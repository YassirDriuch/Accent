package com.appspot.AccentNijkerk.model;

public class Medewerker extends Gebruiker {
	private String naam, adres, email;
	
	public Medewerker(String nm, String ad, String em) {
		naam = nm;
		adres = ad;
		email = em;
	}
	
	//Getters
	public String getNaam() {
		return naam;
	}
	
	public String getAdres() {
		return adres;
	}
	
	public String getEmail() {
		return email;
	}
	
	//Setters
	public void setNaam(String nm) {
		naam = nm;
	}
	
	public void setAdres(String ad) {
		adres = ad;
	}
	
	public void setEmail(String em) {
		email = em;
	}
	
}
