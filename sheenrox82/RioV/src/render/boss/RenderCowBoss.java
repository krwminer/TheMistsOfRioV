package sheenrox82.RioV.src.render.boss;

import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.entity.mob.bosses.vanilla.EntityCowBoss;
import sheenrox82.RioV.src.entity.mob.bosses.vanilla.EntityPigBoss;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCowBoss extends RenderLiving
{
	private static final ResourceLocation texture = new ResourceLocation(Util.MOD_ID + ":" + "textures/entity/CowBoss.png");

	public RenderCowBoss()
	{
		super(new ModelCow(), 0.5F);
	}

	public void func_82418_a(EntityCowBoss par1, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRenderLiving(par1, par2, par4, par6, par8, par9);
		BossStatus.setBossStatus(par1, true);
	}

	protected void preRenderScale(EntityCowBoss par1EntityGiantZombie, float par2)
	{
		GL11.glScalef(4F, 4F, 4F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		this.preRenderScale((EntityCowBoss)par1EntityLivingBase, par2);
	}

	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityCowBoss)par1EntityLiving, par2, par4, par6, par8, par9);
	}

	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return texture;
	}
}
