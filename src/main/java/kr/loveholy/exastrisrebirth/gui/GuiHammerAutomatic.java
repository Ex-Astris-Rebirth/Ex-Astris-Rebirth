package kr.loveholy.exastrisrebirth.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityHammerAutomatic;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityHammerAutomatic.HammerMode;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiHammerAutomatic extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation(ExAstrisRebirthData.MODID, "textures/gui/sieveautomatic.png");
	public TileEntityHammerAutomatic hammer;
	
	public GuiHammerAutomatic(InventoryPlayer invPlayer, TileEntityHammerAutomatic entity) {
		super(new ContainerHammerAutomatic(invPlayer, entity));
		hammer = entity;
		xSize = 176;
		ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		
		if(hammer.mode != HammerMode.EMPTY)
		{
			i1= 15-(int)((float)hammer.getVolume()*15.0);
			this.drawTexturedModalRect(k + 32, l + 36, 176, 0, i1, 15);
		}

		i1= (int)((float)hammer.storage.getEnergyStored()/hammer.storage.getMaxEnergyStored()*70.0);
		this.drawTexturedModalRect(k + 152, l + 8+(70-i1), 176 + 15, 0, 16, i1);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		int x = (this.width - this.xSize)/2 + 152;
		int y = (this.height - this.ySize)/2;

		if (mouseX > x && mouseX < x+16 && mouseY < y+69 && mouseY > y - 51)
		{
			List<String> lines = new ArrayList<String>();
			lines.add(this.hammer.getEnergyStored(null)+ " RF");
			lines.add("Consuming "+this.hammer.getEffectiveEnergy()+ "RF/t");
			this.func_146283_a(lines, mouseX - x + 152, mouseY-y+10);
		}
	}

}
