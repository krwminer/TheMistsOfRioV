package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.entity.mob.hostile.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTerron;
import sheenrox82.RioV.src.entity.mob.passive.EntityFairy;
import sheenrox82.RioV.src.lib.EntityResourceLocation;
import sheenrox82.RioV.src.model.ModelDemonAngel;
import sheenrox82.RioV.src.model.ModelTerron;
import sheenrox82.RioV.src.util.Color;


public class RenderDemonAngel extends RenderLiving
{
	private int field_82419_a;

	public RenderDemonAngel()
	{
		super(new ModelDemonAngel(), 0.5F);

	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityDemonAngel)par1Entity, par2, par4, par6, par8, par9);
		renderLivingLabel((EntityLiving)par1Entity, Color.DARK_RED + "Demon Angel", par2, par4, par6, 64);
		doRenderLiving((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
	}


	public void func_82418_a(EntityDemonAngel par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}

	protected void preRenderScale(EntityDemonAngel par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(1.5F, 1.5F, 1.5F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityDemonAngel)par1EntityLivingBase, par2);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityDemonAngel)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return EntityResourceLocation.demon_angel;
	}
}