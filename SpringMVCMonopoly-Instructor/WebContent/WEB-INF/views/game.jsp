<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="monopoly" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monopoly Game</title>
<link rel="stylesheet" type="text/css" href="resources/style/monopoly.css">
</head>
<body>
<center>
<img src="resources/images/Monopoly-logo.jpg" width="500" height="190"/>
<br/>
<h3>Current Round: ${playGameBean.currentRound}</h3>

	<c:forEach items="${playGameBean.players}" var="player">
		<monopoly:turn player="${player}"/><br/>
		${player.token} rolled a ${player.lastRoll}
		and landed on ${player.location.name}<br/>
		${player.token} has $${player.money}<br/>
	</c:forEach>
	<br/>
	<c:if test="${not playGameBean.gameOver}">
		<form:form commandName="playGameBean" action="playRound">
			<input type="submit" value="Play Another Round"/>
		</form:form>
	<br/>
	</c:if>
	<form action="home">
			<input type="submit" value="Go Home!"/>
		</form>
	<a href="home">New Game</a>
</center>
</body>
</html>


