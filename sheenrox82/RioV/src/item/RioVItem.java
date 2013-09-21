package sheenrox82.RioV.src.item;

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
		this.setCreativeTab(TheMistsOfRioV.tab);
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
}
