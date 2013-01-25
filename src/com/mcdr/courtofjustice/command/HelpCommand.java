package com.mcdr.courtofjustice.command;

import org.bukkit.ChatColor;

public abstract class HelpCommand extends BaseCommand {
	public static void Process() {
		if (!CheckPermission("coj.help", true))
			return;
		
		sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "Commands list");
		sender.sendMessage("/coj help: " + ChatColor.GRAY + "Show this help message.");
		sender.sendMessage("/coj update <check/install>: " + ChatColor.GRAY + "Check for updates or install one if available.");
	}
}
