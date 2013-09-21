package sheenrox82.RioV.src.entity.mob.core;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTameableDeadBody extends EntityTameable
{
	public EntityTameableDeadBody(World par1World)
	{
		super(par1World);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
	}

	@Override
	protected void onDeathUpdate()
	{
		++this.deathTime;
		int i;
		i = this.getExperiencePoints(this.attackingPlayer);

		if (this.deathTime == 20)
		{
			if (!this.worldObj.isRemote && (this.recentlyHit > 0 || this.isPlayer()) && !this.isChild() && this.worldObj.getGameRules().getGameRuleBooleanValue("doMobLoot"))
			{

				while (i > 0)
				{
					int j = EntityXPOrb.getXPSplit(i);
					i -= j;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
				}

				for (i = 0; i < 20; ++i)
				{
					double d0 = this.rand.nextGaussian() * 0.02D;
					double d1 = this.rand.nextGaussian() * 0.02D;
					double d2 = this.rand.nextGaussian() * 0.02D;
					this.worldObj.spawnParticle("explode", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, d0, d1, d2);
				}
			}
		}
		if(this.deathTime >= 1000)
		{
			this.setDead();
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		if(par1EntityPlayer.username.contains("sheenrox82") || par1EntityPlayer.username.contains("Mr_Simba"))
		{
			if(!par1EntityPlayer.isSneaking())
			{
				if (super.interact(par1EntityPlayer))
				{
					return true;
				}
				else if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
				{
					par1EntityPlayer.mountEntity(this);
					return true;
				}
			}
		}
		return false;

	}
	
	public int counter;
	public int countdown;
	public boolean justJumped;

	@Override
	public void moveEntityWithHeading(float par1, float par2)
	{
		if (this.riddenByEntity != null) 
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && counter == 0)
			{
				isJumping = true;

				if(isJumping = true)
				{
					if(counter == 0)
					{
						counter++;
						this.motionY = 0.45F;
					}

					if(counter == 20)
					{
						this.justJumped = true;
					}
				}

			}

			if(justJumped = true && !Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			{
				countdown++;

				if(countdown == 40)
				{
					counter = 0;
					countdown = 0;
				}
			}

			if(!justJumped && !Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			{
				justJumped = false;
			}

			this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
			this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
			par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
			par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
		}

		if (!this.worldObj.isRemote) 
		{
			this.setAIMoveSpeed(0.14F);
			super.moveEntityWithHeading(par1, par2);
		}

		this.prevLimbSwingAmount = this.limbSwingAmount;
		double d0 = this.posX - this.prevPosX;
		double d1 = this.posZ - this.prevPosZ;
		float f4 = MathHelper.sqrt_double(d0 * d0 + d1 * d1) * 4.0F;
		if (f4 > 1.0F)
		{
			f4 = 1.0F;
		}
		this.limbSwingAmount += (f4 - this.limbSwingAmount) * 0.4F;
		this.limbSwing += this.limbSwingAmount;
	}
}
