package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRioVDoor extends Block
{
	private static final String[] glimmerwoodDoor = new String[] {Util.MOD_ID + ":" + "glimmerwoodDoor_lower", Util.MOD_ID + ":" + "glimmerwoodDoor_upper"};
	private static final String[] cherryBlossomDoor = new String[] {Util.MOD_ID + ":" + "cherryBlossomDoor_lower", Util.MOD_ID + ":" + "cherryBlossomDoor_upper"};
	private static final String[] skywoodDoor = new String[] {Util.MOD_ID + ":" + "skywoodDoor_lower", Util.MOD_ID + ":" + "skywoodDoor_upper"};
	private static final String[] bloodDoor = new String[] {Util.MOD_ID + ":" + "bloodDoor_lower", Util.MOD_ID + ":" + "bloodDoor_upper"};

	private final int glimmerwoodDoorIcon;
	private final int cherryBlossomDoorIcon;
	private final int skywoodDoorIcon;
	private final int bloodDoorIcon;

	@SideOnly(Side.CLIENT)
	private Icon[] iconArray;

	public BlockRioVDoor(int par1, Material par2Material)
	{
		super(par1, par2Material);
		this.glimmerwoodDoorIcon = 0;
		this.cherryBlossomDoorIcon = 0;
		this.skywoodDoorIcon = 0;
		this.bloodDoorIcon = 0;
		float f = 0.5F;
		float f1 = 1.0F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getIcon(int par1, int par2)
	{
		if(blockID == Blocks.glimmerwoodDoor.blockID)
		{
			return this.iconArray[this.glimmerwoodDoorIcon];
		}
		if(blockID == Blocks.cherryBlossomDoor.blockID)
		{
			return this.iconArray[this.cherryBlossomDoorIcon];
		}
		if(blockID == Blocks.skywoodDoor.blockID)
		{
			return this.iconArray[this.skywoodDoorIcon];
		}
		if(blockID == Blocks.bloodDoor.blockID)
		{
			return this.iconArray[this.bloodDoorIcon];
		}
		return null;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if (par5 != 1 && par5 != 0)
		{
			int i1 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
			int j1 = i1 & 3;
			boolean flag = (i1 & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (i1 & 8) != 0;

			if (flag)
			{
				if (j1 == 0 && par5 == 2)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && par5 == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && par5 == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && par5 == 4)
				{
					flag1 = !flag1;
				}
			}
			else
			{
				if (j1 == 0 && par5 == 5)
				{
					flag1 = !flag1;
				}
				else if (j1 == 1 && par5 == 3)
				{
					flag1 = !flag1;
				}
				else if (j1 == 2 && par5 == 4)
				{
					flag1 = !flag1;
				}
				else if (j1 == 3 && par5 == 2)
				{
					flag1 = !flag1;
				}

				if ((i1 & 16) != 0)
				{
					flag1 = !flag1;
				}
			}

			if(blockID == Blocks.glimmerwoodDoor.blockID)
			{
				return this.iconArray[this.glimmerwoodDoorIcon + (flag1 ? glimmerwoodDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			if(blockID == Blocks.cherryBlossomDoor.blockID)
			{
				return this.iconArray[this.cherryBlossomDoorIcon + (flag1 ? cherryBlossomDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			if(blockID == Blocks.skywoodDoor.blockID)
			{
				return this.iconArray[this.skywoodDoorIcon + (flag1 ? skywoodDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			if(blockID == Blocks.bloodDoor.blockID)
			{
				return this.iconArray[this.bloodDoorIcon + (flag1 ? bloodDoor.length : 0) + (flag2 ? 1 : 0)];
			}

			return null;
		}
		else
		{
			return this.iconArray[this.glimmerwoodDoorIcon];
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(blockID == Blocks.cherryBlossomDoor.blockID)
		{
			this.iconArray = new Icon[cherryBlossomDoor.length * 2];

			for (int i = 0; i < cherryBlossomDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(cherryBlossomDoor[i]);
				this.iconArray[i + cherryBlossomDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}

		if(blockID == Blocks.glimmerwoodDoor.blockID)
		{
			this.iconArray = new Icon[glimmerwoodDoor.length * 2];

			for (int i = 0; i < glimmerwoodDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(glimmerwoodDoor[i]);
				this.iconArray[i + glimmerwoodDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}

		if(blockID == Blocks.skywoodDoor.blockID)
		{
			this.iconArray = new Icon[skywoodDoor.length * 2];

			for (int i = 0; i < skywoodDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(skywoodDoor[i]);
				this.iconArray[i + skywoodDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}

		if(blockID == Blocks.bloodDoor.blockID)
		{
			this.iconArray = new Icon[bloodDoor.length * 2];

			for (int i = 0; i < bloodDoor.length; ++i)
			{
				this.iconArray[i] = par1IconRegister.registerIcon(bloodDoor[i]);
				this.iconArray[i + bloodDoor.length] = new IconFlipped(this.iconArray[i], true, false);
			}
		}
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int l = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
		return (l & 4) != 0;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 7;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (this.blockMaterial == Material.iron)
		{
			return false;
		}
		else
		{
			int i1 = this.getFullMetadata(par1World, par2, par3, par4);
			int j1 = i1 & 7;
			j1 ^= 4;

			if ((i1 & 8) == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, j1, 2);
				par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
			}
			else
			{
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, j1, 2);
				par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			}

			par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
			return true;
		}
	}

	public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5)
	{
		int l = this.getFullMetadata(par1World, par2, par3, par4);
		boolean flag1 = (l & 4) != 0;

		if (flag1 != par5)
		{
			int i1 = l & 7;
			i1 ^= 4;

			if ((l & 8) == 0)
			{
				par1World.setBlockMetadataWithNotify(par2, par3, par4, i1, 2);
				par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
			}
			else
			{
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, i1, 2);
				par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			}

			par1World.playAuxSFXAtEntity((EntityPlayer)null, 1003, par2, par3, par4, 0);
		}
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		int i1 = par1World.getBlockMetadata(par2, par3, par4);

		if ((i1 & 8) == 0)
		{
			boolean flag = false;

			if (par1World.getBlockId(par2, par3 + 1, par4) != this.blockID)
			{
				par1World.setBlockToAir(par2, par3, par4);
				flag = true;
			}

			if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4))
			{
				par1World.setBlockToAir(par2, par3, par4);
				flag = true;

				if (par1World.getBlockId(par2, par3 + 1, par4) == this.blockID)
				{
					par1World.setBlockToAir(par2, par3 + 1, par4);
				}
			}

			if (flag)
			{
				if (!par1World.isRemote)
				{
					this.dropBlockAsItem(par1World, par2, par3, par4, i1, 0);
				}
			}
			else
			{
				boolean flag1 = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 + 1, par4);

				if ((flag1 || par5 > 0 && Block.blocksList[par5].canProvidePower()) && par5 != this.blockID)
				{
					this.onPoweredBlockChange(par1World, par2, par3, par4, flag1);
				}
			}
		}
		else
		{
			if (par1World.getBlockId(par2, par3 - 1, par4) != this.blockID)
			{
				par1World.setBlockToAir(par2, par3, par4);
			}

			if (par5 > 0 && par5 != this.blockID)
			{
				this.onNeighborBlockChange(par1World, par2, par3 - 1, par4, par5);
			}
		}
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(blockID == Blocks.glimmerwoodDoor.blockID)
		{
			return (par1 & 8) != 0 ? 0 : Items.glimmerwoodDoorItem.itemID;
		}

		if(blockID == Blocks.cherryBlossomDoor.blockID)
		{
			return (par1 & 8) != 0 ? 0 : Items.cherryBlossomDoorItem.itemID;
		}

		if(blockID == Blocks.skywoodDoor.blockID)
		{
			return (par1 & 8) != 0 ? 0 : Items.skywoodDoorItem.itemID;
		}

		if(blockID == Blocks.bloodDoor.blockID)
		{
			return (par1 & 8) != 0 ? 0 : Items.bloodDoorItem.itemID;
		}

		return blockID;
	}

	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
	{
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
	{
		return par3 >= 255 ? false : par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) && super.canPlaceBlockAt(par1World, par2, par3, par4) && super.canPlaceBlockAt(par1World, par2, par3 + 1, par4);
	}

	@Override
	public int getMobilityFlag()
	{
		return 1;
	}

	public int getFullMetadata(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
	{
		int l = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		boolean flag = (l & 8) != 0;
		int i1;
		int j1;

		if (flag)
		{
			i1 = par1IBlockAccess.getBlockMetadata(par2, par3 - 1, par4);
			j1 = l;
		}
		else
		{
			i1 = l;
			j1 = par1IBlockAccess.getBlockMetadata(par2, par3 + 1, par4);
		}

		boolean flag1 = (j1 & 1) != 0;
		return i1 & 7 | (flag ? 8 : 0) | (flag1 ? 16 : 0);
	}

	@Override
	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer)
	{
		if (par6EntityPlayer.capabilities.isCreativeMode && (par5 & 8) != 0 && par1World.getBlockId(par2, par3 - 1, par4) == this.blockID)
		{
			par1World.setBlockToAir(par2, par3 - 1, par4);
		}
	}
}
