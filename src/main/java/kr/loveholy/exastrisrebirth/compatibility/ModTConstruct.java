package kr.loveholy.exastrisrebirth.compatibility;

import java.util.ArrayList;
import java.util.Iterator;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import kr.loveholy.exastrisrebirth.util.RegistryFactory;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import tconstruct.TConstruct;
import tconstruct.library.ActiveToolMod;
import tconstruct.library.TConstructRegistry;
import tconstruct.library.client.TConstructClientRegistry;
import tconstruct.library.crafting.ModifyBuilder;
import tconstruct.library.crafting.Smeltery;
import tconstruct.library.tools.AbilityHelper;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;
import tconstruct.smeltery.TinkerSmeltery;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.ENBlocks;
import exnihilo.registries.CrucibleRegistry;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.HeatRegistry;
import exnihilo.registries.SieveRegistry;
import exnihilo.registries.helpers.Smashable;
import exnihilo.utils.CrookUtils;

public class ModTConstruct {

	public static final int ingotLiquidValue = TConstruct.ingotLiquidValue;
	public static final int ingotCostSmeltery = TConstruct.ingotLiquidValue * 2;
	
	public static void init()
	{
		addSmeltery();
		if(ExAstrisRebirthData.allowTConstructHeat)
		{
			addHeatRegistry();
		}
		if(ExAstrisRebirthData.allowTConstructModifiers)
		{
			addModifiers();
		}
		addHammerRegistry();
		addSieveRegistry();
		addCrucibleRegistry();
	}
	public static void addCrucibleRegistry()
	{
		if(ExAstrisRebirthData.allowMiniSmeltery)
		{
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "iron_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenIronFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "iron_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "gold_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenGoldFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "gold_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "copper_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenCopperFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "copper_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "tin_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenTinFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "tin_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "silver_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenSilverFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "silver_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "lead_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenLeadFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "lead_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "nickel_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenNickelFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "nickel_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "platinum_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenShinyFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "platinum_dust"));
			CrucibleRegistry.register(GameRegistry.findBlock("exnihilo", "aluminum_dust"), 0, ingotCostSmeltery, TinkerSmeltery.moltenAluminumFluid, TConstruct.ingotLiquidValue, GameRegistry.findBlock("exnihilo", "aluminum_dust"));
			if(ExAstrisRebirthData.allowAddTConstructNetherOre)
			{
				CrucibleRegistry.register(ExAstrisRebirthBlock.blockOreCobalt, 2, ingotCostSmeltery, TinkerSmeltery.moltenCobaltFluid, TConstruct.ingotLiquidValue, ExAstrisRebirthBlock.blockOreCobalt);
				CrucibleRegistry.register(ExAstrisRebirthBlock.blockOreArdite, 2, ingotCostSmeltery, TinkerSmeltery.moltenArditeFluid, TConstruct.ingotLiquidValue, ExAstrisRebirthBlock.blockOreArdite);
			}
		}
	}
	public static void addSieveRegistry()
	{
		if(ExAstrisRebirthData.allowAddTConstructNetherOre)
		{
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisRebirthItem.itemOreCobalt, 0, ExAstrisRebirthData.oreCobaltChance);
			SieveRegistry.register(ENBlocks.NetherGravel, 0, ExAstrisRebirthItem.itemOreArdite, 0, ExAstrisRebirthData.oreArditeChance);
		}
		
		if (ExAstrisRebirthData.allowTConstructBushes)
		{
			SieveRegistry.register(Blocks.stone, 0, GameRegistry.findItem("TConstruct", "ore.berries.one"), 8, 96);
			SieveRegistry.register(Blocks.stone, 0, GameRegistry.findItem("TConstruct", "ore.berries.one"), 9, 96);
			SieveRegistry.register(Blocks.stone, 0, GameRegistry.findItem("TConstruct", "ore.berries.one"), 10, 96);
			SieveRegistry.register(Blocks.stone, 0, GameRegistry.findItem("TConstruct", "ore.berries.one"), 11, 96);
			SieveRegistry.register(Blocks.stone, 0, GameRegistry.findItem("TConstruct", "ore.berries.two"), 8, 96);
			SieveRegistry.register(Blocks.stone, 0, GameRegistry.findItem("TConstruct", "ore.berries.two"), 9, 128);
			
			SieveRegistry.register(GameRegistry.findBlock("TConstruct", "slime.gel"), 1, GameRegistry.findItem("TConstruct", "slime.sapling"), 0, 24);
		}
	}
	public static void addHammerRegistry()
	{
		if(ExAstrisRebirthData.allowAddTConstructNetherOre)
		{
			RegistryFactory.HammerOreRegistryFactory(ExAstrisRebirthBlock.blockOreCobalt, ExAstrisRebirthItem.itemOreCobalt );		
			RegistryFactory.HammerOreRegistryFactory(ExAstrisRebirthBlock.blockOreArdite, ExAstrisRebirthItem.itemOreArdite );	
		}
		
	}
	public static void addSmeltery()
	{
		if(ExAstrisRebirthData.allowAddTConstructNetherOre)
		{
			
			addMelting(ExAstrisRebirthBlock.blockOreCobalt, 0, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, ingotCostSmeltery));
			addMelting(ExAstrisRebirthBlock.blockOreArdite, 0, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, ingotCostSmeltery));		

			addMelting(ExAstrisRebirthBlock.blockOreCobalt, 1, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, ingotCostSmeltery));
			addMelting(ExAstrisRebirthBlock.blockOreArdite, 1, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, ingotCostSmeltery));	
			
			addMelting(ExAstrisRebirthBlock.blockOreCobalt, 2, 650, new FluidStack(TinkerSmeltery.moltenCobaltFluid, ingotCostSmeltery));
			addMelting(ExAstrisRebirthBlock.blockOreArdite, 2, 650, new FluidStack(TinkerSmeltery.moltenArditeFluid, ingotCostSmeltery));	

		}
		
	}
	public static void addMelting(Block block,int metadata,int tempoertature,FluidStack fluid)
	{
		Smeltery.addMelting(block,metadata,tempoertature,fluid);
	}
	public static void addHeatRegistry()
	{
		
		HeatRegistry.register(GameRegistry.findBlock("TConstruct","decoration.stonetorch"), 0.1F);
			

	}
	static void addModifiers()
	{
		ModifyBuilder.registerModifier(new ModCrooked(new ItemStack[] { new ItemStack(GameRegistry.findItem("exnihilo", "crook_bone"), 1, 0) }, 60));
		TConstructClientRegistry.addEffectRenderMapping(60, ExAstrisRebirthData.MODID, "crook", true);
		
		ModifyBuilder.registerModifier(new ModHammered(new ItemStack[] { new ItemStack(GameRegistry.findItem("exnihilo", "hammer_diamond"), 1, 0) }, 61));
		TConstructClientRegistry.addEffectRenderMapping(61, ExAstrisRebirthData.MODID, "hammer", true);
		
		TConstructRegistry.registerActiveToolMod(new TConstructModifier());
	}
}


class TConstructModifier extends ActiveToolMod {

	@Override
	public boolean beforeBlockBreak (ToolCore tool, ItemStack item, int X, int Y, int Z, EntityLivingBase player)
	{
		NBTTagCompound tags = item.getTagCompound().getCompoundTag("InfiTool");
		if (tags.getBoolean("Crooked"))
		{
			World world = player.worldObj;
			Block block = world.getBlock(X,Y,Z);
			world.getBlockMetadata(X, Y, Z);

			boolean valid = CrookUtils.doCrooking(item, X, Y, Z, (EntityPlayer) player);

			if (valid)
				AbilityHelper.onBlockChanged(item, world, block, X, Y, Z, player, AbilityHelper.random);

			return false;
		}

		if (tags.getBoolean("Hammered"))
		{
			World world = player.worldObj;
			Block block = world.getBlock(X,Y,Z);
			int blockMeta = world.getBlockMetadata(X,Y,Z);
			int fortune = EnchantmentHelper.getFortuneModifier(player);

			ArrayList<Smashable> rewards = HammerRegistry.getRewards(block, blockMeta);
			boolean validTarget = false;

			if (rewards != null && !rewards.isEmpty())
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

					validTarget = true;
				}

				if (validTarget)
				{
					AbilityHelper.onBlockChanged(item, world, block, X, Y, Z, player, AbilityHelper.random);

					if (!world.isRemote)
					{
						world.setBlockToAir(X, Y, Z);
					}
				}

				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}

	@Override
	public int attackDamage (int modDamage, int currentDamage, ToolCore tool, NBTTagCompound tags, NBTTagCompound toolTags, ItemStack stack, EntityLivingBase player, Entity entity)
	{
		if (toolTags.hasKey("Crooked"))
		{
			return 0;
		}
		else return currentDamage;
	}
}

class ModCrooked extends ModBoolean {

	static String name = "Crooked";
	static String color = "\u00a77";
	static String tooltip = "Crooked";

	public ModCrooked(ItemStack[] items, int effect) {
		super(items, effect, name, color, tooltip);
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		if (tool.getItem() instanceof ToolCore)
		{
			ToolCore toolitem = (ToolCore) tool.getItem();
			if (!validType(toolitem)) return false;

			NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
			if (!tags.getBoolean("Lava") && !tags.hasKey("Lapis") && !tags.hasKey("Silk Touch") && !tags.hasKey("Hammered"))
			{
				return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
			}
		}
		return false;
	}

	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		tags.setBoolean(name, true);

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);

		int attack = tags.getInteger("Attack");
		attack = 0;
		tags.setInteger("Attack", attack);

		int miningSpeed = tags.getInteger("MiningSpeed");
		miningSpeed -= 300;
		if (miningSpeed < 0)
			miningSpeed = 0;
		tags.setInteger("MiningSpeed", miningSpeed);

		if (tags.hasKey("MiningSpeed2"))
		{
			int miningSpeed2 = tags.getInteger("MiningSpeed2");
			miningSpeed2 -= 300;
			if (miningSpeed2 < 0)
				miningSpeed2 = 0;
			tags.setInteger("MiningSpeed2", miningSpeed2);
		}

		float knockback = tags.getFloat("Knockback");

		knockback += 1.5F;
		tags.setFloat("Knockback", knockback);

		addToolTip(tool, color + tooltip, color + key);
	}

	public boolean validType (ToolCore tool)
	{
		if(tool.getToolName().equals("Mattock") ||
				tool.getToolName().equals("Hatchet") ||
				tool.getToolName().equals("Broadsword") ||
				tool.getToolName().equals("Longsword") ||
				tool.getToolName().equals("Rapier") ||
				tool.getToolName().equals("Cutlass") ||
				tool.getToolName().equals("Cleaver") ||
				tool.getToolName().equals("Lumber Axe") ||
				tool.getToolName().equals("Scythe") || tool.getToolName().equals("Pickaxe"))
		{
			return true;
		}

		return false;
	}

}

class ModHammered  extends ModBoolean {

	static String name = "Hammered";
	static String color = "\u00a79";
	static String tooltip = "Smashing";

	public ModHammered(ItemStack[] items, int i)
	{
		super(items, i, name, color, tooltip);
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input)
	{
		if (tool.getItem() instanceof ToolCore)
		{
			ToolCore toolitem = (ToolCore) tool.getItem();
			if (!validType(toolitem)) return false;

			NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");

			if (!tags.getBoolean("Lava") && !tags.hasKey("Lapis") && !tags.hasKey("Silk Touch") && !tags.hasKey("Crooked"))
			{
				return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
			}
		}
		return false;
	}

	public void modify(ItemStack[] input, ItemStack tool)
	{
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		tags.setBoolean(name, true);

		int modifiers = tags.getInteger("Modifiers");
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);

		int miningSpeed = tags.getInteger("MiningSpeed");
		miningSpeed -= 400;
		if (miningSpeed < 0)
			miningSpeed = 0;
		tags.setInteger("MiningSpeed", miningSpeed);

		int attack = tags.getInteger("Attack");
		attack += 3;
		tags.setInteger("Attack", attack);

		addToolTip(tool, color + tooltip, color + key);
	}

	public boolean validType (ToolCore tool)
	{
		if(tool.getToolName().equals("Mattock") ||
				tool.getToolName().equals("Hatchet") ||
				tool.getToolName().equals("Broadsword") ||
				tool.getToolName().equals("Longsword") ||
				tool.getToolName().equals("Rapier") ||
				tool.getToolName().equals("Cutlass") ||
				tool.getToolName().equals("Cleaver") ||
				tool.getToolName().equals("Lumber Axe") ||
				tool.getToolName().equals("Scythe") || 
				tool.getToolName().equals("Pickaxe") ||
				tool.getToolName().equals("Hammer") ||
				tool.getToolName().equals("Shovel") ||
				tool.getToolName().equals("Excavator"))
		{
			return true;
		}
		return false;

	}
}