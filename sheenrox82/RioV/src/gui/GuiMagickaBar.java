package sheenrox82.RioV.src.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.EventPriority;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.util.PlayerNBT;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMagickaBar extends Gui
{
	public Minecraft mc;

	public GuiMagickaBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void renderMagickaBar(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		PlayerNBT props = PlayerNBT.get(mc.thePlayer);
		GuiIngame gig = new GuiIngame(Minecraft.getMinecraft());
		FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
		ResourceLocation icons = new ResourceLocation("riov", "textures/gui/mana_bar.png");
		int width = event.resolution.getScaledWidth();
		int height = event.resolution.getScaledHeight();

		if (props == null || props.maxMana == 0)
		{
			return;
		}

		if(Config.HUD)
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				Minecraft.getMinecraft().renderEngine.bindTexture(icons);
				float magicka = (int)(((float) props.getCurrentMagicka() / props.maxMana) * 80);
				this.drawTexturedModalRect(20, height - 20, 0, 49, 102, 14);
				this.drawTexturedModalRect(31, height - 16, 11, 64, (int)magicka, 6);
			}
		}

		if(!Config.HUD)
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				GL11.glPushMatrix();
				fontrenderer.drawStringWithShadow("Magicka: " + props.getCurrentMagicka() + "/" + props.maxMana, 32, height - 18, 16777215);
				GL11.glPopMatrix();
			}
		}
	}
}
