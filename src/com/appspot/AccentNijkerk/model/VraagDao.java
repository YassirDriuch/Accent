package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface VraagDao {
	public boolean voegVraagToe(Vraag v);
	public void updateVraag(Vraag v);
	public void verwijderVraag(Vraag v);
	public ArrayList<Vraag> getAlleVragen();
	public Vraag getVraag(Long id);
	public boolean isBezet(String vraag);
}
