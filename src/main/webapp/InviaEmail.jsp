<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invia una mail con MDB JMS</title>
<style>
.messaggio {
	color: red;
}
.areaMessaggio{
	width:30%;
	height:100px;
	outline:none;
}
</style>
</head>
<body>
	<%
	String messaggio = request.getParameter("message");
	if (messaggio == null) {
	%>
	<form action="MailSrv" method="POST">
		<div>
			<textarea class="areaMessaggio"
				placeholder="Inserisci il tuo messaggio..." name="message"></textarea>
		</div>
		<div>
			<input type="submit" value="Invia" />
		</div>
	</form>
	<%
	} else {
	%>
	<div>Messaggio inviato. Hai scritto:</div>
	<div class="messaggio"><%=messaggio%></div>
	<%
	}
	%>
</body>
</html>