package sheenrox82.RioV.src.handler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import sheenrox82.RioV.src.util.PlayerNBT;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class EosHandler implements IPacketHandler
{
	public EosHandler() {}

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		if (packet.channel.equals("riovchannel")) {
			handleExtendedProperties(packet, player);
		}
	}

	private void handleExtendedProperties(Packet250CustomPayload packet, Player player)
	{
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		PlayerNBT props = PlayerNBT.get((EntityPlayer) player);

		try 
		{
			props.setMaxEos(inputStream.readInt());
			props.setCurrentEos(inputStream.readInt());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return;
		}
		
		System.out.println("[PACKET] Mana from packet: " + props.getCurrentEos() + "/" + props.maxEos);
	}
}