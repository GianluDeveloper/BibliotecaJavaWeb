<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,model.Registro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<table id="customers">
<tr>
	<th>id</th>
	<th>idLibro</th>
	<th>idCliente</th>
	<th>idDipendente</th>
	<th>data_prestito</th>
	<th>data_scadenza</th>
	<th>data_rientro</th>
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
	</tr>
	
	<% 
}
%>
</table>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>