package com.appspot.AccentNijkerk.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Embedded;
import javax.persistence.Id;

public class BeoordelingsLijst implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id Long id;
	private Long gebruikerId;
	private Long competentieLijstId;
	private String aanmaakDatum;
	@Embedded private ArrayList<Antwoord> antwoorden = new ArrayList<Antwoord>();
	
	public BeoordelingsLijst(Long competentieLijstId, Long gebruikerId, String aanmaakDatum) {
		this.competentieLijstId = competentieLijstId;
		this.gebruikerId = gebruikerId;
		this.aanmaakDatum = aanmaakDatum;
	}
	
	public BeoordelingsLijst() {
		//Default constructor
	}
	
	public void voegAntwoordToe(Antwoord antwoord) {
		antwoorden.add(antwoord);
	}
	
	//Getters
	public Long getId() {
		return id;
	}
	
	public Long getGebruikerId() {
		return gebruikerId;
	}
	
	public Long getCompetentieLijstId(){
		return competentieLijstId;
	}
	
	public String getAanmaakDatum() {
		return aanmaakDatum;
	}
	
	public ArrayList<Antwoord> getAlleAntwoorden(){
		return antwoorden;
	}
	
	//Setters
	public void setGebruikerId(Long gebruikerId) {
		this.gebruikerId = gebruikerId;
	}
	
	public void setCompetentieLijstId(Long competentieLijstId) {
		this.competentieLijstId = competentieLijstId;
	}
	
	public void setAanmaakDatum(String aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}
}