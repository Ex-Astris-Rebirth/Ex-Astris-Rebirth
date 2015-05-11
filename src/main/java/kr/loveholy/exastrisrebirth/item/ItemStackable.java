package kr.loveholy.exastrisrebirth.item;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemStackable extends Item {
	private final String unlocalizedName;

	public ItemStackable(String arg1) {
		super();
		this.setCreativeTab(ExAstrisRebirth.TAB);
		this.setMaxStackSize(maxStackSize);
		unlocalizedName = arg1;
	}

	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + unlocalizedName;
	}

	@Override
	public String getUnlocalizedName(ItemStack item) {
		return ExAstrisRebirthData.MODID + "." + unlocalizedName;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":"+ unlocalizedName);
	}

}