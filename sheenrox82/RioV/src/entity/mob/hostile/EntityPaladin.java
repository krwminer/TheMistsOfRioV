package sheenrox82.RioV.src.entity.mob.hostile;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.mob.core.EntityMobDeadBody;
import sheenrox82.RioV.src.entity.mob.passive.EntityAdv;
import sheenrox82.RioV.src.entity.mob.passive.EntityAltruEssence;


public class EntityPaladin extends EntityMobDeadBody implements IBossDisplayData
{
	public static final ItemStack defaultHeldItem;

	public EntityPaladin(World par1World)
	{
		super(par1World);
		this.experienceValue = 50;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this, 0.56D));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMage.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAunTunMinion.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAunTunBodyguard.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDemonAngel.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTerron.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDarkElf.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAdv.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAltruEssence.class, 0, true));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));
		this.setCurrentItemOrArmor(4, new ItemStack(Items.paladinHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(Items.paladinChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(Items.paladinLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(Items.paladinBoots));
		if(TheMistsOfRioV.getInstance().riovValis)
		{
			isImmuneToFire = true;
		}
	}
	
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(100));
	}
	
	protected boolean isValidLightLevel()
    {
        return true;
    }
	
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
	}
	
	public void onLivingUpdate()
	{
		if (!this.worldObj.isRemote)
		{
		}
		super.onLivingUpdate();
	}
	
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(100.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.56D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(10.0D);
	}
	
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(Items.paladinLongsword);
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(Items.paladinLongsword.itemID, 1);
	}

}