package sheenrox82.RioV.src.handler;

import java.io.IOException;
import java.net.MalformedURLException;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.block.BlockAnvil;
import sheenrox82.RioV.src.util.Color;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ConnectionHandler implements IConnectionHandler
{
	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) 
	{

	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager)
	{
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager)
	{

	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager)
	{

	}

	@Override
	public void connectionClosed(INetworkManager inm)
	{

	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) 
	{
		try 
		{
			if (UpdateHandler.isUpdateAvailable()) 
			{
				clientHandler.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromText("[" + Color.LAVENDER + Util.MOD_NAME + Color.WHITE + "] " + Color.GRAY + "An update is available for " + Util.MOD_NAME + ". Check http://goo.gl/Wf3zCW for more info. - sheenrox82"));
			}

			if (!UpdateHandler.isUpdateAvailable()) 
			{
				clientHandler.getPlayer().sendChatToPlayer(ChatMessageComponent.createFromText("[" + Color.LAVENDER + Util.MOD_NAME + Color.WHITE + "] " + Color.GRAY + "Your version of " + Util.MOD_NAME + " is up-to-date. - sheenrox82"));
			}
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}