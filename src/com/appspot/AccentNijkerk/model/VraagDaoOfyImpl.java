package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class VraagDaoOfyImpl implements VraagDao{
	Objectify ofy = ObjectifyService.begin();
	ArrayList<Vraag> vragen;

	public VraagDaoOfyImpl() {
		vragen = new ArrayList<Vraag>();
	}

	@Override
	public void voegVraagToe(Vraag v) {
		ofy.put(v);
	}

	@Override
	public ArrayList<Vraag> alleVragen() {
		Query<Vraag> query = ofy.query(Vraag.class);
		
		//Alle vragen doorlopen
		for(Vraag v : query) {
			//Toevoegen aan arrayList
			vragen.add(v);
		}
		
		return vragen;
	}

	@Override
	public Vraag getVraag(String vraag) {
		Vraag result = null;
		Vraag gezochte = (Vraag) ofy.query(Vraag.class).filter("vraag", vraag).get();	
		
		//Vraag obj zoeken op basis van de vraag
		if(gezochte != null)
			result = gezochte;
		
		return result;
	}

	@Override
	public void updateVraag(Vraag v) {
		ofy.put(v);
	}

	@Override
	public void verwijderVraag(Vraag v) {
		ofy.delete(v);
	}
}
