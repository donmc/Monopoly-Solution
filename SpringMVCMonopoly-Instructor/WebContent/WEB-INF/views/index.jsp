<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<fmt:setBundle basename="resources.application" var="bundle"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monopoly</title>
<link rel="stylesheet" type="text/css" href="resources/style/monopoly.css">
<link rel="stylesheet" type="text/css" href="resources/style/monopoly.css">
<script type="text/javascript" src="resources/jquery-1.11.3.js"></script>
     <script type="text/javascript" language="javascript">
         $(document).ready(function() {
        	 	$("#numberOfPlayers").keyup(function(event){
        	 		if (isNaN($('#numberOfPlayers').val())) { 
        	 			$('#tokens').html('');
        	 			return;
        	 		}
        	 		var data = {numberOfTokens:$('#numberOfPlayers').val()};
        	 		
             	$.getJSON('http://localhost:8081/SpringMVCMonopoly/tokens.json', data, function(jd) {
             		$('#tokens').html('<span>');
          
             		$.each(jd.tokenList, function(index, token) {
             			$('#tokens').append("<img height='30px' src='resources/images/"+token+".jpg'/>");
             	   	});
             		
             		$('#tokens').append('</span>');
                  });
             });
         });
      </script>

</head>
<body>
<center>
<img src="resources/images/Monopoly-logo.jpg" width="500" height="190"/>

<h2><spring:message code="title.text"></spring:message></h2>
<form:form commandName="newGameBean"  action="startGame">
<div style="height:30px" id="tokens"></div>
How many players? 
<form:input id="numberOfPlayers" path="numberOfPlayers" size="3" cssErrorClass="error"/>
<form:errors path="numberOfPlayers" cssClass="error"/>
<br/>
How many Rounds?
<form:input path="numberOfRounds" size="3" cssErrorClass="error"/>
<form:errors path="numberOfRounds" cssClass="error"/>
<br/>
<br/>
<input type="submit" value="Play!"/>
</form:form>
<br/>
</center>
</body>
</html>