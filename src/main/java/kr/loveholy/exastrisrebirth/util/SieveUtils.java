package kr.loveholy.exastrisrebirth.util;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import exnihilo.registries.SieveRegistry;

public class SieveUtils {

	private static HashMap<ItemInfo, Boolean> registryCache = new HashMap<ItemInfo, Boolean>();

	public static boolean registered(ItemStack item) {
		Boolean allowed = registryCache.get(new ItemInfo(item));
		if (allowed == null) {
			if (SieveRegistry.Contains(Block.getBlockFromItem(item.getItem()),
					item.getItemDamage())) {
				registryCache.put(new ItemInfo(item), true);
				return true;
			} else {
				registryCache.put(new ItemInfo(item), false);
			}
		} else if (allowed) {
			return true;
		}
		return false;
	}
}