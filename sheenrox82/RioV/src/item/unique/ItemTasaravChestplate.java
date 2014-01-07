package sheenrox82.RioV.src.item.unique;


import java.util.List;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Color;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTasaravChestplate extends ItemArmor
{
	public String armorNamePrefix;
	public EnumArmorMaterial material;
	public boolean isInfused;

	public ItemTasaravChestplate(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix, boolean par5)
	{
		super(par1 - 256, par2EnumArmorMaterial, par3, par4);
		this.material = par2EnumArmorMaterial;
		this.setMaxDamage(par2EnumArmorMaterial.getDurability(par4));
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
		armorNamePrefix = armornamePrefix;
		this.isInfused = par5;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) 
	{
		return Util.MOD_ID + ":" + "textures/armor/" + "TasaravChestplate.png";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) 
	{
		ModelBiped armorModel = null;
		int type = ((ItemArmor)itemStack.getItem()).armorType;


		if(itemStack != null)
		{
			if(itemStack.getItem() instanceof ItemTasaravChestplate)
			{
				if(type == 1 || type == 3)
				{
					armorModel = TheMistsOfRioV.getInstance().commonProxy.getArmorModel(2);
				}
				else
				{
					armorModel = TheMistsOfRioV.getInstance().commonProxy.getArmorModel(1);
				}

				if(armorModel != null)
				{
					armorModel.bipedHead.showModel = armorSlot == 0;
					armorModel.bipedHeadwear.showModel = armorSlot == 0;
					armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
					armorModel.bipedRightArm.showModel = armorSlot == 1;
					armorModel.bipedLeftArm.showModel = armorSlot == 1;
					armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
					armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;

					armorModel.isSneak = entityLiving.isSneaking();
					armorModel.isRiding = entityLiving.isRiding();
					armorModel.isChild = entityLiving.isChild();
					armorModel.heldItemRight = entityLiving.getCurrentItemOrArmor(0) != null ? 1 :0;

					if(entityLiving instanceof EntityPlayer)
					{
						armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
					}

					return armorModel;
				}
			}
		}

		return null;
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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if ((itemID == Items.tasaravChestplate.itemID))
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "tasaravChestplate");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(Config.showToolInfo)
		{
			var3.add(Color.GOLD + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.DARK_PURPLE + "Protection: " + MethodUtil.getMaxDamageFactor(this.material));
		}
	}
}