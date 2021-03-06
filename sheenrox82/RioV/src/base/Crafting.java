package sheenrox82.RioV.src.base;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.recipe.MagicBinderCraftingManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class Crafting 
{
	public static String[] helmet = new String[] {"XXX", "X X"};
	public static String[] chestplate = new String[] {"X X", "XXX", "XXX"};
	public static String[] leggings = new String[] {"XXX", "X X", "X X"};
	public static String[] boots = new String[] {"X X", "X X"};
	public static String[] bricks = new String[] {"XX"};
	
	public static void add()
	{
		GameRegistry.addRecipe(new ItemStack(Blocks.infuser, 1), "XXX", "XAX", "XXX", Character.valueOf('X'), Block.obsidian, Character.valueOf('A'), Items.orb);
		GameRegistry.addRecipe(new ItemStack(Items.terronCrystal, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), Items.onyx, Character.valueOf('A'), Items.baseCrystal, Character.valueOf('Z'), Items.blindonite);
		GameRegistry.addRecipe(new ItemStack(Items.demonAngelCrystal, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), Items.onyx, Character.valueOf('A'), Items.baseCrystal, Character.valueOf('Z'), Items.nironite);
		GameRegistry.addRecipe(new ItemStack(Blocks.onyxBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.onyx);
		GameRegistry.addRecipe(new ItemStack(Blocks.amethystBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.amethyst);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 0), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 15)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 1), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 14)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 2), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 13)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 3), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 12)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 4), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 11)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 5), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 10)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 6), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 9)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 7), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 8)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 8), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 7)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 9), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 6)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 10), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 5)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 11), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 4)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 12), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 3)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 13), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 2)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 14), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.plankColored, 1, 15), new Object[] {Block.planks,  new ItemStack(Item.dyePowder, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Blocks.blackQuartz, 1, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.burnedQuartz);
		GameRegistry.addRecipe(new ItemStack(Blocks.garnetBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.garnet);
		GameRegistry.addRecipe(new ItemStack(Blocks.nironiteBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.nironite);
		GameRegistry.addRecipe(new ItemStack(Blocks.dragonBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.dragonSoul);
		GameRegistry.addSmelting(Items.horseMeat.itemID, new ItemStack(Items.cookedHorseMeat, 1), 1F);
		GameRegistry.addRecipe(new ItemStack(Items.wineGlass, 1), "X X", " X ", "XXX", Character.valueOf('X'), Block.glass);
		GameRegistry.addRecipe(new ItemStack(Items.potionGlass, 1), " X ", "X X", "XXX", Character.valueOf('X'), Block.glass);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.wine, 1), new Object[] {Items.grapes, Items.wineGlass});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.pepperSpices, 1), new Object[] {Items.pepper});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.spicedWine, 1), new Object[] {Items.pepperSpices, Items.wine});
		GameRegistry.addRecipe(new ItemStack(Items.onyx, 9), "X", Character.valueOf('X'), Blocks.onyxBlock);
		GameRegistry.addRecipe(new ItemStack(Items.amethyst, 9), "X", Character.valueOf('X'), Blocks.amethystBlock);
		GameRegistry.addRecipe(new ItemStack(Items.burnedQuartz, 9), "X", Character.valueOf('X'), new ItemStack(Blocks.blackQuartz, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Items.garnet, 9), "X", Character.valueOf('X'), Blocks.garnetBlock);
		GameRegistry.addRecipe(new ItemStack(Items.nironite, 9), "X", Character.valueOf('X'), Blocks.nironiteBlock);
		GameRegistry.addRecipe(new ItemStack(Items.dragonSoul, 9), "X", Character.valueOf('X'), Blocks.dragonBlock);
		GameRegistry.addRecipe(new ItemStack(Items.sapphire, 9), "X", Character.valueOf('X'), Blocks.sapphireBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.sapphireBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.sapphire);
		GameRegistry.addRecipe(new ItemStack(Blocks.opalBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.opal);
		GameRegistry.addRecipe(new ItemStack(Blocks.topazBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.topaz);
		GameRegistry.addRecipe(new ItemStack(Items.opal, 9), "X", Character.valueOf('X'), Blocks.opalBlock);
		GameRegistry.addRecipe(new ItemStack(Items.topaz, 9), "X", Character.valueOf('X'), Blocks.topazBlock);
		GameRegistry.addRecipe(new ItemStack(Items.theDarknessCrystal, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), Items.onyx, Character.valueOf('A'), Items.baseCrystal, Character.valueOf('Z'), Items.vulron);
		GameRegistry.addRecipe(new ItemStack(Blocks.lamp, 1), "XZX", "ZAZ", "XZX", Character.valueOf('X'), Block.planks, Character.valueOf('A'), Block.torchWood, Character.valueOf('Z'), Block.glass);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.purpleFeather, 1), new Object[] {Item.feather, new ItemStack(Item.dyePowder, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(Items.darknessArrow, 5), "  *", " D ", "X  ", Character.valueOf('*'), Items.ingotOfFlame, Character.valueOf('D'), Items.blackBone, Character.valueOf('X'), Items.purpleFeather);
		GameRegistry.addRecipe(new ItemStack(Items.blindOasisActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), Items.onyx, Character.valueOf('X'), new ItemStack(Blocks.blackQuartz, 1, 1));
		GameRegistry.addRecipe(new ItemStack(Blocks.blindoniteBlock, 1), "XX", "XX", Character.valueOf('X'), Items.blindonite);
		GameRegistry.addRecipe(new ItemStack(Items.vaerynActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), Items.blindonite, Character.valueOf('X'), Blocks.blindoniteBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.glimmerwoodPlanks, 4), new Object[] {Blocks.glimmerwoodLog});
		GameRegistry.addRecipe(new ItemStack(Blocks.glimmerwoodWorkbench, 1), "XX", "XX", Character.valueOf('X'), Blocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Items.glimmerwoodSticks, 4), "X", "X", Character.valueOf('X'), Blocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.glimmerwoodFence, 2), "XXX", "XXX", Character.valueOf('X'), Items.glimmerwoodSticks);
		GameRegistry.addRecipe(new ItemStack(Blocks.glimmerwoodFenceGate, 1), "XOX", "XOX", Character.valueOf('X'), Items.glimmerwoodSticks, Character.valueOf('O'), Blocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Items.glimmerwoodDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), Blocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.glimmerwoodTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), Blocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.glimmerwoodLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), Items.glimmerwoodSticks);
		GameRegistry.addRecipe(new ItemStack(Items.flamonorActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), Items.onyx, Character.valueOf('X'), Blocks.bloodRock);
		GameRegistry.addRecipe(new ItemStack(Blocks.glimmerwoodChest, 1), "XXX", "X X", "XXX", Character.valueOf('X'), Blocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.slateBricks, 4), "XX", "XX", Character.valueOf('X'), Blocks.slate);
		GameRegistry.addRecipe(new ItemStack(Blocks.slate, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.slateFragment);
		GameRegistry.addSmelting(Blocks.slateCobble.blockID, new ItemStack(Blocks.slate, 1), 1F);
		GameRegistry.addSmelting(Blocks.slateBricks.blockID, new ItemStack(Items.slateFragment, 1), 0.1F);
		GameRegistry.addRecipe(new ItemStack(Blocks.cherryPlanks, 4), "X", Character.valueOf('X'), Blocks.cherryLog);
		GameRegistry.addRecipe(new ItemStack(Blocks.cherryWorkbench, 1), "XX", "XX", Character.valueOf('X'), Blocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(Items.cherryBlossomDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), Blocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.cherryBlossomTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), Blocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.cherryBlossomLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), Items.cherryBlossomSticks);
		GameRegistry.addRecipe(new ItemStack(Blocks.cherryBlossomFenceGate, 1), "XOX", "XOX", Character.valueOf('O'), Blocks.cherryPlanks,  Character.valueOf('X'), Items.cherryBlossomSticks);
		GameRegistry.addRecipe(new ItemStack(Items.cherryBlossomSticks, 4), "X", "X", Character.valueOf('X'), Blocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.cherryBlossomChest, 1), "XXX", "X X", "XXX", Character.valueOf('X'), Blocks.cherryPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.cherryBlossomFence, 2), "XXX", "XXX", Character.valueOf('X'), Items.cherryBlossomSticks);
		GameRegistry.addRecipe(new ItemStack(Items.sanctuatiteActivator, 1), "  *", " X ", "*  ", Character.valueOf('*'), Items.drakiuz, Character.valueOf('X'), Blocks.blindoniteBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.skywoodPlanks, 4), "X", Character.valueOf('X'), Blocks.skywoodLog);
		GameRegistry.addRecipe(new ItemStack(Blocks.skywoodWorkbench, 1), "XX", "XX", Character.valueOf('X'), Blocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Items.skywoodDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), Blocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.skywoodTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), Blocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.skywoodLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), Items.skywoodSticks);
		GameRegistry.addRecipe(new ItemStack(Blocks.skywoodFenceGate, 1), "XOX", "XOX", Character.valueOf('O'), Blocks.skywoodPlanks,  Character.valueOf('X'), Items.skywoodSticks);
		GameRegistry.addRecipe(new ItemStack(Items.skywoodSticks, 4), "X", "X", Character.valueOf('X'), Blocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.skywoodChest, 1), "XXX", "X X", "XXX", Character.valueOf('X'), Blocks.skywoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.skywoodFence, 2), "XXX", "XXX", Character.valueOf('X'), Items.skywoodSticks);
		GameRegistry.addRecipe(new ItemStack(Blocks.bloodPlanks, 4), "X", Character.valueOf('X'), Blocks.bloodLog);
		GameRegistry.addRecipe(new ItemStack(Blocks.bloodWorkbench, 1), "XX", "XX", Character.valueOf('X'), Blocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(Items.bloodDoorItem, 1), "XX", "XX", "XX", Character.valueOf('X'), Blocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.bloodTrapdoor, 2), "XXX", "XXX", Character.valueOf('X'), Blocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.bloodLadder, 3), "X X", "XXX", "X X", Character.valueOf('X'), Items.bloodSticks);
		GameRegistry.addRecipe(new ItemStack(Blocks.bloodFenceGate, 1), "XOX", "XOX", Character.valueOf('O'), Blocks.bloodPlanks,  Character.valueOf('X'), Items.bloodSticks);
		GameRegistry.addRecipe(new ItemStack(Items.bloodSticks, 4), "X", "X", Character.valueOf('X'), Blocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.bloodChest, 1), "XXX", "X X", "XXX", Character.valueOf('X'), Blocks.bloodPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.bloodFence, 2), "XXX", "XXX", Character.valueOf('X'), Items.bloodSticks);
		GameRegistry.addRecipe(new ItemStack(Blocks.anvil, 1), "XOX", "XXX", Character.valueOf('X'), Blocks.slateBricks, Character.valueOf('O'), new ItemStack(Block.cloth, 1, 14));
		GameRegistry.addRecipe(new ItemStack(Items.voidHolder, 1), "X X", " X ", Character.valueOf('X'), Items.onyx);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bambooPlanks, 2), new Object[] {Items.bambooItem});
		GameRegistry.addRecipe(new ItemStack(Blocks.bambooFloorboard, 3), "XXX",  Character.valueOf('X'), Items.bambooPlanks);
		GameRegistry.addRecipe(new ItemStack(Blocks.jaavikBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.jaavik);
		GameRegistry.addRecipe(new ItemStack(Items.jaavik, 9), "X", Character.valueOf('X'), Blocks.jaavikBlock);
		GameRegistry.addRecipe(new ItemStack(Items.blindonite, 4), "X", Character.valueOf('X'), Blocks.blindoniteBlock);
		GameRegistry.addRecipe(new ItemStack(Items.glimmerwoodBucket, 1), "X X", " X ", Character.valueOf('X'), Blocks.glimmerwoodPlanks);
		GameRegistry.addRecipe(new ItemStack(Items.bloodBucket, 1), "X X", " X ", Character.valueOf('X'), Blocks.bloodPlanks);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.chain, 3), new Object[] {Item.ingotIron, Item.ingotIron, Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(Item.helmetChain, 1), new Object[] { helmet, Character.valueOf('X'), Items.chain});
		GameRegistry.addRecipe(new ItemStack(Item.plateChain, 1), new Object[] { chestplate, Character.valueOf('X'), Items.chain});
		GameRegistry.addRecipe(new ItemStack(Item.legsChain, 1), new Object[] { leggings, Character.valueOf('X'), Items.chain});
		GameRegistry.addRecipe(new ItemStack(Item.bootsChain, 1), new Object[] { boots, Character.valueOf('X'), Items.chain});
		GameRegistry.addRecipe(new ItemStack(Items.scroll, 1), new Object[] { "X", Character.valueOf('X'), Item.paper});
		MagicBinderCraftingManager.instance.addShapelessRecipe(new ItemStack(Items.scrollFireI, 1), new Object[]{Items.scroll, Item.blazePowder, Item.blazePowder, Item.blazePowder, Item.blazePowder, Item.blazePowder});
		MagicBinderCraftingManager.instance.addShapelessRecipe(new ItemStack(Items.scrollFireII, 1), new Object[]{Items.scrollFireI, Item.blazePowder, Item.blazePowder, Item.blazePowder, Item.blazePowder, Item.blazePowder});
		MagicBinderCraftingManager.instance.addShapelessRecipe(new ItemStack(Items.scrollEverlight, 1), new Object[]{Items.scroll, Item.enderPearl, Item.enderPearl, Item.enderPearl, Item.enderPearl, Item.enderPearl});
		MagicBinderCraftingManager.instance.addShapelessRecipe(new ItemStack(Items.scrollWindI, 1), new Object[]{Items.scroll, Items.windElement, Items.windElement, Items.windElement, Items.windElement, Items.windElement});
		GameRegistry.addRecipe(new ItemStack(Blocks.alerisBlock, 1), "XXX", "XXX", "XXX", Character.valueOf('X'), Items.aleris);
		GameRegistry.addRecipe(new ItemStack(Items.aleris, 9), "X", Character.valueOf('X'), Blocks.alerisBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 0), bricks, Character.valueOf('X'), Blocks.sapphireBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 1), bricks, Character.valueOf('X'), Blocks.topazBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 2), bricks, Character.valueOf('X'), Blocks.amethystBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 3), bricks, Character.valueOf('X'), Blocks.onyxBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 4), bricks, Character.valueOf('X'), Blocks.blindoniteBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 5), bricks, Character.valueOf('X'), Blocks.dragonBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 6), bricks, Character.valueOf('X'), Blocks.vraviniteBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 7), bricks, Character.valueOf('X'), Blocks.alerisBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 8), bricks, Character.valueOf('X'), Blocks.jaavikBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 9), bricks, Character.valueOf('X'), Blocks.nironiteBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 10), bricks, Character.valueOf('X'), Blocks.garnetBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.bricks, 2, 11), bricks, Character.valueOf('X'), Blocks.drakiuzBlock);
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stainedGlass, 1, 0), new Object[] {new ItemStack(Item.dyePowder, 1, 6), new ItemStack(Item.dyePowder, 1, 10), new ItemStack(Item.dyePowder, 1, 11), Block.glass});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stainedGlass, 1, 1), new Object[] {new ItemStack(Item.dyePowder, 1, 1), new ItemStack(Item.dyePowder, 1, 5), new ItemStack(Item.dyePowder, 1, 12),  new ItemStack(Item.dyePowder, 1, 10), Block.glass});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stainedGlass, 1, 2), new Object[] {new ItemStack(Item.dyePowder, 1, 13), new ItemStack(Item.dyePowder, 1, 14), new ItemStack(Item.dyePowder, 1, 11), new ItemStack(Item.dyePowder, 1, 12),  new ItemStack(Item.dyePowder, 1, 1), Block.glass});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.stainedGlass, 1, 3), new Object[] {new ItemStack(Item.dyePowder, 1, 0),  new ItemStack(Item.dyePowder, 1, 1), Block.glass});
		GameRegistry.addRecipe(new ItemStack(Blocks.abstractor, 1), "XXX", "XOX", "XXX", Character.valueOf('X'), Blocks.slateBricks, Character.valueOf('O'), Blocks.runestone);
		GameRegistry.addRecipe(new ItemStack(Items.smallBag, 1), "XXX", "X X", "XXX", Character.valueOf('X'), Item.leather);
		GameRegistry.addRecipe(new ItemStack(Items.mediumBag, 1), "XXX", "XOX", "XXX", Character.valueOf('X'), Item.leather, Character.valueOf('O'), Items.smallBag);
		GameRegistry.addRecipe(new ItemStack(Items.largeBag, 1), "XXX", "XOX", "XXX", Character.valueOf('X'), Item.leather, Character.valueOf('O'), Items.mediumBag);
		GameRegistry.addRecipe(new ItemStack(Items.sheenBag, 1), "XXX", "XOX", "XXX", Character.valueOf('X'), Item.leather, Character.valueOf('O'), Items.largeBag);
		GameRegistry.addRecipe(new ItemStack(Blocks.magicBinder, 1), "XXX", "XOX", "XXX", Character.valueOf('O'), Items.orb, Character.valueOf('X'), Blocks.onyxBlock);
		GameRegistry.addRecipe(new ItemStack(Items.auntunSummoner, 1), "XTX", "TOT", "XTX", Character.valueOf('O'), Items.onyx, Character.valueOf('X'), Items.darkMatter, Character.valueOf('T'), Blocks.skycloud);
		GameRegistry.addRecipe(new ItemStack(Blocks.chocolateCake, 1), "XXX", "XOX", "XXX", Character.valueOf('O'), Item.cake, Character.valueOf('X'), new ItemStack(Item.dyePowder, 1, 4));
	}
}
