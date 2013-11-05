package sheenrox82.RioV.src.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import sheenrox82.RioV.src.proxy.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PlayerNBT implements IExtendedEntityProperties
{
	public final static String EXT_PROP_NAME = "PlayerNBT";
	private final EntityPlayer player;
	public static final int MAGICKA_WATCHER = 20;
	public static int maxMana = 50;

	public PlayerNBT(EntityPlayer player)
	{
		this.player = player;
		this.player.getDataWatcher().addObject(MAGICKA_WATCHER, this.maxMana);
	}

	public static void register(EntityPlayer player)
	{
		player.registerExtendedProperties(PlayerNBT.EXT_PROP_NAME, new PlayerNBT(player));
	}

	public static PlayerNBT get(EntityPlayer player)
	{
		return (PlayerNBT)player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
		properties.setInteger("CurrentMana", this.player.getDataWatcher().getWatchableObjectInt(MAGICKA_WATCHER));
		properties.setInteger("MaxMana", this.maxMana);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.player.getDataWatcher().updateObject(MAGICKA_WATCHER, properties.getInteger("CurrentMana"));
		this.maxMana = properties.getInteger("MaxMana");
	}

	@Override
	public void init(Entity entity, World world)
	{
	}

	public final void sync()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);

		try 
		{
			outputStream.writeInt(this.maxMana);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}

		Packet250CustomPayload packet = new Packet250CustomPayload("riovchannel", bos.toByteArray());

		if (FMLCommonHandler.instance().getEffectiveSide().isServer()) 
		{
			EntityPlayerMP player1 = (EntityPlayerMP) player;
			PacketDispatcher.sendPacketToPlayer(packet, (Player) player1);
		}
	}

	public final boolean consumeMagicka(int amount)
	{
		int mana = this.player.getDataWatcher().getWatchableObjectInt(MAGICKA_WATCHER);
		boolean sufficient = amount <= mana;
		mana -= (amount < mana ? amount : mana);
		this.player.getDataWatcher().updateObject(MAGICKA_WATCHER, mana);
		return sufficient;
	}


	public final void replenishMagicka()
	{
		this.player.getDataWatcher().updateObject(MAGICKA_WATCHER, this.maxMana);
	}

	public final int getCurrentMagicka()
	{
		return this.player.getDataWatcher().getWatchableObjectInt(MAGICKA_WATCHER);
	}

	public final void setCurrentMagicka(int amount)
	{
		this.player.getDataWatcher().updateObject(MAGICKA_WATCHER, (amount < this.maxMana ? amount : this.maxMana));
	}

	public void setMaxMagicka(int amount)
	{
		this.maxMana = 50;
		this.sync();
	}

	private static String getSaveKey(EntityPlayer player) 
	{
		return player.username + ":" + EXT_PROP_NAME;
	}

	public static void saveProxyData(EntityPlayer player) 
	{
		PlayerNBT playerData = PlayerNBT.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);

		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}

	public static void loadProxyData(EntityPlayer player) 
	{
		PlayerNBT playerData = PlayerNBT.get(player);
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));

		if(savedData != null) 
		{
			playerData.loadNBTData(savedData);
		}

		playerData.sync();
	}
}