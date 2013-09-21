package sheenrox82.RioV.src.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import sheenrox82.RioV.src.util.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class UpdateHandler 
{
	public static boolean isUpdateAvailable() throws IOException, MalformedURLException 
	{
		BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://dl.dropboxusercontent.com/u/126631367/Current%20Version.txt").openStream()));
		String curVersion = versionFile.readLine();

		versionFile.close();

		if (!curVersion.contains(Util.VERSION))
		{
			return true;
		}

		return false;
	}
}