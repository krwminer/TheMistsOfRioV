package sheenrox82.RioV.src.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import cpw.mods.fml.client.FMLClientHandler;

public class CommonProxy
{
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
}