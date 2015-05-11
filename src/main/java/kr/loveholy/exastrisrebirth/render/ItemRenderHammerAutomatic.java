package kr.loveholy.exastrisrebirth.render;

import org.lwjgl.opengl.GL11;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.block.BlockHammerAutomatic;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.obj.Face;
import net.minecraftforge.client.model.obj.GroupObject;
import net.minecraftforge.client.model.obj.TextureCoordinate;
import net.minecraftforge.client.model.obj.Vertex;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class ItemRenderHammerAutomatic implements ISimpleBlockRenderingHandler, IItemRenderer
{
    private static final WavefrontObject model_base = new WavefrontObject(new ResourceLocation(ExAstrisRebirthData.MODID, "models/hammer_base.obj"));
    private static final ResourceLocation texture_base = new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/HammerBase.png");

    public static final WavefrontObject model_arm = new WavefrontObject(new ResourceLocation(ExAstrisRebirthData.MODID, "models/hammer_arm.obj"));
    public static final ResourceLocation texture_arm= new ResourceLocation(ExAstrisRebirthData.MODID, "textures/blocks/HammerArm.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return helper == ItemRendererHelper.INVENTORY_BLOCK || helper == ItemRendererHelper.ENTITY_BOBBING || helper == ItemRendererHelper.ENTITY_ROTATION;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch(type)
        {
        case ENTITY:
            break;
        case EQUIPPED:
            GL11.glRotatef(35, 0, 1, 0);
            GL11.glRotatef(20, 0, 0, 1);
            GL11.glScalef(0.65f, 0.65f, 0.65f);
            GL11.glTranslatef(1.1f, -0.2f, 0.75f);
            break;
        case EQUIPPED_FIRST_PERSON:
            GL11.glRotatef(20, 0, 0, 1);
            GL11.glRotatef(30, 0, 1, 0);
            GL11.glTranslatef(0.4f, -0.05f, -0.1f);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            break;
        case FIRST_PERSON_MAP:
            break;
        case INVENTORY:
            GL11.glTranslatef(0, -0.5f, 0);
        }
        
        Minecraft.getMinecraft().renderEngine.bindTexture(texture_base);
        model_base.renderAll();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture_arm);
        model_arm.renderAll();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        ;
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        Tessellator tes = Tessellator.instance;
        IIcon icon = block.getIcon(0, 0);
        tes.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
        tes.setColorOpaque_F(1, 1, 1);
        tes.addTranslation(x + .5F, y, z + .5F);
        for (GroupObject go : model_base.groupObjects)
        {
            for (Face f : go.faces)
            {
                Vertex n = f.faceNormal;
                tes.setNormal(n.x, n.y, n.z);
                for (int i = 0; i < f.vertices.length; i++)
                {
                    Vertex v = f.vertices[i];
                    TextureCoordinate t = f.textureCoordinates[i];
                    tes.addVertexWithUV(v.x, v.y, v.z, icon.getInterpolatedU(t.u * 16), icon.getInterpolatedV(t.v * 16));
                }
            }
        }
        tes.addTranslation(-x - .5F, -y, -z - .5F);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return BlockHammerAutomatic.renderId;
    }

}