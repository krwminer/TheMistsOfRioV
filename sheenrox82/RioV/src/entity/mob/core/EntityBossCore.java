package sheenrox82.RioV.src.entity.mob.core;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

public class EntityBossCore extends EntityMob implements IBossDisplayData
{
	public int counter;
	public int countdown;
	public boolean justJumped;
	
	public EntityBossCore(World par1World)
	{
		super(par1World);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
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
