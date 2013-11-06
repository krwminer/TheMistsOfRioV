package sheenrox82.RioV.src.entity.mob.hostile;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.content.Sound;
import sheenrox82.RioV.src.entity.mob.core.EntityMobDeadBody;

public class EntityMage extends EntityMobDeadBody
{
	/** Random offset used in floating behaviour */
	private float heightOffset = 0.5F;

	/** ticks until heightOffset is randomized */
	private int heightOffsetUpdateTime;
	private int field_70846_g;

	public EntityMage(World par1World)
	{
		super(par1World);
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this,  0.56D));
		this.experienceValue = 10;
		isImmuneToFire = true;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true;
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	@Override
	protected void attackEntity(Entity par1Entity, float par2)
	{
		if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
		{
			this.attackTime = 20;
			this.attackEntityAsMob(par1Entity);
		}
		else if (par2 < 30.0F)
		{
			double d0 = par1Entity.posX - this.posX;
			double d1 = par1Entity.boundingBox.minY + (double)(par1Entity.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
			double d2 = par1Entity.posZ - this.posZ;

			if (this.attackTime == 0)
			{
				++this.field_70846_g;

				if (this.field_70846_g == 1)
				{
					this.attackTime = 60;
				}
				else if (this.field_70846_g <= 4)
				{
					this.attackTime = 6;
				}
				else
				{
					this.attackTime = 100;
					this.field_70846_g = 0;
				}

				if (this.field_70846_g > 1)
				{
					float f1 = MathHelper.sqrt_float(par2) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

					for (int i = 0; i < 1; ++i)
					{
						EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.worldObj, this, d0 + this.rand.nextGaussian() * (double)f1, d1, d2 + this.rand.nextGaussian() * (double)f1);
						entitysmallfireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
						this.worldObj.spawnEntityInWorld(entitysmallfireball);
					}
				}
			}

			this.rotationYaw = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
		}
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int var1 = this.rand.nextInt(8);

		if (var1 == 0)
		{
			this.dropItem(Items.orb.itemID, 1);
		}
		if (var1 == 1)
		{
			this.dropItem(Items.orb.itemID, 2);
		}
		if (var1 == 2)
		{
			this.dropItem(Items.baseCrystal.itemID, 1);
		}
		if (var1 == 3)
		{
			this.dropItem(Items.eosPotion.itemID, 1);
		}
		if (var1 == 4)
		{

		}
		if (var1 == 5)
		{

		}
		if (var1 == 6)
		{

		}
		if (var1 == 7)
		{
			this.dropItem(Items.mythrilIngot.itemID, 1);
		}
	}

	@Override
	protected void dropRareDrop(int par1)
	{
		Random rand = new Random();
		int random = rand.nextInt(3);

		if(random == 0)
		{
			this.dropItem(Items.fireballWand.itemID, 1);
		}
		
		if(random == 1)
		{
			this.dropItem(Items.iceWand.itemID, 1);
		}
		
		if(random == 2)
		{
			this.dropItem(Items.graviWand.itemID, 1);
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(6.0D);
	}

	@Override
	protected String getHurtSound()
	{
		return Sound.pain;
	}
}
