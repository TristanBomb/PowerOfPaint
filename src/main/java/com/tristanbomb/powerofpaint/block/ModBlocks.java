package com.tristanbomb.powerofpaint.block;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
	public static PaintRepulsion paintRepulsion;
	public static PaintPropulsion paintPropulsion;
	
	public static void init() {
		paintRepulsion = new PaintRepulsion();
		paintPropulsion = new PaintPropulsion();
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() {
        paintRepulsion.initModel();
        paintPropulsion.initModel();
    }
}
