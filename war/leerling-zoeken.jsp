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

Objectify ofy = ObjectifyService.begin();
Query<Leerling> alleLeerlingen = ofy.query(Leerling.class);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/form.css" type="text/css" />
<title>Accent Nijkerk</title>
<script language="javascript" type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script language="javascript" type="text/javascript" src="javascript/jquery.resizebg.js"></script>
</head>

<body>
<img src="images/bg.jpg" id="bg" alt="" />
<div id="panel-container" class="rounded shadow">
	<!-- Header !-->
	<jsp:include page="includes/header.jsp" />
    
    <!-- Content !-->
    <div id="content">
    	<h1>Leerlingen &raquo; Zoeken</h1>
    	<!-- Subemenu -->
        <div id="submenu">
        	<a href="leerling-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
			<% if(gebruikerObject instanceof Docent){ %><a href="leerling-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a><% } %>
            <a href="leerling-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
        </div>
        
		<!-- Zoeken -->
        <div class="block">
        	<label class="form_label" for="leerling">Leerling</label>
        	<input id="leerling_input" class="form_input rounded-small" type="text" placeholder="Leerling zoeken..." />
		    <select id="leerling_select" class="form_input rounded-small" style="width: 245px;" name="leerling" multiple="multiple">
			    <% for(Gebruiker l : alleLeerlingen) { %>
			    <option value="<%=l.getId()%>"><%=((Leerling)l).getNaam()%></option>
				<% } %>
		    </select>
		    <a id="leerling_href" href="" class="submit-button white-gradient rounded-small">Leerling bekijken</a>
        </div>
    </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	//Leerling live search
	$('#leerling_select').on('change', function (e) {
		var optionSelected = $("option:selected", this);
		if(optionSelected != null) {
			$("#leerling_href").attr("href", "leerling-bezichtigen.jsp?id=" + optionSelected.val());
		}
	});
	
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
});
</script>
</body>
</html>