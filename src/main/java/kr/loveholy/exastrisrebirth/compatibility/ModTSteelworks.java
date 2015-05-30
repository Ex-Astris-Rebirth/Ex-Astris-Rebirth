package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.smeltery.TinkerSmeltery;
import toops.tsteelworks.api.PluginFactory;
import toops.tsteelworks.api.highoven.ISmeltingRegistry;

public class ModTSteelworks {
	public static final int ingotLiquidValue = TConstruct.ingotLiquidValue;
	public static final int ingotCostHighoven = TConstruct.ingotLiquidValue;
	private static ISmeltingRegistry instance;
	public static void init()
	{
		instance = (ISmeltingRegistry) PluginFactory.getInstance(ISmeltingRegistry.class);
		if(ExAstrisRebirthData.allowSteelworksMelting)
		{
			addMeltingRecipe();
		}
	}
	public static void addMeltingRecipe()
	{
		if(ExAstrisRebirthData.allowAddTConstructNetherOre)
		{
			addMeltableOre(new ItemStack(ExAstrisRebirthBlock.blockOreCobalt, 1, 2), new FluidStack(TinkerSmeltery.moltenCobaltFluid,ingotCostHighoven), 650);
			addMeltableOre(new ItemStack(ExAstrisRebirthBlock.blockOreArdite, 1, 2),  new FluidStack(TinkerSmeltery.moltenArditeFluid, ingotCostHighoven), 650);
		}

		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "iron_dust"), 0), new FluidStack(TinkerSmeltery.moltenIronFluid, ingotCostHighoven), 600);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "gold_dust"), 0), new FluidStack(TinkerSmeltery.moltenGoldFluid, ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "copper_dust"), 0), new FluidStack(TinkerSmeltery.moltenCopperFluid, ingotCostHighoven), 550);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "tin_dust"), 0), new FluidStack(TinkerSmeltery.moltenTinFluid, ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "silver_dust"), 0), new FluidStack(TinkerSmeltery.moltenSilverFluid, ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "lead_dust"), 0), new FluidStack(TinkerSmeltery.moltenLeadFluid, ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "nickel_dust"), 0), new FluidStack(TinkerSmeltery.moltenNickelFluid, ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "platinum_dust"), 0), new FluidStack(TinkerSmeltery.moltenShinyFluid, ingotCostHighoven), 400);
		addMeltableOre(new ItemStack(GameRegistry.findBlock("exnihilo", "aluminum_dust"), 0), new FluidStack(TinkerSmeltery.moltenAluminumFluid, ingotCostHighoven), 400);

	}

	public static void addMeltableOre(ItemStack stack, FluidStack output, int temperature)
	{
		if (stack != null && output != null && stack.getItem() != null && output.getFluid() != null) //More null checks than you can poke a stick at
		{
			instance.addMeltable(stack, true, output, temperature);
		}
	}
}
