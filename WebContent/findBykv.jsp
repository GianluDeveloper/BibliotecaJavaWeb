<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String type = (String)request.getParameter("type"); %>
<% if(type.equals("Cliente")) { %>
<form method="POST" data-action="Cliente:findBykv" action="#" onsubmit="return handleForm(this)">
	<label for="k">Ricerca Cliente:</label><br/>
	<select name="k" id="k">
		<option value="nome">Nome</option>
		<option value="cognome">Cognome</option>
		<option value="telefono">Telefono</option>
		<option value="idCliente">idCliente</option>
	</select><br/>
	<input type="text" placeholder="Ricerca..." name="v" required/><br/>
	<button type="submit">Trova</button>
	<input type="hidden" name="azione" value="findBykv"/>
</form>
<%}else if(type.equals("Dipendente")){
	%>
	
	<form method="POST" data-action="Dipendenti:findBykv" action="#" onsubmit="return handleForm(this)">
	<label for="k">Ricerca Dipendenti:</label><br/>
	<select name="k" id="k">
		<option value="nome">Nome</option>
		<option value="cognome">Cognome</option>
		<option value="telefono">Telefono</option>
		<option value="admin">Admin</option>
		<option value="id">idDipendente</option>		
	</select><br/>
	<input type="text" placeholder="Ricerca..." name="v" required/><br/>
	<button type="submit">Trova</button>
	<input type="hidden" name="azione" value="findBykv"/>
</form>
	
	<%
}else if(type.equals("Libri")){
	%>

	<form method="POST" data-action="Libri:findBykv" action="#" onsubmit="return handleForm(this)">
	<label for="k">Ricerca Libri:</label><br/>
	<select name="k" id="k">
		<option value="titolo">Titolo</option>
		<option value="anno">Anno</option>
		<option value="numPagine">numPagine</option>
		<option value="posizione">posizione</option>
		<option value="genere">genere</option>
		<option value="autore">autore</option>
		<option value="isbn">isbn</option>
		<option value="casaEditrice">casaEditrice</option>
		<option value="idLibro">idLibro</option>		
	</select><br/>
	<input type="text" placeholder="Ricerca..." name="v" required/><br/>
	<button type="submit">Trova</button>
	<input type="hidden" name="azione" value="findBykv"/>
</form>
	
	<%
}else if(type.equals("RegistroLibri")){
	%>
	<form method="POST" data-action="RegistroLibri:findBykv" action="#" onsubmit="return handleForm(this)">
	<label for="k">Ricerca Registro Libri:</label><br/>
	<select name="k" id="k">
		<option value="idLibro">idLibro</option>
		<option value="idCliente">idCliente</option>
		<option value="idDipendente">idDipendente</option>
		<option value="data_prestito">data_prestito</option>
		<option value="data_scadenza">data_scadenza</option>
		<option value="data_rientro">data_rientro</option>
		<option value="id">id</option>
	</select><br/>
	<input type="text" placeholder="Ricerca..." name="v" required/><br/>
	<button type="submit">Trova</button>
	<input type="hidden" name="azione" value="findBykv"/>
</form>

	<%
}else if(type.equals("Turni")){
	%>
	<form method="POST" data-action="Turni:findBykv" action="#" onsubmit="return handleForm(this)">
	<label for="k">Ricerca Turni:</label><br/>
	<select name="k" id="k">
		<option value="idDipendente">idDipendente</option>
		<option value="data_inizio">data_inizio</option>
		<option value="data_fine">data_fine</option>
		<option value="idTurni">idTurni</option>
	</select><br/>
	<input type="text" placeholder="Ricerca..." name="v" required/><br/>
	<button type="submit">Trova</button>
	<input type="hidden" name="azione" value="findBykv"/>
</form>
	
	<%
}



%>