package com.mcdr.courtofjustice.player;

public class CoJPlayerData {
	private boolean isJudge = false;
	private boolean isProsecutor = false;
	private boolean isSuspect = false;
	private boolean isJuryCandidate = false;
	private boolean isJuryMember = false;
	private boolean isSpectator = false;
	private boolean isSolicitor = false;
	private boolean isInvolved = false;
	
	public boolean isJudge() {
		return isJudge;
	}
	
	public boolean isProsecutor(){
		return isProsecutor;
	}

	public boolean isSuspect() {
		return isSuspect;
	}

	public boolean isJuryCandidate() {
		return isJuryCandidate;
	}
	
	public boolean isJuryMember() {
		return isJuryMember;
	}
	
	public boolean isSpectator() {
		return isSpectator;
	}
	
	public boolean isSolicitor() {
		return isSolicitor;
	}
	
	public boolean isInvolved(){
		return isInvolved;
	}
	
	/******************************************************************\
	 * The methods below shouldn't be called directly,                *
	 * instead call the methods in the CoJPlayer class,               *
	 * they include checks to see if an assignment is actually valid  *
	 * and also give output accordingly.                              *
	\******************************************************************/
	
	/**
	 * Dont use this method directly, instead use the setJudge method in the CoJPlayer class
	 * @param isJudge whether the player is a judge or not
	 */
	public void setJudge(boolean isJudge) {
		this.isJudge = isJudge;
	}
	
	/**
	 * Dont use this method directly, instead use the setProsecutor method in the CoJPlayer class
	 * @param isProsecutor whether the player is a public prosecutor or not
	 */
	public void setProsecutor(boolean isProsecutor) {
		this.isProsecutor = isProsecutor;
	}
	
	/**
	 * Dont use this method directly, instead use the setSuspect method in the CoJPlayer class
	 * @param isSuspect whether the player is a suspect or not
	 */
	public void setSuspect(boolean isSuspect) {
		this.isSuspect = isSuspect;
	}

	/**
	 * Dont use this method directly, instead use the setJuryCandidate method in the CoJPlayer class
	 * @param isJuryCandidate whether the player is a jury candidate or not
	 */
	public void setJuryCandidate(boolean isJuryCandidate) {
		this.isJuryCandidate = isJuryCandidate;
	}

	/**
	 * Dont use this method directly, instead use the setJuryMember method in the CoJPlayer class
	 * @param isJuryMember whether the player is a jury member or not
	 */
	public void setJuryMember(boolean isJuryMember) {
		this.isJuryMember = isJuryMember;
	}
	
	/**
	 * Dont use this method directly, instead use the setSpectator method in the CoJPlayer class
	 * @param isSpectator whether the player is a spectator or not
	 */
	public void setSpectator(boolean isSpectator) {
		this.isSpectator = isSpectator;
	}
	
	/**
	 * Dont use this method directly, instead use the setSpectator method in the CoJPlayer class
	 * @param isSolicitor whether the player is a solicitor or not
	 */
	public void setSolicitor(boolean isSolicitor){
		this.isSolicitor = isSolicitor;
	}
	
	/**
	 * Dont use this method directly, instead use any of the methods in the CoJPlayer class that have to do with involvement
	 * @param isInvolved whether the player is involved in a court case or not
	 */
	public void setInvolvement(boolean isInvolved) {
		this.isInvolved = isInvolved;
		if(!isInvolved){
			this.isJudge = false;
			this.isProsecutor = false;
			this.isJuryCandidate = false;
			this.isJuryMember = false;
			this.isSpectator = false;
			this.isSuspect = false;
		}
	}
}
