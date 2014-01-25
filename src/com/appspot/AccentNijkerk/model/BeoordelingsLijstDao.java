package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface BeoordelingsLijstDao {
	public void voegBeoordelingsLijstToe(BeoordelingsLijst bL);
	public void updateBeoordelingsLijst(BeoordelingsLijst bL);
	public void verwijderBeoordelingsLijst(BeoordelingsLijst bL);
	public ArrayList<BeoordelingsLijst> getAlleBeoordelingsLijsten();
	public BeoordelingsLijst getBeoordelingsLijst(Long id);
}