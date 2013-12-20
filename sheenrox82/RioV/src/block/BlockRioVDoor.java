package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
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

public class BlockRioVDoor extends BlockDoor
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
}
