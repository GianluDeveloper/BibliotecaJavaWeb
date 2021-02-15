package ctr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ClienteDao;
import dao.DipendentiDao;
import dto.CorsiDto;
import ejb.EJBCorsiRemote;
import main.JavaDate;
import model.Cliente;
import model.Dipendenti;
import react.TestObject;
import response.ResponseDao;

@WebServlet("api")
public class Api extends HttpServlet {
	/**
	* 
	*/
	@Resource(mappedName = "java:jboss/exported/Corsi/EJBCorsi!ejb.EJBCorsiRemote")
	private EJBCorsiRemote bs;
	
	private ClienteDao clienteDao = new ClienteDao();
	private DipendentiDao dipendentiDao = new DipendentiDao();

	private static final long serialVersionUID = -6848635859981358008L;
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String type=request.getParameter("type");
		if (type!=null&&type.equals("dipendenti")) {
			List<Dipendenti> obj = dipendentiDao.findAll();
			this.pushResponse(response, obj);
		} 
		else if(type!=null && type.equals("corsi")) {
			int id = 1;
			ResponseDao<CorsiDto> iscrizioniUpdateS = bs.findById(id);
			CorsiDto res = iscrizioniUpdateS.getList().get(0);
//			CorsiDto IscrizioneUpdate = iscrizioniUpdateS.getList().get(0);
//			String tmpFine = IscrizioneUpdate.getDataFine();
//			String tmpInizio = IscrizioneUpdate.getDataInizio();
			String tmpFine = res.getDataFine();
			String tmpInizio = res.getDataInizio();
			res.setDataInizio( new JavaDate().toWebFormat(tmpInizio));
			res.setDataFine( new JavaDate().toWebFormat(tmpFine));
			String userJsonString = this.gson.toJson(res);

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Access-Control-Allow-Origin", "*");
			out.print(userJsonString);
			out.flush();
		}else {
			List<Cliente> res = clienteDao.findAll();
			TestObject u = new TestObject();
			u.setTitle("java online");
			String userJsonString = this.gson.toJson(res);

			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Access-Control-Allow-Origin", "*");
			out.print(userJsonString);
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
	private void pushResponse(HttpServletResponse response,Object obj) throws IOException {
		String userJsonString = this.gson.toJson(obj);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		out.print(userJsonString);
		out.flush();
	}
}
