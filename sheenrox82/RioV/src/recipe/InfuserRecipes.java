package sheenrox82.RioV.src.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;

/*
import mods.natura.common.NContent;
import net.aetherteam.aether.items.AetherItems;
*/
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipes
{
    private static final InfuserRecipes altarBase = new InfuserRecipes();
    private Map AltarList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    public static final InfuserRecipes getInfuser()
    {
        return altarBase;
    }

    private InfuserRecipes()
    {
    	this.addAltarRecipe(Items.amethystSword.itemID, new ItemStack(Items.infusedAmethystSword, 1));
        this.addAltarRecipe(Items.onyxSword.itemID, new ItemStack(Items.infusedOnyxSword, 1));
        this.addAltarRecipe(Items.amethystShovel.itemID, new ItemStack(Items.infusedAmethystShovel, 1));
        this.addAltarRecipe(Items.amethystPickaxe.itemID, new ItemStack(Items.infusedAmethystPickaxe, 1));
        this.addAltarRecipe(Items.amethystAxe.itemID, new ItemStack(Items.infusedAmethystAxe, 1));
        this.addAltarRecipe(Items.onyxShovel.itemID, new ItemStack(Items.infusedOnyxShovel, 1));
        this.addAltarRecipe(Items.onyxPickaxe.itemID, new ItemStack(Items.infusedOnyxPickaxe, 1));
        this.addAltarRecipe(Items.onyxAxe.itemID, new ItemStack(Items.infusedOnyxAxe, 1));
        this.addAltarRecipe(Items.amethystHelmet.itemID, new ItemStack(Items.infusedAmethystHelmet, 1));
        this.addAltarRecipe(Items.amethystChestplate.itemID, new ItemStack(Items.infusedAmethystChestplate, 1));
        this.addAltarRecipe(Items.amethystLeggings.itemID, new ItemStack(Items.infusedAmethystLeggings, 1));
        this.addAltarRecipe(Items.amethystBoots.itemID, new ItemStack(Items.infusedAmethystBoots, 1));
        this.addAltarRecipe(Items.onyxHelmet.itemID, new ItemStack(Items.infusedOnyxHelmet, 1));
        this.addAltarRecipe(Items.onyxChestplate.itemID, new ItemStack(Items.infusedOnyxChestplate, 1));
        this.addAltarRecipe(Items.onyxLeggings.itemID, new ItemStack(Items.infusedOnyxLeggings, 1));
        this.addAltarRecipe(Items.onyxBoots.itemID, new ItemStack(Items.infusedOnyxBoots, 1));
        this.addAltarRecipe(Items.UnfusedaxeOfAunTun.itemID, new ItemStack(Items.HalfFusedaxeOfAunTun, 1));
        this.addAltarRecipe(Items.HalfFusedaxeOfAunTun.itemID, new ItemStack(Items.axeOfAunTun, 1));
        this.addAltarRecipe(Items.sapphireSword.itemID, new ItemStack(Items.infusedSapphireSword, 1));
        this.addAltarRecipe(Items.topazSword.itemID, new ItemStack(Items.infusedTopazSword, 1));
        this.addAltarRecipe(Items.sapphireShovel.itemID, new ItemStack(Items.infusedSapphireShovel, 1));
        this.addAltarRecipe(Items.sapphirePickaxe.itemID, new ItemStack(Items.infusedSapphirePickaxe, 1));
        this.addAltarRecipe(Items.sapphireAxe.itemID, new ItemStack(Items.infusedSapphireAxe, 1));
        this.addAltarRecipe(Items.topazShovel.itemID, new ItemStack(Items.infusedTopazShovel, 1));
        this.addAltarRecipe(Items.topazPickaxe.itemID, new ItemStack(Items.infusedTopazPickaxe, 1));
        this.addAltarRecipe(Items.topazAxe.itemID, new ItemStack(Items.infusedTopazAxe, 1));
        this.addAltarRecipe(Items.sapphireHelmet.itemID, new ItemStack(Items.infusedSapphireHelmet, 1));
        this.addAltarRecipe(Items.sapphireChestplate.itemID, new ItemStack(Items.infusedSapphireChestplate, 1));
        this.addAltarRecipe(Items.sapphireLeggings.itemID, new ItemStack(Items.infusedSapphireLeggings, 1));
        this.addAltarRecipe(Items.sapphireBoots.itemID, new ItemStack(Items.infusedSapphireBoots, 1));
        this.addAltarRecipe(Items.topazHelmet.itemID, new ItemStack(Items.infusedTopazHelmet, 1));
        this.addAltarRecipe(Items.topazChestplate.itemID, new ItemStack(Items.infusedTopazChestplate, 1));
        this.addAltarRecipe(Items.topazLeggings.itemID, new ItemStack(Items.infusedTopazLeggings, 1));
        this.addAltarRecipe(Items.topazBoots.itemID, new ItemStack(Items.infusedTopazBoots, 1));
        this.addAltarRecipe(Items.dragonHelmet.itemID, new ItemStack(Items.infusedDragonHelmet, 1));
        this.addAltarRecipe(Items.dragonChestplate.itemID, new ItemStack(Items.infusedDragonChestplate, 1));
        this.addAltarRecipe(Items.dragonLeggings.itemID, new ItemStack(Items.infusedDragonLeggings, 1));
        this.addAltarRecipe(Items.dragonBoots.itemID, new ItemStack(Items.infusedDragonBoots, 1));
        this.addAltarRecipe(Items.dragonPickaxe.itemID, new ItemStack(Items.infusedDragonPickaxe, 1));
        this.addAltarRecipe(Items.dragonAxe.itemID, new ItemStack(Items.infusedDragonAxe, 1));
        this.addAltarRecipe(Items.dragonShovel.itemID, new ItemStack(Items.infusedDragonShovel, 1));
        this.addAltarRecipe(Items.dragonSword.itemID, new ItemStack(Items.infusedDragonSword, 1));
        this.addAltarRecipe(Items.blindoniteHelmet.itemID, new ItemStack(Items.infusedBlindoniteHelmet, 1));
        this.addAltarRecipe(Items.blindoniteChestplate.itemID, new ItemStack(Items.infusedBlindoniteChestplate, 1));
        this.addAltarRecipe(Items.blindoniteLeggings.itemID, new ItemStack(Items.infusedBlindoniteLeggings, 1));
        this.addAltarRecipe(Items.blindoniteBoots.itemID, new ItemStack(Items.infusedBlindoniteBoots, 1));
        this.addAltarRecipe(Items.blindonitePickaxe.itemID, new ItemStack(Items.infusedBlindonitePickaxe, 1));
        this.addAltarRecipe(Items.blindoniteAxe.itemID, new ItemStack(Items.infusedBlindoniteAxe, 1));
        this.addAltarRecipe(Items.blindoniteShovel.itemID, new ItemStack(Items.infusedBlindoniteShovel, 1));
        this.addAltarRecipe(Items.blindoniteSword.itemID, new ItemStack(Items.infusedBlindoniteSword, 1));
        this.addAltarRecipe(Item.appleRed.itemID, new ItemStack(Items.blueMagicApple, 1));
        this.addAltarRecipe(Items.vraviniteHelmet.itemID, new ItemStack(Items.infusedVraviniteHelmet, 1));
        this.addAltarRecipe(Items.vraviniteChestplate.itemID, new ItemStack(Items.infusedVraviniteChestplate, 1));
        this.addAltarRecipe(Items.vraviniteLeggings.itemID, new ItemStack(Items.infusedVraviniteLeggings, 1));
        this.addAltarRecipe(Items.vraviniteBoots.itemID, new ItemStack(Items.infusedVraviniteBoots, 1));
        this.addAltarRecipe(Items.vravinitePickaxe.itemID, new ItemStack(Items.infusedVravinitePickaxe, 1));
        this.addAltarRecipe(Items.vraviniteAxe.itemID, new ItemStack(Items.infusedVraviniteAxe, 1));
        this.addAltarRecipe(Items.vraviniteShovel.itemID, new ItemStack(Items.infusedVraviniteShovel, 1));
        this.addAltarRecipe(Items.vraviniteSword.itemID, new ItemStack(Items.infusedVraviniteSword, 1));
        
        if(TheMistsOfRioV.getInstance().aether)
        {
        	try 
        	{
	            Class<?> clAetherItems = Class.forName("net.aetherteam.aether.items.AetherItems");
	
	            this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("SkyrootPickaxe").get(null)).itemID, new ItemStack(Items.infusedSkyrootPickaxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("SkyrootAxe").get(null)).itemID, new ItemStack(Items.infusedSkyrootAxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("SkyrootShovel").get(null)).itemID, new ItemStack(Items.infusedSkyrootShovel, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("SkyrootSword").get(null)).itemID, new ItemStack(Items.infusedSkyrootSword, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("HolystonePickaxe").get(null)).itemID, new ItemStack(Items.infusedHolystonePickaxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("HolystoneAxe").get(null)).itemID, new ItemStack(Items.infusedHolystoneAxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("HolystoneShovel").get(null)).itemID, new ItemStack(Items.infusedHolystoneShovel, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("HolystoneSword").get(null)).itemID, new ItemStack(Items.infusedHolystoneSword, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZanitePickaxe").get(null)).itemID, new ItemStack(Items.infusedZanitePickaxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZaniteAxe").get(null)).itemID, new ItemStack(Items.infusedZaniteAxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZaniteShovel").get(null)).itemID, new ItemStack(Items.infusedZaniteShovel, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZaniteSword").get(null)).itemID, new ItemStack(Items.infusedZaniteSword, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititePickaxe").get(null)).itemID, new ItemStack(Items.infusedGravititePickaxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititeAxe").get(null)).itemID, new ItemStack(Items.infusedGravititeAxe, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititeShovel").get(null)).itemID, new ItemStack(Items.infusedGravititeShovel, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititeSword").get(null)).itemID, new ItemStack(Items.infusedGravititeSword, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititeHelmet").get(null)).itemID, new ItemStack(Items.infusedGravititeHelmet, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititeChestplate").get(null)).itemID, new ItemStack(Items.infusedGravititeChestplate, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititeLeggings").get(null)).itemID, new ItemStack(Items.infusedGravititeLeggings, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("GravititeBoots").get(null)).itemID, new ItemStack(Items.infusedGravititeBoots, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZaniteHelmet").get(null)).itemID, new ItemStack(Items.infusedZaniteHelmet, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZaniteChestplate").get(null)).itemID, new ItemStack(Items.infusedZaniteChestplate, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZaniteLeggings").get(null)).itemID, new ItemStack(Items.infusedZaniteLeggings, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("ZaniteBoots").get(null)).itemID, new ItemStack(Items.infusedZaniteBoots, 1));
				this.addAltarRecipe(((Item)clAetherItems.getDeclaredField("BlueBerry").get(null)).itemID, new ItemStack(Items.magicalBlueBerry, 1));
        	} catch(Exception e){}
        }
        
        if(TheMistsOfRioV.getInstance().natura)
        {
        	try {
	            Class<?> clNContent = Class.forName("mods.natura.common.NContent");
	
	        	this.addAltarRecipe(((Item)clNContent.getDeclaredField("bloodwoodPickaxe").get(null)).itemID, new ItemStack(Items.infusedBloodwoodPickaxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("bloodwoodAxe").get(null)).itemID, new ItemStack(Items.infusedBloodwoodAxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("bloodwoodShovel").get(null)).itemID, new ItemStack(Items.infusedBloodwoodShovel, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("bloodwoodSword").get(null)).itemID, new ItemStack(Items.infusedBloodwoodSword, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("ghostwoodPickaxe").get(null)).itemID, new ItemStack(Items.infusedGhostwoodPickaxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("ghostwoodAxe").get(null)).itemID, new ItemStack(Items.infusedGhostwoodAxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("ghostwoodShovel").get(null)).itemID, new ItemStack(Items.infusedGhostwoodShovel, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("ghostwoodSword").get(null)).itemID, new ItemStack(Items.infusedGhostwoodSword, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("darkwoodPickaxe").get(null)).itemID, new ItemStack(Items.infusedDarkwoodPickaxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("darkwoodAxe").get(null)).itemID, new ItemStack(Items.infusedDarkwoodAxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("darkwoodShovel").get(null)).itemID, new ItemStack(Items.infusedDarkwoodShovel, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("darkwoodSword").get(null)).itemID, new ItemStack(Items.infusedDarkwoodSword, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("netherquartzPickaxe").get(null)).itemID, new ItemStack(Items.infusedNetherquartzPickaxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("netherquartzAxe").get(null)).itemID, new ItemStack(Items.infusedNetherquartzAxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("netherquartzShovel").get(null)).itemID, new ItemStack(Items.infusedNetherquartzShovel, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("netherquartzSword").get(null)).itemID, new ItemStack(Items.infusedNetherquartzSword, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("fusewoodPickaxe").get(null)).itemID, new ItemStack(Items.infusedFusewoodPickaxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("fusewoodAxe").get(null)).itemID, new ItemStack(Items.infusedFusewoodAxe, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("fusewoodShovel").get(null)).itemID, new ItemStack(Items.infusedFusewoodShovel, 1));
				this.addAltarRecipe(((Item)clNContent.getDeclaredField("fusewoodSword").get(null)).itemID, new ItemStack(Items.infusedFusewoodSword, 1));
        	} catch(Exception e){}
        }

    }

	public void addAltarRecipe(int par1, ItemStack par2ItemStack)
    {
        this.AltarList.put(Integer.valueOf(par1), par2ItemStack);
    }
	
    public Map getSmeltingList()
    {
        return this.AltarList;
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
        return (ItemStack)AltarList.get(Integer.valueOf(item.itemID));
    }
}
