package com.appspot.AccentNijkerk.model;

import java.io.Serializable;
import java.util.ArrayList;

public class StageBedrijf extends Gebruiker implements Serializable {
	private static final long serialVersionUID = 3861773411669893514L;
	private String naam, adres, email, telnr;
	public ArrayList<Leerling> stagiares;
	
	public StageBedrijf(String gebruikersnaam, String wachtwoord, String naam, String adres, String email, String telnr) {
		super(gebruikersnaam, wachtwoord);
		this.naam = naam;
		this.adres = adres;
		this.email = email;
		this.telnr = telnr;
		stagiares = new ArrayList<Leerling>();
	}
	
	public StageBedrijf() {
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
