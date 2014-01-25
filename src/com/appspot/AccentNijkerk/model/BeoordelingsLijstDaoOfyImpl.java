package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class BeoordelingsLijstDaoOfyImpl implements BeoordelingsLijstDao {
	Objectify ofy = ObjectifyService.begin();

	public BeoordelingsLijstDaoOfyImpl() {
		//Default constructor
	}

	@Override
	public void voegBeoordelingsLijstToe(BeoordelingsLijst bL) {
		ofy.put(bL);
	}

	@Override
	public void updateBeoordelingsLijst(BeoordelingsLijst bL) {
		ofy.put(bL);
	}

	@Override
	public void verwijderBeoordelingsLijst(BeoordelingsLijst bL) {
		ofy.delete(bL);
	}

	@Override
	public ArrayList<BeoordelingsLijst> getAlleBeoordelingsLijsten() {
		ArrayList<BeoordelingsLijst> alleBeoordelingsLijsten = new ArrayList<BeoordelingsLijst>();
		Query<BeoordelingsLijst> query = ofy.query(BeoordelingsLijst.class);
		
		//Competentielijsten doorlopen
		for(BeoordelingsLijst bL : query) {
			//Toevoegen aan arrayList
			alleBeoordelingsLijsten.add(bL);
		}
		
		return alleBeoordelingsLijsten;
	}
	
	@Override
	public BeoordelingsLijst getBeoordelingsLijst(Long id) {
		BeoordelingsLijst result = ofy.find(BeoordelingsLijst.class, id);
		return result;
	}
}



