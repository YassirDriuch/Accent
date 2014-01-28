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
Query<Docent> alleDocenten = ofy.query(Docent.class);
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
    	<h1>Docenten &raquo; Zoeken</h1>
    	<!-- Subemenu -->
        <div id="submenu">
        	<a href="docent-overzicht.jsp" class="button rounded-small white-gradient">Overzicht</a>
			<% if(gebruikerObject instanceof Docent){ %><a href="leerling-toevoegen.jsp" class="button rounded-small white-gradient">Toevoegen</a><% } %>
            <a href="docent-zoeken.jsp" class="button rounded-small white-gradient">Zoeken</a>
        </div>
        
		<!-- Zoeken -->
        <div class="block">
        	<label class="form_label" for="docent">Docent</label>
        	<input id="docent_input" class="form_input rounded-small" type="text" placeholder="Leerling zoeken..." />
		    <select id="docent_select" class="form_input rounded-small" style="width: 245px;" name="docent" multiple="multiple">
			    <% for(Gebruiker d : alleDocenten) { %>
			    <option value="<%=d.getId()%>"><%=((Docent)d).getNaam()%></option>
				<% } %>
		    </select>
		    <a id="docent_href" href="" class="submit-button white-gradient rounded-small">Docent bekijken</a>
        </div>
    </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
	//Leerling live search
	$('#docent_select').on('change', function (e) {
		var optionSelected = $("option:selected", this);
		if(optionSelected != null) {
			$("#docent_href").attr("href", "docent-bezichtigen.jsp?id=" + optionSelected.val());
		}
	});
	
	var opts = $('#docent_select option').map(function(){
		return [[this.value, $(this).text()]];
	});

	$('#docent_input').keyup(function(){
		var rxp = new RegExp($('#docent_input').val(), 'i');
		var optlist = $('#docent_select').empty();
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