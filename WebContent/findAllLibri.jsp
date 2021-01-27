<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,dao.LibriDao,model.Libri" %>
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
	<th>idLibro</th>
	<th>numPagine</th>
	<th>anno</th>
	<th>posizione</th>
	<th>titolo</th>
	<th>genere</th>
	<th>autore</th>
	<th>isbn</th>
	<th>casaEditrice</th>
</tr>
<%
List<Libri> libri = new LibriDao().findAll();

for(int i = 0;i<libri.size();i++){
	 Libri d = libri.get(i);
	 int idLibro=d.getIdLibro(),numPagine=d.getNumPagine(),anno=d.getAnno(),posizione=d.getPosizione();
	 String titolo=d.getTitolo(), genere=d.getGenere(), autore=d.getAutore(), 
			 isbn=d.getIsbn(), casaEditrice=d.getCasaEditrice();
	 
	 %>
	<tr>
	 <td><%=idLibro %></td>
	 <td><%=numPagine %></td>
	 <td><% out.print(anno); %></td>
	 <td><%=posizione %></td>
	 <td><%=titolo %></td>
	 <td><%=genere %></td>
	 <td><%=autore %></td>
	 <td><%=isbn %></td>
	 <td><%=casaEditrice %></td>
	</tr>
	 <% 
	
}
%>
</table>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>