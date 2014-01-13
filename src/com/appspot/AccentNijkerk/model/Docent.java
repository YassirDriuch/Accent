package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

public class Docent extends Gebruiker implements Serializable {
	private static final long serialVersionUID = -8164090105300746871L;
	private String naam, adres, email;
	
	public Docent(String gebruikersnaam, String wachtwoord, String naam, String adres, String email) {
		super(gebruikersnaam, wachtwoord);
		this.naam = naam;
		this.adres = adres;
		this.email = email;
	}
	
	public Docent() {
		//Default constructor
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
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void setAdres(String adres) {
		this.adres = adres;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		String s = "Naam: " + naam + "<br />Adres: " + adres + "<br />Email: " + email;
		return s;
	}
}
