package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StageBedrijfWijzigenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(StageBedrijfWijzigenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String naam = req.getParameter("naam");
		String adres = req.getParameter("adres");
		String email = req.getParameter("email");		
		String telnr = req.getParameter("telnr");
		String stringId = req.getParameter("id");
		Long id = Long.parseLong(stringId);
		Gebruiker g = gebruikerDao.getGebruiker(id);
		RequestDispatcher rd = req.getRequestDispatcher("/stagebedrijf-aanpassen?id="+id);
			
		if(g == null){
			req.getRequestDispatcher("panel.jsp");
			rd.forward(req, resp);
			return;
		}
			
		if(gebruikersnaam.equals("") || naam.equals("") || adres.equals("") || email.equals("") || telnr.equals("")) {
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
		} 
		
		if(!(gebruikerDao.isBezet(gebruikersnaam)) || gebruikersnaam.equals(g.getGebruikersnaam())){
			g.setGebruikersnaam(gebruikersnaam);
			((StageBedrijf) g).setNaam(naam);
			((StageBedrijf)g).setAdres(adres);
			((StageBedrijf) g).setEmail(email);
			((StageBedrijf) g).setTelnr(telnr);
			gebruikerDao.updateGebruiker(g);
			log.info("Stagebedrijf " + g.toString() + " gewijzigd");
			req.setAttribute("msg", "<div class='succes'>Gebruiker is ge&uuml;pdatet");
		}
		
		else {
			req.setAttribute("msg", "<div class='nosucces'>Gebruikersnaam is al in gebruik");
		}
	rd.forward(req, resp);
	}
}