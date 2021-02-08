package ctr;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.EJBCorsiRemote;
import ejb.EJBDocentiRemote;
import ejb.EJBIscrizioniRemote;
import model.Corsi;
import model.Docenti;
import model.Iscrizioni;
import response.Response;
import response.ResponseDao;
import util.RicercaDb;

@WebServlet("CorsiEJB")
public class CorsiCtr extends HttpServlet {

	private static final long serialVersionUID = -114790016222926240L;
	@Resource(mappedName = "java:jboss/exported/Corsi/EJBCorsi!ejb.EJBCorsiRemote")
	private EJBCorsiRemote bs;
	@Resource(mappedName = "java:jboss/exported/Corsi/EJBDocenti!ejb.EJBDocentiRemote")
	private EJBDocentiRemote bs2;
	@Resource(mappedName = "java:jboss/exported/Corsi/EJBIscrizioni!ejb.EJBIscrizioniRemote")
	private EJBIscrizioniRemote bs3;
	
	private void Iscrizioni(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String azione = request.getParameter("azione");
		switch(azione) {
		case "findAll":
			//ResponseDao<Corsi> corsi = bs.findAll(false);

			ResponseDao<Iscrizioni> iscrizioni = bs3.findAll(false);

			//ResponseDao<Docenti> docenti = bs2.findAll(false);
			
			List<Iscrizioni> listaIscrizioni = iscrizioni.getList();
			request.getSession().setAttribute("lista", listaIscrizioni);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);
			//response.getWriter().append("ok findAll iscrizioni");
			break;
		case "search":
			request.getRequestDispatcher("findBykv.jsp").forward(request, response);
			break;
		case "doSearch":
			String k = request.getParameter("k");
			String v = request.getParameter("v");
			if(k==null||v==null) {
				response.getWriter().append("key e value non presenti per la ricerca.");
				return;
			}
			RicercaDb r = new RicercaDb();
			r.setKey(k);
			r.setValue(v);
			ResponseDao<Iscrizioni> iscrizioniFind = bs3.find(r);
			List<Iscrizioni> listaIscrizioniFind = iscrizioniFind.getList();
			request.getSession().setAttribute("lista", listaIscrizioniFind);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);

			break;
		case "update":
			String Id = request.getParameter("id");
			if(Id==null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int id = Integer.parseInt(Id);
			ResponseDao<Iscrizioni> iscrizioniUpdateS = bs3.findById(id);
			Iscrizioni IscrizioneUpdate = iscrizioniUpdateS.getList().get(0);
			request.getSession().setAttribute("oggetto", IscrizioneUpdate);
			request.getRequestDispatcher("corsiUpdate.jsp").forward(request, response);

			break;
		case "doUpdate":
			String idDipendenteU = request.getParameter("idDipendente");
			String idDocenteU = request.getParameter("idDocente");
			String idCorsoU = request.getParameter("idCorso");
			String IdU = request.getParameter("idIscrizione");
			if(IdU==null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int idU = Integer.parseInt(IdU);
			if(idDipendenteU==null|| idDocenteU==null|| idCorsoU==null) {
				response.getWriter().append("inserimento non valido.");
				return;
			}
			int IdDipendenteU = Integer.parseInt(idDipendenteU);
			int IdDocenteU = Integer.parseInt(idDocenteU);
			int IdCorsoU = Integer.parseInt(idCorsoU);
			Iscrizioni IscrDaInserireUpdate= new Iscrizioni(idU,IdDipendenteU,IdDocenteU,IdCorsoU);
			Response iscrizioniUpdate = bs3.update(IscrDaInserireUpdate);
			if(iscrizioniUpdate.getErrorCode()==0) {
				response.getWriter().append("<div><h2>Iscrizione aggiornata con successo</h2></div>");
			}else {
				response.getWriter().append("<div><h2>Errore aggiornamento: "+iscrizioniUpdate.getDescription()+"</h2></div>");
			}

			break;
		case "remove":
			String IdR = request.getParameter("id");
			if(IdR==null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int idR = Integer.parseInt(IdR);
			Iscrizioni tmp = new Iscrizioni();
			tmp.setIdIscrizione(idR);
			Response iscrizioniRemove = bs3.delete(tmp);
			if(iscrizioniRemove.getErrorCode()==0) {
				response.getWriter().append("<div><h2>Iscrizione rimossa con successo</h2></div>");
			}else {
				response.getWriter().append("<div><h2>Errore rimozione: "+iscrizioniRemove.getDescription()+"</h2></div>");
			}
			break;
		case "insert":
			request.getRequestDispatcher("corsiInsert.jsp").forward(request, response);

			break;
		case "doInsert":
			String idDipendente = request.getParameter("idDipendente");
			String idDocente = request.getParameter("idDocente");
			String idCorso = request.getParameter("idCorso");
			
			if(idDipendente==null|| idDocente==null|| idCorso==null) {
				response.getWriter().append("inserimento non valido.");
				return;
			}
			int IdDipendente = Integer.parseInt(idDipendente);
			int IdDocente = Integer.parseInt(idDocente);
			int IdCorso = Integer.parseInt(idCorso);
			Iscrizioni IscrDaInserire= new Iscrizioni(0,IdDipendente,IdDocente,IdCorso);
			Response iscrizioniInsert = bs3.insert(IscrDaInserire);
			if(iscrizioniInsert.getErrorCode()==0) {
				response.getWriter().append("<div><h2>Iscrizione inserita con successo</h2></div>");
			}else {
				response.getWriter().append("<div><h2>Errore inserimento: "+iscrizioniInsert.getDescription()+"</h2></div>");
			}
			break;
		default:
			response.getWriter().append("not implemented iscrizioni");
	}
	}
	
	private void Corsi(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String azione = request.getParameter("azione");
		switch(azione) {
		case "findAll":
			response.getWriter().append("ok findAll corsi");
			break;
		default:
			response.getWriter().append("not implemented corsi");
	}
	}
	
	private void Docenti(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String azione = request.getParameter("azione");
		switch(azione) {
			case "findAll":
				response.getWriter().append("ok findAll docenti");
				break;
			default:
				response.getWriter().append("not implemented docenti");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// response.addHeader("Content-Type", "text/plain; charset=utf-8");
		// String msg = request.getParameter("m");
		// String resp = bs.pippo(msg);
		// Corso corso = new Corso(1,"Java Enterprise");
		//
		// Corso attivato =bs.nuovoCorso(corso);
		//
		// response.getWriter().append(resp).append(" \n"+bs.pluto()).append("\nE'
		// attivo il corso "+attivato.getNome());
		// int idCorso, String nomeCorso, String dataInizio, String dataFine
		
		String type = request.getParameter("type");
		String azione = request.getParameter("azione");
		
		if(type ==null|| azione == null) {
			response.getWriter().append("Parametri non corretti");
			return;
		}
		switch(type) {
			case "Iscrizioni":
				this.Iscrizioni(request, response);
				return;
			case "Docenti":
				this.Docenti(request, response);
				return;
			case "Corsi":
				this.Corsi(request, response);
				return;
		}
		
		
		Corsi c = new Corsi(1, "Nuovo Corso Java EE2", "11/12/2020", "11/04/2021");

		Response r = bs.insert(c);
		// int idDocente, int idCorso, String nomeDocente
		Docenti d = new Docenti(1, 1, "Srand");

		Response r2 = bs2.insert(d);

		// int idIscrizione, int idDipendente, int idDocente, int idCorso
		Iscrizioni i = new Iscrizioni(1, 1, 1, 1);

		Response r3 = bs3.insert(i);

		response.getWriter().append("\nInserted corso with error: " + r.getDescription())
				.append("\nInserted docente with error: " + r2.getDescription())
				.append("\nInserted iscrizone with error: " + r3.getDescription());

		c.setNomeCorso("il corso è cambiato");
		d.setNomeDocente("qualcuno nuovo");
		i.setIdDipendente(69);

		r = bs.update(c);
		r2 = bs2.update(d);
		r3 = bs3.update(i);

		response.getWriter().append("\nUpdated corso with error: " + r.getDescription())
				.append("\nUpdated docente with error: " + r2.getDescription())
				.append("\nUpdated iscrizone with error: " + r3.getDescription());
		
		

		c.setIdCorso(2);
		d.setIdDocente(2);
		i.setIdIscrizione(2);

		r3 = bs3.delete(i);
		r2 = bs2.delete(d);
		r = bs.delete(c);

		response.getWriter().append("\nDELETED 2 corso with error: " + r.getDescription())
				.append("\nDELETED 2 docente with error: " + r2.getDescription())
				.append("\nDELETED 2 iscrizone with error: " + r3.getDescription());

		String liste = "\n";

		ResponseDao<Corsi> corsi = bs.findAll(false);
		for (Corsi corso : corsi.getList()) {
			liste += "\n Nome corso: " + corso.getNomeCorso() + "\n";
		}

		ResponseDao<Iscrizioni> iscrizioni = bs3.findAll(false);
		for (Iscrizioni corso : iscrizioni.getList()) {
			liste += "\n Iscrizione: " + corso.getIdDipendente() + "\n";
		}

		ResponseDao<Docenti> docenti = bs2.findAll(false);
		for (Docenti corso : docenti.getList()) {
			liste += "\n Docente: " + corso.getNomeDocente() + "\n";
		}

		// find libero

		ResponseDao<Corsi> corsif = bs.find(new RicercaDb("idCorso", "3"));
		for (Corsi corso : corsif.getList()) {
			liste += "\n trovato Nome corso: " + corso.getNomeCorso() + "\n";
		}

		ResponseDao<Iscrizioni> iscrizionif = bs3.find(new RicercaDb("idIscrizione", "3"));
		for (Iscrizioni corso : iscrizionif.getList()) {
			liste += "\n trovato Iscrizione: " + corso.getIdDipendente() + "\n";
		}

		ResponseDao<Docenti> docentif = bs2.find(new RicercaDb("idDocente", "3"));
		for (Docenti corso : docentif.getList()) {
			liste += "\n trovato Docente: " + corso.getNomeDocente() + "\n";
		}

		// find by id

		ResponseDao<Corsi> corsid = bs.findById(3);
		for (Corsi corso : corsid.getList()) {
			liste += "\n trovato per id Nome corso: " + corso.getNomeCorso() + "\n";
		}

		ResponseDao<Iscrizioni> iscrizionid = bs3.findById(3);
		for (Iscrizioni corso : iscrizionid.getList()) {
			liste += "\n trovato per id Iscrizione: " + corso.getIdDipendente() + "\n";
		}

		ResponseDao<Docenti> docentid = bs2.findById(3);
		for (Docenti corso : docentid.getList()) {
			liste += "\n trovato per id Docente: " + corso.getNomeDocente() + "\n";
		}
		
		
		response.getWriter().append(liste);
	}

}
