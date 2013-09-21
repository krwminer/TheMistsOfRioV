package sheenrox82.RioV.src.world.teleporter.position;

import sheenrox82.RioV.src.world.teleporter.TeleporterVaeryn;
import net.minecraft.util.ChunkCoordinates;

public class VaerynPortalPosition extends ChunkCoordinates
{
	public long field_85087_d;
	final TeleporterVaeryn field_85088_e;
	
	public VaerynPortalPosition(TeleporterVaeryn tutorialTeleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.field_85088_e = tutorialTeleporter;
		this.field_85087_d = par5;
	}
}