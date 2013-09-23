package com.appspot.AccentNijkerk.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.AccentNijkerk.controller.LoginServlet;
import com.appspot.AccentNijkerk.model.Gebruiker;
import com.appspot.AccentNijkerk.model.Leerling;
import com.appspot.AccentNijkerk.model.Medewerker;
import com.appspot.AccentNijkerk.model.School;
import com.appspot.AccentNijkerk.model.StageBedrijf;

public class ContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(LoginServlet.class.getName());
	
	public void contextInitialized(ServletContextEvent sce) {
		School school = new School("Accent Nijkerk", "Ds. Kuypersstraat 1", "033-2458819");
		
		//Testgebruiker aanmaken
		Leerling l = new Leerling("TestLeerling", "jason.koolman@hotmail.com", "06-18999840");
		l.setGebruikersnaam("leerling");
		l.setWachtwoord("test");
		school.voegGebruikerToe(l);
		log.info("Testgebruiker aangemaakt");
		
		//Testbedrijf aanmaken
		StageBedrijf s = new StageBedrijf("TestBedrijf", "TestStraat 10", "test@bedrijf.nl", "030-5590122");
		s.setGebruikersnaam("bedrijf");
		s.setWachtwoord("test");
		school.voegGebruikerToe(s);
		log.info("Testbedrijf aangemaakt");
		
		//Testmedewerker aanmaken
		Medewerker m = new Medewerker("TestMedewerker", "TestStraat 10", "test@medewerker.nl");
		m.setGebruikersnaam("medewerker");
		m.setWachtwoord("test");
		school.voegGebruikerToe(m);
		log.info("Testmedewerker aangemaakt");
		
		//Objecten wegschrijven
		sce.getServletContext().setAttribute("SchoolObject", school);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		//
	}
}