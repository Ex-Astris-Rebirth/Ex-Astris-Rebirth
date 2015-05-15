package kr.loveholy.exastrisrebirth.compatibility;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRecipe;
import WayofTime.alchemicalWizardry.api.bindingRegistry.BindingRegistry;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import kr.loveholy.exastrisrebirth.item.ItemHammerBound;

public class ModBloodMagic {
	public static void init()
	{
		addAlterRegistry();
		addBindingRegistry();
	}
	public static void addBindingRegistry()
	{
		if(ExAstrisRebirthData.allowHammerBound)
		{
			BindingRegistry.registerRecipe(new ItemStack(ExAstrisRebirthItem.itemHammerBound), new ItemStack(GameRegistry.findItem("exnihilo", "hammer_diamond")));
		}
	}
	public static void addAlterRegistry()
	{
		if(ExAstrisRebirthData.allowUnchargedNetherstar)
		{
			AltarRecipeRegistry.registerAltarRecipe(new ItemStack(Items.nether_star), new ItemStack(ExAstrisRebirthItem.itemUnchargedNetherStar), 4, 20000, 20, 20, false);
		}
	}
	public static Item itemHammerBound()
	{
		return new ItemHammerBound();
	}
}
