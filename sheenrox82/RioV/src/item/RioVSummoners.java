package sheenrox82.RioV.src.item;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
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
import sheenrox82.RioV.src.entity.mob.hostile.EntityTerron;
import sheenrox82.RioV.src.util.Color;
import sheenrox82.RioV.src.util.PlayerNBT;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVSummoners extends Item
{

	public RioVSummoners(int par1)
	{
		super(par1 - 256);
		this.maxStackSize = 1;
		this.setMaxDamage(1);
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer entityplayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		PlayerNBT player = PlayerNBT.get(entityplayer);

		if(world.provider.dimensionId == Config.blindOasisID)
		{
			if (par1ItemStack.itemID == Items.terronCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					if(player.getCurrentEos() > 3)
					{
						while (var4 < 1)
						{
							if(player.consumeEos(3))
							{
								EntityTerron var5 = new EntityTerron(world);
								var5.setPosition(par4, par5+1, par6);
								world.spawnEntityInWorld(var5);
								++var4;
								Minecraft.getMinecraft().thePlayer.addChatMessage("[Terron] has been summoned!");
								par1ItemStack.damageItem(2, entityplayer);
							}
						}

					}
					else
					{
						entityplayer.sendChatToPlayer(ChatMessageComponent.createFromText("You do not have enough Eos!"));
					}
				}

			}

			if (par1ItemStack.itemID == Items.tefCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					if(player.getCurrentEos() > 4)
					{
						while (var4 < 1)
						{
							if(player.consumeEos(4))
							{
								EntityTef var5 = new EntityTef(world);
								var5.setPosition(par4, par5+1, par6);
								world.spawnEntityInWorld(var5);
								++var4;
								Minecraft.getMinecraft().thePlayer.addChatMessage("[\u00A74Tef\u00A7f] has been summoned!");
								par1ItemStack.damageItem(2, entityplayer);
							}
						}
					}
					else
					{
						entityplayer.sendChatToPlayer(ChatMessageComponent.createFromText("You do not have enough Eos!"));
					}
				}
			}

			if (par1ItemStack.itemID == Items.theDarknessCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					if(player.getCurrentEos() > 18)
					{
						while (var4 < 1)
						{
							if(player.consumeEos(18))
							{
								EntityDarkEssence var5 = new EntityDarkEssence(world);
								var5.setPosition(par4, par5+1, par6);
								world.spawnEntityInWorld(var5);
								++var4;
								Minecraft.getMinecraft().thePlayer.addChatMessage("[\u00A70The Darkness\u00A7f] has arrived!");
								par1ItemStack.damageItem(2, entityplayer);
							}

						}
					}
					else
					{
						entityplayer.sendChatToPlayer(ChatMessageComponent.createFromText("You do not have enough Eos!"));
					}
				}
			}
		}

		if(world.provider.dimensionId == Config.flamonorID)
		{
			if (par1ItemStack.itemID == Items.demonAngelCrystal.itemID)
			{
				int var4 = 0;
				if (!world.isRemote)
				{
					if(player.getCurrentEos() > 12)
					{

						while (var4 < 1)
						{
							if(player.consumeEos(12))
							{
								EntityDemonAngel var5 = new EntityDemonAngel(world);
								var5.setPosition(par4, par5+1, par6);
								world.spawnEntityInWorld(var5);
								++var4;
								Minecraft.getMinecraft().thePlayer.addChatMessage("[\u00A74Demon Angel\u00A7f] has been summoned!");
								par1ItemStack.damageItem(2, entityplayer);
							}
						}
					}
					else
					{
						entityplayer.sendChatToPlayer(ChatMessageComponent.createFromText("You do not have enough Eos!"));
					}
				}
			}

			if (par1ItemStack.itemID == Items.auntunSummoner.itemID)
			{
				int var4 = 0;

				if (!world.isRemote)
				{
					if(player.getCurrentEos() > 34)
					{
						while (var4 < 1)
						{
							if(player.consumeEos(34))
							{
								EntityAunTun var5 = new EntityAunTun(world);
								var5.setPosition(par4, par5+1, par6);
								world.spawnEntityInWorld(var5);
								++var4;
								Minecraft.getMinecraft().thePlayer.addChatMessage(Color.DARK_RED + "Aun'Tun has been summoned!" + Color.WHITE + " Good luck, this'll be a LONG fight.");
								par1ItemStack.damageItem(2, entityplayer);
							}
						}
					}
					else
					{
						entityplayer.sendChatToPlayer(ChatMessageComponent.createFromText("You do not have enough Eos!"));
					}
				}
			}
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

		if (var1.itemID == Items.demonAngelCrystal.itemID || var1.itemID == Items.auntunSummoner.itemID)
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
		if(itemID == Items.auntunSummoner.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "auntunSummoner");
		}
	}

}

