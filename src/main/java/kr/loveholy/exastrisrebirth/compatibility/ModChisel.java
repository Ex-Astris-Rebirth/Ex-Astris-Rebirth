package kr.loveholy.exastrisrebirth.compatibility;

import com.cricketcraft.chisel.api.IMC;

import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.registries.SieveRegistry;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;

public class ModChisel {

	public static void init()
	{
		if (ExAstrisRebirthData.allowChiselBlocksFromSifting)
		{
			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 0, 1);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 0, 2);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 0, 4);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 0, 16);

			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 1, 1);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 1, 2);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 1, 4);
			SieveRegistry.register(Blocks.stone, 0, ExAstrisRebirthItem.itemChiselStone, 1, 16);

			GameRegistry.addRecipe(new ItemStack(GameRegistry.findItem("chisel", "marble"), 1, 0), new Object[]{"aa","aa", 'a', new ItemStack(ExAstrisRebirthItem.itemChiselStone, 1, 0)});
			GameRegistry.addRecipe(new ItemStack(GameRegistry.findItem("chisel", "limestone"), 1, 0), new Object[]{"aa","aa", 'a', new ItemStack(ExAstrisRebirthItem.itemChiselStone, 1, 1)});
		}
		
	}

	public static void sendIMC()
	{
		if (ExAstrisRebirthData.allowBarrelsToBeChiselled)
		{
			// Convenience recipe for barrels
			//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ExAstrisRebirthBlock.blockBarrelTweak), "x x", "x x", "xyx", 'x', "plankWood", 'y', "slabWood"));
			for (int i = 0; i < 6; i++)
			{
				FMLInterModComms.sendMessage(IMC.CHISEL_MODID, IMC.ADD_VARIATION.key, "ENBarreltweak|exastrisrebirth:blockBarrelTweak|"+i);
				FMLInterModComms.sendMessage(IMC.CHISEL_MODID, IMC.ADD_VARIATION.key, "ENBarrel|exnihilo:barrel|"+i);
			}
		}
		
		if (ExAstrisRebirthData.allowSievesToBeChiselled)
		{
			//GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ENBlocks.Sieve), "aba", "cbc", "c c", 'a', "plankWood", 'b', ENItems.Mesh, 'c', "stickWood"));
			for (int i = 0; i < 6; i++)
			{
				FMLInterModComms.sendMessage(IMC.CHISEL_MODID, IMC.ADD_VARIATION.key, "ENSieve|exnihilo:sifting_table|"+i);
			}
		}
	}
}
