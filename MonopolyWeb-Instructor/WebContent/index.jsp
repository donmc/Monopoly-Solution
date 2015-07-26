<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Monopoly</title>
<link rel="stylesheet" type="text/css" href="style/monopoly.css">
</head>
<body>
<center>
<img src="images/Monopoly-logo.jpg" width="500" height="190"/>
<br/>
<br/>
<form action="controller" method="post">
How many players? 
<input type="text" name="numberOfPlayers" value="${gameBean.defaultNumberOfPlayers}" size="3"/>
<br/>
How many Rounds?
<input type="text" name="roundLimit" size="3">
<br/>
<input type="submit" value="Play!"/>
<input type="hidden" value="new" name="cmd"/>
</form>
${gameBean.errors}
</center>
</body>
</html>