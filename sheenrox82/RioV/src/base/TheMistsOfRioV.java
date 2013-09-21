package sheenrox82.RioV.src.base;

import java.util.Arrays;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import sheenrox82.RioV.src.content.Biomes;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Enchantments;
import sheenrox82.RioV.src.content.EntityLoader;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.creativetab.Tab;
import sheenrox82.RioV.src.event.BonemealEvent;
import sheenrox82.RioV.src.event.EntityDropEvent;
import sheenrox82.RioV.src.handler.ConnectionHandler;
import sheenrox82.RioV.src.handler.GuiHandler;
import sheenrox82.RioV.src.handler.HudHandler;
import sheenrox82.RioV.src.handler.SoundHandler;
import sheenrox82.RioV.src.proxy.CommonProxy;
import sheenrox82.RioV.src.util.Registry;
import sheenrox82.RioV.src.util.Util;
import sheenrox82.RioV.src.world.WorldGenOverworld;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid= Util.MOD_ID ,name= Util.MOD_NAME, version= Util.VERSION) 
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class TheMistsOfRioV
{
	@Instance(Util.MOD_ID)
	private static TheMistsOfRioV instance;

	@SidedProxy(clientSide="sheenrox82.RioV.src.proxy.ClientProxy", serverSide="sheenrox82.RioV.src.proxy.CommonProxy")
	public static CommonProxy commonProxy;
	public static CreativeTabs tab = new Tab(Util.MOD_ID);
	public static GuiHandler guiHandler = new GuiHandler();
	public static boolean riovPaladin;
	public static boolean riovValis;
	public static boolean riovTrees;
	public static boolean natura;
	public static boolean aether;
	
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
		BiomeDictionary.registerAllBiomes();
		Config.initPost();
		FMLLog.info("[" + Util.MOD_NAME + "] Loaded! Have fun!");
	}
}
