<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List,java.util.ArrayList, model.Dipendenti" %>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FindAll Dipendenti</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
 --%>
<table>
<tr>
	<th>matricola</th>
	<th>nome</th>
	<th>cognome</th>
	<th>telefono</th>
	<th>admin</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.matricola}</td>
		<td>${entry.nome}</td>
		<td>${entry.cognome}</td>
		<td>${entry.telefono}</td>
		<td>${entry.admin}</td>
		<td>
      <a
        href="${pageContext.request.contextPath}/update.jsp?type=Dipendenti&id=${entry.matricola }"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="Dipendente" data-action="stop" href ="#${pageContext.request.contextPath}/Dipendenti?azione=remove&id=${entry.matricola }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
<%-- <jsp:include page="footer.jsp"></jsp:include>

</body>
</html> --%>