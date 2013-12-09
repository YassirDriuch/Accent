package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface CompetentieDao {
	public void voegCompetentieToe(Competentie c);
	public void updateCompetentie(Competentie c);
	public void verwijderCompetentie(Competentie c);
	public Competentie getCompetentie(Long id);
	public ArrayList<Competentie> getAlleCompetenties();
}
