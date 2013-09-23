package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public class StageBedrijf extends Gebruiker {
	private String naam, adres, email, telnr;
	public ArrayList<Leerling> stagiares;
	
	public StageBedrijf(String nm, String ad, String em, String tn) {
		naam = nm;
		adres = ad;
		email = em;
		telnr = tn;
		stagiares = new ArrayList<Leerling>();
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
	
	public String getTelnr() {
		return telnr;
	}
	
	public ArrayList<Leerling> getStagiares() {
		return stagiares;
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
	
	public void setTelnr(String tn) {
		telnr = tn;
	}
	
	//Methods
	public void voegStagiarToe(Leerling stagiar) {
		if(!stagiares.contains(stagiar)) {
			stagiares.add(stagiar);
			System.out.println("#Stagiar is toegevoegd");
		}
	}
		
	public void verwijderStagiar(Leerling stagiar){
		if(stagiares.contains(stagiar)){
			stagiares.remove(stagiar);
			System.out.println("#Stagiar is verwijderd");
		}
	}
}
