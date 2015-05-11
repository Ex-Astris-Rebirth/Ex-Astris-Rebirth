package kr.loveholy.exastrisrebirth.block;

import java.util.ArrayList;
import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityHammerAutomatic;
import cofh.api.block.IDismantleable;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class BlockHammerAutomatic extends BlockContainer implements
		IDismantleable {

	public static int renderId;

	private double minYTop = 13d / 16d;
	private double maxYBot = 3d / 16d;

	public BlockHammerAutomatic() {
		super(Material.iron);
		setCreativeTab(ExAstrisRebirth.TAB);
		setHardness(2.0f);

		setBlockName(ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_AUTOMATIC);
		setBlockTextureName(ExAstrisRebirthData.MODID + ":HammerBase");
		GameRegistry.registerTileEntity(TileEntityHammerAutomatic.class,
				ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_AUTOMATIC);
	}

	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_AUTOMATIC;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block,
			int meta) {
		TileEntity tile = world.getTileEntity(x, y, z);

		ISidedInventory inv = (ISidedInventory) tile;
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			if (inv.getStackInSlot(i) != null) {
				EntityItem entityitem = new EntityItem(world, x, y, z,
						inv.getStackInSlot(i));
				world.spawnEntityInWorld(entityitem);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new TileEntityHammerAutomatic();
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		PlayerInteractEvent e = new PlayerInteractEvent(player,
				Action.RIGHT_CLICK_BLOCK, x, y, z, side, world);
		if (MinecraftForge.EVENT_BUS.post(e) || e.getResult() == Result.DENY
				|| e.useBlock == Result.DENY)
			return false;

		if (!player.isSneaking()) {
			player.openGui(ExAstrisRebirth.instance, 1, world, x, y, z);
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z,
			AxisAlignedBB mask, List list, Entity colliding) {
		AxisAlignedBB up = getUpperBox(x, y, z);
		AxisAlignedBB down = getLowerBox(x, y, z);

		if (mask.intersectsWith(up)) {
			list.add(up);
		}

		if (mask.intersectsWith(down)) {
			list.add(down);
		}
	}

	private AxisAlignedBB getUpperBox(int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y + minYTop, z, x + 1, y + 1,
				z + 1);
	}

	private AxisAlignedBB getLowerBox(int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + maxYBot, z + 1);
	}

	@Override
	public int getRenderType() {
		return renderId;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public ArrayList<ItemStack> dismantleBlock(EntityPlayer player,
			World world, int x, int y, int z, boolean returnDrops) {
		TileEntityHammerAutomatic te = (TileEntityHammerAutomatic) world
				.getTileEntity(x, y, z);

		ItemStack stack = new ItemStack(this);
		if (stack.stackTagCompound == null)
			stack.stackTagCompound = new NBTTagCompound();
		stack.stackTagCompound.setInteger("energy", te.getEnergyStored(null));

		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(stack);
		world.setBlockToAir(x, y, z);
		if (!returnDrops) {
			dropBlockAsItem(world, x, y, z, stack);
		}
		return ret;
	}

	public boolean canDismantle(EntityPlayer player, World world, int x, int y,
			int z) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase player, ItemStack stack) {
		if (stack.stackTagCompound != null
				&& stack.stackTagCompound.hasKey("energy")) {
			TileEntityHammerAutomatic sieve = (TileEntityHammerAutomatic) world
					.getTileEntity(x, y, z);
			sieve.setEnergyStored(stack.stackTagCompound.getInteger("energy"));
		}

		super.onBlockPlacedBy(world, x, y, z, player, stack);

	}

}