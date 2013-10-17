package sheenrox82.RioV.src.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.recipe.MagicBinderCraftingManager;

public class ContainerMagicBinder extends Container
{
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 5, 5);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerMagicBinder(InventoryPlayer inventoryplayer, World world, int x, int y, int z)
	{
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		this.addSlotToContainer(new SlotCrafting(inventoryplayer.player, craftMatrix, craftResult, 0, 79, 43));

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				addSlotToContainer(new Slot(craftMatrix, j + i * 5, 8 + j * 143, 19 + i * 24));
			}
		}

		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(inventoryplayer, j + i * 9 + 9, 8 + j * 18, 102 + i * 18));
			}
		}

		for (int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(inventoryplayer, i, 8 + i * 18, 160));
		}

		onCraftMatrixChanged(craftMatrix);
	}

	public void onCraftMatrixChanged(IInventory iinventory)
	{
		this.craftResult.setInventorySlotContents(0, MagicBinderCraftingManager.instance.findMatchingRecipe(craftMatrix, worldObj));
	}

	public void onContainerClosed(EntityPlayer par1EntityPlayer)
	{
		super.onContainerClosed(par1EntityPlayer);

		if (!this.worldObj.isRemote)
		{
			for (int i = 0; i < 9; ++i)
			{
				ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

				if (itemstack != null)
				{
					par1EntityPlayer.dropPlayerItem(itemstack);
				}
			}
		}
	}

	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		if(worldObj.getBlockId(posX, posY, posZ) != Blocks.magicBinder.blockID)
		{
			return false;
		} else
		{
			return entityplayer.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64D;
		}
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(par2);
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(par2 == 0)
			{

			} 
			else
				if(par2 >= 10 && par2 < 37)
				{

				} 
				else if(par2 >= 37 && par2 < 46)
				{
					if(!mergeItemStack(itemstack1, 10, 37, false))
					{
						return null;
					}
				} 

			if(itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			} else
			{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize != itemstack.stackSize)
			{
				slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
			} else
			{
				return null;
			}
		}
		return itemstack;
	}

	public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
	{
		return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
	}
}