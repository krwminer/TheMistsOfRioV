package sheenrox82.RioV.src.content;

import sheenrox82.RioV.src.util.Util;

public class Sound 
{
	public static final String SOUND_PREFIX = Util.MOD_ID + ":";

	public static String[] files = 
		{ 
		SOUND_PREFIX + "portal.ogg", 
		SOUND_PREFIX + "bow.ogg", 
		SOUND_PREFIX + "demon.ogg",
		SOUND_PREFIX + "hellhound.ogg",
		SOUND_PREFIX + "auntun.ogg",
		SOUND_PREFIX + "darkness.ogg"
		};

	public static String[] music = 
		{ 
		SOUND_PREFIX + "theAwakening.ogg",
		SOUND_PREFIX + "frozen.ogg"
		};
	
	public static final String portal = SOUND_PREFIX + "portal";
	public static final String bow = SOUND_PREFIX + "bow";
	public static final String demon = SOUND_PREFIX + "demon";
	public static final String hellhound = SOUND_PREFIX + "hellhound";
	public static final String auntun = SOUND_PREFIX + "auntun";
	public static final String growl = SOUND_PREFIX + "growl";
	public static final String darkness = SOUND_PREFIX + "darkness";
	public static final String theAwakening = SOUND_PREFIX + "theAwakening";
	public static final String frozen = SOUND_PREFIX + "frozen";
}
