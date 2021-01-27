<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Registro,model.Dipendenti,model.Cliente,model.Libri,model.Turni" %>
<%@ page import="main.JavaDate,dao.RegistroLibriDao,dao.DipendentiDao,dao.ClienteDao,dao.LibriDao,dao.TurniDao" %>
	
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
if(type.equals("Dipendentix")){
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
	
}else if(type.equals("Dipendenti")){
	
		
	Dipendenti d = new DipendentiDao().findById(id);

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
        />
        <br />
        
          <label for="admin">Admin</label><br />
          <input type="radio" name="admin" value="1" <%= d.isAdmin()?"checked":"" %>/> <strong><em>Sì</em></strong> 
           <input type="radio" name="admin" value="0" <%= d.isAdmin()?"":"checked" %>/> <strong><em>No</em></strong><br/>
        <br/>
                
        <br /><button type="submit">Aggiorna dati</button>
		<input type='hidden' name='azione' value='update'/>
		<input type='hidden' name='id' value='<%=d.getMatricola() %>'/>
      </form>
    </div>
  </div>
</div>
	
	
	
	<% 
	
}else if(type.equals("Libri")){
	
		
	Libri d = new LibriDao().findById(id);

	%>
	
	
	
	
	
	<div>
<h2>Aggiorna Libro</h2>
<div>
<form method="POST"  action="#" data-action="<%=type %>:update" onsubmit="return handleForm(this)">
	numero pagine: <input type="number" name="numPagine" value='<%=d.getNumPagine() %>' required/><br/>
	anno: <input type="number" name="anno"  value='<%=d.getAnno() %>' required/><br/>
	posizione: <input type="number" name="posizione"  value='<%=d.getPosizione() %>' required/><br/>
	titolo: <input type="text" name="titolo"  value='<%=d.getTitolo() %>' required /><br/>
	genere: <input type="text" name="genere"  value='<%=d.getGenere() %>' required/><br/>
	autore: <input type="text" name="autore"  value='<%=d.getAutore() %>' required/><br/>
	isbn: <input type="text" name="isbn"  value='<%=d.getIsbn() %>' required/><br/>
	casaEditrice: <input type="text" name="casaEditrice"  value='<%=d.getCasaEditrice() %>' required/><br/>
	<input type="hidden" name="azione" value="update" />
	<input type="hidden" name="idLibro" value="<%=d.getIdLibro() %>" />
	<br/><input type="submit" value="Invia"/>
</form>

</div>

</div>
	
	
	
	
	<% 
	
}else if(type.equals("RegistroLibri")){
	
		
	Registro d = new RegistroLibriDao().findById(id);

	%>
	
	<div>
<h2>Aggiorna Registro Libri</h2>
<div>
<form method="POST" action="#"  data-action="RegistroLibri:update" onsubmit="return handleForm(this)">
	idLibro: <input type="number" name="idLibro" value="<%=d.getIdLibro()%>" required/><br/>
	idCliente: <input type="number" name="idCliente"  value="<%=d.getIdCliente()%>" required/><br/>
	idDipendente: <input type="number" name="idDipendente" value="<%=d.getIdDipendente()%>"  required/><br/>
	data_prestito: <input type="date" name="data_prestito"  value="<%=new JavaDate().toWebFormat(d.getData_prestito())%>" required/><br/>
	data_scadenza: <input type="date" name="data_scadenza" value="<%=new JavaDate().toWebFormat(d.getData_scadenza())%>"  required/><br/>
	data_rientro: <input type="date" name="data_rientro"  value="<%=new JavaDate().toWebFormat(d.getData_rientro())%>" required/><br/>
	<input type="hidden" name="azione" value="update"/>
	<br/><input type="submit" value="Invia"/>
			<input type="hidden" name="id" value="<%=d.getId() %>" />
	
</form>
</div>
</div>
	
	
	
	
	
	
	
	
	<% 
	
}else if(type.equals("Turni")){
	
		
	Turni d = new TurniDao().findById(id);

	%>
	
	
	<div>
<h2>Aggiorna Turno</h2>
<div>
<form method="POST" action="#"  data-action="Turni:update" onsubmit="return handleForm(this)">
	idDipendente: <input type="number" name="idDipendente" value="<%=d.getIdDipendente()%>"/><br/>
	data_inizio: <input type="date" name="data_inizio" value="<%=new JavaDate().toWebFormat(d.getData_inizio())%>"/><br/>
	data_fine: <input type="date" name="data_fine" value="<%=new JavaDate().toWebFormat(d.getData_fine())%>"/><br/>
	<input type="hidden" name="azione" value="update"/>
	<br/><input type="submit" value="Invia"/>
	<input type="hidden" name="idTurni" value="<%=d.getIdTurni() %>" />
	
</form>
</div>
</div>
	
	
	
	
	
	
	
	
	
	
	
	<% 
	
}
%>