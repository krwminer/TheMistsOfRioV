package sheenrox82.RioV.src.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunBodyguard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.hostile.EntityBloodGhoul;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkElf;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.hostile.EntityHellhound;
import sheenrox82.RioV.src.entity.mob.hostile.EntityMage;
import sheenrox82.RioV.src.entity.mob.hostile.EntityShadow;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTef;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTefGuard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTerron;
import sheenrox82.RioV.src.entity.mob.hostile.EntityVravinite;
import sheenrox82.RioV.src.entity.mob.passive.EntityAdv;
import sheenrox82.RioV.src.entity.mob.passive.EntityAltruEssence;
import sheenrox82.RioV.src.entity.mob.passive.EntityAngel;
import sheenrox82.RioV.src.entity.mob.passive.EntityDove;
import sheenrox82.RioV.src.entity.mob.passive.EntityFairy;
import sheenrox82.RioV.src.entity.mob.passive.EntityGalokin;
import sheenrox82.RioV.src.entity.mob.passive.EntityNizonian;
import sheenrox82.RioV.src.entity.mob.passive.EntityOrc;
import sheenrox82.RioV.src.entity.mob.passive.EntityRabbit;
import sheenrox82.RioV.src.entity.mob.passive.EntitySkeletalHorse;
import sheenrox82.RioV.src.entity.mob.passive.EntitySoverianOfficer;
import sheenrox82.RioV.src.entity.projectile.EntityDarknessArrow;
import sheenrox82.RioV.src.entity.projectile.EntityVraviniteArrow;
import sheenrox82.RioV.src.handler.HudHandler;
import sheenrox82.RioV.src.render.RenderAdv;
import sheenrox82.RioV.src.render.RenderAltruEssence;
import sheenrox82.RioV.src.render.RenderAngel;
import sheenrox82.RioV.src.render.RenderAunTun;
import sheenrox82.RioV.src.render.RenderAunTunBodyguard;
import sheenrox82.RioV.src.render.RenderAunTunMinion;
import sheenrox82.RioV.src.render.RenderBloodGhoul;
import sheenrox82.RioV.src.render.RenderDarkElf;
import sheenrox82.RioV.src.render.RenderDarkEssence;
import sheenrox82.RioV.src.render.RenderDemonAngel;
import sheenrox82.RioV.src.render.RenderDove;
import sheenrox82.RioV.src.render.RenderFairy;
import sheenrox82.RioV.src.render.RenderGalokin;
import sheenrox82.RioV.src.render.RenderHellhound;
import sheenrox82.RioV.src.render.RenderMage;
import sheenrox82.RioV.src.render.RenderNizonian;
import sheenrox82.RioV.src.render.RenderOrc;
import sheenrox82.RioV.src.render.RenderRabbit;
import sheenrox82.RioV.src.render.RenderShadow;
import sheenrox82.RioV.src.render.RenderSkeletalHorse;
import sheenrox82.RioV.src.render.RenderSoverianOfficer;
import sheenrox82.RioV.src.render.RenderTef;
import sheenrox82.RioV.src.render.RenderTefGuard;
import sheenrox82.RioV.src.render.RenderTerron;
import sheenrox82.RioV.src.render.RenderVravinite;
import sheenrox82.RioV.src.render.item.ItemRenderBloodChest;
import sheenrox82.RioV.src.render.item.ItemRenderCherryBlossomChest;
import sheenrox82.RioV.src.render.item.ItemRenderGlimmerwoodChest;
import sheenrox82.RioV.src.render.item.ItemRenderSkywoodChest;
import sheenrox82.RioV.src.render.item.RenderItemBow;
import sheenrox82.RioV.src.render.item.RenderLongBow;
import sheenrox82.RioV.src.render.item.RenderShield;
import sheenrox82.RioV.src.render.projectile.RenderDarknessArrow;
import sheenrox82.RioV.src.render.projectile.RenderVraviniteArrow;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityBloodChest;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityCherryBlossomChest;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntityGlimmerwoodChest;
import sheenrox82.RioV.src.render.tileentity.RenderTileEntitySkywoodChest;
import sheenrox82.RioV.src.tileentity.TileEntityBloodChest;
import sheenrox82.RioV.src.tileentity.TileEntityCherryBlossomChest;
import sheenrox82.RioV.src.tileentity.TileEntityGlimmerwoodChest;
import sheenrox82.RioV.src.tileentity.TileEntitySkywoodChest;

import com.jadarstudios.developercapes.DevCapesUtil;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy 
{	
	@Override
	public void init() 
	{
		HudHandler hudHandler = new HudHandler();
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderMage());
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunBodyguard.class, new RenderAunTunBodyguard());
		RenderingRegistry.registerEntityRenderingHandler(EntityAdv.class, new RenderAdv());
		RenderingRegistry.registerEntityRenderingHandler(EntityTerron.class, new RenderTerron());
		RenderingRegistry.registerEntityRenderingHandler(EntityDemonAngel.class, new RenderDemonAngel());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkElf.class, new RenderDarkElf());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessArrow.class, new RenderDarknessArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTun.class, new RenderAunTun());
		RenderingRegistry.registerEntityRenderingHandler(EntityAltruEssence.class, new RenderAltruEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityNizonian.class, new RenderNizonian());
		RenderingRegistry.registerEntityRenderingHandler(EntityGalokin.class, new RenderGalokin());
		RenderingRegistry.registerEntityRenderingHandler(EntityOrc.class, new RenderOrc());
		RenderingRegistry.registerEntityRenderingHandler(EntityFairy.class, new RenderFairy());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkEssence.class, new RenderDarkEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class, new RenderHellhound());
		RenderingRegistry.registerEntityRenderingHandler(EntityTef.class, new RenderTef());
		RenderingRegistry.registerEntityRenderingHandler(EntityTefGuard.class, new RenderTefGuard());
		RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, new RenderShadow());
		RenderingRegistry.registerEntityRenderingHandler(EntityVravinite.class, new RenderVravinite());
		RenderingRegistry.registerEntityRenderingHandler(EntityDove.class, new RenderDove());
		RenderingRegistry.registerEntityRenderingHandler(EntityAngel.class, new RenderAngel());
		RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RenderRabbit());
		RenderingRegistry.registerEntityRenderingHandler(EntitySoverianOfficer.class, new RenderSoverianOfficer());
		TickRegistry.registerTickHandler(hudHandler, Side.CLIENT);
		RenderingRegistry.registerEntityRenderingHandler(EntityVraviniteArrow.class, new RenderVraviniteArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunMinion.class, new RenderAunTunMinion());
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodGhoul.class, new RenderBloodGhoul());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGlimmerwoodChest.class, new RenderTileEntityGlimmerwoodChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCherryBlossomChest.class, new RenderTileEntityCherryBlossomChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkywoodChest.class, new RenderTileEntitySkywoodChest());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBloodChest.class, new RenderTileEntityBloodChest());
	}

	@Override
	public void registerItemRenderers()
	{
		MinecraftForgeClient.registerItemRenderer(Blocks.glimmerwoodChest.blockID, new ItemRenderGlimmerwoodChest());
		MinecraftForgeClient.registerItemRenderer(Blocks.cherryBlossomChest.blockID, new ItemRenderCherryBlossomChest());
		MinecraftForgeClient.registerItemRenderer(Blocks.bloodChest.blockID, new ItemRenderBloodChest());
		MinecraftForgeClient.registerItemRenderer(Blocks.skywoodChest.blockID, new ItemRenderSkywoodChest());
		MinecraftForgeClient.registerItemRenderer(Items.bowOfWurTun.itemID, new RenderItemBow());
		MinecraftForgeClient.registerItemRenderer(Items.enforcedBowOfWurTun.itemID, new RenderItemBow());
		MinecraftForgeClient.registerItemRenderer(Items.longbow.itemID, new RenderLongBow());
		MinecraftForgeClient.registerItemRenderer(Items.vraviniteBow.itemID, new RenderLongBow());
		MinecraftForgeClient.registerItemRenderer(Items.onyxShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.amethystShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.vraviniteShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.sapphireShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.topazShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.shieldOfFlame.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.blindoniteShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.woodenShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.stoneShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.ironShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.goldShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.diamondShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.dragonShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.auntunShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.mythrilShield.itemID, new RenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.galokinShield.itemID, new RenderShield());
	}

	@Override
	public void cape()
	{
		DevCapesUtil.getInstance().addFileUrl("https://dl.dropbox.com/u/126631367/Capes.txt");
	}

	public static int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
}