package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.AccentNijkerk.model.Gebruiker;
import com.appspot.AccentNijkerk.model.Leerling;
import com.appspot.AccentNijkerk.model.Medewerker;
import com.appspot.AccentNijkerk.model.StageBedrijf;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(LoginServlet.class.getName());
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		
		//doLogin
		Gebruiker gebruiker = doLogin(gebruikersnaam, wachtwoord);
		
		if(gebruiker == null) {
			//Inloggen mislukt
			req.setAttribute("msg", "<div class='nosucces'>Gebruikersnaam en wachtwoord combinatie incorrect.</div>");
			rd = req.getRequestDispatcher("index.jsp");
			log.info("Inloggen mislukt");
		} 
		else {
			//Inloggen geslaagd
			req.getSession().setAttribute("gebruikerObject", gebruiker);
			rd = req.getRequestDispatcher("panel.jsp");
			log.info(gebruiker.getGebruikersnaam() + " is ingelogd");
		}
		
		rd.forward(req, resp);
	}
	
	//Login method
	private Gebruiker doLogin(String gebr, String ww) {
		Objectify ofy = ObjectifyService.begin();
		gebr = gebr.toLowerCase();
		
		//Leerlingen doorlopen
		Query<Leerling> leerlingQ = ofy.query(Leerling.class);
		for(Leerling l : leerlingQ) {
			if (l.getGebruikersnaam().toLowerCase().equals(gebr) && l.getWachtwoord().equals(ww)) {
				return (Gebruiker) l;
			}
		}
		
		//Stagebedrijven doorlopen
		Query<StageBedrijf> stagebedrijfQ = ofy.query(StageBedrijf.class);
		for(StageBedrijf g : stagebedrijfQ) {
			if (g.getGebruikersnaam().toLowerCase().equals(gebr) && g.getWachtwoord().equals(ww)) {
				return (Gebruiker) g;
			}
		}
		
		//Medewerkers doorlopen
		Query<Medewerker> medewerkerQ = ofy.query(Medewerker.class);
		for(Medewerker m : medewerkerQ) {
			if (m.getGebruikersnaam().toLowerCase().equals(gebr) && m.getWachtwoord().equals(ww)) {
				return (Gebruiker) m;
			}
		}
		
		return null;
	}
}