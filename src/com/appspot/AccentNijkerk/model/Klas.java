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
	
	//Methods
	public void voegLeerlingToe(Leerling leerling) {
		if(!leerlingen.contains(leerling)) {
			leerlingen.add(leerling);
			System.out.println("#Stagiar is toegevoegd");
		}
	}
			
	public void verwijderLeerling(Leerling leerling){
		if(leerlingen.contains(leerling)){
			leerlingen.remove(leerling);
			System.out.println("#Stagiar is verwijderd");
		}
	}
}
