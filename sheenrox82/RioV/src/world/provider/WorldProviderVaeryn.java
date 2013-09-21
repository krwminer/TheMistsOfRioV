package sheenrox82.RioV.src.world.provider;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.content.Biomes;
import sheenrox82.RioV.src.world.chunk.ChunkProviderVaeryn;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderVaeryn extends WorldProvider
{

	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(Biomes.glimmerwood, 0.5F, 0.5F);
		this.dimensionId = Config.vaerynID;
		this.hasNoSky = false;
	}

	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderVaeryn(this.worldObj, this.worldObj.getSeed(), true);
	}

	public int getAverageGroundLevel()
	{
		return 0;
	}

	
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int par1, int par2)
	{
		return false;
	}

	public String getDimensionName()
	{
		return "Vaeryn";
	}

	public boolean renderStars()
	{
		return true;
	}

	public float getStarBrightness(World world, float f)
	{
		return 10.0F;
	}

	public boolean renderClouds()
	{
		return true;
	}

	public boolean renderVoidFog()
	{
		return false;
	}

	public boolean renderEndSky()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public boolean isSkyColored()
	{
		return false;
	}

	public boolean canRespawnHere()
	{
		return false;
	}

	public boolean isSurfaceWorld()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public float getCloudHeight()
	{
		return 128.0F;
	}

	public boolean canCoordinateBeSpawn(int par1, int par2)
	{
		return false;
	}

	public ChunkCoordinates getEntrancePortalLocation()
	{
		return new ChunkCoordinates(50, 5, 0);
	}

	@SideOnly(Side.CLIENT)
	public String getWelcomeMessage()
	{
		return "Entering Vaeryn";
	}
	
    public String getSaveFolder()
    {
        return "VaerynDim";
    }
}