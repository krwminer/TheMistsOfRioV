package sheenrox82.RioV.src.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlackQuartz extends Block
{
    public static final String[] quartzBlockTypes = new String[] {"default", "chiseled", "lines"};
    private static final String[] quartzBlockTextureTypes = new String[] {"side", "chiseled", "lines", null, null};
    @SideOnly(Side.CLIENT)
    private Icon[] quartzblockIcons;
    @SideOnly(Side.CLIENT)
    private Icon quartzblock_chiseled_top;
    @SideOnly(Side.CLIENT)
    private Icon quartzblock_lines_top;
    @SideOnly(Side.CLIENT)
    private Icon quartzblock_top;
    @SideOnly(Side.CLIENT)
    private Icon quartzblock_bottom;

    public BlockBlackQuartz(int par1)
    {
        super(par1, Material.rock);
        this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
    }

    @SideOnly(Side.CLIENT)
    public Icon getIcon(int par1, int par2)
    {
        if (par2 != 2 && par2 != 3 && par2 != 4)
        {
            if (par1 != 1 && (par1 != 0 || par2 != 1))
            {
                if (par1 == 0)
                {
                    return this.quartzblock_bottom;
                }
                else
                {
                    if (par2 < 0 || par2 >= this.quartzblockIcons.length)
                    {
                        par2 = 0;
                    }

                    return this.quartzblockIcons[par2];
                }
            }
            else
            {
                return par2 == 1 ? this.quartzblock_chiseled_top : this.quartzblock_top;
            }
        }
        else
        {
            return par2 == 2 && (par1 == 1 || par1 == 0) ? this.quartzblock_lines_top : (par2 == 3 && (par1 == 5 || par1 == 4) ? this.quartzblock_lines_top : (par2 == 4 && (par1 == 2 || par1 == 3) ? this.quartzblock_lines_top : this.quartzblockIcons[par2]));
        }
    }

    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        if (par9 == 2)
        {
            switch (par5)
            {
                case 0:
                case 1:
                    par9 = 2;
                    break;
                case 2:
                case 3:
                    par9 = 4;
                    break;
                case 4:
                case 5:
                    par9 = 3;
            }
        }

        return par9;
    }

    public int damageDropped(int par1)
    {
        return par1 != 3 && par1 != 4 ? par1 : 2;
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return par1 != 3 && par1 != 4 ? super.createStackedBlock(par1) : new ItemStack(this.blockID, 1, 2);
    }

    public int getRenderType()
    {
        return 39;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.quartzblockIcons = new Icon[quartzBlockTextureTypes.length];

        for (int i = 0; i < this.quartzblockIcons.length; ++i)
        {
            if (quartzBlockTextureTypes[i] == null)
            {
                this.quartzblockIcons[i] = this.quartzblockIcons[i - 1];
            }
            else
            {
                this.quartzblockIcons[i] = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.unlocalizedName + "_" + quartzBlockTextureTypes[i]);
            }
        }

        this.quartzblock_top = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.unlocalizedName + "_" + "top");
        this.quartzblock_chiseled_top = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.unlocalizedName + "_" + "chiseled_top");
        this.quartzblock_lines_top = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.unlocalizedName + "_" + "lines_top");
        this.quartzblock_bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.unlocalizedName + "_" + "bottom");
    }
}
