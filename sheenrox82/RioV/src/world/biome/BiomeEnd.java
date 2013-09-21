package sheenrox82.RioV.src.world.biome;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeEndDecorator;
import net.minecraft.world.biome.BiomeGenEnd;
import net.minecraft.world.biome.SpawnListEntry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEnd extends BiomeGenEnd
{
    public BiomeEnd(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = (byte)Block.dirt.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.theBiomeDecorator = new BiomeEndDecorator(this);
    }

    @SideOnly(Side.CLIENT)

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
}
