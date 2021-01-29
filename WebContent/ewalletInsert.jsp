<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList,service.ContoCorrente" %>
<% 
String typestr = (String)request.getSession().getAttribute("typestr"); 
String type = (String)request.getSession().getAttribute("type"); 
if(type.equals("ContoCorrente")){
%>
<div>
	<h2>Inserisci <%=typestr %></h2>
	<div>
		<form method="POST" action="#" data-action="Dipendenti:doInsert" onsubmit="return handleForm(this)">
			
	        <label for="nome">ID Dipendente <span style="color:red;">*</span></label><br />
	        <input
	        
	          type="text"
	          name="idCliente"
	          placeholder="ID Dipendente..."
	          value="<% String id =request.getParameter("id"); out.print(id==null?"":id); %>"
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
        <input type="hidden" name="tipo" value="<%=type %>" />
		</form>
	</div>
</div>
<%}else if(type.equals("TipoMovimento")){
	%>
	
<div>
	<h2>Inserisci Nuovo Tipo Movimento</h2>
	<div>
		<form method="POST" action="#" data-action="Dipendenti:doInsert" onsubmit="return handleForm(this)">
			
	        <label for="nome">Nome nuovo movimento <span style="color:red;">*</span></label><br />
	        <input
	        
	          type="text"
	          name="descrizione"
	          placeholder="Descrizione..."
	          required
	        /><br />
	       
		 <br /><button type="submit">Invia dati</button>
        <input type="hidden" name="azioneEwallet" value="doInsert" />
        <input type="hidden" name="azione" value="ewallet" />
        <input type="hidden" name="tipo" value="TipoMovimento" />
		</form>
	</div>
</div>	
	
	
	
	<%
}


%>