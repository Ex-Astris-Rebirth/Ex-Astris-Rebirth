package kr.loveholy.exastrisrebirth.compatibility;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import exnihilo.blocks.ores.BlockOre;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.OreRegistry;
import exnihilo.registries.helpers.Color;

public class ModDraconicEvolution {
	
	public static void init()
	{
		addOres();
		addSiftingRegistry();
		addChestSmeltingDoubling();
	}
	
	private static void addOres()
	{
		OreRegistry.createEnderOre("draconiumdust", new Color("BF3FBF"), ExAstrisRebirthData.oreDraconiumChance, GameRegistry.findItem("DraconicEvolution","draconiumDust"), true);
	}
	
	public static void addSiftingRegistry()
	{
		HammerRegistry.register(GameRegistry.findBlock("exastris", "draconiumdust_dust"), 0, GameRegistry.findItem("DraconicEvolution","draconiumDust"), 0, 0.8f, 0);
		HammerRegistry.register(GameRegistry.findBlock("exastris", "draconiumdust_dust"), 0, GameRegistry.findItem("DraconicEvolution","draconiumDust"), 0, 0.1f, 0.1f);
	}
	
	public static void addChestSmeltingDoubling()
	{
		for (BlockOre b : OreRegistry.gravelTable.values())
			addDraconicDoubling(b);
		for (BlockOre b : OreRegistry.sandTable.values())
			addDraconicDoubling(b);
		for (BlockOre b : OreRegistry.dustTable.values())
			addDraconicDoubling(b);
	}
	
	public static void addDraconicDoubling(Block block)
	{
		// DISABLED FOR NOW
		/*ItemStack furnaceOutput = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(block));
		if (furnaceOutput != null)
		{
			furnaceOutput = furnaceOutput.copy();
			furnaceOutput.stackSize*=2;
			OreDoublingRegistry.resultOverrides.put(block.getUnlocalizedName(), furnaceOutput); //This is naughty
		}*/
	}
}
