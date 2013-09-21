package sheenrox82.RioV.src.handler;

import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.content.Blocks;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		int var1 = fuel.itemID;
		
		if(var1 == Blocks.steamingBloodDeposit.blockID)
		{
			return 6400;
		}
		else
		{
			return 0;
		}
	}
}