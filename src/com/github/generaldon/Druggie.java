package com.github.generaldon;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;

import com.github.generaldon.General.ConfigManager;

public class Druggie extends JavaPlugin {
	
	public static Druggie plugin;
	
    public static final Logger logger=Logger.getLogger("Minecraft");
    
    public Map<String, Integer> Addict = new HashMap<String, Integer>();
    
	@Override
    public void onEnable(){
    	try {
    	      this.Addict = ((HashMap)SLAPI.load("Stimulatory.DAT"));
    	    } catch (Exception localException) {
    	    }
    	
    	plugin=this;
    	
    	PluginDescriptionFile pdf = getDescription();
    	ConfigManager.loadConfig(this);
            logger.info("Druggie version "+pdf.getVersion()+" enabled sucessfully!");
            CommandHandler.loadCommands(this);
    }
   
    @Override
    public void onDisable(){
    		PluginDescriptionFile pdf = getDescription();
            logger.info("Druggie version "+pdf.getVersion()+" disabled sucessfully!");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("drugg"))
		{
			if(args.length>0)
			{
				CommandHandler.handleCommand(this,sender,args);
			}
			else
			{
				ChatColor YELLOW=ChatColor.YELLOW;
				ChatColor BLUE=ChatColor.BLUE;
				ChatColor GREEN=ChatColor.GREEN;
				sender.sendMessage(YELLOW+"Druggie version "+BLUE+getDescription().getVersion()+YELLOW+".");
				sender.sendMessage(YELLOW+"Made by "+GREEN+"GeneralDon"+YELLOW+"!");
				sender.sendMessage(YELLOW+"Type "+BLUE+"/drugg help"+YELLOW+" for Druggie commands!");
			}
		}
		return true;
	}

}
