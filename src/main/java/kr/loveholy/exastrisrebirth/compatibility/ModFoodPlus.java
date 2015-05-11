package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import kr.loveholy.exastrisrebirth.item.ItemSeedFoodPlus;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.SieveRegistry;

public class ModFoodPlus {
	public static void init()
	{
		Block[] saplingBlocks = {GameRegistry.findBlock("FoodPlus", "cherry_sapling"),
			GameRegistry.findBlock("FoodPlus", "banana_sapling"),
			GameRegistry.findBlock("FoodPlus", "orange_sapling"),
			GameRegistry.findBlock("FoodPlus", "kiwi_sapling"),
			GameRegistry.findBlock("FoodPlus", "walnut_sapling"),
			GameRegistry.findBlock("FoodPlus", "coconut_sapling"),
			GameRegistry.findBlock("FoodPlus", "pear_sapling")};	
		ItemSeedFoodPlus.addPlants(saplingBlocks);
		
		SieveRegistry.register(Blocks.grass, ExAstrisRebirthItem.itemSeedFoodPlus, 0, ExAstrisRebirthData.foodPlusSaplingSiftingChance);
		
		if (ExAstrisRebirthData.allowFoodPlusSaplingsToBeComposted)
		{
			for (Block bl : saplingBlocks)
				CompostRegistry.register(Item.getItemFromBlock(bl), 0, 0.125f, ColorRegistry.color("oak"));
		}
	}
}
