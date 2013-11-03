package sheenrox82.RioV.src.entity.mob.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.content.Sound;
import sheenrox82.RioV.src.entity.mob.core.EntityMobDeadBody;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkElf;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.hostile.EntityMage;
import sheenrox82.RioV.src.entity.mob.hostile.EntityPaladin;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTerron;

public class EntitySoverianOfficer extends EntityMobDeadBody
{
	private static ItemStack defaultHeldItem;

	public EntitySoverianOfficer(World par1World)
	{
		super(par1World);
		isImmuneToFire = false;
		if(TheMistsOfRioV.getInstance().riovValis)
		{
			isImmuneToFire = true;
		}
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.56D));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDarkElf.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDemonAngel.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMage.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTerron.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityGhast.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMagmaCube.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPigZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDarkEssence.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAdv.class, 0, true));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));
		this.setCurrentItemOrArmor(4, new ItemStack(Items.onyxHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(Items.onyxChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(Items.onyxLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(Items.onyxBoots));

	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
	}

	@Override
	protected boolean isValidLightLevel()
	{
		return true; //don't care about the light level to spawn
	}

	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(Items.onyxSword);
	}

	protected void attackEntity(Entity par1Entity, float par2)
	{

	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var1 = this.rand.nextInt(10);

		if (var1 == 0)
		{		
		}
		if (var1 == 1)
		{
			this.dropItem(Items.onyxSword.itemID, 1);
		}
		if (var1 == 2)
		{	
		}
		if (var1 == 3)
		{			
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
		}
		if (var1 == 8)
		{
		}
		if (var1 == 9)
		{
		}

	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(10.0D);
	}
	
	@Override
	protected String getLivingSound()
	{
		return Sound.exhale;
	}
	
	@Override
	protected String getHurtSound()
	{
		return Sound.pain;
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
    {
		par1EntityPlayer.playSound(Sound.hello, 1, 1);
		
		if(!this.worldObj.isRemote)
		par1EntityPlayer.sendChatToPlayer(ChatMessageComponent.createFromText("Hello to you too, " + par1EntityPlayer.username + "!"));
		return true;
    }
}
