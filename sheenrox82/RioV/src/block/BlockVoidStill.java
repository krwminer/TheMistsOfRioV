package sheenrox82.RioV.src.block;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.entity.mob.hostile.EntityShadow;
import sheenrox82.RioV.src.util.Util;

public class BlockVoidStill extends BlockStationary
{

	public BlockVoidStill(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(null);
	}

	public void registerIcons(IconRegister i)
	{
		this.blockIcon = i.registerIcon(Util.MOD_ID + ":" + "voidStill");
	}
	
    public Icon getIcon(int par1, int par2)
    {
        return this.blockIcon;
    }
    
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
    	if (par5Entity instanceof EntityLivingBase)
    	{
    		((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(Potion.wither.getId(), 50, 2));
    	}
	}
}
