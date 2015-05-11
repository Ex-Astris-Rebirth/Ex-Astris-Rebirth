package kr.loveholy.exastrisrebirth.item;

import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S2FPacketSetSlot;
import net.minecraft.world.World;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;
import exnihilo.items.hammers.ItemHammerBase;

public class ItemHammerMana extends ItemHammerBase implements IManaUsingItem {

	public static final int MANA_PER_DAMAGE = 60;

	public ItemHammerMana()
	{
		super(ToolMaterial.EMERALD);
		setCreativeTab(ExAstrisRebirth.TAB);
		//this.setUnlocalizedName("manaHammer");
	}

	@Override
	public boolean onBlockStartBreak(ItemStack item, int X, int Y, int Z, EntityPlayer player)
	{
		if (ManaItemHandler.requestManaExactForTool(item, player, 250, false))
		{
			boolean broken = super.onBlockStartBreak(item, X, Y, Z, player);
			if (broken)
				ManaItemHandler.requestManaExactForTool(item, player, MANA_PER_DAMAGE*2, true);

			return broken;
		}
		return false;
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) 
	{
		if(!world.isRemote && player instanceof EntityPlayer && stack.getItemDamage() > 0 && ManaItemHandler.requestManaExactForTool(stack, (EntityPlayer) player, MANA_PER_DAMAGE * 2, true))
		{
			stack.setItemDamage(stack.getItemDamage() - 1);
			EntityPlayer playerEP = (EntityPlayer) player;
			EntityPlayerMP playerMP = (EntityPlayerMP) playerEP;

			playerMP.playerNetServerHandler.sendPacket(new S2FPacketSetSlot(0, playerEP.inventory.currentItem + 36, stack));
		}
	}

	@Override
	public boolean usesMana(ItemStack arg0) 
	{
		return true;
	}

	@Override
	public String getUnlocalizedName() {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_MANA;
	}

	@Override
	public String getUnlocalizedName(ItemStack item) {
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_MANA;
	}

	@Override
	public void registerIcons(IIconRegister register)
	{
		this.itemIcon = register.registerIcon(ExAstrisRebirthData.MODID + ":" + ExAstrisRebirthData.HAMMER_MANA);
	}

}