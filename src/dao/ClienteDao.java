package dao;

import java.util.ArrayList;
import java.util.List;

import main.ObjSql;
import model.Cliente;

public class ClienteDao {
	
	public ClienteDao() {}
	
	public boolean insert(Cliente d)  {
		Object [] campiString = {d.getNome(),d.getCognome(),d.getTelefono()};
		ObjSql connettore = new ObjSql();
		String sql = "INSERT INTO cliente(nome, cognome,telefono) VALUES(?,?,?)";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean update(Cliente d) {
		Object [] campiString = {d.getNome(),d.getCognome(),d.getTelefono(),
				d.getIdCliente()};
		ObjSql connettore = new ObjSql();
		String sql = "UPDATE `cliente` SET `nome`=?,`cognome`=?,`telefono`=? WHERE idCliente=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean remove(Cliente d) {
		Object [] campiString = {d.getIdCliente()};
		ObjSql connettore = new ObjSql();
		String sql = "DELETE FROM `cliente` WHERE idCliente=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public Cliente findById(int id) {
		Cliente cliente = new Cliente();
		Object [] campiString = {id};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idCliente`, `nome`, `cognome`, `telefono` FROM `cliente` "
				+ "WHERE `idCliente`= ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setIdCliente((int)clienteDb[0]);
			cliente.setNome((String)clienteDb[1]);
			cliente.setCognome((String)clienteDb[2]);
			cliente.setTelefono((String)clienteDb[3]);
		}
		
		return cliente;
	}
	
	public List<Cliente> findAll() {
		List<Cliente> clienti = new ArrayList<>();
		Object [] campiString = {1};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idCliente`, `nome`, `cognome`, `telefono` FROM `cliente` "
				+ "WHERE ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			for(int i=0;i<rsp.size();i++) {
				Object[] clienteDb = (Object[]) rsp.get(i);
				Cliente cliente = new Cliente();
				cliente.setIdCliente((int)clienteDb[0]);
				cliente.setNome((String)clienteDb[1]);
				cliente.setCognome((String)clienteDb[2]);
				cliente.setTelefono((String)clienteDb[3]);
				clienti.add(cliente);
			}
		}
		
		return clienti;
	}
	
}
