package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public class School {
	private String naam, adres, telnr;
	public ArrayList<Klas> alleKlassen;
	public ArrayList<Gebruiker> alleGebruikers;
	
	public School(String nm, String ad, String tn) {
		naam = nm;
		adres = ad;
		telnr = tn;
		alleKlassen = new ArrayList<Klas>();
		alleGebruikers = new ArrayList<Gebruiker>();
	}
	
	//Getters
	public String getNaam() {
		return naam;
	}
	
	public String getAdres() {
		return adres;
	}
	
	public String getTelnr() {
		return telnr;
	}
	
	public ArrayList<Klas> getAlleKlassen() {
		return alleKlassen;
	}
	
	public ArrayList<Gebruiker> getAlleGebruikers() {
		return alleGebruikers;
	}
	
	//Setters
	public void setNaam(String nm) {
		naam = nm;
	}
	
	public void setAdres(String ad) {
		adres = ad;
	}
	
	public void setTelnr(String tn) {
		telnr = tn;
	}
	
	//Methods	
	public void voegKlasToe(Klas klas) {
		if(!alleKlassen.contains(klas)) {
			alleKlassen.add(klas);
			System.out.println("#Klas is toegevoegd");
		}
	}
		
	public void verwijderKlas(Klas klas){
		if(alleKlassen.contains(klas)){
			alleKlassen.remove(klas);
			System.out.println("#Klas is verwijderd");
		}
	}
	
	public void voegGebruikerToe(Gebruiker gebruiker) {
		if(!alleGebruikers.contains(gebruiker)) {
			alleGebruikers.add(gebruiker);
			System.out.println("#Gebruiker is toegevoegd");
		}
	}
		
	public void verwijderGebruiker(Gebruiker gebruiker){
		if(alleGebruikers.contains(gebruiker)){
			alleGebruikers.remove(gebruiker);
			System.out.println("#Gebruiker is verwijderd");
		}
	}
}
