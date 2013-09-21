package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;

public class BlockPlantCore extends BlockFlower
{
	public BlockPlantCore(int par1, Material par2Material)
	{
		super(par1, par2Material);
		setCreativeTab(null);
		setHardness(0.0F);
		setStepSound(soundGrassFootstep);
	}

	public BlockPlantCore(int par1)
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
		return blockID;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
	}

	public String getName()
	{
		return this.unlocalizedName;
	}
}
