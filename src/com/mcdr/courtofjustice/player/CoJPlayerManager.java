package com.mcdr.courtofjustice.player;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.mcdr.courtofjustice.CourtOfJustice;

public class CoJPlayerManager {
	private static Map<String, CoJPlayer> cojPlayers = new HashMap<String, CoJPlayer>();
	private static Map<String, CoJPlayer> offlineCojPlayers = new HashMap<String, CoJPlayer>();
	
	public static void AddOnlinePlayers() {
		Player[] players = CourtOfJustice.in.getServer().getOnlinePlayers();
		
		for (Player player : players)
			AddCoJPlayer(player);
	}
	
	public static CoJPlayer AddCoJPlayer(Player player) {
		String playerName = player.getName().toLowerCase();
		if(offlineCojPlayers.containsKey(playerName))
			cojPlayers.put(playerName, offlineCojPlayers.remove(playerName));
		
		if(cojPlayers.containsKey(playerName))
			return cojPlayers.get(playerName);
		
		CoJPlayer cojPlayer = new CoJPlayer(player);
		cojPlayers.put(playerName, cojPlayer);
		return cojPlayer;
	}

	public static void RemoveCoJPlayer(Player player) {
		String playerName = player.getName().toLowerCase();
		if(cojPlayers.containsKey(playerName))
			offlineCojPlayers.put(playerName, cojPlayers.remove(playerName));
	}

}
