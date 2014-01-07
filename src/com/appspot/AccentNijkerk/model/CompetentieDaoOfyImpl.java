package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class CompetentieDaoOfyImpl implements CompetentieDao {
	Objectify ofy = ObjectifyService.begin();
	
	public CompetentieDaoOfyImpl() {
		//Default constructor
	}

	@Override
	public boolean voegCompetentieToe(Competentie c) {
		if(isBezet(c.getCompetentie()) == true) {
			return false; //Niet toegevoegd
		} else {
			ofy.put(c);
			return true; //Toegevoegd
		}
	}

	@Override
	public void updateCompetentie(Competentie c) {
		ofy.put(c);
	}

	@Override
	public void verwijderCompetentie(Competentie c) {
		ofy.delete(c);
	}
	
	@Override
	public boolean isBezet(String competentie) {
		boolean isBezet = false;
		
		//Alle gebruikers doorlopen
		for(Competentie c : getAlleCompetenties()) {
			//Gebruikersnaam vergelijken
			if(c.getCompetentie().equals(competentie)) {
				isBezet = true;
			}
		}
		
		return isBezet;
	}
	
	@Override
	public Competentie getCompetentie(Long id) {
		Competentie result = ofy.get(Competentie.class, id);
		return result;
	}
	
	@Override
	public ArrayList<Competentie> getAlleCompetenties() {
		ArrayList<Competentie> alleCompetenties = new ArrayList<Competentie>();
		Query<Competentie> query = ofy.query(Competentie.class);
		
		//Alle competenties doorlopen en toevoegen
		for(Competentie g : query) {
			//Toevoegen in arrayList
			alleCompetenties.add(g);
		}
		
		return alleCompetenties;
	}
}