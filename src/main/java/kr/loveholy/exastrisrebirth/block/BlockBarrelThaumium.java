package kr.loveholy.exastrisrebirth.block;

import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityBarrelTweak;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.blocks.BlockBarrel;

public class BlockBarrelThaumium extends BlockBarrel{
	public BlockBarrelThaumium() {
		super(Material.iron);
		setCreativeTab(ExAstrisRebirth.TAB);
		setHardness(4.0f);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);

		setBlockName(ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BARREL_THAUMIUM);
		GameRegistry.registerTileEntity(TileEntityBarrelTweak.class, this.getUnlocalizedName());
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		subItems.add(new ItemStack(item, 1, 0));
	}
	
	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BARREL_THAUMIUM;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":" + "IconBarrelThaumiumCompost");
		iconCompost = register.registerIcon(ExAstrisRebirthData.MODID + ":" + "IconBarrelThaumiumCompost");
		iconClouds = register.registerIcon(ExAstrisRebirthData.MODID + ":" + "IconBarrelInternalClouds");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityBarrelTweak();
	}
}
