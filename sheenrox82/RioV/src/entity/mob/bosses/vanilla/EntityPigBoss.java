package sheenrox82.RioV.src.entity.mob.bosses.vanilla;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;
import sheenrox82.RioV.src.entity.mob.core.EntityMobDeadBody;

public class EntityPigBoss extends EntityMobDeadBody implements IBossDisplayData
{
    private final EntityAIControlledByPlayer aiControlledByPlayer;

    public EntityPigBoss(World par1World)
    {
        super(par1World);
        this.setSize(3F, 3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiControlledByPlayer = new EntityAIControlledByPlayer(this, 0.3F));
        this.tasks.addTask(4, new EntityAITempt(this, 0.56D, Item.carrotOnAStick.itemID, false));
        this.tasks.addTask(4, new EntityAITempt(this, 0.56D, Item.carrot.itemID, false));
        this.tasks.addTask(6, new EntityAIWander(this, 0.56D));
        this.tasks.addTask(8, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.56D, true));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(110.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(10D);
    }

    protected void updateAITasks()
    {
        super.updateAITasks();
    }

    public boolean canBeSteered()
    {
        ItemStack itemstack = ((EntityPlayer)this.riddenByEntity).getHeldItem();
        return itemstack != null && itemstack.itemID == Item.carrotOnAStick.itemID;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Saddle", this.getSaddled());
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setSaddled(par1NBTTagCompound.getBoolean("Saddle"));
    }

    protected String getLivingSound()
    {
        return "mob.pig.say";
    }

    protected String getHurtSound()
    {
        return "mob.pig.say";
    }

    protected String getDeathSound()
    {
        return "mob.pig.death";
    }

    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("mob.pig.step", 0.15F, 1.0F);
    }

    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        if (super.interact(par1EntityPlayer))
        {
            return true;
        }
        else if (this.getSaddled() && !this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer))
        {
            par1EntityPlayer.mountEntity(this);
            return true;
        }
        else
        {
            return false;
        }
    }

    protected int getDropItemId()
    {
        return this.isBurning() ? Item.porkCooked.itemID : Item.porkRaw.itemID;
    }

    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

        for (int k = 0; k < j; ++k)
        {
            if (this.isBurning())
            {
                this.dropItem(Item.porkCooked.itemID, 1);
            }
            else
            {
                this.dropItem(Item.porkRaw.itemID, 1);
            }
        }

        if (this.getSaddled())
        {
            this.dropItem(Item.saddle.itemID, 1);
        }
    }

    public boolean getSaddled()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setSaddled(boolean par1)
    {
        if (par1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)1));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)0));
        }
    }

    public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt)
    {
        if (!this.worldObj.isRemote)
        {
            EntityPigZombie entitypigzombie = new EntityPigZombie(this.worldObj);
            entitypigzombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.worldObj.spawnEntityInWorld(entitypigzombie);
            this.setDead();
        }
    }

    protected void fall(float par1)
    {
        super.fall(par1);

        if (par1 > 5.0F && this.riddenByEntity instanceof EntityPlayer)
        {
            ((EntityPlayer)this.riddenByEntity).triggerAchievement(AchievementList.flyPig);
        }
    }

    public EntityPigBoss spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityPigBoss(this.worldObj);
    }

    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.itemID == Item.carrot.itemID;
    }

    public EntityAIControlledByPlayer getAIControlledByPlayer()
    {
        return this.aiControlledByPlayer;
    }
}
