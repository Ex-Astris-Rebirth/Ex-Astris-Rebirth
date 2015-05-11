package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.CrucibleRegistry;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Color;

public class ModMetallurgy {
	public static void init()
	{
		addHammerRegistry();
		addSieveRegistry();
		addSmelteryRegistry();
		addCrucibleRegistry();
	}
	public static void addCrucibleRegistry()
	{
		if(Loader.isModLoaded("TConstruct") && ExAstrisRebirthData.allowMiniSmeltery)
		{
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "eximite_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("eximite.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "eximite_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "meutoite_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("meutoite.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "meutoite_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "prometheum_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("prometheum.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "prometheum_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "deepiron_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("deep.iron.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "deepiron_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "infuscolium_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("infuscolium.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "infuscolium_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "oureclase_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("oureclase.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "oureclase_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "astralsilver_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("astral.silver.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "astralsilver_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "carmot_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("carmot.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "carmot_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "mithril_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("mithril.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "mithril_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "rubracium_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("rubracium.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "rubracium_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "orichalcum_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("orichalcum.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "orichalcum_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "adamantine_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("adamantine.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "adamantine_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "atlarus_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("atlarus.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "atlarus_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "zinc_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("zinc.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "zinc_dust"));
						
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "ignatius_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("ignatius.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "ignatius_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "shadowiron_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("shadow.iron.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "shadowiron_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "lemurite_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("lemurite.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "lemurite_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "midasium_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("midasium.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "midasium_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "vyroxeres_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("vyroxeres.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "vyroxeres_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "ceruclase_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("ceruclase.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "ceruclase_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "alduorite_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("alduorite.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "alduorite_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "kalendrite_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("kalendrite.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "kalendrite_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "vulcanite_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("vulcanite.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "vulcanite_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exastrisrebirth", "sanguinite_dust"), 0, ModTConstruct.ingotCostSmeltery, FluidRegistry.getFluid("sanguinite.molten"), ModTConstruct.ingotLiquidValue, GameRegistry.findBlock("exastrisrebirth", "sanguinite_dust"));
		}
	}
	public static void addSmelteryRegistry()
	{
		if (Loader.isModLoaded("TConstruct") && ExAstrisRebirthData.allowMetallurgyOres)
		{
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "ender_eximite_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("eximite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "eximite_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("eximite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "eximite_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("eximite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "ender_meutoite_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("meutoite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "meutoite_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("meutoite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "meutoite_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("meutoite.molten"), ModTConstruct.ingotCostSmeltery));
			
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "prometheum_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("prometheum.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "prometheum_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("prometheum.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "prometheum_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("prometheum.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "deepiron_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("deep.iron.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "deepiron_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("deep.iron.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "deepiron_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("deep.iron.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "infuscolium_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("infuscolium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "infuscolium_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("infuscolium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "infuscolium_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("infuscolium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "oureclase_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("oureclase.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "oureclase_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("oureclase.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "oureclase_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("oureclase.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "astralsilver_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("astral.silver.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "astralsilver_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("astral.silver.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "astralsilver_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("astral.silver.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "carmot_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("carmot.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "carmot_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("carmot.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "carmot_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("carmot.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "mithril_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("mithril.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "mithril_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("mithril.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "mithril_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("mithril.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "rubracium_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("rubracium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "rubracium_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("rubracium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "rubracium_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("rubracium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "orichalcum_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("orichalcum.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "orichalcum_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("orichalcum.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "orichalcum_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("orichalcum.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "adamantine_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("adamantine.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "adamantine_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("adamantine.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "adamantine_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("adamantine.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "atlarus_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("atlarus.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "atlarus_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("atlarus.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "atlarus_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("atlarus.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "zinc_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("zinc.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "zinc_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("zinc.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "zinc_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("zinc.molten"), ModTConstruct.ingotCostSmeltery));
			
			
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_ignatius_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("ignatius.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "ignatius_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("ignatius.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "ignatius_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("ignatius.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_shadowiron_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("shadow.iron.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "shadowiron_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("shadow.iron.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "shadowiron_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("shadow.iron.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_lemurite_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("lemurite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "lemurite_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("lemurite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "lemurite_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("lemurite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_midasium_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("midasium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "midasium_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("midasium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "midasium_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("midasium.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_vyroxeres_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("vyroxeres.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "vyroxeres_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("vyroxeres.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "vyroxeres_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("vyroxeres.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_ceruclase_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("ceruclase.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "ceruclase_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("ceruclase.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "ceruclase_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("ceruclase.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_alduorite_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("alduorite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "alduorite_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("alduorite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "alduorite_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("alduorite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_kalendrite_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("kalendrite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "kalendrite_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("kalendrite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "kalendrite_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("kalendrite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_vulcanite_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("vulcanite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "vulcanite_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("vulcanite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "vulcanite_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("vulcanite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "nether_sanguinite_gravel"), 0, 650, new FluidStack(FluidRegistry.getFluid("sanguinite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "sanguinite_sand"), 0, 650, new FluidStack(FluidRegistry.getFluid("sanguinite.molten"), ModTConstruct.ingotCostSmeltery));
			ModTConstruct.addMelting(GameRegistry.findBlock("exastrisrebirth", "sanguinite_dust"), 0, 650, new FluidStack(FluidRegistry.getFluid("sanguinite.molten"), ModTConstruct.ingotCostSmeltery));
			
			if (Loader.isModLoaded("TSteelworks"))
			{
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "eximite_dust"), 0), new FluidStack(FluidRegistry.getFluid("eximite.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "meutoite_dust"), 0), new FluidStack(FluidRegistry.getFluid("meutoite.molten"), ModTSteelworks.ingotCostHighoven), 650);
				
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "prometheum_dust"), 0), new FluidStack(FluidRegistry.getFluid("prometheum.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "deepiron_dust"), 0), new FluidStack(FluidRegistry.getFluid("deep.iron.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "infuscolium_dust"), 0), new FluidStack(FluidRegistry.getFluid("infuscolium.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "oureclase_dust"), 0), new FluidStack(FluidRegistry.getFluid("oureclase.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "astralsilver_dust"), 0), new FluidStack(FluidRegistry.getFluid("astral.silver.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "carmot_dust"), 0), new FluidStack(FluidRegistry.getFluid("carmot.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "mithril_dust"), 0), new FluidStack(FluidRegistry.getFluid("mithril.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "rubracium_dust"), 0), new FluidStack(FluidRegistry.getFluid("rubracium.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "orichalcum_dust"), 0), new FluidStack(FluidRegistry.getFluid("orichalcum.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "adamantine_dust"), 0), new FluidStack(FluidRegistry.getFluid("adamantine.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "atlarus_dust"), 0), new FluidStack(FluidRegistry.getFluid("atlarus.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "zinc_dust"), 0), new FluidStack(FluidRegistry.getFluid("zinc.molten"), ModTSteelworks.ingotCostHighoven), 650);
						
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "ignatius_dust"), 0), new FluidStack(FluidRegistry.getFluid("ignatius.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "shadowiron_dust"), 0), new FluidStack(FluidRegistry.getFluid("shadow.iron.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "lemurite_dust"), 0), new FluidStack(FluidRegistry.getFluid("lemurite.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "midasium_dust"), 0), new FluidStack(FluidRegistry.getFluid("midasium.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "vyroxeres_dust"), 0), new FluidStack(FluidRegistry.getFluid("vyroxeres.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "ceruclase_dust"), 0), new FluidStack(FluidRegistry.getFluid("ceruclase.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "alduorite_dust"), 0), new FluidStack(FluidRegistry.getFluid("alduorite.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "kalendrite_dust"), 0), new FluidStack(FluidRegistry.getFluid("kalendrite.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "vulcanite_dust"), 0), new FluidStack(FluidRegistry.getFluid("vulcanite.molten"), ModTSteelworks.ingotCostHighoven), 650);
				ModTSteelworks.addMeltableOre(new ItemStack(GameRegistry.findBlock("exastrisrebirth", "sanguinite_dust"), 0), new FluidStack(FluidRegistry.getFluid("sanguinite.molten"), ModTSteelworks.ingotCostHighoven), 650);
			}
		}
		
	}
	public static void addHammerRegistry()
	{
		if(ExAstrisRebirthData.allowMetallurgyOres)
		{

			OreRegistry.createEnderOre("eximite", new Color("4b3173"), 128, GameRegistry.findItem("Metallurgy", "eximite.ingot"), false);
			OreRegistry.createEnderOre("meutoite", new Color("473f54"), 128, GameRegistry.findItem("Metallurgy", "meutoite.ingot"), false);
			
			OreRegistry.createOverworldOre("prometheum", new Color("46835c"), 128, GameRegistry.findItem("Metallurgy", "prometheum.ingot"), false); 
			OreRegistry.createOverworldOre("deepiron", new Color("1b3549"), 128, GameRegistry.findItem("Metallurgy", "deep.iron.ingot"), false);  
			OreRegistry.createOverworldOre("infuscolium", new Color("640036"), 128, GameRegistry.findItem("Metallurgy", "infuscolium.ingot"), false);  
			OreRegistry.createOverworldOre("oureclase", new Color("934d0c"), 128, GameRegistry.findItem("Metallurgy", "oureclase.ingot"), false);  
			OreRegistry.createOverworldOre("astralsilver", new Color("809b9f"), 128, GameRegistry.findItem("Metallurgy", "astral.silver.ingot"), false);  
			OreRegistry.createOverworldOre("carmot", new Color("b7ab65"), 128, GameRegistry.findItem("Metallurgy", "carmot.ingot"), false);  
			OreRegistry.createOverworldOre("mithril", new Color("5acad9"), 128, GameRegistry.findItem("Metallurgy", "mithril.ingot"), false);  
			OreRegistry.createOverworldOre("rubracium", new Color("731824"), 128, GameRegistry.findItem("Metallurgy", "rubracium.ingot"), false);  
			OreRegistry.createOverworldOre("orichalcum", new Color("30652f"), 128, GameRegistry.findItem("Metallurgy", "orichalcum.ingot"), false);  
			OreRegistry.createOverworldOre("adamantine", new Color("810000"), 128, GameRegistry.findItem("Metallurgy", "adamantine.ingot"), false);  
			OreRegistry.createOverworldOre("atlarus", new Color("9e8d00"), 128, GameRegistry.findItem("Metallurgy", "atlarus.ingot"), false); 
			
			OreRegistry.createNetherOre("ignatius", new Color("d18333"), 128, GameRegistry.findItem("Metallurgy", "ignatius.ingot"), false);   
			OreRegistry.createNetherOre("shadowiron", new Color("383433"), 128, GameRegistry.findItem("Metallurgy", "shadow.iron.ingot"), false);   
			OreRegistry.createNetherOre("lemurite", new Color("a8a8aa"), 128, GameRegistry.findItem("Metallurgy", "lemurite.ingot"), false);  
			OreRegistry.createNetherOre("midasium", new Color("ce7f03"), 128, GameRegistry.findItem("Metallurgy", "midasium.ingot"), false);   
			OreRegistry.createNetherOre("vyroxeres", new Color("158f00"), 128, GameRegistry.findItem("Metallurgy", "vyroxeres.ingot"), false);   
			OreRegistry.createNetherOre("ceruclase", new Color("5e97b0"), 128, GameRegistry.findItem("Metallurgy", "ceruclase.ingot"), false);   
			OreRegistry.createNetherOre("alduorite", new Color("299ba1"), 128, GameRegistry.findItem("Metallurgy", "alduorite.ingot"), false);  
			OreRegistry.createNetherOre("kalendrite", new Color("7c359d"), 128, GameRegistry.findItem("Metallurgy", "kalendrite.ingot"), false);   
			OreRegistry.createNetherOre("vulcanite", new Color("b71500"), 128, GameRegistry.findItem("Metallurgy", "vulcanite.ingot"), false);   
			OreRegistry.createNetherOre("sanguinite", new Color("b71500"), 128, GameRegistry.findItem("Metallurgy", "sanguinite.ingot"), false); 
			
			
			
			OreRegistry.createOverworldOre("zinc", new Color("bfc55c"), 64, GameRegistry.findItem("Metallurgy", "zinc.ingot"), false);
		}
		

	}
	
	public static void addSieveRegistry()
	{
		if(ExAstrisRebirthData.allowMetallurgyOres)
		{
			//Sulfur
			SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 0, 128);
			//phosphorus
			SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 1, 128);
			//saltpeter
			SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 2, 128);
			//magnesium
			SieveRegistry.register(Blocks.gravel, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 3, 128);
			//bitumen
			SieveRegistry.register(Blocks.gravel, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 4, 128);
			//potash
			SieveRegistry.register(Blocks.gravel, 0, GameRegistry.findItem("Metallurgy", "utility.item"), 5, 128);

		}
	}
}
