package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DipendentiDao;
import main.JavaDate;
import model.Dipendenti;
import service.ContoCorrente;
import service.ContoCorrenteWSProxy;
import service.Movimenti;
import service.MovimentiWSProxy;
import service.Response;
import service.ResponseContoCorrente;
import service.ResponseMovimenti;
import service.ResponseTipoMovimento;
import service.RicercaDb;
import service.TipoMovimento;
import service.TipoMovimentoWSProxy;

@WebServlet("Dipendenti")
public class DipendentiCtr extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DipendentiDao dipendentiDao = new DipendentiDao();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Content-Type", "text/html");
		String azione = request.getParameter("azione");
		if(azione == null) {
			response.getWriter().append("Ciao dipendente");
		}else if(azione.equals("insert")) {
			this.insert(request, response);
		}else if(azione.equals("update")) {
			this.update(request, response);			
		}else if(azione.equals("remove")) {
			this.remove(request, response);
		}else if(azione.equals("findById")) {
			this.findById(request, response);
		}else if(azione.equals("findBykv")) {
			this.findBykv(request, response);
		}else if(azione.equals("findAll")) {
			this.findAll(request, response);
		}else if(azione.equals("ewallet")) {
			this.ewallet(request, response);
		}else {
			response.getWriter().append("Azione non riconosciuta.");
		}
	}
	
	private void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {
		//String matricolaget = request.getParameter("matricola");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String adminget = request.getParameter("admin");
		if(nome!=null&&cognome!=null&&telefono!=null&adminget!=null) {
			//int matricola = Integer.parseInt(matricolaget);
			System.out.println(adminget);
			boolean admin;
			if(adminget.equals("1")) {
				admin=true;
				System.out.println("istrue");
			}else {
				admin=false;
				System.out.println("isfalse");
			}
			Dipendenti d = new Dipendenti(0,  nome,  cognome,  telefono,  admin);
			dipendentiDao.insert(d);
			response.addHeader("Content-Type", "text/html");

			response.getWriter().append("Dipendente inserito correttamente"+". ");
		}else {
			response.getWriter().append("Qualcosa e' andato storto");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	private void ewallet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String azione= request.getParameter("azioneEwallet");
		String tipo = request.getParameter("tipo");
		
		if(azione== null||tipo==null) {
			response.getWriter().append("parametri non validi.");
		}else if(tipo.equals("ContoCorrente")) {
			this.ewalletContoCorrente(request, response);
		}else if(tipo.equals("Movimenti")) {
			this.ewalletMovimenti(request, response);
		}else if(tipo.equals("TipoMovimento")) {
			this.ewalletTipoMovimento(request, response);
		}else if(tipo.equals("ContoCorrenteDipendente")){
			this.ewalletContoCorrenteDipendente(request, response);
		}else {
			//azione non riconosciuta
		}
		
		
	}	
	
	private void ewalletContoCorrenteDipendente(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String Id= request.getParameter("id");
		if(Id==null) {
			response.getWriter().append("parametri non validi.");
		}else {
			 
			//conto corrente
			ContoCorrenteWSProxy p = new ContoCorrenteWSProxy();
			RicercaDb ricerca = new RicercaDb();
			ricerca.setKey("idCliente");
			ricerca.setValue(Id);
			ResponseContoCorrente r = p.find(ricerca);
			ContoCorrente[] res = r.getContoCorrente();
			//movimenti 
			Movimenti[] resmov =null;
			if(res!=null) {
				ContoCorrente d = res[0];
				int iban =d.getIban();
				MovimentiWSProxy p2 = new MovimentiWSProxy();
				ricerca.setKey("iban");
				request.getSession().setAttribute("iban", iban);
				ricerca.setValue(String.valueOf(iban));
				ResponseMovimenti rmov = p2.find(ricerca);
				resmov= rmov.getMovimenti();
			}
			
			
			
			
			request.getSession().setAttribute("lista", res);
			request.getSession().setAttribute("movimenti", resmov);
			request.getRequestDispatcher("ewalletVisura.jsp").forward(request, response);
		}
	
	}
	
	private void ewalletContoCorrente(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String azione= request.getParameter("azioneEwallet");
		if(azione.equals("insert")) {
			request.getSession().setAttribute("typestr", "Conto Corrente");
			request.getSession().setAttribute("type", "ContoCorrente");
			request.getRequestDispatcher("ewalletInsert.jsp").forward(request, response);
		}else if(azione.equals("update")) {
			String Id = request.getParameter("id");
			if(Id==null) {
				response.getWriter().append("parametri non validi.");
				return;
			}
			int id =Integer.parseInt(Id);
			ContoCorrenteWSProxy p = new ContoCorrenteWSProxy();
			ResponseContoCorrente r = p.findById(id);
			ContoCorrente oggetto = r.getContoCorrente()[0];
			oggetto.setDataCreazione(new JavaDate().toWebFormat(oggetto.getDataCreazione()));
			request.getSession().setAttribute("oggetto", oggetto);
			request.getRequestDispatcher("ewalletUpdate.jsp").forward(request, response);
		}else if(azione.equals("doInsert")) {
			String saldo = request.getParameter("saldo");
			String dataCreazione = request.getParameter("dataCreazione");
			String idCliente = request.getParameter("idCliente");
			if(saldo==null || dataCreazione == null || idCliente == null) {
				response.getWriter().append("parametri non validi.");
			}else {
				int idClienteInt = Integer.parseInt(idCliente);
				float saldoFloat = Float.parseFloat(saldo);
				String dataCreazioneHandled = new JavaDate().handleWebFormat(dataCreazione);
				ContoCorrente c = new ContoCorrente(dataCreazioneHandled,0,idClienteInt,saldoFloat);
				ContoCorrenteWSProxy p = new ContoCorrenteWSProxy();
				Response remoteResp = p.insert(c);
				if(remoteResp.isSuccesso()) {
					response.getWriter().append("Inserimento avvenuto con successo");
				}else {
					response.getWriter().append("Errore: "+remoteResp.getErrorCode()+" Msg: "+remoteResp.getDescription());
				}
			}
		}else if(azione.equals("doUpdate")) {
			String iban = request.getParameter("iban");
			String saldo = request.getParameter("saldo");
			String dataCreazione = request.getParameter("dataCreazione");
			String idCliente = request.getParameter("idCliente");
			if(iban==null||saldo==null || dataCreazione == null || idCliente == null) {
				response.getWriter().append("parametri non validi.");
			}else {
				int idClienteInt = Integer.parseInt(idCliente);
				float saldoFloat = Float.parseFloat(saldo);
				int ibanInt = Integer.parseInt(iban);
				String dataCreazioneHandled = new JavaDate().handleWebFormat(dataCreazione);
				ContoCorrente c = new ContoCorrente(dataCreazioneHandled,ibanInt,idClienteInt,saldoFloat);
				ContoCorrenteWSProxy p = new ContoCorrenteWSProxy();
				Response remoteResp = p.update(c);
				if(remoteResp.isSuccesso()) {
					response.getWriter().append("Update avvenuto con successo");
				}else {
					response.getWriter().append("Errore: "+remoteResp.getErrorCode()+" Msg: "+remoteResp.getDescription());
				}
			}
		}else if(azione.equals("findAll")) {
			ContoCorrenteWSProxy p = new ContoCorrenteWSProxy();
			ResponseContoCorrente remoteResp = p.findAll(false);
			ContoCorrente[] res = remoteResp.getContoCorrente();
			request.getSession().setAttribute("lista", res);
			request.getRequestDispatcher("ewalletLista.jsp").forward(request, response);
		}else if(azione.equals("remove")) {
			String ID = request.getParameter("id");
			if(ID==null) {
				response.getWriter().append("parametri non validi.");
			}else {
				int idInt= Integer.parseInt(ID);
				ContoCorrenteWSProxy p = new ContoCorrenteWSProxy();
				ContoCorrente c = new ContoCorrente();
				c.setIban(idInt);
				Response r = p.remove(c);
				if(r.isSuccesso()) {
					response.getWriter().append("Rimosso id "+idInt);
				}else {
					response.getWriter().append("Errore "+r.getErrorCode()+": "+
							r.getDescription());
				}
				
			}
			
		}
	}
	private void ewalletTipoMovimento(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String azione= request.getParameter("azioneEwallet");
		if(azione.equals("insert")) {
			request.getSession().setAttribute("typestr", "Tipi Movimento");
			request.getSession().setAttribute("type", "TipoMovimento");
			request.getRequestDispatcher("ewalletInsert.jsp").forward(request, response);
		}else if(azione.equals("update")) {
			String Id = request.getParameter("id");
			if(Id==null) {
				response.getWriter().append("parametri non validi.");
				return;
			}
			int id =Integer.parseInt(Id);
			TipoMovimentoWSProxy p = new TipoMovimentoWSProxy();
			ResponseTipoMovimento r = p.findById(id);
			TipoMovimento[]oggetti=r.getTipoMovimento();
			if(oggetti==null) {
				response.getWriter().append("No results.");

				return;
			}
			TipoMovimento oggetto = oggetti[0];
			request.getSession().setAttribute("oggetto", oggetto);
			request.getRequestDispatcher("ewalletUpdate.jsp").forward(request, response);
		}else if(azione.equals("doInsert")) {
			String descrizione = request.getParameter("descrizione");
			if(descrizione==null ) {
				response.getWriter().append("parametri non validi.");
			}else {
				
				TipoMovimento c = new TipoMovimento(descrizione,0);
				TipoMovimentoWSProxy p = new TipoMovimentoWSProxy();
				Response remoteResp = p.insert(c);
				if(remoteResp.isSuccesso()) {
					response.getWriter().append("Inserimento avvenuto con successo");
				}else {
					response.getWriter().append("Errore: "+remoteResp.getErrorCode()+" Msg: "+remoteResp.getDescription());
				}
			}
		}else if(azione.equals("doUpdate")) {
			String descrizione = request.getParameter("descrizione");
			String idTipoMovimento = request.getParameter("idTipoMovimento");
			if(descrizione == null || idTipoMovimento == null) {
				response.getWriter().append("parametri non validi.");
			}else {
				int idTipoMovimentoInt = Integer.parseInt(idTipoMovimento);
				TipoMovimento c = new TipoMovimento(descrizione,idTipoMovimentoInt);
				TipoMovimentoWSProxy p = new TipoMovimentoWSProxy();
				Response remoteResp = p.update(c);
				if(remoteResp.isSuccesso()) {
					response.getWriter().append("Update avvenuto con successo");
				}else {
					response.getWriter().append("Errore: "+remoteResp.getErrorCode()+" Msg: "+remoteResp.getDescription());
				}
			}
		}else if(azione.equals("findAll")) {
			TipoMovimentoWSProxy p = new TipoMovimentoWSProxy();
			ResponseTipoMovimento remoteResp = p.findAll(false);
			TipoMovimento[] res = remoteResp.getTipoMovimento();
			request.getSession().setAttribute("lista", res);
			request.getRequestDispatcher("ewalletLista.jsp").forward(request, response);
		}else if(azione.equals("remove")) {
			String ID = request.getParameter("id");
			if(ID==null) {
				response.getWriter().append("parametri non validi.");
			}else {
				int idInt= Integer.parseInt(ID);
				TipoMovimentoWSProxy p = new TipoMovimentoWSProxy();
				TipoMovimento c = new TipoMovimento();
				c.setIdTipoMovimento(idInt);
				Response r = p.remove(c);
				if(r.isSuccesso()) {
					response.getWriter().append("Rimosso id "+idInt);
				}else {
					response.getWriter().append("Errore "+r.getErrorCode()+" : "+
							r.getDescription());
				}
				
			}
			
		}
	}
	
	private void ewalletMovimenti(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String azione= request.getParameter("azioneEwallet");
		if(azione.equals("insert")) {
			request.getSession().setAttribute("typestr", "Movimenti");
			request.getSession().setAttribute("type", "Movimenti");
			request.getRequestDispatcher("ewalletInsert.jsp").forward(request, response);
		}else if(azione.equals("update")) {
			String Id = request.getParameter("id");
			if(Id==null) {
				response.getWriter().append("parametri non validi.");
				return;
			}
			int id =Integer.parseInt(Id);
			MovimentiWSProxy p = new MovimentiWSProxy();
			ResponseMovimenti r = p.findById(id);
			Movimenti[]oggetti=r.getMovimenti();
			if(oggetti==null) {
				response.getWriter().append("No results.");

				return;
			}
			Movimenti oggetto = oggetti[0];
			oggetto.setDataMovimento(new JavaDate().toWebFormat(oggetto.getDataMovimento()));
			request.getSession().setAttribute("oggetto", oggetto);
			request.getRequestDispatcher("ewalletUpdate.jsp").forward(request, response);
		}else if(azione.equals("doInsert")) {
			String iban = request.getParameter("iban");
			String importo = request.getParameter("importo");
			String dataMovimento = request.getParameter("dataMovimento");
			String idTipoMovimento = request.getParameter("idTipoMovimento");
			if(iban==null||importo==null||dataMovimento==null||idTipoMovimento==null ) {
				response.getWriter().append("parametri non validi.");
			}else {
				String dataMovimentoHandled = new JavaDate().handleWebFormat(dataMovimento);
				int ibanInt=Integer.parseInt(iban);
				int idTipoMovimentoInt=Integer.parseInt(idTipoMovimento);
				float importoFloat = Float.parseFloat(importo);
				Movimenti c = new Movimenti(dataMovimentoHandled,ibanInt,0,idTipoMovimentoInt,importoFloat);
				MovimentiWSProxy p = new MovimentiWSProxy();
				Response remoteResp = p.insert(c);
				if(remoteResp.isSuccesso()) {
					response.getWriter().append("Inserimento avvenuto con successo");
				}else {
					response.getWriter().append("Errore: "+remoteResp.getErrorCode()+" Msg: "+remoteResp.getDescription());
				}
			}
		}else if(azione.equals("doUpdate")) {
			String iban = request.getParameter("iban");
			String Id = request.getParameter("id");
			String importo = request.getParameter("importo");
			String dataMovimento = request.getParameter("dataMovimento");
			String idTipoMovimento = request.getParameter("idTipoMovimento");
			if(iban==null||importo==null||dataMovimento==null||idTipoMovimento==null ) {
				response.getWriter().append("parametri non validi.");
			}else {
				String dataMovimentoHandled = new JavaDate().handleWebFormat(dataMovimento);
				int ibanInt=Integer.parseInt(iban);
				int idTipoMovimentoInt=Integer.parseInt(idTipoMovimento);
				float importoFloat = Float.parseFloat(importo);
				int id = Integer.parseInt(Id);
				Movimenti c = new Movimenti(dataMovimentoHandled,ibanInt,id,idTipoMovimentoInt,importoFloat);
				MovimentiWSProxy p = new MovimentiWSProxy();
				Response remoteResp = p.update(c);
				if(remoteResp.isSuccesso()) {
					response.getWriter().append("Aggiornamento avvenuto con successo");
				}else {
					response.getWriter().append("Errore: "+remoteResp.getErrorCode()+" Msg: "+remoteResp.getDescription());
				}
			}
		}else if(azione.equals("findAll")) {
			MovimentiWSProxy p = new MovimentiWSProxy();
			ResponseMovimenti remoteResp = p.findAll(false);
			Movimenti[] res = remoteResp.getMovimenti();
			request.getSession().setAttribute("lista", res);
			request.getRequestDispatcher("ewalletLista.jsp").forward(request, response);
		}else if(azione.equals("remove")) {
			String ID = request.getParameter("id");
			if(ID==null) {
				response.getWriter().append("parametri non validi.");
			}else {
				int idInt= Integer.parseInt(ID);
				MovimentiWSProxy p = new MovimentiWSProxy();
				Movimenti c = new Movimenti();
				c.setId(idInt);
				Response r = p.remove(c);
				if(r.isSuccesso()) {
					response.getWriter().append("Rimosso id "+idInt);
				}else {
					response.getWriter().append("Errore "+r.getErrorCode()+" : "+
							r.getDescription());
				}
				
			}
			
		}
	}
	
	
	private void update(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String matricolaget = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String adminget = request.getParameter("admin");
		if(matricolaget!=null&&nome!=null&&cognome!=null&&telefono!=null&adminget!=null) {
			int id =Integer.parseInt(matricolaget);
			boolean admin=false;
			if(adminget.equals("1")) {
				admin=true;
			}
			Dipendenti d = new Dipendenti(id,  nome,  cognome,  telefono,  admin);
			dipendentiDao.update(d);
			response.addHeader("Content-Type", "text/html");
			response.getWriter().append("Utente "+id+" aggiornato. ");

		}
		else {
			response.addHeader("Content-Type", "text/html");
			response.getWriter().append("Errore nell'id o nel tipo. Torna alla <a href='/BibliotecaServlet'>home</a>");

		}
//		String Id=request.getParameter("id"),nome=request.getParameter("nome"),cognome=request.getParameter("cognome"),telefono=request.getParameter("telefono"),
//				Admin=request.getParameter("admin");
//		Dipendenti d = new Dipendenti(id,  nome,  cognome,  telefono,  admin);
//		dipendentiDao.update(d);
	}
	private void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Id=request.getParameter("id");
		response.addHeader("Content-Type","text/html");

		if(Id!=null) {
			int id=Integer.parseInt(Id);
			Dipendenti d = new Dipendenti();
			d.setMatricola(id);
			dipendentiDao.remove(d);
			response.getWriter().append("Rimosso l'utente con id "+id+". ");

		}else {
			response.getWriter().append("Errore nella rimozione. ");

		}
		

	}
	
	private void findById(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Id = request.getParameter("id");
		if(Id!=null) {
			Integer id = Integer.parseInt(Id);
			Dipendenti res = dipendentiDao.findById(id);
			String html = "Con id <strong>"+res.getMatricola()+"</strong> ho trovato nome <strong>"+
			res.getNome()+"</strong> cognome <strong>"+res.getCognome()+"</strong>"+" telefono <strong>"
			+res.getTelefono()+"</strong>";
			
			response.getWriter().append(html);
			
		}else {
			response.getWriter().append("id non fornito");
		}
		
	}
	private void findBykv(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String k = request.getParameter("k");
		String v = request.getParameter("v");
		if(k!=null&&v!=null) {
			List<Dipendenti> res = this.dipendentiDao.findBykv(k,v);
			request.getSession().setAttribute("lista", res);
			request.getRequestDispatcher("findAllDipendenti.jsp").forward(request, response);
		}
	}
	
	private void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Dipendenti> res = dipendentiDao.findAll();
		request.getSession().setAttribute("lista", res);
		request.getRequestDispatcher("findAllDipendenti.jsp").forward(request, response);
	}
}
