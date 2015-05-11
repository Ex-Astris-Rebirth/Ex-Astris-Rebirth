package kr.loveholy.exastrisrebirth.item;

import thaumcraft.common.lib.world.ThaumcraftWorldGenerator;
import thaumcraft.common.lib.world.WorldGenEldritchRing;
import thaumcraft.common.lib.world.dim.MazeThread;
import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEldritchPortalSpawner extends Item {

	private WorldGenEldritchRing gen;

	public ItemEldritchPortalSpawner()
	{
		super();
		setCreativeTab(ExAstrisRebirth.TAB);
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.ELDRITCH_PORTAL_SPAWNER;
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.ELDRITCH_PORTAL_SPAWNER;
	}
	
	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":" + ExAstrisRebirthData.ELDRITCH_PORTAL_SPAWNER);
	}

	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			gen = new WorldGenEldritchRing();
			
			gen.chunkX = x;
			gen.chunkZ = z;
			int w = 11 + world.rand.nextInt(6) * 2;
			int h = 11 + world.rand.nextInt(6) * 2;
			gen.width = w;
			gen.height = h;
			
			if (gen.generate(world, world.rand, x, y, z))
			{
				ThaumcraftWorldGenerator.createRandomNodeAt(world, x, y+2, z, world.rand, false, true, false);
				Thread t = new Thread(new MazeThread(x, z, w, h, world.rand.nextLong()));
				t.start();
				stack.stackSize--;
				if (stack.stackSize <= 0)
					stack = null;
				return true;
			}
		}

		return false;

	}

}