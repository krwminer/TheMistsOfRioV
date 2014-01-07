package sheenrox82.RioV.src.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Color;
import sheenrox82.RioV.src.util.MethodUtil;
import sheenrox82.RioV.src.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class RioVAxe extends ItemAxe
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern, Blocks.plankColored};
	public boolean isInfused;

	public RioVAxe(int par1, EnumToolMaterial par2EnumToolMaterial, boolean par2)
	{
		super(par1 - 256, par2EnumToolMaterial);
		this.isInfused = par2;
		this.setCreativeTab(TheMistsOfRioV.getInstance().tab);
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		if(isInfused)
		{
			return true;
		}

		return par1ItemStack.isItemEnchanted();
	}

	@Override
	public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
	{
		return par2Block != null && (par2Block.blockMaterial == Material.wood || par2Block.blockMaterial == Material.plants || par2Block.blockMaterial == Material.vine) ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(itemID == Items.onyxAxe.itemID || itemID == Items.infusedOnyxAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxAxe");
		}
		if(itemID == Items.amethystAxe.itemID || itemID == Items.infusedAmethystAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystAxe");
		}
		if(itemID == Items.sapphireAxe.itemID || itemID == Items.infusedSapphireAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphireAxe");
		}
		if(itemID == Items.topazAxe.itemID || itemID == Items.infusedTopazAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazAxe");
		}
		if(itemID == Items.dragonAxe.itemID || itemID == Items.infusedDragonAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonAxe");
		}
		if(itemID == Items.glimmerwoodAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "glimmerwoodAxe");
		}
		if(itemID == Items.vraviniteAxe.itemID || itemID == Items.infusedVraviniteAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vraviniteAxe");
		}
		if(itemID == Items.blindoniteAxe.itemID || itemID == Items.infusedBlindoniteAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindoniteAxe");
		}
		if(itemID == Items.cherryBlossomAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryBlossomAxe");
		}
		if(itemID == Items.bloodAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodAxe");
		}
		if(itemID == Items.skywoodAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodAxe");
		}
		if(itemID == Items.sanctuaryStoneAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sanctuaryStoneAxe");
		}
		if(itemID == Items.alerisAxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisAxe");
		}
		if(TheMistsOfRioV.getInstance().natura)
		{
			if(itemID == Items.infusedBloodwoodAxe.itemID || itemID == Items.infusedGhostwoodAxe.itemID || itemID == Items.infusedDarkwoodAxe.itemID || itemID == Items.infusedFusewoodAxe.itemID || itemID == Items.infusedNetherquartzAxe.itemID)
				this.itemIcon = par1IconRegister.registerIcon(MethodUtil.getName(this.getUnlocalizedName()));
		}
		
		if(TheMistsOfRioV.getInstance().aether)
		{
			if(itemID == Items.infusedSkyrootAxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Skyroot Axe");	
			if(itemID == Items.infusedHolystoneAxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Holystone Axe");	
			if(itemID == Items.infusedZaniteAxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Zanite Axe");	
			if(itemID == Items.infusedGravititeAxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Gravitite Axe");	
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if(Config.showToolInfo)
		{
			var3.add(Color.GOLD + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.DARK_PURPLE + "Axing Speed: " + toolMaterial.getEfficiencyOnProperMaterial());
			var3.add(Color.AQUA + "Harvest Level: " + toolMaterial.getHarvestLevel());
		}
	}
}
