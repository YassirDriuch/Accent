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
Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
Query<StageBedrijf> alleStageBedrijven = ofy.query(StageBedrijf.class);
Query<Competentie> alleCompetenties = ofy.query(Competentie.class);
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
    	<h1>Competentielijsten &raquo; Toevoegen</h1>
    	
    	<!-- Submenu -->
        <div id="submenu">
        	<a href="competentielijst-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
            <a href="competentielijst-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
            <% if (gebruikerObject instanceof Docent) { %>
            	<a href="competentielijst-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a>
            	<a href="competentie-overzicht.jsp" class="button rounded-small white-gradient">Compenties</a>
            <% } %>
        </div>
        
        <!-- Toevoegen -->
        <div class="block">
    		<% Object msg = request.getAttribute("msg"); if (msg != null) { out.println(msg); } %>
	    	<form method="post" action="/competentielijst-toevoegen">
	    		<div style="float: left; margin-right: 20px;">
			    	<label class="form_label" for="leerling">Leerling</label>
			    	<input id="leerling_input" class="form_input rounded-small" type="text" placeholder="Leerling zoeken..." />
		            <select id="leerling_select" class="form_input rounded-small" style="width: 245px;" name="leerling" multiple="multiple">
		                <% for(Gebruiker l : alleLeerlingen) { %>
		                	<option value="<%=l.getId()%>"><%=((Leerling)l).getNaam()%></option>
						<% } %>
		            </select>
		        </div>
		        <div style="float: left; margin-right: 20px;">
	                <label class="form_label" for="bedrijf">Bedrijf</label>
	                <input id="bedrijf_input" class="form_input rounded-small" type="text" placeholder="Bedrijf zoeken..." />
	                <select id="bedrijf_select" class="form_input rounded-small" style="width: 245px;" name="bedrijf" multiple="multiple">
	                	<% for(Gebruiker sb : alleStageBedrijven) { %>
	                    	<option value="<%=sb.getId()%>"><%=((StageBedrijf)sb).getNaam()%></option>
	                    <% } %>
	                </select>
                </div>
                <div style="float: left;">
			        <label class="form_label" for="competenties">Competenties</label>
		            <% for(Competentie c : alleCompetenties) { %>
		                <label class="form_checkbox_label"><input type="checkbox" name="competenties" value="<%=c.getId()%>"><%=c.getCompetentie()%></label>
					<% } %>
				</div>
		        <input class="form_submit dark-gradient rounded-small" type="submit" name="submit" value="Toevoegen" />
			</form>
		</div>
    </div>
</div>

<script type="text/javascript">
$(document).ready(function() {
	//Leerling live search
	var opts = $('#leerling_select option').map(function(){
		return [[this.value, $(this).text()]];
	});

	$('#leerling_input').keyup(function(){
		var rxp = new RegExp($('#leerling_input').val(), 'i');
		var optlist = $('#leerling_select').empty();
		opts.each(function(){
			if (rxp.test(this[1])) {
				optlist.append($('<option/>').attr('value', this[0]).text(this[1]));
			}
		}); 
	});
	
	//Bedrijf live search
	var optsb = $('#bedrijf_select option').map(function(){
		return [[this.value, $(this).text()]];
	});

	$('#bedrijf_input').keyup(function(){
		var rxpb = new RegExp($('#bedrijf_input').val(), 'i');
		var optlistb = $('#bedrijf_select').empty();
		optsb.each(function(){
			if (rxpb.test(this[1])) {
				optlistb.append($('<option/>').attr('value', this[0]).text(this[1]));
			}
		}); 
	});
});
</script>
</body>
</html>