package com.mcdr.courtofjustice.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.mcdr.courtofjustice.player.CoJPlayerManager;
import com.mcdr.courtofjustice.utils.CoJUpdateChecker;
import com.mcdr.courtofjustice.utils.Utility;

public class CoJPlayerListener implements Listener {
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if(CoJUpdateChecker.updateNeeded() && Utility.hasPermission(player, "lab.update")){
			player.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + " New version available, version " + CoJUpdateChecker.lastVer);
			player.sendMessage(ChatColor.BLUE + "[CoJ] " + ChatColor.WHITE + " To update, use " + ChatColor.GREEN + "/coj update install");
		}
		CoJPlayerManager.AddCoJPlayer(player);
	}
	
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onPlayerQuit(PlayerQuitEvent event) {
		CoJPlayerManager.RemoveCoJPlayer(event.getPlayer());
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event){
		
	}
}
