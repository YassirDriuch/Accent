package com.appspot.AccentNijkerk.model;

import javax.persistence.Id;

public class Vraag {
	@Id Long id;
	private String vraag;
	private Competentie competentie;
	private int antwoord;
	
	public Vraag(String vraag, int antwoord) {
		this.vraag = vraag;
		this.antwoord = antwoord;
	}
	
	public Vraag() {
		//Default constructor
	}
	
	//Getters
	public String getVraag() {
		return vraag;
	}
	
	public int getAntwoord() {
		return antwoord;
	}
	
	public Competentie getCompetentie(){
		return competentie;
	}
	
	//Setters
	public void setVraag(String vraag) {
		this.vraag = vraag;
	}
	
	public void setAntwoord(int antwoord) {
		this.antwoord = antwoord;
	}
	
	public void setCompetentie(Competentie competentie){
		this.competentie = competentie;
	}
	
	//Methoden
	public boolean isGeantwoord() {
		if(antwoord != 0) {
			return true;
		} else {
			return false;
		}
	}
}
