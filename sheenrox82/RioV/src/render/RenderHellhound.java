package sheenrox82.RioV.src.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.entity.mob.hostile.EntityHellhound;
import sheenrox82.RioV.src.lib.EntityResourceLocation;
import sheenrox82.RioV.src.model.ModelHellhound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHellhound extends RenderLiving
{
	
	public RenderHellhound()
	{
		super(new ModelHellhound(), 0.5F);
	}

	public void renderAdv(EntityHellhound var1, double var2, double var4, double var6, float var8, float var9)
	{
		super.doRenderLiving(var1, var2, var4, var6, var8, var9);
	}

	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityHellhound)var1, var2, var4, var6, var8, var9);
	}

	public void doRenderLiving(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityHellhound)var1, var2, var4, var6, var8, var9);
	}

	protected void preRenderScale(EntityHellhound par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(1.5F, 1.5F, 1.5F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityHellhound)par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return EntityResourceLocation.hellhound;
	}
}
