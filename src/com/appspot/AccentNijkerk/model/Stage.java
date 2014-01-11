package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Id;

public class Stage {
	@Id Long id;
	private long leerlingId;
	private long bedrijfId;
	public ArrayList<Leerling> stagiaires;
	public ArrayList<StageBedrijf> bedrijven;
	private Date datumvan;
	private Date datumtot;
	
	
	public Stage(long leerlingId,Date datumvan, Date datumtot,long bedrijfId) {
		this.leerlingId = leerlingId;
		this.bedrijfId = bedrijfId;
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
	
	public Long getLeerlingId() {
		return leerlingId;
	}
	
	public Long getBedrijfId() {
		return bedrijfId;
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
	public void setLeerlingId(Long leerlingId) {
		this.leerlingId = leerlingId;
	}
	
	public void setBedrijfId(Long bedrijfId) {
		this.bedrijfId = bedrijfId;
	}
	
		public void voegStagiarToe(Leerling stagiar) {
				stagiaires.add(stagiar);
			}
		public void voegBedrijfToe(StageBedrijf bedrijf) {
			bedrijven.add(bedrijf);
		}

}
