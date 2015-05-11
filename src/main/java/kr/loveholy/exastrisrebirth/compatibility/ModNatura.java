package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.SieveRegistry;

public class ModNatura {
	public static void init()
	{
		if (ExAstrisRebirthData.allowNaturaPlants)
		{
			//Saplings
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 0, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 1, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 2, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 3, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","Rare Sapling"), 4, 128);
			
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 0, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 1, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 2, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","florasapling"), 3, 128);
			
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 4, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 5, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 6, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","florasapling"), 7, 128);
			
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 12, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 13, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 14, 128);
			SieveRegistry.register(GameRegistry.findBlock("Natura","GrassBlock"), 0, GameRegistry.findItem("Natura","BerryBush"), 15, 128);
			
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","soil.tainted"), 0, 32);
			SieveRegistry.register(Blocks.soul_sand, 0, GameRegistry.findItem("Natura","heatsand"), 0, 32);	
			
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 12, 64);
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 13, 64);
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 14, 64);
			SieveRegistry.register(GameRegistry.findBlock("Natura", "soil.tainted"), 0, GameRegistry.findItem("Natura","NetherBerryBush"), 15, 64);
			
		}
		
		if (ExAstrisRebirthData.allowNaturaPlantsToBeComposted)
		{
			for (int i = 0 ; i < 5; i++)
				CompostRegistry.register(GameRegistry.findItem("Natura","Rare Sapling"), i, 0.125f, ColorRegistry.color("oak"));
			for (int i = 0; i < 8; i++)
				CompostRegistry.register(GameRegistry.findItem("Natura","florasapling"), i, 0.125f, ColorRegistry.color("oak"));
			for (int i = 12; i < 15; i++)
			{
				CompostRegistry.register(GameRegistry.findItem("Natura","BerryBush"), i, 0.20f, ColorRegistry.color("oak"));
				CompostRegistry.register(GameRegistry.findItem("Natura","NetherBerryBush"), i, 0.20f, ColorRegistry.color("rotten_flesh"));
			}
		}
	}
}
