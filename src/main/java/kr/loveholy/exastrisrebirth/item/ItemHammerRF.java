package kr.loveholy.exastrisrebirth.item;

import java.util.ArrayList;
import java.util.Iterator;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cofh.redstonearsenal.item.RAItems;
import cofh.redstonearsenal.item.tool.ItemToolRF;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.helpers.Smashable;

public class ItemHammerRF extends ItemToolRF {
	  IIcon activeIcon;
	  IIcon drainedIcon;
	//public static Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{});
	 
	public ItemHammerRF() 
	{
		super(RAItems.TOOL_MATERIAL_FLUX);
		this.energyPerUseCharged=ExAstrisRebirthData.hammerEnergyUsagePowered;
		this.energyPerUse=ExAstrisRebirthData.hammerEnergyUsageUnpowered;
	    //this.energyPerUseCharged = 1600;
		setCreativeTab(ExAstrisRebirth.TAB);
	}

	@Override
	public boolean func_150897_b(Block block)
	{
		return HammerRegistry.registered(block, 0);
	}

	@Override
	public float getDigSpeed(ItemStack item, Block block, int meta)
	{
		if(isEmpowered(item))
		{
			return efficiencyOnProperMaterial * 6.0f;
		}
		else{
			if(getEnergyStored(item) >= getEnergyPerUse(item))
			{
				return efficiencyOnProperMaterial * 1.0f;
			}
				
		}
		return 0.5f;
	}

	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		World world = player.worldObj;
		Block block = world.getBlock(X,Y,Z);
		int blockMeta = world.getBlockMetadata(X,Y,Z);
		int fortune = EnchantmentHelper.getFortuneModifier(player);
		boolean valid = false;

		ArrayList<Smashable> rewards = HammerRegistry.getRewards(block, blockMeta);
		
		if (getEnergyStored(item) < getEnergyPerUse(item))
			return false;
		if (rewards.size() > 0 && block.getHarvestLevel(blockMeta) <= this.toolMaterial.getHarvestLevel())
		{
			Iterator<Smashable> it = rewards.iterator();
			while(it.hasNext())
			{
				Smashable reward = it.next();

				if (!world.isRemote && world.rand.nextFloat() <= reward.chance + (reward.luckMultiplier * fortune))
				{
					EntityItem entityitem = new EntityItem(world, (double)X + 0.5D, (double)Y + 0.5D, (double)Z + 0.5D, new ItemStack(reward.item, 1, reward.meta));

					double f3 = 0.05F;
					entityitem.motionX = world.rand.nextGaussian() * f3;
					entityitem.motionY = (0.2d);
					entityitem.motionZ = world.rand.nextGaussian() * f3;

					world.spawnEntityInWorld(entityitem);
					
				}
				
				valid = true;
			}
			if (valid)
				useEnergy(item, false);
		}else
		{
			if (block.getMaterial().isToolNotRequired() || block.getHarvestTool(blockMeta) == null)
			{
				return false;
			}
		}

		if (item.stackSize == 0)
		{
			player.destroyCurrentEquippedItem();
		}

		if (!world.isRemote)
		{
			world.func_147480_a(X, Y, Z, false);
		}
		
		return valid;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_RF;
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_RF;
	}
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":HammerRF");
	    this.activeIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":HammerRF_Active");
	    this.drainedIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":HammerRF_Drained");
	}
	
	@Override
	public IIcon getIcon(ItemStack paramItemStack, int paramInt)
	{
		return getEnergyStored(paramItemStack) <= 0 ? this.drainedIcon : isEmpowered(paramItemStack) ? this.activeIcon : this.itemIcon;
	}
	
	public EnumRarity getRarity()
	{
		return EnumRarity.uncommon;
	}
	
}
