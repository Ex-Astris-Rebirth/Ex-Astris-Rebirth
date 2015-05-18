package kr.loveholy.exastrisrebirth.block;

import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityBarrelTweak;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.ENBlocks;
import exnihilo.ENItems;
import exnihilo.Fluids;
import exnihilo.blocks.BlockBarrel;
import exnihilo.blocks.tileentities.TileEntityBarrel.BarrelMode;

public class BlockBarrelTweak extends BlockBarrel
{
	public BlockBarrelTweak() {
		super(Material.wood);
		setCreativeTab(ExAstrisRebirth.TAB);
		setHardness(2.0f);
		setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 1.0F, 0.9F);

		setBlockName(ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.BARREL_TWEAK);
		GameRegistry.registerTileEntity(TileEntityBarrelTweak.class, this.getUnlocalizedName());
	}
	
	public BlockBarrelTweak(Material material)
	{
		super(material);
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		for (int i = 0; i < 6; i++) {
			subItems.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = Blocks.planks.getIcon(0, 0);
	    iconCompost = register.registerIcon("exnihilo:IconBarrelCompost");
	    iconClouds = register.registerIcon("exnihilo:IconBarrelInternalClouds");
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityBarrelTweak();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{

		TileEntityBarrelTweak barrel = (TileEntityBarrelTweak) world.getTileEntity(x, y, z);
		if (player.getCurrentEquippedItem() != null)
		{
			ItemStack item = player.getCurrentEquippedItem();
			if (item!=null)
			{
				if (item!= null)
				{
					if (barrel.getMode() == BarrelMode.FLUID && barrel.isFull())
					{
						if (barrel.fluid.fluidID == Fluids.fluidWitchWater.getID())
						{
							if(item.getItem() == Item.getItemFromBlock(Blocks.obsidian))
							{
								return true;
							}
							
							if(item.getItem() == Item.getItemFromBlock(ENBlocks.BeeTrap))
							{
								return true;
							}
							
							if(item.getItem() == ExAstrisRebirthItem.itemDollThaumic)
							{
								return true;
							}
						}
					}
				}
			}
		}
		return super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
	}
}
