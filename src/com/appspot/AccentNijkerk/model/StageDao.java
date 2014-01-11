package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;
import java.util.Date;

public interface StageDao {
	public ArrayList<Stage> getStages();
	public void voegStageToe(Stage s);
	public Stage getStage(Leerling l, Date datumvan , Date datumtot , StageBedrijf sb);
	public void updateStage(Stage s);
	public void verwijderStage(Stage s);
	public Stage getStages(Long id);
}
