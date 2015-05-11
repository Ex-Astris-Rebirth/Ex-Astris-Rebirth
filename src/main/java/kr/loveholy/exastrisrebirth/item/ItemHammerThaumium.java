package kr.loveholy.exastrisrebirth.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import thaumcraft.api.IRepairable;
import cpw.mods.fml.common.Optional.Interface;
import exnihilo.items.hammers.ItemHammerBase;

@Interface(iface="thaumcraft.api.IRepairable", modid="Thaumcraft")
public class ItemHammerThaumium extends ItemHammerBase implements IRepairable {

	public ItemHammerThaumium() {
		super(ToolMaterial.EMERALD);
		setCreativeTab(ExAstrisRebirth.TAB);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_THAUMIUM;
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_THAUMIUM;
	}
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":"+ExAstrisRebirthData.HAMMER_THAUMIUM);
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}
}