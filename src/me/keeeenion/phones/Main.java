package me.keeeenion.phones;

import java.io.File;
import java.io.IOException;

import me.keeeenion.phones.apps.Radio;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public final static String mainFolder = "plugins/Phones";
	public final static String appsFolder = "plugins/Phones/Apps";
	public final static String pluginPrefix = "[Phone] ";
	public static int menuCount;
	
	public void onEnable() {
		
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Radio(), this);
		
		File mainDir = new File(mainFolder);
		File menusDir = new File(appsFolder);
		//MAIN DIRECTORY
		if (!mainDir.exists()) {
			try {
				mainDir.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//APPS DIRECTORY for custom apps
		if (!menusDir.exists()) {
			try {
				mainDir.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//APPS COUNT
		File file = new File(appsFolder);
		int filecount = file.listFiles().length;
		menuCount = filecount;
		
	}
	
	public void onDisable() {
		
	}
	
}
