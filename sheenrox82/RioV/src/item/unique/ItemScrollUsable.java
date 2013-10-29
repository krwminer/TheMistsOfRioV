package sheenrox82.RioV.src.item.unique;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Util;

public class ItemScrollUsable extends Item
{
	public static boolean isFireScroll;
	public static boolean isWaterScroll;
	public static boolean isEarthScroll;
	public static boolean isWindScroll;
	public static String level;
	private int damage;
	private int firetick;
	private int firemax;
	public int counter;
	public int countdown;
	public boolean justUsedWind;

	public ItemScrollUsable(int par1, int var2, int var3, int var4, String level, boolean isFireScroll, boolean isWaterScroll, boolean isEarthScroll, boolean isWindScroll) 
	{
		super(par1 - 256);
		this.level = level;
		this.damage = var2;
		this.firemax = var4;
		this.firetick = this.firemax;
		this.isFireScroll = isFireScroll;
		this.isWaterScroll = isWaterScroll;
		this.isEarthScroll = isEarthScroll;
		this.isWindScroll = isWindScroll;
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
		this.setMaxDamage(1);
		this.setMaxStackSize(1);
	}

	public void registerIcons(IconRegister i)
	{
		if(itemID == Items.scrollFireI.itemID) this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + "scrollFire");
		if(itemID == Items.scrollFireII.itemID) this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + "scrollFire");
		if(itemID == Items.scrollWindI.itemID) this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + "scrollWind");
		if(itemID == Items.scrollEverlight.itemID) this.itemIcon = i.registerIcon(Util.MOD_ID + ":" + "scrollEverlight");
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if(itemID == Items.scrollFireI.itemID) par3List.add("\u00A74Fire " + "I");
		if(itemID == Items.scrollFireII.itemID) par3List.add("\u00A74Fire " + "II");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(itemID == Items.scrollFireI.itemID || itemID == Items.scrollFireII.itemID && itemID != Items.scrollEverlight.itemID)
		{
			if(!world.isRemote)
			{
				if (this.firetick == this.firemax && this.firemax != 0)
				{
					Vec3 look = entityplayer.getLookVec();
					EntityLargeFireball fireball2 = new EntityLargeFireball(world, entityplayer, 1, 1, 1);
					fireball2.setPosition(
							entityplayer.posX + look.xCoord * 5,
							entityplayer.posY + look.yCoord * 5,
							entityplayer.posZ + look.zCoord * 5);
					fireball2.accelerationX = look.xCoord * 0.1;
					fireball2.accelerationY = look.yCoord * 0.1;
					fireball2.accelerationZ = look.zCoord * 0.1;
					world.spawnEntityInWorld(fireball2);
					entityplayer.inventory.consumeInventoryItem(this.itemID);
					this.firetick = 0;
				}
				else
				{
					++this.firetick;
				}

				if (this.firemax == 0)
				{
					Vec3 look = entityplayer.getLookVec();
					EntityLargeFireball fireball2 = new EntityLargeFireball(world, entityplayer, 1, 1, 1);
					fireball2.setPosition(
							entityplayer.posX + look.xCoord * 5,
							entityplayer.posY + look.yCoord * 5,
							entityplayer.posZ + look.zCoord * 5);
					fireball2.accelerationX = look.xCoord * 0.1;
					fireball2.accelerationY = look.yCoord * 0.1;
					fireball2.accelerationZ = look.zCoord * 0.1;
					world.spawnEntityInWorld(fireball2);
					entityplayer.inventory.consumeInventoryItem(this.itemID);
				}
			}	
		}

		if(itemID == Items.scrollEverlight.itemID)
		{
			if(!world.isRemote)
			{
				if(world.getWorldTime() > 12000)
				{
					world.setWorldTime(0);
					entityplayer.inventory.consumeInventoryItem(this.itemID);
				}

				if(world.isDaytime())
				{
				}
			}
		}

		if(itemID == Items.scrollWindI.itemID )
		{
			entityplayer.addVelocity(0, 0.9, 0);
			entityplayer.inventory.consumeInventoryItem(this.itemID);
		}

		return itemstack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
	{
		this.firetick = this.firemax;
	}
}
