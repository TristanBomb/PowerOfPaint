package com.tristanbomb.powerofpaint.item;

import java.util.List;

import com.tristanbomb.powerofpaint.EnumPaintTypes;
import com.tristanbomb.powerofpaint.PowerOfPaint;
import com.tristanbomb.powerofpaint.entity.EntityPaintbomb;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPaintbomb extends Item
{
    public ItemPaintbomb()
    {
    	super();
    	this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		setUnlocalizedName(PowerOfPaint.modId + ".paintbomb");
		setRegistryName("paintbomb");
		
        GameRegistry.register(this);
        this.setCreativeTab(PowerOfPaint.tab);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        int meta = stack.getMetadata();
        return super.getUnlocalizedName() + "." + EnumPaintTypes.getByMeta(meta).getName();
    }   
    
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelResourceLocation[] modelList = new ModelResourceLocation[EnumPaintTypes.values().length];
		
		for (EnumPaintTypes enumPaintType : EnumPaintTypes.values()) {
			modelList[enumPaintType.getMeta()] = new ModelResourceLocation(getRegistryName() + "_" + enumPaintType.getName(), "inventory");
			ModelBakery.registerItemVariants(this, modelList[enumPaintType.getMeta()]);
		}
		
		ModelLoader.setCustomMeshDefinition(this, stack -> {
			return modelList[stack.getMetadata()];
		});
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
            EntityPaintbomb proj = new EntityPaintbomb(worldIn, playerIn, stackIn.getMetadata());
            proj.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(proj);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stackIn);
    }
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (int i = 0; i < 2; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}