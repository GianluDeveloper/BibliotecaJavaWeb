package ctr;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import exceptions.CustomException;
import model.Cliente;
import model.Dipendenti;

@WebServlet("Cliente")
public class ClienteCtr extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteDao clienteDao = new ClienteDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.addHeader("Content-Type", "text/html");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String telefono = request.getParameter("telefono");
		String Id = request.getParameter("id");
		String operazione = request.getParameter("azione");
		String k = request.getParameter("k");
		String v = request.getParameter("v");
		if(Id!=null&&operazione!=null&&operazione.equals("findById")) {
			Integer id = Integer.parseInt(Id);
			Cliente c1 = this.findById(id);
			String resp = "Ho trovato all'id "+id+" nome: "+c1.getNome()+
					" cognome: "+c1.getCognome()+" telefono: "+c1.getTelefono();
			response.getWriter().append(resp);
		}else if(operazione!=null&&operazione.equals("findBykv")&&k!=null&&v!=null) {
			this.findBykv(k,v,request,response);
		}
		else if(operazione!=null&&operazione.equals("insert")&& nome!=null&&cognome!=null&&telefono!=null) {
			Cliente cl = new Cliente(1,nome,cognome,telefono);
			try {
				this.insert(cl);
			} catch (CustomException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.addHeader("Content-Type", "text/html");

			String ret="Ho inserito "+nome+" "+cognome+" telefono "+telefono+". Torna alla <a href='/BibliotecaServlet'>home</a>";
			response.getWriter().append(ret);
		}else if(operazione!=null&&operazione.equals("update") && Id!=null&& nome!=null&&cognome!=null&&telefono!=null) {
			Cliente c2 = new Cliente(Integer.parseInt(Id),nome,cognome,telefono);
			this.update(c2);
			response.addHeader("Content-type", "text/html; charset=utf-8");
			String ret="Ho aggiornato id: "+c2.getIdCliente()+" nome: "+nome+" "+cognome+" telefono "+telefono+". Torna alla <a href='/BibliotecaServlet'>home</a>";
			response.getWriter().append(ret);
		}else if(operazione!=null&&operazione.equals("findAll")) {
			this.findAll(request,response);
		}else if(operazione!=null&&operazione.equals("remove")) {
			this.remove(request,response);
		}else {
			String action="insert";
			if(operazione!=null) {
				action = operazione;
			}
			if(Id!=null) {
				action="update";
			}else {
				Id="";
			}
			if(nome==null)nome="";
			if(cognome==null)cognome="";
			if(telefono==null)telefono="";
			response.getWriter().append("<html><head><meta charset='utf-8'><title>inserisci Cliente</title></head><body>"
					+ "<form method='GET'><input type='text' value='"+nome+"' name='nome' placeholder='nome'/>"
					+ "<input type='text' name='cognome' value='"+cognome+"' placeholder='cognome'/>"
					+ "<input type='text' value='"+telefono+"' placeholder='telefono' name='telefono'/>"
					+ "<input type='text' value='"+Id+"' placeholder='idCliente' name='id'><input type='submit'/>"
					+ "<input type='hidden' name='azione' value='"+action+"'/></form><div><button onclick='window.location.href=\"?azione=findAll\"'>findAll</button>&nbsp;"
					+ "<button onclick='window.location.href=\"?\"'>Aggiungi nuovo</button></body></html> ");
		}
	}
	
	private void insert(Cliente d) throws CustomException  {
		boolean res = this.clienteDao.insert(d);
		if(!res) throw new CustomException( "Inserimento fallito");
	}
	private void findBykv(String k,String v,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> res = this.clienteDao.findBykv(k,v);
		request.getSession().setAttribute("lista", res);
		request.getRequestDispatcher("findAllClienti.jsp").forward(request, response);
//		
//		String html="<table>";
//		for(Cliente c : res) {
//			html+="<tr>"+
//					"<td><button title='modifica questo utente' onclick='window.location.href=\"?id="+c.getIdCliente()+"&nome="+
//					c.getNome()+"&cognome="+c.getCognome()+"&telefono="+c.getTelefono()+
//					"\"'>Modifica utente "+c.getIdCliente()+"</a></td>"+
//					"<td>"+c.getNome()+"</td>"+
//					"<td>"+c.getCognome()+"</td>"+
//					"<td>"+c.getTelefono()+"</td><td>"
//					+ "<button onclick='window.location.href=\"?azione=remove&id="+c.getIdCliente()
//					+"\"'>Rimuovi questo utente</button></tr>";
//		}
//		html+="</table>";
//		request.getSession().setAttribute("html", html);
//		request.getRequestDispatcher("findAllClienti.jsp").forward(request,response);
	}
	
	private boolean update(Cliente d) {
		boolean res = this.clienteDao.update(d);
		return res;
	}
	
	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String Id = request.getParameter("id");
		if(Id!=null) {
			int id = Integer.parseInt(Id);
			Cliente d = new Cliente();
			d.setIdCliente(id);
			this.clienteDao.remove(d);
			response.addHeader("Content-Type","text/html");
			response.getWriter().append("Rimosso l'utente con id "+id+". Torna alla <a href='/BibliotecaServlet'>home</a>");
		}
	}
	
	private Cliente findById(int id) {
		Cliente res = this.clienteDao.findById(id);
		return res;
	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		List<Cliente> res = this.clienteDao.findAll();
//		String html="<table><tr><th>Nome</th><th>Cognome</th><th>Telefono</th><th>";
//		for(Cliente c : res) {
//			html+="<tr>"+
//					"<td><button title='modifica questo utente' onclick='window.location.href=\"?id="+c.getIdCliente()+"&nome="+
//					c.getNome()+"&cognome="+c.getCognome()+"&telefono="+c.getTelefono()+
//					"\"'>Modifica utente "+c.getIdCliente()+"</a></td>"+
//					"<td>"+c.getNome()+"</td>"+
//					"<td>"+c.getCognome()+"</td>"+
//					"<td>"+c.getTelefono()+"</td><td>"
//					+ "<button onclick='window.location.href=\"?azione=remove&id="+c.getIdCliente()
//					+"\"'>Rimuovi questo utente</button></tr>";
//		}
//		html+="</table>";
//		request.getSession().setAttribute("html", html);
//		request.getRequestDispatcher("findAllClienti.jsp").forward(request,response);
		List<Cliente> res = clienteDao.findAll();
		request.getSession().setAttribute("lista", res);
		request.getRequestDispatcher("findAllClienti.jsp").forward(request, response);
		//response.getWriter().append(html);
	}
}
