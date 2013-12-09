package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Id;

public class CompetentieLijst {
	@Id Long id;
	private Gebruiker leerling;
	private Calendar aanmaakDatum;
	private boolean ingevuld;
	private ArrayList<Competentie> competenties;
	
	public CompetentieLijst(Gebruiker leerling, Calendar aanmaakDatum, boolean ingevuld) {
		this.leerling = leerling;
		this.aanmaakDatum = aanmaakDatum;
		this.ingevuld = ingevuld;
		competenties = new ArrayList<Competentie>();
	}
	
	public CompetentieLijst() {
		//Default constructor
	}
	
	public void voegCompetentieToe(Competentie competentie) {
		competenties.add(competentie);
	}
	
	//Getters
	public Long getId() {
		return id;
	}
	
	public Gebruiker getLeerling() {
		return leerling;
	}
	
	public Calendar getAanmaakDatum() {
		return aanmaakDatum;
	}
	
	public boolean isIngevuld() {
		return ingevuld;
	}
	
	public ArrayList<Competentie> getAlleCompetenties(){
		return competenties;
	}
	
	//Setters
	public void setLeerling(Gebruiker leerling) {
		this.leerling = leerling;
	}
	
	public void setAanmaakDataum(Calendar aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}
	
	public void setIngevuld(boolean ingevuld) {
		this.ingevuld = ingevuld;
	}
}
