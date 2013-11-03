package sheenrox82.RioV.src.item.metadata;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlackQuartzBlock extends ItemBlock
{
	public ItemBlackQuartzBlock(int par1)
	{
		super(par1);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";
		switch(itemstack.getItemDamage())
		{
		case 0:
		{
			name = "default"; break;
		}
		case 1:
		{
			name = "chiseled"; break;
		}
		case 2:
		{
			name = "lines"; break;
		}
		default: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	}

	public int getMetadata(int par1)
	{
		return par1;
	}
}
