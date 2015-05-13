package kr.loveholy.exastrisrebirth.compatibility;

import net.minecraft.item.Item;
import kr.loveholy.exastrisrebirth.item.ItemCrookRF;
import kr.loveholy.exastrisrebirth.item.ItemHammerRF;

public class ModRedstoneArsenal {
	public static void init()
	{
		
	}
	
	public static Item itemHammerRF()
	{
		return new ItemHammerRF();
	}
	
	public static Item itemCrookRF()
	{
		return new ItemCrookRF();
	}
}
