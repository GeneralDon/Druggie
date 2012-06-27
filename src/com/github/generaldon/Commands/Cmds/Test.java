package com.github.generaldon.Commands.Cmds;

import org.bukkit.command.CommandSender;

import com.github.generaldon.Commands.Main;

public class Test extends Main{
	
	@Override
	public void execute(CommandSender sender, String[] args)
	{
		sender.sendMessage(GREEN+"End of help");
	}
	
	@Override
	public String cmd() {
		return "test";
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
