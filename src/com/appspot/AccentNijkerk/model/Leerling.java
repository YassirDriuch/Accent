package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

public class Leerling extends Gebruiker implements Serializable {
	private static final long serialVersionUID = -3586223028920551117L;
	private String naam, email, leerlingnr;
	
	public Leerling(String gebruikersnaam, String wachtwoord, String naam, String email, String leerlingnr) {
		super(gebruikersnaam, wachtwoord);
		this.naam = naam;
		this.email = email;
		this.leerlingnr = leerlingnr;
	}
	
	public Leerling() {
		//Default constructor
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
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setLeerlingnr(String leerlingnr) {
		this.leerlingnr = leerlingnr;
	}
}
