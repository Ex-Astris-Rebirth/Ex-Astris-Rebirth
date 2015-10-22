package kr.loveholy.exastrisrebirth.item;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cofh.redstonearsenal.item.RAItems;
import cofh.redstonearsenal.item.tool.ItemToolRF;
import exnihilo.items.hammers.IHammer;
import exnihilo.registries.HammerRegistry;

public class ItemHammerRF extends ItemToolRF implements IHammer {
	IIcon activeIcon;
	IIcon drainedIcon;

	public ItemHammerRF() 
	{
		super(RAItems.TOOL_MATERIAL_FLUX);
		this.energyPerUseCharged=ExAstrisRebirthData.hammerEnergyUsagePowered;
		this.energyPerUse=ExAstrisRebirthData.hammerEnergyUsageUnpowered;
		setCreativeTab(ExAstrisRebirth.TAB);
		this.setHarvestLevel("pickaxe", 3);
	}

	@Override
	public boolean isHammer(ItemStack stack)
	{
		return true;
	}

	@Override
	public boolean func_150897_b(Block block)
	{
		return HammerRegistry.registered(new ItemStack(block));
	}

	@Override
	public float getDigSpeed(ItemStack item, Block block, int meta)
	{
		if (HammerRegistry.registered(new ItemStack(block, 1, meta)) && block.getHarvestLevel(meta) <= this.toolMaterial.getHarvestLevel())
		{
			if(isEmpowered(item))
			{
				return efficiencyOnProperMaterial * 6.0f;
			}
			else{
				if(getEnergyStored(item) >= getEnergyPerUse(item))
				{
					return efficiencyOnProperMaterial * 1.0f;
				}

			}
		}
		return 0.5f;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_RF;
	}

	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_RF;
	}
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":HammerRF");
		this.activeIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":HammerRF_Active");
		this.drainedIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":HammerRF_Drained");
	}

	@Override
	public IIcon getIcon(ItemStack paramItemStack, int paramInt)
	{
		return getEnergyStored(paramItemStack) <= 0 ? this.drainedIcon : isEmpowered(paramItemStack) ? this.activeIcon : this.itemIcon;
	}

	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}

}
