package sheenrox82.RioV.src.world.teleporter.position;

import sheenrox82.RioV.src.world.teleporter.TeleporterSanctuatite;
import net.minecraft.util.ChunkCoordinates;

public class SanctuatitePortalPosition extends ChunkCoordinates
{
	public long field_85087_d;
	final TeleporterSanctuatite field_85088_e;
	
	public SanctuatitePortalPosition(TeleporterSanctuatite tutorialTeleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_85088_e = tutorialTeleporter;
		this.field_85087_d = par5;
	}
}