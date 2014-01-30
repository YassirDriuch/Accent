<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");
GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();

if(gebruikerObject == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}

if(!(gebruikerObject instanceof StageBedrijf || gebruikerObject instanceof Docent || gebruikerObject instanceof Admin)){
	RequestDispatcher rd = request.getRequestDispatcher("panel.jsp");
	rd.forward(request, response);
	return;
}

String stringId = request.getParameter("id");
Long id = Long.parseLong(stringId);
Gebruiker gevraagd = gebruikerDao.getGebruiker(id);
if(gevraagd == null){
	RequestDispatcher rd = request.getRequestDispatcher("panel.jsp");
	rd.forward(request, response);
	return;
}
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
    	<h1>Stagiair &raquo; Bekijken</h1>
    	<div id="submenu">
            <% if(gebruikerObject instanceof Admin){ %><a href="/leerling-aanpassen?id=<%=id%>" class="button rounded-small white-gradient">Wijzigen</a><% } %>
        </div>
        <% Object msg = request.getAttribute("msg"); if (msg != null) { out.println(msg); } %>
        <div class="block" style="line-height: 140%;"><%=gevraagd.toString()%></div>
       
    </div>
</div>
</body>
</html>