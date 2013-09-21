package sheenrox82.RioV.src.content;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.world.biome.BiomeBambooFields;
import sheenrox82.RioV.src.world.biome.BiomeBlindOasis;
import sheenrox82.RioV.src.world.biome.BiomeCanopyOasis;
import sheenrox82.RioV.src.world.biome.BiomeFlamonor;
import sheenrox82.RioV.src.world.biome.BiomeGlimmerwood;
import sheenrox82.RioV.src.world.biome.BiomeSanctuatite;
import sheenrox82.RioV.src.world.biome.BiomeSavannah;
import sheenrox82.RioV.src.world.biome.BiomeSnowyMountains;
import cpw.mods.fml.common.registry.GameRegistry;

public class Biomes 
{
	public static BiomeGenBase blindOasis = new BiomeBlindOasis(Config.blindOasisBiomeID);
	public static BiomeGenBase glimmerwood = new BiomeGlimmerwood(Config.glimmerwoodBiomeID);
	public static BiomeGenBase snowyMountains = new BiomeSnowyMountains(Config.snowyMountainsBiomeID).setBiomeName("Snowy Mountains").setMinMaxHeight(0.3F, 1.8F);
	public static BiomeGenBase savannah = new BiomeSavannah(Config.savannahBiomeID).setColor(16421912).setBiomeName("Savannah").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
	public static BiomeGenBase flamonor = new BiomeFlamonor(Config.flamonorBiomeID);
	public static BiomeGenBase sanctuatite = new BiomeSanctuatite(Config.sanctuatiteBiomeID);
	public static BiomeGenBase canopyOasis = new BiomeCanopyOasis(Config.canopyOasisBiomeID).setColor(5470985);
	public static BiomeGenBase bambooFields = new BiomeBambooFields(Config.bambooFieldsBiomeID);

	public static void add()
	{
		GameRegistry.addBiome(snowyMountains);
		GameRegistry.addBiome(savannah);
		GameRegistry.addBiome(canopyOasis);
		GameRegistry.addBiome(bambooFields);
		BiomeDictionary.registerBiomeType(Biomes.snowyMountains, Type.FROZEN, Type.MOUNTAIN);
		BiomeDictionary.registerBiomeType(Biomes.savannah, Type.DESERT, Type.PLAINS);
		BiomeDictionary.registerBiomeType(Biomes.canopyOasis, Type.FOREST, Type.MOUNTAIN);
		BiomeDictionary.registerBiomeType(Biomes.bambooFields, Type.PLAINS);
	}
}
