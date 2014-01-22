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

if(!(gebruikerObject instanceof Docent)){
	RequestDispatcher rd = request.getRequestDispatcher("panel.jsp");
	rd.forward(request, response);
	return;
}
Objectify ofy = ObjectifyService.begin();
Query<Docent> alleDocenten = ofy.query(Docent.class);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/form.css" type="text/css" />
<title>Accent Nijkerk</title>
<script language="javascript" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="javascript/jquery.resizebg.js"></script>
</head>

<body>
<img src="images/bg.jpg" id="bg" alt="" />
<div id="panel-container" class="rounded shadow">
	<!-- Header !-->
	<jsp:include page="includes/header.jsp" />
    
    <!-- Content !-->
    <div id="content">
    	<h1>Docenten &raquo; Overzicht</h1>

		<!-- Submenu -->
        <div id="submenu">
        	<a href="docent-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
            <a href="docent-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a>
            <a href="docent-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
        </div>
        
        <!-- Overzicht -->
        <% for(Docent d : alleDocenten) { %>
        	<div class="row">
	        	<div class="image"><img src="images/user.png" width="20" height="24" /></div>
	            <div class="description"><a href="/docent-bezichtigen?id=<%=d.getId()%>"><%=d.getNaam()%></a></div>
                <div class="image" style="float:right; margin-right:5px;"><a href="/deleteUser?id=<%=d.getId()%>" onclick="return confirm('Weet u zeker dat u docent &quot;<%= d.getNaam() %>&quot; wilt verwijderen?')"> 
                <img src="images/delete.png" width="24" height="24" /></a></div>
	        </div>
		<% } %>
    </div>
</div>
</body>
</html>