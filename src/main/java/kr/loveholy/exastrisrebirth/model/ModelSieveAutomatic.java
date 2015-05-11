package kr.loveholy.exastrisrebirth.model;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelSieveAutomatic extends ModelBase {
	// fields
	ModelRenderer Leg1;
	ModelRenderer Leg2;
	ModelRenderer Leg3;
	ModelRenderer Leg4;
	ModelRenderer BoxSide1;
	ModelRenderer BoxSide2;
	ModelRenderer BoxSide3;
	ModelRenderer BoxSide4;

	public static final ResourceLocation texture = new ResourceLocation(
			ExAstrisRebirthData.MODID,
			"textures/blocks/ModelSieveAutomatic.png");

	public ModelSieveAutomatic() {
		textureWidth = 128;
		textureHeight = 128;

		Leg1 = new ModelRenderer(this, 0, 0);
		Leg1.addBox(0F, 0F, 0F, 1, 11, 1);
		Leg1.setRotationPoint(-7F, 13F, -7F);
		Leg1.setTextureSize(128, 128);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 0, 0);
		Leg2.addBox(0F, 0F, 0F, 1, 11, 1);
		Leg2.setRotationPoint(-7F, 13F, 6F);
		Leg2.setTextureSize(128, 128);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0F);
		Leg3 = new ModelRenderer(this, 0, 0);
		Leg3.addBox(0F, 0F, 0F, 1, 11, 1);
		Leg3.setRotationPoint(6F, 13F, 6F);
		Leg3.setTextureSize(128, 128);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 0, 0);
		Leg4.addBox(0F, 0F, 0F, 1, 11, 1);
		Leg4.setRotationPoint(6F, 13F, -7F);
		Leg4.setTextureSize(128, 128);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, 0F, 0F);
		BoxSide1 = new ModelRenderer(this, 6, 0);
		BoxSide1.addBox(0F, 0F, 0F, 16, 6, 1);
		BoxSide1.setRotationPoint(-8F, 8F, -8F);
		BoxSide1.setTextureSize(128, 128);
		BoxSide1.mirror = true;
		setRotation(BoxSide1, 0F, 0F, 0F);
		BoxSide2 = new ModelRenderer(this, 6, 8);
		BoxSide2.addBox(0F, 0F, 0F, 16, 6, 1);
		BoxSide2.setRotationPoint(-8F, 8F, 7F);
		BoxSide2.setTextureSize(128, 128);
		BoxSide2.mirror = true;
		setRotation(BoxSide2, 0F, 0F, 0F);
		BoxSide3 = new ModelRenderer(this, 6, 16);
		BoxSide3.addBox(0F, 0F, 0F, 1, 6, 14);
		BoxSide3.setRotationPoint(7F, 8F, -7F);
		BoxSide3.setTextureSize(128, 128);
		BoxSide3.mirror = true;
		setRotation(BoxSide3, 0F, 0F, 0F);
		BoxSide4 = new ModelRenderer(this, 6, 37);
		BoxSide4.addBox(0F, 0F, 0F, 1, 6, 14);
		BoxSide4.setRotationPoint(-8F, 8F, -7F);
		BoxSide4.setTextureSize(128, 128);
		BoxSide4.mirror = true;
		setRotation(BoxSide4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Leg1.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		BoxSide1.render(f5);
		BoxSide2.render(f5);
		BoxSide3.render(f5);
		BoxSide4.render(f5);
	}

	public void simpleRender(float scale) {
		Leg1.render(scale);
		Leg2.render(scale);
		Leg3.render(scale);
		Leg4.render(scale);
		BoxSide1.render(scale);
		BoxSide2.render(scale);
		BoxSide3.render(scale);
		BoxSide4.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}