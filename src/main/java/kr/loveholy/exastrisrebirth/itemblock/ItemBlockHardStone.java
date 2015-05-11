package kr.loveholy.exastrisrebirth.itemblock;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockHardStone extends ItemBlock{
	public ItemBlockHardStone(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HARD_STONE_NAME[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
