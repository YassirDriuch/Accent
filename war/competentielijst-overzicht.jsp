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
Query<CompetentieLijst> alleCompetentieLijsten = ofy.query(CompetentieLijst.class);
Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
CompetentieLijstDao competentieLijstDao = new CompetentieLijstDaoOfyImpl();
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
    	<h1>Competentielijsten &raquo; Overzicht</h1>
    	
    	<!-- Submenu -->
        <div id="submenu">
        	<a href="competentielijst-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
            <% if (gebruikerObject instanceof Docent || gebruikerObject instanceof Admin) { %>
            	<a href="competentielijst-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a>
            	<a href="competentie-overzicht.jsp" class="button rounded-small white-gradient">Compenties</a>
            <% } %>
             <input id="cL_input" class="form_input_submenu rounded-small" type="text" placeholder="CompetentieLijst zoeken..." value = ""/>      
        </div>
        

        <!-- Overzicht -->
        			
        
        <% 
        if(gebruikerObject instanceof Docent || gebruikerObject instanceof Admin) { 
        	%>
        		
			<table cellspacing="0" cellpadding="0" class="rounded-small" id="my-table">
				<thead>
					<tr>
						<th width="8%">&nbsp;</th>
						<th width="36%">Stagiaire</th>
						<th width="36%">StageBedrijf</th>
						<th width="20%">Aanmaakdatum</th>
					</tr>
				</thead>
        	<% 
			for(CompetentieLijst cL : alleCompetentieLijsten) {
				if(cL.getLeerlingId().equals((((Leerling)gebruikerDao.getGebruiker(cL.getLeerlingId())).getId()))){
				%>
				<tbody>
					<tr>
						<td><a href="competentielijst-bekijken.jsp?id=<%=cL.getId()%>"><img src="images/list.png" width="20" height="24" border = "0"/></a></td>
						<td><a href="leerling-bezichtigen.jsp?id=<%=cL.getLeerlingId()%>"><%=((Leerling)gebruikerDao.getGebruiker(cL.getLeerlingId())).getNaam()%></a></td>
						<td><a href="stagebedrijf-bezichtigen.jsp?id=<%=cL.getBedrijfId()%>"><%=((StageBedrijf)gebruikerDao.getGebruiker(cL.getBedrijfId())).getNaam()%></a></td>
						<td><%=cL.getAanmaakDatum()%></td>
					</tr>
				</tbody>
        <% 
        			
        		}
        	}%>
        	</table>
        <%}
        %>
        
        <% 
        if(gebruikerObject instanceof Leerling) {
        	%>
			<table cellspacing="0" cellpadding="0" class="rounded-small" id="my-table">
				<thead>
					<tr>
						<th width="8%">&nbsp;</th>
						<th width="36%">Stagiaire</th>
						<th width="36%">StageBedrijf</th>
						<th width="20%">Aanmaakdatum</th>
					</tr>
				</thead>
        	<%
			for(CompetentieLijst cL : alleCompetentieLijsten) {
	        		if(cL.getLeerlingId().equals((((Leerling)gebruikerDao.getGebruiker(cL.getLeerlingId())).getId()))){ 
	    %>
				<tbody>
					<tr>			
					<td><a href="competentielijst-bekijken.jsp?id=<%=cL.getId()%>"><img src="images/list.png" width="20" height="24" border = "0"/></a></td>
							<td><a href="leerling-bezichtigen.jsp?id=<%=cL.getLeerlingId()%>"><%=((Leerling)gebruikerDao.getGebruiker(cL.getLeerlingId())).getNaam()%></a></td>
							<td><a href="stagebedrijf-bezichtigen.jsp?id=<%=cL.getBedrijfId()%>"><%=((StageBedrijf)gebruikerDao.getGebruiker(cL.getBedrijfId())).getNaam()%></a></td>
							<td><%=cL.getAanmaakDatum()%></td>
						</tr>
						</tbody>
						
		 <% 
        			
        		}
        	}%>
        	</table>
        <%}
        %>
        
        <%
        if(gebruikerObject instanceof StageBedrijf) {
        	%>
			<table cellspacing="0" cellpadding="0" class="rounded-small" id="my-table">
				<thead>
					<tr>
						<th width="8%">&nbsp;</th>
						<th width="36%">Stagiaire</th>
						<th width="36%">StageBedrijf</th>
						<th width="20%">Aanmaakdatum</th>
					</tr>
				</thead>
        	<%
			for(CompetentieLijst cL : alleCompetentieLijsten) {
					if(cL.getBedrijfId().equals((((StageBedrijf)gebruikerDao.getGebruiker(cL.getBedrijfId())).getId()))) { 
		%>
				<tbody>
					<tr>				
					<td><a href="competentielijst-bekijken.jsp?id=<%=cL.getId()%>"><img src="images/list.png" width="20" height="24" border = "0"/></a></td>
							<td><a href="leerling-bezichtigen.jsp?id=<%=cL.getLeerlingId()%>"><%=((Leerling)gebruikerDao.getGebruiker(cL.getLeerlingId())).getNaam()%></a></td>
							<td><a href="stagebedrijf-bezichtigen.jsp?id=<%=cL.getBedrijfId()%>"><%=((StageBedrijf)gebruikerDao.getGebruiker(cL.getBedrijfId())).getNaam()%></a></td>
							<td><%=cL.getAanmaakDatum()%></td>
						</tr>
						</tbody>
	 <% 
        			
        		}
        	}%>
        	</table>
        <%}
        %>
<script type="text/javascript">
$(document).ready(function(){
	// per keyInput
	$("#cL_input").keyup(function(){
		// Wanneer de value van de keyInput niet leeg is
		if( $(this).val() != "")
		{
			// laat alleen de table row zien die de inhoud bevat
			$("#my-table tbody>tr").hide();
			$("#my-table td:contains-ci('" + $(this).val() + "')").parent("tr").show();
		}
		else
		{
			// wanneer de search leeg wordt gezet laat dan alles weer zien
			$("#my-table tbody>tr").show();
		}
	});
});
// Onderstaand script is voor lowercase zoeken
$.extend($.expr[":"], 
{
    "contains-ci": function(elem, i, match, array) 
	{
		return (elem.textContent || elem.innerText || $(elem).text() || "").toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	}
});
</script>
</body>
</html>