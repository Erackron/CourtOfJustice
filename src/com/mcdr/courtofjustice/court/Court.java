package com.mcdr.courtofjustice.court;

public class Court {
	private String name;
	private CourtState state = CourtState.INACTIVE;
	private CourtCase courtCase = null;
	
	public Court(String name){
		this.name = name;
	}
	
	/**
	 * Get the name of this court
	 * @return the name belonging to this court
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the current state of this court
	 * @return the current court state
	 */
	public CourtState getState() {
		return state;
	}

	/**
	 * Set the state of this court
	 * @param state the state the court is in
	 */
	public void setState(CourtState state) {
		this.state = state;
	}

	/**
	 * @return the courtCase
	 */
	public CourtCase getCase() {
		return courtCase;
	}

	/**
	 * Set a new case for this court, if it is not already active
	 * @param courtCase the courtCase to set
	 */
	public void setCase(CourtCase courtCase) {
		if(this.state==CourtState.INACTIVE)
			this.courtCase = courtCase;
	}

}
