package com.appspot.AccentNijkerk.model;

import javax.persistence.Id;

public class Antwoord {
	@Id Long id;
	private Long vraagId;
	private Long gebruikerId;
	private Long competentieLijstId;
	private int antwoord;
	
	public Antwoord(Long vraagId, Long gebruikerId, Long competentieLijstId, int antwoord){
		this.vraagId = vraagId;
		this.gebruikerId = gebruikerId;
		this.competentieLijstId = competentieLijstId;
		this.antwoord = antwoord;
	}
	
	public Antwoord(){
		
	}

	//Getters
	public Long getId(){
		return id;
	}
	
	public Long getVraagId(){
		return vraagId;
	}
	
	public Long getGebruikerId(){
		return gebruikerId;
	}
	
	public Long getCompetentieLijstId(){
		return competentieLijstId;
	}
	
	public int getAntwoord(){
		return antwoord;
	}
	
	//Setters
	public boolean setAntwoord(int antwoord){
		
		if(antwoord>-1 && antwoord <4){
			this.antwoord = antwoord;
			return true;
		}
		else{
			return false;
		}
	}
	

}
