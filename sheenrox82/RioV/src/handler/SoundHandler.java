package sheenrox82.RioV.src.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import sheenrox82.RioV.src.content.Sound;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler 
{
	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) 
	{
		for(String sound : Sound.files)
		{
			try 
			{
				event.manager.addSound(sound);
			} 
			catch(Exception e) 
			{
				FMLLog.info("Failed loading " + Util.MOD_NAME + " sound: " + sound);
			}
		}
	}
}