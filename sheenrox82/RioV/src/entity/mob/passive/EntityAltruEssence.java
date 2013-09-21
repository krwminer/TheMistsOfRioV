package sheenrox82.RioV.src.entity.mob.passive;

import org.lwjgl.input.Keyboard;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAltruEssence extends EntityMob
{
	public EntityAltruEssence(World par1World)
	{

		super(par1World);
		float var2 = 0.56F;
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, var2, true));
		this.tasks.addTask(5, new EntityAIWander(this, var2));
		isImmuneToFire = false;
		if(TheMistsOfRioV.riovValis)
		{
			isImmuneToFire = true;
		}
	}
	
	public void onLivingUpdate()
	{
		if (this.rand.nextInt(24) == 0)
		{
		}

		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}

		for (int var1 = 0; var1 < 2; ++var1)
		{
			this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			this.worldObj.spawnParticle("enchantmenttable", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}

		super.onLivingUpdate();
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(60.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(14.0D);
	}

	public boolean isAIEnabled()
	{
		return true;
	}
	
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
    
    protected boolean isValidLightLevel()
    {
        return true;
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