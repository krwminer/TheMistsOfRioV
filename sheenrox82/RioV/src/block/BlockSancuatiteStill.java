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
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.util.Util;

public class BlockSancuatiteStill extends BlockStationary
{

	public BlockSancuatiteStill(int par1, Material par2Material) 
	{
		super(par1, par2Material);
		this.setCreativeTab(null);
	}

	public void registerIcons(IconRegister i)
	{
		this.blockIcon = i.registerIcon(Util.MOD_ID + ":" + this.getName());
	}

	public String getName()
	{
		return this.unlocalizedName;
	}

	public Icon getIcon(int par1, int par2)
	{
		return this.blockIcon;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (par5Entity instanceof EntityLivingBase)
		{
			if(blockID == Blocks.sanctuatiteStill.blockID)
			{
				((EntityLivingBase)par5Entity).addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 100, 2));
			}
			
			if(blockID == Blocks.steamingBloodStill.blockID)
			{
				par5Entity.setFire(100);
			}
		}
	}
}
