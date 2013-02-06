package com.mcdr.courtofjustice.court;

import java.util.ArrayList;
import java.util.List;

import com.mcdr.courtofjustice.player.CoJPlayer;

public class CourtCase {
	private CoJPlayer judge = null;
	private CoJPlayer accused = null;
	private CoJPlayer prosecutor = null;
	private CoJPlayer solicitor = null;
	private List<CoJPlayer> jury = new ArrayList<CoJPlayer>();
	private List<CoJPlayer> juryCandidates = new ArrayList<CoJPlayer>();
	private List<CoJPlayer> spectators = new ArrayList<CoJPlayer>();
	
	public CourtCase(CoJPlayer judge, CoJPlayer accused){
		this.judge = judge;
		this.accused = accused;
		//use this constructor only when you set the court to the detention on remand state
	}
	
	/**
	 * @return the judge of this court
	 */
	public CoJPlayer getJudge() {
		return judge;
	}

	/**
	 * @param judge the judge to set
	 */
	public void setJudge(CoJPlayer judge) {
		this.judge = judge;
	}

	/**
	 * @return the accused
	 */
	public CoJPlayer getAccused() {
		return accused;
	}

	/**
	 * @param accused the accused to set
	 */
	public void setAccused(CoJPlayer accused) {
		this.accused = accused;
	}

	/**
	 * @return the prosecutor
	 */
	public CoJPlayer getProsecutor() {
		return prosecutor;
	}

	/**
	 * @param prosecutor the prosecutor to set
	 */
	public void setProsecutor(CoJPlayer prosecutor) {
		this.prosecutor = prosecutor;
	}
	
	/**
	 * @return the solicitor
	 */
	public CoJPlayer getSolicitor() {
		return solicitor;
	}
	
	/** 
	 * @param solicitor the solicitor to set
	 */
	public void setSolicitor(CoJPlayer solicitor) {
		this.solicitor = solicitor;
	}

	/**
	 * @return the jury
	 */
	public List<CoJPlayer> getJury() {
		return jury;
	}

	/**
	 * @param jury the jury to set
	 */
	public void setJury(List<CoJPlayer> jury) {
		this.jury = jury;
	}
	
	/**
	 * @param juryMember the jurymember to add
	 */
	public void addJuryMember(CoJPlayer juryMember){
		jury.add(juryMember);
	}

	/**
	 * @return the juryCandidates
	 */
	public List<CoJPlayer> getJuryCandidates() {
		return juryCandidates;
	}

	/**
	 * @param juryCandidates the juryCandidates to set
	 */
	public void setJuryCandidates(List<CoJPlayer> juryCandidates) {
		this.juryCandidates = juryCandidates;
	}
	
	/** 
	 * @param juryCandidate the jurycandidate to add
	 */
	public void addJuryCandidate(CoJPlayer juryCandidate){
		juryCandidates.add(juryCandidate);
	}

	/**
	 * @return the spectators
	 */
	public List<CoJPlayer> getSpectators() {
		return spectators;
	}

	/**
	 * @param spectators the spectators to set
	 */
	public void setSpectators(List<CoJPlayer> spectators) {
		this.spectators = spectators;
	}
	
	/**
	 * @param spectator the spectator to add
	 */
	public void addSpectator(CoJPlayer spectator){
		spectators.add(spectator);
	}
}
