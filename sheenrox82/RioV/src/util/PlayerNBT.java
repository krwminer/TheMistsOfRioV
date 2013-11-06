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
	public static final int EOS_WATCHER = 20;
	public static int maxEos = 50;

	public PlayerNBT(EntityPlayer player)
	{
		this.player = player;
		this.player.getDataWatcher().addObject(EOS_WATCHER, this.maxEos);
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
		properties.setInteger("CurrentEos", this.player.getDataWatcher().getWatchableObjectInt(EOS_WATCHER));
		properties.setInteger("MaxEos", this.maxEos);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.player.getDataWatcher().updateObject(EOS_WATCHER, properties.getInteger("CurrentEos"));
		this.maxEos = properties.getInteger("MaxEos");
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
			outputStream.writeInt(this.maxEos);
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

	public final boolean consumeEos(int amount)
	{
		int mana = this.player.getDataWatcher().getWatchableObjectInt(EOS_WATCHER);
		boolean sufficient = amount <= mana;
		mana -= (amount < mana ? amount : mana);
		this.player.getDataWatcher().updateObject(EOS_WATCHER, mana);
		return sufficient;
	}


	public final void replenishEos()
	{
		this.player.getDataWatcher().updateObject(EOS_WATCHER, this.maxEos);
	}

	public final int getCurrentEos()
	{
		return this.player.getDataWatcher().getWatchableObjectInt(EOS_WATCHER);
	}

	public final void setCurrentEos(int amount)
	{
		this.player.getDataWatcher().updateObject(EOS_WATCHER, (amount < this.maxEos ? amount : this.maxEos));
	}

	public void setMaxEos(int amount)
	{
		this.maxEos = 50;
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