<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="monopoly" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Monopoly Game</title>
<link rel="stylesheet" type="text/css" href="style/monopoly.css">
</head>
<body>
<center>
<img src="images/Monopoly-logo.jpg" width="500" height="190"/>
<br/>
<h3>Current Round: ${gameBean.currentRound}</h3>

	<c:forEach items="${gameBean.players}" var="player">
		<monopoly:turn player="${player}"/><br/>
		${player.token} rolled a ${player.lastRoll}
		and landed on ${player.location.name}<br/>
		${player.token} has $${player.money}<br/>
	</c:forEach>
	<br/>
	<c:if test="${not gameBean.gameOver}">
		<form action="controller" method="post">
			<input type="submit" value="Play Another Round"/>
			<input type="hidden" name="cmd" value="play"/>
		</form>
	<br/>
	</c:if>
	<a href="new">New Game</a>
</center>
</body>
</html>

