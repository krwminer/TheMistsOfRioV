package sheenrox82.RioV.src.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.content.Particles;
import sheenrox82.RioV.src.util.Util;

public class BlockRioVLeaf extends BlockLeaves implements IShearable
{
	int[] adjacentTreeBlocks;
	private Icon opaqueIcon;

	public BlockRioVLeaf(int par1, Material par2Material)
	{
		super(par1);
		this.setCreativeTab(TheMistsOfRioV.tab);
		this.setHardness(0.1F);
		this.setTickRandomly(true);
	}

	public int getRenderColor(int i)
	{
		return 16777215;
	}

	public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return 16777215;
    }
	
	public boolean isOpaqueCube()
	{
		return false;
	}

	public int quantityDropped(Random par1Random)
	{
		return par1Random.nextInt(20) == 0 ? 1 : 0;
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(blockID == Blocks.cherryLeaf.blockID)
		{
			return Blocks.cherryBlossomSapling.blockID;
		}

		if(blockID == Blocks.glimmerwoodLeaf.blockID)
		{
			return Blocks.glimmerwoodSapling.blockID;
		}

		if(blockID == Blocks.paleLeaf.blockID)
		{
			return Blocks.bloodSapling.blockID;
		}

		return par1;
	}

	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
	{
		if(blockID == Blocks.cherryLeaf.blockID)
		{
			if(!par1World.isRemote)
			{

				int j1 = 20;

				if ((par5 & 3) == 3)
				{
					j1 = 40;
				}

				if (par7 > 0)
				{
					j1 -= 2 << par7;

					if (j1 < 10)
					{
						j1 = 10;
					}
				}

				if (par1World.rand.nextInt(j1) == 0)
				{
					int k1 = this.idDropped(par5, par1World.rand, par7);
					this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(k1, 1, this.damageDropped(par5)));
				}

				j1 = 200;

				if (par7 > 0)
				{
					j1 -= 10 << par7;

					if (j1 < 40)
					{
						j1 = 40;
					}
				}

				if ((par5 & 3) == 0 && par1World.rand.nextInt(j1) == 0)
				{
					this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Items.cherry, 8, 0));
				}
			}
		}

		if(blockID == Blocks.glimmerwoodLeaf.blockID)
		{
			if(!par1World.isRemote)
			{

				int j1 = 20;

				if ((par5 & 3) == 3)
				{
					j1 = 40;
				}

				if (par7 > 0)
				{
					j1 -= 2 << par7;

					if (j1 < 10)
					{
						j1 = 10;
					}
				}

				if (par1World.rand.nextInt(j1) == 0)
				{
					int k1 = this.idDropped(par5, par1World.rand, par7);
					this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(k1, 1, this.damageDropped(par5)));
				}

				j1 = 200;

				if (par7 > 0)
				{
					j1 -= 10 << par7;

					if (j1 < 40)
					{
						j1 = 40;
					}
				}

				if ((par5 & 3) == 0 && par1World.rand.nextInt(j1) == 0)
				{
					this.dropBlockAsItem_do(par1World, par2, par3, par4, new ItemStack(Items.blueMagicApple, 1, 0));
				}
			}
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		byte b0 = 1;
		int j1 = b0 + 1;

		if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1))
		{
			for (int k1 = -b0; k1 <= b0; ++k1)
			{
				for (int l1 = -b0; l1 <= b0; ++l1)
				{
					for (int i2 = -b0; i2 <= b0; ++i2)
					{
						int j2 = par1World.getBlockId(par2 + k1, par3 + l1, par4 + i2);

						if (Block.blocksList[j2] != null)
						{
							this.beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}

	}

	private void removeLeaves(World par1World, int par2, int par3, int par4)
	{
		this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
		par1World.setBlockToAir(par2, par3, par4);
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z)
	{
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	@Override
	public boolean isLeaves(World world, int x, int y, int z)
	{
		return true;
	}

	@Override
	public boolean isShearable(ItemStack item, World world, int x, int y, int z) 
	{
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune) 
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

	public void registerIcons(IconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
		this.opaqueIcon = iconRegister.registerIcon(Util.MOD_ID + ":" + this.getName() + "_fast");
	}
	
	public String getName()
	{
		return this.unlocalizedName;
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

		if(blockID == Blocks.glimmerwoodLeaf.blockID)
		{
			for (int var6 = par2 - 2; var6 <= par2 + 2; ++var6)
			{
				for (int var7 = par4 - 2; var7 <= par4 + 2; ++var7)
				{
					if (var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1)
					{
						var7 = par4 + 2;
					}

					if (par5Random.nextInt(16) == 0)
					{
						for (int var8 = par3; var8 <= par3 + 1; ++var8)
						{

							if (!par1World.isAirBlock((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4))
							{
								break;
							}

							Particles.spawnParticle("glimmer", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);

							if (!par1World.isAirBlock((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4))
							{
								break;
							}

							Particles.spawnParticle("glimmer", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);
						}
					}
				}
			}
		}
	}

	public Icon getIcon(int par1, int par2)
	{
		this.setGraphicsLevel(Minecraft.getMinecraft().gameSettings.fancyGraphics);
		return this.graphicsLevel ? this.blockIcon : this.opaqueIcon;
	}

	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
	}
}