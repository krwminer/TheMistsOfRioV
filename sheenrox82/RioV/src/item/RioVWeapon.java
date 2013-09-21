package sheenrox82.RioV.src.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Enchantments;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVWeapon extends ItemSword
{
	private float weaponDamage;
	private final EnumToolMaterial toolMaterial;
	public boolean isInfused;

	public RioVWeapon(int par1, EnumToolMaterial par2EnumToolMaterial, boolean par2)
	{
		super(par1 - 256, par2EnumToolMaterial);
		this.toolMaterial = par2EnumToolMaterial;
		this.maxStackSize = 1;
		this.setMaxDamage(par2EnumToolMaterial.getMaxUses());
		this.setCreativeTab(TheMistsOfRioV.tab);
		this.weaponDamage = 4 + par2EnumToolMaterial.getDamageVsEntity();
		this.isInfused = par2;
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if (isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}

	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		if(par1ItemStack.itemID == Items.axeOfAunTun.itemID)
		{
			par2EntityLivingBase.setFire(30);
		}

		if(par1ItemStack.itemID == Items.swordOfFlame.itemID)
		{
			par2EntityLivingBase.setFire(10);
		}

		if(par1ItemStack.itemID == Items.daetoriSword.itemID)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 3));
		}

		if(par1ItemStack.itemID == Items.alerisSword.itemID)
		{
			par2EntityLivingBase.motionY = 1;
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.kanuutu.effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.motionY = 0.8;
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.kanuutu.effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.motionY = 0.7;
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.frost.effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 4));
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.frost.effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 100, 2)); 
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.venom.effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 4));
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.venom.effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.poison.id, 100, 2)); 
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.confusion.effectId, par1ItemStack) == 2)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 4));
		}

		if (EnchantmentHelper.getEnchantmentLevel(Enchantments.confusion.effectId, par1ItemStack) == 1)
		{
			par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.wither.id, 100, 2)); 
		}

		par1ItemStack.damageItem(1, par3EntityLivingBase);
		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(itemstack.itemID == Items.shifter.itemID)
		{
			entityplayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 10));
			itemstack.damageItem(1, entityplayer);
		}

		if(itemstack.itemID == Items.khuulisScythe.itemID)
		{
			float f = 1.0F;
			float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
			float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
			double d = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * (double)f;
			double d1 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * (double)f + 1.6200000000000001D) - (double)entityplayer.yOffset;
			double d2 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * (double)f;
			Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
			float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
			float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
			float f5 = -MathHelper.cos(-f1 * 0.01745329F);
			float f6 = MathHelper.sin(-f1 * 0.01745329F);
			float f7 = f4 * f5;
			float f8 = f6;
			float f9 = f3 * f5;
			double d3 = 5000D;
			Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3 + 1, (double)f9 * d3);
			MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
			if (movingobjectposition == null)
			{
				return itemstack;
			}
			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;
				world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
			}
			itemstack.damageItem(1, entityplayer);
		}
		entityplayer.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
		return itemstack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(var1.itemID == Items.axeOfAunTun.itemID)
		{
			var3.add("The most valuable and powerful weapon.");
			var3.add("Fully fused. Fully usable.");
			var3.add("Fusion: 100%");
		}

		if(var1.itemID == Items.UnfusedaxeOfAunTun.itemID)
		{
			var3.add(StatCollector.translateToLocal("Unfused. Not usable."));
			var3.add(StatCollector.translateToLocal("Fusion: 0%"));
		}

		if (var1.itemID == Items.HalfFusedaxeOfAunTun.itemID)
		{
			var3.add(StatCollector.translateToLocal("Half fused. Still not usable."));
			var3.add(StatCollector.translateToLocal("Fusion: 50%"));
		}

		if(Config.showToolInfo)
		{
			var3.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
			var3.add("Damage: " + toolMaterial.getDamageVsEntity());
		}
	}

	@Override
	public EnumRarity getRarity(ItemStack par1)
	{
		if(par1.itemID == Items.axeOfAunTun.itemID)
		{
			return EnumRarity.epic;
		}

		if(par1.itemID == Items.daetoriSword.itemID)
		{
			return EnumRarity.epic;
		}
		return EnumRarity.common;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(itemID == Items.amethystSword.itemID || itemID == Items.infusedAmethystSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystSword");
		}
		if(itemID == Items.darkenedAmethystSword.itemID || itemID == Items.darkenedInfusedAmethystSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "darkenedAmethystSword");
		}
		if(itemID == Items.onyxSword.itemID || itemID == Items.infusedOnyxSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxSword");
		}
		if(itemID == Items.darkenedOnyxSword.itemID || itemID == Items.darkenedInfusedOnyxSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "darkenedOnyxSword");
		}
		if(itemID == Items.bladeOfAni.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bladeOfAni");
		}
		if(itemID == Items.nizonianBlade.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "nizonianBlade");
		}
		if(itemID == Items.daetoriSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "daetoriSword");
		}
		if(itemID == Items.sorrowSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sorrowSword");
		}
		if(itemID == Items.axeOfAunTun.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "axeOfAunTun");
		}
		if(itemID == Items.slateHandaxe.itemID || itemID == Items.sharpenedSlateHandaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "slateHandaxe");
		}
		if(itemID == Items.dragonSword.itemID || itemID == Items.infusedDragonSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonSword");
		}
		if(itemID == Items.vulronSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vulronSword");
		}
		if(itemID == Items.UnfusedaxeOfAunTun.itemID || itemID == Items.HalfFusedaxeOfAunTun.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "UnfusedaxeOfAunTun");
		}
		if(itemID == Items.khuulisScythe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "khuulisScythe");
		}
		if(itemID == Items.shifter.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "shifter");
		}
		if(itemID == Items.sapphireSword.itemID || itemID == Items.infusedSapphireSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphireSword");
		}
		if(itemID == Items.topazSword.itemID || itemID == Items.infusedTopazSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazSword");
		}
		if(itemID == Items.trainingSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "trainingSword");
		}
		if(itemID == Items.galokinSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "galokinSword");
		}
		if(itemID == Items.darkenedTopazSword.itemID || itemID == Items.darkenedInfusedTopazSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "darkenedTopazSword");
		}
		if(itemID == Items.darkenedSapphireSword.itemID || itemID == Items.darkenedInfusedSapphireSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "darkenedSapphireSword");
		}
		if(itemID == Items.swordOfFlame.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "swordOfFlame");
		}
		if(itemID == Items.darkenedDragonSword.itemID || itemID == Items.darkenedInfusedDragonSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "darkenedDragonSword");
		}
		if(itemID == Items.blindoniteSword.itemID || itemID == Items.infusedBlindoniteSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindoniteSword");
		}
		if(itemID == Items.glimmerwoodSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "glimmerwoodSword");
		}
		if(itemID == Items.vraviniteSword.itemID || itemID == Items.infusedVraviniteSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vraviniteSword");
		}
		if(itemID == Items.cherryBlossomSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryBlossomSword");
		}
		if(itemID == Items.bloodSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodSword");
		}
		if(itemID == Items.skywoodSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodSword");
		}
		if(itemID == Items.sanctuaryStoneSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sanctuaryStoneSword");
		}
		if(itemID == Items.alerisSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisSword");
		}
		if(itemID == Items.darkenedVraviniteSword.itemID || itemID == Items.darkenedInfusedVraviniteSword.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "darkenedVraviniteSword");
		}
		if(TheMistsOfRioV.riovPaladin)
		{
			if(itemID == Items.paladinLongsword.itemID) this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "paladinLongsword");
		}
	}
}
