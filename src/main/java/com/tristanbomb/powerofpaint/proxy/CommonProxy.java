package com.tristanbomb.powerofpaint.proxy;

import com.tristanbomb.powerofpaint.block.ModBlocks;
import com.tristanbomb.powerofpaint.item.ModItems;

public class CommonProxy {
	public void preInit() {
		ModBlocks.init();
		ModItems.init();
	}
	public void init() {
		
	}	
	public void postInit() {
		
	}
}
