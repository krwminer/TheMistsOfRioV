package sheenrox82.RioV.src.races.data;

public class RaceData 
{
	public static boolean isRaceOrc;
	public static boolean isRaceHuman;
	public static boolean isRaceNord;
	public static boolean isRaceElf;
	public static String race;

	//NOT USED YET, MIGHT NOT BE FOR A WHILE.
	public static void check()
	{
		setRace("Elf");

		if(setRace(race).contains("Elf"))
		{
			isRaceElf = true;
		}
		if(setRace(race).contains("Orc"))
		{
			isRaceOrc = true;
		}
		if(setRace(race).contains("Nord"))
		{
			isRaceNord = true;
		}
		if(setRace(race).contains("Human"))
		{
			isRaceHuman = true;
		}
	}

	public static String setRace(String par1)
	{
		race = par1;
		return race;
	}

	public static String getRace()
	{
		return race;
	}
}
