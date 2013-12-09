package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class CompetentieLijstDaoOfyImpl implements CompetentieLijstDao {
	Objectify ofy = ObjectifyService.begin();

	public CompetentieLijstDaoOfyImpl() {
		//Default constructor
	}

	@Override
	public void voegCompetentieLijstToe(CompetentieLijst cL) {
		ofy.put(cL);
	}


	@Override
	public void updateCompetentieLijst(CompetentieLijst cL) {
		ofy.put(cL);
	}

	@Override
	public void verwijderCompetentieLijst(CompetentieLijst cL) {
		ofy.delete(cL);
	}

	@Override
	public ArrayList<CompetentieLijst> getAlleCompetentieLijsten() {
		ArrayList<CompetentieLijst> alleCompetentieLijsten = new ArrayList<CompetentieLijst>();
		Query<CompetentieLijst> query = ofy.query(CompetentieLijst.class);
		
		//Competentielijsten doorlopen
		for(CompetentieLijst cL : query) {
			//Toevoegen aan arrayList
			alleCompetentieLijsten.add(cL);
		}
		
		return alleCompetentieLijsten;
	}
	

	@Override
	public CompetentieLijst getCompetentieLijst(Long id) {
		CompetentieLijst result = ofy.get(CompetentieLijst.class, id);
		return result;
	}
}



