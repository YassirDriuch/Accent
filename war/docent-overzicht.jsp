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

if(!(gebruikerObject instanceof Docent || gebruikerObject instanceof Admin)){
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
            <% if(gebruikerObject instanceof Admin){%><a href="docent-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a><%}%>
            <input id="docent_input" class="form_input_submenu rounded-small" type="text" placeholder="Docent zoeken..." value = ""/>      
        </div>
        
        <!-- Overzicht -->
        <table cellspacing="0" cellpadding="0" class="rounded-small" id="my-table">
			<thead>
				<tr>
					<th width="92%">Docent</th>
					<th width="8%">&nbsp;</th>
				</thead>
        <% for(Docent d : alleDocenten) { %>
        <% if(gebruikerObject instanceof Admin) {%>
        </tr>
        <tbody>
				<tr>
					<td><a href="/stagebedrijf-bezichtigen?id=<%=d.getId()%>"><%=d.getNaam()%></a></td>
					<td>
						<a href="/deleteUser?id=<%=d.getId()%>" onclick="return confirm('Weet u zeker dat u de Docent &quot;<%= d.getNaam() %>&quot; wilt verwijderen?')"><img src="images/delete.png"/></a>
                	</td>
				
			<% }else { %>
        <td><a href="/docent-bezichtigen?id=<%=d.getId()%>"><%=d.getNaam()%></a></td>
        <td>&nbsp;</td>
		<% } %>
		</tr>
		<% } %>
    </tbody>
    </table>
    </div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	// per keyInput
	$("#docent_input").keyup(function(){
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