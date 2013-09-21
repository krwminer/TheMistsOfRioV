package sheenrox82.RioV.src.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.IThrowableEntity;


public class EntityCustomArrow extends Entity implements IThrowableEntity
{

	public float arrowShake = 0;
	public Entity shootingEntity;

	public EntityCustomArrow(World par1World) 
	{
		super(par1World);
	}

	@Override
	protected void entityInit() 
	{

	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound) 
	{
		super.readFromNBT(nbttagcompound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound) 
	{
		super.writeToNBT(nbttagcompound);
	}

	@Override
	public Entity getThrower() {
		return shootingEntity;
	}

	@Override
	public void setThrower(Entity entity) {
		this.shootingEntity = entity;
	}

}