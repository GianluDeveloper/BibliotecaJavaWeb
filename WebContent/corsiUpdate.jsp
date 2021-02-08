<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,service.ContoCorrente" %>
<% 
String type = request.getParameter("type");

if(type.equals("Iscrizioni")){
%>
<div>
	<h2>Aggiorna Iscrizione</h2>
	<div>
		<form method="POST" action="#" data-action="CorsiEJB:doUpdate" onsubmit="return handleForm(this)">
			
	        <label for="nome">ID Dipendente <span style="color:red;">*</span></label><br />
	        <input
	        
	          type="text"
	          name="idDipendente"
	          placeholder="ID Dipendente"
	          value="${oggetto.idDipendente}"
	          required
	        /><br />
	        <label for="nome">ID Docente <span style="color:red;">*</span></label><br />
	        <input
	          type="text"
	          name="idDocente"
	          placeholder="ID Docente..."
	          value="${oggetto.idDocente}"
	          required
	        /><br />
	        <label for="nome">ID Corso <span style="color:red;">*</span></label><br />
	        <input
	          type="text"
	          name="idCorso"
	          placeholder="ID Corso..."
	          value="${oggetto.idCorso}"
	          required
	        /><br />
		 <br /><button type="submit">Aggiorna dati</button>
        <input type="hidden" name="azione" value="doUpdate" />
        <input type="hidden" name="type" value="<%=type %>" />
        <input type="hidden" name="idIscrizione" value="${oggetto.idIscrizione}" />
		</form>
	</div>
</div>
<%}if(type.equals("Corsi")){
	%>
	<div>
		<h2>Aggiorna Corso</h2>
		<div>
		
		<form method="POST" action="#" data-action="CorsiEJB:doUpdate" onsubmit="return handleForm(this)">
				
		        <label for="nome">Nome Corso <span style="color:red;">*</span></label><br />
		        <input
		        
		          type="text"
		          name="nomeCorso"
		          placeholder="Nome Corso..."
		          value="${oggetto.nomeCorso}"
		          required
		        /><br />
		        <label for="nome">Data Inizio <span style="color:red;">*</span></label><br />
		        <input
		          type="date"
		          name="dataInizio"
		          placeholder="Data Inizio..."
		          value="${oggetto.dataInizio}"
		          required
		        /><br />
		        <label for="nome">Data Fine <span style="color:red;">*</span></label><br />
		        <input
		          type="date"
		          name="dataFine"
		          placeholder="Data Fine..."
		          value="${oggetto.dataFine}"
		          required
		        /><br />
			 <br /><button type="submit">Invia dati</button>
	        <input type="hidden" name="azione" value="doUpdate" />
	        <input type="hidden" name="type" value="<%=type %>" />
			<input type="hidden" name="idCorso" value="${oggetto.idCorso}" />
	        
			</form>
		
		
		
		</div>
	</div>
	<%}

%>