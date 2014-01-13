<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

if(gebruikerObject == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

Objectify ofy = ObjectifyService.begin();
Query<Stage> alleStages = ofy.query(Stage.class);
GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
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
    	<h1>Stages &raquo; Overzicht</h1>
    	
    	<!-- Submenu -->
        <div id="submenu">
        	<a href="competentielijst-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
            <a href="competentielijst-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
            <% if (gebruikerObject instanceof Medewerker) { %>
            	<a href="competentielijst-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a>
            	<a href="competentie-overzicht.jsp" class="button rounded-small white-gradient">Compenties</a>
            <% } %>
        </div>
        
        <!-- Overzicht -->
        <% for(Stage s : alleStages) { %>
	        	<div class="row">
		        	<div class="image"><img src="images/list.png" width="20" height="24" /></div>
		            <div class="description">Bedrijf  <%=gebruikerDao.getGebruiker(s.getBedrijfId()).getGebruikersnaam() %>voor <%=gebruikerDao.getGebruiker(s.getLeerlingId()).getGebruikersnaam()%>
		            van <%=sdf.format(s.getDatumVan())%> tot <%=sdf.format(s.getDatumTot()) %>
		        </div>
	        </a>
		<% } %>
    </div>
</div>
</body>
</html>