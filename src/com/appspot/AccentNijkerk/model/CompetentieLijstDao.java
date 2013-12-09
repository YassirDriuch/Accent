package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface CompetentieLijstDao {
	public ArrayList<CompetentieLijst> alleCompetentieLijsten();
	public void voegCompetentieLijstToe(CompetentieLijst cL);
	public CompetentieLijst getCompetentieLijst(Long id);
	public void updateCompetentieLijst(CompetentieLijst cL);
	public void verwijderCompetentieLijst(CompetentieLijst cL);
}
