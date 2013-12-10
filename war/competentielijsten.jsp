<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

if(gebruikerObject == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
    	<h1>Competentielijsten</h1>
        <div id="submenu">
        	<a href="" class="button rounded-small white-gradient">Overzicht</a>
        	<% if (!(gebruikerObject instanceof Leerling) && !(gebruikerObject instanceof StageBedrijf)) { %>
            	<a href="" class="button rounded-small white-gradient">Toevoegen</a>
            <% } %>
            <a href="" class="button rounded-small white-gradient">Zoeken</a>
        </div>
        <div class="row">
        	<div class="image"><img src="images/list.png" width="20" height="24" /></div>
            <div class="description">Competentielijst 1 <font color="#999">op 31 Oktober 2013</font></div>
        </div>
        <div class="row">
        	<div class="image"><img src="images/list.png" width="20" height="24" /></div>
            <div class="description">Competentielijst 2 <font color="#999">op 26 Oktober 2013</font></div>
        </div>
        <div class="row">
        	<div class="image"><img src="images/list.png" width="20" height="24" /></div>
            <div class="description">Competentielijst 3 <font color="#999">op 22 Oktober 2013</font></div>
        </div>
    </div>
</div>
</body>
</html>