<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List,java.util.ArrayList" %>


<table>
<tr>
	<th>idDipendente</th>
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
        href="#${pageContext.request.contextPath}/update.jsp?type=Dipendenti&id=${entry.matricola }"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="DipendenteAll" data-action="stop" href ="#${pageContext.request.contextPath}/Dipendenti?azione=remove&id=${entry.matricola }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
