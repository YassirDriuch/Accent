<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%
Objectify ofy = ObjectifyService.begin();
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");
GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
VraagDao vraagDao = new VraagDaoOfyImpl();

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

//Variabelen setten
String leerlingNaam = ((Leerling)gebruikerDao.getGebruiker(cL.getLeerlingId())).getNaam();
String stageBedrijfNaam = ((StageBedrijf)gebruikerDao.getGebruiker(cL.getBedrijfId())).getNaam();
int aantalVragen = 0;
int gsl = 0;
int gss = 0;
double gemiddeldeScoreLeerling = 0;
double gemiddeldeScoreStageBedrijf = 0;
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
	    	Stagiaire: <%= leerlingNaam %><br />
	    	Stagebedrijf: <%= stageBedrijfNaam %><br />
	    	Aanmaakdatum: <%= cL.getAanmaakDatum() %><br /><br />
	    	
	    	<table cellspacing="0" cellpadding="0" class="rounded-small">
				<thead>
					<tr>
						<th width="50%">Competentie</th>
						<th width="20%">Aantal vragen</th>
						<th width="15%">Gem. score leerling</th>
						<th width="15%">Gem. score stagebedrijf</th>
					</tr>
				</thead>
				<tbody>
				<% 
				for(Competentie c : cL.getAlleCompetenties()) {					
					aantalVragen = 0;
					gsl = 0;
					gss = 0;
					
					for(Vraag v : vraagDao.getAlleVragen()) {
						if(v.getCompetentieId().equals(c.getId())) {
							aantalVragen += 1;
							
							Antwoord aB = bStageBedrijf.zoekAntwoord(v.getId());
							if(aB != null) {
								gsl += aB.getAntwoord();
							}
							
							Antwoord aL = bLeerling.zoekAntwoord(v.getId());
							if(aL != null) {
								gss += aL.getAntwoord();
							}
						}
					}

					gemiddeldeScoreLeerling = (gsl/aantalVragen);
					gemiddeldeScoreStageBedrijf = (gss/aantalVragen);
				%>
					<tr>
						<td><%=c.getCompetentie()%></td>
						<td><%=aantalVragen%></td>
						<td><%=gemiddeldeScoreLeerling%></td>
						<td><%=gemiddeldeScoreStageBedrijf%></td>
					</tr>
				<% } %>
				</tbody>
			</table>
    	</div>
    </div>
</div>
</body>
</html>