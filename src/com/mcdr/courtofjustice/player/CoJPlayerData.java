package com.mcdr.courtofjustice.player;

import org.bukkit.entity.Player;

import com.mcdr.courtofjustice.utils.Utility;

public class CoJPlayerData {
	public static enum PlayerInvolvement {
		JUDGE("coj.judge"),
		PROSECUTOR("coj.prosecute"),
		SUSPECT,
		JURYCANDIDATE("coj.jury"),
		JURYMEMBER("coj.jury"),
		SPECTATOR("coj.spectate"),
		SOLICITOR("coj.solicitor"),
		NONE;
		
		private final String PERM_NODE;
		
		PlayerInvolvement(){
			this.PERM_NODE = null;
		}
		
		PlayerInvolvement(String permissionNode){
			this.PERM_NODE = permissionNode;
		}

		public String getPermissionNode() {
			return PERM_NODE;
		}
		
		public boolean hasPermission(Player player){
			return (PERM_NODE==null)?true:Utility.hasPermission(player, PERM_NODE);
		}
	}
	
	private PlayerInvolvement playerInvolvement = PlayerInvolvement.NONE;
	
	public boolean isJudge() {
		return playerInvolvement==PlayerInvolvement.JUDGE;
	}
	
	public boolean isProsecutor(){
		return playerInvolvement==PlayerInvolvement.PROSECUTOR;
	}

	public boolean isSuspect() {
		return playerInvolvement==PlayerInvolvement.SUSPECT;
	}

	public boolean isJuryCandidate() {
		return playerInvolvement==PlayerInvolvement.JURYCANDIDATE;
	}
	
	public boolean isJuryMember() {
		return playerInvolvement==PlayerInvolvement.JURYMEMBER;
	}
	
	public boolean isSpectator() {
		return playerInvolvement==PlayerInvolvement.SPECTATOR;
	}
	
	public boolean isSolicitor() {
		return playerInvolvement==PlayerInvolvement.SOLICITOR;
	}
	
	public boolean isInvolved(){
		return playerInvolvement==PlayerInvolvement.NONE;
	}
	
	/******************************************************************\
	 * The method below shouldn't be called directly,                *
	 * instead call the methods in the CoJPlayer class,               *
	 * they include checks to see if an assignment is actually valid  *
	 * and also give output accordingly.                              *
	\******************************************************************/
	
	/**
	 * Dont use this method directly, instead use the setJudge method in the CoJPlayer class
	 * @param isJudge whether the player is a judge or not
	 */
	public void setInvolvement(PlayerInvolvement playerInvolvement) {
		this.playerInvolvement = playerInvolvement;
	}
}