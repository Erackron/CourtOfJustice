package com.mcdr.courtofjustice.player;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.mcdr.courtofjustice.utils.Utility;

public class CoJPlayer {
	private OfflinePlayer player;
	private CoJPlayerData playerData;
	
	public CoJPlayer(OfflinePlayer player) {
		this.player = player;
		this.setPlayerData(new CoJPlayerData());
	}

	public Player getPlayer() {
		return player.getPlayer();
	}
	
	public String getName(){
		return player.getName();
	}
	
	public CoJPlayerData getPlayerData() {
		return playerData;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setPlayerData(CoJPlayerData playerData) {
		this.playerData = playerData;
	}
	
	public boolean setJudge(boolean isJudge){
		if(isJudge){
			if(player.getPlayer()!=null && Utility.hasPermission(player.getPlayer(), "coj.judge") && !playerData.isInvolved()){
				playerData.setInvolvement(true);
				playerData.setJudge(true);
			} else
				return false;
		} else {
			if(playerData.isJudge())
				playerData.setInvolvement(false);
			else
				return false;
		}
		return true;
	}
	
	public boolean setProsecutor(boolean isProsecutor){
		if(isProsecutor){
			if(player.getPlayer()!=null && Utility.hasPermission(player.getPlayer(), "coj.prosecute") && !playerData.isInvolved()){
				playerData.setInvolvement(true);
				playerData.setProsecutor(true);
			} else
				return false;
		} else {
			if(playerData.isProsecutor())
				playerData.setInvolvement(false);
			else
				return false;
		}
		return true;
	}
	
	public boolean setJuryCandidate(boolean isJuryCandidate){
		if(isJuryCandidate){
			if(player.getPlayer()!=null && Utility.hasPermission(player.getPlayer(), "coj.jury") && !playerData.isInvolved()){
				playerData.setInvolvement(true);
				playerData.setJuryCandidate(true);
			} else
				return false;
		} else {
			if(playerData.isJuryCandidate())
				playerData.setInvolvement(false);
			else
				return false;
		}
		return true;
	}
	
	public boolean setJuryMember(boolean isJuryMember){
		if(isJuryMember){
			if(player.getPlayer()!=null && playerData.isJuryMember()){
				playerData.setJuryMember(true);
				playerData.setJuryCandidate(false);
			} else
				return false;
		} else {
			if(playerData.isJuryMember())
				playerData.setInvolvement(false);
			else
				return false;
		}
		return true;
	}
	
	public boolean setSuspect(boolean isSuspect){
		if(isSuspect){
			if(player.getPlayer()!=null){
				playerData.setInvolvement(false);
				playerData.setSuspect(true);
			} else
				return false;
		} else {
			if(playerData.isSuspect())
				playerData.setInvolvement(false);
			else
				return false;
		}
		return true;
	}
	
	public boolean setSpectator(boolean isSpectator){
		if(isSpectator){
			if(player.getPlayer()!=null && Utility.hasPermission(player.getPlayer(), "coj.spectate")){
				if(!playerData.isInvolved()){
					playerData.setInvolvement(true);
					playerData.setSpectator(true);
				} else if(playerData.isJuryCandidate()){
					playerData.setJuryCandidate(false);
					playerData.setSpectator(true);
				} else
					return false;
			} else
				return false;
		} else {
			if(playerData.isSpectator())
				playerData.setInvolvement(false);
			else
				return false;
		}
		return true;
	}
	
	public boolean setSolicitor(boolean isSolicitor){
		if(isSolicitor){
			if(player.getPlayer()!=null && Utility.hasPermission(player.getPlayer(), "coj.solicit") && !playerData.isInvolved()){
				playerData.setInvolvement(true);
				playerData.setSolicitor(true);
				} else
					return false;
			} else {
				if(playerData.isSolicitor())
					playerData.setInvolvement(false);
				else
					return false;
		}
		return true;
	}
}
