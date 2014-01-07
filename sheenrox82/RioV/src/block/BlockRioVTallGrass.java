package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.Util;

public class BlockRioVTallGrass extends BlockFlower
{
	public BlockRioVTallGrass(int par1, Material par2Material)
	{
		super(par1);
		this.setCreativeTab(null);
	}

	@Override
	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{
		return par1 == Blocks.sanctuatiteGrass.blockID;
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}

	@Override
	public void registerIcons(IconRegister i)
	{
		this.blockIcon = i.registerIcon(Util.MOD_ID + ":" + MethodUtil.getName(this.getUnlocalizedName()));
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return -1;
	}

}
