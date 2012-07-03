package com.github.generaldon.Commands.Cmds;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.generaldon.Druggie;
import com.github.generaldon.Commands.Main;
import com.github.generaldon.Drugs.Full;
import com.github.generaldon.General.ChatVariables;
import com.github.generaldon.General.ConfigManager;

public class ClearAddiction extends Main{
	
	@Override
	public void execute(CommandSender sender, String[] args)
	{
		Druggie.Addict.put(sender.getName(), Integer.valueOf(0));
	      Player p = (Player)sender;
	      p.sendMessage(ChatVariables.LANGUAGE_DATA[0]);
	}
	
	@Override
	public String cmd() {
		return "clean";
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
