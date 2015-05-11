package kr.loveholy.exastrisrebirth.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemSieveUpgrade extends Item {

	public IIcon[] blockIcons = new IIcon[2];

	public ItemSieveUpgrade()
	{
		super();
		this.setCreativeTab(ExAstrisRebirth.TAB);
		this.setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.SIEVE_UPGRADE;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.SIEVE_UPGRADE_NAME[item.getItemDamage()];
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(Item item, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 2; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public void registerIcons(IIconRegister register)
	{
		this.blockIcons[0] = register.registerIcon(ExAstrisRebirthData.MODID + ":"+ExAstrisRebirthData.SIEVE_UPGRADE_NAME[0]);
		this.blockIcons[1] = register.registerIcon(ExAstrisRebirthData.MODID + ":"+ExAstrisRebirthData.SIEVE_UPGRADE_NAME[1]);
	}

	@Override
	public IIcon getIconFromDamage(int i){
		return this.blockIcons[i];
	}

}