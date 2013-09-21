package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSkywoodLog extends Block
{
	public static final String[] woodType = new String[] {"Skywood"};
	@SideOnly(Side.CLIENT)
	private Icon iconLogTop;

	public BlockSkywoodLog(int par1)
	{
		super(par1, Material.wood);
		this.setCreativeTab(TheMistsOfRioV.tab);
		this.setStepSound(soundWoodFootstep);
		this.setHardness(2.0F);
	}

	 public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
	 {
		 int j1 = par9 & 3;
		 byte b0 = 0;

		 switch (par5)
		 {
		 case 0:
		 case 1:
			 b0 = 0;
			 break;
		 case 2:
		 case 3:
			 b0 = 8;
			 break;
		 case 4:
		 case 5:
			 b0 = 4;
		 }

		 return j1 | b0;
	 }

	 /**
	  * Returns the ID of the items to drop on destruction.
	  */
	 public int idDropped(int par1, Random par2Random, int par3)
	 {
		 return this.blockID;
	 }
	 /**
	  * Returns the quantity of items to drop on block destruction.
	  */
	 public int quantityDropped(Random par1Random)
	 {
		 return 1;
	 }

	 public Icon getIcon(int par1, int par2)
	 {
		 return par1 == 0 ? iconLogTop : par1 == 1 ? iconLogTop : this.blockIcon;
	 }

	 @SideOnly(Side.CLIENT)
	 /** Register Icons for this block used in method above **/
	 public void registerIcons(IconRegister par1IconRegister)
	 {
		 /** change the "Tutorial:LogSide,LogTop to your texture names **/
		 this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodSide");
		 this.iconLogTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodTop");
	 }

	 @Override
	 public boolean canSustainLeaves(World world, int x, int y, int z)
	 {
		 return true;
	 }

	 @Override
	 public boolean isWood(World world, int x, int y, int z)
	 {
		 return true;
	 }
}