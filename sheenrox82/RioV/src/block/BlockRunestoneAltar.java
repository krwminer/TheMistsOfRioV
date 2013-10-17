package sheenrox82.RioV.src.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.util.Util;

public class BlockRunestoneAltar extends Block
{
	public static int id = 2;
	@SideOnly(Side.CLIENT)
	private Icon field_94461_a;
	@SideOnly(Side.CLIENT)
	private Icon field_94460_b;

	public BlockRunestoneAltar(int par1)
	{
		super(par1, Material.rock);
		setCreativeTab(TheMistsOfRioV.getInstance().tab);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public Icon getIcon(int par1, int par2)
	{
		return par1 == 0 ? this.field_94460_b : (par1 == 1 ? this.field_94461_a : this.blockIcon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "runeAltar_side");
		this.field_94461_a = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "runeAltar_top");
		this.field_94460_b = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "anvil_bottom");
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		((EntityLivingBase)par5EntityPlayer).addPotionEffect(new PotionEffect(Potion.harm.getId(), 3, 1));
		((EntityLivingBase)par5EntityPlayer).addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 120, 3));
		par1World.setBlockToAir(par2, par3, par4);
		return true;
	}
}
