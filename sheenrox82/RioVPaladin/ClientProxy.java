package sheenrox82.RioVPaladin;

import sheenrox82.RioV.src.base.*;
import sheenrox82.RioV.src.entity.*;
import sheenrox82.RioV.src.model.*;
import sheenrox82.RioV.src.render.*;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy 
{

	@Override
	public void init() 
	{
		RenderingRegistry.registerEntityRenderingHandler(sheenrox82.RioVPaladin.EntityPaladin.class, new sheenrox82.RioVPaladin.RenderPaladin());
	}

	public static int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
}