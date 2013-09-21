package sheenrox82.RioV.src.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTun;
import sheenrox82.RioV.src.entity.mob.hostile.EntityAunTunMinion;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDarkEssence;
import sheenrox82.RioV.src.entity.mob.hostile.EntityDemonAngel;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTef;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTefGuard;
import sheenrox82.RioV.src.entity.mob.hostile.EntityTerron;
import sheenrox82.RioV.src.util.Util;

public class RioVSummoners extends Item
{

	public RioVSummoners(int par1)
	{
		super(par1 - 256);
		this.maxStackSize = 1;
		this.setMaxDamage(1);
		this.setCreativeTab(TheMistsOfRioV.tab);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer entityplayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(world.provider.dimensionId == Config.blindOasisID)
		{
			if (par1ItemStack.itemID == Items.terronCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					while (var4 < 1)//1 gets the amount of mobs to spawn at once
					{
						EntityTerron var5 = new EntityTerron(world);
						var5.setPosition(par4, par5+1, par6);
						world.spawnEntityInWorld(var5);
						++var4;
					}
				}

				if(world.isRemote)
					Minecraft.getMinecraft().thePlayer.addChatMessage("[Terron] has been summoned!");
				par1ItemStack.damageItem(2, entityplayer);
				return true;
			}

			if (par1ItemStack.itemID == Items.tefCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					while (var4 < 1)//1 gets the amount of mobs to spawn at once
					{
						EntityTef var5 = new EntityTef(world);
						var5.setPosition(par4, par5+1, par6);
						world.spawnEntityInWorld(var5);
						++var4;
					}
				}

				if(world.isRemote)
					Minecraft.getMinecraft().thePlayer.addChatMessage("[\u00A74Tef\u00A7f] has been summoned!");
				par1ItemStack.damageItem(2, entityplayer);
				return true;
			}
			

			if (par1ItemStack.itemID == Items.theDarknessCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					while (var4 < 1)//1 gets the amount of mobs to spawn at once
					{
						EntityDarkEssence var5 = new EntityDarkEssence(world);
						var5.setPosition(par4, par5+1, par6);
						world.spawnEntityInWorld(var5);
						++var4;
					}
				}

				if(world.isRemote)
					Minecraft.getMinecraft().thePlayer.addChatMessage("[\u00A70The Darkness\u00A7f] has arrived!");
				par1ItemStack.damageItem(2, entityplayer);
				return true;
			}
		}

		if(world.provider.dimensionId == Config.flamonorID)
		{
			if (par1ItemStack.itemID == Items.demonAngelCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					while (var4 < 1)
					{
						EntityDemonAngel var5 = new EntityDemonAngel(world);
						var5.setPosition(par4, par5+1, par6);
						world.spawnEntityInWorld(var5);
						++var4;
					}
				}

				if(world.isRemote)
					Minecraft.getMinecraft().thePlayer.addChatMessage("[\u00A74Demon Angel\u00A7f] has been summoned!");
				par1ItemStack.damageItem(2, entityplayer);
				return true;
			}
		}

		if (par1ItemStack.itemID == Items.auntunSummoner.itemID)
		{
			int var4 = 0;
			if (!world.isRemote)
			{
				while (var4 < 1)//1 gets the amount of mobs to spawn at once
				{
					EntityAunTun var5 = new EntityAunTun(world);
					var5.setPosition(par4, par5+1, par6);
					world.spawnEntityInWorld(var5);
					++var4;
				}
				while (var4 < 20)//1 gets the amount of mobs to spawn at once
				{
					EntityAunTunMinion var5 = new EntityAunTunMinion(world);
					var5.setPosition(par4, par5+1, par6);
					world.spawnEntityInWorld(var5);
					++var4;
				}
			}

			if(world.isRemote)
				Minecraft.getMinecraft().thePlayer.addChatMessage("Aun'Tun has been summoned!");
			par1ItemStack.damageItem(2, entityplayer);
			return true;
		}

		return false;
	}

	@Override
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if (var1.itemID == Items.tefCrystal.itemID)
		{
			var3.add(StatCollector.translateToLocal("A side challenge, given by The Darkness."));
			var3.add(StatCollector.translateToLocal("Spawned in: Blind Oasis Dimension"));
		}
		
		if (var1.itemID == Items.terronCrystal.itemID || var1.itemID == Items.theDarknessCrystal.itemID)
		{
			var3.add(StatCollector.translateToLocal("Spawned in: Blind Oasis Dimension"));
		}
		
		if (var1.itemID == Items.demonAngelCrystal.itemID)
		{
			var3.add(StatCollector.translateToLocal("Spawned in: Flamonor Dimension"));
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(itemID == Items.terronCrystal.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "terronCrystal");
		}
		if(itemID == Items.demonAngelCrystal.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "demonAngelCrystal");
		}
		if(itemID == Items.theDarknessCrystal.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "theDarknessCrystal");
		}
		if(itemID == Items.tefCrystal.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "tefCrystal");
		}
	}

}

