<%@ page import="com.appspot.AccentNijkerk.model.*" %>
<%@ page import="com.googlecode.objectify.Objectify" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>
<%@ page import="com.googlecode.objectify.Query" %>
<%
Objectify ofy = ObjectifyService.begin();
Gebruiker gebruikerObject = (Gebruiker) session.getAttribute("gebruikerObject");

//Check op ingelogde gebruiker en competentielijstId
if(gebruikerObject == null || request.getParameter("id") == null) {
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	return;
}

GebruikerDao gebruikerDao = new GebruikerDaoOfyImpl();
CompetentieLijst cL = ofy.find(CompetentieLijst.class, Long.parseLong(request.getParameter("id")));
Query<Vraag> alleVragen = ofy.query(Vraag.class);

//Check of de lijst door beide partijen zijn ingevuld
if(cL.isBedrijfIngevuld() && cL.isLeerlingIngevuld()) {
	RequestDispatcher rd = request.getRequestDispatcher("resultatenlijst.jsp?id=" + cL.getId());
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
    	<h1>Competentielijst voor <%=gebruikerDao.getGebruiker(cL.getLeerlingId()).getGebruikersnaam()%></h1>
    	<div class="show-notice"></div>
		<% 
		if(cL.isBedrijfIngevuld() && gebruikerObject instanceof StageBedrijf) {
			out.println("<div class='succes'>U heeft deze competentielijst succesvol ingevuld.</div>");
			out.println("Zodra " + ((Leerling) gebruikerDao.getGebruiker(cL.getLeerlingId())).getNaam() + " de lijst heeft ingevuld zullen hier de resultaten worden weergeven.");
		} else if (cL.isLeerlingIngevuld() && gebruikerObject instanceof Leerling) {
			out.println("<div class='succes'>U heeft deze competentielijst succesvol ingevuld.</div>");
			out.println("Zodra " + ((StageBedrijf) gebruikerDao.getGebruiker(cL.getBedrijfId())).getNaam() + " de lijst heeft ingevuld zullen hier de resultaten worden weergeven.");
		} else {
			for(Competentie c : cL.getAlleCompetenties()) { 
		%>
			<table cellspacing="0" cellpadding="0" class="rounded-small">
				<thead>
					<tr>
						<th width="76%"><%=c.getCompetentie()%></th>
						<th width="6%">1</th>
						<th width="6%">2</th>
						<th width="6%">3</th>
						<th width="6%">4</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (!(gebruikerObject instanceof Docent)) {
						for(Vraag v : alleVragen) {
			    			if(v.getCompetentieId().equals(c.getId())) { 
			    	%>
					<tr>
						<td><%=v.getVraag()%></td>
						<td><input type="radio" name="<%=v.getId()%>" value="1" /></td>
						<td><input type="radio" name="<%=v.getId()%>" value="2" /></td>
						<td><input type="radio" name="<%=v.getId()%>" value="3" /></td>
						<td><input type="radio" name="<%=v.getId()%>" value="4" /></td>
					</tr>
					<%  
							} 
						}
					}
					%>
				</tbody>
			</table>
			<% } %>
			
			<% if (!(gebruikerObject instanceof Docent)) { %>
			<a href="" class="submit-button white-gradient rounded-small">Invullen voltooien</a>
			<% } %>
		<% } %>
    </div>
</div>

<script type="text/javascript">
$("a.submit-button").click(function(e) {
	e.preventDefault();
	var submitme = true;
	
    $(':radio').each(function() {
        name = $(this).attr('name');
        if (submitme && !$(':radio[name="'+name+'"]:checked').length) {
        	submitme = false;
        	$(".show-notice").hide().html("<div class='nosucces'>Niet alle vragen zijn ingevuld</div>").fadeIn();
            $(':radio[name="'+name+'"]').parents('td').parents('tr').addClass('row-error');
        }
    });
    
    if(submitme) submitList();
});

function submitList() {
	var answers = [];

	$(':radio:checked').each(function() {
        name = $(this).attr('name');
        val = $(this).val();

	    var answer = { "vraagId": name, "antwoord": val };
	    answers.push(answer);
	});
	
	$.ajax({
		url: "beoordelingslijst-toevoegen",
	    type: "POST",
	    data: { "gebruikerId": <% out.print(gebruikerObject.getId()); %>, "competentieLijstId": <% out.print(cL.getId()); %>, "alleAntwoorden": JSON.stringify(answers) },
	    success: function() {
	    	location.reload();
	    }
	});
}
</script>
</body>
</html>