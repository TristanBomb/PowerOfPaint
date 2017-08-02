package com.tristanbomb.powerofpaint.item;

import com.tristanbomb.powerofpaint.entity.EntityPaintbomb;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemPaintball extends Item
{
    public ItemPaintball()
    {
        this.setCreativeTab(CreativeTabs.MISC);
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack worldIn, World playerIn, EntityPlayer handIn, EnumHand p_77659_4_)
    {
        if (!handIn.capabilities.isCreativeMode)
        {
            --worldIn.stackSize;
        }

        playerIn.playSound((EntityPlayer)null, handIn.posX, handIn.posY, handIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!playerIn.isRemote)
        {
            EntityPaintbomb proj = new EntityPaintbomb(playerIn, handIn);
            proj.setHeadingFromThrower(handIn, handIn.rotationPitch, handIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            playerIn.spawnEntity(proj);
        }

        handIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, worldIn);
    }
}