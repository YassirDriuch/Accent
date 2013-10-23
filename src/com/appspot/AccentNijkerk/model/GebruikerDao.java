package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface GebruikerDao {
	public ArrayList<Gebruiker> alleGebruikers();
	public void voegGebruikerToe(Gebruiker g);
	public Gebruiker getGebruiker(String gebruikersnaam);
	public void updateGebruiker(Gebruiker g);
	public void verwijderGebruiker(Gebruiker g);
}
