package sheenrox82.RioV.src.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;

public class BlockCoreOne extends Block
{

	public BlockCoreOne(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(TheMistsOfRioV.tab);
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		if(blockID == Blocks.onyxOre.blockID)
		{
			return Items.onyx.itemID;
		}
		if(blockID == Blocks.garnetOre.blockID)
		{
			return Items.garnet.itemID;
		}
		if(blockID == Blocks.nironiteOre.blockID)
		{
			return Items.nironite.itemID;
		}
		if(blockID == Blocks.dragonOre.blockID)
		{
			return Items.dragonSoul.itemID;
		}
		if(blockID == Blocks.netherCrystal.blockID)
		{
			return Items.burnedQuartz.itemID;
		}
		if(blockID == Blocks.slate.blockID)
		{
			return Blocks.slateCobble.blockID;
		}
		if(blockID == Blocks.sapphireOre.blockID)
		{
			return Items.sapphire.itemID;
		}
		if(blockID == Blocks.topazOre.blockID)
		{
			return Items.topaz.itemID;
		}
		if(blockID == Blocks.amethystOre.blockID)
		{
			return Items.amethyst.itemID;
		}
		if(blockID == Blocks.blindoniteOre.blockID)
		{
			return Items.blindonite.itemID;
		}
		if(blockID == Blocks.vraviniteOre.blockID)
		{
			return Items.vravinite.itemID;
		}

		if(blockID == Blocks.drakiuzOre.blockID)
		{
			return Items.drakiuz.itemID;
		}

		if(blockID == Blocks.alerisOre.blockID)
		{
			return Items.aleris.itemID;
		}

		if(blockID == Blocks.jaavikOre.blockID)
		{
			return Items.jaavik.itemID;
		}

		return blockID;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
	} 

	public String getName()
	{
		return this.unlocalizedName;
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		int var2 = par1Random.nextInt(6);

		if(var2 == 0)
		{
			if(blockID == Blocks.onyxOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.garnetOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.nironiteOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.dragonOre.blockID)
			{
				return 1;
			}
			if(blockID == Blocks.netherCrystal.blockID)
			{
				return 5;
			}
			if(blockID == Blocks.sapphireOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.topazOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.amethystOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.blindoniteOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.vraviniteOre.blockID)
			{
				return 1;
			}
			if(blockID == Blocks.drakiuzOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.alerisOre.blockID)
			{
				return 2;
			}
		}

		if(var2 == 1)
		{

			if(blockID == Blocks.onyxOre.blockID)
			{
				return 3;
			}
			if(blockID == Blocks.garnetOre.blockID)
			{
				return 1;
			}
			if(blockID == Blocks.nironiteOre.blockID)
			{
				return 3;
			}
			if(blockID == Blocks.dragonOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.netherCrystal.blockID)
			{
				return 6;
			}
			if(blockID == Blocks.sapphireOre.blockID)
			{
				return 3;
			}
			if(blockID == Blocks.topazOre.blockID)
			{
				return 1;
			}
			if(blockID == Blocks.amethystOre.blockID)
			{
				return 3;
			}
			if(blockID == Blocks.blindoniteOre.blockID)
			{
				return 1;
			}
			if(blockID == Blocks.vraviniteOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.drakiuzOre.blockID)
			{
				return 1;
			}
			if(blockID == Blocks.alerisOre.blockID)
			{
				return 1;
			}
		}

		if(var2 == 3)
		{

			if(blockID == Blocks.onyxOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.garnetOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.nironiteOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.dragonOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.netherCrystal.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.sapphireOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.topazOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.amethystOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.blindoniteOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.vraviniteOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.drakiuzOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.alerisOre.blockID)
			{
				return 0;
			}
		}

		if(var2 == 4)
		{
			if(blockID == Blocks.onyxOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.garnetOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.nironiteOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.dragonOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.netherCrystal.blockID)
			{
				return 5;
			}
			if(blockID == Blocks.sapphireOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.topazOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.amethystOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.blindoniteOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.vraviniteOre.blockID)
			{
				return 1;
			}
			if(blockID == Blocks.drakiuzOre.blockID)
			{
				return 0;
			}
			if(blockID == Blocks.alerisOre.blockID)
			{
				return 1;
			}
		}

		if(var2 == 5)
		{
			if(blockID == Blocks.onyxOre.blockID)
			{
				return 4;
			}
			if(blockID == Blocks.garnetOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.nironiteOre.blockID)
			{
				return 4;
			}
			if(blockID == Blocks.dragonOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.netherCrystal.blockID)
			{
				return 7;
			}
			if(blockID == Blocks.sapphireOre.blockID)
			{
				return 4;
			}
			if(blockID == Blocks.topazOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.amethystOre.blockID)
			{
				return 4;
			}
			if(blockID == Blocks.blindoniteOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.vraviniteOre.blockID)
			{
				return 3;
			}
			if(blockID == Blocks.drakiuzOre.blockID)
			{
				return 2;
			}
			if(blockID == Blocks.alerisOre.blockID)
			{
				return 3;
			}
		}

		return 1;
	}
}
