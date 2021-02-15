package publicApi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDao;
import model.Cliente;

@Path("Corsi")
public class Api {
	private ClienteDao clienteDao = new ClienteDao();


	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	
	public String test() {
		return "ok";
	}
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente>  findAll() {
		
		List<Cliente> res = clienteDao.findAll();
		return res;
	}
	

	
}
