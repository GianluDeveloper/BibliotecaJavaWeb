<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.Registro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>


<h2>Lista Turni <a href="#" onclick="updateMain('Turni')" data-link="Turni"><em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a></h2>
<div>
<table>
<tr>
	<th>idTurni</th>
	<th>idDipendente</th>
	<th>data_inizio</th>
	<th>data_fine</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${turni}" var="entry">
        <tr>
		<td>${entry.idTurni}</td>
		<td>${entry.idDipendente}</td>
		<td>${entry.data_inizio}</td>
		<td>${entry.data_fine}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/update.jsp?type=Turni&id=${entry.idTurni }"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="TurniAll" data-action="stop" href ="#${pageContext.request.contextPath}/Turni?azione=remove&id=${entry.idTurni }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>


