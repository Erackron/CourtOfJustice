package com.mcdr.courtofjustice.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.mcdr.courtofjustice.CourtOfJustice;
import com.mcdr.courtofjustice.court.Court;
import com.mcdr.courtofjustice.court.CourtManager;
import com.mcdr.courtofjustice.player.CoJPlayer;

public class ArrestCommand extends BaseCommand{
	
	public static void process(){
		if(!checkPermission("coj.judge", false))
			return;

		CoJPlayer cojJudge = new CoJPlayer((Player) sender);
		
		if(cojJudge.getPlayerData().isInvolved()){
			sender.sendMessage(ChatColor.BLUE + "["+CourtOfJustice.shortName+"] " + ChatColor.GRAY + "You are already involved in a case!");
			return;
		}
		
		if(args.length < 3){
			sender.sendMessage(ChatColor.BLUE + "["+CourtOfJustice.shortName+"] " + ChatColor.GRAY + "Usage: " + ChatColor.WHITE + "/" + lbl + " arrest <player> <court name>.");
			return;
		}
		
		Player suspect = CourtOfJustice.in.getServer().getPlayer(args[1]);
		
		if(suspect == null){
			sender.sendMessage(ChatColor.BLUE + "["+CourtOfJustice.shortName+"] " + ChatColor.GRAY + "Player " + ChatColor.GOLD + args[1] + ChatColor.GRAY + " is not online.");
			return;
		}
		
		if(suspect.equals((Player) sender)){
			sender.sendMessage(ChatColor.BLUE + "["+CourtOfJustice.shortName+"] " + ChatColor.GRAY + "You can't arrest yourself.");
			return;
		}
		
		CoJPlayer cojSuspect = new CoJPlayer(suspect);
		
		if(cojSuspect.getPlayerData().isInvolved()){
			sender.sendMessage(ChatColor.BLUE + "["+CourtOfJustice.shortName+"] " + ChatColor.GRAY + "Player " + ChatColor.GOLD + args[1] + ChatColor.GRAY + " is already involved in a case!");
			return;
		}
		
		Court court = CourtManager.getCourt(args[2]);
		
		if(court == null){
			sender.sendMessage(ChatColor.BLUE + "["+CourtOfJustice.shortName+"] " + ChatColor.GRAY + "Court " + ChatColor.GOLD + args[2] + ChatColor.GRAY + " doesn't exist.");
			return;
		}	
		
		//TODO Rest of arresting logic
	}

}
