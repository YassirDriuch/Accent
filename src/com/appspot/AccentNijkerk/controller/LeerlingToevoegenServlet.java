package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeerlingToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(LeerlingToevoegenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("leerling-toevoegen.jsp");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String naam = req.getParameter("naam");
		String email = req.getParameter("email");		
		String leerlingnr = req.getParameter("leerlingnr");
		
		if(gebruikersnaam.equals("") || wachtwoord.equals("") || naam.equals("") || email.equals("") || leerlingnr.equals("")) {
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
		} else {
			Gebruiker g = (Gebruiker) new Leerling(gebruikersnaam, wachtwoord, naam, email, leerlingnr);
			if(gebruikerDao.voegGebruikerToe(g)){
			req.setAttribute("msg", "<div class='succes'>Leerling:<br />" + g + "<br />is toegevoegd</div>");
			log.info( g + " is Toegevoegd");
			}
			else{
				req.setAttribute("msg", "<div class='nosucces'>Leerling bestaat al</div>");
			}
		}
	rd.forward(req, resp);
	}
}