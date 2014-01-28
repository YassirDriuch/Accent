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
if(!(gebruikerObject instanceof Docent || gebruikerObject instanceof Admin)){
	RequestDispatcher rd = request.getRequestDispatcher("panel.jsp");
	rd.forward(request, response);
	return;
}
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

Objectify ofy = ObjectifyService.begin();
Query<Stage> alleStages = ofy.query(Stage.class);
Query<StageBedrijf> alleBedrijven = ofy.query(StageBedrijf.class);
Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
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
        	<a href="stage-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
<<<<<<< HEAD
            <a href="stage-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a> <% } %>
            <input id="leerling_input" class="form_input_submenu rounded-small" type="text" placeholder="Stage zoeken..." value = ""/>      
=======
            <% if (gebruikerObject instanceof Docent) { %> <a href="stage-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a> <% } %>
            <input id="stage_input" class="form_input_submenu rounded-small" type="text" placeholder="Stage zoeken..." value = ""/>      
>>>>>>> c14b5d32c85226a50afc1b8dac33cf738ce6ceb1
        </div>
        
        <!-- Overzicht -->
        <div class="block">
        <table cellspacing="0" cellpadding="0" class="rounded-small" id="my-table">
			<thead>
				<tr>
					<th width="23%">Bedrijf</th>
					<th width="23%">Leerling</th>
					<th width="23%">Datum van</th>
					<th width="23%"> Datum tot</th>
					<th width="8%">&nbsp;</th>
        <% for(Stage s : alleStages) { %>
        	<% for(StageBedrijf b : alleBedrijven) { %>
        		<% for(Leerling l : alleLeerlingen) { %>
        		<% if(s.getBedrijfId().equals(b.getId()) && s.getLeerlingId().equals(l.getId())){%>
				</tr>
				<tbody>
				<tr>
				<td><a href="/stagebedrijf-bezichtigen?id=<%=b.getId()%>"><%=b.getNaam()%></a></td>
				<td><a href="/leerling-bezichtigen?id=<%=l.getId()%>"><%=l.getNaam()%></a></td>
				<td><%=sdf.format(s.getDatumVan())%></td>
				<td><%=sdf.format(s.getDatumTot()) %></td>
				<td>
						<a href="/deleteStage?id=<%=s.getId()%>" onclick="return confirm('Weet u zeker dat u de Stage van &quot;<%= l.getNaam() %>&quot; wilt verwijderen?')"><img src="images/delete.png"/></a>
                	</td>
				</tr>
		<% } 
		}
		}
		}%>
			</tbody>
				</table>
    </div>
    </div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	// per keyInput
	$("#stage_input").keyup(function(){
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