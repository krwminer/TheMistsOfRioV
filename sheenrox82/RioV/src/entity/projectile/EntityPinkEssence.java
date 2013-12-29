package sheenrox82.RioV.src.entity.projectile;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EntityPinkEssence extends EntityThrowable
{
	public EntityPinkEssence(World var1)
	{
		super(var1);
	}

	public EntityPinkEssence(World var1, EntityLivingBase var2)
	{
		super(var1, var2);
	}

	public EntityPinkEssence(World var1, double var2, double var4, double var6)
	{
		super(var1, var2, var4, var6);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
	}

	@Override
	protected void onImpact(MovingObjectPosition var1)
	{
		if(var1.entityHit instanceof EntityLiving)
		{
            EntityLivingBase owner = this.getThrower();

            if (owner != null && owner instanceof EntityPlayer) {
            	if (MinecraftForge.EVENT_BUS.post(new AttackEntityEvent((EntityPlayer)owner, var1.entityHit))) {
            		return;
            	}
            }
			var1.entityHit.addVelocity(0, 1, 0);
		}
	}
}