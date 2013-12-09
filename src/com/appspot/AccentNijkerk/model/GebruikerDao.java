package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface GebruikerDao {
	public boolean voegGebruikerToe(Gebruiker g);
	public void updateGebruiker(Gebruiker g);
	public void verwijderGebruiker(Gebruiker g);
	public boolean isBezet(String gebruikersnaam);
	public Gebruiker getGebruiker(Long id);
	public ArrayList<Gebruiker> getAlleGebruikers();
}