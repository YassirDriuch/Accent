package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Gebruiker implements Serializable {
	private static final long serialVersionUID = -5849640961435645982L;
	@Id Long id;
	private String gebruikersnaam, wachtwoord;
	
	public Gebruiker(String gebruikersnaam, String wachtwoord) {
		this.gebruikersnaam = gebruikersnaam;
		this.wachtwoord = wachtwoord;
	}
	
	public Gebruiker() { 
		//Default constructor
	} 

	//Getters
	public Long getId() {
		return id;
	}
	
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}
	
	public String getWachtwoord() {
		return wachtwoord;
	}
	
	//Setters
	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}
	
	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}
}
