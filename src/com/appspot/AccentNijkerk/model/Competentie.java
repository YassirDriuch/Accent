package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public class Competentie {
	private String competentie;
	public ArrayList<Vraag> vragen;
	
	public Competentie(String competentie) {
		this.competentie = competentie;
		vragen = new ArrayList<Vraag>();
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
