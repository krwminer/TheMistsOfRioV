package sheenrox82.RioV.src.world.biome;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeGenSnowyMountains extends BiomeGenBase
{
    public BiomeGenSnowyMountains(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.topBlock = (byte)Block.blockSnow.blockID;
        this.fillerBlock = (byte)Block.blockSnow.blockID;
    }

}
