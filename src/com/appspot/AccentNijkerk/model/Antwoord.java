package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

public class Antwoord implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long vraagId;
	private int antwoord;
	
	public Antwoord(Long vraagId, int antwoord) {
		this.vraagId = vraagId;
		this.antwoord = antwoord;
	}
	
	public Antwoord() {
		//Default constructor
	}

	//Getters
	
	public Long getVraagId() {
		return vraagId;
	}
	
	public int getAntwoord() {
		return antwoord;
	}
	
	//Setters
	public void setVraagId(Long vraagId) {
		this.vraagId = vraagId;
	}
	
	public boolean setAntwoord(int antwoord) {
		if(antwoord >= 1 && antwoord <= 4){
			this.antwoord = antwoord;
			return true;
		} else {
			return false;
		}
	}
}
