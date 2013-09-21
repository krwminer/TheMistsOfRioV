package sheenrox82.RioV.src.entity.mob.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.mob.core.EntityMobDeadBody;

public class EntityGalokin extends EntityMobDeadBody
{
	public static final ItemStack defaultHeldItem;

	public EntityGalokin(World par1World) {

		super(par1World);
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWander(this,  0.56D));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this,  0.56D, true));
		this.setCurrentItemOrArmor(4, new ItemStack(Items.galokinHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(Items.galokinChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(Items.galokinLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(Items.galokinBoots));
		isImmuneToFire = false;
		if(TheMistsOfRioV.riovValis)
		{
			isImmuneToFire = true;
		}
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

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.62D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(17.0D);
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}

	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(Items.galokinSword);
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(Items.galokinCrystal.itemID, 1);
		}
	}
}
