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
Query<Competentie> alleCompetenties = ofy.query(Competentie.class);
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
    	<form method="post" action="">
	    	<label class="form_label" for="leerling">Leerling</label>
            <select class="form_input rounded-small" name="leerling">
                <% for(Gebruiker g : alleLeerlingen) { %>
                <option value="<%=g.getId()%>"><%=g.getGebruikersnaam()%></option>
				<% } %>
            </select>
	        <label class="form_label" for="competenties">Competenties</label>
            <% for(Competentie c : alleCompetenties) { %>
                <input class="form_checkbox" type="checkbox" name="competenties" value="<%=c.getId()%>"><%=c.getCompetentie()%> 
			<% } %>
	        <input class="form_submit dark-gradient rounded-small" type="submit" name="submit" value="Aanmaken" />
		</form>
    </div>
</div>
</body>
</html>