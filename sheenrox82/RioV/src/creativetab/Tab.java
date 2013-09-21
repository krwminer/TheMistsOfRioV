package sheenrox82.RioV.src.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.content.Blocks;

public final class Tab extends CreativeTabs
{
	public Tab(String label)
	{
		super(label);
	}

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(Blocks.infuser);
    }
}
