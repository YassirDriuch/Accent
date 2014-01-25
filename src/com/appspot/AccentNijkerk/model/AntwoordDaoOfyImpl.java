package com.appspot.AccentNijkerk.model;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class AntwoordDaoOfyImpl implements AntwoordDao{
	Objectify ofy = ObjectifyService.begin();
	
	public AntwoordDaoOfyImpl(){
		//Default constructor
	}
	
	public void voegAntwoordToe(Antwoord a){
		ofy.put(a);
	}
	
	public void updateAntwoord(Antwoord a){
		ofy.put(a);
	}
	
	public void verwijderAntwoord(Antwoord a){
		ofy.delete(a);
	}

	public Antwoord getAntwoord(Long id){
		return ofy.find(Antwoord.class, id);
	}
}

