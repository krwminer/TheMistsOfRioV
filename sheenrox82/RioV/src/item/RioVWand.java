package sheenrox82.RioV.src.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.entity.projectile.EntityPinkEssence;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.PlayerNBT;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVWand extends Item
{
	private int damage;
	private int firetick;
	private int firemax;
	private String firesound;
	private String reloadsound;

	public RioVWand(int par1, int var2, int var3, int var4)
	{
		super(par1 - 256);
		this.damage = var2;
		this.firemax = var4;
		this.firetick = this.firemax;
		this.maxStackSize = 1;
		this.setMaxDamage(300);
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
		bFull3D = true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + MethodUtil.getName(this.getUnlocalizedName()));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		PlayerNBT player = PlayerNBT.get(entityplayer);

		if(itemID == Items.fireballWand.itemID)
		{
			if(!world.isRemote)
			{
				if (this.firetick == this.firemax && this.firemax != 0)
				{
					if(player.consumeEos(2))
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

						itemstack.damageItem(1, entityplayer);
						this.firetick = 0;
					}
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

					itemstack.damageItem(1, entityplayer);
				}
			}
		}
		if(itemID == Items.iceWand.itemID)
		{
			if(!world.isRemote)
			{
				if (this.firetick == this.firemax && this.firemax != 0)
				{
					if(player.consumeEos(2))
					{
						world.spawnEntityInWorld(new EntitySnowball(world, entityplayer));

						itemstack.damageItem(1, entityplayer);
						this.firetick = 0;
					}
				}
				else
				{
					++this.firetick;
				}

				if (this.firemax == 0)
				{
					world.spawnEntityInWorld(new EntitySnowball(world, entityplayer));

					itemstack.damageItem(1, entityplayer);
				}
			}
		}

		if(itemID == Items.graviWand.itemID)
		{
			if(!world.isRemote)
			{
				if (this.firetick == this.firemax && this.firemax != 0)
				{
					if(player.consumeEos(2))
					{
						world.spawnEntityInWorld(new EntityPinkEssence(world, entityplayer));

						itemstack.damageItem(1, entityplayer);
						this.firetick = 0;
					}
				}
				else
				{
					++this.firetick;
				}

				if (this.firemax == 0)
				{
					world.spawnEntityInWorld(new EntityPinkEssence(world, entityplayer));

					itemstack.damageItem(1, entityplayer);
				}
			}
		}

		if(player.getCurrentEos() == 0)
		{
			if(!world.isRemote)
				entityplayer.sendChatToPlayer(ChatMessageComponent.createFromText("You do not have enough Eos!"));
		}
		return itemstack;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
	{
		this.firetick = this.firemax;
	}
}

