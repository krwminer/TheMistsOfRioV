package sheenrox82.RioV.src.item;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;

public class RioVPotions extends Item
{
	private int isFull;

	public RioVPotions(int par1, int par2)
	{
		super(par1 - 256);
		this.maxStackSize = 1;
		this.isFull = par2;
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		boolean flag = this.isFull == 0;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, flag);

		if (movingobjectposition == null)
		{
			return par1ItemStack;
		}
		else
		{
			FillBucketEvent event = new FillBucketEvent(par3EntityPlayer, par1ItemStack, par2World, movingobjectposition);
			if (MinecraftForge.EVENT_BUS.post(event))
			{
				return par1ItemStack;
			}

			if (event.getResult() == Event.Result.ALLOW)
			{
				if (par3EntityPlayer.capabilities.isCreativeMode)
				{
					return par1ItemStack;
				}

				if (--par1ItemStack.stackSize <= 0)
				{
					return event.result;
				}

				if (!par3EntityPlayer.inventory.addItemStackToInventory(event.result))
				{
					par3EntityPlayer.dropPlayerItem(event.result);
				}

				return par1ItemStack;
			}

			if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;

				if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
				{
					return par1ItemStack;
				}

				if (this.isFull == 0)
				{
					if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
					{
						return par1ItemStack;
					}

					if (par2World.getBlockMaterial(i, j, k) == Material.water && par2World.getBlockMetadata(i, j, k) == 0)
					{
						par2World.setBlockToAir(i, j, k);

						if (par3EntityPlayer.capabilities.isCreativeMode)
						{
							return par1ItemStack;
						}

						if (--par1ItemStack.stackSize <= 0)
						{
							return new ItemStack(Items.potionGlassSanctuatite);
						}

						if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.potionGlassSanctuatite)))
						{
							par3EntityPlayer.dropPlayerItem(new ItemStack(Items.potionGlassSanctuatite.itemID, 1, 0));
						}

						return par1ItemStack;
					}

				}
				else
				{
					if (this.isFull < 0)
					{
						return new ItemStack(Items.potionGlass);
					}

					if (movingobjectposition.sideHit == 0)
					{
						--j;
					}

					if (movingobjectposition.sideHit == 1)
					{
						++j;
					}

					if (movingobjectposition.sideHit == 2)
					{
						--k;
					}

					if (movingobjectposition.sideHit == 3)
					{
						++k;
					}

					if (movingobjectposition.sideHit == 4)
					{
						--i;
					}

					if (movingobjectposition.sideHit == 5)
					{
						++i;
					}

					if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
					{
						return par1ItemStack;
					}

					if (this.tryPlaceContainedLiquid(par2World, i, j, k) && !par3EntityPlayer.capabilities.isCreativeMode)
					{
						return new ItemStack(Items.potionGlass);
					}
				}
			}
		}

		return par1ItemStack;
	}

	public boolean tryPlaceContainedLiquid(World par1World, int par2, int par3, int par4)
	{
		if (this.isFull <= 0)
		{
			return false;
		}
		else
		{
			Material material = par1World.getBlockMaterial(par2, par3, par4);
			boolean flag = !material.isSolid();

			if (!par1World.isAirBlock(par2, par3, par4) && !flag)
			{
				return false;
			}
			else
			{
				if (par1World.provider.isHellWorld && this.isFull == Blocks.sanctuatiteMoving.blockID)
				{
					par1World.playSoundEffect((double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

					for (int l = 0; l < 8; ++l)
					{
						par1World.spawnParticle("largesmoke", (double)par2 + Math.random(), (double)par3 + Math.random(), (double)par4 + Math.random(), 0.0D, 0.0D, 0.0D);
					}
				}
				else
				{
					if (!par1World.isRemote && flag && !material.isLiquid())
					{
						par1World.destroyBlock(par2, par3, par4, true);
					}

					par1World.setBlock(par2, par3, par4, this.isFull, 0, 3);
				}

				return true;
			}
		}
	}

	@Override
	public void registerIcons(IconRegister i)
	{
		if(itemID == Items.potionGlass.itemID) this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + "potionGlass");
		if(itemID == Items.potionGlassSanctuatite.itemID) this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + "potionGlassSanctuatite");
	}
}
