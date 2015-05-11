package kr.loveholy.exastrisrebirth.itemblock;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends  ItemBlock
{

	public ItemBlockOre(Block block)
	{
		super(block);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return this.getUnlocalizedName() + ExAstrisRebirthData.oreType[item.getItemDamage()];
	}

	@Override
	public int getMetadata (int meta)
    {
        return meta;
    }
}
