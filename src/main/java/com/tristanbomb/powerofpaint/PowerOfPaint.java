package com.tristanbomb.powerofpaint;

import com.tristanbomb.powerofpaint.proxy.CommonProxy;
import com.tristanbomb.powerofpaint.recipe.ModRecipes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PowerOfPaint.modId, name = PowerOfPaint.name, version = PowerOfPaint.version, acceptedMinecraftVersions = "[1.10.2]")

public class PowerOfPaint {

	public static final String modId = "powerofpaint";
	public static final String name = "Power Of Paint";
	public static final String version = "@VERSION@";
	public static final ModTab tab = new ModTab();
	
	@Mod.Instance(modId)
	public static PowerOfPaint instance;
	
	@SidedProxy(serverSide = "com.tristanbomb.powerofpaint.proxy.CommonProxy", clientSide = "com.tristanbomb.powerofpaint.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		// Pre-init! Item and block registry goes here.
		proxy.preInit();
	}
	
	@Mod.EventHandler
	public void midInit(FMLInitializationEvent event) {
		// Init! Recipe and oredict registry goes here.
		proxy.init();
		ModRecipes.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		// Post-init! Cross-mod compatibility goes here.
		proxy.postInit();
	}
	

}
