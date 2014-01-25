package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface AntwoordDao {
	public void voegAntwoordToe(Antwoord a);
	public void updateAntwoord(Antwoord a);
	public void verwijderAntwoord(Antwoord a);
	public Antwoord getAntwoord(Long id);
	public ArrayList<Antwoord> getAntwoordenCP(Long competentieLijstId);
}
