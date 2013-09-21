package sheenrox82.RioV.src.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.recipe.InfuserRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityInfuser extends TileEntity implements IInventory
{
    /**
     * The ItemStacks that hold the items currently being used in the altar
     */
    private ItemStack[] altarItemStacks = new ItemStack[3];
    public int altarBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int altarCookTime = 0;
    
    public int getSizeInventory()
    {
        return this.altarItemStacks.length;
    }
    
    public ItemStack getStackInSlot(int par1)
    {
        return this.altarItemStacks[par1];
    }

    
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.altarItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.altarItemStacks[par1].stackSize <= par2)
            {
                var3 = this.altarItemStacks[par1];
                this.altarItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.altarItemStacks[par1].splitStack(par2);

                if (this.altarItemStacks[par1].stackSize == 0)
                {
                    this.altarItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }


    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.altarItemStacks[par1] != null)
        {
            ItemStack var2 = this.altarItemStacks[par1];
            this.altarItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.altarItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }


    public String getInvName()
    {
        return "container.altar";
    }

    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.altarItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.altarItemStacks.length)
            {
                this.altarItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.altarBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.altarCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.altarItemStacks[1]);
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.altarBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.altarCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.altarItemStacks.length; ++var3)
        {
            if (this.altarItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.altarItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }
    
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1)
    {
        return this.altarCookTime * par1 / 2;
    }

    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 2;
        }

        return this.altarBurnTime * par1 / this.currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return this.altarBurnTime > 0;
    }


    public void updateEntity()
    {
        boolean var1 = this.altarBurnTime > 0;
        boolean var2 = false;

        if (this.altarBurnTime > 0)
        {
            --this.altarBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.altarBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.altarBurnTime = getItemBurnTime(this.altarItemStacks[1]);

                if (this.altarBurnTime > 0)
                {
                    var2 = true;

                    if (this.altarItemStacks[1] != null)
                    {
                        --this.altarItemStacks[1].stackSize;

                        if (this.altarItemStacks[1].stackSize == 0)
                        {
                            this.altarItemStacks[1] = this.altarItemStacks[1].getItem().getContainerItemStack(altarItemStacks[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.altarCookTime;

                if (this.altarCookTime == 2)
                {
                    this.altarCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.altarCookTime = 0;
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }
    
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    private boolean canSmelt()
    {
        if (this.altarItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = InfuserRecipes.getInfuser().getResult(this.altarItemStacks[0]);
            if (var1 == null) return false;
            if (this.altarItemStacks[2] == null) return true;
            if (!this.altarItemStacks[2].isItemEqual(var1)) return false;
            int result = altarItemStacks[2].stackSize + var1.stackSize;
            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = InfuserRecipes.getInfuser().getResult(this.altarItemStacks[0]);

            if (this.altarItemStacks[2] == null)
            {
                this.altarItemStacks[2] = var1.copy();
            }
            else if (this.altarItemStacks[2].isItemEqual(var1))
            {
                altarItemStacks[2].stackSize += var1.stackSize;
            }

            --this.altarItemStacks[0].stackSize;

            if (this.altarItemStacks[0].stackSize <= 0)
            {
                this.altarItemStacks[0] = null;
            }
        }
    }


    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
        if (par0ItemStack == null)
        {
            return 0;
        }
        else
        {
            int var1 = par0ItemStack.getItem().itemID;
            Item var2 = par0ItemStack.getItem();

            if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[var1] != null)
            {
                Block var3 = Block.blocksList[var1];
            }
            if (var1 == Items.orb.itemID)
            {
            	return 2;
            }

            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }


    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	public int getSizeInventorySide(ForgeDirection side)
	{
		return 1;
	}
	public void openChest(){}
	public void closeChest(){}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
