package sheenrox82.RioV.src.event;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.content.Items;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityDropEvent 
{
	@SideOnly(Side.SERVER)
	@ForgeSubscribe
	public void onEntityDrop(LivingDropsEvent event) 
	{
		if(Config.allowCoinDrop)
		{
			if (event.source.getDamageType().equals("player")) 
			{
				if (event.entityLiving instanceof EntityBlaze) 
				{
					event.entityLiving.dropItem(Items.onyx.itemID, 3);
					event.entityLiving.dropItem(Items.goldCoin.itemID, 5);
				}
				if (event.entityLiving instanceof EntityZombie) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 3);
				}
				if (event.entityLiving instanceof EntitySkeleton) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 4);
				}
				if (event.entityLiving instanceof EntityDragon) 
				{
					event.entityLiving.dropItem(Items.goldCoin.itemID, 100);
				}
				if (event.entityLiving instanceof EntitySilverfish) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 2);
				}
				if (event.entityLiving instanceof EntityPig) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 1);
				}
				if (event.entityLiving instanceof EntityCow) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 2);
				}
				if (event.entityLiving instanceof EntitySheep) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 1);
				}
				if (event.entityLiving instanceof EntityChicken) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 1);
				}
				if (event.entityLiving instanceof EntityEnderman) 
				{
					event.entityLiving.dropItem(Items.goldCoin.itemID, 3);
				}
				if (event.entityLiving instanceof EntityCreeper) 
				{
					event.entityLiving.dropItem(Items.goldCoin.itemID, 2);
				}
				if (event.entityLiving instanceof EntityCaveSpider) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 4);
				}
				if (event.entityLiving instanceof EntityGhast) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 8);
				}
				if (event.entityLiving instanceof EntityMagmaCube) 
				{
					event.entityLiving.dropItem(Items.goldCoin.itemID, 2);
				}
				if (event.entityLiving instanceof EntityPigZombie) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 5);
				}
				if (event.entityLiving instanceof EntitySlime) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 1);
				}
				if (event.entityLiving instanceof EntityWitch) 
				{
					event.entityLiving.dropItem(Items.goldCoin.itemID, 2);
				}
				if (event.entityLiving instanceof EntityWither) 
				{
					event.entityLiving.dropItem(Items.goldCoin.itemID, 25);
				}
				if (event.entityLiving instanceof EntitySquid) 
				{
					event.entityLiving.dropItem(Items.silverCoin.itemID, 4);
				}
				if (event.entityLiving instanceof EntityVillager) 
				{
					event.entityLiving.dropItem(Items.goldCoin.itemID, 1);
				}
			}
		}
		
		if (event.source.getDamageType().equals("player")) 
		{
			if (event.entityLiving instanceof EntityHorse) 
			{
				event.entityLiving.dropItem(Items.horseMeat.itemID, 2);
			}
		}
	}
}