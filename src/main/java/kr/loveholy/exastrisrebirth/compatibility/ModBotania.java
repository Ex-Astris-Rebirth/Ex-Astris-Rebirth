package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.helpers.Color;

public class ModBotania {
	public static void init()
	{
		if (ExAstrisRebirthData.allowBotaniaComposting)
		{
			registerColors();
			addCompostables();
		}
	}
	
	public static void registerColors()
	{
		ColorRegistry.register("Botania", new Color("33CC33"));
	}
	
	public static void addCompostables()
	{
		for (int i = 0; i<16; i++)
		{
			CompostRegistry.register(GameRegistry.findItem("Botania", "flower"), i, 0.125f, ColorRegistry.color("Botania"));
		}
	}
	
}
