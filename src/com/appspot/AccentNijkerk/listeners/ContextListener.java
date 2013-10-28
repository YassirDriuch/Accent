package com.appspot.AccentNijkerk.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.AccentNijkerk.model.*;
import com.googlecode.objectify.ObjectifyService;

public class ContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(ContextListener.class.getName());
	
	public void contextInitialized(ServletContextEvent sce) {
		//Objectify initialization
		initObjectifyClasses();
	
		//School aanmaken
		School school = new School("Accent Nijkerk", "Ds. Kuypersstraat 1", "033-2458819");
		log.info("School aangemaakt");
		
		//Testgebruikers aanmaken
		Gebruiker g1 = (Gebruiker) new Leerling("TestLeerling", "test", "Jason Koolman", "jason.koolman@hotmail.com", "5390531");
		Gebruiker g2 = (Gebruiker) new StageBedrijf("TestBedrijf", "test", "Bedrijfsnaam", "Industrielaan 32", "info@bedrijf.com", "030-8890566");
		Gebruiker g3 = (Gebruiker) new Medewerker("TestMedewerker", "test", "Medewerer", "Slingstraat 24", "info@medewerker.com");
		
		GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
		gebruikerDao.voegGebruikerToe(g1);
		gebruikerDao.voegGebruikerToe(g2);
		gebruikerDao.voegGebruikerToe(g3);
		
		log.info("TESTTTTTTT: " + gebruikerDao.getAlleGebruikers());
		
		//Objecten wegschrijven
		sce.getServletContext().setAttribute("SchoolObject", school);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		//ContextDestroyed
	}
	
	private void initObjectifyClasses() {
		ObjectifyService.register(StageBedrijf.class);
		ObjectifyService.register(Medewerker.class);
		ObjectifyService.register(Leerling.class);
		ObjectifyService.register(Gebruiker.class);
		ObjectifyService.register(Competentie.class);
		ObjectifyService.register(CompetentieLijst.class);
		ObjectifyService.register(Vraag.class);
	}
}