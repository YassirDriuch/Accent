package com.appspot.AccentNijkerk.model;

public class Vraag {
	private String vraag;
	private int antwoord;
	
	public Vraag(String vraag, int antwoord) {
		this.vraag = vraag;
		this.antwoord = antwoord;
	}
	
	//Getters
	public String getVraag() {
		return vraag;
	}
	
	public int getAntwoord() {
		return antwoord;
	}
	
	//Setters
	public void setVraag(String vraag) {
		this.vraag = vraag;
	}
	
	public void setAntwoord(int antwoord) {
		this.antwoord = antwoord;
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
