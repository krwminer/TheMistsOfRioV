package sheenrox82.RioV.src.world.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import sheenrox82.RioV.src.content.Blocks;

public class WorldGenNetherShrine extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			Block.netherrack.blockID,
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
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

	public WorldGenNetherShrine() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 8, j, k) || !LocationIsValidSpawn(world, i + 8, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8))
		{
			return false;
		}

		world.setBlock(i + 0, j + 0, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 1, j + 0, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 1, j + 0, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 1, j + 0, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 1, j + 1, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 1, j + 1, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 0, k + 1, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 0, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 0, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 0, k + 4, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 0, k + 5, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 0, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 0, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 1, k + 1, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 1, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 1, k + 6, Block.netherBrick.blockID);
		world.setBlock(i + 2, j + 1, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 2, k + 1, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 2, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 2, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 2, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 2, j + 3, k + 1, Block.netherrack.blockID);
		world.setBlock(i + 3, j + 0, k + 0, Block.netherrack.blockID);
		world.setBlock(i + 3, j + 0, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 3, j + 0, k + 4, Block.netherrack.blockID);
		world.setBlock(i + 3, j + 0, k + 5, Block.netherrack.blockID);
		world.setBlock(i + 3, j + 0, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 3, j + 0, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 3, j + 1, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 0, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 4, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 5, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 0, k + 8, Block.netherrack.blockID);
		world.setBlock(i + 4, j + 1, k + 4, Blocks.shrine.blockID);
		world.setBlock(i + 5, j + 0, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 5, j + 0, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 5, j + 0, k + 4, Block.netherrack.blockID);
		world.setBlock(i + 5, j + 0, k + 5, Block.netherrack.blockID);
		world.setBlock(i + 5, j + 0, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 5, j + 0, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 5, j + 0, k + 8, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 0, k + 1, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 0, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 0, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 0, k + 5, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 0, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 0, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 1, k + 1, Block.netherBrick.blockID);
		world.setBlock(i + 6, j + 1, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 1, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 1, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 2, k + 1, Block.netherBrick.blockID);
		world.setBlock(i + 6, j + 2, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 2, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 2, k + 7, Block.netherrack.blockID);
		world.setBlock(i + 6, j + 3, k + 1, Block.netherBrick.blockID);
		world.setBlock(i + 6, j + 3, k + 7, Block.netherBrick.blockID);
		world.setBlock(i + 7, j + 0, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 7, j + 0, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 7, j + 0, k + 4, Block.netherrack.blockID);
		world.setBlock(i + 7, j + 0, k + 5, Block.netherrack.blockID);
		world.setBlock(i + 7, j + 0, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 7, j + 1, k + 2, Block.netherrack.blockID);
		world.setBlock(i + 7, j + 1, k + 3, Block.netherrack.blockID);
		world.setBlock(i + 7, j + 1, k + 6, Block.netherrack.blockID);
		world.setBlock(i + 8, j + 0, k + 4, Block.netherrack.blockID);

		return true;
	}

}