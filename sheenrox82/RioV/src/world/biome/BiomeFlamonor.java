package sheenrox82.RioV.src.world.biome;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.world.feature.WorldGenBloodTree;
import sheenrox82.RioV.src.world.feature.WorldGenGlimmerWoodTree;
import sheenrox82.RioV.src.world.feature.WorldGenGlimmerWoodTree2;

public class BiomeFlamonor extends BiomeGenBase
{

	public BiomeFlamonor(int par1)
	{
		super(par1);
		this.minHeight = 0.5F;
		this.maxHeight = 0.9F;
		this.topBlock = ((byte)Blocks.bloodGrass.blockID);
		this.fillerBlock = ((byte)Blocks.bloodDirt.blockID);
		this.setBiomeName("Flamonor");
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = 5;
	}
	
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(3) == 0 ? new WorldGenBloodTree(false) : new WorldGenBloodTree(false));
    }
}