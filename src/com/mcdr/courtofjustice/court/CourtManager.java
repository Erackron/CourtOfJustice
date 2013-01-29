package com.mcdr.courtofjustice.court;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourtManager {
	private Map<String, Court> courts = new HashMap<String, Court>();

	/**
	 * Get a mapping of all names and courts
	 * @return the court map
	 */
	public Map<String, Court> getCourts() {
		return courts;
	}
	
	/**
	 * Get a list of all courts
	 * @return the court list
	 */
	public List<Court> getCourtList(){
		List<Court> courts = new ArrayList<Court>();
		for(Court c: this.courts.values()){
			courts.add(c);
		}
		return courts;
	}
	
	/**
	 * Get a list of free courts
	 * @return the list containing inactive courts
	 */
	public List<Court> getInactiveCourts(){
		List<Court> courts = getCourtList();
		for(Court c: courts){
			if(c.getState()!=CourtState.INACTIVE)
				courts.remove(c);
		}
		return courts;
	}
	
	/**
	 * Get a list of active courts
	 * @return the list containing all courts currently active
	 */
	public List<Court> getActiveCourts(){
		List<Court> courts = getCourtList();
		for(Court c: courts){
			if(c.getState()==CourtState.INACTIVE)
				courts.remove(c);
		}
		return courts;
	}
	
	/**
	 * Get a court by name
	 * @param name the name of the court
	 * @return the court object belonging to the name, or null if no court with that name exists
	 */
	public Court getCourt(String name){
		if(name==null)
			return null;
		return courts.get(name.toLowerCase());
	}
	
	
	/**
	 * Add a court to the list
	 * @param court the court object to add
	 */
	public void addCourt(Court court) {
		if(court!=null && court.getName()!=null)
			this.courts.put(court.getName().toLowerCase(), court);
			
	}
	
	/**
	 * Remove a court from the list
	 * @param the court to remove
	 * @return whether or not it previously existed
	 */
	public boolean removeCourt(Court court){
		if(court==null||court.getName()==null)
			return false;
		return removeCourt(court.getName());
	}
	
	/**
	 * Remove a court from the list
	 * @param the name of the court to remove
	 * @return whether or not it previously existed
	 */
	public boolean removeCourt(String name){
		if(name==null)
			return false;
		return (this.courts.remove(name.toLowerCase()) != null);
	}
	
	/**
	 * Clear the court list
	 */
	public void clear(){
		this.courts.clear();
	}
}
