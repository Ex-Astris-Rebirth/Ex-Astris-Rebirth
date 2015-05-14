package kr.loveholy.exastrisrebirth;

import kr.loveholy.exastrisrebirth.block.BlockBarrelBOP;
import kr.loveholy.exastrisrebirth.block.BlockBarrelStone;
import kr.loveholy.exastrisrebirth.block.BlockBarrelTweak;
import kr.loveholy.exastrisrebirth.block.BlockBeeTrapInfused;
import kr.loveholy.exastrisrebirth.block.BlockEndCake;
import kr.loveholy.exastrisrebirth.block.BlockHammerAutomatic;
import kr.loveholy.exastrisrebirth.block.BlockHardStone;
import kr.loveholy.exastrisrebirth.block.BlockOre;
import kr.loveholy.exastrisrebirth.block.BlockSieveAutomatic;
import kr.loveholy.exastrisrebirth.compatibility.ModThaumcraft;
import kr.loveholy.exastrisrebirth.itemblock.ItemBlockBarrelBOP;
import kr.loveholy.exastrisrebirth.itemblock.ItemBlockBarrelTweak;
import kr.loveholy.exastrisrebirth.itemblock.ItemBlockHardStone;
import kr.loveholy.exastrisrebirth.itemblock.ItemBlockOre;
import kr.loveholy.exastrisrebirth.itemblock.ItemBlockSieveAutomatic;
import net.minecraft.block.Block;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class ExAstrisRebirthBlock {
	public static Block blockSieveAutomatic;
	public static Block blockHammerAutomatic;
	public static Block blockEndCake;
	public static Block blockBeeTrapInfused;
	public static Block blockBarrelTweak;
	public static Block blockBarrelBOP;
	public static Block blockBarrelThaumium;
	public static Block blockBarrelStone;

	public static Block blockHardStone;
	

	public static Block blockOreCobalt;
	public static Block blockOreArdite;
	public static void init() {
		blockSieveAutomatic = new BlockSieveAutomatic();
		GameRegistry.registerBlock(blockSieveAutomatic, ItemBlockSieveAutomatic.class ,ExAstrisRebirthData.SIEVE_AUTOMATIC);
		
		blockHammerAutomatic = new BlockHammerAutomatic();
		GameRegistry.registerBlock(blockHammerAutomatic, ExAstrisRebirthData.HAMMER_AUTOMATIC);
		
		blockEndCake = new BlockEndCake();
		GameRegistry.registerBlock(blockEndCake, ExAstrisRebirthData.END_CAKE);
		
		blockBeeTrapInfused = new BlockBeeTrapInfused();
		GameRegistry.registerBlock(blockBeeTrapInfused, ExAstrisRebirthData.BEE_TRAP_INFUSED);
		
		blockBarrelTweak = new BlockBarrelTweak();
		GameRegistry.registerBlock(blockBarrelTweak, ItemBlockBarrelTweak.class ,ExAstrisRebirthData.BARREL_TWEAK);
		
		if (Loader.isModLoaded("BiomesOPlenty"))
		{
			blockBarrelBOP = new BlockBarrelBOP();
			GameRegistry.registerBlock(blockBarrelBOP, ItemBlockBarrelBOP.class ,ExAstrisRebirthData.BARREL_BOP);
		}
		
		blockBarrelStone = new BlockBarrelStone();
		GameRegistry.registerBlock(blockBarrelStone, ExAstrisRebirthData.BARREL_STONE);
		
		if (Loader.isModLoaded("Thaumcraft"))
		{
			blockBarrelThaumium = ModThaumcraft.blockBarrelThaumium();
			GameRegistry.registerBlock(blockBarrelThaumium, ExAstrisRebirthData.BARREL_THAUMIUM);
		}
		
		blockHardStone = new BlockHardStone();
		GameRegistry.registerBlock(blockHardStone, ItemBlockHardStone.class ,ExAstrisRebirthData.HARD_STONE);

		blockOreCobalt = new BlockOre("blockOreCobalt");
		GameRegistry.registerBlock(blockOreCobalt, ItemBlockOre.class ,"blockOreCobalt");
		
		blockOreArdite = new BlockOre("blockOreArdite");
		GameRegistry.registerBlock(blockOreArdite, ItemBlockOre.class ,"blockOreArdite");
	}
}
