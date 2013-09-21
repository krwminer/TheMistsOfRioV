package sheenrox82.RioV.src.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import sheenrox82.RioV.src.world.feature.WorldGenBloodTree;
import sheenrox82.RioV.src.world.feature.WorldGenGiantTree;

public class BiomeCanopyOasis extends BiomeGenBase
{
	public BiomeCanopyOasis(int par1)
	{
		super(par1);
		this.minHeight = 0.1F;
		this.maxHeight = 1.5F;
		this.topBlock = ((byte)Block.grass.blockID);
		this.fillerBlock = ((byte)Block.dirt.blockID);
		this.setBiomeName("Canopy Oasis");
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = 10;
		this.theBiomeDecorator.grassPerChunk = 40;
	}
	
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(3) == 0 ? new WorldGenGiantTree(false, 100, 0, 0) : new WorldGenGiantTree(false, 100, 0, 0));
    }
}