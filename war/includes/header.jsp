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
	<a href="index.jsp"><img src="images/logo.jpg" alt="" class="frontpage-logo" /></a>
        
	<!-- Menu !-->
	<div id="menu">
		<div id="menu-user" class="white-gradient rounded-small">
			<%=gebruikerObject.getGebruikersnaam()%><a href="/logout" class="menu-logout">Uitloggen</a>
		</div>
     
		<% if (gebruikerObject instanceof Leerling) { %>
			<a href="competentielijst-overzicht.jsp" class="menu-button white-gradient rounded-small">Competentielijsten</a>
		<% } else if (gebruikerObject instanceof StageBedrijf) { %>
			<a href="leerling-overzicht.jsp" class="menu-button white-gradient rounded-small">Stagiares</a>
			<a href="competentielijst-overzicht.jsp" class="menu-button white-gradient rounded-small">Competentielijsten</a>
		<% } else if (gebruikerObject instanceof Docent) { %>
			<a href="leerling-overzicht.jsp" class="menu-button white-gradient rounded-small">Stagiares</a>
			<a href="stagebedrijf-overzicht.jsp" class="menu-button white-gradient rounded-small">Stagebedrijven</a>
			<a href="docent-overzicht.jsp" class="menu-button white-gradient rounded-small">Docenten</a>
			<a href="competentielijst-overzicht.jsp" class="menu-button white-gradient rounded-small">Competentielijsten</a>
			<a href="stage-toevoegen.jsp" class="menu-button white-gradient rounded-small">Stages</a>
		<% } %>
	</div>
</div>