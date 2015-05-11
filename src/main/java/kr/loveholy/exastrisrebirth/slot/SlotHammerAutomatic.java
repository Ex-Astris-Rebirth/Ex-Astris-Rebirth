package kr.loveholy.exastrisrebirth.slot;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import exnihilo.registries.HammerRegistry;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotHammerAutomatic extends Slot {

	private int id;

	public SlotHammerAutomatic(IInventory p_i1824_1_, int p_i1824_2_,
			int p_i1824_3_, int p_i1824_4_) {
		super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);

		this.id = p_i1824_2_;
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		if (HammerRegistry.registered(
				Block.getBlockFromItem(itemstack.getItem()),
				itemstack.getItemDamage())
				&& this.id == 0) {
			return true;
		} else if (this.id == 21) {
			return itemstack.getItem() == ExAstrisRebirthItem.itemSieveUpgrade
					&& itemstack.getItemDamage() == 0;
		} else if (this.id == 22) {
			return itemstack.getItem() == ExAstrisRebirthItem.itemSieveUpgrade
					&& itemstack.getItemDamage() == 1;
		}
		return false;
	}
}