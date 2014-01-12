package com.appspot.AccentNijkerk.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Competentie implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id Long id;
	private String competentie;
	
	public Competentie(String competentie) {
		this.competentie = competentie;
	}
	
	public Competentie() {
		//Default constructor
	}
	
	//Getters
	public Long getId() {
		return id;
	}
	
	public String getCompetentie() {
		return competentie;
	}

	//Setters
	public void setCompetentie(String competentie) {
		this.competentie = competentie;
	}
}
