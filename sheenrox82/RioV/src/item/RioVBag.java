package sheenrox82.RioV.src.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.container.ContainerBagLarge;
import sheenrox82.RioV.src.container.ContainerBagMedium;
import sheenrox82.RioV.src.container.ContainerBagSheen;
import sheenrox82.RioV.src.container.ContainerBagSmall;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVBag extends Item
{
	public static int smallBagId = 4;
	public static int mediumBagId = 5;
	public static int largeBagId = 6;
	public static int sheensBagId = 7;

	public RioVBag(int par1)
	{
		super(par1 - 256);
		this.maxStackSize = 1;
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean isCurrentItem)
	{
		if (!world.isRemote && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;

			if(itemID == Items.smallBag.itemID)
			{
				if(player.openContainer != null && player.openContainer instanceof ContainerBagSmall
						&& ((ContainerBagSmall) player.openContainer).needsUpdate)
				{
					((ContainerBagSmall) player.openContainer).writeToNBT();
					((ContainerBagSmall) player.openContainer).needsUpdate = false;
				}
			}

			if(itemID == Items.mediumBag.itemID)
			{
				if(player.openContainer != null && player.openContainer instanceof ContainerBagMedium
						&& ((ContainerBagMedium) player.openContainer).needsUpdate)
				{
					((ContainerBagMedium) player.openContainer).writeToNBT();
					((ContainerBagMedium) player.openContainer).needsUpdate = false;
				}
			}

			if(itemID == Items.largeBag.itemID)
			{
				if(player.openContainer != null && player.openContainer instanceof ContainerBagLarge
						&& ((ContainerBagLarge) player.openContainer).needsUpdate)
				{
					((ContainerBagLarge) player.openContainer).writeToNBT();
					((ContainerBagLarge) player.openContainer).needsUpdate = false;
				}
			}

			if(player.username.contains("sheenrox82") || player.username.contains("Mr_Simba"))
			{
				if(itemID == Items.sheenBag.itemID)
				{
					if(player.openContainer != null && player.openContainer instanceof ContainerBagSheen
							&& ((ContainerBagSheen) player.openContainer).needsUpdate)
					{
						((ContainerBagSheen) player.openContainer).writeToNBT();
						((ContainerBagSheen) player.openContainer).needsUpdate = false;
					}
				}
			}
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemstack)
	{
		return 1;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			if(itemID == Items.smallBag.itemID)
			{
				player.openGui(TheMistsOfRioV.getInstance(), smallBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}

			if(itemID == Items.mediumBag.itemID)
			{
				player.openGui(TheMistsOfRioV.getInstance(), mediumBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}

			if(itemID == Items.largeBag.itemID)
			{
				player.openGui(TheMistsOfRioV.getInstance(), largeBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}

			if(player.username.contains("sheenrox82") || player.username.contains("Mr_Simba"))
			{
				if(itemID == Items.sheenBag.itemID)
				{
					player.openGui(TheMistsOfRioV.getInstance(), sheensBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
				}
			}
		}

		return false;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			if(itemID == Items.smallBag.itemID)
			{
				player.openGui(TheMistsOfRioV.getInstance(), smallBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}

			if(itemID == Items.mediumBag.itemID)
			{
				player.openGui(TheMistsOfRioV.getInstance(), mediumBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}

			if(itemID == Items.largeBag.itemID)
			{
				player.openGui(TheMistsOfRioV.getInstance(), largeBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
			}

			if(player.username.contains("sheenrox82") || player.username.contains("Mr_Simba"))
			{
				if(itemID == Items.sheenBag.itemID)
				{
					player.openGui(TheMistsOfRioV.getInstance(), sheensBagId, world, (int) player.posX, (int) player.posY, (int) player.posZ);
				}
			}
		}

		return itemstack;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(itemID == Items.sheenBag.itemID)
		{
			par3List.add("If you're not Sheen and you made this,");
			par3List.add("you're an idiot.");
			par3List.add("This is only usable by Sheen");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Util.MOD_ID + ":" + this.getName());
	}

	public String getName()
	{
		return this.unlocalizedName;
	}
}