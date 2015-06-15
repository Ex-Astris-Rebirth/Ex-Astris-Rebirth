package kr.loveholy.exastrisrebirth.tileentity;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import exnihilo.ENBlocks;
import exnihilo.Fluids;
import exnihilo.blocks.tileentities.TileEntityBarrel;

public class TileEntityBarrelTweak extends TileEntityBarrel{
	
	public TileEntityBarrelTweak()
	{
		super();
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		Item item = stack.getItem();
		int meta = stack.getItemDamage();
		
		Block bl = worldObj.getBlock(xCoord, yCoord, zCoord);
		if(getMode() == BarrelMode.FLUID && this.isFull() && bl != ExAstrisRebirthBlock.blockBarrelThaumium)
		{
			if (fluid.getFluid().equals(Fluids.fluidWitchWater))
			{
				if(Block.getBlockFromItem(item) == Blocks.obsidian)
				{
					return false;
				}
				if(item == ExAstrisRebirthItem.itemDollThaumic)
				{
					return false;
				}
                if(item == ExAstrisRebirthItem.itemDollCrimson)
                {
                    return false;
                }
				if(Block.getBlockFromItem(item) == ENBlocks.BeeTrap)
				{
					return false;
				}
			}
		}
		
		return super.isItemValid(stack);
	}
}
