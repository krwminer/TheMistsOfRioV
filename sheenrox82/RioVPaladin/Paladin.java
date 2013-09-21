package sheenrox82.RioVPaladin;

import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid="sheenrox82.RioVPaladin") 
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class Paladin
{
	@SidedProxy(clientSide="sheenrox82.RioVPaladin.ClientProxy", serverSide="sheenrox82.RioVPaladin.CommonProxy")
	public static CommonProxy commonProxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent initEvent)
	{
		commonProxy.init();
		ModMetadata data = initEvent.getModMetadata();
		data.parent = "RioV";
	}

}
