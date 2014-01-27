package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import com.appspot.AccentNijkerk.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StageVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(GebruikerVerwijderenServlet.class.getName());
	StageDao stageDao = new StageDaoOfyImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		String stringId = req.getParameter("id");
		Long id = Long.parseLong(stringId);
		Stage teVerwijderen = stageDao.getStage(id);
		if(teVerwijderen != null){
			stageDao.verwijderStage(teVerwijderen);
			req.setAttribute("msg", "<div class='succes'>Stage:<br />" + teVerwijderen + "<br />is verwijderd.<br /><br />Herlaad de pagina als Stage nog in de lijst staat.</div>");
			log.info("DELETED: " + teVerwijderen + " is verwijderd!");
		}
		else {
			req.setAttribute("msg", "<div class='nosucces'>Stage is niet verwijderd. Stage bestaat niet (meer)!</div>");
		}
		rd.forward(req, resp);
	}
}