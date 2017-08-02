package com.tristanbomb.powerofpaint;

import com.tristanbomb.powerofpaint.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = PowerOfPaint.modId, name = PowerOfPaint.name, version = PowerOfPaint.version, acceptedMinecraftVersions = "[1.10.2]")

public class PowerOfPaint {

	public static final String modId = "powerofpaint";
	public static final String name = "Power Of Paint";
	public static final String version = "prealpha";
	public static final ModTab tab = new ModTab();
	
	@Mod.Instance(modId)
	public static PowerOfPaint instance;
	
	@SidedProxy(serverSide = "com.tristanbomb.powerofpaint.proxy.CommonProxy", clientSide = "com.tristanbomb.powerofpaint.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit();
		System.out.println(name + " has entered pre-init! Item and block registry goes here.");
	}
	
	@Mod.EventHandler
	public void midInit(FMLInitializationEvent event) {
		proxy.init();
		System.out.println(name + " has entered mid-init! Recipe and oredict registry goes here.");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
		System.out.println(name + " has entered post-init! Cross-mod compatiblity goes here.");
	}
	

}
