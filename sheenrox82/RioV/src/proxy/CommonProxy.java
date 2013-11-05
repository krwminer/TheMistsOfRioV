package sheenrox82.RioV.src.proxy;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.client.FMLClientHandler;

public class CommonProxy
{
	private static final Map<String, NBTTagCompound> entityplayerMagickaData = new HashMap<String, NBTTagCompound>();
	
	public static int addArmor(String armorName)
	{
		return 0;
	}

	public void init() 
	{	

	}

	public void cape()
	{

	}

	public void registerItemRenderers()
	{

	}

	public Minecraft getClient()
	{
		return FMLClientHandler.instance().getClient();
	}

	public ModelBiped getArmorModel(int id)
	{
		return null;
	}

	public static void storeEntityData(String name, NBTTagCompound compound)
	{
		entityplayerMagickaData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name)
	{
		return entityplayerMagickaData.remove(name);
	}
}