package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import mods.natura.common.NContent;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.SieveRegistry;

public class ModNatura {
	public static void init()
	{
		addSieveRegistry();
		addCompostRegistry();
	}
	
	public static void addSieveRegistry()
	{
		if (ExAstrisRebirthData.allowNaturaPlants)
		{
			//Saplings
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.rareSapling), 0, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.rareSapling), 1, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.rareSapling), 2, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.rareSapling), 3, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.rareSapling), 4, 128);
			
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.floraSapling), 0, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.floraSapling), 1, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.floraSapling), 2, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.floraSapling), 3, 128);
			
			SieveRegistry.register(Blocks.soul_sand, 0, Item.getItemFromBlock(NContent.floraSapling), 4, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, Item.getItemFromBlock(NContent.floraSapling), 5, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, Item.getItemFromBlock(NContent.floraSapling), 6, 128);
			SieveRegistry.register(Blocks.soul_sand, 0, Item.getItemFromBlock(NContent.floraSapling), 7, 128);
			
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.berryBush), 12, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.berryBush), 13, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.berryBush), 14, 128);
			SieveRegistry.register(NContent.grassBlock, 0, Item.getItemFromBlock(NContent.berryBush), 15, 128);
			
			SieveRegistry.register(Blocks.soul_sand, 0, Item.getItemFromBlock(NContent.taintedSoil), 0, 32);
			SieveRegistry.register(Blocks.soul_sand, 0, Item.getItemFromBlock(NContent.heatSand), 0, 32);	
			
			SieveRegistry.register(NContent.taintedSoil, 0, Item.getItemFromBlock(NContent.netherBerryBush) , 12, 64);
			SieveRegistry.register(NContent.taintedSoil, 0, Item.getItemFromBlock(NContent.netherBerryBush), 13, 64);
			SieveRegistry.register(NContent.taintedSoil, 0, Item.getItemFromBlock(NContent.netherBerryBush), 14, 64);
			SieveRegistry.register(NContent.taintedSoil, 0, Item.getItemFromBlock(NContent.netherBerryBush), 15, 64);
			
		}
	}
	
	public static void addCompostRegistry()
	{
		if (ExAstrisRebirthData.allowNaturaPlantsToBeComposted)
		{
			for (int i = 0 ; i < 5; i++)
				CompostRegistry.register(Item.getItemFromBlock(NContent.rareSapling), i, 0.125f, ColorRegistry.color("oak"));
			for (int i = 0; i < 8; i++)
				CompostRegistry.register(Item.getItemFromBlock(NContent.floraSapling), i, 0.125f, ColorRegistry.color("oak"));
			for (int i = 12; i < 15; i++)
			{
				CompostRegistry.register(Item.getItemFromBlock(NContent.berryBush), i, 0.20f, ColorRegistry.color("oak"));
				CompostRegistry.register(Item.getItemFromBlock(NContent.netherBerryBush), i, 0.20f, ColorRegistry.color("rotten_flesh"));
			}
		}
	}
}
