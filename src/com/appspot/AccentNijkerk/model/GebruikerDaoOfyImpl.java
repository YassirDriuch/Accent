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
		if(isBezet(g.getGebruikersnaam()) == true) {
			return false; //Niet toegevoegd
		} else {
			ofy.put(g);
			return true; //Toegevoegd
		}
	}
	
	@Override
	public void updateGebruiker(Gebruiker g) {
		ofy.put(g);
	}
	
	@Override
	public void verwijderGebruiker(Gebruiker g) {
		ofy.delete(g);
	}
	
	@Override
	public boolean isBezet(String gebruikersnaam) {
		boolean isBezet = false;
		
		//Alle gebruikers doorlopen
		for(Gebruiker g : getAlleGebruikers()) {
			//Gebruikersnaam vergelijken
			if(g.getGebruikersnaam().equals(gebruikersnaam)) {
				isBezet = true;
			}
		}
		
		return isBezet;
	}
	
	@Override
	public Gebruiker getGebruiker(Long id) {
		Gebruiker result = null;
		Gebruiker leerling = ofy.get(Leerling.class, id);
		Gebruiker medewerker = ofy.get(Medewerker.class, id);
		Gebruiker stagebedrijf = ofy.get(StageBedrijf.class, id);

		//Gebruiker instantie returnen
		if(leerling != null) {
			result = leerling;
		} else if(medewerker != null) {
			result = medewerker;
		} else if(stagebedrijf != null) {
			result = stagebedrijf;
		}
		
		return result;
	}
	
	@Override
	public ArrayList<Gebruiker> getAlleGebruikers() {
		ArrayList<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
		Query<Medewerker> alleMedewerkers = ofy.query(Medewerker.class);
		Query<StageBedrijf> alleStageBedrijven = ofy.query(StageBedrijf.class);
		
		for(Gebruiker g : alleLeerlingen) {
			alleGebruikers.add(g);
		}
		
		for(Gebruiker g : alleMedewerkers) {
			alleGebruikers.add(g);
		}
		
		for(Gebruiker g : alleStageBedrijven) {
			alleGebruikers.add(g);
		}

		return alleGebruikers;
	}
}
