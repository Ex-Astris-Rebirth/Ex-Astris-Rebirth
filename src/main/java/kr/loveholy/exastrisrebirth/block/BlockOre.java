package kr.loveholy.exastrisrebirth.block;

import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockSand;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockOre  extends BlockSand{

	@SideOnly(Side.CLIENT)
	private IIcon[] icon;
	public String name;
	public BlockOre(String name) {
		super();
		setHardness(0.4F);
		setStepSound(soundTypeSand);
		setCreativeTab(ExAstrisRebirth.TAB);
		this.name = name;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icon = new IIcon[3];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon(ExAstrisRebirthData.MODID+":" + ExAstrisRebirthData.oreType[i] + "/" + name + ExAstrisRebirthData.oreType[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return icon[meta];
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems)
	{
		for (int i = 0; i < 3; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public int damageDropped (int meta)
	{
		return meta;
	}
	
	
	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + name;
	}
}