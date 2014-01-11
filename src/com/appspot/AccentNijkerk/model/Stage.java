package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Id;

public class Stage {
	@Id Long id;
	public ArrayList<Leerling> stagiaires;
	public ArrayList<StageBedrijf> bedrijven;
	private Date datumvan;
	private Date datumtot;
	
	
	public Stage(Date datumvan, Date datumtot) {
		this.datumvan = datumvan;
		this.datumtot = datumtot;
		stagiaires = new ArrayList<Leerling>();
		bedrijven = new ArrayList<StageBedrijf>();
	}
	
	public Stage() {
		//Default constructor
	}
	
	//Getters
	public Long getId() {
		return id;
	}
	
	public Date getDatumVan() {
		return datumvan;
	}
	public Date getDatumTot(){
		return datumtot;
	}
	
	public ArrayList<Leerling> getStagiaires() {
		return stagiaires;
	}
	
	public ArrayList<StageBedrijf> getBedrijven() {
		return bedrijven;
	}
	
	//Setters
	public void setDatumVan(Date datumvan) {
		this.datumvan = datumvan;
	}
	public void setDatumTot(Date datumtot) {
		this.datumtot = datumtot;
	}
	
		public void voegStagiarToe(Leerling stagiar) {
				stagiaires.add(stagiar);
			}
		public void voegBedrijfToe(StageBedrijf bedrijf) {
			bedrijven.add(bedrijf);
		}

}
