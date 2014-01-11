package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;
import java.util.Date;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class StageDaoOfyImpl implements StageDao {
	Objectify ofy = ObjectifyService.begin();


	@Override
	public void voegStageToe(Stage s) {
		ofy.put(s);
		
	}

	@Override
	public Stage getStage(Leerling l, Date datumvan, Date datumtot,
			StageBedrijf sb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStage(Stage s) {
		ofy.put(s);
		
	}

	@Override
	public void verwijderStage(Stage s) {
		ofy.delete(s);
		
	}
	
	public Stage getStages(Long id) {
		Stage result = ofy.find(Stage.class, id);
		return result;
	}

	@Override
	public ArrayList<Stage> getStages() {
		ArrayList<Stage> alleStages = new ArrayList<Stage>();
		Query<Stage> query = ofy.query(Stage.class);
		
		//Competentielijsten doorlopen
		for(Stage s : query) {
			//Toevoegen aan arrayList
			alleStages.add(s);
		}
		
		return alleStages;
	}
}

	





