package sheenrox82.RioV.src.recipe;

import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;

public class AlchemyTableRecipes
{
	public AlchemyTableRecipes()
	{
	}
	
	public static ItemStack getSmeltingResult(int slot1, int slot2, int slot3, int slot4)
	{
		return getOutput(slot1, slot2, slot3, slot4);
	}
	
	private static ItemStack getOutput(int slot1, int slot2, int slot3, int slot4)
	{
		if (slot1 == Blocks.runestone.blockID && slot2 == Blocks.runestone.blockID)
		{
			return new ItemStack(Items.rune, 1);
		}

		return null;
	}
}