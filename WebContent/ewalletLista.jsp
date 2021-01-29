<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
String tipo = request.getParameter("tipo");

if(tipo.equals("ContoCorrente")){ %>
<div>


<h2>Lista Conti Correnti 
<a href="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=ContoCorrente&azioneEwallet=insert&id=${entry.iban}" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a></h2>
<div>
<table>
<tr>
	<th>iban</th>
	<th>idCliente</th>
	<th>saldo</th>
	<th>dataCreazione</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.iban}</td>
		<td>${entry.idCliente}</td>
		<td>${entry.saldo}</td>
		<td>${entry.dataCreazione}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=ContoCorrente&azioneEwallet=update&id=${entry.iban}"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="ContoCorrenteAll" data-action="stop" href ="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=ContoCorrente&azioneEwallet=remove&id=${entry.iban }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>
<%}else if(tipo.equals("TipoMovimento")){ %>
<div>


<h2>Lista Tipi Movimenti 
<a href="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=TipoMovimento&azioneEwallet=insert&id=${entry.idTipoMovimento}" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a></h2>
<div>
<table>
<tr>
	<th>idTipoMovimento</th>
	<th>Descrizione</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.idTipoMovimento}</td>
		<td>${entry.descrizione}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=TipoMovimento&azioneEwallet=update&id=${entry.idTipoMovimento}"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="ContoCorrente" data-action="stop" href ="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=TipoMovimento&azioneEwallet=remove&id=${entry.idTipoMovimento }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>
<%} %>


