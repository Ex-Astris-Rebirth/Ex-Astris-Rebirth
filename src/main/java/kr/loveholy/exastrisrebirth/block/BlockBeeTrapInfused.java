package kr.loveholy.exastrisrebirth.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockBeeTrapInfused extends Block{
	public static IIcon topIcon;
	public static IIcon sideIcon;
	
	public BlockBeeTrapInfused() {
		super(Material.ground);
		setHardness(0.8f);
		setStepSound(soundTypeGrass);
		setCreativeTab(ExAstrisRebirth.TAB);
	}

	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BEE_TRAP_INFUSED;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		topIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":IconBeeTrapInfusedTopRaw");
		sideIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":IconBeeTrapInfusedSideRaw");
		blockIcon = sideIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
    {
		if (side == 0 || side == 1)
		{
			return topIcon;
		}
		return sideIcon;
    }
}