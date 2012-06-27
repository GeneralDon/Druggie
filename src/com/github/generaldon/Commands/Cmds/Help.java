package com.github.generaldon.Commands.Cmds;

import com.github.generaldon.CommandHandler;
import com.github.generaldon.Commands.Main;
import com.github.generaldon.General.ConfigManager;

import org.bukkit.command.CommandSender;

public class Help extends Main{

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		sender.sendMessage(GREEN+"Druggie Commands:");
		for(Main c:CommandHandler.getCmds())
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
					||sender.hasPermission("Druggie.*")
				    ||(!ConfigManager.usingPlayerPerms()&&permSplit[1].equalsIgnoreCase("player")))
			{
				sender.sendMessage(BLUE+"/drugg "+c.usage()+YELLOW+" - "+c.description());
			}
		}
		sender.sendMessage(GREEN+"End of help");
	}

	@Override
	public String cmd() {
		return "help";
	}

	@Override
	public String usage() {
		return cmd();
	}

	@Override
	public String description() {
		return "shows help";
	}

	@Override
	public String permission() {
		return "Druggie.drug.help";
	}

	@Override
	public int numArgs() {
		return 0;
	}

}