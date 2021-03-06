<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

if(gebruikerObject != null){
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
<div id="frontpage-container" class="rounded shadow">
    <img src="images/logo.jpg" alt="" class="frontpage-logo" />
    <% Object msg = request.getAttribute("msg"); if (msg != null) { out.println(msg); } %>
    <form method="post" action="login">
    	<label class="form_label" for="gebruikersnaam">Gebruikersnaam</label>
        <input class="form_input white-gradient rounded-small" type="text" name="gebruikersnaam" />
        <label class="form_label" for="wachtwoord">Wachtwoord</label>
        <input class="form_input white-gradient rounded-small" type="password" name="wachtwoord" />
        <input class="form_submit dark-gradient rounded-small" type="submit" name="submit" value="Inloggen" />
	</form>
</div>
</body>
</html>
