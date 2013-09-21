package sheenrox82.RioV.src.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVArmor extends ItemArmor
{
	public String armorNamePrefix;
	public EnumArmorMaterial material;
	public boolean isInfused;

	public RioVArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, boolean par5)
	{
		super(par1 - 256, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.setCreativeTab(TheMistsOfRioV.tab);
		armorNamePrefix = armornamePrefix;
		this.isInfused = par5;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		if (stack.toString().contains("leggings")) 
		{
			return Util.MOD_ID + ":" + "textures/armor/" + armorNamePrefix + "_2.png";
		}
		if (stack.toString().contains("Leggings")) 
		{
			return Util.MOD_ID + ":" + "textures/armor/" + armorNamePrefix + "_2.png";
		}

		return Util.MOD_ID + ":" + "textures/armor/" + armorNamePrefix + "_1.png";
	}

	@Override
	public EnumArmorMaterial getArmorMaterial()
	{
		return this.material;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}

	@Override
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemstack)
	{
		ItemStack boots = player.getCurrentItemOrArmor(1);
		ItemStack leggings = player.getCurrentItemOrArmor(2);
		ItemStack chestplate = player.getCurrentItemOrArmor(3);
		ItemStack helmet = player.getCurrentItemOrArmor(4);

		if(boots != null) 
		{
			if(boots.getItem() == Items.magickaBoots)
			{
				player.fallDistance = 0.0F;
				player.addPotionEffect(new PotionEffect(Potion.jump.id, 5, 2));
				player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5, 0));
			}
			if(boots.getItem() == Items.bootsOfFlame)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}

		if(chestplate != null) 
		{
			if(chestplate.getItem() == Items.magickaChestplate)
			{
				player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5, 2));
			}
			if(chestplate.getItem() == Items.chestplateOfFlame)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}

		if(leggings != null) 
		{
			if(leggings.getItem() == Items.magickaLeggings)
			{
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 5, 0));
			}
			if(leggings.getItem() == Items.leggingsOfFlame)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}

		if(helmet != null) 
		{
			if(helmet.getItem() == Items.magickaHelmet)
			{
				player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 5, 0));
			}
			if(helmet.getItem() == Items.helmetOfFlame)
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5, 1));
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if ((itemID == Items.onyxHelmet.itemID) || (itemID == Items.infusedOnyxHelmet.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxHelmet");
		}
		if ((itemID == Items.onyxChestplate.itemID) || (itemID == Items.infusedOnyxChestplate.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxChestplate");
		}
		if ((itemID == Items.onyxLeggings.itemID) || (itemID == Items.infusedOnyxLeggings.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxLeggings");
		}
		if ((itemID == Items.onyxBoots.itemID) || (itemID == Items.infusedOnyxBoots.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxBoots");
		}
		if ((itemID == Items.amethystHelmet.itemID) || (itemID == Items.infusedAmethystHelmet.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystHelmet");
		}
		if ((itemID == Items.amethystChestplate.itemID) || (itemID == Items.infusedAmethystChestplate.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystChestplate");
		}
		if ((itemID == Items.amethystLeggings.itemID) || (itemID == Items.infusedAmethystLeggings.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystLeggings");
		}
		if ((itemID == Items.amethystBoots.itemID) || (itemID == Items.infusedAmethystBoots.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystBoots");
		}
		if (itemID == Items.auntunMinionHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "auntunMinionHelmet");
		}
		if (itemID == Items.auntunMinionChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "auntunMinionChestplate");
		}
		if (itemID == Items.auntunMinionLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "auntunMinionLeggings");
		}
		if (itemID == Items.auntunMinionBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "auntunMinionBoots");
		}
		if (itemID == Items.galokinHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "galokinHelmet");
		}
		if (itemID == Items.galokinChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "galokinChestplate");
		}
		if (itemID == Items.galokinLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "galokinLeggings");
		}
		if (itemID == Items.galokinBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "galokinBoots");
		}
		if (itemID == Items.garnetHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "garnetHelmet");
		}
		if (itemID == Items.garnetChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "garnetChestplate");
		}
		if (itemID == Items.garnetLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "garnetLeggings");
		}
		if (itemID == Items.garnetBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "garnetBoots");
		}
		if (itemID == Items.mythrilHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "mythrilHelmet");
		}
		if (itemID == Items.mythrilChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "mythrilChestplate");
		}
		if (itemID == Items.mythrilLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "mythrilLeggings");
		}
		if (itemID == Items.mythrilBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "mythrilBoots");
		}
		if ((itemID == Items.dragonHelmet.itemID) || (itemID == Items.infusedDragonHelmet.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonHelmet");
		}
		if ((itemID == Items.dragonChestplate.itemID) || (itemID == Items.infusedDragonChestplate.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonChestplate");
		}
		if ((itemID == Items.dragonLeggings.itemID) || (itemID == Items.infusedDragonLeggings.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonLeggings");
		}
		if ((itemID == Items.dragonBoots.itemID) || (itemID == Items.infusedDragonBoots.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonBoots");
		}
		if ((itemID == Items.sapphireHelmet.itemID) || (itemID == Items.infusedSapphireHelmet.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphireHelmet");
		}
		if ((itemID == Items.sapphireChestplate.itemID) || (itemID == Items.infusedSapphireChestplate.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphireChestplate");
		}
		if ((itemID == Items.sapphireLeggings.itemID) || (itemID == Items.infusedSapphireLeggings.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphireLeggings");
		}
		if ((itemID == Items.sapphireBoots.itemID) || (itemID == Items.infusedSapphireBoots.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphireBoots");
		}
		if ((itemID == Items.topazHelmet.itemID) || (itemID == Items.infusedTopazHelmet.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazHelmet");
		}
		if ((itemID == Items.topazChestplate.itemID) || (itemID == Items.infusedTopazChestplate.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazChestplate");
		}
		if ((itemID == Items.topazLeggings.itemID) || (itemID == Items.infusedTopazLeggings.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazLeggings");
		}
		if ((itemID == Items.topazBoots.itemID) || (itemID == Items.infusedTopazBoots.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazBoots");
		}
		if ((itemID == Items.blindoniteHelmet.itemID) || (itemID == Items.infusedBlindoniteHelmet.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindoniteHelmet");
		}
		if ((itemID == Items.blindoniteChestplate.itemID) || (itemID == Items.infusedBlindoniteChestplate.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindoniteChestplate");
		}
		if ((itemID == Items.blindoniteLeggings.itemID) || (itemID == Items.infusedBlindoniteLeggings.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindoniteLeggings");
		}
		if ((itemID == Items.blindoniteBoots.itemID) || (itemID == Items.infusedBlindoniteBoots.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindoniteBoots");
		}
		if (itemID == Items.magickaHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "magickaHelmet");
		}
		if (itemID == Items.magickaChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "magickaChestplate");
		}
		if (itemID == Items.magickaLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "magickaLeggings");
		}
		if (itemID == Items.magickaBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "magickaBoots");
		}
		if (itemID == Items.helmetOfFlame.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "helmetOfFlame");
		}
		if (itemID == Items.chestplateOfFlame.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "chestplateOfFlame");
		}
		if (itemID == Items.leggingsOfFlame.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "leggingsOfFlame");
		}
		if (itemID == Items.bootsOfFlame.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bootsOfFlame");
		}
		if (itemID == Items.tefHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "tefHelmet");
		}
		if (itemID == Items.tefChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "tefChestplate");
		}
		if (itemID == Items.tefLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "tefLeggings");
		}
		if (itemID == Items.tefBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "tefBoots");
		}
		if (itemID == Items.vraviniteHelmet.itemID || itemID == Items.infusedVraviniteHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vraviniteHelmet");
		}
		if (itemID == Items.vraviniteChestplate.itemID || itemID == Items.infusedVraviniteChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vraviniteChestplate");
		}
		if (itemID == Items.vraviniteLeggings.itemID || itemID == Items.infusedVraviniteLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vraviniteLeggings");
		}
		if (itemID == Items.vraviniteBoots.itemID || itemID == Items.infusedVraviniteBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vraviniteBoots");
		}
		if (itemID == Items.alerisHelmet.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisHelmet");
		}
		if (itemID == Items.alerisChestplate.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisChestplate");
		}
		if (itemID == Items.alerisLeggings.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisLeggings");
		}
		if (itemID == Items.alerisBoots.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisBoots");
		}
		if (TheMistsOfRioV.riovPaladin)
		{
			if (itemID == Items.paladinHelmet.itemID)this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "paladinHelmet");
			if (itemID == Items.paladinChestplate.itemID)this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "paladinChestplate");
			if (itemID == Items.paladinLeggings.itemID)this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "paladinLeggings");
			if (itemID == Items.paladinBoots.itemID)this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "paladinBoots");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(Config.showToolInfo)
		{
			var3.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
			var3.add("Protection: " + material.maxDamageFactor);
		}
	}
}