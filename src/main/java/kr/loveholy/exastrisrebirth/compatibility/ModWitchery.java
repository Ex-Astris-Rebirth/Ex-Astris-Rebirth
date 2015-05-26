package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;

import com.emoniph.witchery.Witchery;
import com.emoniph.witchery.WitcheryFluids;
import com.emoniph.witchery.WitcheryItems;
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
			BarrelRecipeRegistry.addMobRecipe(Fluids.fluidWitchWater, new ItemStack(GameRegistry.findItem("witchery", "witchhand")), EntityCovenWitch.class, "portal", new ItemStack(GameRegistry.findItem("witchery", "witchhand")));
	}
	
	private static void addSifting()
	{
		SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_ARTICHOKE , 0, ExAstrisRebirthData.witcherySeedsChance);//seedsartichoke
		SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_WOLFSBANE, 0, ExAstrisRebirthData.witcherySeedsChance);//seedswolfsbane
		SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_MANDRAKE, 0, ExAstrisRebirthData.witcherySeedsChance);//seedsmandrake
		SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_BELLADONNA, 0, ExAstrisRebirthData.witcherySeedsChance);//seedsbelladonna
		SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_SNOWBELL, 0, ExAstrisRebirthData.witcherySeedsChance);//seedssnowbell
	}
}
