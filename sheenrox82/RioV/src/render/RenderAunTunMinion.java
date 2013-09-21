package sheenrox82.RioV.src.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunMinion;
import sheenrox82.RioV.src.lib.EntityResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAunTunMinion extends RenderBiped
{
	public RenderAunTunMinion()
	{
		super(new ModelBiped(), 0.5F);

	}

	public void renderAdv(EntityAunTunMinion var1, double var2, double var4, double var6, float var8, float var9)
	{
		super.doRenderLiving(var1, var2, var4, var6, var8, var9);
	}

	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityAunTunMinion)var1, var2, var4, var6, var8, var9);
	}

	public void doRenderLiving(Entity var1, double var2, double var4, double var6, float var8, float var9)
	{
		renderAdv((EntityAunTunMinion)var1, var2, var4, var6, var8, var9);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		// TODO Auto-generated method stub
		return EntityResourceLocation.auntun;
	}
}
