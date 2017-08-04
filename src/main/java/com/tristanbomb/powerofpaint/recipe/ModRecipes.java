package com.tristanbomb.powerofpaint.recipe;

import com.tristanbomb.powerofpaint.EnumPaintTypes;
import com.tristanbomb.powerofpaint.item.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes {

	public static void init() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.waterbomb, 4), "ABA", "BCB", "ABA", 'A', "paper", 'B', "gemQuartz", 'C', new ItemStack(Items.WATER_BUCKET.setContainerItem(Items.BUCKET))));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.waterbomb, 4), "BAB", "ACA", "BAB", 'A', "paper", 'B', "gemQuartz", 'C', new ItemStack(Items.WATER_BUCKET.setContainerItem(Items.BUCKET))));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.paintbomb, 2, EnumPaintTypes.REPULSION.getMeta()), "ABA", "BCB", "ABA", 'A', "gemLapis", 'B', "slimeball", 'C', ModItems.waterbomb));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.paintbomb, 2, EnumPaintTypes.REPULSION.getMeta()), "BAB", "ACA", "BAB", 'A', "gemLapis", 'B', "slimeball", 'C', ModItems.waterbomb));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.paintbomb, 2, EnumPaintTypes.PROPULSION.getMeta()), "ABA", "BCB", "ABA", 'A', "dustRedstone", 'B', "dustGlowstone", 'C', ModItems.waterbomb));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.paintbomb, 2, EnumPaintTypes.PROPULSION.getMeta()), "BAB", "ACA", "BAB", 'A', "dustRedstone", 'B', "dustGlowstone", 'C', ModItems.waterbomb));
	}
	
}
