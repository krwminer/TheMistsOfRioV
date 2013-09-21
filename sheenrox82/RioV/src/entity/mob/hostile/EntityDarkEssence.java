package sheenrox82.RioV.src.entity.mob.hostile;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.content.Sound;
import sheenrox82.RioV.src.entity.mob.hostile.EntityMage;
import sheenrox82.RioV.src.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityDarkEssence extends EntityMob implements IBossDisplayData
{

	public EntityDarkEssence(World par1World)
	{
		super(par1World);
		this.setSize(1F, 4F);
		this.experienceValue = 70;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.62D));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this,  0.62D, true));
		isImmuneToFire = true;
	}

	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
		if(this.worldObj.isRemote)
		Minecraft.getMinecraft().thePlayer.addChatMessage("\u00A70The Darkness\u00A7f: *Screeeech*");
		
		if(this.worldObj.isRemote)
		Minecraft.getMinecraft().thePlayer.addChatMessage("The Darkness has vanished!");
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(100));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
	}
	
	@Override
	public void onLivingUpdate()
	{
		if (!this.worldObj.isRemote)
		{
		}
		
		if (this.rand.nextInt(24) == 0)
		{
		}

		if (!this.onGround && this.motionY < 0.0D)
		{
			this.motionY *= 0.6D;
		}

		for (int var1 = 0; var1 < 2; ++var1)
		{
			this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
			this.worldObj.spawnParticle("enchantmenttable", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}
		super.onLivingUpdate();
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);

	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(2000.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(50.0D);
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(Items.clothOfMagic.itemID, 3);
		this.dropItem(Items.darkMatter.itemID, 2);
		this.dropItem(Items.tefCrystal.itemID, 1);
	}

	@Override
	protected String getLivingSound()
	{
		return Sound.darkness;
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