package kr.loveholy.exastrisrebirth.util;

import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.ENItems;

public class RegistryRecipe {
	public static void removeRecipe()
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		java.util.Iterator<IRecipe> remover = recipes.iterator();
		
		while(remover.hasNext())
		{
			ItemStack items = remover.next().getRecipeOutput();
			if(items != null && (items.getItem() ==  Item.getItemFromBlock(ENBlocks.Barrel) || items.getItem() == Item.getItemFromBlock(ENBlocks.BarrelStone) ))
			{
				remover.remove();
			}
		}
	}
	public static void furnaceRecipe() {
		if (Loader.isModLoaded("TConstruct")
				&& ExAstrisRebirthData.allowAddTConstructNetherOre) {
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreCobalt, new ItemStack(
							GameRegistry.findItem("TConstruct", "materials"),
							1, 3));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreArdite, new ItemStack(
							GameRegistry.findItem("TConstruct", "materials"),
							1, 4));
		}
		if (Loader.isModLoaded("Metallurgy")
				&& ExAstrisRebirthData.allowMetallurgyOres) {
			/*
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreEximite,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"eximite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreMeutoite,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"meutoite.ingot"), 1, 0));

			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOrePrometheum,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"prometheum.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreDeepiron,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"deep.iron.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreInfuscolium,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"infuscolium.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreOureclase,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"oureclase.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreAstralsilver,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"astral.silver.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreCarmot,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"carmot.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreMithril,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"mithril.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreRubracium,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"rubracium.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreOrichalcum,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"orichalcum.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreAdamantine,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"adamantine.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreAtlarus,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"atlarus.ingot"), 1, 0));

			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreIgnatius,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"ignatius.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreShadowiron,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"shadow.iron.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreLemurite,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"lemurite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreMidasium,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"midasium.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreVyroxeres,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"vyroxeres.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreCeruclase,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"ceruclase.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreAlduorite,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"alduorite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreKalendrite,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"kalendrite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreVulcanite,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"vulcanite.ingot"), 1, 0));
			RegistryFactory.FurnaceOreRegistryFactory(
					ExAstrisRebirthBlock.blockOreSanguinite,
					new ItemStack(GameRegistry.findItem("Metallurgy",
							"sanguinite.ingot"), 1, 0));*/
		}
	}

	public static void craftingRecipe() {
		if (Loader.isModLoaded("RedstoneArsenal")) {
			if (ExAstrisRebirthData.allowHammerRF) {

				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
						ExAstrisRebirthItem.itemHammerRF, 1, 0), " x ", " yx", "y  ", 'x',
						"ingotElectrumFlux", 'y', new ItemStack(GameRegistry
								.findItem("RedstoneArsenal", "material"), 1,
								193)));
			}

			if (ExAstrisRebirthData.allowCrookRF) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
						ExAstrisRebirthItem.itemCrookRF, 1, 0), "xxy", " x ", "yx ", 'x',
						new ItemStack(GameRegistry.findItem("RedstoneArsenal",
								"material"), 1, 192), 'y', "gemCrystalFlux"));
			}
		}

		if (Loader.isModLoaded("Thaumcraft") && ExAstrisRebirthData.allowThermalExpansionBlizz
				&& ExAstrisRebirthData.allowThaumiumbarrel) {

			GameRegistry.addRecipe(new ItemStack(ExAstrisRebirthItem.itemDollFreezing, 1,
					0), "aba", "ded", "aca", 'a', Items.snowball, 'b',
					Items.nether_wart, 'c', Items.redstone, 'd',
					Items.glowstone_dust, 'e',
					new ItemStack(ENItems.Doll, 1,
							0));
		}

		if (Loader.isModLoaded("AWWayofTime")) {
			GameRegistry.addRecipe(new ItemStack(
					ExAstrisRebirthItem.itemUnchargedNetherStar, 1, 0), "aaa", "dbd",
					"cef", 'a', Items.skull, 'b', Items.quartz, 'c',
					Items.diamond_axe, 'd', Blocks.soul_sand, 'e',
					Items.diamond_pickaxe, 'f', Items.diamond_sword);
		}

		if (ExAstrisRebirthData.allowEndCake) {
			GameRegistry.addRecipe(new ItemStack(ExAstrisRebirthBlock.blockEndCake, 1, 0),
					"aaa", "bcb", "aaa", 'a', Items.ender_eye, 'b', Items.cake,
					'c', Items.golden_apple);
		}

		if (Loader.isModLoaded("ThermalFoundation") && ExAstrisRebirthData.enableTERecipes) {
			addThermalFoundationRecipes();
		}

		if (Loader.isModLoaded("EnderIO") && ExAstrisRebirthData.enableEIORecipes) {
			addEnderIORecipes();
		}

		if (Loader.isModLoaded("TConstruct")
				&& ExAstrisRebirthData.allowAddTConstructNetherOre) {
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreCobalt,
					ExAstrisRebirthItem.itemOreCobalt);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreArdite,
					ExAstrisRebirthItem.itemOreArdite);
		}
		if (Loader.isModLoaded("RotaryCraft")
				&& ExAstrisRebirthData.allowHardStone) {
			GameRegistry.addRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockHardStone, 1, 0), "aaa", "aaa",
					"aaa", 'a', new ItemStack(Blocks.obsidian, 1, 0));
			GameRegistry.addRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockHardStone, 1, 1), "aaa", "aaa",
					"aaa", 'a', new ItemStack(
							ExAstrisRebirthBlock.blockHardStone, 1, 0));
			GameRegistry.addRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockHardStone, 1, 2), "aaa", "aaa",
					"aaa", 'a', new ItemStack(
							ExAstrisRebirthBlock.blockHardStone, 1, 1));
			GameRegistry.addRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockHardStone, 1, 0), "aaa",
					"aaa", "aaa", 'a', new ItemStack(
							ExAstrisRebirthBlock.blockHardStone, 1, 2));
		}
		if (Loader.isModLoaded("Metallurgy") && ExAstrisRebirthData.allowMetallurgyOres) {
			
			/*OreRecipeFactory(ExAstrisRebirthBlock.blockOreEximite,
					ExAstrisRebirthItem.itemOreEximite);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreMeutoite,
					ExAstrisRebirthItem.itemOreMeutoite);

			OreRecipeFactory(ExAstrisRebirthBlock.blockOrePrometheum,
					ExAstrisRebirthItem.itemOrePrometheum);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreDeepiron,
					ExAstrisRebirthItem.itemOreDeepiron);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreInfuscolium,
					ExAstrisRebirthItem.itemOreInfuscolium);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreOureclase,
					ExAstrisRebirthItem.itemOreOureclase);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreAstralsilver,
					ExAstrisRebirthItem.itemOreAstralsilver);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreCarmot,
					ExAstrisRebirthItem.itemOreCarmot);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreMithril,
					ExAstrisRebirthItem.itemOreMithril);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreRubracium,
					ExAstrisRebirthItem.itemOreRubracium);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreOrichalcum,
					ExAstrisRebirthItem.itemOreOrichalcum);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreAdamantine,
					ExAstrisRebirthItem.itemOreAdamantine);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreAtlarus,
					ExAstrisRebirthItem.itemOreAtlarus);

			OreRecipeFactory(ExAstrisRebirthBlock.blockOreIgnatius,
					ExAstrisRebirthItem.itemOreIgnatius);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreShadowiron,
					ExAstrisRebirthItem.itemOreShadowiron);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreLemurite,
					ExAstrisRebirthItem.itemOreLemurite);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreMidasium,
					ExAstrisRebirthItem.itemOreMidasium);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreVyroxeres,
					ExAstrisRebirthItem.itemOreVyroxeres);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreCeruclase,
					ExAstrisRebirthItem.itemOreCeruclase);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreAlduorite,
					ExAstrisRebirthItem.itemOreAlduorite);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreKalendrite,
					ExAstrisRebirthItem.itemOreKalendrite);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreVulcanite,
					ExAstrisRebirthItem.itemOreVulcanite);
			OreRecipeFactory(ExAstrisRebirthBlock.blockOreSanguinite,
					ExAstrisRebirthItem.itemOreSanguinite);*/
		}

		if (Loader.isModLoaded("Botania")) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthItem.itemHammerMana), " b ", " ab", "a  ", 'a',
					"livingwoodTwig", 'b', "ingotManasteel"));
		}
		
		for(int i = 0; i < 6; i++)
		{
			GameRegistry.addRecipe(new ItemStack(ExAstrisRebirthBlock.blockBarrelTweak, 1, i),
					"x x",
					"x x",
					"xyx",
					'x', new ItemStack(Blocks.planks, 1, i), 
					'y', new ItemStack(Blocks.wooden_slab, 1, i));
		}

		GameRegistry.addRecipe(
				new ShapedOreRecipe(
						new ItemStack(ExAstrisRebirthBlock.blockBarrelStone, 1, 0),
						new Object[]
								{
							"x x",
							"x x",
							"xyx",
							'x', new ItemStack(Blocks.stone, 1, 0),
							'y', new ItemStack(Blocks.stone_slab, 1, 0)
								}));
	}

	public static void OreRecipeFactory(Block block, Item item) {
		GameRegistry.addRecipe(new ItemStack(block, 1, 0), "aa ", "aa ", "   ",
				'a', new ItemStack(item, 1, 0));

		GameRegistry.addRecipe(new ItemStack(block, 1, 1), "aa ", "aa ", "   ",
				'a', new ItemStack(item, 1, 1));

		GameRegistry.addRecipe(new ItemStack(block, 1, 2), "aa ", "aa ", "   ",
				'a', new ItemStack(item, 1, 2));
	}

	public static void addThermalFoundationRecipes() {
		if (ExAstrisRebirthData.allowSieveAutomatic) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockSieveAutomatic, 1, 0), "aba", "aca", "d d",
					'a', "ingotInvar", 'b', new ItemStack(GameRegistry
							.findItem("exnihilo", "mesh"), 1, 0), 'c',
					"gearElectrum", 'd', "nuggetInvar"));
		}
		if (ExAstrisRebirthData.allowUpgrades) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthItem.itemSieveUpgrade, 2, 0), "aba", "bcb", "aba",
					'a', "nuggetElectrum", 'b', "ingotInvar", 'c',
					"dustPyrotheum"));

			GameRegistry
					.addRecipe(new ShapedOreRecipe(new ItemStack(
							ExAstrisRebirthItem.itemSieveUpgrade, 2, 1), "aba", "bcb",
							"aba", 'a', "nuggetElectrum", 'b', "ingotInvar",
							'c', "gemDiamond"));

		}

		if (ExAstrisRebirthData.allowHammerAutomatic) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockHammerAutomatic, 1, 0), "ada", "aba", "aca",
					'a', "ingotInvar", 'd', Blocks.piston, 'c', Blocks.anvil,
					'b', Blocks.heavy_weighted_pressure_plate));
		}
	}

	public static void addEnderIORecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				ExAstrisRebirthItem.itemNuggetElectricalSteel, 9, 0), "a", 'a',
				"ingotElectricalSteel"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(GameRegistry
				.findItem("EnderIO", "itemAlloy"), 1, 0), "aaa", "aaa", "aaa",
				'a', "nuggetElectricalSteel"));

		if (ExAstrisRebirthData.allowSieveAutomatic) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockSieveAutomatic, 1, 0), "aba", "aca", "d d",
					'a', "ingotElectricalSteel", 'b', new ItemStack(
							GameRegistry.findItem("exnihilo", "mesh"), 1, 0),
					'c', new ItemStack(GameRegistry.findItem("EnderIO",
							"itemMachinePart"), 1, 0), 'd',
					"nuggetElectricalSteel"));
		}

		if (ExAstrisRebirthData.allowUpgrades) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthItem.itemSieveUpgrade, 2, 0), "aba", "bcb", "aba",
					'a', "nuggetVibrantAlloy", 'b', "ingotRedstoneAlloy", 'c',
					new ItemStack(GameRegistry.findItem("EnderIO",
							"itemMaterial"), 1, 7)));

			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthItem.itemSieveUpgrade, 2, 1), "aba", "bcb", "aba",
					'a', "nuggetVibrantAlloy", 'b', "ingotRedstoneAlloy", 'c',
					"gemDiamond"));

		}

		if (ExAstrisRebirthData.allowHammerAutomatic) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
					ExAstrisRebirthBlock.blockHammerAutomatic, 1, 0), "ada", "aba", "aca",
					'a', "ingotDarkSteel", 'd', Blocks.piston, 'c',
					Blocks.anvil, 'b', Blocks.heavy_weighted_pressure_plate));
		}

	}
}
