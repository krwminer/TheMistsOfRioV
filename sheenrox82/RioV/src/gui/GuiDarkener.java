package sheenrox82.RioV.src.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.container.ContainerDarkener;
import sheenrox82.RioV.src.lib.GuiResourceLocation;
import sheenrox82.RioV.src.tileentity.TileEntityDarkener;

public class GuiDarkener extends GuiContainer
{
	public GuiDarkener(InventoryPlayer player_inventory, TileEntityDarkener tile_entity)
	{
		super(new ContainerDarkener(player_inventory, tile_entity));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j)
	{
		fontRenderer.drawString("Darkening Altar", 6, 6, 0x4A4A4A);
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 6, ySize - 96 , 0x4A4A4A);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		mc.renderEngine.bindTexture(GuiResourceLocation.darkener);
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}