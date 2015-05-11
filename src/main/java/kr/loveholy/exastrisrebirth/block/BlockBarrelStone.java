package kr.loveholy.exastrisrebirth.block;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.data.ModData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityBarrelTweak;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockBarrelStone extends BlockBarrelTweak{
	public BlockBarrelStone() {
		super(Material.rock);
		setCreativeTab(ExAstrisRebirth.TAB);
		setHardness(4.0f);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);

		setBlockName(ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BARREL_STONE);
		GameRegistry.registerTileEntity(TileEntityBarrelTweak.class, this.getUnlocalizedName());
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		subItems.add(new ItemStack(item, 1, 0));
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = Blocks.stone.getIcon(0, 0);
		iconCompost = register.registerIcon(ModData.TEXTURE_LOCATION + ":" + "IconBarrelCompost");
	}
	
	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BARREL_STONE;
	}
}
