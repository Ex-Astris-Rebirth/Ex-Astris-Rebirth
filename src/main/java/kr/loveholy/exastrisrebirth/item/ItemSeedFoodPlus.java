package kr.loveholy.exastrisrebirth.item;

import java.util.ArrayList;
import java.util.Random;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import exnihilo.items.seeds.ItemSeedBase;

public class ItemSeedFoodPlus extends ItemSeedBase {
	
	private static ArrayList<Block> plants = new ArrayList<Block>();
	private static Random rand = new Random();

	public ItemSeedFoodPlus() 
	{
		super(Blocks.sapling, Blocks.dirt);
		setCreativeTab(ExAstrisRebirth.TAB);
	}
	
	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.SEED_FOOD_PLUS;
	}

	@Override
	public String getUnlocalizedName(ItemStack item) {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.SEED_FOOD_PLUS;
	}
	
	private static void addPlant(Block block)
	{
		if (block != null)
			plants.add(block);
	}
	
	@Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Plains;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
    	
        if (plants.size() > 0)
        {
        	return plants.get(rand.nextInt(plants.size()));
        }
        
        return Blocks.sapling;
    }
    
    @Override
    public void registerIcons(IIconRegister register)
    {
    	this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":"+ExAstrisRebirthData.SEED_FOOD_PLUS);
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return 0;
    }
    
    public static void addPlants(Block[] block)
    {
    	for (Block bl : block)
    	{
    		addPlant(bl);
    	}
    }

}
