package sheenrox82.RioV.src.util;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.EntityLoader;
import sheenrox82.RioV.src.content.Items;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Loader;

public class ExpansionChecker 
{
	public static void check()
	{
		try
		{
			Class.forName("sheenrox82.RioVValis.Valis");
			FMLLog.info(Util.MOD_NAME + ": Valis detected, initiating.");
			TheMistsOfRioV.getInstance().riovValis = true;
		}
		catch (Throwable var11)
		{
			FMLLog.info(Util.MOD_NAME + ": Valis wasn't detected, not initializing.");
			TheMistsOfRioV.getInstance().riovValis = false;
		}
		
		try
		{
			Class.forName("optifine.OptiFineClassTransformer");
			FMLLog.info("Optifine detected! Disabling RioV capes for safety measures!");
			TheMistsOfRioV.getInstance().optifine = true;
		}
		catch (Throwable var11)
		{
			FMLLog.info("Optifine not detected! RioV Capes is activating using DeveloperCapes by Jadar.");
			TheMistsOfRioV.getInstance().optifine = false;
		}

		if(Loader.isModLoaded("Natura"))
		{
			FMLLog.info("Natura detected! You get the Natura Expansion for RioV! :)");
			TheMistsOfRioV.getInstance().natura = true;
			if(TheMistsOfRioV.getInstance().natura = true)
			{
				Items.addNatura();
			}
		}
		else
		{
			FMLLog.info("Natura wasn't detected... No Natura Expansion for you. :(");
			TheMistsOfRioV.getInstance().natura = false;
		}

		if(Loader.isModLoaded("Aether II"))
		{
			FMLLog.info("Aether II detected! You get the Aether II Expansion for RioV! :)");
			TheMistsOfRioV.getInstance().aether = true;
			if(TheMistsOfRioV.getInstance().aether = true)
			{
				Items.addAether();
			}
		}
		else
		{
			FMLLog.info("Aether II wasn't detected... No Aether II Expansion for you. :(");
			TheMistsOfRioV.getInstance().aether = false;
		}

		if(Loader.isModLoaded("Thaumcraft 4"))
		{
			FMLLog.info("Thaumcraft detected! You get the Thaumcraft Expansion for RioV! :) (Please note this expansion isn't done, nor have I started it yet...)");
			TheMistsOfRioV.getInstance().thaumcraft = true;
			if(TheMistsOfRioV.getInstance().thaumcraft = true)
			{
				//Items.addThaumcraft();
			}
		}
		else
		{
			FMLLog.info("Thaumcraft wasn't detected... No Thaumcraft Expansion for you. :( (Please note this expansion isn't done, nor have I started it yet...)");
			TheMistsOfRioV.getInstance().thaumcraft = false;
		}
	}
}
