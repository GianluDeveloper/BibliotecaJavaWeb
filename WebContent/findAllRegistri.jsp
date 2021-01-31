<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,model.Registro" %>

<div><h2>Lista Registri Libri <a href="#" onclick="updateMain('RegistroLibri')" data-link="RegistroLibri"><em style="color:red" class="fas fa-plus-circle fa-fw addEwallet"></em></a></h2>
<table>
<tr>
	<th>id</th>
	<th>idLibro</th>
	<th>idCliente</th>
	<th>idDipendente</th>
	<th>data_prestito</th>
	<th>data_scadenza</th>
	<th>data_rientro</th>
	<th>Modifica</th>
	<th>Elimina</th>
</tr>
<%
List<Registro> lista = (List<Registro>)request.getSession().getAttribute("registri");
for(Registro d : lista){
	
	int id=d.getId(),idLibro=d.getIdLibro(),idCliente=d.getIdCliente(),idDipendente=d.getIdDipendente();
	String data_prestito=d.getData_prestito(),data_scadenza=d.getData_scadenza(),
			data_rientro=d.getData_rientro();
	%>
	<tr>
		<td><%=id %></td>
		<td><%=idLibro %></td>
		<td><%=idCliente %></td>
		<td><%=idDipendente %></td>
		<td><%=data_prestito %></td>
		<td><%=data_scadenza %></td>
		<td><%=data_rientro %></td>
		<td>
      <a
        href="#${pageContext.request.contextPath}/update.jsp?type=RegistroLibri&id=<%=id %>"
        onclick="updateLink(this)"
        ><em class="fa fa-edit fa-fw"></em
      ></a>
    </td>
    <td>
      <a data-link="RegistroLibriAll" data-action="stop" href ="#${pageContext.request.contextPath}/RegistroLibri?azione=remove&id=<%=id %>"
        onclick="return remove(this)" ><em class="fa fa-trash-alt fa-fw"></em
      ></a>
    </td>
	</tr>
	
	<% 
}
%>
</table>
</div>


