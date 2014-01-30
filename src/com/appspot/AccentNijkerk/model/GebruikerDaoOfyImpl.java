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
		Query<CompetentieLijst> alleCompetentieLijsten = ofy.query(CompetentieLijst.class);
		Query<Stage> alleStages = ofy.query(Stage.class);
		for(CompetentieLijst cL : alleCompetentieLijsten){
			if(g instanceof Leerling && cL.getLeerlingId() == g.getId() || g instanceof StageBedrijf && cL.getBedrijfId() == g.getId()){
					System.out.println(cL);
					ofy.delete(cL);
			}
		}
		for(Stage s : alleStages){
			if(g instanceof Leerling && s.getLeerlingId() == g.getId() || g instanceof StageBedrijf && s.getBedrijfId() == g.getId()){
				System.out.println(s);
				ofy.delete(s);
			}
		}
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
		Gebruiker leerling = (Gebruiker) ofy.find(Leerling.class, id);
		Gebruiker docent = (Gebruiker) ofy.find(Docent.class, id);
		Gebruiker stagebedrijf = (Gebruiker)ofy.find(StageBedrijf.class, id);

		//Gebruiker instantie returnen
		if(leerling != null) {
			result = leerling;
		} else if(docent != null) {
			result = docent;
		} else if(stagebedrijf != null) {
			result = stagebedrijf;
		}
		
		return result;
	}
	
	@Override
	public ArrayList<Gebruiker> getAlleGebruikers() {
		ArrayList<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
		Query<Docent> alleDocenten = ofy.query(Docent.class);
		Query<StageBedrijf> alleStageBedrijven = ofy.query(StageBedrijf.class);
		Query<Admin> alleAdmins = ofy.query(Admin.class);
		
		for(Gebruiker g : alleLeerlingen) {
			alleGebruikers.add(g);
		}
		
		for(Gebruiker g : alleDocenten) {
			alleGebruikers.add(g);
		}
		
		for(Gebruiker g : alleStageBedrijven) {
			alleGebruikers.add(g);
		}
		
		for(Gebruiker g : alleAdmins) {
			alleGebruikers.add(g);
		}

		return alleGebruikers;
	}
	
	@Override
	public ArrayList<Gebruiker> getAlleLeerlingen() {
		ArrayList<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
		
		for(Gebruiker g : alleLeerlingen) {
			alleGebruikers.add(g);
		}

		return alleGebruikers;
	}
	
	@Override
	public ArrayList<Gebruiker> getAlleDocenten() {
		ArrayList<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		Query<Docent> alleMedewerkers = ofy.query(Docent.class);
		
		for(Gebruiker g : alleMedewerkers) {
			alleGebruikers.add(g);
		}

		return alleGebruikers;
	}
	
	@Override
	public ArrayList<Gebruiker> getAlleStageBedrijven() {
		ArrayList<Gebruiker> alleGebruikers = new ArrayList<Gebruiker>();
		Query<StageBedrijf> alleStageBedrijven = ofy.query(StageBedrijf.class);
		
		for(Gebruiker g : alleStageBedrijven) {
			alleGebruikers.add(g);
		}

		return alleGebruikers;
	}

	@Override
	public Gebruiker zoekGebruiker(String n) {
		Gebruiker gl = null;
		Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
		CharSequence cs1 = n.toLowerCase();
		for(Leerling l: alleLeerlingen){
			if(l.getNaam().toLowerCase().contains(cs1)){
				Long leerlingid = l.getId();
				gl = getGebruiker(leerlingid);
			}
			
		}
		return gl;
	}
}