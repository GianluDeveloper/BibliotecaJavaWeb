<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.List,java.util.ArrayList" %>

<div>


<h2>Lista Libri <a href="#" onclick="updateMain('Libri')" data-link="Libri"><em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a></h2>
<div>
<table>
<tr>
	<th>idLibro</th>
	<th>numPagine</th>
	<th>anno</th>
	<th>posizione</th>
	<th>titolo</th>
	<th>genere</th>
	<th>autore</th>
	<th>isbn</th>
	<th>casaEditrice</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.idLibro}</td>
		<td>${entry.numPagine}</td>
		<td>${entry.anno}</td>
		<td>${entry.posizione}</td>
		<td>${entry.titolo}</td>
		<td>${entry.genere}</td>
		<td>${entry.autore}</td>
		<td>${entry.isbn}</td>
		<td>${entry.casaEditrice}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/update.jsp?type=Libri&id=${entry.idLibro }"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="LibriAll" data-action="stop" href ="#${pageContext.request.contextPath}/Libri?azione=remove&id=${entry.idLibro }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>

