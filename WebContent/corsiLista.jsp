<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% 
String tipo = request.getParameter("type");
String k = request.getParameter("k");
String v = request.getParameter("v");
String msg= "";
if(k!=null&&v!=null){
	msg="<h3>Risultati per la ricerca di <em style='color:red'>"+k+
			"</em> con valore <em style='color:red'>"+v+"</em></h3>";
}

if(tipo.equals("Iscrizioni")){ %>
<div>


<h2>Lista Iscrizioni &nbsp;
<a href="#${pageContext.request.contextPath}/CorsiEJB?azione=insert&type=Iscrizioni" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a>&nbsp; <a href="#${pageContext.request.contextPath}/CorsiEJB?azione=search&type=Iscrizioni" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-search fa-fw addEwallet"></em></a>  </h2>
<div>
<%=msg %>
<table>
<tr>
	<th>idIscrizione</th>
	<th>idDipendente</th>
	<th>idDocente</th>
	<th>idCorso</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.idIscrizione}</td>
		<td>${entry.idDipendente}</td>
		<td>${entry.idDocente}</td>
		<td>${entry.idCorso}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/CorsiEJB?azione=update&type=Iscrizioni&id=${entry.idIscrizione}"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="IscrizioniAll" data-action="stop" href ="#${pageContext.request.contextPath}/CorsiEJB?azione=remove&type=Iscrizioni&id=${entry.idIscrizione }"
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
<a href="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=TipoMovimento&azioneEwallet=insert&id=" onclick="updateLink(this)" >
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
<%}else if(tipo.equals("Movimenti")){ %>
<div>


<h2>Lista Movimenti 
<a href="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=Movimenti&azioneEwallet=insert&id=" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a></h2>
<div>
<table>
<tr>
	<th>ID</th>
	<th>Iban</th>
	<th>Importo</th>
	<th>Data Movimento</th>
	<th>ID Tipo Movimento</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.id}</td>
		<td>${entry.iban}</td>
		<td>${entry.importo}</td>
		<td>${entry.dataMovimento}</td>
		<td>${entry.idTipoMovimento}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=Movimenti&azioneEwallet=update&id=${entry.id}"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="ContoCorrenteFind" data-action="stop" href ="#${pageContext.request.contextPath}/Dipendenti?azione=ewallet&tipo=Movimenti&azioneEwallet=remove&id=${entry.id }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>
<%} %>


