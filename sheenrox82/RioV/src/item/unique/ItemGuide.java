package sheenrox82.RioV.src.item.unique;

import java.util.List;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Color;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGuide extends Item
{
	public static ItemStack reading;

	static
	{
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("author", "sheenrox82");
		nbt.setString("title", "The Mists of RioV - Vol. I");

		NBTTagList pages = new NBTTagList();
		pages.appendTag(new NBTTagString("1", "The is the guide for The Mists of RioV."));
		pages.appendTag(new NBTTagString("2", Color.RED + "Table of Contents" + Color.BLACK
				+ "       " + Color.GOLD + "1." + Color.BLACK + " Getting Started"
				+ "       " + Color.GOLD + "2." + Color.BLACK + " Finding some ores."
				+ "    " + Color.GOLD + "3." + Color.BLACK + " Preparing your new gear                   "
				+ "    " + Color.GOLD + "4." + Color.BLACK + " Getting ready for the first boss fight.     " + Color.GOLD + "5." + Color.BLACK + " Proceeding from there."));

		pages.appendTag(new NBTTagString("3", "Chapter I: Getting Started                 When you begin playing RioV, you may be confused; this is where this book comes in. This book will contain a F.A.Q. (at the back of the book) and more. When you create your world, you must do the usual beginning Minecraft stuff. Make a house, get tools,"));
		pages.appendTag(new NBTTagString("4", "survive the night. After this, you can start RioV. To begin diving into the mod, you'll need the first set of tools to proceed further into the mod: Amethyst, or Onyx. Amethys is cheaper to make, but not as good as Onyx. To see if a tool is better than another, look at the tool tips on "));
		pages.appendTag(new NBTTagString("5", "the items, it displays stats such as damage (for swords) and durability and harvest level. The higher the harvest level the better, tool wise. On the next page will be a table of tool progression in order, starting at amethyst, going to aleris. Aleris is the best tool set in "));
		pages.appendTag(new NBTTagString("6", "the game along with armor. It's difficult to achieve though..."));
		pages.appendTag(new NBTTagString("7", "Tool Table: (Worst to Best)               Infused/Sapphire, Infused/Mystic Topaz, Infused/Amethyst, Infused/Onyx, Infused/Blindonite, Galokin,                 Flame,                 Agonite,               Sorrow,               Infused/Dragon, Infused/Vravinite, Aleris,                 "));
		pages.appendTag(new NBTTagString("8", "Axe of Aun'Tun. That was the basic table. Of course there are other materials that aren't as big. Next we'll cover materials used to make each tool set. " + Color.GOLD + "Sapphire: " + Color.BLACK + "Sapphire and sticks. " + Color.GOLD + "Mystic Topaz: " + Color.BLACK + "Mystic Topaz and sticks. " + Color.GOLD + "Amethyst: " + Color.BLACK + "Amethyst and black bone."));
		pages.appendTag(new NBTTagString("9", Color.GOLD + "Onyx: " + Color.BLACK + "Onyx and black bone."));

		nbt.setTag("pages", pages);
		reading = new ItemStack(Item.writtenBook);
		reading.setTagCompound(nbt);
	}

	public ItemGuide(int id)
	{
		super(id);
		setContainerItem(this);
		setMaxStackSize(1);
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemId, CreativeTabs creativeTab, List subTypes)
	{
		subTypes.add(reading);
	}
}