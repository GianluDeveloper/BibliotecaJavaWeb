package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TurniDao;
import main.JavaDate;
import model.Cliente;
import model.Turni;

@WebServlet("Turni")
public class TurniCtr extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TurniDao turniDao = new TurniDao();
	
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
		}else if(azione.equals("findBykv")) {
			this.findBykv(request, response);
		}else {
			response.getWriter().append("Azione non riconosciuta.");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	private void insert(HttpServletRequest request,HttpServletResponse response) throws IOException {

		String data_inizio=request.getParameter("data_inizio"), 
				data_fine=request.getParameter("data_fine");
		String dipendenteGet = request.getParameter("idDipendente");
		
		if(data_inizio!=null&&data_fine!=null&dipendenteGet!=null) {
			int idDipendente = Integer.parseInt(dipendenteGet);
			data_inizio=new JavaDate().handleWebFormat(data_inizio);
			data_fine=new JavaDate().handleWebFormat(data_fine);

			Turni d = new Turni(0, idDipendente, data_inizio, data_fine);
			boolean res = turniDao.insert(d);
			response.addHeader("Content-Type", "text/html");
			response.getWriter().append("Turno inserito correttamente"+". ");
		}else {
			response.getWriter().append("si e' verificato un errore");
		}			
		
	}
	private void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String data_inizio=request.getParameter("data_inizio"), 
				data_fine=request.getParameter("data_fine");
		String dipendenteGet = request.getParameter("idDipendente");
		String idTurnoGet=request.getParameter("idTurni");
		if(idTurnoGet!=null&&data_inizio!=null&&data_fine!=null&dipendenteGet!=null) {
			int idDipendente = Integer.parseInt(dipendenteGet);
			int idTurno = Integer.parseInt(idTurnoGet);
			data_inizio=new JavaDate().handleWebFormat(data_inizio);
			data_fine=new JavaDate().handleWebFormat(data_fine);
			Turni d = new Turni(idTurno, idDipendente, data_inizio, data_fine);
			boolean res = turniDao.update(d);
			response.addHeader("Content-Type","text/html");

			response.getWriter().append("Turno aggiornato correttamente"+". ");
		}else {
			response.addHeader("Content-Type","text/html");

			response.getWriter().append("si e' verificato un errore"+". ");
		}	
	}
	private void remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String turno = request.getParameter("id");
		response.addHeader("Content-Type","text/html");

		if(turno!=null) {
			int idTurno = Integer.parseInt(turno);
			Turni d = new Turni();
			d.setIdTurni(idTurno);
			boolean res = turniDao.remove(d);
			response.getWriter().append("Turno "+idTurno+" rimosso"+". ");
		}else {
			response.getWriter().append("Errore nei parametri"+". ");
		}
		
	}
	private void findById(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String turno = request.getParameter("idTurno");
		if(turno!=null) {
			int idTurno = Integer.parseInt(turno);
			Turni res = turniDao.findById(idTurno);
			String html = "";
			html += "idTurno: "+res.getIdTurni()+" idDipendente: "+res.getIdDipendente()+
					" dataInizio: "+res.getData_inizio()+" data fine: "+res.getData_fine();
			response.getWriter().append(html);
		}
		
	}
	private void findBykv(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String k = request.getParameter("k");
		String v = request.getParameter("v");
		if(k!=null&&v!=null) {
			List<Turni> res = turniDao.findBykv(k,v);
			request.getSession().setAttribute("turni", res);
			request.getRequestDispatcher("findAllTurni.jsp").forward(request, response);
		}
		
		
	}
	private void findAll(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		List<Turni> res = turniDao.findAll();
		
		request.getSession().setAttribute("turni", res);
		request.getRequestDispatcher("findAllTurni.jsp").forward(request, response);
	}
}
