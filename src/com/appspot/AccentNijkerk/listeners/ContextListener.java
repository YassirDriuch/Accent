package com.appspot.AccentNijkerk.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.AccentNijkerk.model.Gebruiker;
import com.appspot.AccentNijkerk.model.Leerling;
import com.appspot.AccentNijkerk.model.Medewerker;
import com.appspot.AccentNijkerk.model.School;
import com.appspot.AccentNijkerk.model.StageBedrijf;

public class ContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(ContextListener.class.getName());
	
	public void contextInitialized(ServletContextEvent sce) {
		School school = new School("Accent Nijkerk", "Ds. Kuypersstraat 1", "033-2458819");
		log.info("School aangemaakt");
		
		//Testgebruikers aanmaken
		Gebruiker g1 = (Gebruiker) new Leerling("TestLeerling", "test", "Jason Koolman", "jason.koolman@hotmail.com", "5390531");
		Gebruiker g2 = (Gebruiker) new StageBedrijf("TestBedrijf", "test", "Bedrijfsnaam", "Industrielaan 32", "info@bedrijf.com", "030-8890566");
		Gebruiker g3 = (Gebruiker) new Medewerker("TestMedewerker", "test", "Medewerer", "Slingstraat 24", "info@medewerker.com");
		school.voegGebruikerToe(g1);
		school.voegGebruikerToe(g2);
		school.voegGebruikerToe(g3);
		
		//Objecten wegschrijven
		sce.getServletContext().setAttribute("SchoolObject", school);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		//
	}
}