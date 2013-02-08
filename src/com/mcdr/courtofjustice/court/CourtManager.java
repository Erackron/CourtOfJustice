package com.mcdr.courtofjustice.court;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourtManager {
	private static Map<String, Court> courts = new HashMap<String, Court>();

	/**
	 * Get a mapping of all names and courts
	 * @return the court map
	 */
	public static Map<String, Court> getCourts() {
		return courts;
	}
	
	/**
	 * Get a list of all courts
	 * @return the court list
	 */
	public static List<Court> getCourtList(){
		List<Court> courtlist = new ArrayList<Court>();
		for(Court c: courts.values()){
			courtlist.add(c);
		}
		return courtlist;
	}
	
	/**
	 * Get a list of free courts
	 * @return the list containing inactive courts
	 */
	public static List<Court> getInactiveCourts(){
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
	public static List<Court> getActiveCourts(){
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
	public static Court getCourt(String name){
		if(name==null)
			return null;
		return courts.get(name.toLowerCase());
	}
	
	
	/**
	 * Add a court to the list
	 * @param court the court object to add
	 */
	public static void addCourt(Court court) {
		if(court!=null && court.getName()!=null)
			courts.put(court.getName().toLowerCase(), court);
			
	}
	
	/**
	 * Remove a court from the list
	 * @param the court to remove
	 * @return whether or not it previously existed
	 */
	public static boolean removeCourt(Court court){
		if(court==null||court.getName()==null)
			return false;
		return removeCourt(court.getName());
	}
	
	/**
	 * Remove a court from the list
	 * @param the name of the court to remove
	 * @return whether or not it previously existed
	 */
	public static boolean removeCourt(String name){
		if(name==null)
			return false;
		return (courts.remove(name.toLowerCase()) != null);
	}
	
	/**
	 * Clear the court list
	 */
	public static void clear(){
		courts.clear();
	}
}
