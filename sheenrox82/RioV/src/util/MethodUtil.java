package sheenrox82.RioV.src.util;

import java.lang.reflect.Field;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraftforge.common.DimensionManager;
import sheenrox82.RioV.src.base.Config;
import sheenrox82.RioV.src.base.TheMistsOfRioV;
import sheenrox82.RioV.src.content.Sound;
import sheenrox82.RioV.src.entity.projectile.EntityCustomArrow;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MethodUtil 
{
	public static int id = 500;
	private static Field fMaxDamageFactor = null;

	public static void registerItem(Item var0, String var1)
	{
		GameRegistry.registerItem(var0, var1);
		LanguageRegistry.addName(var0, var1);
	}

	public static void registerBlock(Block var0, String var1)
	{
		GameRegistry.registerBlock(var0, var1);
		LanguageRegistry.addName(var0, var1);
	}

	public static DamageSource causeArrowDamage(EntityCustomArrow entityDarknessArrow, Entity par1Entity)
	{
		return (new EntityDamageSourceIndirect("arrow", entityDarknessArrow, par1Entity)).setProjectile();
	}

	public static void registerEntity(Class entityClass, String entityName)
	{
		int entityID = Config.addEntity(entityName);
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, entityID);
		EntityRegistry.registerModEntity(entityClass, entityName, entityID, TheMistsOfRioV.getInstance(), 128, 1, true);
		LanguageRegistry.instance().addStringLocalization("entity." + entityName + ".name", entityName);
	}

	public static void registerEgg(Class entityClass)
	{
		int ID = uniqueEggID();
		EntityList.IDtoClassMapping.put(ID, entityClass);
		EntityList.entityEggs.put(ID, new EntityEggInfo(ID, 0xffffff, 0x000000));
	}

	public static int uniqueEggID()
	{
		return id++;
	}	

	public static void registerDimension(int id, Class worldProvider)
	{
		DimensionManager.registerProviderType(id, worldProvider, true);
		DimensionManager.registerDimension(id, id);
	}
	
	public static String getName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.lastIndexOf(".") + 1);
	}
	
	public static int getMaxDamageFactor(EnumArmorMaterial material) {
		int maxDamageFactor = 0;

		try {
			if (fMaxDamageFactor == null) {
				fMaxDamageFactor = material.getClass().getDeclaredField("field_78048_f");
				fMaxDamageFactor.setAccessible(true);
			}
			maxDamageFactor = fMaxDamageFactor.getInt(material);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return maxDamageFactor;
	}
}
