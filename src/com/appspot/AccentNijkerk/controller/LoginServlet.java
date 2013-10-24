package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.AccentNijkerk.model.Gebruiker;
import com.appspot.AccentNijkerk.model.School;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(LoginServlet.class.getName());
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		Gebruiker gebruiker = doLogin(gebruikersnaam, wachtwoord);
		
		if(gebruiker == null) { 
			req.setAttribute("msg", "<div class='nosucces'>Gebruikersnaam en wachtwoord combinatie incorrect.</div>");
			rd = req.getRequestDispatcher("index.jsp");
			log.info("Inloggen mislukt");
		} 
		else {
			req.getSession().setAttribute("gebruikerObject", gebruiker);
			rd = req.getRequestDispatcher("panel.jsp");
			log.info(gebruiker.getGebruikersnaam() + " is ingelogd");
		}
		
		rd.forward(req, resp);
	}
	
	//Login method
	private Gebruiker doLogin(String gebr, String ww) {
		School school = (School) getServletContext().getAttribute("SchoolObject");
		for(Gebruiker g : school.getAlleGebruikers()) {
			if (g.getGebruikersnaam().equals(gebr) && g.getWachtwoord().equals(ww)) {
				return g;
			}
		}
		return null;
	}
}