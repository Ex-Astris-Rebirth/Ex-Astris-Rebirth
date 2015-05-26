package kr.loveholy.exastrisrebirth.compatibility;

import com.foodplus.core.FoodPlusBlocks;

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
		Block[] saplingBlocks = {FoodPlusBlocks.CherrySapling,//cherry_sapling
				FoodPlusBlocks.BananaSapling,//banana_sapling
				FoodPlusBlocks.OrangeSapling,//orange_sapling
				FoodPlusBlocks.KiwiSapling,//kiwi_sapling
				FoodPlusBlocks.WalnutSapling,//walnut_sapling
				FoodPlusBlocks.CoconutSapling,//coconut_sapling
				FoodPlusBlocks.PearSapling};//pear_sapling
		ItemSeedFoodPlus.addPlants(saplingBlocks);
		
		SieveRegistry.register(Blocks.grass, ExAstrisRebirthItem.itemSeedFoodPlus, 0, ExAstrisRebirthData.foodPlusSaplingSiftingChance);
		
		if (ExAstrisRebirthData.allowFoodPlusSaplingsToBeComposted)
		{
			for (Block bl : saplingBlocks)
				CompostRegistry.register(Item.getItemFromBlock(bl), 0, 0.125f, ColorRegistry.color("oak"));
		}
	}
}
