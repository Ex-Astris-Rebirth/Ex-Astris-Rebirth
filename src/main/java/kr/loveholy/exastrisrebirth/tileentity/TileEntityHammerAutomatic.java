package kr.loveholy.exastrisrebirth.tileentity;

import java.util.ArrayList;
import java.util.Iterator;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthItem;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import cofh.lib.util.helpers.ItemHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.helpers.Smashable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityHammerAutomatic extends TileEntity  implements IEnergyHandler, ISidedInventory{

	public EnergyStorage storage = new EnergyStorage(64000);
	private int energyPerCycle = ExAstrisRebirthData.hammerAutomaticBaseEnergy;
	private float processingInterval = 0.005f;
	protected ItemStack[] inventory;
	public HammerMode mode;
	public Block content;
	public int contentMeta;
	public ItemStack stackInProgress;

	private float volume = 0;
	private boolean particleMode;
	private boolean update=false;
	private static final int UPDATE_INTERVAL = 20;

	private int timer=0;

	public enum HammerMode
	{
		EMPTY(0), FILLED(1);
		private HammerMode(int v){this.value = v;}
		public int value;
	}

	public TileEntityHammerAutomatic()
	{
		this.inventory = new ItemStack[getSizeInventory()];
		this.mode=HammerMode.EMPTY;
	}

	public void updateEntity()
	{
		timer++;
		if (timer >= UPDATE_INTERVAL)
		{	
			timer = 0;
			//disableParticles();

			if (update)
			{
				update();
			}
		}
		if(storage.getEnergyStored() > getEffectiveEnergy())
		{
			if (mode == HammerMode.EMPTY && inventory[0] != null)
			{
				ItemStack held = inventory[0];
				if (HammerRegistry.registered(Block.getBlockFromItem(held.getItem()), held.getItemDamage()))
				{
					addHammerable(Block.getBlockFromItem(held.getItem()), held.getItemDamage());
					stackInProgress = held.copy();
					stackInProgress.stackSize = 1;
					decrStackSize(0,1);
					storage.extractEnergy(getEffectiveEnergy(), false);

				}
			}
			else if(mode != HammerMode.EMPTY)
			{
				processContents();
			}
		}
	}

	public void addHammerable(Block block, int blockMeta)
	{
		this.content = block;
		this.contentMeta = blockMeta;

		this.mode = HammerMode.FILLED;

		volume = 1.0f;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void processContents()
	{
		volume -= getEffectiveSpeed();
		storage.extractEnergy(getEffectiveEnergy(), false);

		if (volume <= 0)
		{
			mode = HammerMode.EMPTY;
			//give rewards!
			if (!worldObj.isRemote)
			{
				
				ArrayList<Smashable> rewards = HammerRegistry.getRewards(content, contentMeta);
				if (rewards.size() > 0)
				{
					
					Iterator<Smashable> it = rewards.iterator();
					while(it.hasNext())
					{
						Smashable reward = it.next();

						int size = getSizeInventory()-2;
						int inventoryIndex = 0;
						if (worldObj.rand.nextFloat() <= reward.chance + (reward.luckMultiplier * getFortuneModifier()))
						{
							for(int i = 1; i < size; i++)
							{
								if(inventory[i] == null)
								{
									inventoryIndex=i;
									break;
								}
								else
								{
									if (ItemHelper.itemsEqualWithMetadata(inventory[i],new ItemStack(reward.item, 1, reward.meta)) && inventory[i].stackSize < inventory[i].getMaxStackSize())
									{
										inventoryIndex=i;
										break;
									}
								}
							}


							if(inventoryIndex != 0)
							{
								if (inventory[inventoryIndex] != null)
									inventory[inventoryIndex] = new ItemStack(reward.item, (inventory[inventoryIndex].stackSize + 1), reward.meta);
								else 
									inventory[inventoryIndex] = new ItemStack(reward.item, 1, reward.meta);
							}
							else
							{
								EntityItem entityitem = new EntityItem(worldObj, (double)xCoord + 0.5D, (double)yCoord + 1.5D, (double)zCoord + 0.5D, new ItemStack(reward.item, 1, reward.meta));

								double f3 = 0.05F;
								entityitem.motionX = worldObj.rand.nextGaussian() * f3;
								entityitem.motionY = (0.2d);
								entityitem.motionZ = worldObj.rand.nextGaussian() * f3;

								worldObj.spawnEntityInWorld(entityitem);

							}
						}
					}
				}
			}
			else if (stackInProgress != null)
			{
				spawnCrushParticles();
			}
		}
		else
		{
			particleMode = true;
		}

		update = true;
	}

	@SideOnly(Side.CLIENT)
	private void spawnCrushParticles()
	{
		for (int i = 0; i < 10; i++)
		{
			EntityDiggingFX particle = new EntityDiggingFX(getWorldObj(), xCoord + 0.5, yCoord + 5d/16d, zCoord + 0.5, 0, 0, 0,
					Block.getBlockFromItem(stackInProgress.getItem()), stackInProgress.getItemDamage()
					);
			particle.setVelocity((worldObj.rand.nextDouble() / 2) - 0.25, 0, (worldObj.rand.nextDouble() / 2) - 0.25);
			Minecraft.getMinecraft().effectRenderer.addEffect(particle);
		}
	}

	private void update()
	{
		update = false;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection arg0) 
	{
		return true;
	}

	@Override
	public int getSizeInventory() 
	{
		return 23;
	}

	@Override
	public ItemStack getStackInSlot(int slot) 
	{
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if(inventory[slot] != null)
		{
			if(inventory[slot].stackSize <= amount)
			{
				ItemStack itemstack = inventory[slot];
				inventory[slot] = null;
				return itemstack;
			}
			ItemStack itemstack1 = inventory[slot].splitStack(amount);
			if(inventory[slot].stackSize == 0)
			{
				inventory[slot] = null;
			}
			return itemstack1;
		}
		else
		{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) 
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) 
	{
		inventory[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}

	}

	@Override
	public String getInventoryName() 
	{
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) 
	{
		return this.canInsertItem(slot, stack, 0); //Side is irrelevant here
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) 
	{
		int size = getSizeInventory()-2;
		int[] slots = new int[size];
		for(int i = 0; i < size; i++)
		{
			slots[i] = i;
		}
		return slots;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack item, int side) {
		if (slot == 0) 
		{
			return HammerRegistry.registered(Block.getBlockFromItem(item.getItem()), item.getItemDamage());
		}
		if (slot == 21)
			return item.getItem() == ExAstrisRebirthItem.itemSieveUpgrade && item.getItemDamage() == 0;
		if (slot==22)
			return item.getItem() == ExAstrisRebirthItem.itemSieveUpgrade && item.getItemDamage() == 1;
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack item,	int side) {
		if (slot >=1) return true;
		if (slot >=1 && slot < 21) return true;
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		switch (compound.getInteger("mode"))
		{
		case 0:
			mode = HammerMode.EMPTY;
			break;

		case 1:
			mode = HammerMode.FILLED;
			break;
		}
		if(!compound.getString("content").equals("")) {
			content = (Block)Block.blockRegistry.getObject(compound.getString("content"));
		}else{
			content = null;
		}
		contentMeta = compound.getInteger("contentMeta");
		volume = compound.getFloat("volume");
		particleMode = compound.getBoolean("particles");
		this.processingInterval = compound.getFloat("speed");
		storage.readFromNBT(compound);

		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.inventory = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.inventory.length)
			{
				this.inventory[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("mode", mode.value);
		//Should change later to not be dependent on DV, as Forge can now change them willy-nilly at startup
		if(content == null) {
			compound.setString("content", "");
		}else{
			compound.setString("content", Block.blockRegistry.getNameForObject(content));
		}
		compound.setInteger("contentMeta", contentMeta);
		compound.setFloat("volume", volume);
		compound.setBoolean("particles", particleMode);
		compound.setFloat("speed", processingInterval);
		storage.writeToNBT(compound);

		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventory.length; ++i)
		{	
			if (this.inventory[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				this.inventory[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		compound.setTag("Items", nbttaglist);
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);

		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.func_148857_g();
		this.readFromNBT(tag);
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) 
	{
		return storage.extractEnergy(maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection arg0) 
	{
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection arg0) {
		return storage.getMaxEnergyStored();
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) 
	{
		return storage.receiveEnergy(maxReceive, simulate);
	}

	public float getEffectiveSpeed()
	{
		float time = processingInterval;
		if (inventory[21] != null)
		{
			time += (((float)inventory[21].stackSize)/1024);
		}
		return time;
	}

	public int getEffectiveEnergy()
	{
		int energy = energyPerCycle;
		if (inventory[21] != null)
		{
			energy *= ((((float)inventory[21].stackSize)/1024) + processingInterval)/processingInterval;
		}
		if (inventory[22] != null)
		{
			energy += inventory[22].stackSize * ExAstrisRebirthData.sieveFortuneRFIncrease;
		}
		return energy;
	}

	public double getFortuneModifier()
	{
		if (inventory[22]== null || ExAstrisRebirthData.sieveFortuneChance==0)
		{
			return 0;
		}
		else
		{
			return (6.0/64) * inventory[22].stackSize;
		}
	}

	public float getVolume() 
	{
		return this.volume;
	}

	public void setEnergyStored(int energy)
	{
		storage.setEnergyStored(energy);
	}



}