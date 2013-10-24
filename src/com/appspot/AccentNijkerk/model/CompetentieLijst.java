package com.appspot.AccentNijkerk.model;

import java.util.Calendar;

import javax.persistence.Id;

public class CompetentieLijst {
	@Id Long id;
	private Gebruiker leerling;
	private Calendar aanmaakDatum;
	private boolean ingevuld;
	
	public CompetentieLijst(Gebruiker l, Calendar ad, boolean ig) {
		leerling = l;
		aanmaakDatum = ad;
		ingevuld = ig;
	}
	
	//Getters
	public Gebruiker getLeerling() {
		return leerling;
	}
	
	public Calendar getAanmaakDatum() {
		return aanmaakDatum;
	}
	
	public boolean isIngevuld() {
		return ingevuld;
	}
	
	//Setters
	public void setLeerling(Gebruiker l) {
		leerling = l;
	}
	
	public void setAanmaakDataum(Calendar ad) {
		aanmaakDatum = ad;
	}
	
	public void setIngevuld(boolean ig) {
		ingevuld = ig;
	}
}
