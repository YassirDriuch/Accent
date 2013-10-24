package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class GebruikerDaoOfyImpl implements GebruikerDao {
	Objectify ofy = ObjectifyService.begin();
	ArrayList<Gebruiker> gebruikers;
	
	public GebruikerDaoOfyImpl() {
		gebruikers = new ArrayList<Gebruiker>();
	}
	
	@Override
	public void voegGebruikerToe(Gebruiker g){
		ofy.put(g);
	}
	
	public ArrayList<Gebruiker> alleGebruikers(){
		return gebruikers;
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
