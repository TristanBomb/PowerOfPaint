package com.tristanbomb.powerofpaint;

import com.tristanbomb.powerofpaint.block.ModBlocks;
import com.tristanbomb.powerofpaint.block.Paint;

public enum EnumPaintTypes {
	REPULSION(0, "repulsion", "blue", ModBlocks.paintRepulsion),
	PROPULSION(1, "propulsion", "orange", ModBlocks.paintPropulsion);
	
	private static final EnumPaintTypes[] META_LOOKUP = new EnumPaintTypes[values().length];
	private final int meta;
	private final String name;
	private final String color;
	private final Paint paint;
	
	EnumPaintTypes(int meta, String name, String color, Paint paint) {
		this.meta = meta;
		this.name = name;
		this.color = color;
		this.paint = paint;
	}
	
	static {
		for (EnumPaintTypes enumPaintType : values()) {
			META_LOOKUP[enumPaintType.getMeta()] = enumPaintType;
		}
	}
	
	public static EnumPaintTypes getByMeta(int meta) {
		if (meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }
		return META_LOOKUP[meta];
	}

	public int getMeta() {
		return meta;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public Paint getPaint() {
		return paint;
	}
}
