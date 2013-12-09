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
	public void voegCompetentieToe(Competentie c) {
		ofy.put(c);
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