<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

if(gebruikerObject == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}
%>

<div id="header">
	<img src="images/logo.jpg" alt="" class="frontpage-logo" />
        
	<!-- Menu !-->
	<div id="menu">
		<div id="menu-user" class="white-gradient rounded-small">
			Ingelogd als <b><%=gebruikerObject.getGebruikersnaam()%></b><a href="/logout" class="menu-logout">Uitloggen</a>
		</div>
     
		<a href="panel.jsp" class="menu-button white-gradient rounded-small">Home</a>
		<% if (gebruikerObject instanceof Leerling) { %>
			<a href="competentielijsten.jsp" class="menu-button white-gradient rounded-small">Competentielijsten</a>
		<% } else if (gebruikerObject instanceof StageBedrijf) { %>
			<a href="stagiares.jsp" class="menu-button white-gradient rounded-small">Stagiares</a>
			<a href="competentielijsten.jsp" class="menu-button white-gradient rounded-small">Competentielijsten</a>
		<% } else if (gebruikerObject instanceof Medewerker) { %>
			<a href="stagiares.jsp" class="menu-button white-gradient rounded-small">Stagiares</a>
			<a href="stagebedrijven.jsp" class="menu-button white-gradient rounded-small">Stagebedrijven</a>
			<a href="competentielijst-aanmaken.jsp" class="menu-button white-gradient rounded-small">Competentielijst aanmaken</a>
		<% } %>
	</div>
</div>