package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.AccentNijkerk.model.Competentie;
import com.appspot.AccentNijkerk.model.CompetentieDao;
import com.appspot.AccentNijkerk.model.CompetentieDaoOfyImpl;
import com.appspot.AccentNijkerk.model.CompetentieLijst;
import com.appspot.AccentNijkerk.model.CompetentieLijstDao;
import com.appspot.AccentNijkerk.model.CompetentieLijstDaoOfyImpl;

public class CompetentieLijstToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(CompetentieLijstToevoegenServlet.class.getName());
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("competentielijst-toevoegen.jsp");
		String lId = req.getParameter("leerling");
		String bId = req.getParameter("bedrijf");
		String[] competenties = req.getParameterValues("competenties");

		if(lId == null || bId == null || competenties == null) {
			//Aanmaken mislukt
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
			rd = req.getRequestDispatcher("competentielijst-toevoegen.jsp");
		} else {
			Long leerlingId = Long.parseLong(lId);
			Long bedrijfId = Long.parseLong(bId);
			
			//Datum van vandaag setten
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
			String today = sdf.format(cal.getTime());
				
			//Nieuwe competentielijst aanmaken
			CompetentieLijst cL = new CompetentieLijst(bedrijfId, leerlingId, today, false, false);
			CompetentieDao competentieDao = new CompetentieDaoOfyImpl();
			
			//Competenties toevoegen aan lijst
			for(String s : competenties) {
				Competentie c = competentieDao.getCompetentie(Long.parseLong(s));
				cL.voegCompetentieToe(c);
			}
			
			//CompetentieLijst toevoegen
			CompetentieLijstDao competentieLijstDao = new CompetentieLijstDaoOfyImpl();
			competentieLijstDao.voegCompetentieLijstToe(cL);
			
			req.setAttribute("msg", "<div class='succes'>Competentielijst succesvol aangemaakt</div>");
			log.info("CompetentieLijst voor " + leerlingId + " succesvol aangemaakt");
		}

		rd.forward(req, resp);
	}
}