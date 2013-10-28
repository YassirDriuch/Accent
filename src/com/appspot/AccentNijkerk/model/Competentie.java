package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

import javax.persistence.Id;

public class Competentie {
	@Id Long id;
	private String competentie;
	public ArrayList<Vraag> vragen;
	
	public Competentie(String competentie) {
		this.competentie = competentie;
		vragen = new ArrayList<Vraag>();
	}
	
	public Competentie() {
		//Default constructor
	}
	
	//Getters
	public String getCompetentie() {
		return competentie;
	}
	
	public ArrayList<Vraag> getVragen() {
		return vragen;
	}
	
	//Setters
	public void setCompetentie(String competentie) {
		this.competentie = competentie;
	}
}
