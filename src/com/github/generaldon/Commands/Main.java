package com.github.generaldon.Commands;

import org.bukkit.command.CommandSender;

import com.github.generaldon.General.ChatVariables;

public abstract class Main extends ChatVariables {
	public abstract void execute(CommandSender sender, String[] args);
	public abstract String cmd();
	public abstract String usage();
	public abstract String description();
	public abstract String permission();
	public abstract int numArgs();

}
