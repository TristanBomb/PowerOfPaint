package com.tristanbomb.powerofpaint.item;

import com.tristanbomb.powerofpaint.PowerOfPaint;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PaintGun extends Item {
			
	public PaintGun() {
		super();
		setUnlocalizedName(PowerOfPaint.modId + ".paintgun");
		setRegistryName("paintgun");
		
        GameRegistry.register(this);
		this.setCreativeTab(PowerOfPaint.tab);
	}
	
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
}
