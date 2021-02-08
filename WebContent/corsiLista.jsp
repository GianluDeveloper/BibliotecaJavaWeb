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

String idHtml =request.getParameter("id");
if(idHtml==null){
	idHtml="";
}else{
	idHtml="&id="+idHtml;
}

if(tipo.equals("Iscrizioni")){ %>
<div>


<h2>Lista Iscrizioni &nbsp;
<a href="#${pageContext.request.contextPath}/CorsiEJB?azione=insert&type=Iscrizioni<%=idHtml %>" onclick="updateLink(this)" >
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
		<td><a onclick="updateLink(this)" href='#${pageContext.request.contextPath}/CorsiEJB?azione=doSearch&type=Docenti&k=idDocente&v=${entry.idDocente}'>
		<strong>${entry.idDocente}</strong></a></td>
		<td><a onclick="updateLink(this)" href='#${pageContext.request.contextPath}/CorsiEJB?azione=doSearch&type=Corsi&k=idCorso&v=${entry.idCorso}'>
		<strong>${entry.idCorso}</strong></a></td>
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
<%}else if(tipo.equals("Corsi")){ %>
<div>

<h2>Lista Corsi &nbsp;
<a href="#${pageContext.request.contextPath}/CorsiEJB?azione=insert&type=Corsi" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a>&nbsp; <a href="#${pageContext.request.contextPath}/CorsiEJB?azione=search&type=Corsi" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-search fa-fw addEwallet"></em></a>  </h2>
<div>
<%=msg %>
<table>
<tr>
	<th>idCorso</th>
	<th>nomeCorso</th>
	<th>dataInizio</th>
	<th>dataFine</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.idCorso}</td>
		<td>${entry.nomeCorso}</td>
		<td>${entry.dataInizio}</td>
		<td>${entry.dataFine}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/CorsiEJB?azione=update&type=Corsi&id=${entry.idCorso}"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="CorsiAll" data-action="stop" href ="#${pageContext.request.contextPath}/CorsiEJB?azione=remove&type=Corsi&id=${entry.idCorso }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>
<%}else if(tipo.equals("Docenti")){ %>
<div>

<h2>Lista Docenti &nbsp;
<a href="#${pageContext.request.contextPath}/CorsiEJB?azione=insert&type=Docenti" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a>&nbsp; <a href="#${pageContext.request.contextPath}/CorsiEJB?azione=search&type=Docenti" onclick="updateLink(this)" >
<em style="color:red" class="fas fa-search fa-fw addEwallet"></em></a>  </h2>
<div>
<%=msg %>
<table>
<tr>
	<th>idDocente</th>
	<th>idCorso</th>
	<th>nomeDocente</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<c:forEach items="${lista}" var="entry">
        <tr>
		<td>${entry.idDocente}</td>
		<td>${entry.idCorso}</td>
		<td>${entry.nomeDocente}</td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/CorsiEJB?azione=update&type=Docenti&id=${entry.idDocente}"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="DocentiAll" data-action="stop" href ="#${pageContext.request.contextPath}/CorsiEJB?azione=remove&type=Docenti&id=${entry.idDocente }"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
    	</tr>
</c:forEach>
</table>
</div>
</div>
<%}
%>

