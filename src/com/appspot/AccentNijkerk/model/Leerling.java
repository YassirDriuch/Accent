package com.appspot.AccentNijkerk.model;

public class Leerling extends Gebruiker {
	private String naam, email, leerlingnr;
	
	public Leerling(String nm, String em, String ln) {
		naam = nm;
		email = em;
		leerlingnr = ln;
	}
	
	//Getters
	public String getNaam() {
		return naam;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getLeerlingnr() {
		return leerlingnr;
	}
	
	//Setters
	public void setNaam(String nm) {
		naam = nm;
	}
	
	public void setEmail(String em) {
		email = em;
	}
	
	public void setLeerlingnr(String ln) {
		leerlingnr = ln;
	}
}
