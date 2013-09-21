package sheenrox82.RioV.src.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import sheenrox82.RioV.src.block.BlockAnvil;
import sheenrox82.RioV.src.block.BlockRioVWorkbench;
import sheenrox82.RioV.src.container.ContainerAnvil;
import sheenrox82.RioV.src.container.ContainerDarkener;
import sheenrox82.RioV.src.container.ContainerInfuser;
import sheenrox82.RioV.src.container.ContainerRioVWorkbench;
import sheenrox82.RioV.src.gui.GuiAnvil;
import sheenrox82.RioV.src.gui.GuiDarkener;
import sheenrox82.RioV.src.gui.GuiInfuser;
import sheenrox82.RioV.src.gui.GuiRioVWorkbench;
import sheenrox82.RioV.src.tileentity.TileEntityDarkener;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity instanceof TileEntityInfuser){

			return new ContainerInfuser(player.inventory, (TileEntityInfuser) tile_entity);
		}

		if(tile_entity instanceof TileEntityDarkener){

			return new ContainerDarkener(player.inventory, (TileEntityDarkener) tile_entity);
		}

		if (id == BlockRioVWorkbench.idForActivation)
		{
			return new ContainerRioVWorkbench(player.inventory, world, x, y, z);
		}

		if (id == BlockAnvil.id)
		{
			return new ContainerAnvil(player.inventory, world, x, y, z);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		if(tile_entity instanceof TileEntityInfuser){

			return new GuiInfuser(player.inventory, (TileEntityInfuser) tile_entity);
		}

		if(tile_entity instanceof TileEntityDarkener){

			return new GuiDarkener(player.inventory, (TileEntityDarkener) tile_entity);
		}

		if (id == BlockRioVWorkbench.idForActivation)
		{
			return new GuiRioVWorkbench(player.inventory, world, x, y, z);
		}

		if (id == BlockAnvil.id)
		{
			return new GuiAnvil(player.inventory, world, x, y, z);
		}

		return null;
	}
}