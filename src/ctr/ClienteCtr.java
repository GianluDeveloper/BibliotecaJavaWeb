package ctr;

import java.util.List;

import dao.ClienteDao;
import model.Cliente;

public class ClienteCtr {
	
	private ClienteDao clienteDao = new ClienteDao();
	
	public void insert(Cliente d) throws Exception  {
		boolean res = this.clienteDao.insert(d);
		if(!res) throw new Exception( "Inserimento fallito");
	}
	
	public boolean update(Cliente d) {
		boolean res = this.clienteDao.update(d);
		return res;
	}
	
	public boolean remove(Cliente d) {
		boolean res = this.clienteDao.remove(d);
		return res;
	}
	
	public Cliente findById(int id) {
		Cliente res = this.clienteDao.findById(id);
		return res;
	}
	
	public List<Cliente> findAll() {
		List<Cliente> res = this.clienteDao.findAll();
		return res;
	}
}
