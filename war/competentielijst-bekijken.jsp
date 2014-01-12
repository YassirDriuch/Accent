<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

//Check op ingelogde gebruiker en competentielijstId
if(gebruikerObject == null || request.getParameter("id") == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}

Objectify ofy = ObjectifyService.begin();
GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
CompetentieLijst cL = ofy.find(CompetentieLijst.class, Long.parseLong(request.getParameter("id")));
Query<Vraag> alleVragen = ofy.query(Vraag.class);
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
    	<h1>Competentielijst voor <%=gebruikerDao.getGebruiker(cL.getLeerlingId()).getGebruikersnaam()%></h1>
        <div class="block">
		    <% for(Competentie c : cL.getAlleCompetenties()) {
		    	for(Vraag v : alleVragen) {
		    		if(v.getCompetentieId().equals(c.getId())) {
		    			out.println(v.getVraag() + "<br />");
		    		}
		    	}
		    } %>
	    </div>
    </div>
</div>
</body>
</html>