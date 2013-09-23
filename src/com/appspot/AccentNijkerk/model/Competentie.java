package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public class Competentie {
	private String competentie;
	public ArrayList<Vraag> vragen;
	
	public Competentie(String cp) {
		competentie = cp;
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
	public void setCompetentie(String cp) {
		competentie = cp;
	}
}
