package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface CompetentieDao {
	public boolean voegCompetentieToe(Competentie c);
	public void updateCompetentie(Competentie c);
	public void verwijderCompetentie(Competentie c);
	boolean isBezet(String competentie);
	public Competentie getCompetentie(Long id);
	public ArrayList<Competentie> getAlleCompetenties();
}
