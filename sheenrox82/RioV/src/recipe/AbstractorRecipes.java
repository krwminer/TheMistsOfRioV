package sheenrox82.RioV.src.recipe;

import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;

public class AbstractorRecipes
{
	public AbstractorRecipes()
	{
	}
	public static ItemStack getSmeltingResult(int i, int j)
	{
		return getOutput(i, j);
	}
	private static ItemStack getOutput(int i, int j)
	{
		if (i == Blocks.runestone.blockID && j == Blocks.runestone.blockID)
		{
			return new ItemStack(Items.rune, 1);
		}

		return null;
	}
}