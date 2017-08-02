package com.tristanbomb.powerofpaint.block;

import com.tristanbomb.powerofpaint.PowerOfPaint;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PaintPropulsion extends Paint {
	
	public PaintPropulsion() {
		super();
        setUnlocalizedName(PowerOfPaint.modId + ".paintpropulsion");
        setRegistryName("paintpropulsion");
        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			double boost = 0.6;
			if (entityIn.isSprinting()) {
				boost = 0.8;
			}
			double theta = Math.atan2(entityIn.motionX, entityIn.motionZ);
			double speed = Math.sqrt(Math.pow(entityIn.motionX,2) + Math.pow(entityIn.motionZ,2));
			speed += boost * speed;
			entityIn.motionX = speed * Math.sin(theta);
			entityIn.motionZ = speed * Math.cos(theta);
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
}
