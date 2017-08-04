package com.tristanbomb.powerofpaint.item;

import com.tristanbomb.powerofpaint.PowerOfPaint;
import com.tristanbomb.powerofpaint.entity.EntityWaterBomb;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWaterBomb extends Item
{
    public ItemWaterBomb()
    {
    	super();
		setUnlocalizedName(PowerOfPaint.modId + ".waterbomb");
		setRegistryName("waterbomb");
		
        GameRegistry.register(this);
        this.setCreativeTab(PowerOfPaint.tab);
    } 
    
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack stackIn, World worldIn, EntityPlayer playerIn, EnumHand p_77659_4_)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --stackIn.stackSize;
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            EntityWaterBomb proj = new EntityWaterBomb(worldIn, playerIn);
            proj.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(proj);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stackIn);
    }
}