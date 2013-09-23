package com.appspot.AccentNijkerk.model;

public class Vraag {
	private String vraag;
	private int antwoord;
	
	public Vraag(String v, int aw) {
		vraag = v;
		antwoord = aw;
	}
	
	//Getters
	public String getVraag() {
		return vraag;
	}
	
	public int getAntwoord() {
		return antwoord;
	}
	
	//Setters
	public void setVraag(String vg) {
		vraag = vg;
	}
	
	public void setAntwoord(int aw) {
		antwoord = aw;
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
