package sheenrox82.RioV.src.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Enchantments;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;

public class RioVShield extends Item
{
	public int protection;
	
	public RioVShield(int par1, EnumToolMaterial var2, int protection)
	{
		super(par1 - 256);
		this.protection = protection;
		this.maxStackSize = 1;
		this.setMaxDamage(var2.getMaxUses());
		this.setCreativeTab(TheMistsOfRioV.tab);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 72000;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(itemID == Items.shieldOfFlame.itemID)
		{
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 20, 1));
		}
		
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 20, protection));
		par1ItemStack.damageItem(1, par3EntityPlayer);
		return par1ItemStack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
	{
		par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	}

	@Override
	public void registerIcons(IconRegister i)
	{
		this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + this.getName());
	}

	public String getName()
	{
		return this.unlocalizedName;
	}
}
