package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StageBedrijfToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(LeerlingToevoegenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("stagebedrijf-toevoegen.jsp");
		String gebruikersnaam = req.getParameter("gebruikersnaam");
		String wachtwoord = req.getParameter("wachtwoord");
		String naam = req.getParameter("naam");
		String adres = req.getParameter("adres");		
		String email = req.getParameter("email");
		String tel = req.getParameter("tel");
		
		if(checkInteger(tel)) {
			if(gebruikersnaam.equals("") || wachtwoord.equals("") || naam.equals("") || email.equals("") || adres.equals("") || tel.equals("")) {
				req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
			} else {
				Gebruiker g = (Gebruiker) new StageBedrijf(gebruikersnaam, wachtwoord, naam, adres, email, tel);
				
				if(gebruikerDao.voegGebruikerToe(g)){
					req.setAttribute("msg", "<div class='succes'>Bedrijf met account:<br />" + g + "<br />is toegevoegd</div>");
					log.info( g + " is Toegevoegd");
				} else{
					req.setAttribute("msg", "<div class='nosucces'>Bedrijf bestaat al</div>");
				}
			}
		} else {
			req.setAttribute("msg", "<div class='nosucces'>Vul een geldige telefoonnummer in</div>");
		}
		
		rd.forward(req, resp);
	}
	
	private boolean checkInteger(String integer) {
		boolean result = true;
		try {
			Integer.parseInt(integer);
		}
		catch(NumberFormatException e){
			result = false;
		}
		return result;
	}
}