package sheenrox82.RioV.src.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;

public class RioVActivators extends Item
{
	public RioVActivators(int par1)
	{
		super(par1 - 256);
		this.maxStackSize = 1;
		this.setMaxDamage(50);
		this.setCreativeTab(TheMistsOfRioV.tab);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(par1ItemStack.itemID == Items.blindOasisActivator.itemID)
		{

			if (par7 == 0)
			{
				par5--;
			}
			if (par7 == 1)
			{
				par5++;
			}
			if (par7 == 2)
			{
				par6--;
			}
			if (par7 == 3)
			{
				par6++;
			}
			if (par7 == 4)
			{
				par4--;
			}
			if (par7 == 5)
			{
				par4++;
			}
			if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			{
				return false;
			}
			int i1 = par3World.getBlockId(par4, par5, par6);
			if (i1 == 0)
			{
				par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				par3World.setBlock(par4, par5, par6, Blocks.blackFire.blockID);
			}
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}

		if(par1ItemStack.itemID == Items.vaerynActivator.itemID)
		{

			if (par7 == 0)
			{
				par5--;
			}
			if (par7 == 1)
			{
				par5++;
			}
			if (par7 == 2)
			{
				par6--;
			}
			if (par7 == 3)
			{
				par6++;
			}
			if (par7 == 4)
			{
				par4--;
			}
			if (par7 == 5)
			{
				par4++;
			}
			if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			{
				return false;
			}
			int i1 = par3World.getBlockId(par4, par5, par6);
			if (i1 == 0)
			{
				par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				par3World.setBlock(par4, par5, par6, Blocks.whiteFire.blockID);
			}
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}
		if(par1ItemStack.itemID == Items.flamonorActivator.itemID)
		{

			if (par7 == 0)
			{
				par5--;
			}
			if (par7 == 1)
			{
				par5++;
			}
			if (par7 == 2)
			{
				par6--;
			}
			if (par7 == 3)
			{
				par6++;
			}
			if (par7 == 4)
			{
				par4--;
			}
			if (par7 == 5)
			{
				par4++;
			}
			if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			{
				return false;
			}
			int i1 = par3World.getBlockId(par4, par5, par6);
			if (i1 == 0)
			{
				par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				par3World.setBlock(par4, par5, par6, Blocks.redFire.blockID);
			}
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}

		if(par1ItemStack.itemID == Items.sanctuatiteActivator.itemID)
		{

			if (par7 == 0)
			{
				par5--;
			}
			if (par7 == 1)
			{
				par5++;
			}
			if (par7 == 2)
			{
				par6--;
			}
			if (par7 == 3)
			{
				par6++;
			}
			if (par7 == 4)
			{
				par4--;
			}
			if (par7 == 5)
			{
				par4++;
			}
			if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
			{
				return false;
			}
			int i1 = par3World.getBlockId(par4, par5, par6);
			if (i1 == 0)
			{
				par3World.playSoundEffect(par4 + 0.5D, par5 + 0.5D, par6 + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
				par3World.setBlock(par4, par5, par6, Blocks.sanctuatiteFire.blockID);
			}
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}

		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
	}

	public String getName()
	{
		return this.unlocalizedName;
	}
}

