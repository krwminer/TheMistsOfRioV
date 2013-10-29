package sheenrox82.RioV.src.world.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPalmTree extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			Block.sand.blockID
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

	public WorldGenPalmTree() { }

	public boolean generate(World world, Random rand, int i, int j, int k)
	{
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 8, j, k) || !LocationIsValidSpawn(world, i + 8, j, k + 8) || !LocationIsValidSpawn(world, i, j, k + 8))
		{
			return false;
		}

		this.setBlockAndMetadata(world, i + 0, j + 5, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 1, j + 6, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 2, j + 5, k + 2, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 2, j + 5, k + 6, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 2, j + 6, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 3, j + 6, k + 3, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 3, j + 6, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 3, j + 6, k + 5, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 0, k + 4, Block.wood.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 1, k + 4, Block.wood.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 2, k + 4, Block.wood.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 3, k + 4, Block.wood.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 4, k + 4, Block.wood.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 5, k + 0, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 5, k + 4, Block.wood.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 5, k + 8, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 6, k + 1, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 6, k + 2, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 6, k + 3, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 6, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 6, k + 5, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 6, k + 6, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 6, k + 7, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 4, j + 7, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 5, j + 6, k + 3, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 5, j + 6, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 5, j + 6, k + 5, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 6, j + 5, k + 2, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 6, j + 5, k + 6, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 6, j + 6, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 7, j + 6, k + 4, Block.leaves.blockID, 3);
		this.setBlockAndMetadata(world, i + 8, j + 5, k + 4, Block.leaves.blockID, 3);

		return true;
	}
}