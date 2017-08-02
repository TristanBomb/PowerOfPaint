package com.tristanbomb.powerofpaint.proxy;

import com.tristanbomb.powerofpaint.block.ModBlocks;
import com.tristanbomb.powerofpaint.item.ModItems;

public class ClientProxy extends CommonProxy {
	public void preInit() {
		super.preInit();
		ModBlocks.initModels();
		ModItems.initModels();
	}
	public void init() {
		
	}	
	public void postInit() {
		
	}
}
