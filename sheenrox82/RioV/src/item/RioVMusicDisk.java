package sheenrox82.RioV.src.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemRecord;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVMusicDisk extends ItemRecord
{
    public String artistName;
    public String songName;

    public RioVMusicDisk(int itemID, String s, String artist, String song)
    {
        super(itemID - 256, s);
        this.artistName = artist;
        this.songName = song;
        this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
    }

    public String getRecordTitle()
    {
        return this.artistName + " - " + this.songName;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
    }
    
    public String getName()
    {
    	return this.unlocalizedName;
    }
}
