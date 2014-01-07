package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.Util;

public class BlockPlantCore extends BlockFlower
{
	public BlockPlantCore(int par1)
	{
		super(par1, Material.plants);
		setCreativeTab(null);
		setHardness(0.0F);
		setStepSound(soundGrassFootstep);
	}

	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(blockID == Blocks.blackDuriiPlant.blockID)
		{
			return Items.blackDurii.itemID;
		}
		if(blockID == Blocks.tomatoPlant.blockID)
		{
			return Items.tomato.itemID;
		}
		if(blockID == Blocks.grapePlant.blockID)
		{
			return Items.grapes.itemID;
		}
		if(blockID == Blocks.pepperPlant.blockID)
		{
			return Items.pepper.itemID;
		}
		if(blockID == Blocks.cherryPlant.blockID)
		{
			return Items.cherry.itemID;
		}
		if(blockID == Blocks.bamboo.blockID)
		{
			return Items.bambooItem.itemID;
		}
		if(blockID == Blocks.bloodFlower.blockID)
		{
			return Items.heart.itemID;
		}

		return blockID;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + MethodUtil.getName(this.getUnlocalizedName()));
	}

	protected boolean canThisPlantGrowOnThisBlockID(int par1)
	{		
		if(blockID == Blocks.bloodFlower.blockID)
		{
			return par1 == Blocks.bloodGrass.blockID;
		}
		
		return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID;
	}
}
