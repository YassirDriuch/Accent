package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface CompetentieDao {
	public ArrayList<Competentie> alleCompetenties();
	public boolean voegCompetentieToe(Competentie c);
	public Competentie getCompetentie(String competentie);
	public void updateCompetentie(Competentie c);
	public void verwijderCompetentie(Competentie c);
}
