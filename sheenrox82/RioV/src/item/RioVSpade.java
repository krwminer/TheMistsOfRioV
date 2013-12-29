package sheenrox82.RioV.src.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Color;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.Util;

public class RioVSpade extends ItemSpade
{
	/** an array of the blocks this spade is effective against */
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium, Blocks.glimmerGrass, Blocks.glimmerDirt};
	public boolean isInfused;

	public RioVSpade(int par1, EnumToolMaterial par2EnumToolMaterial, boolean par2)
	{
		super(par1 - 256, par2EnumToolMaterial);
		this.isInfused = par2;
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if (isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}
	/**
	 * Returns if the item (tool) can harvest results from the block type.
	 */
	public boolean canHarvestBlock(Block par1Block)
	{
		return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
	}


	/**
	 * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
	 * sword
	 */
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return par2Block != null && (par2Block.blockMaterial == Material.grass || par2Block.blockMaterial == Material.ground) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(itemID == Items.onyxShovel.itemID || itemID == Items.infusedOnyxShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxShovel");
		}
		if(itemID == Items.amethystShovel.itemID || itemID == Items.infusedAmethystShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystShovel");
		}
		if(itemID == Items.sapphireShovel.itemID || itemID == Items.infusedSapphireShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphireShovel");
		}
		if(itemID == Items.topazShovel.itemID || itemID == Items.infusedTopazShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazShovel");
		}
		if(itemID == Items.dragonShovel.itemID || itemID == Items.infusedDragonShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonShovel");
		}
		if(itemID == Items.glimmerwoodShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "glimmerwoodShovel");
		}
		if(itemID == Items.vraviniteShovel.itemID || itemID == Items.infusedVraviniteShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vraviniteShovel");
		}
		if(itemID == Items.blindoniteShovel.itemID || itemID == Items.infusedBlindoniteShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindoniteShovel");
		}
		if(itemID == Items.cherryBlossomShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryBlossomShovel");
		}
		if(itemID == Items.bloodShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodShovel");
		}
		if(itemID == Items.skywoodShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodShovel");
		}
		if(itemID == Items.sanctuaryStoneShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sanctuaryStoneShovel");
		}
		if(itemID == Items.alerisShovel.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisShovel");
		}
		if(TheMistsOfRioV.getInstance().natura)
		{
			if(itemID == Items.infusedBloodwoodShovel.itemID || itemID == Items.infusedGhostwoodShovel.itemID || itemID == Items.infusedDarkwoodShovel.itemID || itemID == Items.infusedFusewoodShovel.itemID || itemID == Items.infusedNetherquartzShovel.itemID)
				this.itemIcon = par1IconRegister.registerIcon(MethodUtil.getName(this.getUnlocalizedName()));
		}
		
		if(TheMistsOfRioV.getInstance().aether)
		{
			if(itemID == Items.infusedSkyrootShovel.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Skyroot Shovel");
			if(itemID == Items.infusedHolystoneShovel.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Holystone Shovel");
			if(itemID == Items.infusedZaniteShovel.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Zanite Shovel");
			if(itemID == Items.infusedGravititeShovel.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Gravitite Shovel");
		}
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(Config.showToolInfo)
		{
			var3.add(Color.GOLD + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.DARK_PURPLE + "Digging Speed: " + toolMaterial.getEfficiencyOnProperMaterial());
			var3.add(Color.AQUA + "Harvest Level: " + toolMaterial.getHarvestLevel());
		}
	}
}
