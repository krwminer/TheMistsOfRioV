package sheenrox82.RioV.src.entity.mob.hostile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.mob.core.EntityMobDeadBody;
import sheenrox82.RioV.src.entity.mob.passive.EntityAltruEssence;
import sheenrox82.RioV.src.entity.mob.passive.EntitySkeletalHorse;

public class EntityAunTun extends EntityMobDeadBody implements IBossDisplayData
{
	public static final ItemStack defaultHeldItem;

	public EntityAunTun(World par1World)
	{
		super(par1World);
		this.setSize(3F, 9F);
		this.experienceValue = 70;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityAltruEssence.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTef.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTefGuard.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDarkElf.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDemonAngel.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityMage.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySkeletalHorse.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityTerron.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityDarkEssence.class, 0, true));
		this.tasks.addTask(5, new EntityAIWander(this, 0.56D));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));
		this.setCurrentItemOrArmor(4, new ItemStack(Items.auntunMinionHelmet));
		this.setCurrentItemOrArmor(3, new ItemStack(Items.auntunMinionChestplate));
		this.setCurrentItemOrArmor(2, new ItemStack(Items.auntunMinionLeggings));
		this.setCurrentItemOrArmor(1, new ItemStack(Items.auntunMinionBoots));
		if(TheMistsOfRioV.riovValis)
		{
			isImmuneToFire = true;
		}
	}
	
	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
		if(this.worldObj.isRemote)
		Minecraft.getMinecraft().thePlayer.addChatMessage("Aun'Tun: *Grroowwwwwwwwwlllll*");
		
		if(this.worldObj.isRemote)
		Minecraft.getMinecraft().thePlayer.addChatMessage("Aun'Tun was killed!");
	}
	
	@Override
	public void onLivingUpdate()
	{
		if (!this.worldObj.isRemote)
		{

		}
		
		if (!this.worldObj.isRemote)
		{
			if (this.isWet())
			{
				this.attackEntityFrom(DamageSource.drown, 1);
			}
		}

		if (this.rand.nextInt(24) == 0)
		{
			this.worldObj.playSoundEffect(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F);
		}


		for (int i = 0; i < 2; ++i)
		{
			this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}
		
		super.onLivingUpdate();
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	public ItemStack getHeldItem()
	{
		return defaultHeldItem;
	}

	static
	{
		defaultHeldItem = new ItemStack(Items.axeOfAunTun);
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		this.dropItem(Items.agonite.itemID, 10);
		this.dropItem(Items.darkMatter.itemID, 20);
		this.dropItem(Items.dragonSoul.itemID, 10);
		this.dropItem(Items.onyx.itemID, 20);
		this.dropItem(Items.axeOfAunTun.itemID, 1);
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10000.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.62D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(300.0D);
	}
}