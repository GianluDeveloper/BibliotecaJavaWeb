package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ctr.ClienteCtr;
import exceptions.CustomException;
import model.Cliente;

/**
 * Servlet implementation class HelloWorld
 */

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getHeader("Content-type", "text/html");
		ClienteCtr clienteCtr = new ClienteCtr();
		Cliente nelDb = null;
		try {
			nelDb = clienteCtr.findById(11);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		//nelDb=new Cliente();
		//nelDb.setCognome("okiii");
		
		response.addHeader("Content-Type", "text/html");
		String test = request.getParameter("password");
		if(test==null) {
			String res = "Ciao "+nelDb.getCognome();
			//System.out.println("Ciao "+nelDb.getNome()+" "+nelDb.getCognome());
			response.getWriter().append(res).append(" Per loggarti, utilizza il parametro get <a href='?password=segreta'>?password=segreta</a>");
		}else {
			if(  test.matches("^segreta$")) {
				Cliente c1 = new Cliente(1,"Sono","unServlet","32883838338");
				
				try {
					clienteCtr.insert(c1);
				} catch (CustomException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				response.getWriter().append("Utente aggiunto nel db!");
			}else {
				response.getWriter().append("L'utente "+test+" non e' autorizzato");
				//			response.getWriter().append("Served at: ").append(request.getContextPath()).append(test);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
