package sheenrox82.RioV.src.block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.content.Materials;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMist extends Block
{
	public BlockMist(int var1)
	{
		super(var1, Materials.customMaterial);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(Block.soundClothFootstep);
		this.setTickRandomly(true);
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
	{
		return AxisAlignedBB.getBoundingBox((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)var3, (double)(var4 + 1));
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
	 */
	public int getRenderBlockPass()
	{
		return 1;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	 */
	public void onEntityCollidedWithBlock(World var1, int var2, int var3, int var4, Entity var5)
	{
		var5.fallDistance = 0.0F;

		if (var5.motionY < 0.0D)
		{
			var5.motionY *= 0.005D;
		}

		if (!(var5 instanceof EntityPlayer))
		{
			var5.fallDistance = -20.0F;
		}
	}

	public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5)
	{
		return super.shouldSideBeRendered(var1, var2, var3, var4, 1 - var5);
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		if ((par1World.getBlockId(par2, par3 - 1, par4) != Blocks.waterFilledGlowstone.blockID) || (!Blocks.hydrogenicPortal.tryToCreatePortal(par1World, par2, par3, par4)))
		{
			if ((!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4)))
			{
				par1World.setBlockToAir(par2, par3, par4);
			}
			else
			{
				par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, tickRate(par1World) + par1World.rand.nextInt(10));
			}
		}
	}

	public void registerIcons(IconRegister var1)
	{
		this.blockIcon = var1.registerIcon(Util.MOD_ID + ":" + this.getName());
	}

	public String getName()
	{
		return this.unlocalizedName;
	}
}
