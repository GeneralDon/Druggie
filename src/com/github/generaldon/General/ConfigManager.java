package com.github.generaldon.General;

import java.io.File;
import java.io.IOException;
import com.github.generaldon.Druggie;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;

public class ConfigManager {
	/*
	 * ConfigManager creates a config file for the plugin.
	 * Plugin preferences and options are set in this file.
	 * This file will be edited by the user in almost all cases.
	 */
	private static File configFile;
	private static FileConfiguration config;
	//Configuration Options
	//The displayed plugin prefix
	private static String prefix;
	//Whether plugin should use player group permissions
	private static boolean playerPerms;

	//Call onEnable for initialization
	public static void loadConfig(Druggie pl)
	{
		PluginDescriptionFile pdf=pl.getDescription();
		//Naming the file
		configFile=new File(pl.getDataFolder(),"config.yml");
		//Create if it doesn't exist
		if(!configFile.exists())
		{
			configFile.getParentFile().mkdirs();
			try {
				configFile.createNewFile();
				Druggie.logger.info("["+pdf.getName()+"] Generating config!");
			} catch (IOException wtf){
				wtf.printStackTrace();
			}
		}
		//Actually loading the file
		config=new YamlConfiguration();
		try {
			config.load(configFile);
			Druggie.logger.info("["+pdf.getName()+"] Loading config!");
		} catch (Exception wtf) {
			wtf.printStackTrace();
		}		

		//Check for missing config sections and set defaults
		if(config.options().header()==null)
		{
			config.options().header("Druggie Config File.\nGo to http://dev.bukkit.org/server-mods/hungerbargames/pages/configuration-tutorial/ for a tutorial.");
		}
		if(!config.contains("Prefix"))
		{
			config.createSection("Prefix");
			config.set("Prefix", "Druggie");
		}
		if(!config.contains("PlayerPerms"))
		{
			config.createSection("PlayerPerms");
			config.set("PlayerPerms", false);
		}
		saveConfig();

		//Load configuration options to memory
		prefix=ChatColor.BLUE+"["+ChatColor.YELLOW+config.getString("Prefix")+ChatColor.BLUE+"] "+ChatColor.WHITE;
		playerPerms=config.getBoolean("PlayerPerms");
	}
	//Get the config
	public static FileConfiguration getConfig()
	{
		return config;
	}
	//Save config
	public static void saveConfig()
	{
		try {
			config.save(configFile);
		} catch (IOException wtf) {
			wtf.printStackTrace();
		}
	}
	//Get the plugin's prefix
	public static String getPrefix()
	{
		return prefix;
	}
	public static boolean usingPlayerPerms()
	{
		return playerPerms;
	}
}