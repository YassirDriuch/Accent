package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import javax.persistence.Id;

public class CompetentieLijst {
	@Id Long id;
	private long leerlingId;
	private String aanmaakDatum;
	private boolean ingevuld;
	private ArrayList<Competentie> competenties;
	
	public CompetentieLijst(Long leerlingId, String aanmaakDatum, boolean ingevuld) {
		this.leerlingId = leerlingId;
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
	
	public Long getLeerlingId() {
		return leerlingId;
	}
	
	public String getAanmaakDatum() {
		return aanmaakDatum;
	}
	
	public boolean isIngevuld() {
		return ingevuld;
	}
	
	public ArrayList<Competentie> getAlleCompetenties(){
		return competenties;
	}
	
	//Setters
	public void setLeerlingId(Long leerlingId) {
		this.leerlingId = leerlingId;
	}
	
	public void setAanmaakDataum(String aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}
	
	public void setIngevuld(boolean ingevuld) {
		this.ingevuld = ingevuld;
	}
}
