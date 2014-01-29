package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.AccentNijkerk.model.Competentie;
import com.appspot.AccentNijkerk.model.CompetentieDao;
import com.appspot.AccentNijkerk.model.CompetentieDaoOfyImpl;
import com.appspot.AccentNijkerk.model.CompetentieLijst;
import com.appspot.AccentNijkerk.model.CompetentieLijstDao;
import com.appspot.AccentNijkerk.model.CompetentieLijstDaoOfyImpl;
import com.appspot.AccentNijkerk.model.GebruikerDao;
import com.appspot.AccentNijkerk.model.GebruikerDaoOfyImpl;
import com.appspot.AccentNijkerk.model.Leerling;
import com.appspot.AccentNijkerk.model.StageBedrijf;

public class CompetentieLijstToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(CompetentieLijstToevoegenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("competentielijst-toevoegen.jsp");
		String lId = req.getParameter("leerling");
		String bId = req.getParameter("bedrijf");
		String[] competenties = req.getParameterValues("competenties");
		
		//Mail opzetten dmv properties te laden van je applicatie en een sessie.
				Properties props = new Properties();
				Session session = Session.getDefaultInstance(props, null); 

		if(lId == null || bId == null || competenties == null) {
			//Aanmaken mislukt
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
			rd = req.getRequestDispatcher("competentielijst-toevoegen.jsp");
		} else {
			Long leerlingId = Long.parseLong(lId);
			Long bedrijfId = Long.parseLong(bId);
			
			//Datum van vandaag setten
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
			String today = sdf.format(cal.getTime());
				
			//Nieuwe competentielijst aanmaken
			CompetentieLijst cL = new CompetentieLijst(bedrijfId, leerlingId, today, false, false);
			CompetentieDao competentieDao = new CompetentieDaoOfyImpl();
			
			//Competenties toevoegen aan lijst
			for(String s : competenties) {
				Competentie c = competentieDao.getCompetentie(Long.parseLong(s));
				cL.voegCompetentieToe(c);
			}
			
			//CompetentieLijst toevoegen
			CompetentieLijstDao competentieLijstDao = new CompetentieLijstDaoOfyImpl();
			competentieLijstDao.voegCompetentieLijstToe(cL);
			
			req.setAttribute("msg", "<div class='succes'>Competentielijst succesvol aangemaakt</div>");
			log.info("CompetentieLijst voor " + leerlingId + " succesvol aangemaakt");
			req.setAttribute("session", session);
			sendMail(req, resp);
		}

		rd.forward(req, resp);
	}
	public void sendMail(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		String lId = req.getParameter("leerling");
		String bId = req.getParameter("bedrijf");
		Long leerlingId = Long.parseLong(lId);
		Long bedrijfId = Long.parseLong(bId);
		String verstuurMail = "jason.koolman86@gmail.com";
		String emailSupport = "info@accentnijkerk.nl";
		String foto = "http://hu-jason.appspot.com/images/logo.jpg";
		String link = "http://hu-jason.appspot.com/competentielijst-overzicht.jsp";
		Session session = (Session)req.getAttribute("session");
		String leerlingnaam = (((Leerling)gebruikerDao.getGebruiker(leerlingId)).getNaam());
		String Bedrijfsnaam = (((StageBedrijf)gebruikerDao.getGebruiker(bedrijfId)).getNaam());
		String lEmail= (((Leerling)gebruikerDao.getGebruiker(leerlingId)).getEmail());
		String bEmail = (((StageBedrijf)gebruikerDao.getGebruiker(bedrijfId)).getEmail());
		String[] to = {bEmail,lEmail};
		
		//Onderwerp en bodypart
		String subject = "Er is een account aangemaakt.";
		String htmlBody = "<table>"
				+ "<a href='http://www.accentnijkerk.nl/'><img src='" + foto + "' /></a><br></br>"
				+ "<table cellpadding='0' cellspacing='0' width='100%' bgcolor='e4e4e4'><tr></td>"
				+ "<td align = 'center'><h3>Er is een CompetentieLijst aangemaakt! </h3><br></br> "
				+ "<p>De CompetentieLijst is gemaakt voor: <br></br> Leerling: " + " " + leerlingnaam 
				+ " <br> </br> bij Bedrijf: " + " " + Bedrijfsnaam 
				+ "<br></br> U kunt de competentielijst bekijken door: <a href='" + link + "'>hier</a> te klikken.</p>"
				+ "<br></br> Dit is een automatisch verzonden email. Voor vragen neem contact op met: "+ emailSupport
				+ "</td></tr></table></td>";
		try {
			//Array maken van emails
			InternetAddress[] addressTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++)
            {
                addressTo[i] = new InternetAddress(to[i]);
            }
			//Nieuwe message creëren
		    Message msg = new MimeMessage(session);
		    //Opsplitsen voor html gebruik
		    Multipart mp = new MimeMultipart();
			MimeBodyPart htmlPart = new MimeBodyPart();
		    htmlPart.setContent(htmlBody, "text/html");
		    mp.addBodyPart(htmlPart);
			
			//Van, voor en onderwerp setten
		    msg.setFrom(new InternetAddress(verstuurMail, "Accent Nijkerk Competentiesysteem"));
		    msg.setRecipients(RecipientType.TO, addressTo);
		    msg.setSubject(subject);
		    //Aan het nieuwe message de Multipart toevoegen als content
		    msg.setContent(mp);
		    Transport.send(msg);
		    log.info("email is verzonden");

		} catch (AddressException e) {
		    log.info("Geen geldig email adres");
		} catch (MessagingException e) {
		    log.info(e.toString());
		}
	}
}
