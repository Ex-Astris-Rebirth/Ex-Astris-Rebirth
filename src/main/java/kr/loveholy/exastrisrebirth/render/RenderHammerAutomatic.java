package kr.loveholy.exastrisrebirth.render;

import org.lwjgl.opengl.GL11;

import kr.loveholy.exastrisrebirth.tileentity.TileEntityHammerAutomatic;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class RenderHammerAutomatic extends TileEntitySpecialRenderer
{
    private static EntityItem item;

    private final float amntMaxRaise = 0.31f;
    private final float percShowItem = 0.60f;
    
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f)
    {
        if (item == null)
        {
            item = new EntityItem(tileentity.getWorldObj());
        }

        float percMaxRaise = 0.90f;

        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);

        TileEntityHammerAutomatic tile = (TileEntityHammerAutomatic) tileentity;
        float prog = 1 - tile.getVolume(); // volume counts down to 0, need to invert that
        ItemStack stack = tile.stackInProgress;

        // show the item to be squashed
        if (prog >= percShowItem && stack != null)
        {
            GL11.glPushMatrix();
            item.setEntityItemStack(stack);
            GL11.glDepthMask(true);
            item.hoverStart = 0.0F;
            GL11.glTranslatef(0, 0.2f, 0);
            GL11.glScalef(0.95f, 0.95f, 0.95f); // fits inside arm when squashed
            RenderManager.instance.renderEntityWithPosYaw(item, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
            GL11.glPopMatrix();
        }

        // on the way down
        if (prog > percMaxRaise)
        {
            percMaxRaise = 1 - percMaxRaise;
            prog = 1 - prog;
        }

        // cut off floating point errors to prevent "bounce" at the bottom
        float translate = Math.max(0, amntMaxRaise * (prog / percMaxRaise));

        GL11.glTranslatef(0, translate, 0);

        bindTexture(ItemRenderHammerAutomatic.texture_arm);
        ItemRenderHammerAutomatic.model_arm.renderAll();
        GL11.glPopMatrix();
    }
}