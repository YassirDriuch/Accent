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
		
		Gebruiker admin = new Admin("admin", "test", "Administrator");
		if(!gebruikerDao.isBezet("admin")){
		gebruikerDao.voegGebruikerToe(admin);}
	
		//Testgebruikers aanmaken
		Gebruiker g1 = (Gebruiker) new Leerling("suzanne", "test", "Suzanne Smit", "suzanne@accent.nl", "5390531");
		Gebruiker g2 = (Gebruiker) new Leerling("jaap", "test", "Jaap Spiekenburg", "jaap@accent.nl", "5898856");
		Gebruiker g3 = (Gebruiker) new Leerling("joey", "test", "Joey Kulk", "joey@accent.nl", "5569885");
		Gebruiker g4 = (Gebruiker) new Leerling("kelly", "test", "Kelly Plat", "kelly@accent.nl", "5355985");
		Gebruiker g5 = (Gebruiker) new Leerling("anne", "test", "Anne Metz", "anne@accent.nl", "5895556");
		Gebruiker g6 = (Gebruiker) new Leerling("nick", "test", "Nick Bollee", "nick@accent.nl", "5785546");
		Gebruiker g7 = (Gebruiker) new Leerling("sanne", "test", "Sanne Hruk", "sanne@student.nl", "5455862");
		Gebruiker g8 = (Gebruiker) new Leerling("sam", "test", "Sam Schnell", "sam@accent.nl", "5265556");
		Gebruiker g9 = (Gebruiker) new Leerling("piet", "test", "Piet Mondi", "piet@accent.nl", "5985545");
		Gebruiker g10 = (Gebruiker) new Leerling("josh", "test", "Josh Mok", "josh@accent.nl", "5059525");
		Gebruiker g11 = (Gebruiker) new Leerling("leo", "test", "Leo West", "leo@accent.nl", "5688955");
		Gebruiker g12 = (Gebruiker) new Leerling("chris", "test", "Chris Verdi", "chris@accent.nl", "5982256");
		Gebruiker g13 = (Gebruiker) new Leerling("alexander", "test", "Alexander Boullier", "alexander@accent.nl", "5458212");
		Gebruiker g14 = (Gebruiker) new Leerling("vicki", "test", "Vicki Sax", "vickie@accent.nl", "5945214");
		Gebruiker g15 = (Gebruiker) new Leerling("remy", "test", "Remy oosterveen", "remy@accent.nl", "5326556");
		Gebruiker g16 = (Gebruiker) new Leerling("ariane", "test", "Ariane Hubers", "ariane@accent.nl", "5145151");
		Gebruiker g17 = (Gebruiker) new Leerling("leerling", "test", "Jason koolman", "jason.koolman@hotmail.com", "53025654");

		Gebruiker g20 = (Gebruiker) new StageBedrijf("stagebedrijf", "test", "Restaurant Vroom", "javalaan 32", "info@company.com", "030-88905663");
		Gebruiker g21 = (Gebruiker) new StageBedrijf("Jansen", "test", "Schildersbedrijf Jansen", "kajakstraat 6", "sjansen@hotmail.com", "030-2586732");
		Gebruiker g22 = (Gebruiker) new StageBedrijf("Langerak", "test", "Timmersbedrijf langerak", "viavastraat 86", "langeraktimmer@hotmail.com", "036-8656663");
		Gebruiker g23 = (Gebruiker) new StageBedrijf("Boonzaaijer", "test", "Bakkerij Boonzaaijer", "goedestraat 163", "boonzaaijer@hotmail.com", "036-6252421");
		Gebruiker g24 = (Gebruiker) new StageBedrijf("Kuerker", "test", "Bloemist Kuerker", "instellerstraat 45", "kuerk@hotmail.com", "041-3981547");

		
		Gebruiker g30 = (Gebruiker) new Docent("stagebegeleider", "test", "Frits Bakker", "Slingstraat 24", "info@stagebegeleider.com");
		Gebruiker g31 = (Gebruiker) new Docent("michiel", "test", "Michiel Langeveld", "Kiwistraat 45", "info@stagebegeleider.com");
		Gebruiker g32 = (Gebruiker) new Docent("gerard", "test", "Gerard van Houten", "Gansstraat 32", "info@stagebegeleider.com");
		Gebruiker g33 = (Gebruiker) new Docent("paula", "test", "Paula Slingers", "Voorstraat 134", "info@stagebegeleider.com");

		gebruikerDao.voegGebruikerToe(g1);
		gebruikerDao.voegGebruikerToe(g2);
		gebruikerDao.voegGebruikerToe(g3);
		gebruikerDao.voegGebruikerToe(g4);
		gebruikerDao.voegGebruikerToe(g5);
		gebruikerDao.voegGebruikerToe(g6);
		gebruikerDao.voegGebruikerToe(g7);
		gebruikerDao.voegGebruikerToe(g8);
		gebruikerDao.voegGebruikerToe(g9);
		gebruikerDao.voegGebruikerToe(g10);
		gebruikerDao.voegGebruikerToe(g11);
		gebruikerDao.voegGebruikerToe(g12);
		gebruikerDao.voegGebruikerToe(g13);
		gebruikerDao.voegGebruikerToe(g14);
		gebruikerDao.voegGebruikerToe(g15);
		gebruikerDao.voegGebruikerToe(g16);
		gebruikerDao.voegGebruikerToe(g17);
		gebruikerDao.voegGebruikerToe(g20);
		gebruikerDao.voegGebruikerToe(g21);
		gebruikerDao.voegGebruikerToe(g22);
		gebruikerDao.voegGebruikerToe(g23);
		gebruikerDao.voegGebruikerToe(g24);
		gebruikerDao.voegGebruikerToe(g30);
		gebruikerDao.voegGebruikerToe(g31);
		gebruikerDao.voegGebruikerToe(g32);
		gebruikerDao.voegGebruikerToe(g33);
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