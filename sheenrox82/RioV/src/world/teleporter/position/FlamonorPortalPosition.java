package sheenrox82.RioV.src.world.teleporter.position;

import sheenrox82.RioV.src.world.teleporter.TeleporterFlamonor;
import net.minecraft.util.ChunkCoordinates;

public class FlamonorPortalPosition extends ChunkCoordinates
{
	public long field_85087_d;
	final TeleporterFlamonor field_85088_e;
	
	public FlamonorPortalPosition(TeleporterFlamonor tutorialTeleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_85088_e = tutorialTeleporter;
		this.field_85087_d = par5;
	}
}