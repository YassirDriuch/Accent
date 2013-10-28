package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

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
		/* Returnt momenteel nog null, functie moet herschreven worden dmv
		objectify query */
		return null;
	}

	@Override
	public Vraag getVraag(String vraag) {
		Vraag result = null;
		Vraag gezochte = null;
		if (gezochte != null)
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
