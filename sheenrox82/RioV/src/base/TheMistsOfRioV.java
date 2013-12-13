package sheenrox82.RioV.src.base;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import sheenrox82.RioV.src.creativetab.CreativeTabRioV;
import sheenrox82.RioV.src.gui.GuiMagickaBar;
import sheenrox82.RioV.src.handler.GuiHandler;
import sheenrox82.RioV.src.handler.EosHandler;
import sheenrox82.RioV.src.proxy.CommonProxy;
import sheenrox82.RioV.src.util.Registry;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid= Util.MOD_ID ,name= Util.MOD_NAME, version= Util.VERSION) 
@NetworkMod(clientSideRequired=true, serverSideRequired=true, channels = {"riovchannel"}, packetHandler = EosHandler.class)
public class TheMistsOfRioV
{
	@Instance(Util.MOD_ID)
	private static TheMistsOfRioV instance;

	@SidedProxy(clientSide="sheenrox82.RioV.src.proxy.ClientProxy", serverSide="sheenrox82.RioV.src.proxy.CommonProxy")
	public static CommonProxy commonProxy;
	public CreativeTabs tab = new CreativeTabRioV(Util.MOD_ID);
	public GuiHandler guiHandler = new GuiHandler();
	public boolean riovValis;
	public boolean natura;
	public boolean aether;
	public boolean thaumcraft;

	public static TheMistsOfRioV getInstance()
	{
		return instance;
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent initEvent)
	{
		Registry.preInit(initEvent);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent initEvent)
	{
		Registry.init(initEvent);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.info("[" + Util.MOD_NAME + "] Loading...");
		if (FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			MinecraftForge.EVENT_BUS.register(new GuiMagickaBar(Minecraft.getMinecraft()));
		}
		BiomeDictionary.registerAllBiomes();
		Config.initPost();
		FMLLog.info("[" + Util.MOD_NAME + "] Loaded! Have fun!");
	}
}
