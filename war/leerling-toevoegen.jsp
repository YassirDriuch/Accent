<%@ page import="com.appspot.AccentNijkerk.model.*" %>
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
    	<h1>Stagiaires &raquo; Toevoegen</h1>
    	
    	<!-- Submenu -->
        <div id="submenu">
        	<a href="leerling-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
            <% if(gebruikerObject instanceof Docent || gebruikerObject instanceof Admin){ %><a href="leerling-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a><% } %>
            <a href="leerling-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
        </div>
        
    	<div class="block">
	    	<% Object msg = request.getAttribute("msg"); if (msg != null) { out.println(msg); } %>
	    	<form method="post" action="/leerling-toevoegen">
	    	<div style="float: left;"> 
	    		<label class="form_label" for="gebruikersnaam">Gebruikersnaam</label>
	    		<input class="form_input rounded-small" type="text" name="gebruikersnaam" />
	    		<input class="form_input rounded-small" type="hidden" name="wachtwoord" />
	    		<label class="form_label" for="naam">Naam</label>
	    		<input class="form_input rounded-small" type="text" name="naam" />
	    		<label class="form_label" for="email">E-Mailadres</label>
	    		<input class="form_input rounded-small" type="email" name="email" />
	    		<label class="form_label" for="leerlingnr">Leerlingnummer</label>
	    		<input class="form_input rounded-small" type="number" name="leerlingnr" />
	    		<input class="form_submit dark-gradient rounded-small" type="submit" name="submit" value="Aanmaken" onClick="generatepass()"/>
			</div>
			</form>
		</div>
	</div>
</div>
<script>
	var keylist="abcdefghijklmnopqrstuvwxyz123456789"
	var temp=''
	
	function generatepass(){
	temp=''
	for (i=0;i<8;i++) {
	temp+=keylist.charAt(Math.floor(Math.random()*keylist.length))
	}
	$("input[name='wachtwoord']").val(temp);
	return true;
	}

</script>
</body>
</html>