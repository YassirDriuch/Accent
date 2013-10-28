package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

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
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<Competentie> alleCompetenties() {
		// Returnt momenteel nog null, functie moet herschreven worden dmv
		// objectify query
		return null;
	}

	@Override
	public Competentie getCompetentie(String competentie) {
		Competentie result = null;
		Competentie gezochte = (Competentie) ofy.query(Competentie.class)
				.filter("competentie", competentie).get();

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
