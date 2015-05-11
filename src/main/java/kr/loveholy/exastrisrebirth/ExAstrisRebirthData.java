package kr.loveholy.exastrisrebirth;

import net.minecraftforge.common.config.Configuration;

public class ExAstrisRebirthData {
	public static final String MODID = "exastrisrebirth";
	public static final String MODNAME = "Ex Astris Rebirth";
	public static final String VERSION = "@VERSION@";
	public static final String DEPENDENCIES = "required-after:Forge@[10.13.0.1180,);required-after:exnihilo;after:ThermalExpansion;after:Thaumcraft;after:TConstruct;after:TSteelworks;after:RedstoneArsenal;after:RotaryCraft;after:Metallurgy;after:ThermalFoundation;after:EnderIO;after:chisel;after:CoFHAPI|energy";
    
	public static final String UNCHARGED_NETHER_STAR = "itemUnchargedNetherStar";
	public static final String BEE_TRAP_INFUSED = "blockBeeTrapInfused";
	public static final String END_CAKE = "blockEndCake";
	public static final String BARREL_THAUMIUM = "blockBarrelThaumium";
	public static final String BARREL_TWEAK = "blockBarrelTweak";
	public static final String BARREL_STONE = "blockBarrelStone";
	public static final String CHISEL_STONE = "itemChiselStone";
	public static final String NUGGET_ELECTRICAL_STEEL = "itemNuggetElectricalSteel";
	public static final String[] CHISEL_STONE_NAME = {"itemChiselStoneMarble", "itemChiselStoneLimestone"};
	public static final String[] BARREL_TWEAK_NAME = {
		"blockBarrelOak",
		"blockBarrelSpruce",
		"blockBarrelBirch",
		"blockBarrelJungle",
		"blockBarrelAcacia",
		"blockBarrelDarkOak"
		}; 
	public static final String HAMMER_AUTOMATIC = "blockHammerAutomatic";
	public static final String HARD_STONE = "blockHardStone";
	public static final String[] HARD_STONE_NAME = {
		"blockHardStone",
		"blockDoubleHardStone",
		"blockTripleHardStone",
		"blockQuadrupleHardStone"
		};
	public static final String SIEVE_AUTOMATIC = "blockSieveAutomatic";
	public static final String HAMMER_RF = "itemHammerRF";
	public static final String CROOK_RF = "itemCrookRF";
	public static final String ELDRITCH_PORTAL_SPAWNER = "itemEldritchPortalSpawner";
	public static final String SIEVE_UPGRADE = "itemSieveUpgrade";
	public static final String[] SIEVE_UPGRADE_NAME = {"itemSieveUpgradeSpeed","itemSieveUpgradeFortune"};
	public static final String DOLL_FREEZING = "itemDollFreezing";
	public static final String DOLL_THAUMIC = "itemDollThaumic";
	public static final String HAMMER_MANA = "itemHammerMana";
	public static final String HAMMER_THAUMIUM = "itemHammerThaumium";
	public static final String SEED_FOOD_PLUS = "itemSeedFoodPlus";
	
	public static String[] oreType = { "Gravel","Sand","Dust" };
	
	public static String categoryExAstrisRebirth = "ExAstrisRebirth";
    public static String categoryMagicBees="MagicBees";
    public static String categoryOres="Ores";
    public static String categoryBloodMagic="BloodMagic";
    public static String categoryBotania="Botania";
    public static String categoryChisel="Chisel";
    public static String categoryFoodPlus="FoodPlus";
    public static String categoryMetallurgy="Metallurgy";
    public static String categoryMFR="MineFactoryReloaded";
    public static String categoryNatura="natura";
    public static String categoryRedstoneArsenal="RedstoneArsenal";
    public static String categoryTConstruct="TinkersConstruct";
    public static String categoryTSteelworks="TinkersSteelworks";
    public static String categoryThaumcraft="Thaumcraft";
    public static String categoryThermalExpansion="ThermalExpansion";
    public static String categoryWitchery="Witchery";
    public static String categoryRotaryCraft="RotaryCraft";

	public static String allowSieveAutomaticKey = "autoSieve";
	public static boolean allowSieveAutomatic = true;
	
	public static String allowHammerAutomaticKey = "autoHammer";
	public static boolean allowHammerAutomatic = true;

	public static String sieveAutomaticBaseEnergyKey = "autoSieveEnergy";
	public static int sieveAutomaticBaseEnergy;

	public static String sieveFortuneExtraRollsKey = "autoSieveFortuneExtraRolls";
	public static boolean sieveFortuneExtraRolls;

	public static String sieveFortuneRFIncreaseKey = "autoSieveRFIncrease";
	public static int sieveFortuneRFIncrease;

	public static String sieveFortuneChanceKey = "autoSieveFortuneChance";
	public static int sieveFortuneChance;

	public static String sieveFortuneExtraDropsKey = "autoSieveFortuneExtraDrops";
	public static boolean sieveFortuneExtraDrops;
	
	public static String hammerAutomaticBaseEnergyKey = "hammerAutomaticBaseEnergy";
	public static int hammerAutomaticBaseEnergy;

	public static String allowEndCakeEatingWhileFullKey = "enableEndCakeToBeEatenWhenFull";
	public static boolean allowEndCakeEatingWhileFull = true;
	
	public static String allowBeeTrapInfusedKey = "infusedArtificialHive";
	public static boolean allowBeeTrapInfused = true;
	
	public static String oreYelloriumChanceKey = "yellorium";
	public static int oreYelloriumChance = 128;
	
	public static String allowUnchargedNetherstarKey = "unchargedNetherStar";
	public static boolean allowUnchargedNetherstar = true;
	
	public static String allowBotaniaCompostingKey = "botaniaComposting";
	public static boolean allowBotaniaComposting = true;
	
	public static String allowChiselBlocksFromSiftingKey = "chiselBlocksFromSifting";
	public static boolean allowChiselBlocksFromSifting = true;
	
	public static boolean allowBarrelsToBeChiselled;
	public static String allowBarrelsToBeChiselledKey = "barrelChiselled";
	
	public static boolean allowSievesToBeChiselled;
	public static String allowSievesToBeChiselledKey = "sieveChiselled";
	
	public static String oreDraconiumChanceKey = "draconium";
	public static int oreDraconiumChance = 25;
	
	public static int foodPlusSaplingSiftingChance = 64;
	public static String allowFoodPlusSaplingsFromSiftingChanceKey = "saplingsFromSifting";
	
	public static boolean allowFoodPlusSaplingsToBeComposted = true;
	public static String allowFoodPlusSaplingsToBeCompostedKey = "saplingsToBeComposted";
	
	public static String allowMetallurgyOresKey = "metallurgySifting";
	public static boolean allowMetallurgyOres = true;
	
	public static String allowMFRCompostKey = "MFRCompost";
	public static boolean allowMFRCompost = true;
	
	public static String allowNaturaPlantsKey = "naturaSifting";
	public static boolean allowNaturaPlants = true;
	
	public static String allowNaturaPlantsToBeCompostedKey = "naturaComposting";
	public static boolean allowNaturaPlantsToBeComposted = true;
	
	public static String crookEnergyUsagePoweredKey = "fluxCrookEnergyUsagePowered";
	public static int crookEnergyUsagePowered = 1200;
	
	public static String crookEnergyUsageUnpoweredKey = "fluxCrookEnergyUsageUnpowered";
	public static int crookEnergyUsageUnpowered = 400;
	
	public static String hammerEnergyUsagePoweredKey = "fluxHammerEnergyUsagePowered";
	public static int hammerEnergyUsagePowered = 1200;
	
	public static String hammerEnergyUsageUnpoweredKey = "fluxHammerEnergyUsageUnpowered";
	public static int hammerEnergyUsageUnpowered = 400;
	
	public static String allowTConstructHeatKey = "tinkersHeat";
	public static boolean allowTConstructHeat = true;
	
	public static String allowTConstructModifiersKey = "modifiers";
	public static boolean allowTConstructModifiers = true;
	
	public static String allowAddTConstructNetherOreKey = "tinkersOresFromSifting";
	public static boolean allowAddTConstructNetherOre = true;
	
	public static String allowTConstructBushesKey = "oreberryBushes";
	public static boolean allowTConstructBushes;
	
	public static String oreCobaltChanceKey = "cobalt";
	public static int oreCobaltChance = 128;
	
	public static String oreArditeChanceKey = "ardite";
	public static int oreArditeChance = 128;
	
	public static String allowSteelworksMeltingKey = "steelworksMelting";
	public static boolean allowSteelworksMelting = true;
	
	public static String allowThaumcraftHeatKey = "thaumHeat";
	public static boolean allowThaumcraftHeat = true;
	
	public static String allowThaumcraftResearchKey = "research";
	public static boolean allowThaumcraftResearch = true;
	
	public static String oreQuicksilverChanceKey = "quicksilver";
	public static int oreQuicksilverChance = 128;
	
	public static String oreAmberChanceKey = "amber";
	public static int oreAmberChance = 128;
	
	public static String allowThaumiumBarrelKey = "thaumiumBarrel";
	public static boolean allowThaumiumbarrel = true;
	
	public static String allowDollThaumicKey = "thaumicDoll";
	public static boolean allowDollThaumic = true;
	
	public static String allowHammerThaumiumKey = "thaumiumHammer";
	public static boolean allowHammerThaumium = true;
	
	//Thermal Expansion
	public static String allowThermalExpansionHeatKey = "thermalHeat";
	public static boolean allowThermalExpansionHeat = true;

	public static String allowThermalExpansionHiveKey = "thermalHives";
	public static boolean allowThermalExpansionHive = true;
	
	public static String allowThermalExpansionBlizzKey = "thermalBlizz";
	public static boolean allowThermalExpansionBlizz = true;
	
	//Witchery
	public static int witcherySeedsChance = 64;
	public static String witcherySeedsChanceKey = "seedsFromSifting";
	
	public static boolean witcheryEnableCovenWitch = true;
	public static String witcheryEnableCovenWitchKey = "enableCovenWitch";
	
	public static String allowHammerRFKey = "fluxHammer";
	public static boolean allowHammerRF = true;

	public static String allowCrookRFKey = "fluxCrook";
	public static boolean allowCrookRF = true;
	
	public static String allowEndCakeKey = "endCake";
	public static boolean allowEndCake = true;

	public static boolean enableTERecipes;
	public static String enableTERecipesKey = "enableTERecipes";
	
	public static boolean enableEIORecipes;
	public static String enableEIORecipesKey = "enableEIORecipes";
	
	public static String allowHardStoneKey = "hardStone";
	public static boolean allowHardStone = true;
	
	public static boolean allowUpgrades;
	public static String allowUpgradesKey = "allowUpgradesKey";
	
	public static String allowMiniSmelteryKey = "hardStone";
	public static boolean allowMiniSmeltery = true;
	
	public static void load(Configuration config) {
		enableEIORecipes = config.get(categoryExAstrisRebirth, enableEIORecipesKey, true, "Enable EnderIO Recipes").getBoolean();
		enableTERecipes = config.get(categoryExAstrisRebirth, enableTERecipesKey, true, "Enable Thermal Expansion/Foundation Recipes").getBoolean();
		allowEndCake  = config.get(categoryExAstrisRebirth, allowEndCakeKey, allowEndCake, "Enable End Cake").getBoolean();
		sieveAutomaticBaseEnergy = config.get(categoryExAstrisRebirth, sieveAutomaticBaseEnergyKey, 40, "Base RF/t that is consumed by the Automatic Sieve").getInt();
		sieveFortuneExtraRolls = config.get(categoryExAstrisRebirth, sieveFortuneExtraRollsKey, true, "If true, Fortune upgrades will give extra 'chances' to get each item.").getBoolean();
		sieveFortuneRFIncrease = config.get(categoryExAstrisRebirth, sieveFortuneRFIncreaseKey, 10, "Amount of RF that each Fortune Upgrade costs").getInt();
		sieveFortuneChance = config.get(categoryExAstrisRebirth, sieveFortuneChanceKey, 1,"%ge that each Fortune Upgrade will increase the chance of a drop to double in the Automatic Sieve. Strictly speaking, the chance of the drops being multiplied X times is binomially distributed, with n=64 trials, and probability of success defined here. A value of 1 gives a 22% chance to triple a drop with 64 Fortune Upgrades.").getInt();
		sieveFortuneExtraDrops = config.get(categoryExAstrisRebirth, sieveFortuneExtraDropsKey, true, "If true, Fortune upgrades will give more of each item.").getBoolean();
		allowSieveAutomatic = config.get(categoryExAstrisRebirth, allowSieveAutomaticKey, allowSieveAutomatic, "Enable Automatic Sieve").getBoolean();
		hammerAutomaticBaseEnergy = config.get(categoryExAstrisRebirth, hammerAutomaticBaseEnergyKey, 40, "Base RF/t that is consumed by the Automatic Hammerer").getInt();
		allowEndCakeEatingWhileFull = config.get(categoryExAstrisRebirth, allowEndCakeEatingWhileFullKey, true, "Allow End Cake to be eaten when full").getBoolean();
		allowBeeTrapInfused  = config.get(categoryMagicBees, allowBeeTrapInfusedKey, allowBeeTrapInfused, "Enable Mana Infused Hives").getBoolean();
		oreYelloriumChance = config.get(categoryOres, oreYelloriumChanceKey, oreYelloriumChance).getInt();
		allowUnchargedNetherstar  = config.get(categoryBloodMagic, allowUnchargedNetherstarKey, allowUnchargedNetherstar, "Enable Uncharged Nether Star").getBoolean();
		allowBotaniaComposting = config.get(categoryBotania, allowBotaniaCompostingKey, true, "Allow Botania Mystical Flowers to be composted").getBoolean();
		allowHammerAutomatic = config.get(categoryExAstrisRebirth, allowHammerAutomaticKey, allowHammerAutomatic, "Enable Automatic Hammer").getBoolean();
		allowUpgrades = config.get(categoryExAstrisRebirth, allowUpgradesKey, true, "Allow Upgrades for Automatic Sieve/Hammer").getBoolean();
		
		//Chisel
		allowChiselBlocksFromSifting = config.get(categoryChisel, allowChiselBlocksFromSiftingKey, true, "Allow Marble and Limestone stones to be obtained via sifting").getBoolean();
		allowBarrelsToBeChiselled = config.get(categoryChisel, allowBarrelsToBeChiselledKey , true, "Allow Barrels to be chiselled between types").getBoolean();
		allowSievesToBeChiselled = config.get(categoryChisel, allowSievesToBeChiselledKey, true, "Allow Sieves to be chiselled between types").getBoolean();
		//DraconicEv
		oreDraconiumChance = config.get(categoryOres, oreDraconiumChanceKey, oreDraconiumChance).getInt();
		//Food Plus
		foodPlusSaplingSiftingChance = config.get(categoryFoodPlus, allowFoodPlusSaplingsFromSiftingChanceKey, 64).getInt();
		allowFoodPlusSaplingsToBeComposted = config.get(categoryFoodPlus, allowFoodPlusSaplingsToBeCompostedKey, true).getBoolean();
		//Metallurgy
		allowMetallurgyOres  = config.get(categoryMetallurgy, allowMetallurgyOresKey, allowMetallurgyOres, "Enable Metallurgy Ores from Sifting").getBoolean();
		//MFR
		allowMFRCompost  = config.get(categoryMFR, allowMFRCompostKey, true, "Add MFR items to be composted").getBoolean();
		//Natura
		allowNaturaPlants = config.get(categoryNatura, allowNaturaPlantsKey, true, "Allow Natura Plants to be obtained via sifting").getBoolean();
		allowNaturaPlantsToBeComposted = config.get(categoryNatura, allowNaturaPlantsToBeCompostedKey, true, "Allow Natura Saplings to be composted").getBoolean();
		//REDSTONE ARSENAL
		allowHammerRF  = config.get(categoryRedstoneArsenal, allowHammerRFKey, allowHammerRF, "Enable RF Hammer").getBoolean();
		allowCrookRF = config.get(categoryRedstoneArsenal, allowCrookRFKey, allowCrookRF, "Enable RF Crook").getBoolean();
		
		crookEnergyUsagePowered = config.get(categoryRedstoneArsenal, crookEnergyUsagePoweredKey, crookEnergyUsagePowered, "RF Consumption per block broken for RF Crook when empowered").getInt();
		crookEnergyUsageUnpowered = config.get(categoryRedstoneArsenal, crookEnergyUsageUnpoweredKey, crookEnergyUsageUnpowered, "RF Consumption per block broken for RF Crook when unpowered").getInt();
		hammerEnergyUsagePowered = config.get(categoryRedstoneArsenal, hammerEnergyUsagePoweredKey, hammerEnergyUsagePowered, "RF Consumption per block broken for RF Hammer when empowered").getInt();
		hammerEnergyUsageUnpowered = config.get(categoryRedstoneArsenal, hammerEnergyUsageUnpoweredKey, hammerEnergyUsageUnpowered, "RF Consumption per block broken for RF Hammer when unpowered").getInt();
		//tink
		allowAddTConstructNetherOre  = config.get(categoryTConstruct, allowAddTConstructNetherOreKey, allowAddTConstructNetherOre, "Add Tinkers Nether Ores from sifter").getBoolean();
		allowTConstructHeat  = config.get(categoryTConstruct, allowTConstructHeatKey, allowTConstructHeat, "Add Tinkers Items as a heat source for Crucible etc").getBoolean();
		allowTConstructModifiers  = config.get(categoryTConstruct, allowTConstructModifiersKey, allowTConstructModifiers, "Add Tinkers Modifiers (Smashing and Crooked").getBoolean();
		allowTConstructBushes = config.get(categoryTConstruct, allowTConstructBushesKey, true, "Allow OreBerry bushes to be obtained via sifting").getBoolean();
		oreCobaltChance = config.get(categoryOres, oreCobaltChanceKey, oreCobaltChance).getInt();
		oreArditeChance = config.get(categoryOres, oreArditeChanceKey, oreArditeChance).getInt();

		allowMiniSmeltery  = config.get(categoryTConstruct, allowMiniSmelteryKey, allowMiniSmeltery, "Enable Mini Smeltery").getBoolean();
		//Steelworks
		allowSteelworksMelting  = config.get(categoryTSteelworks, allowSteelworksMeltingKey, allowSteelworksMelting, "Allow Dusts etc to be melted in the High Oven").getBoolean();
		//Thaumcraft
		allowThaumcraftHeat  = config.get(categoryThaumcraft, allowThaumcraftHeatKey, allowThaumcraftHeat, "Add Thaumcraft Items as heat source for Crucible etc").getBoolean();
		allowThaumcraftResearch  = config.get(categoryThaumcraft, allowThaumcraftResearchKey, allowThaumcraftResearch, "Enable Thaumcraft Research").getBoolean();
		oreQuicksilverChance = config.get(categoryOres, oreQuicksilverChanceKey, oreQuicksilverChance).getInt();
		oreAmberChance = config.get(categoryOres, oreAmberChanceKey, oreAmberChance).getInt();
		allowThaumiumbarrel  = config.get(categoryThaumcraft, allowThaumiumBarrelKey, allowThaumiumbarrel, "Enable Thaumium Barrel").getBoolean();
		allowDollThaumic  = config.get(categoryThaumcraft, allowDollThaumicKey, allowDollThaumic, "Enable Thaumic Doll").getBoolean();
		allowHammerThaumium  = config.get(categoryThaumcraft, allowHammerThaumiumKey, allowHammerThaumium, "Enable Thaumium Hammer").getBoolean();
		//Thermal Expansion
		allowThermalExpansionHeat  = config.get(categoryThermalExpansion, allowThermalExpansionHeatKey, allowThermalExpansionHeat, "Add Thermal Expansion Items and Fluids as heat sources for Crucible etc").getBoolean();
		allowThermalExpansionHive  = config.get(categoryThermalExpansion, allowThermalExpansionHiveKey, allowThermalExpansionHive, "Add Thermal Expansion Hive Recipes").getBoolean();
		allowThermalExpansionBlizz  = config.get(categoryThermalExpansion, allowThermalExpansionBlizzKey, allowThermalExpansionBlizz).getBoolean();
		
		//Witchery
		witcherySeedsChance = config.get(categoryWitchery, witcherySeedsChanceKey, witcherySeedsChance).getInt();
		witcheryEnableCovenWitch = config.get(categoryWitchery, witcheryEnableCovenWitchKey, witcheryEnableCovenWitch).getBoolean();
	
		
		//ROTARY
		allowHardStone  = config.get(categoryRotaryCraft, allowHardStoneKey, allowHardStone, "Enable Hard Stone").getBoolean();
		
	}
}
