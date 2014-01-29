package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StageBedrijfToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(StageBedrijfToevoegenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/stagebedrijf-toevoegen.jsp");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String naam = req.getParameter("naam");
		String adres = req.getParameter("adres");		
		String email = req.getParameter("email");
		String tel = req.getParameter("telnr");
		
		//Mail opzetten dmv properties te laden van je applicatie en een sessie.
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null); 
		

		if( gebruikersnaam.equals("") || wachtwoord.equals("") || naam.equals("") || email.equals("") || adres.equals("") || tel.equals("")) {
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
		} else {
			Gebruiker g = (Gebruiker) new StageBedrijf(gebruikersnaam, wachtwoord, naam, adres, email, tel);		
			if(gebruikerDao.voegGebruikerToe(g)){
				req.setAttribute("msg", "<div class='succes'>Bedrijf met account:<br />" + g + "<br />is toegevoegd</div>");
				log.info( g + " is Toegevoegd");
				req.setAttribute("session", session);
				sendMail(req, resp);
			} else{
				req.setAttribute("msg", "<div class='nosucces'>Bedrijf bestaat al</div>");
			}
		}
		rd.forward(req, resp);
	} 
	
	public void sendMail(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String naam = req.getParameter("naam");
		String email = req.getParameter("email");
		String verstuurMail = "jason.koolman86@gmail.com";
		String emailSupport = "info@accentnijkerk.nl";
		String foto = "http://hu-jason.appspot.com/images/logo.jpg";
		String foto2 = "http://hu-jason.appspot.com/images/tablet.png";
		String link = "http://hu-jason.appspot.com/index.jsp";
		Session session = (Session)req.getAttribute("session");
		
		//Onderwerp en bodypart
		String subject = "Er is een account aangemaakt.";
		String htmlBody = "<table>"
				+ "<a href='http://www.accentnijkerk.nl/'><img src='" + foto + "' /></a><br></br>"
				+ "<table cellpadding='0' cellspacing='0' width='100%' bgcolor='e4e4e4'><tr><td align = 'left'><img src='" + foto2 + "'</td>"
				+ "<td align = 'center'><h3>Welkom bij de Accent Nijkerk app! </h3><br></br> "
				+ "<p>Uw inloggegevens zijn: <br></br> Gebruikersnaam: " + " " + gebruikersnaam 
				+ " <br> </br> Wachtwoord: " + " " + wachtwoord 
				+ "<br></br> U kunt nu inloggen door: <a href='" + link + "'>hier</a> te klikken.</p>"
				+ "<br></br> Dit is een automatisch verzonden email. Voor vragen neem contact op met: "+ emailSupport
				+ "</td></tr></table></td>";
		try {
			//Nieuwe message creëren
		    Message msg = new MimeMessage(session);
		    //Opsplitsen voor html gebruik
		    Multipart mp = new MimeMultipart();
			MimeBodyPart htmlPart = new MimeBodyPart();
		    htmlPart.setContent(htmlBody, "text/html");
		    mp.addBodyPart(htmlPart);
			
			//Van, voor en onderwerp setten
		    msg.setFrom(new InternetAddress(verstuurMail, "Accent Nijkerk Competentiesysteem"));
		    msg.addRecipient(Message.RecipientType.TO,
		    new InternetAddress(email, naam));
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