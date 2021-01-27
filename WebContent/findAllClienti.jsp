<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List,java.util.ArrayList" %>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FindAll Dipendenti</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
 --%>
<div>


<h2>Lista Clienti</h2>
<div>
<table>
<tr>
	<th>idCliente</th>
	<th>nome</th>
	<th>cognome</th>
	<th>telefono</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.idCliente}</td>
		<td>${entry.nome}</td>
		<td>${entry.cognome}</td>
		<td>${entry.telefono}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/update.jsp?type=Cliente&id=${entry.idCliente }"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="ClienteAll" data-action="stop" href ="#${pageContext.request.contextPath}/Cliente?azione=remove&id=${entry.idCliente }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>

