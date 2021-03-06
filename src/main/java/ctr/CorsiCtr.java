package ctr;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DocentiDto;
import ejb.EJBCorsiRemote;
import ejb.EJBDocentiRemote;
import ejb.EJBIscrizioniRemote;
import main.JavaDate;
import dto.CorsiDto;
import dto.IscrizioniDto;
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

	private void Iscrizioni(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String azione = request.getParameter("azione");
		switch (azione) {
		case "findAll":
			// ResponseDao<Corsi> corsi = bs.findAll(false);

			ResponseDao<IscrizioniDto> iscrizioni = bs3.findAll(false);

			// ResponseDao<Docenti> docenti = bs2.findAll(false);

			List<IscrizioniDto> listaIscrizioni = iscrizioni.getList();
			request.getSession().setAttribute("lista", listaIscrizioni);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);
			// response.getWriter().append("ok findAll iscrizioni");
			break;
		case "search":
			request.getRequestDispatcher("findBykv.jsp").forward(request, response);
			break;
		case "doSearch":
			String k = request.getParameter("k");
			String v = request.getParameter("v");
			if (k == null || v == null) {
				response.getWriter().append("key e value non presenti per la ricerca.");
				return;
			}
			RicercaDb r = new RicercaDb();
			r.setKey(k);
			r.setValue(v);
			ResponseDao<IscrizioniDto> iscrizioniFind = bs3.find(r);
			List<IscrizioniDto> listaIscrizioniFind = iscrizioniFind.getList();
			request.getSession().setAttribute("lista", listaIscrizioniFind);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);

			break;
		case "update":
			String Id = request.getParameter("id");
			if (Id == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int id = Integer.parseInt(Id);
			ResponseDao<IscrizioniDto> iscrizioniUpdateS = bs3.findById(id);
			IscrizioniDto IscrizioneUpdate = iscrizioniUpdateS.getList().get(0);
			request.getSession().setAttribute("oggetto", IscrizioneUpdate);
			request.getRequestDispatcher("corsiUpdate.jsp").forward(request, response);

			break;
		case "doUpdate":
			String idDipendenteU = request.getParameter("idDipendente");
			String idDocenteU = request.getParameter("idDocente");
			String idCorsoU = request.getParameter("idCorso");
			String IdU = request.getParameter("idIscrizione");
			if (IdU == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int idU = Integer.parseInt(IdU);
			if (idDipendenteU == null || idDocenteU == null || idCorsoU == null) {
				response.getWriter().append("update non valido.");
				return;
			}
			int IdDipendenteU = Integer.parseInt(idDipendenteU);
			int IdDocenteU = Integer.parseInt(idDocenteU);
			int IdCorsoU = Integer.parseInt(idCorsoU);
			IscrizioniDto IscrDaInserireUpdate = new IscrizioniDto(idU, IdDipendenteU, IdDocenteU, IdCorsoU);
			Response iscrizioniUpdate = bs3.update(IscrDaInserireUpdate);
			if (iscrizioniUpdate.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Iscrizione aggiornata con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore aggiornamento: " + iscrizioniUpdate.getDescription() + "</h2></div>");
			}

			break;
		case "remove":
			String IdR = request.getParameter("id");
			if (IdR == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int idR = Integer.parseInt(IdR);
			IscrizioniDto tmp = new IscrizioniDto();
			tmp.setIdIscrizione(idR);
			Response iscrizioniRemove = bs3.delete(tmp);
			if (iscrizioniRemove.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Iscrizione rimossa con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore rimozione: " + iscrizioniRemove.getDescription() + "</h2></div>");
			}
			break;
		case "insert":
			request.getRequestDispatcher("corsiInsert.jsp").forward(request, response);

			break;
		case "doInsert":
			String idDipendente = request.getParameter("idDipendente");
			String idDocente = request.getParameter("idDocente");
			String idCorso = request.getParameter("idCorso");

			if (idDipendente == null || idDocente == null || idCorso == null) {
				response.getWriter().append("inserimento non valido.");
				return;
			}
			int IdDipendente = Integer.parseInt(idDipendente);
			int IdDocente = Integer.parseInt(idDocente);
			int IdCorso = Integer.parseInt(idCorso);
			IscrizioniDto IscrDaInserire = new IscrizioniDto(0, IdDipendente, IdDocente, IdCorso);
			Response iscrizioniInsert = bs3.insert(IscrDaInserire);
			if (iscrizioniInsert.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Iscrizione inserita con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore inserimento: " + iscrizioniInsert.getDescription() + "</h2></div>");
			}
			break;
		default:
			response.getWriter().append("not implemented iscrizioni");
		}
	}

	private void Corsi(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String azione = request.getParameter("azione");
		switch (azione) {
		case "findAll":
			// ResponseDao<Corsi> corsi = bs.findAll(false);

			ResponseDao<CorsiDto> iscrizioni = bs.findAll(false);

			// ResponseDao<Docenti> docenti = bs2.findAll(false);

			List<CorsiDto> listaIscrizioni = iscrizioni.getList();
			request.getSession().setAttribute("lista", listaIscrizioni);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);
			// response.getWriter().append("ok findAll iscrizioni");
			break;
		case "search":
			request.getRequestDispatcher("findBykv.jsp").forward(request, response);
			break;
		case "doSearch":
			String k = request.getParameter("k");
			String v = request.getParameter("v");
			if (k == null || v == null) {
				response.getWriter().append("key e value non presenti per la ricerca.");
				return;
			}
			RicercaDb r = new RicercaDb();
			r.setKey(k);
			r.setValue(v);
			ResponseDao<CorsiDto> iscrizioniFind = bs.find(r);
			List<CorsiDto> listaIscrizioniFind = iscrizioniFind.getList();
			request.getSession().setAttribute("lista", listaIscrizioniFind);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);

			break;
		case "update":
			String Id = request.getParameter("id");
			if (Id == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int id = Integer.parseInt(Id);
			ResponseDao<CorsiDto> iscrizioniUpdateS = bs.findById(id);
			CorsiDto IscrizioneUpdate = iscrizioniUpdateS.getList().get(0);
			String tmpFine = IscrizioneUpdate.getDataFine();
			String tmpInizio = IscrizioneUpdate.getDataInizio();
			IscrizioneUpdate.setDataInizio( new JavaDate().toWebFormat(tmpInizio));
			IscrizioneUpdate.setDataFine( new JavaDate().toWebFormat(tmpFine));

			
			request.getSession().setAttribute("oggetto", IscrizioneUpdate);
			request.getRequestDispatcher("corsiUpdate.jsp").forward(request, response);

			break;
		case "doUpdate":
			String nomeCorsoU = request.getParameter("nomeCorso");
			String dataInizioU = request.getParameter("dataInizio");
			String dataFineU = request.getParameter("dataFine");
			String IdU = request.getParameter("idCorso");
			
			if (IdU==null||dataInizioU == null || nomeCorsoU == null || dataFineU == null) {
				response.getWriter().append("update non valido.");
				return;
			}
			int idU = Integer.parseInt(IdU);	
			dataInizioU = new JavaDate().handleWebFormat(dataInizioU);
			dataFineU = new JavaDate().handleWebFormat(dataFineU);
			
			CorsiDto IscrDaInserireUpdate = new CorsiDto(idU, nomeCorsoU, dataInizioU, dataFineU);
			Response iscrizioniUpdate = bs.update(IscrDaInserireUpdate);
			if (iscrizioniUpdate.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Corso aggiornato con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore aggiornamento: " + iscrizioniUpdate.getDescription() + "</h2></div>");
			}

			break;
		case "remove":
			String IdR = request.getParameter("id");
			if (IdR == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int idR = Integer.parseInt(IdR);
			CorsiDto tmp = new CorsiDto();
			tmp.setIdCorso(idR);
			Response iscrizioniRemove = bs.delete(tmp);
			if (iscrizioniRemove.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Corso rimosso con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore rimozione: " + iscrizioniRemove.getDescription() + "</h2></div>");
			}
			break;
		case "insert":
			request.getRequestDispatcher("corsiInsert.jsp").forward(request, response);

			break;
		case "doInsert":
			String nomeCorso = request.getParameter("nomeCorso");
			String dataInizio = request.getParameter("dataInizio");
			String dataFine = request.getParameter("dataFine");
			// idCorso
			if (dataInizio == null || nomeCorso == null || dataFine == null) {
				response.getWriter().append("inserimento non valido.");
				return;
			}
			dataInizio = new JavaDate().handleWebFormat(dataInizio);
			dataFine = new JavaDate().handleWebFormat(dataFine);
			
			CorsiDto IscrDaInserire = new CorsiDto(0, nomeCorso, dataInizio, dataFine);
			Response iscrizioniInsert = bs.insert(IscrDaInserire);
			if (iscrizioniInsert.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Corso inserito con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore inserimento: " + iscrizioniInsert.getDescription() + "</h2></div>");
			}
			break;
		default:
			response.getWriter().append("not implemented iscrizioni");
		}
	}

	private void Docenti(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String azione = request.getParameter("azione");
		switch (azione) {
		case "findAll":

			ResponseDao<DocentiDto> iscrizioni = bs2.findAll(false);


			List<DocentiDto> listaIscrizioni = iscrizioni.getList();
			request.getSession().setAttribute("lista", listaIscrizioni);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);
			break;
		case "search":
			request.getRequestDispatcher("findBykv.jsp").forward(request, response);
			break;
		case "doSearch":
			String k = request.getParameter("k");
			String v = request.getParameter("v");
			if (k == null || v == null) {
				response.getWriter().append("key e value non presenti per la ricerca.");
				return;
			}
			RicercaDb r = new RicercaDb();
			r.setKey(k);
			r.setValue(v);
			ResponseDao<DocentiDto> iscrizioniFind = bs2.find(r);
			List<DocentiDto> listaIscrizioniFind = iscrizioniFind.getList();
			request.getSession().setAttribute("lista", listaIscrizioniFind);
			request.getRequestDispatcher("corsiLista.jsp").forward(request, response);

			break;
		case "update":
			String Id = request.getParameter("id");
			if (Id == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int id = Integer.parseInt(Id);
			ResponseDao<DocentiDto> iscrizioniUpdateS = bs2.findById(id);
			DocentiDto IscrizioneUpdate = iscrizioniUpdateS.getList().get(0);
			request.getSession().setAttribute("oggetto", IscrizioneUpdate);
			request.getRequestDispatcher("corsiUpdate.jsp").forward(request, response);

			break;
		case "doUpdate":
			String nomeDocente = request.getParameter("nomeDocente");
			String idCorsoU = request.getParameter("idCorso");
			String IdU = request.getParameter("idDocente");
			if (IdU == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int idU = Integer.parseInt(IdU);
			if (nomeDocente == null || idCorsoU == null) {
				response.getWriter().append("update non valido.");
				return;
			}
			int IdCorsoU = Integer.parseInt(idCorsoU);
			DocentiDto IscrDaInserireUpdate = new DocentiDto(idU, IdCorsoU, nomeDocente);
			Response iscrizioniUpdate = bs2.update(IscrDaInserireUpdate);
			if (iscrizioniUpdate.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Docente aggiornato con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore aggiornamento: " + iscrizioniUpdate.getDescription() + "</h2></div>");
			}

			break;
		case "remove":
			String IdR = request.getParameter("id");
			if (IdR == null) {
				response.getWriter().append("cancellazione non valida.");
			}
			int idR = Integer.parseInt(IdR);
			DocentiDto tmp = new DocentiDto();
			tmp.setIdDocente(idR);
			Response iscrizioniRemove = bs2.delete(tmp);
			if (iscrizioniRemove.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Docente rimosso con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore rimozione: " + iscrizioniRemove.getDescription() + "</h2></div>");
			}
			break;
		case "insert":
			request.getRequestDispatcher("corsiInsert.jsp").forward(request, response);

			break;
		case "doInsert":
			String nomeDocenteI = request.getParameter("nomeDocente");
			String idCorso = request.getParameter("idCorso");

			if (nomeDocenteI == null || idCorso == null) {
				response.getWriter().append("inserimento non valido.");
				return;
			}
			int IdCorso = Integer.parseInt(idCorso);
			DocentiDto IscrDaInserire = new DocentiDto(0, IdCorso, nomeDocenteI);
			Response iscrizioniInsert = bs2.insert(IscrDaInserire);
			if (iscrizioniInsert.getErrorCode() == 0) {
				response.getWriter().append("<div><h2>Docente inserito con successo</h2></div>");
			} else {
				response.getWriter()
						.append("<div><h2>Errore inserimento: " + iscrizioniInsert.getDescription() + "</h2></div>");
			}
			break;
		default:
			response.getWriter().append("not implemented iscrizioni");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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

		if (type == null || azione == null) {
			response.getWriter().append("Parametri non corretti");
			return;
		}
		switch (type) {
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

	}

}
