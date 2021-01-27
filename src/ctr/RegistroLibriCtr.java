package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistroLibriDao;
import main.JavaDate;
import model.Registro;

@WebServlet("RegistroLibri")
public class RegistroLibriCtr extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RegistroLibriDao registroLibriDao = new RegistroLibriDao();
	
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
		}else if(azione.equals("findAll")) {
			this.findAll(request, response);
		}else {
			response.getWriter().append("Azione non riconosciuta.");
		}
	}
	private void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String idLibro=request.getParameter("idLibro"),idCliente=request.getParameter("idCliente"),
				idDipendente=request.getParameter("idDipendente");
		String data_prestito=request.getParameter("data_prestito"),data_scadenza=request.getParameter("data_scadenza"),
			   data_rientro=request.getParameter("data_rientro");
		if(idLibro!=null&&idCliente!=null&&idDipendente!=null&&data_prestito!=null&&
				data_scadenza!=null&&data_rientro!=null) {
			int idLibroInt = Integer.parseInt(idLibro);
			int idClienteInt=Integer.parseInt(idCliente);
			int idDipendenteInt=Integer.parseInt(idDipendente);
			data_prestito=new JavaDate().handleWebFormat(data_prestito);
			data_rientro=new JavaDate().handleWebFormat(data_rientro);
			data_scadenza=new JavaDate().handleWebFormat(data_scadenza);
			Registro d = new Registro(0,idLibroInt,idClienteInt,idDipendenteInt,data_prestito,data_scadenza,data_rientro);
			boolean res = registroLibriDao.insert(d);
			if(res) {
				response.addHeader("Content-Type", "text/html");

				response.getWriter().append("Registro inserito correttamente"+". Torna alla <a href='/BibliotecaServlet'>home</a>");
			}else {
				response.getWriter().append("errore inserimento");
			}
		}else {
			response.getWriter().append("parametri non corretti");
		}
		
	}
	private void update(HttpServletRequest request,HttpServletResponse response) {
		Registro d = new Registro();
		boolean res = registroLibriDao.update(d);
	}
	private void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Id=request.getParameter("id");
		response.addHeader("Content-Type","text/html");

		if(Id!=null) {
			int id=Integer.parseInt(Id);
			Registro d = new Registro();
			d.setId(id);
			registroLibriDao.remove(d);
			response.getWriter().append("Rimosso il registro libri con id "+id+". Torna alla <a href='/BibliotecaServlet'>home</a>");

		}else {
			response.getWriter().append("Errore nella rimozione. Torna alla <a href='/BibliotecaServlet'>home</a>");

		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	private void findById(HttpServletRequest request,HttpServletResponse response) {
		int id = 0;
		Registro res = registroLibriDao.findById(id);
	}
	private void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Registro> res = registroLibriDao.findAll();
		request.getSession().setAttribute("registri", res);
		request.getRequestDispatcher("findAllRegistri.jsp").forward(request, response);
	}
}
