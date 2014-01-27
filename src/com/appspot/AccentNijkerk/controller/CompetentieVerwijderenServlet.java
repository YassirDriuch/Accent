package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.AccentNijkerk.model.Competentie;
import com.appspot.AccentNijkerk.model.CompetentieDao;
import com.appspot.AccentNijkerk.model.CompetentieDaoOfyImpl;

public class CompetentieVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(CompetentieVerwijderenServlet.class.getName());
	CompetentieDao competentieDao = new CompetentieDaoOfyImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("competentie-overzicht.jsp");
		String stringId = req.getParameter("id");
		Long id = Long.parseLong(stringId);
		Competentie teVerwijderen = competentieDao.getCompetentie(id);
		
		if(teVerwijderen != null){
			competentieDao.verwijderCompetentie(teVerwijderen);
			req.setAttribute("msg", "<div class='succes'>Competentie \"" + teVerwijderen.getCompetentie() + "\" is verwijderd. Herlaad de pagina als competentie nog in de lijst staat.</div>");
			log.info("DELETED: " + teVerwijderen + " is verwijderd!");
		} else {
			req.setAttribute("msg", "<div class='nosucces'>De competentie kon niet worden verwijderd</div>");
		}
		
		rd.forward(req, resp);
	}
}