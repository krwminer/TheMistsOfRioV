package sheenrox82.RioV.src.handler;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class HudHandler extends Container implements ITickHandler 
{
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{      
		if(Config.HUD)
		{
			if (type.equals(EnumSet.of(TickType.RENDER))) 
			{
				Minecraft mc = Minecraft.getMinecraft();

				GuiIngame gig = new GuiIngame(mc);
				FontRenderer fontrenderer = mc.fontRenderer;

				if (!mc.gameSettings.showDebugInfo)
				{
					if(mc.currentScreen == null)
					{
						mc.mcProfiler.startSection("debug");
						GL11.glPushMatrix();
						fontrenderer.drawStringWithShadow(Config.color + Util.MOD_NAME + " - " + Util.VERSION, 2, 2, 16777215);
						GL11.glPopMatrix();
					}
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.CLIENT, TickType.RENDER); // Check whether client or render
	}

	@Override
	public String getLabel() 
	{
		return Util.MOD_NAME;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) 
	{
		return false;
	}
}
