package com.tristanbomb.powerofpaint.item;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
	public static ItemPaintGun paintgun;
	public static ItemPaintbomb paintbomb;
	
	public static void init() {
		paintgun = new ItemPaintGun();
		paintbomb = new ItemPaintbomb();
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        paintgun.initModel();
        paintbomb.initModel();
    }
}
