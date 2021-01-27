package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DipendentiDao;
import model.Dipendenti;

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
		}else if(azione.equals("findAll")) {
			this.findAll(request, response);
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

			response.getWriter().append("Dipendente inserito correttamente"+". Torna alla <a href='/BibliotecaServlet'>home</a>");
		}else {
			response.getWriter().append("Qualcosa e' andato storto");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	private void update(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String matricolaget = request.getParameter("matricola");
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
			response.getWriter().append("Utente "+id+" aggiornato. Torna alla <a href='/BibliotecaServlet'>home</a>");

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
			response.getWriter().append("Rimosso l'utente con id "+id+". Torna alla <a href='/BibliotecaServlet'>home</a>");

		}else {
			response.getWriter().append("Errore nella rimozione. Torna alla <a href='/BibliotecaServlet'>home</a>");

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
	
	private void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Dipendenti> res = dipendentiDao.findAll();
		request.getSession().setAttribute("lista", res);
		request.getRequestDispatcher("findAllDipendenti.jsp").forward(request, response);
	}
}
