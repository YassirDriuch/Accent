package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface GebruikerDao {
	public boolean voegGebruikerToe(Gebruiker g);
	public boolean updateGebruiker(Gebruiker g);
	public void verwijderGebruiker(Gebruiker g);
	public boolean isBezet(String gebruikersnaam);
	public Gebruiker getGebruiker(Long id);
	public ArrayList<Gebruiker> getAlleGebruikers();
	public ArrayList<Gebruiker> getAlleLeerlingen();
	public ArrayList<Gebruiker> getAlleDocenten();
	public ArrayList<Gebruiker> getAlleStageBedrijven();
}