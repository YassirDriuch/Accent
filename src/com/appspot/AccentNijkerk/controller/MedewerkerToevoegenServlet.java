package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MedewerkerToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(LeerlingToevoegenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("medewerker-toevoegen.jsp");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String naam = req.getParameter("naam");
		String adres = req.getParameter("adres");		
		String email = req.getParameter("email");
		
		if(gebruikersnaam.equals("") || wachtwoord.equals("") || naam.equals("") || email.equals("") || adres.equals("")) {
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
		} else {
			Gebruiker g = (Gebruiker) new Medewerker(gebruikersnaam, wachtwoord, naam, adres, email);
			if(gebruikerDao.voegGebruikerToe(g)){
			req.setAttribute("msg", "<div class='succes'>Docent:<br />" + g + "<br />is toegevoegd</div>");
			log.info( g + " is Toegevoegd");
			}
			else{
				req.setAttribute("msg", "<div class='nosucces'>Docent bestaat al</div>");
			}
		}
	rd.forward(req, resp);
	}
}