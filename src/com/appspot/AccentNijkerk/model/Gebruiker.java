package com.appspot.AccentNijkerk.model;

public class Gebruiker {
	private String gebruikersnaam, wachtwoord;
	
	public Gebruiker(String gn, String ww) {
		gebruikersnaam = gn;
		wachtwoord = ww;
	}
	
	public Gebruiker() { 
		//Default constructor
	} 

	//Getters
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	
	public String getWachtwoord() {
		return wachtwoord;
	}
	
	//Setters
	public void setGebruikersnaam(String gn) {
		gebruikersnaam = gn;
	}
	
	public void setWachtwoord(String ww) {
		wachtwoord = ww;
	}
}
