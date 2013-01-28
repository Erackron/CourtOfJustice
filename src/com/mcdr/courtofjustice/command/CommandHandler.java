package com.mcdr.courtofjustice.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		BaseCommand.processed = false;
		BaseCommand.sender = sender;
		BaseCommand.args = args;
		BaseCommand.lbl = lbl;
		
		String firstArg = args.length > 0?args[0].toLowerCase():"help";
		
		if(firstArg.equalsIgnoreCase("help"))
			HelpCommand.Process();
		
		
		return BaseCommand.processed;
	}

}
