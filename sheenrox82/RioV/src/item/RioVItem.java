package sheenrox82.RioV.src.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVItem extends Item
{
	public RioVItem(int par1)
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
		if(itemID == Items.orb.itemID)
		{
			return true;
		}

		return false;
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
		if(itemID == Items.amethyst.itemID)par3List.add("A gem to show wealth and power");
		if(itemID == Items.onyx.itemID)par3List.add("A dark mass");
		if(itemID == Items.vravinite.itemID)par3List.add("A crystal to show confidence");
		if(itemID == Items.aleris.itemID)par3List.add("A gem to show defence and strategies");
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(itemID == Items.heart.itemID)
		{
			par3EntityPlayer.heal(2);
			par3EntityPlayer.inventory.consumeInventoryItem(Items.heart.itemID);
		}
		
		return par1ItemStack;
	}
}
