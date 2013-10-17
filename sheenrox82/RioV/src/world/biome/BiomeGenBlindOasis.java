package sheenrox82.RioV.src.world.biome;

import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.entity.mob.hostile.EntityMage;
import sheenrox82.RioV.src.entity.mob.passive.EntityAdv;

public class BiomeGenBlindOasis extends BiomeGenBase
{

	public BiomeGenBlindOasis(int par1)
	{
		super(par1);
		this.minHeight = 0.1F;
		this.maxHeight = 0.6F;
		this.topBlock = ((byte)Blocks.blackRock.blockID);
		this.fillerBlock = ((byte)Blocks.blackRock.blockID);
		this.setBiomeName("Blind Oasis");
		this.waterColorMultiplier = 0x000000;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
	}

}