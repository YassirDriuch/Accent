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
    	<h1>Leerling Toevoegen</h1><br /><br />
    	<form method="post" action="LeerlingToevoegen.do">
    	<div style="float: left;"> 
    		<label class="form_label" for="gebruikersnaam">Gebruikersnaam</label>
    		<input class="form_input rounded-small" type="text" name="gebruikersnaam" />
    		<label class="form_label" for="wachtwoord">Wachtwoord</label>
    		<input class="form_input rounded-small" type="password" name="wachtwoord" />
    		<label class="form_label" for="naam">Naam</label>
    		<input class="form_input rounded-small" type="text" name="naam" />
    		<label class="form_label" for="email">E-Mailadres</label>
    		<input class="form_input rounded-small" type="email" name="email" />
    		<label class="form_label" for="leerlingnr">Leerlingnummer</label>
    		<input class="form_input rounded-small" type="number" name="leerlingnr" />
    		<input class="form_submit dark-gradient rounded-small" type="submit" name="submit" value="Aanmaken" />
		</div>
		</form>
	</div>
</div>
</body>
</html>