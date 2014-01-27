package com.appspot.AccentNijkerk.model;

import java.util.ArrayList;

public interface StageDao {
	public ArrayList<Stage> getStages();
	public void voegStageToe(Stage s);
	public Stage getStage(Long id);
	public void updateStage(Stage s);
	public void verwijderStage(Stage s);
	public Stage getStages(Long id);
}
