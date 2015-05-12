package kr.loveholy.exastrisrebirth.itemblock;

import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSieveAutomatic extends ItemBlock{

	public ItemBlockSieveAutomatic(Block block) {
		super(block);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.SIEVE_AUTOMATIC;
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player,
            List list, boolean par4) {
		if (itemStack.stackTagCompound != null) {
			int energy = itemStack.stackTagCompound.getInteger("energy");
			list.add("Energy Stored: " + energy + " RF");
		}
	}
}
