package publicApi;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dao.ClienteDao;
import dto.CorsiDto;
import model.Cliente;
import response.Response;
import response.ResponseDao;

@Path("Corsi")
public class Clienti {
	private ClienteDao clienteDao = new ClienteDao();
	Response r = new Response();
	ResponseDao<CorsiDto> rx = new ResponseDao<>();

	
	@GET
	@Path("/findById")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	
	public Cliente findById(@QueryParam("id") Integer id) {
		Cliente c = clienteDao.findById(id);
		return c;
	}
	@GET
	@Path("/findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente>  findAll() {
		
		List<Cliente> res = clienteDao.findAll();
		return res;
	}
	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  insert(Cliente c) {
		clienteDao.insert(c);
		Response res = new Response();
		res.setErrorCode(0);
		res.setDescription("OK");
		res.setSuccesso(true);
		return res;
	}
	@GET
	@Path("/find")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	
	public List<Cliente> find(@QueryParam("key") String key,@QueryParam("value") String value) {
		List<Cliente> c = clienteDao.findBykv(key, value);
		return c;
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  update(Cliente c) {
		clienteDao.update(c);
		Response res = new Response();
		res.setErrorCode(0);
		res.setDescription("OK");
		res.setSuccesso(true);
		return res;
	}
	@DELETE
	@Path("/remove")
	@Produces(MediaType.APPLICATION_JSON)
	public Response  remove(@QueryParam("id") Integer id) {
		Cliente c = new Cliente();
		c.setIdCliente(id);
		clienteDao.remove(c);
		Response res = new Response();
		res.setErrorCode(0);
		res.setDescription("Rimosso con successo");
		res.setSuccesso(true);
		return res;
	}

	
}