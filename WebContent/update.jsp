<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Registro,model.Dipendenti,model.Cliente,model.Libri,model.Turni" %>
<%@ page import="dao.RegistroLibriDao,dao.DipendentiDao,dao.ClienteDao,dao.LibriDao,dao.TurniDao" %>
	
<% 
/* String type = (String)request.getSession().getAttribute("type");
int id = (int)request.getSession().getAttribute("id"); */
String type = (String)request.getParameter("type");
int id = Integer.parseInt(request.getParameter("id"));
%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="ISO-8859-1"> -->
<%-- <title>Aggiorna <%=type %></title> --%>
<!-- </head> -->
<!-- <body> -->
<%
if(type.equals("Dipendenti")){
	%>
	

	<% 
	Dipendenti d = new DipendentiDao().findById(id);
	%>
	<form class="update" method='POST' action="<%=type%>">
		Nome: <input type='text' value='<%=d.getNome() %>' name='nome' placeholder='nome'/><br/>
		Cognome: <input type='text' name='cognome' value='<%=d.getCognome() %>'  placeholder='cognome'/><br/>
		Telefono: <input type='text' value='<%=d.getTelefono() %>' placeholder='telefono' name='telefono'/><br/>
		Admin: No <input type="radio" name="admin" value="0" <%= d.isAdmin()?"":"checked" %>/> Sì<input type="radio" name="admin" value="1" <%= d.isAdmin()?"checked":"" %> /><br/>
		
		<input type='submit'/>
		<input type='hidden' name='azione' value='update'/>
		<input type='hidden' name='matricola' value='<%=d.getMatricola()%>'/>
	</form>
	<% 
}else if(type.equals("Cliente")){
	
		
	Cliente d = new ClienteDao().findById(id);

	%>
	
<div>
  <div>
    <h1>Aggiorna <%=type %></h1>
    <div>
      <form class="update"  method="POST" action="#" data-action="<%=type %>:update" onsubmit="return handleForm(this)">
        <label for="nome">Nome <span style="color:red;">*</span></label><br />
        <input
          type="text"
          name="nome"
          value='<%=d.getNome() %>'
          placeholder="Nome utente..."
          required
        /><br />
        <label for="cognome">Cognome <span style="color:red;">*</span></label><br />
        <input
          type="text"
          name="cognome"
		  value='<%=d.getCognome() %>'
          placeholder="Cognome utente..."
          required
        /><br />
        <label for="telefono">Telefono <span style="color:red;">*</span></label><br />
        <input
          type="text"
          name="telefono"
		  value='<%=d.getTelefono() %>'
          placeholder="Telefono utente..."
          required
        /><br />
                
        <br /><button type="submit">Aggiorna dati</button>
		<input type='hidden' name='azione' value='update'/>
		<input type='hidden' name='id' value='<%=d.getIdCliente() %>'/>
      </form>
    </div>
  </div>
</div>
	
	
	
	<% 
	
}
%>