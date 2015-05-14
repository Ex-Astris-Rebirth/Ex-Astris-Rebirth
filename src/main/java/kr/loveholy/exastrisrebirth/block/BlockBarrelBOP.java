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
import net.minecraft.util.IIcon;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBarrelBOP extends BlockBarrelTweak{
	@SideOnly(Side.CLIENT)
	private IIcon[] iconsbop;
	
	public BlockBarrelBOP() {
		super(Material.rock);
		setCreativeTab(ExAstrisRebirth.TAB);
		setHardness(2.0f);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);

		setBlockName(ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BARREL_BOP);
		GameRegistry.registerTileEntity(TileEntityBarrelTweak.class, this.getUnlocalizedName());
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		for (int i = 0; i < 14; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		iconsbop = new IIcon[14];
		iconsbop[0] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 1);
		iconsbop[1] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 2);
		iconsbop[2] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 4);
		iconsbop[3] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 3);
		iconsbop[4] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 12);
		iconsbop[5] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 13);
		iconsbop[6] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 5);
		iconsbop[7] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 14);
		iconsbop[8] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 6);
		iconsbop[9] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 7);
		iconsbop[10] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 11);
		iconsbop[11] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 8);
		iconsbop[12] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 0);
		iconsbop[13] = GameRegistry.findBlock("BiomesOPlenty", "planks").getIcon(0, 9);
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2)
	{
		if(par2 < 14)
			return iconsbop[par2];
		else
			return iconsbop[0];
	}
}
