package com.appspot.AccentNijkerk.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appspot.AccentNijkerk.model.Antwoord;
import com.appspot.AccentNijkerk.model.BeoordelingsLijst;
import com.appspot.AccentNijkerk.model.BeoordelingsLijstDao;
import com.appspot.AccentNijkerk.model.BeoordelingsLijstDaoOfyImpl;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class BeoordelingsLijstToevoegenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BeoordelingsLijstToevoegenServlet.class.getName());
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {
		String alleAntwoorden = req.getParameter("alleAntwoorden");
		Long gebruikerId = Long.parseLong(req.getParameter("gebruikerId"));
		Long competentieLijstId = Long.parseLong(req.getParameter("competentieLijstId"));
		
		try {
			JSONArray jsonArray = new JSONArray(alleAntwoorden);
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			String today = sdf.format(cal.getTime());
			
			BeoordelingsLijst bL = new BeoordelingsLijst(gebruikerId, competentieLijstId, today);
			
			for(int i=0; i<jsonArray.length(); i++) {
				JSONObject item = jsonArray.getJSONObject(i);
				
			    Long vraagId = Long.parseLong(item.getString("vraagId"));
			    int antwoord = Integer.parseInt(item.getString("antwoord"));
			    
			    Antwoord a = new Antwoord(vraagId, antwoord);
			    bL.voegAntwoordToe(a);
			}
			
			BeoordelingsLijstDao beoordelingsLijstDao = new BeoordelingsLijstDaoOfyImpl();
			beoordelingsLijstDao.voegBeoordelingsLijstToe(bL);
			
			log.info("Beoordelingslijst toegevoegd door: " + gebruikerId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}