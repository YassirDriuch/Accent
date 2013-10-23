package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public class GebruikerDaoOfyImpl implements GebruikerDao {
	ArrayList<Gebruiker> gebruikers;
	
	public GebruikerDaoOfyImpl(){
		gebruikers = new ArrayList<Gebruiker>();
	}
	
	@Override
	public void voegGebruikerToe(Gebruiker g){
		
	}
	
	public ArrayList<Gebruiker> alleGebruikers(){
		return gebruikers;
	}
	
	@Override
	public Gebruiker getGebruiker(String gebruikersnaam){
		return null;
	}
	
	@Override
	public void updateGebruiker(Gebruiker g){
	}
	
	@Override
	public void verwijderGebruiker(Gebruiker g){
	}
	
}
