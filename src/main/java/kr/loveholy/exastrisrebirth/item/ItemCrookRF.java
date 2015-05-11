package kr.loveholy.exastrisrebirth.item;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import cofh.redstonearsenal.item.RAItems;
import cofh.redstonearsenal.item.tool.ItemToolRF;
import exnihilo.utils.CrookUtils;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemCrookRF extends ItemToolRF {
	
	public IIcon itemIcon;
	public IIcon empoweredIcon;
	public IIcon drainedIcon;
	
	
	public ItemCrookRF()
	{
		super(RAItems.TOOL_MATERIAL_FLUX);
		this.energyPerUseCharged=ExAstrisRebirthData.crookEnergyUsagePowered;
		this.energyPerUse=ExAstrisRebirthData.crookEnergyUsageUnpowered;
		this.setCreativeTab(ExAstrisRebirth.TAB);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.CROOK_RF;
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.CROOK_RF;
	}
	
	@Override
	public boolean func_150897_b(Block block)
	{
		return block.isLeaves(ExAstrisRebirth.proxy.getWorld(), 0, 0, 0);
	}
	
	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		if (getEnergyStored(item) < getEnergyPerUse(item))
				return false;
		
		CrookUtils.doCrooking(item, X, Y, Z, player);
		
		return false;
	}
	
	@Override
	public float getDigSpeed(ItemStack item, Block block, int meta)
	{
		if (isEmpowered(item))
			return efficiencyOnProperMaterial * 3.0f;
		else if (getEnergyStored(item) >= getEnergyPerUse(item))
			return efficiencyOnProperMaterial * 0.4f;
		
		return 0.5f;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":CrookRF");
	    this.empoweredIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":CrookRF_Active");
	    this.drainedIcon = register.registerIcon(ExAstrisRebirthData.MODID+":CrookRF_Drained");
	}
	
	@Override
	public IIcon getIcon(ItemStack paramItemStack, int paramInt)
	{
		return getEnergyStored(paramItemStack) <= 0 ? this.drainedIcon : isEmpowered(paramItemStack) ? this.empoweredIcon : this.itemIcon;
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity)
    {
        if (canHarvestBlock(block, stack) && entity instanceof EntityPlayer)
        	harvestBlock(world, x, y, z, (EntityPlayer) entity);

        return true;
    }

}
