<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<fmt:setBundle basename="resources.application" var="bundle"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monopoly</title>
<link rel="stylesheet" type="text/css" href="style/monopoly.css">
</head>
<body>
<center>
<img src="images/Monopoly-logo.jpg" width="500" height="190"/>

<c:set var="name">
<fmt:message key="name" bundle="${bundle}"/>
</c:set>

this: ${name}
<br/>
<br/>
<html:form action="createGame.do">
How many players? 
<html:text property="numberOfPlayers" size="3"/>
<br/>
How many Rounds?
<html:text property="roundLimit" size="3"/>
<br/>
<html:hidden property="new"/>
<html:submit value="Play!"/>
</html:form>
<br/>
<html:errors/>
</center>
</body>
</html>