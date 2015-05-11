package kr.loveholy.exastrisrebirth.compatibility;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.helpers.Color;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;

public class ModMineFactoryReloaded {
	public static void init()
	{
		addColorRegistry();
		if(ExAstrisRebirthData.allowMFRCompost)
		{
			addCompostRegistry();
		}
	}
	public static void addColorRegistry()
	{
		ColorRegistry.register("rubberwood", new Color("29410A"));
	}
	public static void addCompostRegistry()
	{
		
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.sapling"), 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.sapling"), 1, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.leaves"), 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(GameRegistry.findItem("MineFactoryReloaded", "rubberwood.leaves"), 1, 0.125F, ColorRegistry.color("rubberwood"));
		
	}
}
