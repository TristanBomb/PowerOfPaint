package com.tristanbomb.powerofpaint.block;

import com.tristanbomb.powerofpaint.PowerOfPaint;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PaintRepulsion extends Paint {
	
	public PaintRepulsion() {
		super();
        setUnlocalizedName(PowerOfPaint.modId + ".paintrepulsion");
        setRegistryName("paintrepulsion");
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
	}	

	@Override
	public void onLanded(World worldIn, Entity entityIn) {
		if(entityIn.motionY < -0.2f && entityIn instanceof EntityLivingBase) {
			double yvel = -1.2*entityIn.motionY;
			if (yvel < 0.8f) { yvel = 0.8f; }
			
			entityIn.fallDistance = 0;
			super.onLanded(worldIn, entityIn);
			
			if (!entityIn.isSneaking()) {
				entityIn.motionY = yvel;
				entityIn.playSound(SoundEvents.BLOCK_SLIME_BREAK, (float) yvel * 0.80f, (float) yvel);
				entityIn.playSound(SoundEvents.BLOCK_ANVIL_PLACE, (float) yvel * 0.05f, (float) yvel - 1);
				entityIn.motionX *= 4.0 * Math.pow(yvel,2);
				entityIn.motionZ *= 4.0 * Math.pow(yvel,2);
			}
			else {
				entityIn.playSound(SoundEvents.BLOCK_SLIME_BREAK, 0.4f, 0.0f);
				entityIn.playSound(SoundEvents.BLOCK_ANVIL_PLACE, 0.1f, -1.0f);}
		}
		else {super.onLanded(worldIn, entityIn);}
	}
	
}
