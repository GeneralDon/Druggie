package com.github.generaldon;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.github.generaldon.Commands.Main;
import com.github.generaldon.Commands.Cmds.Help;
import com.github.generaldon.Commands.Cmds.Test;
import com.github.generaldon.General.ConfigManager;

public class CommandHandler {
	//Colors
	private static final ChatColor RED=ChatColor.RED;
	//Commands
	private static List<Main> cmds=new ArrayList<Main>();
	//Player, selection associations
  //private static Map<CommandSender,Arena> selections=new HashMap<CommandSender,Arena>();

	public static void loadCommands(Druggie pl)
	{
		cmds.add(new Help());
		cmds.add(new Test());
	}
	public static void handleCommand(Druggie pl,CommandSender sender, String[] args)
	{
		//The command sent to the plugin
		String cmd=args[0];
		//New arguments
		String[] subArgs=new String[0];
		if(args.length!=0)
		{
			subArgs=new String[args.length-1];
			System.arraycopy(args,1,subArgs,0,subArgs.length);
		}
		//Check for the command
		for(Main c:cmds)
		{
			if(cmd.equalsIgnoreCase(c.cmd()))
			{
				if(subArgs.length>=c.numArgs())
				{
					String perm=c.permission();
					String[] permSplit=perm.split("\\.");
					String permGroup="";
					for(int x=0;x<permSplit.length-1;x++)
					{
						permGroup+=permSplit[x]+".";
					}
					permGroup+="*";
					if(sender.isOp()||sender.hasPermission(perm)
							||sender.hasPermission(permGroup)
							||sender.hasPermission("HBG.*")
					        ||(!ConfigManager.usingPlayerPerms()&&permSplit[1].equalsIgnoreCase("player")))
					{
						c.execute(sender,subArgs);
					}
					else
					{
						sender.sendMessage(RED+"Insufficient permissions!");
					}
				}
				else
				{
					sender.sendMessage(RED+"Incompatible arguments!");
				}
				return;
			}
		}
		sender.sendMessage(RED+"Not a valid command!");
	}
//	public static Map<CommandSender,Arena> getSelections()
//	{
//		return selections;
//	}
	public static List<Main> getCmds()
	{
		return cmds;
	}
}
