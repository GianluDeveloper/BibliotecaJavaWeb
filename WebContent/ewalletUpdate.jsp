<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,service.ContoCorrente" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String type = request.getParameter("tipo"); 

if(type.equals("TipoMovimento")){
%>
<div>
	<h2>Aggiorna Tipo Movimento</h2>
	<div>
		<form method="POST" action="#" data-action="Dipendenti:update" onsubmit="return handleForm(this)">
			
	        <label for="nome">Descrizione <span style="color:red;">*</span></label><br />
	        <input
	        
	          type="text"
	          name="descrizione"
	          placeholder="Descrizione Tipo Movimento..."
	          value="${oggetto.descrizione}"
	          required
	        /><br />
	        
		 <br /><button type="submit">Aggiorna dati</button>
        <input type="hidden" name="azioneEwallet" value="doUpdate" />
        <input type="hidden" name="azione" value="ewallet" />
        <input type="hidden" name="tipo" value="TipoMovimento" />
        <input type="hidden" name="idTipoMovimento" value="${oggetto.idTipoMovimento}" />
		</form>
	</div>
</div>

<% }else if(type.equals("ContoCorrente")){
	%>
	<div>
		<h2>Aggiorna Conto Corrente</h2>
		<div>
			<form method="POST" action="#" data-action="Dipendenti:update" onsubmit="return handleForm(this)">
				
		        <label for="nome">ID Dipendente <span style="color:red;">*</span></label><br />
		        <input
		        
		          type="text"
		          name="idCliente"
		          placeholder="ID Dipendente..."
		          value="${oggetto.idCliente}"
		          required
		        /><br />
		        <label for="nome">Saldo Iniziale <span style="color:red;">*</span></label><br />
		        <input
		          type="text"
		          name="saldo"
		          placeholder="Saldo Iniziale..."
		          value="${oggetto.saldo}"
		          required
		        /><br />
		        <label for="nome">Data Creazione <span style="color:red;">*</span></label><br />
		        <input
		          type="date"
		          name="dataCreazione"
		          placeholder="Data creazione..."
		          value="${oggetto.dataCreazione}"
		          required
		        /><br />
			 <br /><button type="submit">Aggiorna dati</button>
	        <input type="hidden" name="azioneEwallet" value="doUpdate" />
	        <input type="hidden" name="azione" value="ewallet" />
	        <input type="hidden" name="tipo" value="ContoCorrente" />
	        <input type="hidden" name="iban" value="${oggetto.iban}" />
			</form>
		</div>
	</div>

	<% } else if(type.equals("Movimenti")){
		%>
		<div>
			<h2>Aggiorna Movimento</h2>
			<div>
				<form method="POST" action="#" data-action="Dipendenti:update" onsubmit="return handleForm(this)">
					
			        <label for="nome">Iban <span style="color:red;">*</span></label><br />
			        <input
			        
			          type="text"
			          name="iban"
			          placeholder="Iban..."
			          value="${oggetto.iban}"
			          required
			        /><br />
			        <label for="nome">Importo <span style="color:red;">*</span></label><br />
			        <input
			          type="text"
			          name="importo"
			          placeholder="Importo..."
			          value="${oggetto.importo}"
			          required
			        /><br />
			        <label for="nome">Data Movimento <span style="color:red;">*</span></label><br />
			        <input
			          type="date"
			          name="dataMovimento"
			          placeholder="Data Movimento..."
			          value="${oggetto.dataMovimento}"
			          required
			        /><br />
			        <label for="nome">ID Tipo Movimento <span style="color:red;">*</span></label><br />
			        <input
			          type="text"
			          name="idTipoMovimento"
			          placeholder="ID Tipo Movimento..."
			          value="${oggetto.idTipoMovimento}"
			          required
			        /><br />
				 <br /><button type="submit">Aggiorna dati</button>
		        <input type="hidden" name="azioneEwallet" value="doUpdate" />
		        <input type="hidden" name="azione" value="ewallet" />
		        <input type="hidden" name="tipo" value="Movimenti" />
		        <input type="hidden" name="id" value="${oggetto.id}" />
				</form>
			</div>
		</div>

		<% } %>





