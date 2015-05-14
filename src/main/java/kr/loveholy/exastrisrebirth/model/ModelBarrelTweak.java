package kr.loveholy.exastrisrebirth.model;

import exnihilo.blocks.models.ModelBarrel;
import exnihilo.data.ModData;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelBarrelTweak extends ModelBarrel {

	private static final ResourceLocation[] texturestweak = {
		new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelOak.png"), 
		new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelSpruce.png"), 
		new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelBirch.png"),
		new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelJungle.png"),
		new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelAcacia.png"),
		new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelDarkOak.png"),
		new ResourceLocation(ModData.TEXTURE_LOCATION, "textures/blocks/ModelBarrelStone.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelThaumium.png")
	};
	
	private static final ResourceLocation[] texturesbop = {
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelCherry.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelDark.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelEthereal.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelFir.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelHellbark.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelJacaranda.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelMagic.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelMahogany.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelMangrove.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelPalm.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelPine.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelRedwood.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelSacredOak.png"),
		new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/ModelBarrelWillow.png")
	};
	
	public ResourceLocation getBarrelTexture(Block block, int meta) {
		if(block == ExAstrisRebirthBlock.blockBarrelBOP)
		{
			return texturesbop[meta];
		}else if(block == ExAstrisRebirthBlock.blockBarrelTweak)
    	{
    		return texturestweak[meta];
    	}else if(block == ExAstrisRebirthBlock.blockBarrelStone)
    	{
    		return texturestweak[texturestweak.length -2];
    	}else if(block == ExAstrisRebirthBlock.blockBarrelThaumium)
    	{
    		return texturestweak[texturestweak.length -1];
    	}
    	return null;
	}
}
