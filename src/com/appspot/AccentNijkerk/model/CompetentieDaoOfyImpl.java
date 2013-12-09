package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class CompetentieDaoOfyImpl implements CompetentieDao {

	Objectify ofy = ObjectifyService.begin();
	ArrayList<Competentie> competenties;

	public CompetentieDaoOfyImpl() {
		competenties = new ArrayList<Competentie>();
	}

	@Override
	public boolean voegCompetentieToe(Competentie c) {
		if (getCompetentie(c.getCompetentie()) == null) {
			ofy.put(c);
			return true; //Toegevoegd
		} else {
			return false; //Niet toegevoegd
		}
	}

	@Override
	public ArrayList<Competentie> alleCompetenties() {
		Query<Competentie> query = ofy.query(Competentie.class);
		
		//Alle competenties doorlopen
		for(Competentie g : query) {
			//Toevoegen in arraylist
			competenties.add(g);
		}
		
		return competenties;
	}
	

	@Override
	public Competentie getCompetentie(String competentie) {
		Competentie result = null;
		//Zoeken naar competentie op naam
		Competentie gezochte = (Competentie) ofy.query(Competentie.class).filter("competentie", competentie).get();

		if (gezochte != null)
			result = gezochte;

		return result;
	}

	@Override
	public void updateCompetentie(Competentie c) {
		ofy.put(c);
	}

	@Override
	public void verwijderCompetentie(Competentie c) {
		ofy.delete(c);
	}
}