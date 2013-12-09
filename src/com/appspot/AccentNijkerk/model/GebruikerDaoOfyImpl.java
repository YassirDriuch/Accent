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
		boolean result = false;
		
		/*for(Gebruiker g : getAlleGebruikers()) {
			if(g.getGebruikersnaam().equals(gebruikersnaam)) {
				result = true;
			}
		}*/
		
		return result;
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
		Query<Gebruiker> query = ofy.query(Gebruiker.class);
		
		//Gebruikers doorlopen
		for(Gebruiker g : query) {
			//Toevoegen aan arrayList
			alleGebruikers.add(g);
		}

		return alleGebruikers;
	}
}
