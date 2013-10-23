package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

public class Leerling extends Gebruiker implements Serializable {
	private static final long serialVersionUID = -3586223028920551117L;
	private String naam, email, leerlingnr;
	
	public Leerling(String gn, String ww, String nm, String em, String ln) {
		super(gn, ww);
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
