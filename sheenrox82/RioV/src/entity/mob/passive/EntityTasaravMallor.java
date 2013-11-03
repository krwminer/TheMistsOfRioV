package sheenrox82.RioV.src.entity.mob.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.mob.core.EntityTameableDeadBody;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunBodyguard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.hostile.EntityPaladin;
import sheenrox82.RioV.src.tileentity.TileEntityShrine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTasaravMallor extends EntityTameableDeadBody
{
	private static ItemStack defaultHeldItem;
	private float field_70926_e;
	private float field_70924_f;
	private boolean field_70928_h;
	public static boolean isTasaravAlive;

	public EntityTasaravMallor(World par1World)
	{
		super(par1World);
		this.setSize(0.9F, 2F);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 0.56D, 10.0F, 2.0F));
		this.tasks.addTask(7, new EntityAIWander(this, 0.56D));
		this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(9, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAunTun.class, 0, false));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAunTunBodyguard.class, 0, false));
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityAunTunMinion.class, 0, false));
		tasks.addTask(1, new EntityAITargetNonTamed(this, EntityPaladin.class, 0, true));
		this.setCurrentItemOrArmor(4, new ItemStack(Items.tasaravHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(Items.tasaravChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(Items.tasaravLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(Items.tasaravBoots));
	}

	public void setAttackTarget(EntityLivingBase par1EntityLivingBase)
	{
		super.setAttackTarget(par1EntityLivingBase);

		if (par1EntityLivingBase == null)
		{
			this.setAngry(false);
		}
		else if (!this.isTamed())
		{
			this.setAngry(true);
		}
	}

	public void setAngry(boolean par1)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(16);

		if (par1)
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));
		}
		else
		{
			this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
		}
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(100.0D);
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected void updateAITick()
	{
		this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(18, new Float(this.getHealth()));
		this.dataWatcher.addObject(19, new Byte((byte)0));
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("Angry", this.isAngry());
		par1NBTTagCompound.setBoolean("TasaravAlive", this.isTasaravAlive);
	}

	public boolean isAngry()
	{
		return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setAngry(par1NBTTagCompound.getBoolean("Angry"));
		this.isTasaravAlive = par1NBTTagCompound.getBoolean("TasaravAlive");
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId()
	{
		return -1;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onUpdate();
		this.field_70924_f = this.field_70926_e;

		if (this.func_70922_bv())
		{
			this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
		}
		else
		{
			this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
		}

		if (this.func_70922_bv())
		{
			this.numTicksToChaseTarget = 10;
		}
	}

	@SideOnly(Side.CLIENT)
	public float getInterestedAngle(float par1)
	{
		return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * par1) * 0.15F * (float)Math.PI;
	}

	public float getEyeHeight()
	{
		return this.height * 0.8F;
	}

	public int getVerticalFaceSpeed()
	{
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if (this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity = par1DamageSource.getEntity();
			this.aiSit.setSitting(false);

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
			{
				par2 = (par2 + 1.0F) / 2.0F;
			}

			return super.attackEntityFrom(par1DamageSource, par2);
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity)
	{
		int i = this.isTamed() ? 40 : 30;
		return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
	}

	public void setTamed(boolean par1)
	{
		super.setTamed(par1);

		if (par1)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(200.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(100.0D);
		}
	}

	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if (this.isTamed())
		{
			if (itemstack != null)
			{
				if (Item.itemsList[itemstack.itemID] instanceof ItemFood)
				{
					ItemFood itemfood = (ItemFood)Item.itemsList[itemstack.itemID];

					if (itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F)
					{
						if (!par1EntityPlayer.capabilities.isCreativeMode)
						{
							--itemstack.stackSize;
						}

						this.heal((float)itemfood.getHealAmount());

						if (itemstack.stackSize <= 0)
						{
							par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
						}

						return true;
					}
				}
			}

			if (par1EntityPlayer.getCommandSenderName().equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote)
			{
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
				this.setTarget((Entity)null);
				this.setAttackTarget((EntityLivingBase)null);
			}
		}
		else if (itemstack != null && itemstack.itemID == Items.vaiziCurrency.itemID && !this.isAngry())
		{
			if (!par1EntityPlayer.capabilities.isCreativeMode)
			{
				--itemstack.stackSize;
			}

			if (itemstack.stackSize <= 0)
			{
				par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
			}

			if (!this.worldObj.isRemote)
			{
				if (this.rand.nextInt(3) == 0)
				{
					this.setTamed(true);
					this.setPathToEntity((PathEntity)null);
					this.setAttackTarget((EntityLivingBase)null);
					this.aiSit.setSitting(true);
					this.setHealth(20.0F);
					this.setOwner(par1EntityPlayer.getCommandSenderName());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte)7);
				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
				}
			}

			return true;
		}

		return super.interact(par1EntityPlayer);
	}

	public boolean func_70922_bv()
	{
		return this.dataWatcher.getWatchableObjectByte(19) == 1;
	}

	public boolean func_142018_a(EntityLivingBase par1EntityLivingBase, EntityLivingBase par2EntityLivingBase)
	{
		if (!(par1EntityLivingBase instanceof EntityCreeper) && !(par1EntityLivingBase instanceof EntityGhast))
		{
			if (par1EntityLivingBase instanceof EntityTasaravMallor)
			{
				EntityTasaravMallor entitywolf = (EntityTasaravMallor)par1EntityLivingBase;

				if (entitywolf.isTamed() && entitywolf.func_130012_q() == par2EntityLivingBase)
				{
					return false;
				}
			}

			return par1EntityLivingBase instanceof EntityPlayer && par2EntityLivingBase instanceof EntityPlayer && !((EntityPlayer)par2EntityLivingBase).canAttackPlayer((EntityPlayer)par1EntityLivingBase) ? false : !(par1EntityLivingBase instanceof EntityHorse) || !((EntityHorse)par1EntityLivingBase).isTame();
		}
		else
		{
			return false;
		}
	}

	protected boolean canDespawn()
	{
		return !this.isTamed() && this.ticksExisted > 2400;
	}

	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
		this.isTasaravAlive = false;
		TileEntityShrine.isTasaravDead = true;
	}

	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(Items.tasaravSword);
	}
}
