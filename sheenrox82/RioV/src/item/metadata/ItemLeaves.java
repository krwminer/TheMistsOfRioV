package sheenrox82.RioV.src.item.metadata;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLeaves extends Item
{
	public static String[] leafType = new String[] {"glimmerwoodLeaf", "paleLeaf", "cherryBlossomLeaf"};
	
	@SideOnly(Side.CLIENT)
	public Icon[] icons;

	public ItemLeaves(int item)
	{
		super(item);
		this.setHasSubtypes(true);
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	@Override
	public Icon getIconFromDamage(int par0)
	{
		return icons[par0];
	}
	
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for(int x = 0; x < leafType.length; x++)
		{
			par3List.add(new ItemStack(this, 1, x));
		}
	}
	
	@Override
	public void registerIcons(IconRegister i)
	{
		icons = new Icon[leafType.length];

		for(int x = 0; x < leafType.length; x++)
		{
			this.icons[x] = i.registerIcon(Util.MOD_ID + ":" + leafType[x]);
		}
	}
	
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	    int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	    return super.getUnlocalizedName() + "." + leafType[i];
	}
}
