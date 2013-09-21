package sheenrox82.RioV.src.recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;

public class AnvilCraftingManager
{
	public String[] pickaxe = new String[] {"XXX", " ! ", " ! ", " ! "};
	public String[] sword = new String[] {" X ", " X ", "XXX", " ! ",};
	public String[] shovel = new String[] {"X", "!", "!", "!"};
	public String[] axe = new String[] {"XX", "X!", " !", " !"};
	public String[] dagger = new String[] {"X", "!"};
	
	public String[] helmet = new String[] {"XXX", "X X"};
	public String[] chestplate = new String[] {"X X", "XXX", "XXX"};
	public String[] leggings = new String[] {"XXX", "X X", "X X"};
	public String[] boots = new String[] {"X X", "X X"};
	public String[] shield = { "X X", "XXX", " X " };
	
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	private static final AnvilCraftingManager instance = new AnvilCraftingManager();
	public static List recipes = new ArrayList();

	public static final AnvilCraftingManager getInstance()
	{
		return instance;
	}

	private AnvilCraftingManager()
	{
		recipes = new ArrayList();

		this.addRecipe(new ItemStack(Items.amethystPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.amethyst, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.amethystSword, 1), new Object[] { sword, Character.valueOf('X'), Items.amethyst, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.amethystShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.amethyst, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.amethystAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.amethyst, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.onyxPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.onyx, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.onyxSword, 1), new Object[] { sword, Character.valueOf('X'), Items.onyx, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.onyxShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.onyx, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.onyxAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.onyx, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.sapphirePickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.sapphire, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.sapphireSword, 1), new Object[] { sword, Character.valueOf('X'), Items.sapphire, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.sapphireShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.sapphire, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.sapphireAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.sapphire, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.topazPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.topaz, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.topazSword, 1), new Object[] { sword, Character.valueOf('X'), Items.topaz, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.topazShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.topaz, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.topazAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.topaz, Character.valueOf('!'), Item.stick});
		this.addRecipe(new ItemStack(Items.nizonianBlade, 1), new Object[] { dagger, Character.valueOf('X'), Item.ingotGold, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.bladeOfAni, 1), new Object[] { dagger, Character.valueOf('X'), Item.ingotIron, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.dragonPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.dragonSoul, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.dragonSword, 1), new Object[] { sword, Character.valueOf('X'), Items.dragonSoul, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.dragonShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.dragonSoul, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.dragonAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.dragonSoul, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.agonitePickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.agonite, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.galokinSword, 1), new Object[] { sword, Character.valueOf('X'), Items.galokinCrystal, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.blindonitePickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.blindonite, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.blindoniteSword, 1), new Object[] { sword, Character.valueOf('X'), Items.blindonite, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.blindoniteShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.blindonite, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.blindoniteAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.blindonite, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.vravinitePickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.vravinite, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.vraviniteSword, 1), new Object[] { sword, Character.valueOf('X'), Items.vravinite, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.vraviniteShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.vravinite, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.vraviniteAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.vravinite, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.cherryBlossomPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Blocks.cherryPlanks, Character.valueOf('!'), Items.cherryBlossomSticks});
		this.addRecipe(new ItemStack(Items.cherryBlossomSword, 1), new Object[] { sword, Character.valueOf('X'), Blocks.cherryPlanks, Character.valueOf('!'), Items.cherryBlossomSticks});
		this.addRecipe(new ItemStack(Items.cherryBlossomShovel, 1), new Object[] { shovel, Character.valueOf('X'), Blocks.cherryPlanks, Character.valueOf('!'), Items.cherryBlossomSticks});
		this.addRecipe(new ItemStack(Items.cherryBlossomAxe, 1), new Object[] { axe, Character.valueOf('X'), Blocks.cherryPlanks, Character.valueOf('!'), Items.cherryBlossomSticks});
		this.addRecipe(new ItemStack(Items.glimmerwoodPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Blocks.glimmerwoodPlanks, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.glimmerwoodSword, 1), new Object[] { sword, Character.valueOf('X'), Blocks.glimmerwoodPlanks, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.glimmerwoodShovel, 1), new Object[] { shovel, Character.valueOf('X'), Blocks.glimmerwoodPlanks, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.glimmerwoodAxe, 1), new Object[] { axe, Character.valueOf('X'), Blocks.glimmerwoodPlanks, Character.valueOf('!'), Items.glimmerwoodSticks});
		this.addRecipe(new ItemStack(Items.khuulisScythe, 1), "X  ", " Z ", "  X", Character.valueOf('X'), Item.ingotIron, Character.valueOf('Z'), Items.blackBone);
		this.addRecipe(new ItemStack(Items.bowOfWurTun, 1), " XC", "D C", " XC", Character.valueOf('X'), Item.ingotGold, Character.valueOf('C'), Item.silk, Character.valueOf('D'), Items.blackBone);
		this.addRecipe(new ItemStack(Items.shifter, 1), "XXX", Character.valueOf('X'), Item.ingotIron);
		this.addRecipe(new ItemStack(Items.slateHandaxe, 1), "XXX", "X* ", " * ", " * ", Character.valueOf('X'), Items.slateFragment, Character.valueOf('*'), Items.blackBone);
		this.addRecipe(new ItemStack(Items.sharpenedSlateHandaxe, 1), "X*", Character.valueOf('*'), Items.slateHandaxe, Character.valueOf('X'), Items.burnedQuartz);
		this.addRecipe(new ItemStack(Items.enforcedBowOfWurTun, 1), " XC", "DOC", " XC", Character.valueOf('X'), Item.ingotGold, Character.valueOf('C'), Item.silk, Character.valueOf('D'), Items.blackBone, Character.valueOf('O'), Items.bowOfWurTun);
		this.addRecipe(new ItemStack(Items.longbow, 1), " XC", "XOC", " XC", Character.valueOf('X'), Item.stick, Character.valueOf('C'), Item.silk, Character.valueOf('O'), Item.bow);
		this.addRecipe(new ItemStack(Items.skywoodPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Blocks.skywoodPlanks, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.skywoodSword, 1), new Object[] { sword, Character.valueOf('X'), Blocks.skywoodPlanks, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.skywoodShovel, 1), new Object[] { shovel, Character.valueOf('X'), Blocks.skywoodPlanks, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.skywoodAxe, 1), new Object[] { axe, Character.valueOf('X'), Blocks.skywoodPlanks, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.bloodPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Blocks.bloodPlanks, Character.valueOf('!'), Items.bloodSticks});
		this.addRecipe(new ItemStack(Items.bloodSword, 1), new Object[] { sword, Character.valueOf('X'), Blocks.bloodPlanks, Character.valueOf('!'), Items.bloodSticks});
		this.addRecipe(new ItemStack(Items.bloodShovel, 1), new Object[] { shovel, Character.valueOf('X'), Blocks.bloodPlanks, Character.valueOf('!'), Items.bloodSticks});
		this.addRecipe(new ItemStack(Items.bloodAxe, 1), new Object[] { axe, Character.valueOf('X'), Blocks.bloodPlanks, Character.valueOf('!'), Items.bloodSticks});
		this.addRecipe(new ItemStack(Items.alerisPickaxe, 1), new Object[] { pickaxe, Character.valueOf('X'), Items.aleris, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.alerisSword, 1), new Object[] { sword, Character.valueOf('X'), Items.aleris, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.alerisShovel, 1), new Object[] { shovel, Character.valueOf('X'), Items.aleris, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.alerisAxe, 1), new Object[] { axe, Character.valueOf('X'), Items.aleris, Character.valueOf('!'), Items.skywoodSticks});
		this.addRecipe(new ItemStack(Items.daetoriSword, 1), new Object[] { " X ", " X ", "!!!", " X ", Character.valueOf('X'), Items.blackBone, Character.valueOf('!'), Item.ingotIron});
		this.addRecipe(new ItemStack(Items.sorrowSword, 1), new Object[] { " X ", " X ", "XXX", " X ", Character.valueOf('X'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.UnfusedaxeOfAunTun, 1), new Object[] { "XOX", "X!X", " ! ", "*!*", Character.valueOf('X'), Items.vulron, Character.valueOf('!'), Items.blackBone, Character.valueOf('O'), Items.darkMatter, Character.valueOf('*'), Items.clothOfMagic});
		this.addRecipe(new ItemStack(Items.vulronSword, 1), new Object[] { sword, Character.valueOf('X'), Items.vulron, Character.valueOf('!'), Items.blackBone});
		this.addRecipe(new ItemStack(Items.swordOfFlame, 1), "*", "*", "*", Character.valueOf('*'), Items.ingotOfFlame);

		this.addRecipe(new ItemStack(Items.onyxHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.onyx});
		this.addRecipe(new ItemStack(Items.onyxChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.onyx});
		this.addRecipe(new ItemStack(Items.onyxLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.onyx});
		this.addRecipe(new ItemStack(Items.onyxBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.onyx});
		this.addRecipe(new ItemStack(Items.amethystHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.amethyst});
		this.addRecipe(new ItemStack(Items.amethystChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.amethyst});
		this.addRecipe(new ItemStack(Items.amethystLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.amethyst});
		this.addRecipe(new ItemStack(Items.amethystBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.amethyst});
		this.addRecipe(new ItemStack(Items.sapphireHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.sapphire});
		this.addRecipe(new ItemStack(Items.sapphireChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.sapphire});
		this.addRecipe(new ItemStack(Items.sapphireLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.sapphire});
		this.addRecipe(new ItemStack(Items.sapphireBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.sapphire});
		this.addRecipe(new ItemStack(Items.topazHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.topaz});
		this.addRecipe(new ItemStack(Items.topazChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.topaz});
		this.addRecipe(new ItemStack(Items.topazLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.topaz});
		this.addRecipe(new ItemStack(Items.topazBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.topaz});
		this.addRecipe(new ItemStack(Items.garnetHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.garnet});
		this.addRecipe(new ItemStack(Items.garnetChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.garnet});
		this.addRecipe(new ItemStack(Items.garnetLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.garnet});
		this.addRecipe(new ItemStack(Items.garnetBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.garnet});
		this.addRecipe(new ItemStack(Items.mythrilHelmet, 1), "XAX", "X*X", Character.valueOf('X'), Items.mythrilIngot, Character.valueOf('A'), Item.ingotIron, Character.valueOf('*'), Items.darkMatter);
		this.addRecipe(new ItemStack(Items.mythrilChestplate, 1), "X X", "XAX", "X*X", Character.valueOf('X'), Items.mythrilIngot, Character.valueOf('A'), Item.ingotIron, Character.valueOf('*'), Items.darkMatter);
		this.addRecipe(new ItemStack(Items.mythrilLeggings, 1), "X*X", "A A", "X X", Character.valueOf('X'), Items.mythrilIngot, Character.valueOf('A'), Item.ingotIron, Character.valueOf('*'), Items.darkMatter);
		this.addRecipe(new ItemStack(Items.mythrilBoots, 1), "A A", "X*X", Character.valueOf('X'), Items.mythrilIngot, Character.valueOf('A'), Item.ingotIron, Character.valueOf('*'), Items.darkMatter);
		this.addRecipe(new ItemStack(Items.dragonHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.dragonSoul});
		this.addRecipe(new ItemStack(Items.dragonChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.dragonSoul});
		this.addRecipe(new ItemStack(Items.dragonLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.dragonSoul});
		this.addRecipe(new ItemStack(Items.dragonBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.dragonSoul});
		this.addRecipe(new ItemStack(Items.galokinHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.galokinCrystal});
		this.addRecipe(new ItemStack(Items.galokinChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.galokinCrystal});
		this.addRecipe(new ItemStack(Items.galokinLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.galokinCrystal});
		this.addRecipe(new ItemStack(Items.galokinBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.galokinCrystal});
		this.addRecipe(new ItemStack(Items.blindoniteHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.blindonite});
		this.addRecipe(new ItemStack(Items.blindoniteChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.blindonite});
		this.addRecipe(new ItemStack(Items.blindoniteLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.blindonite});
		this.addRecipe(new ItemStack(Items.blindoniteBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.blindonite});
		this.addRecipe(new ItemStack(Items.helmetOfFlame, 1), new Object[] { helmet, Character.valueOf('X'), Items.ingotOfFlame});
		this.addRecipe(new ItemStack(Items.chestplateOfFlame, 1), new Object[] { chestplate, Character.valueOf('X'), Items.ingotOfFlame});
		this.addRecipe(new ItemStack(Items.leggingsOfFlame, 1), new Object[] { leggings, Character.valueOf('X'), Items.ingotOfFlame});
		this.addRecipe(new ItemStack(Items.bootsOfFlame, 1), new Object[] { boots, Character.valueOf('X'), Items.ingotOfFlame});
		this.addRecipe(new ItemStack(Items.vraviniteHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.vravinite});
		this.addRecipe(new ItemStack(Items.vraviniteChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.vravinite});
		this.addRecipe(new ItemStack(Items.vraviniteLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.vravinite});
		this.addRecipe(new ItemStack(Items.vraviniteBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.vravinite});
		this.addRecipe(new ItemStack(Items.magickaHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.clothOfMagic});
		this.addRecipe(new ItemStack(Items.magickaChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.clothOfMagic});
		this.addRecipe(new ItemStack(Items.magickaLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.clothOfMagic});
		this.addRecipe(new ItemStack(Items.magickaBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.clothOfMagic});
		this.addRecipe(new ItemStack(Items.alerisHelmet, 1), new Object[] { helmet, Character.valueOf('X'), Items.aleris});
		this.addRecipe(new ItemStack(Items.alerisChestplate, 1), new Object[] { chestplate, Character.valueOf('X'), Items.aleris});
		this.addRecipe(new ItemStack(Items.alerisLeggings, 1), new Object[] { leggings, Character.valueOf('X'), Items.aleris});
		this.addRecipe(new ItemStack(Items.alerisBoots, 1), new Object[] { boots, Character.valueOf('X'), Items.aleris});
		this.addRecipe(new ItemStack(Items.onyxShield, 1), shield, Character.valueOf('X'), Items.onyx);
		this.addRecipe(new ItemStack(Items.amethystShield, 1), shield, Character.valueOf('X'), Items.amethyst);
		this.addRecipe(new ItemStack(Items.vraviniteShield, 1), shield, Character.valueOf('X'), Items.vravinite);
		this.addRecipe(new ItemStack(Items.sapphireShield, 1), shield, Character.valueOf('X'), Items.sapphire);
		this.addRecipe(new ItemStack(Items.topazShield, 1), shield, Character.valueOf('X'), Items.topaz);
		this.addRecipe(new ItemStack(Items.shieldOfFlame, 1), shield, Character.valueOf('X'), Items.ingotOfFlame);
		this.addRecipe(new ItemStack(Items.blindoniteShield, 1), shield, Character.valueOf('X'), Items.blindonite);
		this.addRecipe(new ItemStack(Items.woodenShield, 1), shield, Character.valueOf('X'), Block.planks);
		this.addRecipe(new ItemStack(Items.stoneShield, 1), shield, Character.valueOf('X'), Block.cobblestone);
		this.addRecipe(new ItemStack(Items.ironShield, 1), shield, Character.valueOf('X'), Item.ingotIron);
		this.addRecipe(new ItemStack(Items.goldShield, 1), shield, Character.valueOf('X'), Item.ingotGold);
		this.addRecipe(new ItemStack(Items.diamondShield, 1), shield, Character.valueOf('X'), Item.diamond);
		this.addRecipe(new ItemStack(Items.dragonShield, 1), shield, Character.valueOf('X'), Items.dragonSoul);
		this.addRecipe(new ItemStack(Items.galokinShield, 1), shield, Character.valueOf('X'), Items.galokinCrystal);
		this.addRecipe(new ItemStack(Items.mythrilShield, 1), "X*X", "XOX", " X ", Character.valueOf('X'), Item.ingotIron, Character.valueOf('O'), Items.mythrilIngot, Character.valueOf('*'), Items.darkMatter);

		Collections.sort(this.recipes, new AnvilRecipeSorter(this));
		System.out.println(this.recipes.size() + " recipes");
	}

	public AnvilShapedRecipes addRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		String var3 = "";
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;

		if (par2ArrayOfObj[var4] instanceof String[])
		{
			String[] var7 = (String[])((String[])par2ArrayOfObj[var4++]);

			for (int var8 = 0; var8 < var7.length; ++var8)
			{
				String var9 = var7[var8];
				++var6;
				var5 = var9.length();
				var3 = var3 + var9;
			}
		}
		else
		{
			while (par2ArrayOfObj[var4] instanceof String)
			{
				String var11 = (String)par2ArrayOfObj[var4++];
				++var6;
				var5 = var11.length();
				var3 = var3 + var11;
			}
		}

		HashMap var12;

		for (var12 = new HashMap(); var4 < par2ArrayOfObj.length; var4 += 2)
		{
			Character var13 = (Character)par2ArrayOfObj[var4];
			ItemStack var14 = null;

			if (par2ArrayOfObj[var4 + 1] instanceof Item)
			{
				var14 = new ItemStack((Item)par2ArrayOfObj[var4 + 1]);
			}
			else if (par2ArrayOfObj[var4 + 1] instanceof Block)
			{
				var14 = new ItemStack((Block)par2ArrayOfObj[var4 + 1], 1, -1);
			}
			else if (par2ArrayOfObj[var4 + 1] instanceof ItemStack)
			{
				var14 = (ItemStack)par2ArrayOfObj[var4 + 1];
			}

			var12.put(var13, var14);
		}

		ItemStack[] var15 = new ItemStack[var5 * var6];

		for (int var16 = 0; var16 < var5 * var6; ++var16)
		{
			char var10 = var3.charAt(var16);

			if (var12.containsKey(Character.valueOf(var10)))
			{
				var15[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).copy();
			}
			else
			{
				var15[var16] = null;
			}
		}

		AnvilShapedRecipes var17 = new AnvilShapedRecipes(var5, var6, var15, par1ItemStack);
		this.recipes.add(var17);
		return var17;
	}

	public void addShapelessRecipe(ItemStack par1ItemStack, Object ... par2ArrayOfObj)
	{
		ArrayList var3 = new ArrayList();
		Object[] var4 = par2ArrayOfObj;
		int var5 = par2ArrayOfObj.length;

		for (int var6 = 0; var6 < var5; ++var6)
		{
			Object var7 = var4[var6];

			if (var7 instanceof ItemStack)
			{
				var3.add(((ItemStack)var7).copy());
			}
			else if (var7 instanceof Item)
			{
				var3.add(new ItemStack((Item)var7));
			}
			else
			{
				if (!(var7 instanceof Block))
				{
					throw new RuntimeException("Invalid shapeless recipe!");
				}

				var3.add(new ItemStack((Block)var7));
			}
		}

		this.recipes.add(new AnvilShapelessRecipes(par1ItemStack, var3));
	}

	public ItemStack findMatchingRecipe(InventoryCrafting par1InventoryCrafting, World par2World)
	{
		int var3 = 0;
		ItemStack var4 = null;
		ItemStack var5 = null;
		int var6;

		for (var6 = 0; var6 < par1InventoryCrafting.getSizeInventory(); ++var6)
		{
			ItemStack var7 = par1InventoryCrafting.getStackInSlot(var6);

			if (var7 != null)
			{
				if (var3 == 0)
				{
					var4 = var7;
				}

				if (var3 == 1)
				{
					var5 = var7;
				}

				++var3;
			}
		}

		if (var3 == 2 && var4.itemID == var5.itemID && var4.stackSize == 1 && var5.stackSize == 1 && Item.itemsList[var4.itemID].isRepairable())
		{
			Item var11 = Item.itemsList[var4.itemID];
			int var13 = var11.getMaxDamage() - var4.getItemDamageForDisplay();
			int var8 = var11.getMaxDamage() - var5.getItemDamageForDisplay();
			int var9 = var13 + var8 + var11.getMaxDamage() * 5 / 100;
			int var10 = var11.getMaxDamage() - var9;

			if (var10 < 0)
			{
				var10 = 0;
			}

			return new ItemStack(var4.itemID, 1, var10);
		}
		else
		{
			for (var6 = 0; var6 < this.recipes.size(); ++var6)
			{
				IRecipe var12 = (IRecipe)this.recipes.get(var6);

				if (var12.matches(par1InventoryCrafting, par2World))
				{
					return var12.getCraftingResult(par1InventoryCrafting);
				}
			}

			return null;
		}
	}

	/**
	 * returns the List<> of all recipes
	 */
	public List getRecipeList()
	{
		return this.recipes;
	}
}