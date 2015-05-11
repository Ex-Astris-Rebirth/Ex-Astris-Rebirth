package kr.loveholy.exastrisrebirth.creativetab;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabExAstrisRebirth extends CreativeTabs {

	public CreativeTabExAstrisRebirth() {
		super("tabExAstrisRebirth");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ExAstrisRebirthBlock.blockSieveAutomatic);
	}

}