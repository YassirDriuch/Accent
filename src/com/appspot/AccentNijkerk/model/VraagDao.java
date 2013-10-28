package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface VraagDao {
	public ArrayList<Vraag> alleVragen();
	public void voegVraagToe(Vraag v);
	public Vraag getVraag(String vraag);
	public void updateVraag(Vraag v);
	public void verwijderVraag(Vraag v);
}
