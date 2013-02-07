package com.mcdr.courtofjustice.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.mcdr.courtofjustice.CourtOfJustice;
import com.mcdr.courtofjustice.court.Court;
import com.mcdr.courtofjustice.court.CourtCase;
import com.mcdr.courtofjustice.court.CourtManager;

public class ArrestCommand extends BaseCommand{
	
	public static void process(){
		if(!checkPermission("coj.judge", false))
			return;
		
		if(args.length < 3){
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.GRAY + "Usage: " + ChatColor.WHITE + "/" + lbl + " arrest <player> <court name>.");
			return;
		}
		
		Player suspect = CourtOfJustice.server.getPlayer(args[1]);
		
		if(suspect == null){
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.GRAY + "Player " + ChatColor.GOLD + args[1] + ChatColor.GRAY + " is not online.");
			return;
		}
		
		CourtManager manager = new CourtManager();
		Court court = manager.getCourt(args[2]);
		
		if(court == null){
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.GRAY + "Court " + ChatColor.GOLD + args[2] + ChatColor.GRAY + " doesn't exist.");
			return;
		}
		
		//TODO Rest of arresting logic
	}

}
