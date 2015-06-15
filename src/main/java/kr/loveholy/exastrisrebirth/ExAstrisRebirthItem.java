package kr.loveholy.exastrisrebirth;

import kr.loveholy.exastrisrebirth.compatibility.ModBloodMagic;
import kr.loveholy.exastrisrebirth.compatibility.ModBotania;
import kr.loveholy.exastrisrebirth.compatibility.ModRedstoneArsenal;
import kr.loveholy.exastrisrebirth.compatibility.ModThaumcraft;
import kr.loveholy.exastrisrebirth.item.ItemChiselStone;
import kr.loveholy.exastrisrebirth.item.ItemOre;
import kr.loveholy.exastrisrebirth.item.ItemSeedFoodPlus;
import kr.loveholy.exastrisrebirth.item.ItemSieveUpgrade;
import kr.loveholy.exastrisrebirth.item.ItemStackable;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExAstrisRebirthItem {

	public static Item itemSieveUpgrade;
	public static Item itemDollFreezing;
	public static Item itemDollThaumic;
	public static Item itemDollCrimson;
	public static Item itemUnchargedNetherStar;
	public static Item itemHammerMana;
	public static Item itemChiselStone;
	public static Item itemNuggetElectricalSteel;
	public static Item itemSeedFoodPlus;
		
	public static Item itemHammerRF;
	public static Item itemCrookRF;
	
	public static Item itemOreCobalt;
	public static Item itemOreArdite;
	
	public static Item itemHammerThaumium;
	
	public static Item itemEldritchPortalSpawner;
	
	public static Item itemHammerBound;
	public static void init() {
		
		itemSieveUpgrade = new ItemSieveUpgrade();
		GameRegistry.registerItem(itemSieveUpgrade, ExAstrisRebirthData.SIEVE_UPGRADE);
		
		itemDollFreezing = new ItemStackable(ExAstrisRebirthData.DOLL_FREEZING);
		GameRegistry.registerItem(itemDollFreezing, ExAstrisRebirthData.DOLL_FREEZING);

		itemUnchargedNetherStar = new ItemStackable(ExAstrisRebirthData.UNCHARGED_NETHER_STAR);
		GameRegistry.registerItem(itemUnchargedNetherStar, ExAstrisRebirthData.UNCHARGED_NETHER_STAR);
		
		if (Loader.isModLoaded("Botania"))
		{
			itemHammerMana = ModBotania.itemHammerMana();
			GameRegistry.registerItem(itemHammerMana, ExAstrisRebirthData.HAMMER_MANA);
		}
		
		
		itemChiselStone = new ItemChiselStone();
		GameRegistry.registerItem(itemChiselStone, ExAstrisRebirthData.CHISEL_STONE);
		
		
		itemNuggetElectricalSteel = new ItemStackable(ExAstrisRebirthData.NUGGET_ELECTRICAL_STEEL);
		GameRegistry.registerItem(itemNuggetElectricalSteel, ExAstrisRebirthData.NUGGET_ELECTRICAL_STEEL);
		
		itemSeedFoodPlus = new ItemSeedFoodPlus();
		GameRegistry.registerItem(itemSeedFoodPlus, ExAstrisRebirthData.SEED_FOOD_PLUS);
		
		
		if (Loader.isModLoaded("RedstoneArsenal"))
		{
			itemHammerRF =  ModRedstoneArsenal.itemHammerRF();
			GameRegistry.registerItem(itemHammerRF, ExAstrisRebirthData.HAMMER_RF);

			itemCrookRF = ModRedstoneArsenal.itemCrookRF();
			GameRegistry.registerItem(itemCrookRF, ExAstrisRebirthData.CROOK_RF);
		}

		itemOreCobalt = new ItemOre("itemOreCobalt");
		GameRegistry.registerItem(itemOreCobalt, "itemOreCobalt");
		
		itemOreArdite = new ItemOre("itemOreArdite");
		GameRegistry.registerItem(itemOreArdite, "itemOreArdite");
		
		if (Loader.isModLoaded("Thaumcraft"))
		{
			itemDollThaumic = new ItemStackable(ExAstrisRebirthData.DOLL_THAUMIC);
			GameRegistry.registerItem(itemDollThaumic, ExAstrisRebirthData.DOLL_THAUMIC);

			itemDollCrimson = new ItemStackable(ExAstrisRebirthData.DOLL_CRIMSON);
			GameRegistry.registerItem(itemDollCrimson, ExAstrisRebirthData.DOLL_CRIMSON);

			itemHammerThaumium =  ModThaumcraft.itemHammerThaumium();
			GameRegistry.registerItem(itemHammerThaumium, ExAstrisRebirthData.HAMMER_THAUMIUM);
			
			itemEldritchPortalSpawner = ModThaumcraft.itemEldritchPortalSpawner();
			GameRegistry.registerItem(itemEldritchPortalSpawner, ExAstrisRebirthData.ELDRITCH_PORTAL_SPAWNER);
		}
		if(Loader.isModLoaded("AWWayofTime"))
		{
			itemHammerBound = ModBloodMagic.itemHammerBound();
			GameRegistry.registerItem(itemHammerBound, ExAstrisRebirthData.HAMMER_BOUND);
		}
	}
}
