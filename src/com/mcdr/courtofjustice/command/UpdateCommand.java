package com.mcdr.courtofjustice.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.mcdr.courtofjustice.CourtOfJustice;
import com.mcdr.courtofjustice.utils.CoJAutoUpdater;
import com.mcdr.courtofjustice.utils.CoJUpdateChecker;

public class UpdateCommand extends BaseCommand {
	public static void process(){
		if (!checkPermission("coj.update", true))
			return;
		
		if(args.length < 2){
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.GRAY + "Usage: " + ChatColor.WHITE + "/coj update <check/install>.");
			return;
		}
		String arg = args[1].toLowerCase();
		if(arg.equalsIgnoreCase("c")||arg.equalsIgnoreCase("check"))
			checkCommand();
		else if(arg.equalsIgnoreCase("i")||arg.equalsIgnoreCase("install"))
			installCommand();
		return;
	}
	
	private static void checkCommand(){
		if(CoJUpdateChecker.updateNeeded()){
			String lastVer = CoJUpdateChecker.getLastVersion();
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "New version available, version " + ChatColor.GRAY +lastVer);
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "To update, use " + ChatColor.GREEN + "/lab update install");
		} else {
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "No update needed, running the latest version (" + ChatColor.GRAY + CourtOfJustice.in.getDescription().getVersion() + ChatColor.WHITE + ")");
		}
	}
	
	private static void installCommand(){
		if(!CoJUpdateChecker.updateNeeded()){
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "No update needed, running the latest version (" + ChatColor.GRAY + CourtOfJustice.in.getDescription().getVersion() + ChatColor.WHITE + ")");
			return;
		}
		//If something went wrong, return. Errors will be handled in the CoJUpdateChecker class
		if(CoJUpdateChecker.timeStamp==-1)
			return;
		
		//Get the download Url
		CoJAutoUpdater.getDownloadUrl();
		
		//If something went wrong, return. Errors will be handled in the CoJAutoUpdater class
		if(CoJAutoUpdater.timeStamp==-1)
			return;
		
		if(CoJAutoUpdater.update())
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "Updated successfully.");
		else {
			sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "Update failed.");
			if(sender instanceof Player)
				sender.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + "Check the console/logs for more information.");
		}
	}
}
