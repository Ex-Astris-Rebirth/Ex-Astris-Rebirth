package kr.loveholy.exastrisrebirth.block;

import java.util.ArrayList;
import java.util.List;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.tileentity.TileEntitySieveAutomatic;
import cofh.api.block.IDismantleable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.blocks.BlockSieve;

public class BlockSieveAutomatic extends BlockContainer implements
		IDismantleable {
	public static IIcon meshIcon;

	public BlockSieveAutomatic() {
		super(Material.iron);
		setCreativeTab(ExAstrisRebirth.TAB);
		setHardness(2.0f);

		setBlockName(ExAstrisRebirthData.MODID + "."
				+ ExAstrisRebirthData.SIEVE_AUTOMATIC);
		GameRegistry.registerTileEntity(TileEntitySieveAutomatic.class,
				ExAstrisRebirthData.MODID + "."
						+ ExAstrisRebirthData.SIEVE_AUTOMATIC);
	}
	
	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.SIEVE_AUTOMATIC;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register) {
		blockIcon = Blocks.iron_block.getIcon(0, 0);
		meshIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":" + "IconSieveMesh");
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tabs, List subItems) {
		subItems.add(new ItemStack(item, 1, 0));
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
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public int damageDropped(int metadata) {
		return metadata;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySieveAutomatic();
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
			player.openGui(ExAstrisRebirth.instance, 0, world, x, y, z);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<ItemStack> dismantleBlock(EntityPlayer player,
			World world, int x, int y, int z, boolean returnDrops) {
		TileEntitySieveAutomatic te = (TileEntitySieveAutomatic) world
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
			TileEntitySieveAutomatic sieve = (TileEntitySieveAutomatic) world
					.getTileEntity(x, y, z);
			sieve.setEnergyStored(stack.stackTagCompound.getInteger("energy"));
		}

		super.onBlockPlacedBy(world, x, y, z, player, stack);

	}
}
