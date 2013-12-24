package sheenrox82.RioV.src.render.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.entity.mob.bosses.vanilla.EntitySheepBoss;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSheepBoss extends RenderLiving
{
	private static final ResourceLocation texture = new ResourceLocation(Util.MOD_ID + ":" + "textures/entity/SheepBoss.png");
	private static final ResourceLocation sheared = new ResourceLocation(Util.MOD_ID + ":" + "textures/entity/ShearedSheepBoss.png");

	public RenderSheepBoss(ModelBase model1, ModelBase model2)
	{
		super(model1, 0.5F);
		this.setRenderPassModel(model2);
	}

	public void func_82418_a(EntitySheepBoss par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}
	 
	protected void preRenderScale(EntitySheepBoss par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(4F, 4F, 4F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntitySheepBoss)par1EntityLivingBase, par2);
	}
	
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
    {
		this.bindTexture(texture);
        return 1;
    }

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntitySheepBoss)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return sheared;
	}
}
