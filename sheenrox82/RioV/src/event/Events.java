package sheenrox82.RioV.src.event;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import sheenrox82.RioV.src.block.BlockRioVSapling;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.proxy.CommonProxy;
import sheenrox82.RioV.src.util.PlayerNBT;

public class Events
{
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{

		if (event.entity instanceof EntityPlayer && PlayerNBT.get((EntityPlayer) event.entity) == null)
			PlayerNBT.register((EntityPlayer) event.entity);
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(PlayerNBT.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(PlayerNBT.EXT_PROP_NAME, new PlayerNBT((EntityPlayer) event.entity));
	}

	@ForgeSubscribe
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			NBTTagCompound playerData = CommonProxy.getEntityData(((EntityPlayer) event.entity).username + PlayerNBT.EXT_PROP_NAME);
			if (playerData != null) 
			{
				((PlayerNBT)(event.entity.getExtendedProperties(PlayerNBT.EXT_PROP_NAME))).loadNBTData(playerData);
			}
			((PlayerNBT)(event.entity.getExtendedProperties(PlayerNBT.EXT_PROP_NAME))).sync();
		}
	}

	@ForgeSubscribe
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			NBTTagCompound playerData = new NBTTagCompound();
			((PlayerNBT)(event.entity.getExtendedProperties(PlayerNBT.EXT_PROP_NAME))).saveNBTData(playerData);
			CommonProxy.storeEntityData(((EntityPlayer) event.entity).username + PlayerNBT.EXT_PROP_NAME, playerData);
			PlayerNBT.saveProxyData((EntityPlayer) event.entity);
		}
	}

	@ForgeSubscribe
	public void onEntityDrop(LivingDropsEvent event) 
	{
		if (event.source.getDamageType().equals("player")) 
		{
			if (event.entityLiving instanceof EntityBlaze) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 1);
			}
			if (event.entityLiving instanceof EntityDragon) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 40);
			}
			if (event.entityLiving instanceof EntityEnderman) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 1);
			}
			if (event.entityLiving instanceof EntityCreeper) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 1);
			}
			if (event.entityLiving instanceof EntityGhast) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 3);
			}
			if (event.entityLiving instanceof EntityPigZombie) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 2);
			}
			if (event.entityLiving instanceof EntityWitch) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 2);
			}
			if (event.entityLiving instanceof EntityWither) 
			{
				event.entityLiving.dropItem(Items.vaiziCurrency.itemID, 5);
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

	@ForgeSubscribe
	public void bonemealUsed(net.minecraftforge.event.entity.player.BonemealEvent event)
	{
		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.glimmerwoodSapling.blockID)
		{
			((BlockRioVSapling)Blocks.glimmerwoodSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}

		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.cherryBlossomSapling.blockID)
		{
			((BlockRioVSapling)Blocks.cherryBlossomSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}

		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.bloodSapling.blockID)
		{
			((BlockRioVSapling)Blocks.bloodSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}

		if(event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.skywoodSapling.blockID)
		{
			((BlockRioVSapling)Blocks.skywoodSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
	}
}