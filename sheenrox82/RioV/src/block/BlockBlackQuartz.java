package sheenrox82.RioV.src.block;

import java.util.Random;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockBlackQuartz extends Block
{
    @SideOnly(Side.CLIENT)
    private Icon field_94460_b;
    
	public BlockBlackQuartz(int par1)
	{
		super(par1, Material.rock);
		this.setCreativeTab(TheMistsOfRioV.tab);
	}
	
	@Override
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 0 ? this.field_94460_b : (par1 == 1 ? this.blockIcon : this.blockIcon);
    }

	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
        this.field_94460_b = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blackQuartzBlock_bottom");
    } 
    
    public String getName()
    {
    	return this.unlocalizedName;
    }
}
