package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.util.Util;
import sheenrox82.RioV.src.world.feature.WorldGenBloodTree;
import sheenrox82.RioV.src.world.feature.WorldGenCherryBlossomTree;
import sheenrox82.RioV.src.world.feature.WorldGenGlimmerWoodTree;
import sheenrox82.RioV.src.world.feature.WorldGenSanctuatiteTree;

public class BlockRioVSapling extends BlockFlower
{
	public BlockRioVSapling(int i, int j)
	{
		super(i, Material.leaves);
		float var3 = 0.4F;
		this.setStepSound(soundGrassFootstep);
		this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
		this.setCreativeTab(TheMistsOfRioV.tab);
	}
	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			super.updateTick(par1World, par2, par3, par4, par5Random);
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
			{
				this.func_96477_c(par1World, par2, par3, par4, par5Random);
			}
		}
	}
	public void func_96477_c(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if(blockID == Blocks.glimmerwoodSapling.blockID)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			/** change this block to your custom grass block **/
			if ((l & 8) == Blocks.glimmerGrass.blockID)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
			}
			else
			{
				this.growTree(par1World, par2, par3, par4, par5Random);
			}
		}

		if(blockID == Blocks.cherryBlossomSapling.blockID)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			/** change this block to your custom grass block **/
			if ((l & 8) == Block.grass.blockID)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
			}
			else
			{
				this.growTree(par1World, par2, par3, par4, par5Random);
			}
		}

		if(blockID == Blocks.bloodSapling.blockID)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			/** change this block to your custom grass block **/
			if ((l & 8) == Blocks.bloodGrass.blockID)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
			}
			else
			{
				this.growTree(par1World, par2, par3, par4, par5Random);
			}
		}

		if(blockID == Blocks.skywoodSapling.blockID)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			/** change this block to your custom grass block **/
			if ((l & 8) == Blocks.sanctuatiteGrass.blockID)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
			}
			else
			{
				this.growTree(par1World, par2, par3, par4, par5Random);
			}
		}
	}
	/**
	 * Attempts to grow a sapling into a tree
	 */
	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if(blockID == Blocks.glimmerwoodSapling.blockID)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenGlimmerWoodTree();
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenGlimmerWoodTree();
				}
			}
			else
			{
				object = new WorldGenGlimmerWoodTree(); // Changed //

			}
			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, 0, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
				}
			}
		}

		if(blockID == Blocks.cherryBlossomSapling.blockID)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenCherryBlossomTree(false);
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenCherryBlossomTree(false);
				}
			}
			else
			{
				object = new WorldGenCherryBlossomTree(false); // Changed //

			}
			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, 0, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
				}
			}
		}

		if(blockID == Blocks.bloodSapling.blockID)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenBloodTree(false);
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenBloodTree(false);
				}
			}
			else
			{
				object = new WorldGenBloodTree(false); // Changed //

			}
			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, 0, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
				}
			}
		}

		if(blockID == Blocks.skywoodSapling.blockID)
		{
			if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
			int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
			Object object = null;
			int i1 = 0;
			int j1 = 0;
			boolean flag = false;
			if (l == 3)
			{
				for (i1 = 0; i1 >= -1; --i1)
				{
					for (j1 = 0; j1 >= -1; --j1)
					{
						if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
						{
							/** Change this to your WorldGenNAMETree **/
							object = new WorldGenSanctuatiteTree(false);
							flag = true;
							break;
						}
					}
					if (object != null)
					{
						break;
					}
				}
				if (object == null)
				{
					j1 = 0;
					i1 = 0;

					object = new WorldGenSanctuatiteTree(false);
				}
			}
			else
			{
				object = new WorldGenSanctuatiteTree(false); // Changed //

			}
			if (flag)
			{
				par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
				par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
				par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
			}
			else
			{
				par1World.setBlock(par2, par3, par4, 0, 0, 4);
			}
			if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
			{
				if (flag)
				{
					par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
					par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
				}
				else
				{
					par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
				}
			}
		}
	}
	/**
	 * Determines if the same sapling is present at the given location.
	 */
	public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
	{
		return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
	}
	/**
	 * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
	 * blockID passed in. Args: blockID
	 */
	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		/** Change this to your custom grass **/
		return par1 == Blocks.sanctuatiteGrass.blockID || par1 == Blocks.sanctuatiteDirt.blockID || par1 == Blocks.bloodGrass.blockID || par1 == Blocks.bloodDirt.blockID || par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Blocks.glimmerGrass.blockID || par1 == Blocks.glimmerDirt.blockID || par1 == Block.tilledField.blockID;
	}

	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
	}
	
	public String getName()
	{
		return this.unlocalizedName;
	}
}