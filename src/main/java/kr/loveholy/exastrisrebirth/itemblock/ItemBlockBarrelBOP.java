package kr.loveholy.exastrisrebirth.itemblock;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBarrelBOP extends ItemBlock
{
	public ItemBlockBarrelBOP(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BARREL_BOP_NAME[itemstack.getItemDamage()];
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
