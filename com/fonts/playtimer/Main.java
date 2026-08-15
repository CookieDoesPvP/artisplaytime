package com.fonts.playtimer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;

public class Main extends JavaPlugin {
	TitleManagerAPI api;
	static Main ins;
		  
	public static Main getInstance() { return ins; }
		  
	public void onEnable() {
			  
        if( Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            //Registering placeholder will be use here
            new PlaceHolderHook().register();
        } 
	
	
	
	ins = this;
	getConfig().options().copyDefaults(true);
	saveConfig();
	getCommand("playtime").setExecutor(new PTCommand());
	
	}
		  
	 public void onDisable() {}

}
