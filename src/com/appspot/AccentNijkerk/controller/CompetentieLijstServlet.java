package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompetentieLijstServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(CompetentieLijstServlet.class.getName());
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		String leerling = req.getParameter("leerling");
		String datum = req.getParameter("datum");
		
		if(leerling.equals("") || datum.equals("")) {
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
			rd = req.getRequestDispatcher("competentielijst.jsp");
		} else {
			//Nieuwe competentielijst aanmaken
			//CompetentieLijst cl = new CompetentieLijst();
			//CompetentieLijstDao competentieLijstDao = new CompetentieLijstDaoOfyImpl();
			log.info("CompetentieLijst voor " + leerling + " succesvol aangemaakt");
		}
		
		rd.forward(req, resp);
	}
}