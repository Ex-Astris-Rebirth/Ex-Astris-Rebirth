package kr.loveholy.exastrisrebirth.block;

import java.util.Random;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCake;
import net.minecraft.block.BlockEndPortal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockEndCake extends BlockCake {
	@SideOnly(Side.CLIENT)
	private IIcon[] icon;
	
	public BlockEndCake()
	{
		super();
		setCreativeTab(ExAstrisRebirth.TAB);
	}
	
	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.END_CAKE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		icon = new IIcon[4];
		
		for (int i = 0; i < icon.length; i++)
		{
			
			icon[i] = register.registerIcon(ExAstrisRebirthData.MODID + ":EnderCake_" + i);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return side == 0 ? icon[side] : (side == 1 ? icon[side] : (meta > 0 && side == 4 ? icon[3] : icon[2]));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		int meta = world.getBlockMetadata(x, y, z) - 1;
		ItemStack item = player.getCurrentEquippedItem();

		if (player.capabilities.isCreativeMode)
		{
			if (item != null && item.getItem() == Items.ender_eye)
			{
				world.setBlockMetadataWithNotify(x, y, z, 0, 2);
				return true;
			}
			else
			{
				player.travelToDimension(1);
				return true;
			}
		}
		else
		{
			if (item != null && item.getItem() == Items.ender_eye)
			{
				if (meta >= 0)
				{
					//ExAstris.ExAstris.log.info("METAMEAMETA " + meta);
					world.setBlockMetadataWithNotify(x, y, z, meta, 2);
					--item.stackSize;
					//ExAstris.ExAstris.log.info("METAMEAMETA2 " + meta);
					return true;
				}
			}
			else
			{
				nomEndCake(world, x, y, z, player);
				return true;
			}
		}
		//ExAstris.ExAstris.log.info("METAMEAMETA RETURNFALSE" + meta +" "+item.getUnlocalizedName());
		return false;
    }
	
	private void nomEndCake(World world, int x, int y, int z, EntityPlayer player)
    {
        if (player.canEat(false) || ExAstrisRebirthData.allowEndCakeEatingWhileFull)
        {
            int l = world.getBlockMetadata(x, y, z) + 1;

            if (l >= 6)
            {
            	return;
            }
            else
            {
            	player.getFoodStats().addStats(2, 0.1F);
                world.setBlockMetadataWithNotify(x, y, z, l, 2);
                if (world.provider.dimensionId == 0)
                {
                	if (!BlockEndPortal.field_149948_a)
                	{
                		player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 1));
                	}
                	//if (!EndWorld.bossDefeated) player.addPotionEffect(new PotionEffect(Potion.resistance.id, 200, 1));
                	player.travelToDimension(1);
                }
            }
        }
    }
	
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hx, float hy, float hz, int meta)
    {
        return meta = 5;
    }
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
    {
		if (world.provider.dimensionId == 1)
		{
			world.scheduleBlockUpdate(x, y, z, this, 12000);
		}
    }
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (world.provider.dimensionId == 1)
		{
			int meta = world.getBlockMetadata(x, y, z) - 1;
			if (meta > 0) world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			world.scheduleBlockUpdate(x, y, z, this, 12000);
		}
	}
}
