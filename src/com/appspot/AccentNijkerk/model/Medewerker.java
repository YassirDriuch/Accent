package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

public class Medewerker extends Gebruiker implements Serializable {
	private static final long serialVersionUID = -8164090105300746871L;
	private String naam, adres, email;
	
	public Medewerker(String gn, String ww, String nm, String ad, String em) {
		super(gn, ww);
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
