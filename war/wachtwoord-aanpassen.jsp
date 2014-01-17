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
    	<h1>Persoonlijk &raquo; Wachtwoord wijzigen</h1>        
    	<div class="block">
	    	<% Object msg = request.getAttribute("msg"); if (msg != null) { out.println(msg); } %>
	    	<form method="post" action="/wachtwoord-wijzigen">
                <div style="float: left;"> 
                    <label class="form_label" for="wachtwoord_oud">Oude wachtwoord</label>
                    <input class="form_input rounded-small" type="password" name="wachtwoord_oud" />
                    <label class="form_label" for="wachtwoord">Nieuwe wachtwoord</label>
                    <input class="form_input rounded-small" type="password" name="wachtwoord" />
                    <label class="form_label" for="wachtwoord2">Bevestig nieuwe wachtwoord</label>
                    <input class="form_input rounded-small" type="password" name="wachtwoord2" />
                    <input class="form_submit dark-gradient rounded-small" type="submit" name="submit" value="Wijzigen" />
                </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>