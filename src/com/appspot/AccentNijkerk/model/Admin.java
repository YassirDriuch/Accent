package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

public class Admin extends Gebruiker implements Serializable{
	private static final long serialVersionUID = 7827614177664321030L;
	private String naam;
	
	public Admin(String gebruikersnaam, String wachtwoord, String naam){
		super(gebruikersnaam, wachtwoord);
		this.naam = naam;
	}
	
	public Admin(){
	}
	
	public String getNaam(){
		return naam;
	}
	
	public void setNaam(String naam){
		this.naam = naam;
	}
	
	public String toString() {
		String s = "Administrator: " + naam;
		return s;
	}
}
