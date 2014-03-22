<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
Objectify ofy = ObjectifyService.begin();	
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");
GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
CompetentieLijstDao competentieLijstDao = new CompetentieLijstDaoOfyImpl();
BeoordelingsLijstDao beoordelingsLijstDao = new BeoordelingsLijstDaoOfyImpl();
CompetentieDao competentieDao = new CompetentieDaoOfyImpl();
VraagDao vraagDao = new VraagDaoOfyImpl();
Query<CompetentieLijst> alleCompetentieLijsten = ofy.query(CompetentieLijst.class);
int i = competentieLijstDao.getAlleCompetentieLijsten().size() - ingevuldCompetentieLijsten();
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
Calendar vandaag = Calendar.getInstance();
Calendar deadline = Calendar.getInstance();
deadline.set(2014,2,25);

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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Competentielijsten', 'Aantal'],
          ['Niet Ingevuld',     <%=i%>],
          ['Ingevuld',      <%= ingevuldCompetentieLijsten() %>]
        ]);

        var options = {
          title: 'Competentielijsten',
		  backgroundColor: '#F5F5F5',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
</script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Gebruikers', 'Aantal'],
          ['Leerlingen',     <%= gebruikerDao.getAlleLeerlingen().size() %>],
          ['Docenten',      <%= gebruikerDao.getAlleDocenten().size() %>],
		  ['Bedrijven',      <%= gebruikerDao.getAlleStageBedrijven().size() %>],
		  ['Administratoren',      <%= gebruikerDao.getAlleAdmins().size() %>]
        ]);

        var options = {
          title: 'Gebruikers',
		  backgroundColor: '#F5F5F5',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d_01'));
        chart.draw(data, options);
      }
</script>

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
        <% if(i != 0 && (vandaag.equals(deadline) || vandaag.after(deadline))) { %>
        <div class="nosucces"> WAARSCHUWING!! De deadline van <%= sdf.format(deadline.getTime()) %> is niet gehaald. Niet alle competentielijsten zijn ingevuld </div>
        <% } %>
        Totaal aantal gebruikers: <%= gebruikerDao.getAlleGebruikers().size() %><br />
        <b>KPI 1</b><br />
        <div id="piechart_3d_01" style="width: 800px; height: 400px;"> </div>    
        
        
        <b>KPI 2</b><br />
		<div id="piechart_3d" style="width: 800px; height: 400px;"> </div>      
        <b>KPI 3</b><br />    		
			<table cellspacing="0" cellpadding="0" class="rounded-small" id="my-table">
				<thead>
					<tr>
						<th width="33%">Competentie</th>
						<th width="33%">Keren gebruikt</th>
					</tr>
				</thead>
				<tbody>
        	<% 
			for(Competentie c : competentieDao.getAlleCompetenties()) {
				int kerenGebruikt = 0;
				for(CompetentieLijst cL : alleCompetentieLijsten) {
					for(Competentie c2 : cL.getAlleCompetenties()) {
						if(c.getCompetentie().equals(c2.getCompetentie())) {
							kerenGebruikt++;
						}
					}
				}
				
				int gemScore = 0;
				Query<Antwoord> alleAntwoorden = ofy.query(Antwoord.class);
				
				for(Vraag v : vraagDao.getAlleVragen()) {
					if(v.getCompetentieId().equals(c.getId())) {
						for(Antwoord a : alleAntwoorden) {
							if(a.getVraagId().equals(v.getId())) {
								gemScore += a.getAntwoord();
							}
						}
					}
				}
			%>
				
					<tr>
						<td><%=c.getCompetentie()%></td>
						<td><%=kerenGebruikt%></td>
					</tr>
				
        	<% } %>
        		</tbody>
        	</table>
        <% } else { %>
        	<%=gebruikerObject.toString()%>
        <% } %>
        </div>
    </div>
</div>
</body>
</html>