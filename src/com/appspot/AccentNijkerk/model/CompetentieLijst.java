package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;
import java.util.Calendar;

public class CompetentieLijst {
	private int id;
	private Calendar aanmaakDatum;
	public ArrayList<Competentie> competenties;
	
	public CompetentieLijst(int i, Calendar ad) {
		id = i;
		aanmaakDatum = ad;
		competenties = new ArrayList<Competentie>();
	}
	
	//Getters
	public int getId() {
		return id;
	}
	
	public Calendar getAanmaakDatum() {
		return aanmaakDatum;
	}
	
	public ArrayList<Competentie> getCompetenties() {
		return competenties;
	}
	
	//Setters
	public void setId(int i) {
		id = i;
	}
}
