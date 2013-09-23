package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public class School {
	private String naam, adres, telnr;
	public ArrayList<Leerling> alleLeerlingen;
	public ArrayList<Klas> alleKlassen;
	public ArrayList<StageBedrijf> alleStageBedrijven;
	public ArrayList<Gebruiker> alleGebruikers;
	
	public School(String nm, String ad, String tn) {
		naam = nm;
		adres = ad;
		telnr = tn;
		alleLeerlingen = new ArrayList<Leerling>();
		alleKlassen = new ArrayList<Klas>();
		alleStageBedrijven = new ArrayList<StageBedrijf>();
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
	
	public ArrayList<Leerling> getAlleLeerlingen() {
		return alleLeerlingen;
	}
	
	public ArrayList<Klas> getAlleKlassen() {
		return alleKlassen;
	}
	
	public ArrayList<StageBedrijf> getAlleStageBedrijven() {
		return alleStageBedrijven;
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
	public void voegLeerlingToe(Leerling leerling) {
		if(!alleLeerlingen.contains(leerling)) {
			alleLeerlingen.add(leerling);
			System.out.println("#Leerling is toegevoegd");
		}
	}
		
	public void verwijderLeerling(Leerling leerling){
		if(alleLeerlingen.contains(leerling)){
			alleLeerlingen.remove(leerling);
			System.out.println("#Leerling is verwijderd");
		}
	}
	
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
	
	public void voegStageBedrijfToe(StageBedrijf stagebedrijf) {
		if(!alleStageBedrijven.contains(stagebedrijf)) {
			alleStageBedrijven.add(stagebedrijf);
			System.out.println("#Stagebedrijf is toegevoegd");
		}
	}
		
	public void verwijderStageBedrijf(StageBedrijf stagebedrijf){
		if(alleStageBedrijven.contains(stagebedrijf)){
			alleStageBedrijven.remove(stagebedrijf);
			System.out.println("#Stagebedrijf is verwijderd");
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
	
	public void voegMedewerkerToe(Medewerker medewerker) {
		if(!alleGebruikers.contains(medewerker)) {
			alleGebruikers.add(medewerker);
			System.out.println("#Medewerker is toegevoegd");
		}
	}
		
	public void verwijderMedewerker(Medewerker medewerker){
		if(alleGebruikers.contains(medewerker)){
			alleGebruikers.remove(medewerker);
			System.out.println("#Medewerker is verwijderd");
		}
	}
}
