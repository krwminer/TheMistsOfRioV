/*
 *** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
 */

package sheenrox82.RioV.src.world.feature;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunMinion;

public class WorldGenDungeon extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
				Block.netherrack.blockID
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}

	public WorldGenDungeon() { }

	public boolean generate(World world, Random rand, int i, int j, int k) 
	{
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 7, j, k) || !LocationIsValidSpawn(world, i + 7, j, k + 7) || !LocationIsValidSpawn(world, i, j, k + 7))
		{
			return false;
		}

		world.setBlock(i + 0, j + 1, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 1, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 0, j + 2, k + 2, Block.fenceIron.blockID);
		world.setBlock(i + 0, j + 2, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 2, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 0, j + 2, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 0, j + 2, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 4, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 4, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 4, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 0, j + 4, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 0, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 0, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 0, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 1, k + 4, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 1, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 2, k + 0, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 2, k + 3, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 2, k + 4, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 2, k + 7, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 4, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 4, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 4, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 4, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 4, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 4, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 5, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 7, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 7, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 7, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 7, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 7, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 7, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 8, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 8, k + 2, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 8, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 1, j + 8, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 9, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 9, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 9, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 1, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 1, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 1, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 1, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 2, k + 0, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 2, k + 7, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 4, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 4, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 4, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 4, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 4, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 4, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 4, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 5, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 5, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 5, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 5, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 6, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 7, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 7, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 7, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 7, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 7, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 7, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 8, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 8, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 2, j + 9, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 2, j + 9, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 0, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 0, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 1, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 3, j + 1, k + 3, Blocks.runestoneAltar.blockID);
		world.setBlock(i + 3, j + 1, k + 4, Blocks.runestoneAltar.blockID);
		world.setBlock(i + 3, j + 1, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 3, j + 2, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 2, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 3, j + 2, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 3, j + 2, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 4, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 4, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 5, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 5, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 6, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 7, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 7, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 7, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 3, j + 7, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 0, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 1, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 4, j + 1, k + 3, Blocks.runestoneAltar.blockID);
		world.setBlock(i + 4, j + 1, k + 4, Blocks.runestoneAltar.blockID);
		world.setBlock(i + 4, j + 1, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 4, j + 2, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 2, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 4, j + 2, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 4, j + 2, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 4, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 4, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 4, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 5, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 5, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 6, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 7, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 7, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 4, j + 7, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 0, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 1, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 2, k + 0, Block.fenceIron.blockID);
		world.setBlock(i + 5, j + 2, k + 7, Block.fenceIron.blockID);
		world.setBlock(i + 5, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 4, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 4, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 4, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 4, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 4, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 4, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 4, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 5, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 5, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 5, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 6, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 6, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 7, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 7, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 7, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 7, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 7, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 8, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 5, j + 8, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 5, j + 9, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 5, j + 9, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 1, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 1, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 1, k + 3, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 1, k + 4, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 1, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 1, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 2, k + 0, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 2, k + 3, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 2, k + 4, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 2, k + 7, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 4, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 4, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 4, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 4, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 5, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 7, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 7, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 7, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 7, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 7, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 8, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 8, k + 2, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 8, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 6, j + 8, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 9, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 9, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 6, j + 9, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 1, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 1, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 1, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 1, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 1, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 2, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 2, k + 1, Block.fenceIron.blockID);
		world.setBlock(i + 7, j + 2, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 2, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 2, k + 5, Block.fenceIron.blockID);
		world.setBlock(i + 7, j + 2, k + 6, Block.fenceIron.blockID);
		world.setBlock(i + 7, j + 2, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 3, k + 0, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 3, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 3, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 3, k + 3, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 3, k + 4, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 3, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 3, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 4, k + 1, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 4, k + 2, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 4, k + 5, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 4, k + 6, Blocks.slateBricks.blockID);
		world.setBlock(i + 7, j + 4, k + 7, Blocks.slateBricks.blockID);
		world.setBlock(i + 1, j + 4, k + 6, Blocks.lamp.blockID);
		world.setBlock(i + 6, j + 4, k + 1, Blocks.lamp.blockID);
		world.setBlock(i + 6, j + 4, k + 6, Blocks.lamp.blockID);
		
		return true;
	}
}