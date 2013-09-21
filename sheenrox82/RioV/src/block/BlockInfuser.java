package sheenrox82.RioV.src.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Particles;
import sheenrox82.RioV.src.tileentity.TileEntityInfuser;
import sheenrox82.RioV.src.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInfuser extends BlockContainer
{
    private Random AltarRand = new Random();
    private final boolean isActive;
    private static boolean keepAltarInventory = false;
    @SideOnly(Side.CLIENT)
    private Icon field_94461_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94460_b;

    public BlockInfuser(int par1, boolean par3)
    {
        super(par1, Material.rock);
        setHardness(6.0F);
        setResistance(6.0F);
        this.isActive = par3;
        this.setCreativeTab(TheMistsOfRioV.tab);
    }
    
    @Override
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 0 ? this.field_94460_b : (par1 == 1 ? this.field_94461_a : this.blockIcon);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "infuser_side");
        this.field_94461_a = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "infuser_top");
        this.field_94460_b = par1IconRegister.registerIcon(Util.MOD_ID + ":" + "infuser_bottom");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

        for (int var6 = par2 - 2; var6 <= par2 + 2; ++var6)
        {
            for (int var7 = par4 - 2; var7 <= par4 + 2; ++var7)
            {
                if (var6 > par2 - 2 && var6 < par2 + 2 && var7 == par4 - 1)
                {
                    var7 = par4 + 2;
                }

                if (par5Random.nextInt(16) == 0)
                {
                    for (int var8 = par3; var8 <= par3 + 1; ++var8)
                    {
                        
                            if (!par1World.isAirBlock((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4))
                            {
                                break;
                            }

                            par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);
                            Particles.spawnParticle("glimmer", (double)par2 + 0.5D, (double)par3 + 1.0D, (double)par4 + 0.5D, (double)((float)(par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(par3) - par5Random.nextFloat() - 1.0F), (double)((float)(par4) + par5Random.nextFloat()) - 0.5D);
                       
                        	if (!par1World.isAirBlock((var6 - par2) / 2 + par2, var8, (var7 - par4) / 2 + par4))
                            {
                                break;
                            }

                            par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(var6 - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(var8 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(var7 - par4) + par5Random.nextFloat()) - 0.5D);
                            Particles.spawnParticle("glimmer", (double)par2 + 0.5D, (double)par3 + 1.0D, (double)par4 + 0.5D, (double)((float)(par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(par3) - par5Random.nextFloat() - 1.0F), (double)((float)(par4) + par5Random.nextFloat()) - 0.5D);                       	
                    }
                }
            }
        }
    }
    
    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int var5 = par1World.getBlockId(par2, par3, par4 - 1);
            int var6 = par1World.getBlockId(par2, par3, par4 + 1);
            int var7 = par1World.getBlockId(par2 - 1, par3, par4);
            int var8 = par1World.getBlockId(par2 + 1, par3, par4);
            byte var9 = 3;

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
            {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
            {
                var9 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9, var8);
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

	    if (!world.isRemote)
	    {
            TileEntityInfuser tileEntityInfusionAltar = (TileEntityInfuser) world.getBlockTileEntity(x, y, z);
            if(player.isSneaking() || tileEntityInfusionAltar == null)
            {
            	return false;
            }
            else if (tileEntityInfusionAltar != null)
            {
                player.openGui(TheMistsOfRioV.getInstance(), 2, world, x, y, z);
            }
	    }

        return true;

    }

    
    @Override
    public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityInfuser();
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepAltarInventory)
        {
            TileEntityInfuser var7 = (TileEntityInfuser)par1World.getBlockTileEntity(par2, par3, par4);

            if (var7 != null)
            {
                for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
                {
                    ItemStack var9 = var7.getStackInSlot(var8);

                    if (var9 != null)
                    {
                        float var10 = this.AltarRand.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.AltarRand.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.AltarRand.nextFloat() * 0.8F + 0.1F;

                        while (var9.stackSize > 0)
                        {
                            int var13 = this.AltarRand.nextInt(21) + 10;

                            if (var13 > var9.stackSize)
                            {
                                var13 = var9.stackSize;
                            }

                            var9.stackSize -= var13;
                            EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

                            float var15 = 0.05F;
                            var14.motionX = (double)((float)this.AltarRand.nextGaussian() * var15);
                            var14.motionY = (double)((float)this.AltarRand.nextGaussian() * var15 + 0.2F);
                            var14.motionZ = (double)((float)this.AltarRand.nextGaussian() * var15);
                            par1World.spawnEntityInWorld(var14);
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
}
