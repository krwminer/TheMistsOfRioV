package sheenrox82.RioV.src.gui;

import java.io.IOException;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonLanguage;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenOnlineServers;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.mco.ExceptionMcoService;
import net.minecraft.client.mco.GuiScreenClientOutdated;
import net.minecraft.client.mco.McoClient;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Project;

import sheenrox82.RioV.src.handler.HudHandler;
import sheenrox82.RioV.src.handler.WavHandler;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.client.GuiModList;

public class GuiRioVMainMenu extends GuiScreen
{
	/** The RNG used by the Main Menu Screen. */
	private static final Random rand = new Random();

	/** Counts the number of screen updates. */
	private float updateCounter;

	/** The splash message. */
	private GuiButton buttonResetDemo;

	/** Timer used to rotate the panorama, increases every tick. */
	private int panoramaTimer;
	private GuiButton fmlModButton = null;

	/**
	 * Texture allocated for the current viewport of the main menu's panorama background.
	 */
	private DynamicTexture viewportTexture;
	private boolean field_96141_q = true;
	private static boolean field_96140_r;
	private static boolean field_96139_s;
	private final Object field_104025_t = new Object();
	private String field_92025_p;
	private String field_104024_v;
	private static final ResourceLocation minecraftTitleTextures = new ResourceLocation(Util.MOD_ID + ":" + "title.png");

	/** An array of all the paths to the panorama pictures. */
	private static final ResourceLocation[] titlePanoramaPaths = new ResourceLocation[] {new ResourceLocation(Util.MOD_ID + ":" + "bg.png"), new ResourceLocation(Util.MOD_ID + ":" + "bg.png"), new ResourceLocation(Util.MOD_ID + ":" + "bg.png"), new ResourceLocation(Util.MOD_ID + ":" + "bg.png"), new ResourceLocation(Util.MOD_ID + ":" + "bg.png"), new ResourceLocation(Util.MOD_ID + ":" + "bg.png")};
	public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
	private int field_92024_r;
	private int field_92023_s;
	private int field_92022_t;
	private int field_92021_u;
	private int field_92020_v;
	private int field_92019_w;
	private ResourceLocation field_110351_G;
	private GuiButton minecraftRealmsButton;

	public GuiRioVMainMenu()
	{
		String var3;

		this.updateCounter = rand.nextFloat();
		this.field_92025_p = "";
		String var14 = System.getProperty("os_architecture");
		var3 = System.getProperty("java_version");

		if ("ppc".equalsIgnoreCase(var14))
		{
			this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " PowerPC compatibility will be dropped in Minecraft 1.6";
			this.field_104024_v = "http://tinyurl.com/javappc";
		}
		else if (var3 != null && var3.startsWith("1.5"))
		{
			this.field_92025_p = "" + EnumChatFormatting.BOLD + "Notice!" + EnumChatFormatting.RESET + " Java 1.5 compatibility will be dropped in Minecraft 1.6";
			this.field_104024_v = "http://tinyurl.com/javappc";
		}

		WavHandler.setUpSound("BackgroundMusic.wav");

		WavHandler.playSound(0);
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	public void updateScreen()
	{
		++this.panoramaTimer;
	}

	/**
	 * Returns true if this GUI should pause the game when it is displayed in single-player
	 */
	public boolean doesGuiPauseGame()
	{
		return false;
	}

	/**
	 * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
	 */
	protected void keyTyped(char par1, int par2) {}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	public void initGui()
	{
		this.viewportTexture = new DynamicTexture(256, 256);
		this.field_110351_G = this.mc.getTextureManager().getDynamicTextureLocation("background", this.viewportTexture);
		Calendar var1 = Calendar.getInstance();
		var1.setTime(new Date());

		boolean var2 = true;
		int var3 = this.height / 4 + 48;

		if (this.mc.isDemo())
		{
			this.addDemoButtons(var3, 24);
		}
		else
		{
			this.addSingleplayerMultiplayerButtons(var3, 24);
		}

		this.func_130020_g();
		this.buttonList.add(new GuiRioVButton(0, this.width / 2 - 280, 150, I18n.getString("menu.options")));
		this.buttonList.add(new GuiRioVButton(4, this.width / 2 - 280, 170, I18n.getString("menu.quit")));
		this.buttonList.add(new GuiButtonLanguage(5, 2, 2));
		Object var4 = this.field_104025_t;

		synchronized (this.field_104025_t)
		{
			this.field_92023_s = this.fontRenderer.getStringWidth(this.field_92025_p);
			this.field_92024_r = this.fontRenderer.getStringWidth(field_96138_a);
			int var5 = Math.max(this.field_92023_s, this.field_92024_r);
			this.field_92022_t = (this.width - var5) / 2;
			this.field_92021_u = ((GuiButton)this.buttonList.get(0)).yPosition - 24;
			this.field_92020_v = this.field_92022_t + var5;
			this.field_92019_w = this.field_92021_u + 24;
		}
	}

	private void func_130020_g()
	{
		if (this.field_96141_q)
		{
			if (!field_96140_r)
			{
				field_96140_r = true;
				(new RunnableRioVScreen(this)).start();
			}
			else if (field_96139_s)
			{
				this.func_130022_h();
			}
		}
	}

	private void func_130022_h()
	{
		this.minecraftRealmsButton.drawButton = true;
	}

	private void addSingleplayerMultiplayerButtons(int par1, int par2)
	{
		GL11.glPushMatrix();
		this.buttonList.add(new GuiRioVButton(1, this.width / 2 - 280, 90, I18n.getString("menu.singleplayer")));
		this.buttonList.add(new GuiRioVButton(2, this.width / 2 - 280, 110, I18n.getString("menu.multiplayer")));
		fmlModButton = new GuiRioVButton(6, this.width / 2 - 280, 130, "Mods");
		this.buttonList.add(fmlModButton);

		minecraftRealmsButton = new GuiButton(14, this.width / 2 - 280, 210, I18n.getString("menu.online"));
		this.buttonList.add(minecraftRealmsButton);
		this.minecraftRealmsButton.drawButton = false;
		GL11.glPopMatrix();
	}

	/**
	 * Adds Demo buttons on Main Menu for players who are playing Demo.
	 */
	private void addDemoButtons(int par1, int par2)
	{
		this.buttonList.add(new GuiButton(11, this.width / 2 - 100, par1, I18n.getString("menu.playdemo")));
		this.buttonList.add(this.buttonResetDemo = new GuiButton(12, this.width / 2 - 100, par1 + par2 * 1, I18n.getString("menu.resetdemo")));
		ISaveFormat var3 = this.mc.getSaveLoader();
		WorldInfo var4 = var3.getWorldInfo("Demo_World");

		if (var4 == null)
		{
			this.buttonResetDemo.enabled = false;
		}
	}

	protected void actionPerformed(GuiButton par1GuiButton)
	{
		if (par1GuiButton.id == 0)
		{
			this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
			WavHandler.stopSound();
		}

		if (par1GuiButton.id == 5)
		{
			this.mc.displayGuiScreen(new GuiLanguage(this, this.mc.gameSettings, this.mc.getLanguageManager()));
			WavHandler.stopSound();
		}

		if (par1GuiButton.id == 1)
		{
			this.mc.displayGuiScreen(new GuiSelectWorld(this));
			WavHandler.stopSound();
		}

		if (par1GuiButton.id == 2)
		{
			this.mc.displayGuiScreen(new GuiMultiplayer(this));
			WavHandler.stopSound();
		}

		if (par1GuiButton.id == 14 && this.minecraftRealmsButton.drawButton)
		{
			this.func_140005_i();
			WavHandler.stopSound();
		}

		if (par1GuiButton.id == 4)
		{
			this.mc.shutdown();
		}

		if (par1GuiButton.id == 6)
		{
			this.mc.displayGuiScreen(new GuiModList(this));
			WavHandler.stopSound();
		}

		if (par1GuiButton.id == 11)
		{
			this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
			WavHandler.stopSound();
		}

		if (par1GuiButton.id == 12)
		{
			ISaveFormat var2 = this.mc.getSaveLoader();
			WorldInfo var3 = var2.getWorldInfo("Demo_World");

			if (var3 != null)
			{
				GuiYesNo var4 = GuiSelectWorld.getDeleteWorldScreen(this, var3.getWorldName(), 12);
				WavHandler.stopSound();
				this.mc.displayGuiScreen(var4);
			}
		}
	}

	private void func_140005_i()
	{
		McoClient var1 = new McoClient(this.mc.getSession());

		try
		{
			if (var1.func_140054_c().booleanValue())
			{
				this.mc.displayGuiScreen(new GuiScreenClientOutdated(this));
			}
			else
			{
				this.mc.displayGuiScreen(new GuiScreenOnlineServers(this));
			}
		}
		catch (ExceptionMcoService var3)
		{
			this.mc.getLogAgent().logSevere(var3.toString());
		}
		catch (IOException var4)
		{
			this.mc.getLogAgent().logSevere(var4.getLocalizedMessage());
		}
	}

	public void confirmClicked(boolean par1, int par2)
	{
		if (par1 && par2 == 12)
		{
			ISaveFormat var6 = this.mc.getSaveLoader();
			var6.flushCache();
			var6.deleteWorldDirectory("Demo_World");
			this.mc.displayGuiScreen(this);
		}
		else if (par2 == 13)
		{
			if (par1)
			{
				try
				{
					Class var3 = Class.forName("java.awt.Desktop");
					Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
					var3.getMethod("browse", new Class[] {URI.class}).invoke(var4, new Object[] {new URI(this.field_104024_v)});
				}
				catch (Throwable var5)
				{
					var5.printStackTrace();
				}
			}

			this.mc.displayGuiScreen(this);
		}
	}

	/**
	 * Draws the main menu panorama
	 */
	private void drawPanorama(int par1, int par2, float par3)
	{
		Tessellator var4 = Tessellator.instance;
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPushMatrix();
		GL11.glLoadIdentity();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glDepthMask(false);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		byte var5 = 8;

		for (int var6 = 0; var6 < var5 * var5; ++var6)
		{
			GL11.glPushMatrix();
			float var7 = ((float)(var6 % var5) / (float)var5 - 0.5F) / 64.0F;
			float var8 = ((float)(var6 / var5) / (float)var5 - 0.5F) / 64.0F;
			float var9 = 0.0F;
			GL11.glTranslatef(var7, var8, var9);
			GL11.glRotatef(MathHelper.sin(((float)this.panoramaTimer + par3) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-((float)this.panoramaTimer + par3) * 0.1F, 0.0F, 1.0F, 0.0F);

			for (int var10 = 0; var10 < 6; ++var10)
			{
				GL11.glPushMatrix();

				if (var10 == 1)
				{
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
				}

				if (var10 == 2)
				{
					GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
				}

				if (var10 == 3)
				{
					GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
				}

				if (var10 == 4)
				{
					GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
				}

				if (var10 == 5)
				{
					GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				}

				this.mc.getTextureManager().bindTexture(titlePanoramaPaths[var10]);
				var4.startDrawingQuads();
				var4.setColorRGBA_I(16777215, 255 / (var6 + 1));
				float var11 = 0.0F;
				var4.addVertexWithUV(-1.0D, -1.0D, 1.0D, (double)(0.0F + var11), (double)(0.0F + var11));
				var4.addVertexWithUV(1.0D, -1.0D, 1.0D, (double)(1.0F - var11), (double)(0.0F + var11));
				var4.addVertexWithUV(1.0D, 1.0D, 1.0D, (double)(1.0F - var11), (double)(1.0F - var11));
				var4.addVertexWithUV(-1.0D, 1.0D, 1.0D, (double)(0.0F + var11), (double)(1.0F - var11));
				var4.draw();
				GL11.glPopMatrix();
			}

			GL11.glPopMatrix();
			GL11.glColorMask(true, true, true, false);
		}

		var4.setTranslation(0.0D, 0.0D, 0.0D);
		GL11.glColorMask(true, true, true, true);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glPopMatrix();
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glPopMatrix();
		GL11.glDepthMask(true);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	/**
	 * Rotate and blurs the skybox view in the main menu
	 */
	private void rotateAndBlurSkybox(float par1)
	{
		this.mc.getTextureManager().bindTexture(this.field_110351_G);
		GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColorMask(true, true, true, false);
		Tessellator var2 = Tessellator.instance;
		var2.startDrawingQuads();
		byte var3 = 3;

		for (int var4 = 0; var4 < var3; ++var4)
		{
			var2.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F / (float)(var4 + 1));
			int var5 = this.width;
			int var6 = this.height;
			float var7 = (float)(var4 - var3 / 2) / 256.0F;
			var2.addVertexWithUV((double)var5, (double)var6, (double)this.zLevel, (double)(0.0F + var7), 0.0D);
			var2.addVertexWithUV((double)var5, 0.0D, (double)this.zLevel, (double)(1.0F + var7), 0.0D);
			var2.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(1.0F + var7), 1.0D);
			var2.addVertexWithUV(0.0D, (double)var6, (double)this.zLevel, (double)(0.0F + var7), 1.0D);
		}

		var2.draw();
		GL11.glColorMask(true, true, true, true);
	}

	/**
	 * Renders the skybox in the main menu
	 */
	private void renderSkybox(int par1, int par2, float par3)
	{
		GL11.glViewport(0, 0, 256, 256);
		this.drawPanorama(par1, par2, par3);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		this.rotateAndBlurSkybox(par3);
		GL11.glViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
		Tessellator var4 = Tessellator.instance;
		var4.startDrawingQuads();
		float var5 = this.width > this.height ? 120.0F / (float)this.width : 120.0F / (float)this.height;
		float var6 = (float)this.height * var5 / 256.0F;
		float var7 = (float)this.width * var5 / 256.0F;
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
		var4.setColorRGBA_F(1.0F, 1.0F, 1.0F, 1.0F);
		int var8 = this.width;
		int var9 = this.height;
		var4.addVertexWithUV(0.0D, (double)var9, (double)this.zLevel, (double)(0.5F - var6), (double)(0.5F + var7));
		var4.addVertexWithUV((double)var8, (double)var9, (double)this.zLevel, (double)(0.5F - var6), (double)(0.5F - var7));
		var4.addVertexWithUV((double)var8, 0.0D, (double)this.zLevel, (double)(0.5F + var6), (double)(0.5F - var7));
		var4.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, (double)(0.5F + var6), (double)(0.5F + var7));
		var4.draw();
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	public void drawScreen(int par1, int par2, float par3)
	{
		this.renderSkybox(par1, par2, par3);
		Tessellator var4 = Tessellator.instance;
		short var5 = 274;
		int var6 = this.width / 2 - var5 / 2;
		byte var7 = 30;
		this.drawGradientRect(0, 0, this.width, this.height, -2130706433, 16777215);
		this.drawGradientRect(0, 0, this.width, this.height, 0, Integer.MIN_VALUE);
		this.mc.getTextureManager().bindTexture(minecraftTitleTextures);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		if ((double)this.updateCounter < 1.0E-4D)
		{
			this.drawTexturedModalRect(var6 + 0, var7 + 0, 0, 0, 99, 44);
			this.drawTexturedModalRect(var6 + 99, var7 + 0, 129, 0, 27, 44);
			this.drawTexturedModalRect(var6 + 99 + 26, var7 + 0, 126, 0, 3, 44);
			this.drawTexturedModalRect(var6 + 99 + 26 + 3, var7 + 0, 99, 0, 26, 44);
			this.drawTexturedModalRect(var6 + 155, var7 + 0, 0, 45, 155, 44);
		}
		else
		{
			this.drawTexturedModalRect(var6 + 0, var7 + 0, 0, 0, 155, 44);
			this.drawTexturedModalRect(var6 + 155, var7 + 0, 0, 45, 155, 44);
		}

		var4.setColorOpaque_I(16777215);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(this.width / 2 + 90), 70.0F, 0.0F);
		GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
		float var8 = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
		GL11.glScalef(var8, var8, var8);
		GL11.glPopMatrix();
		String var9 = Util.MOD_NAME + " - " + Util.VERSION;

		if (this.mc.isDemo())
		{
			var9 = var9 + " Demo";
		}

		this.drawString(this.fontRenderer, var9, 2, this.height - 10, 16777215);
		String var10 = "Made by sheenrox82";
		this.drawString(this.fontRenderer, var10, this.width - this.fontRenderer.getStringWidth(var10) - 2, this.height - 10, 16777215);

		if (this.field_92025_p != null && this.field_92025_p.length() > 0)
		{
			drawRect(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
			this.drawString(this.fontRenderer, this.field_92025_p, this.field_92022_t, this.field_92021_u, 16777215);
			this.drawString(this.fontRenderer, field_96138_a, (this.width - this.field_92024_r) / 2, ((GuiButton)this.buttonList.get(0)).yPosition - 12, 16777215);
		}

		super.drawScreen(par1, par2, par3);
	}

	/**
	 * Called when the mouse is clicked.
	 */
	protected void mouseClicked(int par1, int par2, int par3)
	{
		super.mouseClicked(par1, par2, par3);
		Object var4 = this.field_104025_t;

		synchronized (this.field_104025_t)
		{
			if (this.field_92025_p.length() > 0 && par1 >= this.field_92022_t && par1 <= this.field_92020_v && par2 >= this.field_92021_u && par2 <= this.field_92019_w)
			{
				GuiConfirmOpenLink var5 = new GuiConfirmOpenLink(this, this.field_104024_v, 13, true);
				var5.func_92026_h();
				this.mc.displayGuiScreen(var5);
			}
		}
	}

	static Minecraft func_110348_a(GuiRioVMainMenu par0GuiMainMenu)
	{
		return par0GuiMainMenu.mc;
	}

	static void func_130021_b(GuiRioVMainMenu par0GuiMainMenu)
	{
		par0GuiMainMenu.func_130022_h();
	}

	static boolean func_110349_a(boolean par0)
	{
		field_96139_s = par0;
		return par0;
	}

	static Minecraft func_130018_c(GuiRioVMainMenu par0GuiMainMenu)
	{
		return par0GuiMainMenu.mc;
	}

	static Minecraft func_130019_d(GuiRioVMainMenu par0GuiMainMenu)
	{
		return par0GuiMainMenu.mc;
	}
}