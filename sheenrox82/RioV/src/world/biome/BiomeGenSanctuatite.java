package sheenrox82.RioV.src.world.biome;

import java.util.Random;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.world.feature.WorldGenBloodTree;
import sheenrox82.RioV.src.world.feature.WorldGenSanctuatiteTree;

public class BiomeGenSanctuatite extends BiomeGenBase
{
	public BiomeGenSanctuatite(int par1)
	{
		super(par1);
		this.minHeight = 0.5F;
		this.maxHeight = 0.9F;
		this.topBlock = ((byte)Blocks.sanctuatiteGrass.blockID);
		this.fillerBlock = ((byte)Blocks.sanctuatiteDirt.blockID);
		this.setBiomeName("Sanctuatite");
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.theBiomeDecorator.treesPerChunk = 8;
	}
	
	@Override
    public WorldGenerator getRandomWorldGenForGrass(Random var1)
    {
        return new WorldGenTallGrass(Blocks.sanctuatiteTallGrass.blockID, 16);
    }
	
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(3) == 0 ? new WorldGenSanctuatiteTree(false) : new WorldGenSanctuatiteTree(false));
    }
}