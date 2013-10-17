package sheenrox82.RioV.src.item;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Blocks;
import sheenrox82.RioV.src.content.Items;
import sheenrox82.RioV.src.util.Color;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RioVPickaxe extends ItemPickaxe
{
	public static final Block[] blocksEffectiveAgainst = new Block[] {Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator, Blocks.blackRock, Blocks.bloodRock,};
	public boolean isInfused;

	public RioVPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial, boolean par2)
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
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
	{
		if (var1.itemID == Items.agonitePickaxe.itemID)
		{
			var3.add("Used to mine Nironite/Dragon/Vravinite Ore");
		}

		if(Config.showToolInfo)
		{
			var3.add(Color.GOLD + (var1.getMaxDamage() - var1.getItemDamage()) + " Uses");
			var3.add(Color.DARK_PURPLE + "Mining Speed: " + toolMaterial.getEfficiencyOnProperMaterial());
			var3.add(Color.AQUA + "Harvest Level: " + toolMaterial.getHarvestLevel());
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister)
	{
		if(itemID == Items.onyxPickaxe.itemID || itemID == Items.infusedOnyxPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "onyxPickaxe");
		}
		if(itemID == Items.amethystPickaxe.itemID || itemID == Items.infusedAmethystPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "amethystPickaxe");
		}
		if(itemID == Items.agonitePickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "agonitePickaxe");
		}
		if(itemID == Items.sapphirePickaxe.itemID || itemID == Items.infusedSapphirePickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sapphirePickaxe");
		}
		if(itemID == Items.topazPickaxe.itemID || itemID == Items.infusedTopazPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "topazPickaxe");
		}
		if(itemID == Items.dragonPickaxe.itemID || itemID == Items.infusedDragonPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "dragonPickaxe");
		}
		if(itemID == Items.glimmerwoodPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "glimmerwoodPickaxe");
		}
		if(itemID == Items.vravinitePickaxe.itemID || itemID == Items.infusedVravinitePickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "vravinitePickaxe");
		}
		if(itemID == Items.blindonitePickaxe.itemID || itemID == Items.infusedBlindonitePickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "blindonitePickaxe");
		}
		if(itemID == Items.cherryBlossomPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "cherryBlossomPickaxe");
		}
		if(itemID == Items.bloodPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "bloodPickaxe");
		}
		if(itemID == Items.skywoodPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "skywoodPickaxe");
		}
		if(itemID == Items.sanctuaryStonePickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "sanctuaryStonePickaxe");
		}
		if(itemID == Items.alerisPickaxe.itemID)
		{
			this.itemIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "alerisPickaxe");
		}
		
		if(TheMistsOfRioV.getInstance().natura)
		{
			if(itemID == Items.infusedBloodwoodPickaxe.itemID || itemID == Items.infusedGhostwoodPickaxe.itemID || itemID == Items.infusedDarkwoodPickaxe.itemID || itemID == Items.infusedFusewoodPickaxe.itemID || itemID == Items.infusedNetherquartzPickaxe.itemID)
				this.itemIcon = par1IconRegister.registerIcon(this.unlocalizedName);
		}
		
		if(TheMistsOfRioV.getInstance().aether)
		{
			if(itemID == Items.infusedSkyrootPickaxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Skyroot Pickaxe");
			if(itemID == Items.infusedHolystonePickaxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Holystone Pickaxe");
			if(itemID == Items.infusedZanitePickaxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Zanite Pickaxe");
			if(itemID == Items.infusedGravititePickaxe.itemID) this.itemIcon = par1IconRegister.registerIcon("Aether:Gravitite Pickaxe");
		}
	}
}
