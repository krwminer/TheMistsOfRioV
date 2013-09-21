package sheenrox82.RioV.src.render.item;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import sheenrox82.RioV.src.tileentity.TileEntityGlimmerwoodChest;

public class ItemRenderGlimmerwoodChest implements IItemRenderer 
{
    private ModelChest model;

    public ItemRenderGlimmerwoodChest() {
        model = new ModelChest();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) 
    {
    	return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
    {
    	GL11.glPushMatrix();
        GL11.glScalef(1.0F, 1.0F, 1.0F);        
        TileEntityRenderer.instance.renderTileEntityAt(new TileEntityGlimmerwoodChest(), 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glPopMatrix();
    }

}