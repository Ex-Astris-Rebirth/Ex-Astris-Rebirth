package kr.loveholy.exastrisrebirth.tileentity;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHardStone extends TileEntity {
	private int timer;
	private float volume;
	private static final int UPDATE_INTERVAL = 20;
	
	public TileEntityHardStone() {
		super();
		timer = 0;
	}
	
	@Override
	public void updateEntity()
	{
		if(worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 3)
		{
			timer ++;
			if (timer > UPDATE_INTERVAL)
			{
				timer = 0;
				volume += 0.01f;
				worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			}
			
			if (volume > 1.0f)
			{
				worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.bedrock, 0, 3);
			}
		}
			
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.volume = compound.getFloat("volume");
		this.timer = compound.getInteger("timer");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setFloat("volume", this.volume);
		compound.setInteger("timer", this.timer);
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
	
	public float getVolume()
	{
		return this.volume;
	}
}
