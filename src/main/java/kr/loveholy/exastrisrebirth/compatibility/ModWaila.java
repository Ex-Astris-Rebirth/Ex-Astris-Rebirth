package kr.loveholy.exastrisrebirth.compatibility;

import java.text.DecimalFormat;
import java.util.List;

import kr.loveholy.exastrisrebirth.block.BlockHardStone;
import kr.loveholy.exastrisrebirth.block.BlockSieveAutomatic;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityHardStone;
import kr.loveholy.exastrisrebirth.tileentity.TileEntitySieveAutomatic;
import kr.loveholy.exastrisrebirth.tileentity.TileEntitySieveAutomatic.SieveMode;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModWaila implements IWailaDataProvider {

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor,
			IWailaConfigHandler config) {
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack stack, List<String> currentTip,
			IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return currentTip;
	}
	
	@Override
	public List<String> getWailaBody(ItemStack stack, List<String> currentTip,
			IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if (accessor.getBlock() instanceof BlockSieveAutomatic) {
			TileEntitySieveAutomatic teSieve = (TileEntitySieveAutomatic) accessor
					.getTileEntity();
			currentTip.add(getSieveDisplay(teSieve));
		} 
		else if (accessor.getBlock() instanceof BlockHardStone && accessor.getMetadata() == 3) {
			TileEntityHardStone scStone = (TileEntityHardStone) accessor
					.getTileEntity();
			currentTip.add(getHardStoneDisplay(scStone));
		} 
		return currentTip;
	}
	
	@Override
	public List<String> getWailaTail(ItemStack stack, List<String> currentTip,
			IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if (accessor.getBlock() instanceof BlockSieveAutomatic) {
			TileEntitySieveAutomatic teSieve = (TileEntitySieveAutomatic) accessor
				.getTileEntity();
			currentTip.add(getSieveDisplayTail(teSieve));
		} 
		return currentTip;
	}
	
	
	public String getSieveDisplay(TileEntitySieveAutomatic sieve) {
		if (sieve.mode == SieveMode.EMPTY)
			return "Empty";// 
		else
			return Math.round(getSieveClicksRemaining(sieve)) + "% left";// + sieve.storage.getEnergyStored() + " / " + sieve.storage.getMaxEnergyStored() + " RF"
	}
	
	public String getHardStoneDisplay(TileEntityHardStone stone) {
		DecimalFormat format = new DecimalFormat("##.#");
		return "Transforming: " + format.format(stone.getVolume() * 100) + "%";
	}
	
	public String getSieveDisplayTail(TileEntitySieveAutomatic sieve) {
		return sieve.storage.getEnergyStored() + " / " + sieve.storage.getMaxEnergyStored() + " RF";
	}
	
	public static void callbackRegister(IWailaRegistrar registrar) {
		ModWaila instance = new ModWaila();
		registrar.registerBodyProvider(instance, BlockSieveAutomatic.class);
		registrar.registerBodyProvider(instance, BlockHardStone.class);
	}
	public float getSieveClicksRemaining(TileEntitySieveAutomatic sieve) {
		return (sieve.getVolume() / 1) * 100;
	}


	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te,
			NBTTagCompound tag, World world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}