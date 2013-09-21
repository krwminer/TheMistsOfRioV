package sheenrox82.RioV.src.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class DarkenerRecipes
{
    private static final DarkenerRecipes altarBase = new DarkenerRecipes();
    private Map DarkenerList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    public static final DarkenerRecipes recipe()
    {
        return altarBase;
    }

    private DarkenerRecipes()
    {
    	this.addAltarRecipe(Items.amethystSword.itemID, new ItemStack(Items.darkenedAmethystSword, 1));
        this.addAltarRecipe(Items.infusedAmethystSword.itemID, new ItemStack(Items.darkenedInfusedAmethystSword, 1));
        this.addAltarRecipe(Items.onyxSword.itemID, new ItemStack(Items.darkenedOnyxSword, 1));
        this.addAltarRecipe(Items.infusedOnyxSword.itemID, new ItemStack(Items.darkenedInfusedOnyxSword, 1));
        this.addAltarRecipe(Items.sapphireSword.itemID, new ItemStack(Items.darkenedSapphireSword, 1));
        this.addAltarRecipe(Items.infusedSapphireSword.itemID, new ItemStack(Items.darkenedInfusedSapphireSword, 1));
        this.addAltarRecipe(Items.topazSword.itemID, new ItemStack(Items.darkenedTopazSword, 1));
        this.addAltarRecipe(Items.infusedTopazSword.itemID, new ItemStack(Items.darkenedInfusedTopazSword, 1));
        this.addAltarRecipe(Items.dragonSword.itemID, new ItemStack(Items.darkenedDragonSword, 1));
        this.addAltarRecipe(Items.infusedDragonSword.itemID, new ItemStack(Items.darkenedInfusedDragonSword, 1));
        this.addAltarRecipe(Items.vraviniteSword.itemID, new ItemStack(Items.darkenedVraviniteSword, 1));
        this.addAltarRecipe(Items.infusedVraviniteSword.itemID, new ItemStack(Items.darkenedInfusedVraviniteSword, 1));
    }

	public void addAltarRecipe(int par1, ItemStack par2ItemStack)
    {
        this.DarkenerList.put(Integer.valueOf(par1), par2ItemStack);
    }

    public Map getSmeltingList()
    {
        return this.DarkenerList;
    }
    
    public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
    }
    
    public ItemStack getResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)DarkenerList.get(Integer.valueOf(item.itemID));
    }
}
