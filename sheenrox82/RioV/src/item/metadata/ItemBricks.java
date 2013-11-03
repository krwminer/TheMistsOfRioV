package sheenrox82.RioV.src.item.metadata;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBricks extends ItemBlock
{
	public ItemBricks(int par1)
	{
		super(par1);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack itemstack)
	{
		String name = "";
		switch(itemstack.getItemDamage())
		{
		case 0:
		{
			name = "sapphire"; break;
		}
		case 1:
		{
			name = "topaz"; break;
		}
		case 2:
		{
			name = "amethyst"; break;
		}
		case 3:
		{
			name = "onyx"; break;
		}
		case 4:
		{
			name = "blindonite"; break;
		}
		case 5:
		{
			name = "dragon"; break;
		}
		case 6:
		{
			name = "vravinite"; break;
		}
		case 7:
		{
			name = "aleris"; break;
		}
		case 8:
		{
			name = "jaavik"; break;
		}
		case 9:
		{
			name = "nironite"; break;
		}
		case 10:
		{
			name = "garnet"; break;
		}
		case 11:
		{
			name = "drakiuz"; break;
		}
		default: name = "broken";
		}
		return getUnlocalizedName() + "." + name;
	}

	public int getMetadata(int par1)
	{
		return par1;
	}
}
