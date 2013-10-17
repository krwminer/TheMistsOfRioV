package sheenrox82.RioV.src.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.container.ContainerMagicBinder;
import sheenrox82.RioV.src.util.Util;

public class GuiMagicBinder extends GuiContainer
{	
	public GuiMagicBinder(InventoryPlayer inventoryplayer, World world, int i, int j, int k)
    {
        super(new ContainerMagicBinder(inventoryplayer, world, i, j, k));
		xSize = 176;
		ySize = 184;
    }


    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(Util.MOD_ID + ":" + "textures/gui/" + "magicBinder.png"));
        int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
