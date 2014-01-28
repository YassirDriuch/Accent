<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%
Objectify ofy = ObjectifyService.begin();
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");
GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();

//Check op ingelogde gebruiker en competentielijstId
if(gebruikerObject == null || request.getParameter("id") == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}

CompetentieLijst cL = ofy.find(CompetentieLijst.class, Long.parseLong(request.getParameter("id")));

//Check of de lijst door beide partijen zijn ingevuld
if(!(cL.isBedrijfIngevuld() && cL.isLeerlingIngevuld())) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}

//Bijbehorende beoordelinglijst zoeken
Query<BeoordelingsLijst> query = ofy.query(BeoordelingsLijst.class).filter("competentieLijstId", cL.getId());
BeoordelingsLijst bLeerling = null;
BeoordelingsLijst bStageBedrijf = null;

if(query != null) {
	for (BeoordelingsLijst bL : query) {
	    if(gebruikerDao.getGebruiker(bL.getGebruikerId()) instanceof Leerling) {
	    	bLeerling = bL;
	    } else if(gebruikerDao.getGebruiker(bL.getGebruikerId()) instanceof StageBedrijf) {
	    	bStageBedrijf = bL;
	    }
	}
}

ArrayList<Antwoord> leerlingAntwoorden = bLeerling.getAlleAntwoorden();
ArrayList<Antwoord> stageBedrijfAntwoorden = bStageBedrijf.getAlleAntwoorden();
%>

<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/form.css" type="text/css" />
<title>Accent Nijkerk</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript" src="javascript/jquery.resizebg.js"></script>
</head>

<body>
<img src="images/bg.jpg" id="bg" alt="" />
<div id="panel-container" class="rounded shadow">
	<!-- Header !-->
	<jsp:include page="includes/header.jsp" />
    
    <!-- Content !-->
    <div id="content">
    	<h1>Resultatenlijst</h1>
    	<div class="block" style="line-height: 140%;">
	    	Stagiaire: <%= cL.getLeerlingId() %><br />
	    	Stagebedrijf: <%= cL.getBedrijfId() %><br />
	    	Aanmaakdatum: <%= cL.getAanmaakDatum() %><br /><br />
	    	Resultaten van beoordelinglijsten hier...
	    	<%= bLeerling.toString() %>
	    	<%= bStageBedrijf.toString() %>
    	</div>
    </div>
</div>
</body>
</html>