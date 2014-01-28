package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.AccentNijkerk.model.Stage;
import com.appspot.AccentNijkerk.model.StageDao;
import com.appspot.AccentNijkerk.model.StageDaoOfyImpl;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class StageToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = -5060943264223383201L;
	private static final Logger log = Logger.getLogger(StageToevoegenServlet.class.getName());
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		
		Objectify ofy = ObjectifyService.begin();
		Query<Stage> alleStages = ofy.query(Stage.class);
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		Long leerlingId = Long.parseLong(req.getParameter("leerling"));
		Long bedrijfId = Long.parseLong(req.getParameter("bedrijf"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date datumvan = null;
		Date datumtot = null;
		String dsv = req.getParameter("datumv");
		String dst = req.getParameter("datumt");
		
		if(dsv != null && dsv != null){
			try {
				datumvan = sdf.parse(dsv);
				datumtot = sdf.parse(dst);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(leerlingId.equals("") || bedrijfId.equals("") || datumvan.equals("") || datumtot.equals("")) {
			//Aanmaken mislukt
			req.setAttribute("msg", "<div class='nosucces'>Niet alle velden zijn ingevuld</div>");
			rd = req.getRequestDispatcher("stage-toevoegen.jsp");
		} else {	
			//Nieuwe Stage aanmaken
			Stage s = new Stage(leerlingId, datumvan, datumtot, bedrijfId);
			StageDao StageDao = new StageDaoOfyImpl();
			StageDao.voegStageToe(s);
			for(Stage ss: alleStages){
				if(ss.getId().equals(s)){
					req.setAttribute("msg", "<div class='succes'>Stage:<br />" + s + "<br />is toegevoegd</div>");
				}
			}
			
			log.info("Stage voor " + leerlingId + " succesvol aangemaakt");
		}

		rd.forward(req, resp);
	}
}
