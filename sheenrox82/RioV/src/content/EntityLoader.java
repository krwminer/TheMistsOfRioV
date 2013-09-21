package sheenrox82.RioV.src.content;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunBodyguard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.hostile.EntityBloodGhoul;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkElf;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.hostile.EntityHellhound;
import sheenrox82.RioV.src.entity.mob.hostile.EntityMage;
import sheenrox82.RioV.src.entity.mob.hostile.EntityShadow;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTef;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTefGuard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTerron;
import sheenrox82.RioV.src.entity.mob.hostile.EntityVravinite;
import sheenrox82.RioV.src.entity.mob.passive.EntityAdv;
import sheenrox82.RioV.src.entity.mob.passive.EntityAltruEssence;
import sheenrox82.RioV.src.entity.mob.passive.EntityAngel;
import sheenrox82.RioV.src.entity.mob.passive.EntityDove;
import sheenrox82.RioV.src.entity.mob.passive.EntityFairy;
import sheenrox82.RioV.src.entity.mob.passive.EntityGalokin;
import sheenrox82.RioV.src.entity.mob.passive.EntityNizonian;
import sheenrox82.RioV.src.entity.mob.passive.EntityOrc;
import sheenrox82.RioV.src.entity.mob.passive.EntityRabbit;
import sheenrox82.RioV.src.entity.mob.passive.EntitySkeletalHorse;
import sheenrox82.RioV.src.entity.mob.passive.EntitySoverianOfficer;
import sheenrox82.RioV.src.entity.projectile.EntityDarknessArrow;
import sheenrox82.RioV.src.entity.projectile.EntityVraviniteArrow;
import sheenrox82.RioV.src.util.Registry;
import sheenrox82.RioVPaladin.EntityPaladin;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityLoader 
{

	public static void add()
	{
		Registry.registerEntity(EntityAdv.class, "Adventurer");
		Registry.registerEntity(EntityAltruEssence.class, "Altru Essence");
		Registry.registerEntity(EntityAunTun.class, "Aun'Tun");
		Registry.registerEntity(EntityAunTunBodyguard.class, "Aun'Tun Bodyguard");
		Registry.registerEntity(EntityAunTunMinion.class, "Aun'Tun Minion");
		Registry.registerEntity(EntityDarkElf.class, "Dark Elf");
		Registry.registerEntity(EntityDemonAngel.class, "Demon Angel");
		Registry.registerEntity(EntityMage.class, "Mage");
		Registry.registerEntity(EntityNizonian.class, "Nizonian");
		Registry.registerEntity(EntitySkeletalHorse.class, "Skeletal Horse");
		Registry.registerEntity(EntityTerron.class, "Terron");
		Registry.registerEntity(EntityGalokin.class, "Galokin");
		Registry.registerEntity(EntityOrc.class, "Orc");
		Registry.registerEntity(EntityFairy.class, "Fairy");
		Registry.registerEntity(EntityDarkEssence.class, "The Darkness");
		Registry.registerEntity(EntityHellhound.class, "Hellhound");
		Registry.registerEntity(EntityDarknessArrow.class, "Darkness Arrow");
		Registry.registerEntity(EntityTef.class, "Tef");
		Registry.registerEntity(EntityTefGuard.class, "Tef Guard");
		Registry.registerEntity(EntityShadow.class, "The Shadow");
		Registry.registerEntity(EntityVravinite.class, "Vravinite");
		Registry.registerEntity(EntityVraviniteArrow.class, "Vravinite Arrow");
		Registry.registerEntity(EntityBloodGhoul.class, "Blood Ghoul");
		Registry.registerEntity(EntityDove.class, "Dove");
		Registry.registerEntity(EntityAngel.class, "Angel");
		Registry.registerEntity(EntityRabbit.class, "Rabbit");
		Registry.registerEntity(EntitySoverianOfficer.class, "Soverian Officer");

		Registry.registerEgg(EntityAdv.class);
		Registry.registerEgg(EntityMage.class);
		Registry.registerEgg(EntityAltruEssence.class);
		Registry.registerEgg(EntityAunTunBodyguard.class);
		Registry.registerEgg(EntityAunTunMinion.class);
		Registry.registerEgg(EntityDarkElf.class);
		Registry.registerEgg(EntitySkeletalHorse.class);
		Registry.registerEgg(EntityNizonian.class);
		Registry.registerEgg(EntityGalokin.class);
		Registry.registerEgg(EntityOrc.class);
		Registry.registerEgg(EntityFairy.class);
		Registry.registerEgg(EntityHellhound.class);
		Registry.registerEgg(EntityTef.class);
		Registry.registerEgg(EntityTefGuard.class);
		Registry.registerEgg(EntityShadow.class);
		Registry.registerEgg(EntityVravinite.class);
		Registry.registerEgg(EntityBloodGhoul.class);
		Registry.registerEgg(EntityDove.class);
		Registry.registerEgg(EntityAngel.class);
		Registry.registerEgg(EntityRabbit.class);
		Registry.registerEgg(EntitySoverianOfficer.class);
	}

	public static void addOverworldSpawning()
	{
		BiomeGenBase[] plains = BiomeDictionary.getBiomesForType(Type.PLAINS);
		BiomeGenBase[] desert = BiomeDictionary.getBiomesForType(Type.DESERT);
		BiomeGenBase[] mountain = BiomeDictionary.getBiomesForType(Type.MOUNTAIN);
		BiomeGenBase[] frozen = BiomeDictionary.getBiomesForType(Type.FROZEN);
		BiomeGenBase[] jungle = BiomeDictionary.getBiomesForType(Type.JUNGLE);
		BiomeGenBase[] forest = BiomeDictionary.getBiomesForType(Type.FOREST);

		SpawnListEntry advSpawn = new SpawnListEntry(EntityAdv.class, 1, 2, 6);
		SpawnListEntry nizonianSpawn = new SpawnListEntry(EntityNizonian.class, 1, 2, 6);
		SpawnListEntry mageSpawn = new SpawnListEntry(EntityMage.class, 3, 3, 6);
		SpawnListEntry darkElfSpawn = new SpawnListEntry(EntityDarkElf.class, 2, 4, 8);
		SpawnListEntry galokinSpawn = new SpawnListEntry(EntityGalokin.class, 2, 4, 8);
		SpawnListEntry orcSpawn = new SpawnListEntry(EntityOrc.class, 2, 4, 8);
		SpawnListEntry sovSpawn = new SpawnListEntry(EntitySoverianOfficer.class, 1, 2, 6);

		for(int i = 0; i < plains.length; i++)
		{
			plains[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			plains[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
		}
		
		for(int i = 0; i < mountain.length; i++)
		{
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			mountain[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
		}
		
		for(int i = 0; i < frozen.length; i++)
		{
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			frozen[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
		}
		
		for(int i = 0; i < jungle.length; i++)
		{
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			jungle[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
		}
		
		for(int i = 0; i < forest.length; i++)
		{
			forest[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			forest[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
		}
		
		for(int i = 0; i < desert.length; i++)
		{
			desert[i].getSpawnableList(EnumCreatureType.creature).add(nizonianSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(advSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(mageSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(darkElfSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(galokinSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(orcSpawn);
			desert[i].getSpawnableList(EnumCreatureType.creature).add(sovSpawn);
		}
	}

	public static void addNetherSpawning()
	{
		BiomeGenBase[] nether = BiomeDictionary.getBiomesForType(Type.NETHER);

		SpawnListEntry skeleHorseSpawn = new SpawnListEntry(EntitySkeletalHorse.class, 3, 4, 8);
		SpawnListEntry minionSpawn = new SpawnListEntry(EntityAunTunMinion.class, 1, 2, 5);
		SpawnListEntry bodyguardSpawn = new SpawnListEntry(EntityAunTunBodyguard.class, 1, 2, 5);
		SpawnListEntry hellhoundSpawn = new SpawnListEntry(EntityHellhound.class, 1, 5, 9);

		for(int i = 0; i < nether.length; i++)
		{
			nether[i].getSpawnableList(EnumCreatureType.creature).add(skeleHorseSpawn);
			nether[i].getSpawnableList(EnumCreatureType.creature).add(minionSpawn);
			nether[i].getSpawnableList(EnumCreatureType.creature).add(bodyguardSpawn);
			nether[i].getSpawnableList(EnumCreatureType.creature).add(hellhoundSpawn);
		}
	}

	public static void addEndSpawning()
	{
		BiomeGenBase[] end = BiomeDictionary.getBiomesForType(Type.END);

		SpawnListEntry fairySpawn = new SpawnListEntry(EntityFairy.class, 1, 2, 6);
		SpawnListEntry essenceSpawn = new SpawnListEntry(EntityAltruEssence.class, 1, 2, 6);

		for(int i = 0; i < end.length; i++)
		{
			end[i].getSpawnableList(EnumCreatureType.creature).add(fairySpawn);
			end[i].getSpawnableList(EnumCreatureType.creature).add(essenceSpawn);
		}
	}

	public static void addDimensionSpawning()
	{
		EntityRegistry.addSpawn(EntityShadow.class, 1, 2, 6, EnumCreatureType.creature, Biomes.blindOasis);
		EntityRegistry.addSpawn(EntityShadow.class, 1, 2, 6, EnumCreatureType.monster, Biomes.blindOasis);
		EntityRegistry.addSpawn(EntityVravinite.class, 1, 2, 6, EnumCreatureType.creature, Biomes.glimmerwood);
		EntityRegistry.addSpawn(EntityVravinite.class, 1, 2, 6, EnumCreatureType.monster, Biomes.glimmerwood);
		EntityRegistry.addSpawn(EntityBloodGhoul.class, 1, 2, 6, EnumCreatureType.creature, Biomes.flamonor);
		EntityRegistry.addSpawn(EntityBloodGhoul.class, 1, 2, 6, EnumCreatureType.monster, Biomes.flamonor);
		EntityRegistry.addSpawn(EntityDove.class, 1, 1, 3, EnumCreatureType.creature, Biomes.sanctuatite);
		EntityRegistry.addSpawn(EntityAngel.class, 1, 1, 3, EnumCreatureType.creature, Biomes.sanctuatite);
		EntityRegistry.addSpawn(EntityRabbit.class, 1, 1, 3, EnumCreatureType.creature, Biomes.sanctuatite);

	}

	public static void addNightSpawning()
	{
		EntityRegistry.addSpawn(EntityNizonian.class, 1, 2, 6, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.beach, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(EntityMage.class, 3, 3, 6, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(EntityDarkElf.class, 2, 4, 8, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.jungle, BiomeGenBase.desert, BiomeGenBase.taiga, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityAdv.class, 1, 2, 6, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.jungle, BiomeGenBase.desert, BiomeGenBase.taiga, BiomeGenBase.forest, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(EntityGalokin.class, 2, 4, 8, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.jungle, BiomeGenBase.forest, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(EntityOrc.class, 2, 4, 8, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.jungle, BiomeGenBase.forest);

	}
	public static void addPMobs()
	{
		if(TheMistsOfRioV.riovPaladin)
		{
			Registry.registerEntity(EntityPaladin.class, "Paladin");
			EntityRegistry.addSpawn(EntityPaladin.class, 2, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains,BiomeGenBase.jungle,BiomeGenBase.extremeHills,BiomeGenBase.desert, BiomeGenBase.desertHills,BiomeGenBase.taiga, BiomeGenBase.taigaHills,BiomeGenBase.jungleHills,BiomeGenBase.beach,BiomeGenBase.extremeHillsEdge,BiomeGenBase.forest,BiomeGenBase.forestHills,BiomeGenBase.frozenOcean,BiomeGenBase.frozenRiver,BiomeGenBase.iceMountains,BiomeGenBase.icePlains,BiomeGenBase.mushroomIsland,BiomeGenBase.mushroomIslandShore,BiomeGenBase.swampland);

			Registry.registerEgg(EntityPaladin.class);
		}
		else
		{

		}
	}
}
