<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rimuovi <%=request.getParameter("type") %></title>
</head>
<body>
<h1>Rimuovi <%=request.getParameter("type") %></h1>
<form action="<%=request.getParameter("type") %>" method="GET">
	<input type="number" name="id" placeholder="id"/>
	<input type="hidden" name="azione" value="remove"/>
	<input type="submit" value="Invia delete"/>
</form>
</body>
</html>