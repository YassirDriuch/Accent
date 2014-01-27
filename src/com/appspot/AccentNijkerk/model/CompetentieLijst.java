package com.appspot.AccentNijkerk.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Embedded;
import javax.persistence.Id;

public class CompetentieLijst implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id Long id;
	private Long leerlingId;
	private Long bedrijfId;
	private String aanmaakDatum;
	private boolean bedrijfIngevuld, leerlingIngevuld;
	@Embedded private ArrayList<Competentie> competenties = new ArrayList<Competentie>();
	
	public CompetentieLijst(Long bedrijfId, Long leerlingId, String aanmaakDatum, boolean bedrijfIngevuld, boolean leerlingIngevuld) {
		this.bedrijfId = bedrijfId;
		this.leerlingId = leerlingId;
		this.aanmaakDatum = aanmaakDatum;
		this.bedrijfIngevuld = bedrijfIngevuld;
		this.leerlingIngevuld = leerlingIngevuld;
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
	
	public Long getBedrijfId(){
		return bedrijfId;
	}
	
	public String getAanmaakDatum() {
		return aanmaakDatum;
	}
	
	public boolean isBedrijfIngevuld() {
		return bedrijfIngevuld;
	}
	
	public boolean isLeerlingIngevuld() {
		return leerlingIngevuld;
	}
	
	public ArrayList<Competentie> getAlleCompetenties(){
		return competenties;
	}
	
	//Setters
	public void setLeerlingId(Long leerlingId) {
		this.leerlingId = leerlingId;
	}
	
	public void setBedrijfId(Long bedrijfId) {
		this.bedrijfId = bedrijfId;
	}
	
	public void setAanmaakDatum(String aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}
	
	public void setBedrijfIngevuld(boolean bedrijfIngevuld) {
		this.bedrijfIngevuld = bedrijfIngevuld;
	}
	
	public void setLeerlingIngevuld(boolean leerlingIngevuld) {
		this.leerlingIngevuld = leerlingIngevuld;
	}
}