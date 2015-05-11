package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cofh.api.modhelpers.ThermalExpansionHelper;
import cofh.thermalfoundation.entity.monster.EntityBlizz;
import cofh.thermalfoundation.fluid.TFFluids;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.registries.BarrelRecipeRegistry;
import exnihilo.registries.HeatRegistry;

public class ModThermalExpansion {
	public static void init()
	{
		if(ExAstrisRebirthData.allowThermalExpansionHeat)
		{
			addHeatRegistry();
		}
		if(ExAstrisRebirthData.allowThermalExpansionHive)
		{
			addHiveRegistry();
		}
		
		addBarrelRegistry();
	}
	public static void addHiveRegistry()
	{
		if (Loader.isModLoaded("Forestry"))
		{
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(Blocks.leaves,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,1));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(Blocks.grass,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,2));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(Blocks.sand,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,3));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(Blocks.vine,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,4));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(Items.ender_pearl,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,5));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(Blocks.ice,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,6));
			ThermalExpansionHelper.addSmelterRecipe(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(Blocks.mycelium,8),new ItemStack(GameRegistry.findBlock("Forestry", "beehives"),1,7));
		}
		if (Loader.isModLoaded("ExtraBees"))
		{
			ThermalExpansionHelper.addTransposerFill(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,0),new FluidStack(FluidRegistry.WATER, 8000),false);
			ThermalExpansionHelper.addTransposerFill(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,1),new FluidStack(FluidRegistry.LAVA, 8000),false);
			ThermalExpansionHelper.addTransposerFill(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,2),new FluidStack(TFFluids.fluidRedstone, 8000),false);
			ThermalExpansionHelper.addTransposerFill(10000, new ItemStack(ENBlocks.BeeTrapTreated),new ItemStack(GameRegistry.findBlock("ExtraBees", "hive"),1,3),new FluidStack(TFFluids.fluidGlowstone, 8000),false);
			
		}
	}
	public static void addHeatRegistry()
	{
		
		HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation","FluidPyrotheum"), 0.5F);
		HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation","FluidPyrotheum"), 0, 0.7F);
		HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation","FluidCryotheum"), 0.2F);
		HeatRegistry.register(GameRegistry.findBlock("ThermalFoundation","FluidCryotheum"), 0, 0.3F);
		
	}
	public static void addBarrelRegistry()
	{
		if(ExAstrisRebirthData.allowThermalExpansionBlizz)
		{
			BarrelRecipeRegistry.addMobRecipe(FluidRegistry.WATER, new ItemStack(ExAstrisRebirthItem.itemDollFreezing), EntityBlizz.class, "snowballpoof", new ItemStack(ExAstrisRebirthItem.itemDollFreezing));
		}
	}
}
