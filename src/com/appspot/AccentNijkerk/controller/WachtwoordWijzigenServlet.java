package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WachtwoordWijzigenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(WachtwoordWijzigenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		String wachtwoordOud = req.getParameter("wachtwoord_oud");
		String wachtwoordNieuw = req.getParameter("wachtwoord");
		String wachtwoordBevestig = req.getParameter("wachtwoord2");
		Gebruiker g = (Gebruiker) req.getSession().getAttribute("gebruikerObject");
		if(g.getWachtwoord().equals(wachtwoordOud) && wachtwoordNieuw.equals(wachtwoordBevestig)) {
			g.setWachtwoord(wachtwoordNieuw);
			gebruikerDao.updateGebruiker(g);
			log.info("Wachtwoord van gebruiker " + g.getGebruikersnaam() + " is gewijzigd " + "g.getWachtwoord");
			req.setAttribute("msg", "<div class='succes'>Wachtwoord succesvol gewijzigd!");
		}
		else {
			req.setAttribute("msg", "<div class='nosucces'>U heeft een verkeerd huidig wachtwoord ingevuld of de nieuwe wachtwoorden komen niet overeen");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/wachtwoord-aanpassen.jsp");
		rd.forward(req, resp);
	}
}