package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

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
	
	public ArrayList getAntwoordenCP(Long competentieLijstId){
		ArrayList<Antwoord> alleAntwoordenCP = new ArrayList<Antwoord>();
		return null;
	}
}

