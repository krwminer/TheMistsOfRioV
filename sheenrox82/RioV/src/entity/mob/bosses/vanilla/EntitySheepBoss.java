package sheenrox82.RioV.src.entity.mob.bosses.vanilla;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import sheenrox82.RioV.src.entity.mob.core.EntityBossCore;

public class EntitySheepBoss extends EntityBossCore implements IBossDisplayData
{
	public EntitySheepBoss(World par1World)
	{
		super(par1World);
		this.setSize(4F, 4F);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAITempt(this, 0.76D, Item.wheat.itemID, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.56D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(108.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.56D);
	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
		return "mob.sheep.say";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		return "mob.sheep.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return "mob.sheep.hurt";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4)
	{
		this.playSound("mob.sheep.step", 0.15F, 1.0F);
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}

	protected int getDropItemId()
	{
		return Block.cloth.blockID;
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(Block.cloth.blockID, 4);
	}
}
