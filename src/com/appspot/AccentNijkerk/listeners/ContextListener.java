package com.appspot.AccentNijkerk.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.AccentNijkerk.model.*;
import com.googlecode.objectify.ObjectifyService;

public class ContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(ContextListener.class.getName());
	
	public void contextInitialized(ServletContextEvent sce) {
		initObjectifyClasses();
	
		//Testgebruikers aanmaken
		Gebruiker g1 = (Gebruiker) new Leerling("TestLeerling", "test", "Jason Koolman", "jason.koolman@hotmail.com", "5390531");
		Gebruiker g2 = (Gebruiker) new StageBedrijf("TestBedrijf", "test", "Bedrijfsnaam", "Industrielaan 32", "info@bedrijf.com", "030-8890566");
		Gebruiker g3 = (Gebruiker) new Medewerker("TestMedewerker", "test", "Medewerer", "Slingstraat 24", "info@medewerker.com");
		
		GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
		gebruikerDao.voegGebruikerToe(g1);
		gebruikerDao.voegGebruikerToe(g2);
		gebruikerDao.voegGebruikerToe(g3);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		//ContextDestroyed
	}
	
	private void initObjectifyClasses() {
		//Objectify classes initialiseren
		ObjectifyService.register(StageBedrijf.class);
		ObjectifyService.register(Medewerker.class);
		ObjectifyService.register(Leerling.class);
		ObjectifyService.register(Gebruiker.class);
		ObjectifyService.register(Competentie.class);
		ObjectifyService.register(CompetentieLijst.class);
		ObjectifyService.register(Vraag.class);
	}
}