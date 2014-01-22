package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GebruikerVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(GebruikerVerwijderenServlet.class.getName());
	GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		String stringId = req.getParameter("id");
		Long id = Long.parseLong(stringId);
		Gebruiker teVerwijderen = gebruikerDao.getGebruiker(id);
		if(teVerwijderen != null){
			gebruikerDao.verwijderGebruiker(teVerwijderen);
			req.setAttribute("msg", "<div class='succes'>Gebruiker:<br />" + teVerwijderen + "<br />is verwijderd.<br /><br />Herlaad de pagina als gebruiker nog in de lijst staat.</div>");
			log.info("DELETED: " + teVerwijderen + " is verwijderd!");
		}
		else {
			req.setAttribute("msg", "<div class='nosucces'>Gebruiker is niet verwijderd. Gebruiker bestaat niet (meer)!</div>");
		}
		rd.forward(req, resp);
	}
}