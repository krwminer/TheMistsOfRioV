package sheenrox82.RioV.src.world.teleporter.position;

import net.minecraft.util.ChunkCoordinates;
import sheenrox82.RioV.src.world.teleporter.TeleporterAtlantea;
import sheenrox82.RioV.src.world.teleporter.TeleporterFlamonor;

public class PortalPositionAtlantea extends ChunkCoordinates
{
	public long field_85087_d;
	final TeleporterAtlantea teleporter;
	
	public PortalPositionAtlantea(TeleporterAtlantea teleporter, int par2, int par3, int par4, long par5)
	{
		super(par2, par3, par4);
		this.teleporter = teleporter;
		this.field_85087_d = par5;
	}
}