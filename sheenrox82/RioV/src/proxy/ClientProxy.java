package sheenrox82.RioV.src.proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.mob.bosses.vanilla.EntityChickenBoss;
import sheenrox82.RioV.src.entity.mob.bosses.vanilla.EntityCowBoss;
import sheenrox82.RioV.src.entity.mob.bosses.vanilla.EntityPigBoss;
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
import sheenrox82.RioV.src.entity.mob.passive.EntityWoodElf;
import sheenrox82.RioV.src.entity.projectile.EntityDarknessArrow;
import sheenrox82.RioV.src.entity.projectile.EntityVraviniteArrow;
import sheenrox82.RioV.src.handler.HudHandler;
import sheenrox82.RioV.src.lib.EntityResourceLocation;
import sheenrox82.RioV.src.model.ModelDemonAngel;
import sheenrox82.RioV.src.model.ModelHellhound;
import sheenrox82.RioV.src.model.ModelTerron;
import sheenrox82.RioV.src.render.RenderAngel;
import sheenrox82.RioV.src.render.RenderAunTun;
import sheenrox82.RioV.src.render.RenderBipedCore;
import sheenrox82.RioV.src.render.RenderBossCore;
import sheenrox82.RioV.src.render.RenderDarkEssence;
import sheenrox82.RioV.src.render.RenderDove;
import sheenrox82.RioV.src.render.RenderEssence;
import sheenrox82.RioV.src.render.RenderFairy;
import sheenrox82.RioV.src.render.RenderLivingCore;
import sheenrox82.RioV.src.render.RenderOrc;
import sheenrox82.RioV.src.render.RenderRabbit;
import sheenrox82.RioV.src.render.RenderSkeletalHorse;
import sheenrox82.RioV.src.render.RenderTef;
import sheenrox82.RioV.src.render.boss.RenderChickenBoss;
import sheenrox82.RioV.src.render.boss.RenderCowBoss;
import sheenrox82.RioV.src.render.boss.RenderPigBoss;
import sheenrox82.RioV.src.render.item.ItemRenderBloodChest;
import sheenrox82.RioV.src.render.item.ItemRenderBow;
import sheenrox82.RioV.src.render.item.ItemRenderCherryBlossomChest;
import sheenrox82.RioV.src.render.item.ItemRenderGlimmerwoodChest;
import sheenrox82.RioV.src.render.item.ItemRenderLongbow;
import sheenrox82.RioV.src.render.item.ItemRenderShield;
import sheenrox82.RioV.src.render.item.ItemRenderSkywoodChest;
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
import sheenrox82.RioV.src.util.Util;

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
		RenderingRegistry.registerEntityRenderingHandler(EntityMage.class, new RenderBipedCore(EntityResourceLocation.mage));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletalHorse.class, new RenderSkeletalHorse());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunBodyguard.class, new RenderBipedCore(EntityResourceLocation.auntun));
		RenderingRegistry.registerEntityRenderingHandler(EntityAdv.class, new RenderBipedCore(EntityResourceLocation.adventurer));
		RenderingRegistry.registerEntityRenderingHandler(EntityTerron.class, new RenderBossCore(new ModelTerron(), 0.5F, 1.2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDemonAngel.class, new RenderBossCore(new ModelDemonAngel(), 0.5F, 2F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkElf.class, new RenderBipedCore(EntityResourceLocation.dark_elf));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarknessArrow.class, new RenderDarknessArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTun.class, new RenderAunTun());
		RenderingRegistry.registerEntityRenderingHandler(EntityAltruEssence.class, new RenderEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityNizonian.class, new RenderLivingCore(new ModelTerron(), 0.5F, 0.9F, 0.9F, 0.9F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGalokin.class, new RenderBipedCore(EntityResourceLocation.galokin));
		RenderingRegistry.registerEntityRenderingHandler(EntityOrc.class, new RenderOrc());
		RenderingRegistry.registerEntityRenderingHandler(EntityFairy.class, new RenderFairy());
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkEssence.class, new RenderDarkEssence());
		RenderingRegistry.registerEntityRenderingHandler(EntityHellhound.class, new RenderLivingCore(new ModelHellhound(), 0.6F, 1.5F, 1.5F, 1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodElf.class, new RenderBipedCore(EntityResourceLocation.wood_elf));
		RenderingRegistry.registerEntityRenderingHandler(EntityTef.class, new RenderTef());
		RenderingRegistry.registerEntityRenderingHandler(EntityTefGuard.class, new RenderBipedCore(EntityResourceLocation.essence));
		RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, new RenderBipedCore(EntityResourceLocation.shadow));
		RenderingRegistry.registerEntityRenderingHandler(EntityVravinite.class, new RenderBipedCore(EntityResourceLocation.vravinite));
		RenderingRegistry.registerEntityRenderingHandler(EntityDove.class, new RenderDove());
		RenderingRegistry.registerEntityRenderingHandler(EntityAngel.class, new RenderAngel());
		RenderingRegistry.registerEntityRenderingHandler(EntityRabbit.class, new RenderRabbit());
		RenderingRegistry.registerEntityRenderingHandler(EntitySoverianOfficer.class, new RenderBipedCore(EntityResourceLocation.officer));
		RenderingRegistry.registerEntityRenderingHandler(EntityPigBoss.class, new RenderPigBoss());
		RenderingRegistry.registerEntityRenderingHandler(EntityCowBoss.class, new RenderCowBoss());
		RenderingRegistry.registerEntityRenderingHandler(EntityChickenBoss.class, new RenderChickenBoss(new ResourceLocation(Util.MOD_ID + ":" + "textures/entity/ChickenBoss.png")));
		TickRegistry.registerTickHandler(hudHandler, Side.CLIENT);
		RenderingRegistry.registerEntityRenderingHandler(EntityVraviniteArrow.class, new RenderVraviniteArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityAunTunMinion.class, new RenderBipedCore(EntityResourceLocation.auntun));
		RenderingRegistry.registerEntityRenderingHandler(EntityBloodGhoul.class, new RenderBipedCore(EntityResourceLocation.blood_ghoul));
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
		MinecraftForgeClient.registerItemRenderer(Items.bowOfWurTun.itemID, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(Items.enforcedBowOfWurTun.itemID, new ItemRenderBow());
		MinecraftForgeClient.registerItemRenderer(Items.vraviniteBow.itemID, new ItemRenderLongbow());
		MinecraftForgeClient.registerItemRenderer(Items.onyxShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.amethystShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.vraviniteShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.sapphireShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.topazShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.shieldOfFlame.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.blindoniteShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.woodenShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.stoneShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.ironShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.goldShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.diamondShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.dragonShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.auntunShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.mythrilShield.itemID, new ItemRenderShield());
		MinecraftForgeClient.registerItemRenderer(Items.galokinShield.itemID, new ItemRenderShield());
	}

	@Override
	public void cape()
	{
		DevCapesUtil.addFileUrl("https://dl.dropbox.com/u/126631367/Capes.txt");
	}

	public static int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
}