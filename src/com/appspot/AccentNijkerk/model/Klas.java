package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public class Klas {
	private String naam;
	public ArrayList<Leerling> leerlingen;
	
	public Klas(String nm) {
		naam = nm;
		leerlingen = new ArrayList<Leerling>();
	}
	
	//Getters
	public String getNaam() {
		return naam;
	}
	
	public ArrayList<Leerling> getLeerlingen() {
		return leerlingen;
	}
	
	//Setters
	public void setNaam(String nm) {
		naam = nm;
	}
}
