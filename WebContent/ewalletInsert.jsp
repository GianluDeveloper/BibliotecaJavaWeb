<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,service.ContoCorrente" %>
<% String type = (String)request.getSession().getAttribute("type"); %>
<div>
	<h2>Inserisci <%=type %></h2>
	<div>
		<form method="POST" action="#" data-action="Dipendenti:doInsert" onsubmit="return handleForm(this)">
			
	        <label for="nome">ID Dipendente <span style="color:red;">*</span></label><br />
	        <input
	        style="text-decoration: line-through;font-size:0.8em; "
	          type="text"
	          name="idCliente"
	          placeholder="idCliente"
	          value="<%=request.getParameter("id") %>"
	          disabled
	          required
	        /><br />
	        <label for="nome">Saldo Iniziale <span style="color:red;">*</span></label><br />
	        <input
	          type="text"
	          name="saldo"
	          placeholder="Saldo Iniziale..."
	          required
	        /><br />
	        <label for="nome">Data Creazione <span style="color:red;">*</span></label><br />
	        <input
	          type="date"
	          name="dataCreazione"
	          placeholder="Data creazione..."
	          required
	        /><br />
		 <br /><button type="submit">Invia dati</button>
        <input type="hidden" name="azioneEwallet" value="doInsert" />
        <input type="hidden" name="azione" value="ewallet" />
        <input type="hidden" name="tipo" value=<%=type %> />
		</form>
	</div>
</div>