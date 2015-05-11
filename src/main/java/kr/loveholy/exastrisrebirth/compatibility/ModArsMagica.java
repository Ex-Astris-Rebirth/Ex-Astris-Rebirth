package kr.loveholy.exastrisrebirth.compatibility;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import exnihilo.ENBlocks;
import exnihilo.registries.SieveRegistry;

public class ModArsMagica {
	public static void init()
	{
		addSieveRegistry();
	}
	public static void addSieveRegistry()
	{
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 0, 128);
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 4, 128);
		SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 5, 128);
		SieveRegistry.register(ENBlocks.NetherGravel, 0, GameRegistry.findItem("arsmagica2", "itemOre"), 6, 128);
	}
}
