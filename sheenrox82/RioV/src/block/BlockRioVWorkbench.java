package sheenrox82.RioV.src.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRioVWorkbench extends BlockWorkbench
{
	@SideOnly(Side.CLIENT)
	private Icon workbenchIconTop;
	@SideOnly(Side.CLIENT)
	private Icon workbenchIconFront;
	@SideOnly(Side.CLIENT)
	private Icon bottom;
	private static List containerList = new ArrayList();
	public static int idForActivation = 1;

	public BlockRioVWorkbench(int par1)
	{
		super(par1);
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	@SideOnly(Side.CLIENT)

	/**
	 * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	 */
	public Icon getIcon(int par1, int par2)
	{
		if(blockID == Blocks.cherryWorkbench.blockID)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		if(blockID == Blocks.bloodWorkbench.blockID)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		if(blockID == Blocks.glimmerwoodWorkbench.blockID)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		if(blockID == Blocks.skywoodWorkbench.blockID)
		{
			return par1 == 1 ? this.workbenchIconTop : (par1 == 0 ? this.bottom : (par1 != 2 && par1 != 4 ? this.blockIcon : this.workbenchIconFront));
		}
		
		return this.blockIcon;
	}

	@SideOnly(Side.CLIENT)

	/**
	 * When this method is called, your block should register all the icons it needs with the given IconRegister. This
	 * is the only chance you get to register icons.
	 */
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(blockID == Blocks.bloodWorkbench.blockID)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodWorkbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodWorkbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodWorkbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodPlanks");
		}
		
		if(blockID == Blocks.cherryWorkbench.blockID)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryWorkbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryWorkbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryWorkbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryPlanks");
		}
		
		if(blockID == Blocks.glimmerwoodWorkbench.blockID)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "workbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "workbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "workbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "glimmerwoodPlanks");
		}
		
		if(blockID == Blocks.skywoodWorkbench.blockID)
		{
			this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodWorkbench_side");
			this.workbenchIconTop = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodWorkbench_top");
			this.workbenchIconFront = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodWorkbench_front");
			this.bottom = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodPlanks");
		}
	}
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9)
	{
		if (var1.isRemote)
		{
			return true;
		}

		int id = this.idForActivation;
		player.openGui(TheMistsOfRioV.getInstance(), id, var1, var2, var3, var4);
		return true;
	}
}
