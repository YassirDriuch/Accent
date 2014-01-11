<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

if(gebruikerObject == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}

Objectify ofy = ObjectifyService.begin();
Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
Query<StageBedrijf> alleBedrijven = ofy.query(StageBedrijf.class);
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
    	<h1>Stage &raquo; Toevoegen</h1>
    	
    	<!-- Submenu -->
        <div id="submenu">
        	<a href="stage-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
        	<% if (gebruikerObject instanceof Medewerker) { %>
            	<a href="stage-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a>
            <% } %>
            <a href="stage-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
        </div>
        
        <!-- Toevoegen -->
    	<% Object msg = request.getAttribute("msg"); if (msg != null) { out.println(msg); } %>
    	<form method="post" action="/stage-toevoegen">
    	<label class="form_label" for="Bedrijf">Bedrijf</label>
            <select class="form_input rounded-small" name="bedrijf">
                <% for(Gebruiker g : alleBedrijven) { %>
                <option value="<%=g.getId()%>"><%=g.getGebruikersnaam()%></option>
				<% } %>
            </select>
	    	<label class="form_label" for="leerling">Leerling</label>
            <select class="form_input rounded-small" name="leerling">
                <% for(Gebruiker g : alleLeerlingen) { %>
                <option value="<%=g.getId()%>"><%=g.getGebruikersnaam()%></option>
				<% } %>
            </select>
            <label class="form_label" for="naam">Van</label>
    		<input class="form_input rounded-small" type="date" name="datumv" /><br></br>
    		<label class="form_label" for="naam">Tot</label>
    		<input class="form_input rounded-small" type="date" name="datumt" />
    		<input class="form_submit dark-gradient rounded-small" type="submit" name="submit" value="Toevoegen" />
		</form>
    </div>
</div>
</body>
</html>