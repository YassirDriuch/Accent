package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;


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
		Query<CompetentieLijst> query = ofy.query(CompetentieLijst.class);
		
		//Competentielijsten doorlopen
		for(CompetentieLijst g : query) {
			//Toevoegen aan arrayList
			competentieLijsten.add(g);
		}
		
		return competentieLijsten;
	}
	

	@Override
	public CompetentieLijst getCompetentieLijst(Long id) {
		CompetentieLijst result = null;
		//Competentielijst returnen op basis van de ID
		CompetentieLijst gezochte = (CompetentieLijst) ofy.query(CompetentieLijst.class).filter("id", id).get();
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



