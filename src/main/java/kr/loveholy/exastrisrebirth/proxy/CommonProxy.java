package kr.loveholy.exastrisrebirth.proxy;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class CommonProxy {
	public void initializeRenderers() {
	}
	
	public World getWorld()
	{
		World world = null;
		try
		{
			world = MinecraftServer.getServer().worldServers[0];
		}
		catch (Exception ex) 
		{
		  ExAstrisRebirth.log.error("Error while getting server side world reference");
		}
		return world;
	}
}
