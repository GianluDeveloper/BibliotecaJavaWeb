<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,service.ContoCorrente" %>
<% 
String id =request.getParameter("id");
String type = request.getParameter("type");
if(id!=null){
	if(id.length()<1){
		id=null;
	}
}
if(type.equals("Iscrizioni")){
%>
<div>
	<h2>Inserisci Nuova Iscrizione</h2>
	<div>
		<form method="POST" action="#" data-action="CorsiEJB:doInsert" onsubmit="return handleForm(this)">
			
	        <label for="nome">ID Dipendente <span style="color:red;">*</span></label><br />
	        <input
	        
	          type="text"
	          name="idDipendente"
	          placeholder="ID Dipendente"
	          value="<%  out.print(id==null?"":id); %>"
	          <%out.print(id==null?"":"DISABLED"); %>
	          required
	        /><br />
	        <label for="nome">ID Docente <span style="color:red;">*</span></label><br />
	        <input
	          type="text"
	          name="idDocente"
	          placeholder="ID Docente..."
	          required
	        /><br />
	        <label for="nome">ID Corso <span style="color:red;">*</span></label><br />
	        <input
	          type="text"
	          name="idCorso"
	          placeholder="ID Corso..."
	          required
	        /><br />
		 <br /><button type="submit">Invia dati</button>
        <input type="hidden" name="azione" value="doInsert" />
        <input type="hidden" name="type" value="<%=type %>" />
		</form>
	</div>
</div>
<%}else if(type.equals("Corsi")){
	%>
	<div>
		<h2>Inserisci Nuovo Corso</h2>
		<div>
			<form method="POST" action="#" data-action="CorsiEJB:doInsert" onsubmit="return handleForm(this)">
				
		        <label for="nome">Nome Corso <span style="color:red;">*</span></label><br />
		        <input
		        
		          type="text"
		          name="nomeCorso"
		          placeholder="Nome Corso..."
		          required
		        /><br />
		        <label for="nome">Data Inizio <span style="color:red;">*</span></label><br />
		        <input
		          type="date"
		          name="dataInizio"
		          placeholder="Data Inizio..."
		          required
		        /><br />
		        <label for="nome">Data Fine <span style="color:red;">*</span></label><br />
		        <input
		          type="date"
		          name="dataFine"
		          placeholder="Data Fine..."
		          required
		        /><br />
			 <br /><button type="submit">Invia dati</button>
	        <input type="hidden" name="azione" value="doInsert" />
	        <input type="hidden" name="type" value="<%=type %>" />
			</form>
		</div>
	</div>
	<%}
else if(type.equals("Docenti")){
	%>
	<div>
		<h2>Inserisci Docente</h2>
		<div>
			<form method="POST" action="#" data-action="CorsiEJB:doInsert" onsubmit="return handleForm(this)">
				
		        <label for="nome">Nome Docente <span style="color:red;">*</span></label><br />
		        <input
		        
		          type="text"
		          name="nomeDocente"
		          placeholder="Nome Docente..."
		          required
		        /><br />
		        <label for="nome">ID Corso <span style="color:red;">*</span></label><br />
		        <input
		          type="number"
		          name="idCorso"
		          placeholder="ID Corso..."
		          required
		        /><br />
		        
			 <br /><button type="submit">Invia dati</button>
	        <input type="hidden" name="azione" value="doInsert" />
	        <input type="hidden" name="type" value="<%=type %>" />
			</form>
		</div>
	</div>
	<%}

%>