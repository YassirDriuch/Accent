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
Query<StageBedrijf> alleStageBedrijven = ofy.query(StageBedrijf.class);
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
    	<h1>Stagebedrijven &raquo; Overzicht</h1>
    	
    	<!-- Submenu -->
        <div id="submenu">
        	<a href="stagebedrijf-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
            <a href="stagebedrijf-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a>
            <a href="stagebedrijf-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
        </div>
        
        <!-- Overzicht -->
         <table cellspacing="0" cellpadding="0" class="rounded-small">
			<thead>
				<tr>
					<th width="92%">Bedrijf</th>
					<th width="8%">&nbsp;</th>
				</tr>
			</thead>
        <% for(StageBedrijf b : alleStageBedrijven) { %>
        <% if(gebruikerObject instanceof Docent) {%>
      
			<tbody>
        <tbody>
				<tr>
					<td><a href="/stagebedrijf-bezichtigen?id=<%=b.getId()%>"><%=b.getNaam()%></a></td>
					<td>
						<a href="/deleteUser?id=<%=b.getId()%>" onclick="return confirm('Weet u zeker dat u het bedrijf &quot;<%= b.getNaam() %>&quot; wilt verwijderen?')"><img src="images/delete.png"/>
                	</td>
				</tr>
			<% }else { %>
        <td><a href="/stagebedrijf-bezichtigen?id=<%=b.getId()%>"><%=b.getNaam()%></a></td>
		<% } %>
		<% } %>
    </tbody>
    </table>
</div>
</body>
</html>