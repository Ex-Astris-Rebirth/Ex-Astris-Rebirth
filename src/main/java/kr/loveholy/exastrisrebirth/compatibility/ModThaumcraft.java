package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import kr.loveholy.exastrisrebirth.block.BlockBarrelThaumium;
import kr.loveholy.exastrisrebirth.item.ItemEldritchPortalSpawner;
import kr.loveholy.exastrisrebirth.item.ItemHammerThaumium;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.IArcaneRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;
import thaumcraft.common.config.ConfigBlocks;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.config.ConfigResearch;
import thaumcraft.common.entities.monster.EntityCultistCleric;
import thaumcraft.common.entities.monster.EntityPech;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.Fluids;
import exnihilo.registries.BarrelRecipeRegistry;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.HeatRegistry;
import exnihilo.registries.SieveRegistry;

public class ModThaumcraft {
	public static final String CATEGORY_NAME = "ExAstrisRebirth";
	public static final String PAGE_NAME = CATEGORY_NAME + ".page.";
	private static boolean isWitchingGadgetsLoaded = false;

	public static void init() {
		addHammerRegistry();
		addSieveRegistry();
		if (ExAstrisRebirthData.allowThaumcraftHeat) {
			addHeatRegistry();
		}
		addPages();
		addInfusion();
		addArcane();
		addCrucible();
		if (ExAstrisRebirthData.allowThaumcraftResearch) {
			addResearch();
		}
		addBarrelRegistry();
	}
	
	public static void witchingGadgetsLoaded() {
		isWitchingGadgetsLoaded = true;
	}
	
	public static Item itemHammerThaumium()
	{
		return new ItemHammerThaumium();
	}
	
	public static Item itemEldritchPortalSpawner()
	{
		return new ItemEldritchPortalSpawner();
	}
	
	public static Block blockBarrelThaumium()
	{
		return new BlockBarrelThaumium();
	}
	public static void addHammerRegistry() {
		HammerRegistry.register(Blocks.double_stone_slab, 1,
				GameRegistry.findItem("Thaumcraft", "ItemShard"), 0, 1.00f,
				0.0f);
		HammerRegistry.register(Blocks.nether_brick, 0,
				GameRegistry.findItem("Thaumcraft", "ItemShard"), 1, 1.00f,
				0.0f);
		HammerRegistry.register(Blocks.grass, 0,
				GameRegistry.findItem("Thaumcraft", "ItemShard"), 3, 1.00f,
				0.0f);
		HammerRegistry.register(Blocks.ice, 0,
				GameRegistry.findItem("Thaumcraft", "ItemShard"), 2, 1.00f,
				0.0f);
		HammerRegistry.register(Blocks.tnt, 0,
				GameRegistry.findItem("Thaumcraft", "ItemShard"), 5, 1.00f,
				0.0f);
		HammerRegistry.register(Blocks.double_stone_slab, 0,
				GameRegistry.findItem("Thaumcraft", "ItemShard"), 4, 1.00f,
				0.0f);
	}

	public static void addSieveRegistry() {
		SieveRegistry.register(Blocks.sand, 0,
				GameRegistry.findItem("Thaumcraft", "ItemNugget"), 5,
				ExAstrisRebirthData.oreQuicksilverChance);
		SieveRegistry.register(Blocks.sand, 0,
				GameRegistry.findItem("Thaumcraft", "ItemResource"), 6,
				ExAstrisRebirthData.oreAmberChance);
		if (isWitchingGadgetsLoaded) {
			Item powerlessPearlBase = GameRegistry.findItem("WitchingGadgets", "item.WG_Material");
			SieveRegistry.register(ConfigBlocks.blockCosmeticSolid, 11,
					powerlessPearlBase, 12,
					ExAstrisRebirthData.primordialPearlChance);
		} else {
			SieveRegistry.register(ConfigBlocks.blockCosmeticSolid, 11,
					GameRegistry.findItem("Thaumcraft", "ItemEldritchObject"), 3,
					ExAstrisRebirthData.primordialPearlChance);
		}
	}

	public static void addHeatRegistry() {
		HeatRegistry.register(
				GameRegistry.findBlock("Thaumcraft", "blockAiry"), 1, 0.15F);
		for (int i = 0; i <= 15; i++) {
			HeatRegistry.register(
					GameRegistry.findBlock("Thaumcraft", "blockCandle"), i,
					0.1F);
		}

	}

	public static void addResearch() {
		new ResearchItem(CATEGORY_NAME + "_SHARD", CATEGORY_NAME,
				new AspectList(), 0, 0, 0, new ItemStack(GameRegistry.findItem(
						"Thaumcraft", "ItemShard"), 1, 0))
				.setPages(
						new ResearchPage[] { new ResearchPage(PAGE_NAME + "1"),
								new ResearchPage(PAGE_NAME + "2") }).setStub()
				.setRound().setAutoUnlock().registerResearchItem();

		if (ExAstrisRebirthData.allowThaumiumbarrel) {
			new ResearchItem(CATEGORY_NAME + "_BARRELTHAUMIUM", CATEGORY_NAME,
					new AspectList().add(Aspect.TOOL, 10).add(Aspect.WATER, 10)
							.add(Aspect.MAGIC, 10).add(Aspect.CRAFT, 10), 0,
					-2, 0, new ItemStack(
							ExAstrisRebirthBlock.blockBarrelThaumium, 1, 0))
					.setPages(
							new ResearchPage[] {
									new ResearchPage(PAGE_NAME + "3"),
									new ResearchPage(
											(IArcaneRecipe) ConfigResearch.recipes
													.get(CATEGORY_NAME
															+ "_BARRELTHAUMIUM")) })
					.setConcealed().registerResearchItem();
			if (ExAstrisRebirthData.allowDollThaumic) {
				new ResearchItem(CATEGORY_NAME + "_DOLLTHAUMIC", CATEGORY_NAME,
						new AspectList().add(Aspect.SOUL, 10)
								.add(Aspect.GREED, 10).add(Aspect.MAGIC, 10),
						2, -2, 0, new ItemStack(
								ExAstrisRebirthItem.itemDollThaumic, 1, 0))
						.setPages(
								new ResearchPage[] {
										new ResearchPage(PAGE_NAME + "4"),
										new ResearchPage(
												(CrucibleRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_DOLLTHAUMIC")) })
						.setConcealed()
						.setParents(CATEGORY_NAME + "_BARRELTHAUMIUM")
						.registerResearchItem();

			}
			if (ExAstrisRebirthData.allowDollCrimson) {
				new ResearchItem(CATEGORY_NAME + "_DOLLCRIMSON", CATEGORY_NAME,
						new AspectList().add(Aspect.SOUL, 10)
								.add(Aspect.ELDRITCH, 10).add(Aspect.MAGIC, 10),
						2, -1, 1, new ItemStack(
								ExAstrisRebirthItem.itemDollCrimson, 1, 0))
						.setPages(
								new ResearchPage[]{
										new ResearchPage(PAGE_NAME + "16"),
										new ResearchPage(
												(CrucibleRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_DOLLCRIMSON"))})
						.setParents(CATEGORY_NAME + "_BARRELTHAUMIUM")
						.setParentsHidden("ELDRITCHMAJOR")
						.setSecondary()
						.registerResearchItem();
				ThaumcraftApi.addWarpToResearch(CATEGORY_NAME + "_DOLLCRIMSON", 4);
			}

			if (Loader.isModLoaded("MagicBees")
					&& ExAstrisRebirthData.allowBeeTrapInfused) {
				new ResearchItem(CATEGORY_NAME + "_BEEHIVES", CATEGORY_NAME,
						new AspectList().add(Aspect.MAGIC, 10)
								.add(Aspect.AIR, 10).add(Aspect.BEAST, 10)
								.add(Aspect.CRAFT, 10), 0, -4, 0,
						new ItemStack(ExAstrisRebirthBlock.blockBeeTrapInfused,
								1, 0))
						.setPages(
								new ResearchPage[] {
										new ResearchPage(PAGE_NAME + "13"),
										new ResearchPage(
												(IArcaneRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_CURIOUSHIVE")),
										new ResearchPage(
												(IArcaneRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_UNUSUALHIVE")),
										new ResearchPage(
												(IArcaneRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_RESONATINGHIVE")) })
						.setConcealed()
						.setParents(CATEGORY_NAME + "_BARRELTHAUMIUM")
						.registerResearchItem();
				new ResearchItem(CATEGORY_NAME + "_ADVANCEBEEHIVES",
						CATEGORY_NAME, new AspectList().add(Aspect.MAGIC, 10)
								.add(Aspect.AIR, 10).add(Aspect.BEAST, 10)
								.add(Aspect.CRAFT, 10), -2, -4, 0,
						new ItemStack(ExAstrisRebirthBlock.blockBeeTrapInfused,
								1, 0))
						.setPages(
								new ResearchPage[] {
										new ResearchPage(PAGE_NAME + "14"),
										new ResearchPage(
												(InfusionRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_DEEPHIVE")),
										new ResearchPage(
												(InfusionRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_INFERNALHIVE")),
										new ResearchPage(
												(InfusionRecipe) ConfigResearch.recipes
														.get(CATEGORY_NAME
																+ "_OBLIVIONHIVE")) })
						.setConcealed().setSpecial()
						.setParents(CATEGORY_NAME + "_BEEHIVES")
						.registerResearchItem();

				ThaumcraftApi.addWarpToResearch(CATEGORY_NAME+ "_ADVANCEBEEHIVES", 2);
			}
		}

		new ResearchItem(CATEGORY_NAME + "_VISFILTER", CATEGORY_NAME,
				new AspectList().add(Aspect.WATER, 10).add(Aspect.ORDER, 10),
				-2, 0, 0, new ItemStack(GameRegistry.findItem("Thaumcraft",
						"ItemResource"), 1, 8))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "5"),
								new ResearchPage(
										(IArcaneRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME
														+ "_VISFILTER")) })
				.setConcealed().registerResearchItem();
		new ResearchItem(CATEGORY_NAME + "_MATRIX", CATEGORY_NAME,
				new AspectList().add(Aspect.WATER, 10).add(Aspect.FIRE, 10)
						.add(Aspect.EARTH, 10).add(Aspect.AIR, 10), -2, -2, 0,
				new ItemStack(GameRegistry.findItem("Thaumcraft",
						"blockStoneDevice"), 1, 2))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "6"),
								new ResearchPage(
										(IArcaneRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME + "_MATRIX")) })
				.setConcealed().setParents(CATEGORY_NAME + "_VISFILTER")
				.registerResearchItem();
		if (ExAstrisRebirthData.allowHammerThaumium) {
			new ResearchItem(
					CATEGORY_NAME + "_HAMMERTHAUMIUM",
					CATEGORY_NAME,
					new AspectList().add(Aspect.TOOL, 10).add(Aspect.MAGIC, 10),
					0, 2, 0, new ItemStack(
							ExAstrisRebirthItem.itemHammerThaumium, 1, 0))
					.setPages(
							new ResearchPage[] {
									new ResearchPage(PAGE_NAME + "7"),
									new ResearchPage(
											(IArcaneRecipe) ConfigResearch.recipes
													.get(CATEGORY_NAME
															+ "_HAMMERTHAUMIUM")) })
					.setConcealed().registerResearchItem();

		}
		new ResearchItem(CATEGORY_NAME + "_SHIMMERLEAF", CATEGORY_NAME,
				new AspectList().add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10)
						.add(Aspect.EXCHANGE, 10), 4, 0, 0,
				new ItemStack(GameRegistry.findItem("Thaumcraft",
						"blockCustomPlant"), 1, 2))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "8"),
								new ResearchPage(
										(CrucibleRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME
														+ "_SHIMMERLEAF")) })
				.setConcealed().registerResearchItem();
		new ResearchItem(CATEGORY_NAME + "_CINDERPEARL", CATEGORY_NAME,
				new AspectList().add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10)
						.add(Aspect.FIRE, 10), 4, -2, 0,
				new ItemStack(GameRegistry.findItem("Thaumcraft",
						"blockCustomPlant"), 1, 3))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "9"),
								new ResearchPage(
										(CrucibleRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME
														+ "_CINDERPEARL")) })
				.setConcealed().registerResearchItem();

		new ResearchItem(CATEGORY_NAME + "_VISHROOM", CATEGORY_NAME,
				new AspectList().add(Aspect.PLANT, 10).add(Aspect.MAGIC, 10)
						.add(Aspect.FIRE, 10), 4, 2, 0,
				new ItemStack(GameRegistry.findItem("Thaumcraft",
						"blockCustomPlant"), 1, 5))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "10"),
								new ResearchPage(
										(CrucibleRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME
														+ "_VISHROOM")) })
				.setConcealed().registerResearchItem();

		new ResearchItem(CATEGORY_NAME + "_GREATWOOD", CATEGORY_NAME,
				new AspectList().add(Aspect.TREE, 10).add(Aspect.PLANT, 10)
						.add(Aspect.MAGIC, 10).add(Aspect.PLANT, 10), 0, 4, 0,
				new ItemStack(GameRegistry.findItem("Thaumcraft",
						"blockCustomPlant"), 1, 0))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "11"),
								new ResearchPage(
										(InfusionRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME
														+ "_GREATWOOD")) })
				.setConcealed().registerResearchItem();
		new ResearchItem(CATEGORY_NAME + "_SILVERWOOD", CATEGORY_NAME,
				new AspectList().add(Aspect.MAGIC, 20).add(Aspect.TREE, 20)
						.add(Aspect.ORDER, 20).add(Aspect.VOID, 20), 2, 4, 0,
				new ItemStack(GameRegistry.findItem("Thaumcraft",
						"blockCustomPlant"), 1, 1))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "12"),
								new ResearchPage(
										(InfusionRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME
														+ "_SILVERWOOD")) })
				.setConcealed().setSpecial()
				.setParents(CATEGORY_NAME + "_GREATWOOD")
				.registerResearchItem();
		new ResearchItem(CATEGORY_NAME + "_PORTAL", CATEGORY_NAME,
				new AspectList().add(Aspect.MAGIC, 20).add(Aspect.VOID, 20)
						.add(Aspect.AURA, 20).add(Aspect.TOOL, 20), 4, 4, 1,
				new ItemStack(ExAstrisRebirthItem.itemEldritchPortalSpawner))
				.setPages(
						new ResearchPage[] {
								new ResearchPage(PAGE_NAME + "15"),
								new ResearchPage(
										(InfusionRecipe) ConfigResearch.recipes
												.get(CATEGORY_NAME + "_PORTAL")) })
				.setConcealed().setSpecial().setParents("VOIDMETAL")
				.registerResearchItem();

	}

	public static void addPages() {
		ResearchCategories.registerCategory(CATEGORY_NAME,
				new ResourceLocation(ExAstrisRebirthData.MODID,
						"textures/misc/thaumicpage.png"), new ResourceLocation(
						"thaumcraft", "textures/gui/gui_researchback.png"));
	}

	public static void addInfusion() {
		ConfigResearch.recipes
				.put(CATEGORY_NAME + "_GREATWOOD",
						ThaumcraftApi.addInfusionCraftingRecipe(
								CATEGORY_NAME + "_GREATWOOD",
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "blockCustomPlant"), 1, 0),
								10,
								new AspectList().add(Aspect.TREE, 128)
										.add(Aspect.AIR, 64)
										.add(Aspect.EARTH, 64)
										.add(Aspect.FIRE, 64)
										.add(Aspect.WATER, 64)
										.add(Aspect.ORDER, 64)
										.add(Aspect.ENTROPY, 64),
								new ItemStack(Blocks.sapling, 1, 3),
								new ItemStack[] {
										new ItemStack(GameRegistry
												.findItem("exnihilo",
														"bucket_witchwater"),
												1, 0),
										new ItemStack(GameRegistry
												.findItem("exnihilo",
														"bucket_witchwater"),
												1, 0),
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft",
												"blockCustomPlant"), 1, 3),
										new ItemStack(GameRegistry
												.findItem("exnihilo",
														"bucket_witchwater"),
												1, 0),
										new ItemStack(GameRegistry
												.findItem("exnihilo",
														"bucket_witchwater"),
												1, 0),
										new ItemStack(GameRegistry
												.findItem("exnihilo",
														"bucket_witchwater"),
												1, 0),
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft",
												"blockCustomPlant"), 1, 2),
										new ItemStack(GameRegistry
												.findItem("exnihilo",
														"bucket_witchwater"),
												1, 0) }));

		ConfigResearch.recipes
				.put(CATEGORY_NAME + "_SILVERWOOD",
						ThaumcraftApi.addInfusionCraftingRecipe(
								CATEGORY_NAME + "_SILVERWOOD",
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "blockCustomPlant"), 1, 1),
								12,
								new AspectList().add(Aspect.EXCHANGE, 64)
										.add(Aspect.MAGIC, 64)
										.add(Aspect.CRYSTAL, 64)
										.add(Aspect.TREE, 128),
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "blockCustomPlant"), 1, 0),
								new ItemStack[] {
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft", "ItemResource"),
												1, 14),
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft",
												"blockCustomPlant"), 1, 4),
										new ItemStack(Blocks.diamond_block, 1,
												0),
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft",
												"blockCustomPlant"), 1, 4),
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft", "ItemResource"),
												1, 14),
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft",
												"blockCustomPlant"), 1, 4),
										new ItemStack(Blocks.diamond_block, 1,
												0),
										new ItemStack(GameRegistry.findItem(
												"Thaumcraft",
												"blockCustomPlant"), 1, 4) }));
		if (Loader.isModLoaded("MagicBees")) {
			ConfigResearch.recipes
					.put(CATEGORY_NAME + "_DEEPHIVE",
							ThaumcraftApi
									.addInfusionCraftingRecipe(
											CATEGORY_NAME + "_ADVANCEBEEHIVES",
											new ItemStack(GameRegistry
													.findItem("MagicBees",
															"hive"), 1, 3),
											12,
											new AspectList()
													.add(Aspect.MAGIC, 64)
													.add(Aspect.BEAST, 64)
													.add(Aspect.VOID, 32),
											new ItemStack(
													ExAstrisRebirthBlock.blockBeeTrapInfused,
													1, 0), new ItemStack[] {
													new ItemStack(Blocks.stone,
															1, 0),
													new ItemStack(Blocks.stone,
															1, 0),
													new ItemStack(Blocks.stone,
															1, 0),
													new ItemStack(Blocks.stone,
															1, 0),
													new ItemStack(Blocks.stone,
															1, 0),
													new ItemStack(Blocks.stone,
															1, 0),
													new ItemStack(Blocks.stone,
															1, 0),
													new ItemStack(Blocks.stone,
															1, 0) }));

			ConfigResearch.recipes
					.put(CATEGORY_NAME + "_INFERNALHIVE",
							ThaumcraftApi
									.addInfusionCraftingRecipe(
											CATEGORY_NAME + "_ADVANCEBEEHIVES",
											new ItemStack(GameRegistry
													.findItem("MagicBees",
															"hive"), 1, 4),
											12,
											new AspectList()
													.add(Aspect.MAGIC, 64)
													.add(Aspect.BEAST, 64)
													.add(Aspect.FIRE, 32),
											new ItemStack(
													ExAstrisRebirthBlock.blockBeeTrapInfused,
													1, 0),
											new ItemStack[] {
													new ItemStack(
															Blocks.nether_brick,
															1, 0),
													new ItemStack(
															Blocks.nether_brick,
															1, 0),
													new ItemStack(
															Blocks.nether_brick,
															1, 0),
													new ItemStack(
															Blocks.nether_brick,
															1, 0),
													new ItemStack(
															Blocks.nether_brick,
															1, 0),
													new ItemStack(
															Blocks.nether_brick,
															1, 0),
													new ItemStack(
															Blocks.nether_brick,
															1, 0),
													new ItemStack(
															Blocks.nether_brick,
															1, 0) }));

			ConfigResearch.recipes.put(CATEGORY_NAME + "_OBLIVIONHIVE",
					ThaumcraftApi.addInfusionCraftingRecipe(
							CATEGORY_NAME + "_ADVANCEBEEHIVES",
							new ItemStack(GameRegistry.findItem("MagicBees",
									"hive"), 1, 5),
							12,
							new AspectList().add(Aspect.MAGIC, 64)
									.add(Aspect.BEAST, 64)
									.add(Aspect.ELDRITCH, 32), new ItemStack(
									ExAstrisRebirthBlock.blockBeeTrapInfused,
									1, 0), new ItemStack[] {
									new ItemStack(Blocks.end_stone, 1, 0),
									new ItemStack(Blocks.end_stone, 1, 0),
									new ItemStack(Blocks.end_stone, 1, 0),
									new ItemStack(Blocks.end_stone, 1, 0),
									new ItemStack(Blocks.end_stone, 1, 0),
									new ItemStack(Blocks.end_stone, 1, 0),
									new ItemStack(Blocks.end_stone, 1, 0),
									new ItemStack(Blocks.end_stone, 1, 0) }));
			
		}
		
		ConfigResearch.recipes
		.put(CATEGORY_NAME + "_PORTAL",
				ThaumcraftApi
						.addInfusionCraftingRecipe(
								CATEGORY_NAME + "_PORTAL",
								new ItemStack(
										ExAstrisRebirthItem.itemEldritchPortalSpawner),
								25,
								new AspectList()
										.add(Aspect.MAGIC, 64)
										.add(Aspect.VOID, 64)
										.add(Aspect.TRAVEL, 64)
										.add(Aspect.ELDRITCH, 32),
								new ItemStack(GameRegistry
										.findItem("Thaumcraft",
												"ItemResource"), 1,
										10),
								new ItemStack[] {
										new ItemStack(
												GameRegistry
														.findItem(
																"Thaumcraft",
																"ItemResource"),
												1, 16),
										new ItemStack(
												GameRegistry
														.findItem(
																"Thaumcraft",
																"ItemEldritchObject")),
										new ItemStack(
												GameRegistry
														.findItem(
																"Thaumcraft",
																"ItemEldritchObject")),
										new ItemStack(
												GameRegistry
														.findItem(
																"Thaumcraft",
																"ItemResource"),
												1, 16),
										new ItemStack(
												GameRegistry
														.findItem(
																"Thaumcraft",
																"ItemEldritchObject")),
										new ItemStack(
												GameRegistry
														.findItem(
																"Thaumcraft",
																"ItemEldritchObject"))

								}));

	}

	public static void addArcane() {
		ConfigResearch.recipes.put(CATEGORY_NAME + "_BARRELTHAUMIUM",
				ThaumcraftApi.addArcaneCraftingRecipe(
						CATEGORY_NAME + "_BARRELTHAUMIUM",
						new ItemStack(ExAstrisRebirthBlock.blockBarrelThaumium,
								1, 0),
						new AspectList().add(Aspect.FIRE, 5).add(Aspect.WATER,
								5),
						new Object[] {
								"a a",
								"a a",
								"aba",
								'a',
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "ItemResource"), 1, 2),
								'b',
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "ItemNugget"), 1, 6) }));
		// ConfigResearch.recipes.put("exastrisdollthaumic",
		// ThaumcraftApi.addArcaneCraftingRecipe("EXASTRIS_DOLLTHAUMIC", new
		// ItemStack(ExAstrisItem.DollThaumic, 1, 0), new
		// AspectList().add(Aspect.EARTH, 10).add(Aspect.FIRE, 10), new Object[]
		// { "aba", "cdc", "aea", 'a', new
		// ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,4),
		// 'b', new ItemStack(GameRegistry.findItem("Thaumcraft",
		// "ItemResource"),1,6), 'c', new
		// ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,14),
		// 'd', new ItemStack(ENItems.Doll,1,0), 'e', new
		// ItemStack(GameRegistry.findItem("Thaumcraft", "ItemResource"),1,3)
		// }));
		ConfigResearch.recipes.put(CATEGORY_NAME + "_VISFILTER", ThaumcraftApi
				.addArcaneCraftingRecipe(
						CATEGORY_NAME + "_VISFILTER",
						new ItemStack(GameRegistry.findItem("Thaumcraft",
								"ItemResource"), 1, 8),
						new AspectList().add(Aspect.ORDER, 5).add(Aspect.WATER,
								5), new Object[] { "mmm", "imi", "mmm", 'i',
								Items.gold_ingot, 'm',
								new ItemStack(ENItems.Mesh, 1, 0) }));
		ConfigResearch.recipes.put(CATEGORY_NAME + "_MATRIX", ThaumcraftApi
				.addArcaneCraftingRecipe(
						CATEGORY_NAME + "_MATRIX",
						new ItemStack(GameRegistry.findItem("Thaumcraft",
								"blockStoneDevice"), 1, 2),
						new AspectList().add(Aspect.AIR, 1)
								.add(Aspect.EARTH, 1).add(Aspect.FIRE, 1)
								.add(Aspect.WATER, 1).add(Aspect.ORDER, 1)
								.add(Aspect.ENTROPY, 1),
						new Object[] {
								"bcb",
								"cec",
								"bcb",
								'b',
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "blockCosmeticSolid"), 1,
										6),
								'c',
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "blockCrystal"), 1, 6),
								'e', Items.ender_pearl }));
		ConfigResearch.recipes.put(CATEGORY_NAME + "_HAMMERTHAUMIUM",
				ThaumcraftApi.addArcaneCraftingRecipe(
						CATEGORY_NAME + "_HAMMERTHAUMIUM",
						new ItemStack(ExAstrisRebirthItem.itemHammerThaumium,
								1, 0),
						new AspectList().add(Aspect.AIR, 2)
								.add(Aspect.EARTH, 2).add(Aspect.FIRE, 2)
								.add(Aspect.WATER, 2).add(Aspect.ORDER, 2)
								.add(Aspect.ENTROPY, 2),
						new Object[] {
								" a ",
								" ba",
								"b  ",
								'a',
								new ItemStack(GameRegistry.findItem(
										"Thaumcraft", "ItemResource"), 1, 2),
								'b', Items.stick }));
		if (Loader.isModLoaded("MagicBees")) {
			ConfigResearch.recipes
					.put(CATEGORY_NAME + "_CURIOUSHIVE",
							ThaumcraftApi.addArcaneCraftingRecipe(
									CATEGORY_NAME + "_BEEHIVES",
									new ItemStack(GameRegistry.findItem(
											"MagicBees", "hive"), 1, 0),
									new AspectList().add(Aspect.AIR, 4)
											.add(Aspect.EARTH, 4)
											.add(Aspect.FIRE, 4)
											.add(Aspect.WATER, 4),
									new Object[] {
											" a ",
											"aba",
											" a ",
											'a',
											new ItemStack(GameRegistry
													.findItem("Thaumcraft",
															"ItemResource"), 1,
													4),
											'b',
											new ItemStack(
													ExAstrisRebirthBlock.blockBeeTrapInfused,
													1, 0) }));
			ConfigResearch.recipes
					.put(CATEGORY_NAME + "_UNUSUALHIVE",
							ThaumcraftApi.addArcaneCraftingRecipe(
									CATEGORY_NAME + "_BEEHIVES",
									new ItemStack(GameRegistry.findItem(
											"MagicBees", "hive"), 1, 1),
									new AspectList().add(Aspect.AIR, 4)
											.add(Aspect.EARTH, 4)
											.add(Aspect.FIRE, 4)
											.add(Aspect.WATER, 4),
									new Object[] {
											" a ",
											"aba",
											" a ",
											'a',
											new ItemStack(GameRegistry
													.findItem("Thaumcraft",
															"ItemResource"), 1,
													3),
											'b',
											new ItemStack(
													ExAstrisRebirthBlock.blockBeeTrapInfused,
													1, 0) }));
			ConfigResearch.recipes
					.put(CATEGORY_NAME + "_RESONATINGHIVE",
							ThaumcraftApi.addArcaneCraftingRecipe(
									CATEGORY_NAME + "_BEEHIVES",
									new ItemStack(GameRegistry.findItem(
											"MagicBees", "hive"), 1, 2),
									new AspectList().add(Aspect.AIR, 4)
											.add(Aspect.EARTH, 4)
											.add(Aspect.FIRE, 4)
											.add(Aspect.WATER, 4),
									new Object[] {
											" a ",
											"aba",
											" a ",
											'a',
											new ItemStack(GameRegistry
													.findItem("Thaumcraft",
															"ItemResource"), 1,
													6),
											'b',
											new ItemStack(
													ExAstrisRebirthBlock.blockBeeTrapInfused,
													1, 0) }));
		}
	}

	public static void addCrucible() {
		ConfigResearch.recipes.put(CATEGORY_NAME + "_DOLLTHAUMIC",
				ThaumcraftApi
						.addCrucibleRecipe(
								CATEGORY_NAME + "_DOLLTHAUMIC",
								new ItemStack(
										ExAstrisRebirthItem.itemDollThaumic, 1,
										0),
								new ItemStack(ENItems.Doll, 1, 0),
								new AspectList().add(Aspect.MAGIC, 8)
										.add(Aspect.SOUL, 8)
										.add(Aspect.GREED, 8)));
		ConfigResearch.recipes.put(CATEGORY_NAME + "_DOLLCRIMSON",
				ThaumcraftApi
						.addCrucibleRecipe(
								CATEGORY_NAME + "_DOLLCRIMSON",
								new ItemStack(
										ExAstrisRebirthItem.itemDollCrimson, 1,
										0),
								new ItemStack(ENItems.Doll, 1, 0),
								new AspectList().add(Aspect.MAGIC, 8)
										.add(Aspect.SOUL, 8)
										.add(Aspect.ELDRITCH, 8)));
		ConfigResearch.recipes.put(CATEGORY_NAME + "_SHIMMERLEAF",
				ThaumcraftApi.addCrucibleRecipe(
						CATEGORY_NAME + "_SHIMMERLEAF",
						new ItemStack(GameRegistry.findItem("Thaumcraft",
								"blockCustomPlant"), 1, 2),
						new ItemStack(Blocks.red_flower, 1, 0),
						new AspectList().add(Aspect.MAGIC, 4)
								.add(Aspect.EXCHANGE, 4).add(Aspect.PLANT, 4)));
		ConfigResearch.recipes.put(CATEGORY_NAME + "_CINDERPEARL",
				ThaumcraftApi.addCrucibleRecipe(
						CATEGORY_NAME + "_CINDERPEARL",
						new ItemStack(GameRegistry.findItem("Thaumcraft",
								"blockCustomPlant"), 1, 3),
						new ItemStack(Blocks.yellow_flower, 1, 0),
						new AspectList().add(Aspect.MAGIC, 4)
								.add(Aspect.PLANT, 4).add(Aspect.FIRE, 4)));
		ConfigResearch.recipes.put(CATEGORY_NAME + "_VISHROOM", ThaumcraftApi
				.addCrucibleRecipe(
						CATEGORY_NAME + "_VISHROOM",
						new ItemStack(GameRegistry.findItem("Thaumcraft",
								"blockCustomPlant"), 1, 5),
						new ItemStack(Blocks.brown_mushroom, 1, 0),
						new AspectList().add(Aspect.MAGIC, 4)
								.add(Aspect.PLANT, 4).add(Aspect.POISON, 4)));
	}

	public static void addBarrelRegistry() {
		BarrelRecipeRegistry.addMobRecipe(Fluids.fluidWitchWater,
				new ItemStack(ExAstrisRebirthItem.itemDollThaumic),
				EntityPech.class, "portal", new ItemStack(
						ExAstrisRebirthItem.itemDollThaumic));
		BarrelRecipeRegistry.addMobRecipe(Fluids.fluidWitchWater,
				new ItemStack(ExAstrisRebirthItem.itemDollCrimson),
				EntityCultistCleric.class, "portal", new ItemStack(
						ConfigItems.itemEldritchObject, 1, 1));
		BarrelRecipeRegistry.addFluidItemRecipe(
				Fluids.fluidWitchWater,
				new ItemStack(Blocks.obsidian),
				new ItemStack(GameRegistry.findItem("Thaumcraft",
						"blockCosmeticSolid"), 1, 0));
		BarrelRecipeRegistry.addFluidItemRecipe(Fluids.fluidWitchWater,
				new ItemStack(ENBlocks.BeeTrapTreated), new ItemStack(
						ExAstrisRebirthBlock.blockBeeTrapInfused, 1, 0));
	}
}
