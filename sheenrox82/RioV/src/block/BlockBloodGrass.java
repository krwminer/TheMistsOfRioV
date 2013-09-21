package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Particles;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBloodGrass extends Block
{
	@SideOnly(Side.CLIENT)
	private Icon iconGrassTop;

	public BlockBloodGrass(int par1)
	{
		super(par1, Material.grass);
		this.setStepSound(soundGrassFootstep);
		this.setTickRandomly(true);
		this.setCreativeTab(TheMistsOfRioV.tab);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 1 ? this.iconGrassTop : (par1 == 0 ? Blocks.bloodDirt.getBlockTextureFromSide(par1) : this.blockIcon);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (!par1World.isRemote)
		{
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
			{
				par1World.setBlock(par2, par3, par4, Blocks.bloodDirt.blockID);
			}
			else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
			{
				for (int l = 0; l < 4; ++l)
				{
					int i1 = par2 + par5Random.nextInt(3) - 1;
					int j1 = par3 + par5Random.nextInt(5) - 3;
					int k1 = par4 + par5Random.nextInt(3) - 1;
					int l1 = par1World.getBlockId(i1, j1 + 1, k1);

					if (par1World.getBlockId(i1, j1, k1) == Blocks.bloodDirt.blockID && par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4 && par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
					{
						par1World.setBlock(i1, j1, k1, Blocks.bloodGrass.blockID);
					}
				}
			}
		}
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Blocks.bloodDirt.blockID;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		if (par5 == 1)
		{
			return this.iconGrassTop;
		}
		else if (par5 == 0)
		{
			return Blocks.bloodDirt.getBlockTextureFromSide(par2);
		}
		else
		{

			return this.blockIcon;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
		this.iconGrassTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodGrassTop");
	}

	public String getName()
	{
		return this.unlocalizedName;
	}
}