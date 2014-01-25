package com.appspot.AccentNijkerk.model;


public interface AntwoordDao {
	public void voegAntwoordToe(Antwoord a);
	public void updateAntwoord(Antwoord a);
	public void verwijderAntwoord(Antwoord a);
	public Antwoord getAntwoord(Long id);
}
