package kr.loveholy.exastrisrebirth.proxy;

import kr.loveholy.exastrisrebirth.ExAstrisRebirthBlock;
import kr.loveholy.exastrisrebirth.block.BlockHammerAutomatic;
import kr.loveholy.exastrisrebirth.model.ModelBarrelTweak;
import kr.loveholy.exastrisrebirth.model.ModelSieveAutomatic;
import kr.loveholy.exastrisrebirth.render.ItemRenderHammerAutomatic;
import kr.loveholy.exastrisrebirth.render.ItemRenderSieveAutomatic;
import kr.loveholy.exastrisrebirth.render.RenderHammerAutomatic;
import kr.loveholy.exastrisrebirth.render.RenderSieveAutomatic;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityBarrelTweak;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityHammerAutomatic;
import kr.loveholy.exastrisrebirth.tileentity.TileEntitySieveAutomatic;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import exnihilo.blocks.models.ModelBarrel;
import exnihilo.blocks.models.ModelSieveMesh;
import exnihilo.blocks.renderers.RenderBarrel;
import exnihilo.blocks.renderers.blockItems.ItemRenderBarrel;

public class ClientProxy extends CommonProxy {
	@Override
	public void initializeRenderers() {
		ModelSieveAutomatic sieve = new ModelSieveAutomatic();
		ModelSieveMesh mesh = new ModelSieveMesh();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySieveAutomatic.class, new RenderSieveAutomatic(sieve,mesh));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisRebirthBlock.blockSieveAutomatic),new ItemRenderSieveAutomatic(sieve, mesh));
		
		BlockHammerAutomatic.renderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new ItemRenderHammerAutomatic());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHammerAutomatic.class,  new RenderHammerAutomatic());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisRebirthBlock.blockHammerAutomatic), new ItemRenderHammerAutomatic());

		ModelBarrel barrel = new ModelBarrelTweak();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrelTweak.class, new RenderBarrel(barrel));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisRebirthBlock.blockBarrelTweak), new ItemRenderBarrel(barrel));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisRebirthBlock.blockBarrelThaumium), new ItemRenderBarrel(barrel));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisRebirthBlock.blockBarrelStone), new ItemRenderBarrel(barrel));

	}
	
	@Override
	public World getWorld()
	{
		World world = null;
		try
		{
			world = Minecraft.getMinecraft().theWorld;
		}
		catch (Exception ex) {}
		return world;
	}
}
