package sheenrox82.RioV.src.recipe;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class AnvilRecipeSorter implements Comparator
{
	final AnvilCraftingManager anvil;

	public AnvilRecipeSorter(AnvilCraftingManager anvil)
	{
		this.anvil = anvil;
	}

	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
	{
		return par1IRecipe instanceof AnvilShapelessRecipes && par2IRecipe instanceof AnvilShapedRecipes ? 1 : (par2IRecipe instanceof AnvilShapelessRecipes && par1IRecipe instanceof AnvilShapedRecipes ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
	}

	public int compare(Object par1Obj, Object par2Obj)
	{
		return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
	}
}