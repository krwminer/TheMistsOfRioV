package sheenrox82.RioV.src.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityShrine extends TileEntity 
{
	public static boolean isTasaravSpawned;
	public static boolean isTasaravDead;

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        isTasaravSpawned = nbt.getBoolean("Tasarav");
        isTasaravDead = nbt.getBoolean("TasaravDead");
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setBoolean("Tasarav", isTasaravSpawned);
        nbt.setBoolean("TasaravDead", isTasaravDead);
    }
}
