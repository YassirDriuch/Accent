package com.appspot.AccentNijkerk.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Embedded;
import javax.persistence.Id;

public class CompetentieLijst implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id Long id;
	private long leerlingId;
	private String aanmaakDatum;
	private boolean verstuurd;
	@Embedded private ArrayList<Competentie> competenties = new ArrayList<Competentie>();
	
	public CompetentieLijst(Long leerlingId, String aanmaakDatum, boolean verstuurd) {
		this.leerlingId = leerlingId;
		this.aanmaakDatum = aanmaakDatum;
		this.verstuurd = verstuurd;
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
	
	public boolean isVerstuurd() {
		return verstuurd;
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
	
	public void setVerstuurd(boolean verstuurd) {
		this.verstuurd = verstuurd;
	}
}