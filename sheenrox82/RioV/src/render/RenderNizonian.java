package sheenrox82.RioV.src.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.entity.mob.passive.EntityNizonian;
import sheenrox82.RioV.src.lib.EntityResourceLocation;
import sheenrox82.RioV.src.model.ModelTerron;

public class RenderNizonian extends RenderLiving
{
	
	public RenderNizonian()
	{
		super(new ModelTerron(), 0.5F);
	}

	public void renderTroll(EntityNizonian var1, double var2, double var4, double var6, float var8, float var9)
	{
		super.doRenderLiving(var1, var2, var4, var6, var8, var9);
	}

	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderTroll((EntityNizonian)var1, var2, var4, var6, var8, var9);
	}

	public void doRenderLiving(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderTroll((EntityNizonian)var1, var2, var4, var6, var8, var9);
	}

	protected void preRenderScale(EntityNizonian par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(1.2F, 1.2F, 1.2F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityNizonian)par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return EntityResourceLocation.nizonian;
	}
}