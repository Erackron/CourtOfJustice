package com.mcdr.courtofjustice.court;

import java.util.HashMap;
import java.util.Map;

public enum CourtState {
	INACTIVE("Inactive"),
	JURY_SELECTION("JurySelection"),
	IN_SESSION("InSession"),
	JUDGEMENT("Judgement");
	
	private String name;
	
	private static final Map<String, CourtState> NAME_MAP = new HashMap<String, CourtState>();
	
	static{
		for(CourtState state: values())
			if(state.name != null)
				NAME_MAP.put(state.name.toLowerCase(), state);
	}
	
	CourtState(String name){
		this.name= name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static CourtState getByName(String name){
		if(name == null)
			return null;
		return NAME_MAP.get(name.toLowerCase());
	}
	
}
