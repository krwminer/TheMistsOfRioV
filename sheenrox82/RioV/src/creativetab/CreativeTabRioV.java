package sheenrox82.RioV.src.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.content.Blocks;

public final class CreativeTabRioV extends CreativeTabs
{
	public CreativeTabRioV(String label)
	{
		super(label);
	}

    @Override
    public ItemStack getIconItemStack()
    {
        return new ItemStack(Blocks.infuser);
    }
}
