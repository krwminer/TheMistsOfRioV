package sheenrox82.RioV.src.content;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.world.biome.BiomeGenBambooFields;
import sheenrox82.RioV.src.world.biome.BiomeGenBlindOasis;
import sheenrox82.RioV.src.world.biome.BiomeGenCanopyOasis;
import sheenrox82.RioV.src.world.biome.BiomeGenFlamonor;
import sheenrox82.RioV.src.world.biome.BiomeGenGlimmerwood;
import sheenrox82.RioV.src.world.biome.BiomeGenRunes;
import sheenrox82.RioV.src.world.biome.BiomeGenSanctuatite;
import sheenrox82.RioV.src.world.biome.BiomeGenSavannah;
import sheenrox82.RioV.src.world.biome.BiomeGenSnowyMountains;
import cpw.mods.fml.common.registry.GameRegistry;

public class Biomes 
{
	public static BiomeGenBase blindOasis = new BiomeGenBlindOasis(Config.blindOasisBiomeID);
	public static BiomeGenBase glimmerwood = new BiomeGenGlimmerwood(Config.glimmerwoodBiomeID);
	public static BiomeGenBase snowyMountains = new BiomeGenSnowyMountains(Config.snowyMountainsBiomeID).setBiomeName("Snowy Mountains").setMinMaxHeight(0.3F, 1.8F);
	public static BiomeGenBase savannah = new BiomeGenSavannah(Config.savannahBiomeID).setColor(16421912).setBiomeName("Savannah").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
	public static BiomeGenBase flamonor = new BiomeGenFlamonor(Config.flamonorBiomeID);
	public static BiomeGenBase sanctuatite = new BiomeGenSanctuatite(Config.sanctuatiteBiomeID);
	public static BiomeGenBase canopyOasis = new BiomeGenCanopyOasis(Config.canopyOasisBiomeID).setColor(5470985);
	public static BiomeGenBase bambooFields = new BiomeGenBambooFields(Config.bambooFieldsBiomeID);
	public static BiomeGenBase runes = new BiomeGenRunes(Config.runesBiomeID);

	public static void add()
	{
		GameRegistry.addBiome(snowyMountains);
		GameRegistry.addBiome(savannah);
		GameRegistry.addBiome(canopyOasis);
		GameRegistry.addBiome(bambooFields);
		GameRegistry.addBiome(runes);
		BiomeDictionary.registerBiomeType(Biomes.snowyMountains, Type.FROZEN, Type.MOUNTAIN);
		BiomeDictionary.registerBiomeType(Biomes.savannah, Type.DESERT, Type.PLAINS);
		BiomeDictionary.registerBiomeType(Biomes.canopyOasis, Type.FOREST, Type.MOUNTAIN);
		BiomeDictionary.registerBiomeType(Biomes.bambooFields, Type.PLAINS);
		BiomeDictionary.registerBiomeType(Biomes.runes, Type.WASTELAND);
	}
}
