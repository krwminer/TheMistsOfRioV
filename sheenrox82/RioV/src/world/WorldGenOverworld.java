package sheenrox82.RioV.src.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.world.feature.WorldGenCherryBlossomTree;
import sheenrox82.RioV.src.world.mineable.WorldGenBalance;
import sheenrox82.RioV.src.world.mineable.WorldGenEndMineable;
import sheenrox82.RioV.src.world.mineable.WorldGenNetherMineable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenOverworld implements IWorldGenerator 
{

	public int i;
	public int Xcoord;
	public int Ycoord;
	public int Zcoord;
	
	public WorldGenOverworld() 
	{

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch (world.provider.dimensionId)
		{
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateEnd(World world, Random rand, int blockX, int blockZ) 
	{
		for (int i = 0; i < 8; i++) 
		{
			int Xcoord = blockX + rand.nextInt(16);
			int YcoordEnd = rand.nextInt(56);
			int Zcoord = blockZ + rand.nextInt(16);
			(new WorldGenEndMineable(Blocks.dragonOre.blockID, 5)).generate(world, rand, Xcoord, YcoordEnd, Zcoord);
		}
	}

	private void generateSurface(World world, Random rand, int blockX, int blockZ) 
	{
		int d, y;
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(blockX, blockZ);
		WorldGenCherryBlossomTree tree = new WorldGenCherryBlossomTree(false);

		for (int i = 0; i < 8; i++) 
		{
			int Xcoord = blockX + rand.nextInt(16);
			int YcoordSurface1 = rand.nextInt(56);
			int YcoordSurface2 = rand.nextInt(36);
			int YcoordSurface3 = rand.nextInt(20);
			int YcoordSurface4 = rand.nextInt(10);
			int Zcoord = blockZ + rand.nextInt(16);
			(new WorldGenMinable(Blocks.onyxOre.blockID, 4)).generate(world, rand, Xcoord, YcoordSurface1, Zcoord);
			(new WorldGenMinable(Blocks.garnetOre.blockID, 3)).generate(world, rand, Xcoord, YcoordSurface2, Zcoord);
			(new WorldGenMinable(Blocks.nironiteOre.blockID, 3)).generate(world, rand, Xcoord, YcoordSurface3, Zcoord);
			(new WorldGenMinable(Blocks.sapphireOre.blockID, 4)).generate(world, rand, Xcoord, YcoordSurface2, Zcoord);
			(new WorldGenMinable(Blocks.topazOre.blockID, 4)).generate(world, rand, Xcoord, YcoordSurface2, Zcoord);
			(new WorldGenMinable(Blocks.amethystOre.blockID, 4)).generate(world, rand, Xcoord, YcoordSurface1, Zcoord);
			(new WorldGenMinable(Blocks.slate.blockID, 8)).generate(world, rand, Xcoord, YcoordSurface3, Zcoord);
		}

		for(int var5 = 0; var5 < 1; ++var5)
		{
			int var6 = blockX + rand.nextInt(16);
			int var7 = rand.nextInt(128);
			int var8 = blockZ + rand.nextInt(16);

			new WorldGenBalance(Blocks.blackDuriiPlant.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.tomatoPlant.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.grapePlant.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.pepperPlant.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.blueFlower.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.blueBerryBush.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.blackBerryBush.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.raspBerryBush.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.strawberryBush.blockID).generate(world, rand, var6, var7, var8);
			new WorldGenBalance(Blocks.shortGrass.blockID).generate(world, rand, var6, var7, var8);
		}

		if((biome instanceof BiomeGenForest)) 
		{
			for(int x = 0; x < 3; x++)
			{
				int i = blockX + rand.nextInt(16);
				int k = blockZ + rand.nextInt(16);
				int j = world.getHeightValue(i, k);
				tree.generate(world, rand, i, j, k);
			}
		}

		if((biome instanceof BiomeGenPlains)) 
		{
			for(int x = 0; x < 3; x++)
			{
				int i = blockX + rand.nextInt(16);
				int k = blockZ + rand.nextInt(16);
				int j = world.getHeightValue(i, k);
				tree.generate(world, rand, i, j, k);
			}
		}
	}

	private void generateNether(World world, Random rand, int blockX, int blockZ) 
	{
		for (int i = 0; i < 8; i++) 
		{
			int Xcoord = blockX + rand.nextInt(16);
			int YcoordNether1 = rand.nextInt(128);
			int YcoordNether2 = rand.nextInt(100);
			int Zcoord = blockZ + rand.nextInt(16);
			(new WorldGenNetherMineable(Blocks.netherCrystal.blockID, 9)).generate(world, rand, Xcoord, YcoordNether1, Zcoord);
			(new WorldGenNetherMineable(Blocks.bloodRock.blockID, 20)).generate(world, rand, Xcoord, YcoordNether2, Zcoord);
		}	
	}
}
