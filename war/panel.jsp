<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");
//Leerling l = (Leerling) gebruikerObject;

if(gebruikerObject == null){
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}
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
    <img src="images/logo.jpg" alt="" class="frontpage-logo" />
    <div id="menu">
    	<div id="menu-user" class="white-gradient rounded-small">
        	Ingelogd als <b><%=gebruikerObject.getGebruikersnaam()%></b><a href="/logout" class="menu-logout">Uitloggen</a>
        </div>
<% if(gebruikerObject instanceof Leerling) { %>
<a href="" class="menu-button white-gradient rounded-small">Leerling</a>
<% } else if(gebruikerObject instanceof StageBedrijf) { %>
<a href="" class="menu-button white-gradient rounded-small">StageBedrijf</a>
<% } else if(gebruikerObject instanceof Medewerker) { %>
<a href="" class="menu-button white-gradient rounded-small">Medewerker</a>
<% } %>
    </div>
</div>
</body>
</html>