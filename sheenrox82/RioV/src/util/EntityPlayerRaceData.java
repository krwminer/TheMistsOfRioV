package sheenrox82.RioV.src.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EntityPlayerRaceData implements IExtendedEntityProperties
{
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	private final EntityPlayer player;
	public static boolean isRaceDwarf;
	public static boolean isRaceElf;
	public static boolean isRaceHuman;

	public EntityPlayerRaceData(EntityPlayer player)
	{
		this.player = player;
	}

	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(EntityPlayerRaceData.EXT_PROP_NAME, new EntityPlayerRaceData(player));
	}

	public static final EntityPlayerRaceData get(EntityPlayer player)
	{
		return (EntityPlayerRaceData) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();

		properties.setBoolean("DwarvenRace", this.isRaceDwarf);
		properties.setBoolean("ElvenRace", this.isRaceElf);
		properties.setBoolean("HumanRace", this.isRaceHuman);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.isRaceDwarf = properties.getBoolean("DwarvenRace");
		this.isRaceElf = properties.getBoolean("ElvenRace");
		this.isRaceHuman = properties.getBoolean("HumanRace");
	}

	@Override
	public void init(Entity entity, World world)
	{

	}
	
	public boolean setRaceHuman()
	{
		return this.isRaceHuman = true;
	}
	
	public boolean setRaceElven()
	{
		return this.isRaceElf = true;
	}
	
	public boolean setRaceDwarven()
	{
		return this.isRaceDwarf = true;
	}
}
