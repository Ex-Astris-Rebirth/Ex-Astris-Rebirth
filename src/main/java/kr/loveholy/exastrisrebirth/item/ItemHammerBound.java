package kr.loveholy.exastrisrebirth.item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.HashMultiset;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import exnihilo.items.hammers.ItemHammerBase;
import exnihilo.registries.HammerRegistry;
import exnihilo.registries.helpers.Smashable;
import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.items.interfaces.IBindable;
import WayofTime.alchemicalWizardry.common.ItemType;
import WayofTime.alchemicalWizardry.common.items.BoundPickaxe;
import WayofTime.alchemicalWizardry.common.items.EnergyItems;
import WayofTime.alchemicalWizardry.common.spell.complex.effect.SpellHelper;

public class ItemHammerBound extends ItemHammerBase implements IBindable{
	public float efficiencyOnProperMaterial = 12.0F;
    private static IIcon activeIcon;
    private static IIcon passiveIcon;
    private int energyUsed;
	public ItemHammerBound() {
		super(AlchemicalWizardry.bloodBoundToolMaterial);
		setCreativeTab(ExAstrisRebirth.TAB);
		this.maxStackSize = 1;
        setEnergyUsed(5);
	}
	
	public void setEnergyUsed(int i)
    {
        energyUsed = i;
    }
	
	public int getEnergyUsed()
    {
        return this.energyUsed;
    }
	
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        //par3List.add(StatCollector.translateToLocal("tooltip.boundhammer.desc"));

        if (!(par1ItemStack.getTagCompound() == null))
        {
            if (par1ItemStack.getTagCompound().getBoolean("isActive"))
            {
                par3List.add(StatCollector.translateToLocal("tooltip.sigil.state.activated"));
            } else
            {
                par3List.add(StatCollector.translateToLocal("tooltip.sigil.state.deactivated"));
            }

            if (!par1ItemStack.getTagCompound().getString("ownerName").equals(""))
            {
                par3List.add(StatCollector.translateToLocal("tooltip.owner.currentowner") + " " + par1ItemStack.getTagCompound().getString("ownerName"));
            }
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(ExAstrisRebirthData.MODID + ":BoundHammer_activated");
        this.activeIcon = iconRegister.registerIcon(ExAstrisRebirthData.MODID + ":BoundHammer_activated");
        this.passiveIcon = iconRegister.registerIcon("AlchemicalWizardry:SheathedItem");
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        if (stack.getTagCompound() == null)
        {
            stack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound tag = stack.getTagCompound();

        if (tag.getBoolean("isActive"))
        {
            return this.activeIcon;
        } else
        {
            return this.passiveIcon;
        }
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!EnergyItems.checkAndSetItemOwner(par1ItemStack, par3EntityPlayer) || par3EntityPlayer.isSneaking())
        {
            this.setActivated(par1ItemStack, !getActivated(par1ItemStack));
            par1ItemStack.getTagCompound().setInteger("worldTimeDelay", (int) (par2World.getWorldTime() - 1) % 200);
            return par1ItemStack;
        }
        
        if (par2World.isRemote)
        {
            return par1ItemStack;
        }

        if (!getActivated(par1ItemStack) || SpellHelper.isFakePlayer(par2World, par3EntityPlayer))
        {
            return par1ItemStack;
        }

        if (par3EntityPlayer.isPotionActive(AlchemicalWizardry.customPotionInhibit))
        {
            return par1ItemStack;
        }
        
        if(!EnergyItems.syphonBatteries(par1ItemStack, par3EntityPlayer, 10000))
        {
        	return par1ItemStack;
        }

        Vec3 blockVec = SpellHelper.getEntityBlockVector(par3EntityPlayer);
        int posX = (int) (blockVec.xCoord);
        int posY = (int) (blockVec.yCoord);
        int posZ = (int) (blockVec.zCoord);
        //boolean silkTouch = EnchantmentHelper.getSilkTouchModifier(par3EntityPlayer);
        int fortuneLvl = EnchantmentHelper.getFortuneModifier(par3EntityPlayer);

        HashMultiset<ItemType> dropMultiset = HashMultiset.create();
        
        for (int i = -5; i <= 5; i++)
        {
            for (int j = -5; j <= 5; j++)
            {
                for (int k = -5; k <= 5; k++)
                {
                    Block block = par2World.getBlock(posX + i, posY + j, posZ + k);
                    int meta = par2World.getBlockMetadata(posX + i, posY + j, posZ + k);

                    if (block != null)
                    {
                        //float str = func_150893_a(par1ItemStack, block);
                        ArrayList<Smashable> rewards = HammerRegistry.getRewards(block, meta);
                        
                        if (rewards != null && rewards.size() > 0)
                        {
                        	Iterator<Smashable> it = rewards.iterator();
                        	while(it.hasNext())
                			{
                				Smashable reward = it.next();
                				if (par2World.rand.nextFloat() <= reward.chance + (reward.luckMultiplier * fortuneLvl))
                				{
                					dropMultiset.add(ItemType.fromStack(new ItemStack(reward.item, 1, reward.meta)), 1);
                					
                				}
                			}
                        	/*if (silkTouch && block.canSilkHarvest(par2World, par3EntityPlayer, posX + i, posY + j, posZ + k, meta))
                            {
                                dropMultiset.add(new ItemType(block, meta));
                            } else
                            {
                                ArrayList<ItemStack> itemDropList = block.getDrops(par2World, posX + i, posY + j, posZ + k, meta, fortuneLvl);

                                if (itemDropList != null)
                                {
                                    for (ItemStack stack : itemDropList)
                                        dropMultiset.add(ItemType.fromStack(stack), stack.stackSize);
                                }
                            }*/

                            par2World.setBlockToAir(posX + i, posY + j, posZ + k);
                        }
                    }
                }
            }
        }
        
        BoundPickaxe.dropMultisetStacks(dropMultiset, par2World, posX, posY + par3EntityPlayer.getEyeHeight(), posZ);
        
        return par1ItemStack;
    }
    
    @Override
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
        if (!(par3Entity instanceof EntityPlayer))
        {
            return;
        }

        EntityPlayer par3EntityPlayer = (EntityPlayer) par3Entity;

        if (par1ItemStack.getTagCompound() == null)
        {
            par1ItemStack.setTagCompound(new NBTTagCompound());
        }

        if (par2World.getWorldTime() % 200 == par1ItemStack.getTagCompound().getInteger("worldTimeDelay") && par1ItemStack.getTagCompound().getBoolean("isActive"))
        {
            if (!par3EntityPlayer.capabilities.isCreativeMode)
            {
                if(!EnergyItems.syphonBatteries(par1ItemStack, par3EntityPlayer, 20))
                {
                	this.setActivated(par1ItemStack, false);
                }
            }
        }

        par1ItemStack.setItemDamage(0);
        return;
    }
    
    @Override
    public float func_150893_a(ItemStack par1ItemStack, Block par2Block) //getStrVsBlock
    {
        if (!getActivated(par1ItemStack))
        {
            return 0.0F;
        }

        // return super.func_150893_a(par1ItemStack, par2Block); // Seems to always return one (or zero?)
        return efficiencyOnProperMaterial;
    }

    @Override
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        if (!getActivated(par1ItemStack))
        {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, Block par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {

        if (par7EntityLivingBase instanceof EntityPlayer)
        {
            EnergyItems.syphonBatteries(par1ItemStack, (EntityPlayer) par7EntityLivingBase, getEnergyUsed());
        }
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
    
    @Override
    public int getItemEnchantability()
    {
        return 30;
    }
    
    public void setActivated(ItemStack par1ItemStack, boolean newActivated)
    {
        NBTTagCompound itemTag = par1ItemStack.getTagCompound();

        if (itemTag == null)
        {
            par1ItemStack.setTagCompound(new NBTTagCompound());
        }

        itemTag.setBoolean("isActive", newActivated);
    }
    
    public boolean getActivated(ItemStack par1ItemStack)
    {
        if (!par1ItemStack.hasTagCompound())
        {
            par1ItemStack.setTagCompound(new NBTTagCompound());
        }

        NBTTagCompound itemTag = par1ItemStack.getTagCompound();

        return itemTag.getBoolean("isActive");
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
        if (!getActivated(stack))
        {
            return 0.0F;
        }

        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
            return efficiencyOnProperMaterial;
        }

        return func_150893_a(stack, block);
    }
    
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        return !getActivated(stack);
    }
    
    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass)
    {
        if (getActivated(stack) && "pickaxe".equals(toolClass))
        {
            return 5;
        }

        return 0;
    }
    
    @Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_BOUND;
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return ExAstrisRebirthData.MODID + "." + ExAstrisRebirthData.HAMMER_BOUND;
	}

}
