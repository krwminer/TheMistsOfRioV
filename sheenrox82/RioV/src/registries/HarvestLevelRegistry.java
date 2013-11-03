package sheenrox82.RioV.src.registries;

import net.minecraftforge.common.MinecraftForge;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;

public class HarvestLevelRegistry 
{
	public static void addHarvestLevels()
	{
		//0's
		MinecraftForge.setBlockHarvestLevel(Blocks.infuser, "axe", 0);
		MinecraftForge.setBlockHarvestLevel(Blocks.infuser, "pickaxe", 0);
		//0's

		//1's
		MinecraftForge.setToolClass(Items.skywoodPickaxe, "pickaxe", 1);
		MinecraftForge.setToolClass(Items.skywoodAxe, "axe", 1);
		MinecraftForge.setToolClass(Items.skywoodShovel, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(Blocks.slate, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Blocks.sanctuaryStone, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Blocks.flamonorRock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Blocks.amethystOre, "pickaxe", 1);
		//1's

		//2's
		MinecraftForge.setToolClass(Items.glimmerwoodPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(Items.glimmerwoodAxe, "axe", 2);
		MinecraftForge.setToolClass(Items.glimmerwoodShovel, "shovel", 2);
		MinecraftForge.setToolClass(Items.cherryBlossomPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(Items.cherryBlossomAxe, "axe", 2);
		MinecraftForge.setToolClass(Items.cherryBlossomShovel, "shovel", 2);
		MinecraftForge.setToolClass(Items.bloodPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(Items.bloodAxe, "axe", 2);
		MinecraftForge.setToolClass(Items.bloodShovel, "shovel", 2);
		MinecraftForge.setToolClass(Items.sanctuaryStonePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(Items.sanctuaryStoneAxe, "axe", 2);
		MinecraftForge.setToolClass(Items.sanctuaryStoneShovel, "shovel", 2);
		MinecraftForge.setToolClass(Items.topazPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(Items.topazAxe, "axe", 2);
		MinecraftForge.setToolClass(Items.topazShovel, "shovel", 2);
		MinecraftForge.setToolClass(Items.sapphirePickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(Items.sapphireAxe, "axe", 2);
		MinecraftForge.setToolClass(Items.sapphireShovel, "shovel", 2);
		MinecraftForge.setBlockHarvestLevel(Blocks.sapphireOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(Blocks.topazOre, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(Blocks.onyxOre, "pickaxe", 2);
		//2's

		//3's
		MinecraftForge.setToolClass(Items.infusedTopazPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(Items.infusedTopazAxe, "axe", 3);
		MinecraftForge.setToolClass(Items.infusedTopazShovel, "shovel", 3);
		MinecraftForge.setToolClass(Items.amethystPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(Items.amethystAxe, "axe", 3);
		MinecraftForge.setToolClass(Items.amethystShovel, "shovel", 3);
		MinecraftForge.setToolClass(Items.onyxPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(Items.onyxAxe, "axe", 3);
		MinecraftForge.setToolClass(Items.onyxShovel, "shovel", 3);
		MinecraftForge.setToolClass(Items.infusedAmethystPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(Items.infusedAmethystAxe, "axe", 3);
		MinecraftForge.setToolClass(Items.infusedAmethystShovel, "shovel", 3);
		MinecraftForge.setBlockHarvestLevel(Blocks.garnetOre, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Blocks.bloodRock, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Blocks.blackRock, "pickaxe", 3);
		//3's

		//4's
		MinecraftForge.setToolClass(Items.infusedSapphirePickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(Items.infusedSapphireAxe, "axe", 4);
		MinecraftForge.setToolClass(Items.infusedSapphireShovel, "shovel", 4);
		MinecraftForge.setToolClass(Items.infusedOnyxPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(Items.infusedOnyxAxe, "axe", 4);
		MinecraftForge.setToolClass(Items.infusedOnyxShovel, "shovel", 4);
		MinecraftForge.setToolClass(Items.blindonitePickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(Items.blindoniteAxe, "axe", 4);
		MinecraftForge.setToolClass(Items.blindoniteShovel, "shovel", 4);
		MinecraftForge.setBlockHarvestLevel(Blocks.blindoniteOre, "pickaxe", 4);
		//4's

		//5's
		MinecraftForge.setToolClass(Items.infusedBlindonitePickaxe, "pickaxe", 5);
		MinecraftForge.setToolClass(Items.infusedBlindoniteAxe, "axe", 5);
		MinecraftForge.setToolClass(Items.infusedBlindoniteShovel, "shovel", 5);
		//5's

		//8's
		MinecraftForge.setToolClass(Items.agonitePickaxe, "pickaxe", 8);
		MinecraftForge.setBlockHarvestLevel(Blocks.nironiteOre, "pickaxe", 8);
		MinecraftForge.setBlockHarvestLevel(Blocks.dragonOre, "pickaxe", 8);
		MinecraftForge.setBlockHarvestLevel(Blocks.vraviniteOre, "pickaxe", 8);
		//8's

		//9's
		MinecraftForge.setToolClass(Items.dragonPickaxe, "pickaxe", 9);
		MinecraftForge.setToolClass(Items.dragonAxe, "axe", 9);
		MinecraftForge.setToolClass(Items.dragonShovel, "shovel", 9);
		//9's

		//11's
		MinecraftForge.setToolClass(Items.infusedDragonPickaxe, "pickaxe", 11);
		MinecraftForge.setToolClass(Items.infusedDragonAxe, "axe", 11);
		MinecraftForge.setToolClass(Items.infusedDragonShovel, "shovel", 11);
		//11's

		//12's
		MinecraftForge.setToolClass(Items.vravinitePickaxe, "pickaxe", 12);
		MinecraftForge.setToolClass(Items.vraviniteAxe, "axe", 12);
		MinecraftForge.setToolClass(Items.vraviniteShovel, "shovel", 12);
		MinecraftForge.setToolClass(Items.kupinumPickaxe, "pickaxe", 12);
		MinecraftForge.setToolClass(Items.kupinumAxe, "axe", 12);
		MinecraftForge.setToolClass(Items.kupinumShovel, "shovel", 12);
		//12's

		//13's
		MinecraftForge.setToolClass(Items.infusedVravinitePickaxe, "pickaxe", 13);
		MinecraftForge.setToolClass(Items.infusedVraviniteAxe, "axe", 13);
		MinecraftForge.setToolClass(Items.infusedVraviniteShovel, "shovel", 13);
		MinecraftForge.setBlockHarvestLevel(Blocks.drakiuzOre, "pickaxe", 13);
		MinecraftForge.setBlockHarvestLevel(Blocks.jaavikOre, "pickaxe", 13);
		//13's

		//14's
		MinecraftForge.setToolClass(Items.alerisPickaxe, "pickaxe", 14);
		MinecraftForge.setToolClass(Items.alerisAxe, "axe", 14);
		MinecraftForge.setToolClass(Items.alerisShovel, "shovel", 14);
		MinecraftForge.setBlockHarvestLevel(Blocks.alerisOre, "pickaxe", 13);
		//14's
	}
}
