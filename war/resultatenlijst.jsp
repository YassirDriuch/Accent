<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%
Objectify ofy = ObjectifyService.begin();
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

//Check op ingelogde gebruiker en competentielijstId
if(gebruikerObject == null || request.getParameter("id") == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}

CompetentieLijst cL = ofy.find(CompetentieLijst.class, Long.parseLong(request.getParameter("id")));

//Check of de lijst door beide partijen zijn ingevuld
if(!((cL.isBedrijfIngevuld() && cL.isLeerlingIngevuld() && (gebruikerObject.getId() == cL.getBedrijfId() || gebruikerObject.getId()== cL.getLeerlingId()))|| gebruikerObject instanceof Docent || gebruikerObject instanceof Admin)) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}
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
    	</div>
    </div>
</div>
</body>
</html>