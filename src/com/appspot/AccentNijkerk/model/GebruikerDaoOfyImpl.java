package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class GebruikerDaoOfyImpl implements GebruikerDao {
	Objectify ofy = ObjectifyService.begin();
	
	public GebruikerDaoOfyImpl() {
		//Default constructor
	}
	
	@Override
	public boolean voegGebruikerToe(Gebruiker g) {		
		if(getGebruiker(g.getGebruikersnaam()) == null) {
			ofy.put(g);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public ArrayList<Gebruiker> getAlleGebruikers() {
		Query<Gebruiker> query = ofy.query(Gebruiker.class);
		ArrayList<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		
		for(Gebruiker g : query) {
			alleGebruikers.add(g);
		}
		
		return alleGebruikers;
	}
	
	@Override
	public Gebruiker getGebruiker(String gebruikersnaam){
		Gebruiker result = null;
		Gebruiker leerling = (Gebruiker) ofy.query(Leerling.class).filter("gebruikersnaam", gebruikersnaam).get();
		Gebruiker medewerker = (Gebruiker) ofy.query(Medewerker.class).filter("gebruikersnaam", gebruikersnaam).get();
		Gebruiker stagebedrijf = (Gebruiker) ofy.query(StageBedrijf.class).filter("gebruikersnaam", gebruikersnaam).get();
		
		if(leerling != null)
			result = leerling;
		if(medewerker != null)
			result = medewerker;
		if(stagebedrijf != null)
			result = stagebedrijf;
		
		return result;
	}
	
	@Override
	public void updateGebruiker(Gebruiker g) {
		ofy.put(g);
	}
	
	@Override
	public void verwijderGebruiker(Gebruiker g) {
		ofy.delete(g);
	}
	
}
