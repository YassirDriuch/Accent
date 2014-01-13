package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface CompetentieLijstDao {
	public void voegCompetentieLijstToe(CompetentieLijst cL);
	public void updateCompetentieLijst(CompetentieLijst cL);
	public void verwijderCompetentieLijst(CompetentieLijst cL);
	public ArrayList<CompetentieLijst> getAlleCompetentieLijsten();
	public CompetentieLijst getCompetentieLijst(Long id);
}
