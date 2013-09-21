package sheenrox82.RioV.src.world.chunk;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.SCATTERED_FEATURE;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraftforge.event.terraingen.TerrainGen;
import sheenrox82.RioV.src.content.Biomes;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.world.feature.WorldGenClouds;
import sheenrox82.RioV.src.world.feature.WorldGenLakesFlamonor;
import sheenrox82.RioV.src.world.mineable.WorldGenBalance;
import sheenrox82.RioV.src.world.mineable.WorldGenFlamonorMineable;

public class ChunkProviderFlamonor implements IChunkProvider
{
	private Random rand;
	private NoiseGeneratorOctaves noiseGenerator1;
	private NoiseGeneratorOctaves noiseGenerator2;
	private NoiseGeneratorOctaves noiseGenerator3;
	private NoiseGeneratorOctaves noiseGenerator4;
	private NoiseGeneratorOctaves noiseGenerator5;
	public NoiseGeneratorOctaves noiseGenerator6;
	public NoiseGeneratorOctaves noiseGenerator7;
	public NoiseGeneratorOctaves noiseGenerator8;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private final boolean mapFeaturesEnabled;
	private double[] noiseArray;
	private double[] field_28079_r = new double[256];
	private double[] field_28078_s = new double[256];
	private double[] field_28077_t = new double[256];
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
    double[] field_28093_d;
    double[] field_28092_e;
    double[] field_28091_f;
    double[] field_28090_g;
    double[] field_28089_h;
	byte topBlock;
	byte fillerBlock;
	
	
	{
		scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
	}

	public ChunkProviderFlamonor(World var1, long var2, boolean var4)
	{
		this.worldObj = var1;
		this.rand = new Random(var2);
		this.mapFeaturesEnabled = var4;
		this.noiseGenerator1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGenerator2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGenerator3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGenerator4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGenerator5 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGenerator6 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGenerator7 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGenerator8 = new NoiseGeneratorOctaves(this.rand, 8);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
	}

	public void func_28071_a(int var1, int var2, byte[] var3)
	{
		byte var4 = 2;
		int var5 = var4 + 1;
		byte var6 = 33;
		int var7 = var4 + 1;
		this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * var4, 0, var2 * var4, var5, var6, var7);

		for (int var8 = 0; var8 < var4; ++var8)
		{
			for (int var9 = 0; var9 < var4; ++var9)
			{
				for (int var10 = 0; var10 < 32; ++var10)
				{
					double var11 = 0.25D;
					double var13 = this.noiseArray[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 0];
					double var15 = this.noiseArray[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 0];
					double var17 = this.noiseArray[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 0];
					double var19 = this.noiseArray[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 0];
					double var21 = (this.noiseArray[((var8 + 0) * var7 + var9 + 0) * var6 + var10 + 1] - var13) * var11;
					double var23 = (this.noiseArray[((var8 + 0) * var7 + var9 + 1) * var6 + var10 + 1] - var15) * var11;
					double var25 = (this.noiseArray[((var8 + 1) * var7 + var9 + 0) * var6 + var10 + 1] - var17) * var11;
					double var27 = (this.noiseArray[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 1] - var19) * var11;

					for (int var29 = 0; var29 < 4; ++var29)
					{
						double var30 = 0.125D;
						double var32 = var13;
						double var34 = var15;
						double var36 = (var17 - var13) * var30;
						double var38 = (var19 - var15) * var30;

						for (int var40 = 0; var40 < 8; ++var40)
						{
							int var41 = var40 + var8 * 8 << 11 | 0 + var9 * 8 << 7 | var10 * 4 + var29;
							short var42 = 128;
							double var43 = 0.125D;
							double var45 = var32;
							double var47 = (var34 - var32) * var43;

							for (int var49 = 0; var49 < 8; ++var49)
							{
								int var50 = 0;

								if (var45 > 0.0D)
								{
									var50 = Blocks.flamonorRock.blockID;
								}

								var3[var41] = (byte)var50;
								var41 += var42;
								var45 += var47;
							}

							var32 += var36;
							var34 += var38;
						}

						var13 += var21;
						var15 += var23;
						var17 += var25;
						var19 += var27;
					}
				}
			}
		}
	}

	public void func_28072_a(int var1, int var2, byte[] var3)
	{
		double var4 = 0.03125D;
		this.field_28079_r = this.noiseGenerator4.generateNoiseOctaves(this.field_28079_r, var1 * 16, var2 * 16, 0, 16, 16, 1, var4, var4, 1.0D);
		this.field_28078_s = this.noiseGenerator4.generateNoiseOctaves(this.field_28078_s, var1 * 16, 109, var2 * 16, 16, 1, 16, var4, 1.0D, var4);
		this.field_28077_t = this.noiseGenerator5.generateNoiseOctaves(this.field_28077_t, var1 * 16, var2 * 16, 0, 16, 16, 1, var4 * 2.0D, var4 * 2.0D, var4 * 2.0D);

		for (int var6 = 0; var6 < 16; ++var6)
		{
			for (int var7 = 0; var7 < 16; ++var7)
			{
				int var8 = (int)(this.field_28077_t[var6 + var7 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int var9 = -1;
				this.topBlock = (byte)Blocks.bloodGrass.blockID;
				this.fillerBlock = (byte)Blocks.bloodDirt.blockID;
				byte var10 = this.topBlock;
				byte var11 = this.fillerBlock;
				byte var12 = (byte)Blocks.flamonorRock.blockID;

				if (var10 < 0)
				{
					var10 = (byte)(var10 + 0);
				}

				if (var11 < 0)
				{
					var11 = (byte)(var11 + 0);
				}

				if (var12 < 0)
				{
					var12 = (byte)(var12 + 0);
				}

				for (int var13 = 127; var13 >= 0; --var13)
				{
					int var14 = (var7 * 16 + var6) * 128 + var13;
					byte var15 = var3[var14];

					if (var15 == 0)
					{
						var9 = -1;
					}
					else if (var15 == var12)
					{
						if (var9 == -1)
						{
							if (var8 <= 0)
							{
								var10 = 0;
								var11 = var12;
							}

							var9 = var8;

							if (var13 >= 0)
							{
								var3[var14] = var10;
							}
							else
							{
								var3[var14] = var11;
							}
						}
						else if (var9 > 0)
						{
							--var9;
							var3[var14] = var11;
						}
					}
				}
			}
		}
	}


	/**
	 * loads or generates the chunk at the chunk location specified
	 */
	 @Override
	 public Chunk loadChunk(int var1, int var2)
	{
		return this.provideChunk(var1, var2);
	}

	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
	 * specified chunk from the map seed and chunk seed
	 */
	 @Override
	 public Chunk provideChunk(int var1, int var2)
	{
		 this.rand.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
		 byte[] var3 = new byte[32768];
		 this.func_28071_a(var1, var2, var3);
		 this.func_28072_a(var1, var2, var3);
		 Chunk var4 = new Chunk(this.worldObj, var3, var1, var2);
		 var4.generateSkylightMap();
		 if (this.mapFeaturesEnabled)
		 {
			 this.scatteredFeatureGenerator.generate(this, this.worldObj, var1, var2, var3);
		 }
		 return var4;
	}

	private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7)
	{
		if (var1 == null)
		{
			var1 = new double[var5 * var6 * var7];
		}

		double var8 = 684.412D;
		double var10 = 684.412D;
		this.field_28090_g = this.noiseGenerator5.generateNoiseOctaves(this.field_28090_g, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
		this.field_28089_h = this.noiseGenerator6.generateNoiseOctaves(this.field_28089_h, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
		var8 *= 2.0D;
		this.field_28093_d = this.noiseGenerator3.generateNoiseOctaves(this.field_28093_d, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var8 / 160.0D, var8 / 80.0D);
		this.field_28092_e = this.noiseGenerator1.generateNoiseOctaves(this.field_28092_e, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		this.field_28091_f = this.noiseGenerator2.generateNoiseOctaves(this.field_28091_f, var2, var3, var4, var5, var6, var7, var8, var10, var8);
		int var12 = 0;
		int var13 = 0;
		int var14 = 16 / var5;

		for (int var15 = 0; var15 < var5; ++var15)
		{
			int var16 = var15 * var14 + var14 / 2;

			for (int var17 = 0; var17 < var7; ++var17)
			{
				int var18 = var17 * var14 + var14 / 2;
				double var19 = (this.field_28090_g[var13] + 256.0D) / 512.0D;
				double var21 = this.field_28089_h[var13] / 8000.0D;

				if (var21 < 0.0D)
				{
					var21 = -var21 * 0.3D;
				}

				var21 = var21 * 3.0D - 2.0D;

				if (var21 > 1.0D)
				{
					var21 = 1.0D;
				}

				var21 /= 8.0D;
				var21 = 0.0D;

				if (var19 < 0.0D)
				{
					var19 = 0.0D;
				}

				var19 += 0.5D;
				var21 = var21 * var6 / 16.0D;
				++var13;
				double var23 = var6 / 2.0D;

				for (int var25 = 0; var25 < var6; ++var25)
				{
					double var26 = 0.0D;
					double var28 = (var25 - var23) * 8.0D / var19;

					if (var28 < 0.0D)
					{
						var28 *= -1.0D;
					}

					double var30 = this.field_28092_e[var12] / 512.0D;
					double var34 = (this.field_28093_d[var12] / 10.0D + 1.0D) / 2.0D;

					if (var34 < 0.0D)
					{
						var26 = var30;
					}

					var26 -= 8.0D;
					byte var36 = 32;
					double var37;

					if (var25 > var6 - var36)
					{
						var37 = (var25 - (var6 - var36)) / (var36 - 1.0F);
						var26 = var26 * (1.0D - var37) + -30.0D * var37;
					}

					var36 = 8;

					if (var25 < var36)
					{
						var37 = (var36 - var25) / (var36 - 1.0F);
						var26 = var26 * (1.0D - var37) + -30.0D * var37;
					}

					var1[var12] = var26;
					++var12;
				}
			}
		}

		return var1;
	}

	@Override
	public boolean chunkExists(int var1, int var2)
	{
		return true;
	}

	/**
	 * Populates chunk with ores etc etc
	 */
	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
	{
		BlockSand.fallInstantly = true;
		int k = par2 * 16;
		int l = par3 * 16;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * i1 + (long)par3 * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
        int var13;
        int var14;
        int var15;
        int var16;
        int d, y;
        
		if (this.mapFeaturesEnabled)
		{
			this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
		}

		for(int x =0; x < 8; x++)
        {
            var14 = k + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = l + this.rand.nextInt(16);
            (new WorldGenFlamonorMineable(Blocks.drakiuzOre.blockID, 4)).generate(this.worldObj, this.rand, var14, var15, var16);
            (new WorldGenFlamonorMineable(Blocks.steamingBloodDeposit.blockID, 5)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

		for(int var5 = 0; var5 < 2; ++var5)
		{
			int var6 = k + rand.nextInt(16);
			int var7 = rand.nextInt(128);
			int var8 = l + rand.nextInt(16);
			new WorldGenBalance(Blocks.bloodBerryBush.blockID).generate(worldObj, rand, var6, var7, var8);
		}

		if (biomegenbase == Biomes.flamonor)
		{
			int k1 = k + this.rand.nextInt(16) + 8;
			int l1 = this.rand.nextInt(128);
			int i2 = l + this.rand.nextInt(16) + 8;
			(new WorldGenLakesFlamonor(Blocks.steamingBloodStill.blockID)).generate(this.worldObj, this.rand, k1, l1, i2);
		}
		
		if (this.rand.nextInt(25) == 0)
        {
            d = k + this.rand.nextInt(16);
            y = this.rand.nextInt(256);
            int biomeGenBase = l + this.rand.nextInt(16);
            (new WorldGenClouds(false)).generate(this.worldObj, this.rand, d, y, biomeGenBase);
        }
		
		biomegenbase.decorate(this.worldObj, this.rand, k, l);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);

		BlockSand.fallInstantly = false;
	}

	/**
	 * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
	 * Return true if all chunks have been saved.
	 */
	@Override
	public boolean saveChunks(boolean var1, IProgressUpdate var2)
	{
		return true;
	}

	@Override
	public boolean canSave()
	{
		return true;
	}

	@Override
	public String makeString()
	{
		return "FlamonorData";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3, int var4)
	{
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(var2, var4);
		return var5 == null ? null : var5.getSpawnableList(var1);
	}

	@Override
	public ChunkPosition findClosestStructure(World var1, String var2, int var3, int var4, int var5)
	{
		return null;
	}

	@Override
	public int getLoadedChunkCount()
	{
		return 20;
	}

	@Override
	public void recreateStructures(int var1, int var2) {}

	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}

	@Override
	public void saveExtraData() 
	{
		
	}
}
