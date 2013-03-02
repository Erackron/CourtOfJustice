package com.mcdr.courtofjustice.player;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.mcdr.courtofjustice.player.CoJPlayerData.PlayerInvolvement;

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
			if(player.getPlayer()!=null && PlayerInvolvement.JUDGE.hasPermission(player.getPlayer()) && !playerData.isInvolved()){
				playerData.setInvolvement(PlayerInvolvement.JUDGE);
			} else
				return false;
		} else {
			if(playerData.isJudge())
				playerData.setInvolvement(PlayerInvolvement.NONE);
			else
				return false;
		}
		return true;
	}
	
	public boolean setProsecutor(boolean isProsecutor){
		if(isProsecutor){
			if(player.getPlayer()!=null && PlayerInvolvement.PROSECUTOR.hasPermission(player.getPlayer()) && !playerData.isInvolved()){
				playerData.setInvolvement(PlayerInvolvement.PROSECUTOR);
			} else
				return false;
		} else {
			if(playerData.isProsecutor())
				playerData.setInvolvement(PlayerInvolvement.NONE);
			else
				return false;
		}
		return true;
	}
	
	public boolean setJuryCandidate(boolean isJuryCandidate){
		if(isJuryCandidate){
			if(player.getPlayer()!=null && PlayerInvolvement.JURYCANDIDATE.hasPermission(player.getPlayer()) && !playerData.isInvolved()){
				playerData.setInvolvement(PlayerInvolvement.JURYCANDIDATE);
			} else
				return false;
		} else {
			if(playerData.isJuryCandidate())
				playerData.setInvolvement(PlayerInvolvement.NONE);
			else
				return false;
		}
		return true;
	}
	
	public boolean setJuryMember(boolean isJuryMember){
		if(isJuryMember){
			if(player.getPlayer()!=null && playerData.isJuryMember()){
				playerData.setInvolvement(PlayerInvolvement.JURYMEMBER);
			} else
				return false;
		} else {
			if(playerData.isJuryMember())
				playerData.setInvolvement(PlayerInvolvement.NONE);
			else
				return false;
		}
		return true;
	}
	
	public boolean setSuspect(boolean isSuspect){
		if(isSuspect){
			if(player.getPlayer()!=null){
				playerData.setInvolvement(PlayerInvolvement.SUSPECT);
			} else
				return false;
		} else {
			if(playerData.isSuspect())
				playerData.setInvolvement(PlayerInvolvement.NONE);
			else
				return false;
		}
		return true;
	}
	
	public boolean setSpectator(boolean isSpectator){
		if(isSpectator){
			if(player.getPlayer()!=null && PlayerInvolvement.SPECTATOR.hasPermission(player.getPlayer())){
				if(!playerData.isInvolved() || playerData.isJuryCandidate()){
					playerData.setInvolvement(PlayerInvolvement.SPECTATOR);
				} else
					return false;
			} else
				return false;
		} else {
			if(playerData.isSpectator())
				playerData.setInvolvement(PlayerInvolvement.NONE);
			else
				return false;
		}
		return true;
	}
	
	public boolean setSolicitor(boolean isSolicitor){
		if(isSolicitor){
			if(player.getPlayer()!=null && PlayerInvolvement.SOLICITOR.hasPermission(player.getPlayer()) && !playerData.isInvolved()){
				playerData.setInvolvement(PlayerInvolvement.SOLICITOR);
			} else
				return false;
		} else {
			if(playerData.isSolicitor())
				playerData.setInvolvement(PlayerInvolvement.NONE);
			else
				return false;
		}
		return true;
	}
}
