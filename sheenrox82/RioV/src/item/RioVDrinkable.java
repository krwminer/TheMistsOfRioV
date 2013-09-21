package sheenrox82.RioV.src.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;

public class RioVDrinkable extends ItemFood
{
	public int foodEffectRand;

	public RioVDrinkable(int par1, int par2, float par3, boolean par4)
	{
		super(par1 - 256, par2, par4);
		this.setMaxStackSize(1);
		this.setCreativeTab(TheMistsOfRioV.tab);
	}

	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		if (!entityPlayer.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}
		if(itemStack.itemID == Items.wine.itemID)
		{
			foodEffectRand = itemRand.nextInt(3);

			if (foodEffectRand == 0)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().addStats(this);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(Items.wineGlass) : itemStack;
			}
			if (foodEffectRand == 1)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().addStats(this);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 1000, 6));//again, sets effect an time
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(Items.wineGlass) : itemStack;
			}
			if (foodEffectRand == 2)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().addStats(this);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(Items.wineGlass) : itemStack;			}
		}

		if(itemStack.itemID == Items.spicedWine.itemID)
		{
			foodEffectRand = itemRand.nextInt(3);

			if (foodEffectRand == 0)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().addStats(this);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(Items.wineGlass) : itemStack;
			}
			if (foodEffectRand == 1)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().addStats(this);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 10 * 20, 2));//again, sets effect an time
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(Items.wineGlass) : itemStack;

			}
			if (foodEffectRand == 2)
			{
				--itemStack.stackSize;
				entityPlayer.getFoodStats().addStats(this);
				world.playSoundAtEntity(entityPlayer, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
				this.onFoodEaten(itemStack, world, entityPlayer);
				return itemStack.stackSize <= 0 ? new ItemStack(Items.wineGlass) : itemStack;
			}
		}

		return itemStack;

	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.drink;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(itemID == Items.wine.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "wine");
		}
		if(itemID == Items.spicedWine.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "spicedWine");
		}
	}
}
