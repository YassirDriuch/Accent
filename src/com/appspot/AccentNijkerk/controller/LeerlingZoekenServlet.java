package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeerlingZoekenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(LeerlingZoekenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		String naam = req.getParameter("naam");
		Gebruiker teZoeken = gebruikerDao.zoekGebruiker(naam);
		if(teZoeken != null){
			req.setAttribute("msg", "<div class='succes'>Gebruiker:<br />" + teZoeken + "<br />is gezocht.<br /><br />Momenteel probleem: 1 User kan worden gezocht. Niet meerdere.</div>");
			log.info("S: " + teZoeken + " is gezocht!");
		}
		else {
			req.setAttribute("msg", "<div class='nosucces'>Gebruiker is niet gezocht. Bekijk of u alles goed heeft ingevoerd en probeer opnieuw!</div>");
		}
		rd.forward(req, resp);
	}
}