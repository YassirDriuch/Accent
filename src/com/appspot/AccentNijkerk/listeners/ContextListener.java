package com.appspot.AccentNijkerk.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.AccentNijkerk.model.Competentie;
import com.appspot.AccentNijkerk.model.CompetentieDao;
import com.appspot.AccentNijkerk.model.CompetentieDaoOfyImpl;
import com.appspot.AccentNijkerk.model.CompetentieLijst;
import com.appspot.AccentNijkerk.model.Docent;
import com.appspot.AccentNijkerk.model.Gebruiker;
import com.appspot.AccentNijkerk.model.GebruikerDao;
import com.appspot.AccentNijkerk.model.GebruikerDaoOfyImpl;
import com.appspot.AccentNijkerk.model.Leerling;
import com.appspot.AccentNijkerk.model.Stage;
import com.appspot.AccentNijkerk.model.StageBedrijf;
import com.appspot.AccentNijkerk.model.Vraag;
import com.appspot.AccentNijkerk.model.VraagDao;
import com.appspot.AccentNijkerk.model.VraagDaoOfyImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class ContextListener implements ServletContextListener {
	private static final Logger log = Logger.getLogger(ContextListener.class.getName());
	Objectify ofy = ObjectifyService.begin();
	
	public void contextInitialized(ServletContextEvent sce) {
		initObjectifyClasses();
	
		//Testgebruikers aanmaken
		Gebruiker g1 = (Gebruiker) new Leerling("Leerling", "test", "Jason Koolman", "jason.koolman@hotmail.com", "5390531");
		Gebruiker g2 = (Gebruiker) new StageBedrijf("StageBedrijf", "test", "Company BV", "Industrielaan 32", "info@company.com", "030-88905663");
		Gebruiker g3 = (Gebruiker) new Docent("StageBegeleider", "test", "Frits Bakker", "Slingstraat 24", "info@stagebegeleider.com");
		
		GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
		gebruikerDao.voegGebruikerToe(g1);
		gebruikerDao.voegGebruikerToe(g2);
		gebruikerDao.voegGebruikerToe(g3);
		
		//Testcompetenties aanmaken
		Competentie c1 = new Competentie("Sociale vaardigheden");
		Competentie c2 = new Competentie("Communicatie");
		Competentie c3 = new Competentie("Motivatie");
		
		CompetentieDao competentieDao = new CompetentieDaoOfyImpl();
		competentieDao.voegCompetentieToe(c1);
		competentieDao.voegCompetentieToe(c2);
		competentieDao.voegCompetentieToe(c3);
		
		//Testvragen aanmaken
		Vraag v1 = new Vraag("Wat is dit voor een vraag?", c1.getId());
		Vraag v2 = new Vraag("Is dit een goed antwoord?", c1.getId());
		Vraag v3 = new Vraag("Dat gaat wel goed?", c2.getId());
		Vraag v4 = new Vraag("Dit is nog een vraag?", c2.getId());
		Vraag v5 = new Vraag("Gaat het maar door dit?", c3.getId());
		VraagDao vraagDao = new VraagDaoOfyImpl();
		vraagDao.voegVraagToe(v1);
		vraagDao.voegVraagToe(v2);
		vraagDao.voegVraagToe(v3);
		vraagDao.voegVraagToe(v4);
		vraagDao.voegVraagToe(v5);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		//ContextDestroyed
	}
	
	private void initObjectifyClasses() {
		//Objectify classes initialiseren
		ObjectifyService.register(StageBedrijf.class);
		ObjectifyService.register(Docent.class);
		ObjectifyService.register(Leerling.class);
		ObjectifyService.register(Gebruiker.class);
		ObjectifyService.register(Competentie.class);
		ObjectifyService.register(CompetentieLijst.class);
		ObjectifyService.register(Vraag.class);
		ObjectifyService.register(Stage.class);
	}
}