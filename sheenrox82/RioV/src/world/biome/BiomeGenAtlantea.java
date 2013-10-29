package sheenrox82.RioV.src.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.world.feature.WorldGenPalmTree;

public class BiomeGenAtlantea extends BiomeGenBase
{
	public BiomeGenAtlantea(int par1)
	{
		super(par1);
		this.minHeight = -1.0F;
		this.maxHeight = 0.9F;
		this.topBlock = ((byte)Block.waterStill.blockID);
		this.fillerBlock = ((byte)Block.waterStill.blockID);
		this.setBiomeName("Atlantea");
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = 130;
	}
	
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return (WorldGenerator)(par1Random.nextInt(3) == 0 ? new WorldGenPalmTree() : new WorldGenPalmTree());
	}
}