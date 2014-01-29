package com.appspot.AccentNijkerk.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.appspot.AccentNijkerk.model.*;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class ContextListener implements ServletContextListener {
	Objectify ofy = ObjectifyService.begin();
	private static final Logger log = Logger.getLogger(ContextListener.class.getName());
	
	public void contextInitialized(ServletContextEvent sce) {
		initObjectifyClasses();
		GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
		
		Gebruiker admin = new Admin("admin", "y3pr&dUw", "Administrator");
		if(!gebruikerDao.isBezet("admin")){
		gebruikerDao.voegGebruikerToe(admin);}
	
		//Testgebruikers aanmaken
		Gebruiker g1 = (Gebruiker) new Leerling("Leerling", "test", "Jason Koolman", "jason.koolman@hotmail.com", "5390531");
		Gebruiker g2 = (Gebruiker) new StageBedrijf("StageBedrijf", "test", "Company BV", "Industrielaan 32", "info@company.com", "030-88905663");
		Gebruiker g3 = (Gebruiker) new Docent("StageBegeleider", "test", "Frits Bakker", "Slingstraat 24", "info@stagebegeleider.com");
		gebruikerDao.voegGebruikerToe(g1);
		gebruikerDao.voegGebruikerToe(g2);
		gebruikerDao.voegGebruikerToe(g3);
		
		log.info("Testgebruikers aangemaakt");
		
		//Testcompetenties aanmaken
		Competentie c1 = new Competentie("Samenwerken en overleggen");
		Competentie c2 = new Competentie("Aandacht en begrip tonen");
		Competentie c3 = new Competentie("Klantvriendelijk en dienstverlenend");
		Competentie c4 = new Competentie("Instructies en procedures opvolgen");
		Competentie c5 = new Competentie("Plannen en organiseren");
		Competentie c6 = new Competentie("Kwaliteit en vakdeskundigheid");
		Competentie c7 = new Competentie("Veilig werken");
		Competentie c8 = new Competentie("Met druk en tegenslag omgaan");
		Competentie c9 = new Competentie("Omgaan met verandering en aanpassen");
		Competentie c10 = new Competentie("Leren");
		
		CompetentieDao competentieDao = new CompetentieDaoOfyImpl();
		competentieDao.voegCompetentieToe(c1);
		competentieDao.voegCompetentieToe(c2);
		competentieDao.voegCompetentieToe(c3);
		competentieDao.voegCompetentieToe(c4);
		competentieDao.voegCompetentieToe(c5);
		competentieDao.voegCompetentieToe(c6);
		competentieDao.voegCompetentieToe(c7);
		competentieDao.voegCompetentieToe(c8);
		competentieDao.voegCompetentieToe(c9);
		competentieDao.voegCompetentieToe(c10);
		
		
		log.info("Testcompetenties aangemaakt");
		
		//Testvragen aanmaken
		Vraag v1 = new Vraag("De leerling gedraagt zich zo dat samenwerking makkelijk gaat.", c1.getId());
		Vraag v2 = new Vraag("De leerling past zich aan de groep aan.", c1.getId());
		Vraag v3 = new Vraag("De leerling houdt zich aan de regels van het bedrijf.", c1.getId());
		Vraag v4 = new Vraag("De leerling zegt of doet dingen zo dat anderen er geen last van hebben.", c2.getId());
		Vraag v5 = new Vraag("De leerling laat de ander uitpraten.", c2.getId());
		Vraag v6 = new Vraag("De leerling luistert naar de ander.", c2.getId());
		Vraag v7 = new Vraag("De leerling doet geen dingen waarvan de leerling weet dat iemand er niet tegen kan.", c2.getId());
		Vraag v8 = new Vraag("De leerling gaat goed om met iets wat hem in vertrouwen is verteld", c2.getId());
		Vraag v9 = new Vraag("De leerling is zich bewust van klanten.", c3.getId());
		Vraag v10 = new Vraag("De leerling groet de klant.", c3.getId());
		Vraag v11 = new Vraag("De leerling toont passend gedrag: houding en taalgebruik.", c3.getId());
		Vraag v12 = new Vraag("De leerling doet de dingen in een logische volgorde.", c4.getId());
		Vraag v13 = new Vraag("De leerling geeft aan of de leerling een opdracht wel of niet begrijpt en kan uitvoeren.", c4.getId());
		Vraag v14 = new Vraag("De leerling gebruikt materialen en gereedschappen volgens de veiligheidsinstructies.", c4.getId());
		Vraag v15 = new Vraag("De leerling houdt zich aan de regels van het bedrijf.", c4.getId());
		Vraag v16 = new Vraag("De leerling luistert naar instructies.", c4.getId());
		Vraag v17 = new Vraag("De leerling neemt pauze als het werk het toelaat.", c4.getId());
		Vraag v18 = new Vraag("De leerling ruimt op na instructie.", c4.getId());
		Vraag v19 = new Vraag("De leerling kan op tijd komen", c5.getId());
		Vraag v20 = new Vraag("De leerling volgt de instructie op.", c6.getId());
		Vraag v21 = new Vraag("De leerling ruimt op wanneer het hem gevraagd wordt.", c6.getId());
		Vraag v22 = new Vraag("De leerling maakt het werk af volgens afspraak.", c6.getId());
		Vraag v23 = new Vraag("De leerling voert het werk in de voorgeschreven volgorde uit", c6.getId());
		Vraag v24 = new Vraag("De leerling doet de dingen op de afgesproken tijden.", c6.getId());
		Vraag v25 = new Vraag("De leerling kent een aantal vaktermen.", c6.getId());
		Vraag v26 = new Vraag("De leerling voert zijn taken onder begeleiding uit.", c6.getId());
		Vraag v27 = new Vraag("De leerling maakt materialen en gereedschappen op de juiste manier schoon.", c6.getId());
		Vraag v28 = new Vraag("De leerling ruimt materialen en gereedschappen na gebruik op.", c6.getId());
		Vraag v29 = new Vraag("De leerling krijgt hulp bij het gebruik van materialen.", c7.getId());
		Vraag v30 = new Vraag("De leerling kent de namen van de meest gebruikte materialen.", c7.getId());
		Vraag v31 = new Vraag("De leerling let op eigen veiligheid.", c7.getId());
		Vraag v32 = new Vraag("De leerling ruimt zelf zijn materiaal op.", c7.getId());
		Vraag v33 = new Vraag("De leerling gaat goed om met mensen met een andere achtergrond.", c7.getId());
		Vraag v34 = new Vraag("De leerling vindt het geen probleem om steeds andere taken uit te voeren.", c7.getId());
		Vraag v35 = new Vraag("De leerling meldt het als zich een probleem voordoet.", c8.getId());
		Vraag v36 = new Vraag("De leerling vraagt hulp bij problemen.", c8.getId());
		Vraag v37 = new Vraag("De leerling accepteert dat iedereen andere taken heeft.", c9.getId());
		Vraag v38 = new Vraag("De leerling gaat goed om met mensen met een andere achtergrond.", c9.getId());
		Vraag v39 = new Vraag("De leerling vindt het geen probleem om steeds andere taken uit te voeren.", c9.getId());
		Vraag v40 = new Vraag("De leerling toont interesse in nieuwe dingen.", c10.getId());
		Vraag v41 = new Vraag("De leerling staat open voor aanwijzingen.", c10.getId());
		Vraag v42 = new Vraag("De leerling stelt vragen.", c10.getId());
		Vraag v43 = new Vraag("De leerling toont inzet.", c10.getId());
		Vraag v44 = new Vraag("De leerling toont interesse in het werk.", c10.getId());

		VraagDao vraagDao = new VraagDaoOfyImpl();
		vraagDao.voegVraagToe(v1);
		vraagDao.voegVraagToe(v2);
		vraagDao.voegVraagToe(v3);
		vraagDao.voegVraagToe(v4);
		vraagDao.voegVraagToe(v5);
		vraagDao.voegVraagToe(v6);
		vraagDao.voegVraagToe(v7);
		vraagDao.voegVraagToe(v8);
		vraagDao.voegVraagToe(v9);
		vraagDao.voegVraagToe(v10);
		vraagDao.voegVraagToe(v11);
		vraagDao.voegVraagToe(v12);
		vraagDao.voegVraagToe(v13);
		vraagDao.voegVraagToe(v14);
		vraagDao.voegVraagToe(v15);
		vraagDao.voegVraagToe(v16);
		vraagDao.voegVraagToe(v17);
		vraagDao.voegVraagToe(v18);
		vraagDao.voegVraagToe(v19);
		vraagDao.voegVraagToe(v20);
		vraagDao.voegVraagToe(v21);
		vraagDao.voegVraagToe(v22);
		vraagDao.voegVraagToe(v23);
		vraagDao.voegVraagToe(v24);
		vraagDao.voegVraagToe(v25);
		vraagDao.voegVraagToe(v26);
		vraagDao.voegVraagToe(v27);
		vraagDao.voegVraagToe(v28);
		vraagDao.voegVraagToe(v29);
		vraagDao.voegVraagToe(v30);
		vraagDao.voegVraagToe(v31);
		vraagDao.voegVraagToe(v32);
		vraagDao.voegVraagToe(v33);
		vraagDao.voegVraagToe(v34);
		vraagDao.voegVraagToe(v35);
		vraagDao.voegVraagToe(v36);
		vraagDao.voegVraagToe(v37);
		vraagDao.voegVraagToe(v38);
		vraagDao.voegVraagToe(v39);
		vraagDao.voegVraagToe(v40);
		vraagDao.voegVraagToe(v41);
		vraagDao.voegVraagToe(v42);
		vraagDao.voegVraagToe(v43);
		vraagDao.voegVraagToe(v44);
		log.info("Testvragen aanemaakt");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		//ContextDestroyed
	}
	
	private void initObjectifyClasses() {
		//Objectify classes initialiseren
		ObjectifyService.register(Admin.class);
		ObjectifyService.register(StageBedrijf.class);
		ObjectifyService.register(Docent.class);
		ObjectifyService.register(Leerling.class);
		ObjectifyService.register(Gebruiker.class);
		ObjectifyService.register(Competentie.class);
		ObjectifyService.register(CompetentieLijst.class);
		ObjectifyService.register(Vraag.class);
		ObjectifyService.register(Stage.class);
		ObjectifyService.register(BeoordelingsLijst.class);
	}
}