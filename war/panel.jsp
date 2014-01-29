<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
CompetentieLijstDao competentieLijstDao = new CompetentieLijstDaoOfyImpl();

if(gebruikerObject == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}%>
<%!
public int ingevuldCompetentieLijsten(){
	Objectify ofy = ObjectifyService.begin();	
	Query<CompetentieLijst> alleCompetentieLijsten = ofy.query(CompetentieLijst.class);
	int i = 0;
	for(CompetentieLijst cL : alleCompetentieLijsten){
		if(cL.isLeerlingIngevuld() && cL.isBedrijfIngevuld()){
			i++;
		}
	}
	return i;
}%>
	

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
    	<h1>Accountgegevens</h1>
    	<div id="submenu">
        	<a href="wachtwoord-aanpassen.jsp" class="button rounded-small white-gradient">Wachtwoord wijzigen</a>
        </div>
        <div class="block">
        <% if(gebruikerObject instanceof Admin){ %>
        Totaal aantal gebruikers: <%= gebruikerDao.getAlleGebruikers().size() %><br />
        Waarvan Leerlingen: <%= gebruikerDao.getAlleLeerlingen().size() %><br />
        Waarvan Bedrijven: <%= gebruikerDao.getAlleStageBedrijven().size() %><br />
        Waarvan Docenten: <%= gebruikerDao.getAlleDocenten().size() %><br /><br />
        Totaal Competentielijsten: <%= competentieLijstDao.getAlleCompetentieLijsten().size() %><br />
        Aantal ingevulde competentielijsten: <%= ingevuldCompetentieLijsten() %>
        
        
        <% } else { %>
        	<%=gebruikerObject.toString()%>
        <% } %>
        </div>
    </div>
</div>
</body>
</html>