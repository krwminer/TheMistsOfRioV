package sheenrox82.RioV.src.block;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockVoidFlowing extends BlockFlowing
{

	public BlockVoidFlowing(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(null);
	}

	public void registerIcons(IconRegister i)
	{
		this.blockIcon = i.registerIcon(Util.MOD_ID + ":" + "voidMoving");
	}
	
    public Icon getIcon(int par1, int par2)
    {
        return this.blockIcon;
    } 
}
