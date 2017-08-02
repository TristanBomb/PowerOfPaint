package com.tristanbomb.powerofpaint.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	public static PaintGun paintGun;
	
	public static void init() {
		paintGun = new PaintGun();
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        paintGun.initModel();
    }
}
