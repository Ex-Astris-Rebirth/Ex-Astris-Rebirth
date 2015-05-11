package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;

import com.emoniph.witchery.entity.EntityCovenWitch;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import exnihilo.Fluids;
import exnihilo.registries.BarrelRecipeRegistry;
import exnihilo.registries.SieveRegistry;

public class ModWitchery {
	public static void init()
	{
		addSifting();
		if (ExAstrisRebirthData.witcheryEnableCovenWitch)
			BarrelRecipeRegistry.addMobRecipe(Fluids.fluidWitchWater, new ItemStack(GameRegistry.findItem("witchery", "witchhand")), EntityCovenWitch.class, "portal", null);
	}
	
	private static void addSifting()
	{
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsartichoke"), 0, ExAstrisRebirthData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedswolfsbane"), 0, ExAstrisRebirthData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsmandrake"), 0, ExAstrisRebirthData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedsbelladonna"), 0, ExAstrisRebirthData.witcherySeedsChance);
		SieveRegistry.register(Blocks.grass, 0, GameRegistry.findItem("witchery", "seedssnowbell"), 0, ExAstrisRebirthData.witcherySeedsChance);
	}
}
