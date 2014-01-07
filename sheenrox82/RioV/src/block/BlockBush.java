package sheenrox82.RioV.src.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.Util;

public class BlockBush extends BlockFlower
{
	public int growth;

	public BlockBush(int par1, Material par2Material)
	{
		super(par1, par2Material);
		setCreativeTab(TheMistsOfRioV.getInstance().tab);
		setHardness(0.3F);
		float f = 0.375F;
		float f1 = f / 2.0F;
		this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f, 0.5F + f1);
		setStepSound(soundGrassFootstep);
	}

	public BlockBush(int par1)
	{
		this(par1, Material.plants);
	}

	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(blockID == Blocks.blueBerryBush.blockID)
		{
			return Items.berry.itemID;
		}

		if(blockID == Blocks.blackBerryBush.blockID)
		{
			return Items.blackBerry.itemID;
		}

		if(blockID == Blocks.raspBerryBush.blockID)
		{
			return Items.raspBerry.itemID;
		}

		if(blockID == Blocks.bloodBerryBush.blockID)
		{
			return Items.bloodBerry.itemID;
		}

		if(blockID == Blocks.strawberryBush.blockID)
		{
			return Items.strawBerry.itemID;
		}
		if(blockID == Blocks.coconut.blockID)
		{
			return blockID;
		}
		
		return -1;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(blockID == Blocks.paleBush.blockID)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "paleLeaf");
		}
		else
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + MethodUtil.getName(this.getUnlocalizedName()));
		}
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return true;
	}

	@Override
	public int getRenderType()
	{
		return 0;
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
	{
		if(blockID == Blocks.bush.blockID)
		{
			world.setBlockToAir(x, y, z);
		}
		if(blockID == Blocks.bloodBerryBush.blockID)
		{
			world.setBlock(x, y, z, Blocks.paleBush.blockID, meta, meta);
		}
		if(blockID == Blocks.blueBerryBush.blockID)
		{
			world.setBlock(x, y, z, Blocks.bush.blockID, meta, meta);
		}
		if(blockID == Blocks.blackBerryBush.blockID)
		{
			world.setBlock(x, y, z, Blocks.bush.blockID, meta, meta);
		}
		if(blockID == Blocks.raspBerryBush.blockID)
		{
			world.setBlock(x, y, z, Blocks.bush.blockID, meta, meta);
		}
		if(blockID == Blocks.strawberryBush.blockID)
		{
			world.setBlock(x, y, z, Blocks.bush.blockID, meta, meta);
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
		return null;
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		if(blockID == Blocks.bloodBerryBush.blockID || blockID == Blocks.paleBush.blockID)
		{
			return par1 == Blocks.bloodDirt.blockID || par1 == Blocks.bloodGrass.blockID;
		}
		if(blockID == Blocks.coconut.blockID)
		{
			return par1 == Block.sand.blockID;
		}
		else
		{
			return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID;
		}
	}
}
