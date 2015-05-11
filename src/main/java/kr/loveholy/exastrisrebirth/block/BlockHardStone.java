package kr.loveholy.exastrisrebirth.block;

import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityHardStone;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHardStone extends BlockContainer {
	
	private IIcon[] icon;

	public BlockHardStone() {
		super(Material.iron);
		setHardness(50.0f);
		setHarvestLevel("pickaxe", 3);
		setResistance(6000.0f);
		setCreativeTab(ExAstrisRebirth.TAB);	
		
		GameRegistry.registerTileEntity(TileEntityHardStone.class, this.getUnlocalizedName());
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityHardStone();
	}

	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		icon = new IIcon[4];
		
		for (int i = 0; i < icon.length; i++)
		{
			icon[i] = register.registerIcon(ExAstrisRebirthData.MODID+":" + ExAstrisRebirthData.HARD_STONE_NAME[i]);
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
		for (int i = 0; i < 4; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public int damageDropped (int meta)
	{
		return meta;
	}
}
