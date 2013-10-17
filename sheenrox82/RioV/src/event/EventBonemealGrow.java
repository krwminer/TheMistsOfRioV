package sheenrox82.RioV.src.event;

import net.minecraftforge.event.ForgeSubscribe;
import sheenrox82.RioV.src.block.BlockRioVSapling;
import sheenrox82.RioV.src.content.Blocks;

public class EventBonemealGrow
{
	private int BlockID;

	@ForgeSubscribe
	public void bonemealUsed(net.minecraftforge.event.entity.player.BonemealEvent event)
	{
		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.glimmerwoodSapling.blockID)
		{
			((BlockRioVSapling)Blocks.glimmerwoodSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
		
		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.cherryBlossomSapling.blockID)
		{
			((BlockRioVSapling)Blocks.cherryBlossomSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
		
		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.bloodSapling.blockID)
		{
			((BlockRioVSapling)Blocks.bloodSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
		
		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.skywoodSapling.blockID)
		{
			((BlockRioVSapling)Blocks.skywoodSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
	}
}