package sheenrox82.RioV.src.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBricks extends Block
{
    public static final String[] brickList = new String[] {"sapphire", "topaz", "amethyst", "onyx", "blindonite", "dragon", "vravinite", "aleris", "jaavik", "nironite", "garnet", "drakiuz"};

    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

    public BlockBricks(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int par1, int par2)
    {
        return this.iconArray[par2];
    }

    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
    	 for(int i = 0; i < brickList.length; i++)
         {
                par3List.add(new ItemStack(par1, 1, i));
         }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[brickList.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(Util.MOD_ID + ":" + brickList[i] + "Bricks");
        }
    }
}
