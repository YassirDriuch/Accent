package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface GebruikerDao {
	public boolean voegGebruikerToe(Gebruiker g);
	public void updateGebruiker(Gebruiker g);
	public void verwijderGebruiker(Gebruiker g);
	public Gebruiker zoekGebruiker(String n);
	public boolean isBezet(String gebruikersnaam);
	public Gebruiker getGebruiker(Long id);
	public ArrayList<Gebruiker> getAlleGebruikers();
	public ArrayList<Gebruiker> getAlleLeerlingen();
	public ArrayList<Gebruiker> getAlleDocenten();
	public ArrayList<Gebruiker> getAlleStageBedrijven();
	public ArrayList<Gebruiker> getAlleAdmins();
}