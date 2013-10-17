package sheenrox82.RioV.src.item.unique;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRune extends Item
{
	public int foodEffectRand;

	public ItemRune(int par1)
	{
		super(par1 - 256);
		this.setMaxDamage(0);
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	public String itemName()
	{
		return this.unlocalizedName;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.itemName());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(itemID == Items.rune.itemID)par3List.add("Take your chances...");
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		if (!entityPlayer.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}

		foodEffectRand = itemRand.nextInt(10);

		if (foodEffectRand == 0)
		{
			entityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 150, 4));
		}
		if (foodEffectRand == 1)
		{
			entityPlayer.addPotionEffect(new PotionEffect(Potion.wither.id, 210, 4));
		}
		if (foodEffectRand == 2)
		{
			entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.amethystSword, 1));
		}
		if (foodEffectRand == 3)
		{
			entityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 120, 2));
		}
		if (foodEffectRand == 4)
		{
			entityPlayer.addPotionEffect(new PotionEffect(Potion.harm.id, 400, 8));
		}
		if (foodEffectRand == 5)
		{
			entityPlayer.addPotionEffect(new PotionEffect(Potion.weakness.id, 300, 1));
		}
		if (foodEffectRand == 6)
		{
			entityPlayer.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 9));
		}
		if (foodEffectRand == 7)
		{
			entityPlayer.heal(20);
		}
		if (foodEffectRand == 8)
		{
			entityPlayer.addVelocity(0, 2, 0);
		}
		if (foodEffectRand == 9)
		{
			entityPlayer.addVelocity(0, 1, 0);
		}

		return itemStack;
	}
}

