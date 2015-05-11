package kr.loveholy.exastrisrebirth.render;

import org.lwjgl.opengl.GL11;

import exnihilo.blocks.models.ModelSieveMesh;
import kr.loveholy.exastrisrebirth.block.BlockSieveAutomatic;
import kr.loveholy.exastrisrebirth.model.ModelSieveAutomatic;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderSieveAutomatic implements IItemRenderer {
	private ModelSieveAutomatic model;
	private ModelSieveMesh mesh;

	public ItemRenderSieveAutomatic(ModelSieveAutomatic model,
			ModelSieveMesh mesh) {
		this.model = model;
		this.mesh = mesh;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case FIRST_PERSON_MAP:
			return false;
		case INVENTORY:
			break;
		}
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		switch (type) {
		case ENTITY:
			break;
		case EQUIPPED:
			break;
		case EQUIPPED_FIRST_PERSON:
			break;
		case FIRST_PERSON_MAP:
			return false;
		case INVENTORY:
			break;
		}

		switch (helper) {
		case BLOCK_3D:
			break;
		case ENTITY_BOBBING:
			break;
		case ENTITY_ROTATION:
			break;
		case EQUIPPED_BLOCK:
			break;
		case INVENTORY_BLOCK:
			break;
		default:
			break;

		}
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		renderTable(type, item);
		renderMesh(type);
	}

	private void renderTable(ItemRenderType type, ItemStack item) {
		GL11.glPushMatrix();
		GL11.glScalef(-1F, -1F, 1F);

		switch (type) {
		case EQUIPPED:
			GL11.glTranslatef(-0.5F, -1.5F, 0.5F);
			break;

		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(0F, -1.6F, 0.6F);
			break;

		case ENTITY:
			GL11.glTranslatef(0F, -1.0F, 0F);
			break;

		case INVENTORY:
			GL11.glTranslatef(0F, -1.0F, 0F);
			break;

		default:
			GL11.glTranslatef(0F, 0F, 0F);
			break;
		}

		bindTexture(item.getItemDamage());
		model.simpleRender(0.0625F);

		GL11.glPopMatrix();
	}

	private void renderMesh(ItemRenderType type) {
		GL11.glPushMatrix();
		GL11.glScalef(-1F, -1F, 1F);

		switch (type) {
		case EQUIPPED:
			GL11.glTranslatef(-0.5F, -0.69F, 0.5F);
			break;

		case EQUIPPED_FIRST_PERSON:
			GL11.glTranslatef(-0.5F, -0.79F, 0.5F);
			break;

		case ENTITY:
			GL11.glTranslatef(0F, -0.2F, 0F);
			break;

		case INVENTORY:
			GL11.glTranslatef(0F, -0.2F, 0F);
			break;

		default:
			GL11.glTranslatef(0F, -0.2F, 0F);
			break;
		}

		bindMeshTexture();
		mesh.render(BlockSieveAutomatic.meshIcon);

		GL11.glPopMatrix();
	}

	protected void bindTexture(int meta) {
		TextureManager texturemanager = Minecraft.getMinecraft()
				.getTextureManager();

		if (texturemanager != null) {
			texturemanager.bindTexture(ModelSieveAutomatic.texture);
		}
	}

	protected void bindMeshTexture() {
		TextureManager texturemanager = Minecraft.getMinecraft()
				.getTextureManager();

		if (texturemanager != null) {
			texturemanager.bindTexture(TextureMap.locationBlocksTexture);
		}
	}
}