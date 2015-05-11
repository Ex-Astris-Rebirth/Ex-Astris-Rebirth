package kr.loveholy.exastrisrebirth.compatibility;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;

public class ModBloodMagic {
	public static void init()
	{
		addAlterRegistry();
	}
	public static void addAlterRegistry()
	{
		if(ExAstrisRebirthData.allowUnchargedNetherstar)
		{
			AltarRecipeRegistry.registerAltarRecipe(new ItemStack(Items.nether_star), new ItemStack(ExAstrisRebirthItem.itemUnchargedNetherStar), 4, 20000, 20, 20, false);
		}
	}
	
}
