package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class CompetentieLijstDaoOfyImpl implements CompetentieLijstDao {
	Objectify ofy = ObjectifyService.begin();
	ArrayList<CompetentieLijst> competentieLijsten;

	public CompetentieLijstDaoOfyImpl() {
		competentieLijsten = new ArrayList<CompetentieLijst>();
	}

	@Override
	public void voegCompetentieLijstToe(CompetentieLijst cL) {
			ofy.put(cL);
	}

	@Override
	public ArrayList<CompetentieLijst> alleCompetentieLijsten() {
		/* Herschrijven dmv Objectify query */
		return null;
	}

	@Override
	public CompetentieLijst getCompetentieLijst(String iets) {
		CompetentieLijst result = null;
		CompetentieLijst gezochte = null;
		if (gezochte != null)
			result = gezochte;

		return result;
	}

	@Override
	public void updateCompetentieLijst(CompetentieLijst cL) {
		ofy.put(cL);
	}

	@Override
	public void verwijderCompetentieLijst(CompetentieLijst cL) {
		ofy.delete(cL);
	}

}



