package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibriDao;
import model.Libri;

@WebServlet("Libri")
public class LibriCtr extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LibriDao libriDao = new LibriDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.addHeader("Content-Type", "text/html");
		String azione = request.getParameter("azione");
		if (azione == null) {
			response.getWriter().append("Ciao dipendente");
		} else if (azione.equals("insert")) {
			this.insert(request, response);
		} else if (azione.equals("update")) {
			this.update(request, response);
		} else if (azione.equals("remove")) {
			this.remove(request, response);
		} else if (azione.equals("findById")) {
			this.findById(request, response);
		} else if (azione.equals("findBykv")) {
			this.findBykv(request, response);
		} else if (azione.equals("findAll")) {
			this.findAll(request, response);
		} else {
			response.getWriter().append("Azione non riconosciuta.");
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numPagine = request.getParameter("numPagine"), anno = request.getParameter("anno"),
				posizione = request.getParameter("posizione"), titolo = request.getParameter("titolo"),
				genere = request.getParameter("genere"), autore = request.getParameter("autore"),
				isbn = request.getParameter("isbn"), casaEditrice = request.getParameter("casaEditrice");

		if (numPagine != null && anno != null && posizione != null && titolo != null && genere != null && autore != null
				&& isbn != null && casaEditrice != null) {
			int numPagineInt = Integer.parseInt(numPagine);
			int annoInt = Integer.parseInt(anno);
			int posizioneInt = Integer.parseInt(posizione);
			Libri d = new Libri(0, numPagineInt, annoInt, posizioneInt, titolo, genere, autore, isbn, casaEditrice);

			boolean res = libriDao.insert(d);
			if (res) {
				response.addHeader("Content-Type", "text/html");

				response.getWriter().append("Libro <strong>" + titolo + "</strong> inserito correttamente.");
			} else {
				response.getWriter().append("errore inserimento nel database");
			}

		} else {
			response.getWriter().append("parametri non corretti");
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String numPagine = request.getParameter("numPagine"), anno = request.getParameter("anno"),
				posizione = request.getParameter("posizione"), titolo = request.getParameter("titolo"),
				genere = request.getParameter("genere"), autore = request.getParameter("autore"),
				isbn = request.getParameter("isbn"), casaEditrice = request.getParameter("casaEditrice"),
				Id = request.getParameter("idLibro");

		if (numPagine != null && anno != null && posizione != null && titolo != null && genere != null && autore != null
				&& isbn != null && casaEditrice != null && Id != null) {
			int numPagineInt = Integer.parseInt(numPagine);
			int annoInt = Integer.parseInt(anno);
			int id = Integer.parseInt(Id);
			int posizioneInt = Integer.parseInt(posizione);
			Libri d = new Libri(id, numPagineInt, annoInt, posizioneInt, titolo, genere, autore, isbn, casaEditrice);
			boolean res = libriDao.update(d);
			if (res) {
				response.getWriter().append("Aggiornamento effettuato");
			} else {
				response.getWriter().append("parametri non corretti");
			}
		} else {
			response.getWriter().append("parametri non corretti");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String Id = request.getParameter("id");
		response.addHeader("Content-Type", "text/html");

		if (Id != null) {
			int id = Integer.parseInt(Id);
			Libri d = new Libri();
			d.setIdLibro(id);
			libriDao.remove(d);
			response.getWriter().append("Rimosso il libro con id " + id + ".");

		} else {
			response.getWriter().append("Errore nella rimozione. ");

		}

	}

	private void findById(HttpServletRequest request, HttpServletResponse response) {
		int id = 1;
		libriDao.findById(id);
	}

	private void findBykv(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String k = request.getParameter("k");
		String v = request.getParameter("v");
		if (k != null && v != null) {
			List<Libri> res = this.libriDao.findBykv(k, v);
			request.getSession().setAttribute("lista", res);
			request.getRequestDispatcher("findAllLibri.jsp").forward(request, response);
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Libri> res = libriDao.findAll();
		request.getSession().setAttribute("lista", res);
		request.getRequestDispatcher("findAllLibri.jsp").forward(request, response);
	}
}
