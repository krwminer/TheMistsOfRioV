package sheenrox82.RioV.src.world.teleporter.position;

import sheenrox82.RioV.src.world.teleporter.TeleporterBlindOasis;
import net.minecraft.util.ChunkCoordinates;

public class BlindOasisPortalPosition extends ChunkCoordinates
{
	public long field_85087_d;
	final TeleporterBlindOasis field_85088_e;
	
	public BlindOasisPortalPosition(TeleporterBlindOasis tutorialTeleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_85088_e = tutorialTeleporter;
		this.field_85087_d = par5;
	}
}