package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeerlingWijzigenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(LeerlingWijzigenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("leerling-overzicht.jsp");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String naam = req.getParameter("naam");
		String email = req.getParameter("email");		
		String leerlingnr = req.getParameter("leerlingnr");
		String stringId = req.getParameter("id");
		Long id = Long.parseLong(stringId);
		Gebruiker g = gebruikerDao.getGebruiker(id);
		
		if(g == null){
			req.getRequestDispatcher("panel.jsp");
			rd.forward(req, resp);
			return;
		}
		
		if(gebruikersnaam.equals("") || naam.equals("") || email.equals("") || leerlingnr.equals("")) {
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
		} else {
			g.setGebruikersnaam(gebruikersnaam);
			((Leerling) g).setNaam(naam);
			((Leerling) g).setEmail(email);
			((Leerling) g).setLeerlingnr(leerlingnr);
			gebruikerDao.updateGebruiker(g);
			req.setAttribute("msg", "<div class='succes'>Gebruiker is ge�pdatet");
		}
	rd.forward(req, resp);
	}
}