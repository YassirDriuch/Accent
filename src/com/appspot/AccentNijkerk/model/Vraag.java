package com.appspot.AccentNijkerk.model;

import javax.persistence.Id;

public class Vraag {
	@Id Long id;
	private String vraag;
	private Long competentieId;
	
	public Vraag(String vraag, Long competentieId) {
		this.vraag = vraag;
		this.competentieId = competentieId;
	}
	
	public Vraag() {
		//Default constructor
	}
	
	//Getters
	public Long getId() {
		return id;
	}
	
	public String getVraag() {
		return vraag;
	}
	
	public Long getCompetentieId() {
		return competentieId;
	}
	
	//Setters
	public void setVraag(String vraag) {
		this.vraag = vraag;
	}
	
	public void setCompetentieId(Long id) {
		this.competentieId = id;
	}
}
