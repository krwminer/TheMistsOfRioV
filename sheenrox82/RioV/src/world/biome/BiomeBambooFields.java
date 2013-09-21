package sheenrox82.RioV.src.world.biome;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import sheenrox82.RioV.src.content.Blocks;

public class BiomeBambooFields extends BiomeGenBase
{
	public BiomeBambooFields(int par1)
	{
		super(par1);
		this.minHeight = 0.2F;
		this.maxHeight = 0.2F;
		this.topBlock = ((byte)Block.grass.blockID);
		this.fillerBlock = ((byte)Block.dirt.blockID);
		this.setBiomeName("Bamboo Fields");
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.theBiomeDecorator.grassPerChunk = 16;
	}
	
	@Override
    public WorldGenerator getRandomWorldGenForGrass(Random var1)
    {
        return new WorldGenTallGrass(Blocks.bamboo.blockID, 16);
    }
}