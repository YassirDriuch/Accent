package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class VraagDaoOfyImpl implements VraagDao {
	Objectify ofy = ObjectifyService.begin();

	public VraagDaoOfyImpl() {
		//Default constructor
	}

	@Override
	public boolean voegVraagToe(Vraag v) {
		if(isBezet(v.getVraag()) == true) {
			return false; //Niet toegevoegd
		} else {
			ofy.put(v);
			return true; //Toegevoegd
		}
	}
	
	@Override
	public void updateVraag(Vraag v) {
		ofy.put(v);
	}

	@Override
	public void verwijderVraag(Vraag v) {
		ofy.delete(v);
	}

	@Override
	public ArrayList<Vraag> getAlleVragen() {
		ArrayList<Vraag> alleVragen = new ArrayList<Vraag>();
		Query<Vraag> query = ofy.query(Vraag.class);
		
		//Alle vragen doorlopen
		for(Vraag v : query) {
			//Toevoegen aan arrayList
			alleVragen.add(v);
		}
		
		return alleVragen;
	}

	@Override
	public Vraag getVraag(Long id) {
		Vraag result = ofy.get(Vraag.class, id);
		return result;
	}
	
	@Override
	public boolean isBezet(String vraag) {
		boolean isBezet = false;
		
		//Alle gebruikers doorlopen
		for(Vraag v : getAlleVragen()) {
			//Gebruikersnaam vergelijken
			if(v.getVraag().equals(vraag)) {
				isBezet = true;
			}
		}
		
		return isBezet;
	}
}
