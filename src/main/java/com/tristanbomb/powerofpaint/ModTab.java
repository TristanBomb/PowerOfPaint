package com.tristanbomb.powerofpaint;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.tristanbomb.powerofpaint.item.ModItems;

public class ModTab extends CreativeTabs {

	public ModTab() {
		super(PowerOfPaint.modId);
	}
	
	@Override
	public Item getTabIconItem() {
		return ModItems.paintGun;
	}

}
