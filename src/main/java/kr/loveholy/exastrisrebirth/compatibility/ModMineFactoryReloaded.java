package kr.loveholy.exastrisrebirth.compatibility;

import powercrystals.minefactoryreloaded.setup.MFRThings;
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
		
		CompostRegistry.register(MFRThings.rubberSaplingItem, 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(MFRThings.rubberSaplingItem, 1, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(MFRThings.rubberLeavesItem, 0, 0.125F, ColorRegistry.color("rubberwood"));
		CompostRegistry.register(MFRThings.rubberLeavesItem, 1, 0.125F, ColorRegistry.color("rubberwood"));
		
	}
}
