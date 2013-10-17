package sheenrox82.RioV.src.world.teleporter.position;

import sheenrox82.RioV.src.world.teleporter.TeleporterFlamonor;
import net.minecraft.util.ChunkCoordinates;

public class PortalPositionFlamonor extends ChunkCoordinates
{
	public long field_85087_d;
	final TeleporterFlamonor teleporter;
	
	public PortalPositionFlamonor(TeleporterFlamonor teleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.teleporter = teleporter;
		this.field_85087_d = par5;
	}
}