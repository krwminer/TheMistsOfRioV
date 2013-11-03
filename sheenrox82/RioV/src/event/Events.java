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
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.block.BlockRioVSapling;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.EntityPlayerRaceData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Events 
{
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
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && EntityPlayerRaceData.get((EntityPlayer) event.entity) == null)
		{
			EntityPlayerRaceData.register((EntityPlayer) event.entity);
		}
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(EntityPlayerRaceData.EXT_PROP_NAME) == null)
		{
			event.entity.registerExtendedProperties(EntityPlayerRaceData.EXT_PROP_NAME, new EntityPlayerRaceData((EntityPlayer) event.entity));
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