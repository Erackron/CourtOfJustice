package com.mcdr.courtofjustice.command;

import org.bukkit.ChatColor;

import com.mcdr.courtofjustice.CourtOfJustice;

public abstract class HelpCommand extends BaseCommand {
	public static void process() {
		if (!checkPermission("coj.help", true))
			return;
		
		sender.sendMessage(ChatColor.BLUE + "["+CourtOfJustice.shortName+"] " + ChatColor.WHITE + "Commands list");
		sender.sendMessage("/" + lbl + " help: " + ChatColor.GRAY + "Show this help message.");
		sender.sendMessage("/" + lbl + " update <check/install>: " + ChatColor.GRAY + "Check for updates or install one if available.");
	}
}
