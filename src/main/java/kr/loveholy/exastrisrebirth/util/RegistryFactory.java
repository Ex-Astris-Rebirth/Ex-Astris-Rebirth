package kr.loveholy.exastrisrebirth.util;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.SieveRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RegistryFactory {
	public static void HammerOreRegistryFactory(Block block, Item item)
	{
		for(int i=0;i<2;i++)
		{
			HammerRegistry.register(block, i,item , (i+1), 1.00f, 0.0f);
			HammerRegistry.register(block, i,item , (i+1), 1.00f, 0.0f);
			HammerRegistry.register(block, i,item , (i+1), 1.00f, 0.0f);
			HammerRegistry.register(block, i,item , (i+1), 1.00f, 0.0f);
			HammerRegistry.register(block, i,item , (i+1), 0.50f, 0.1f);
			HammerRegistry.register(block, i,item , (i+1), 0.05f, 0.1f);
			HammerRegistry.register(block, i,item , (i+1), 0.0f, 0.05f);
		}
		
	}
	
	public static void FurnaceOreRegistryFactory(Block block,ItemStack items)
	{
		ItemStack OreBlock = new ItemStack(block,1,0);
		ItemStack OreBlock1 = new ItemStack(block,1,1);
		ItemStack OreBlock2 = new ItemStack(block,1,2);
		GameRegistry.addSmelting(OreBlock, items, 0.1f);
		GameRegistry.addSmelting(OreBlock1, items, 0.1f);
		GameRegistry.addSmelting(OreBlock2, items, 0.1f);
	}
	
	public static void SieveOreRegistryFactory(Item item)
	{
		SieveRegistry.register(Blocks.gravel, 0, item, 0, 128);
		SieveRegistry.register(Blocks.sand, 0, item, 1, 128);
		SieveRegistry.register(ENBlocks.Dust, 0, item, 2, 128);
	}
}
