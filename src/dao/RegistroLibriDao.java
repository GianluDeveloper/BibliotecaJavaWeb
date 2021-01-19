package dao;

import java.util.ArrayList;
import java.util.List;

import main.ObjSql;
import model.Registro;

public class RegistroLibriDao {
	
	public RegistroLibriDao() {}
	
	public boolean insert(Registro d)  {
		Object [] campiString = {d.getIdLibro(),d.getIdCliente(),d.getIdDipendente(),
				d.getData_prestito().split("/"),d.getData_scadenza().split("/")
				,d.getData_rientro().split("/")};
		ObjSql connettore = new ObjSql();
		String sql = "INSERT INTO `registro`(`idLibro`, `idCliente`, `idDipendente`, `data_prestito`,"
				+ " `data_scadenza`, `data_rientro`) VALUES (?,?,?,?,?,?);";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean update(Registro d) {
		Object [] campiString = {d.getIdLibro(),d.getIdCliente(),d.getIdDipendente(),
				d.getData_prestito().split("/"),d.getData_scadenza().split("/"),
				d.getData_rientro().split("/"),d.getId()};
		ObjSql connettore = new ObjSql();
		String sql = "UPDATE `registro` SET `idLibro`=?,`idCliente`=?,`idDipendente`=?,"
				+ "`data_prestito`=?,`data_scadenza`=?,`data_rientro`=? WHERE `id` = ?;";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}

	public boolean remove(Registro d) {
		Object [] campiString = {d.getId()};
		ObjSql connettore = new ObjSql();
		String sql = "DELETE FROM `registro` WHERE id=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	

	public Registro findById(int id) {
		Registro cliente = new Registro();
		Object [] campiString = {id};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `id`,`idLibro`, `idCliente`,`idDipendente`,`data_prestito`,"+
				"`data_scadenza`,`data_rientro`"
				+ "FROM `registro` WHERE `id` = ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setId((int)clienteDb[0]);
			cliente.setIdLibro((int)clienteDb[1]);
			cliente.setIdCliente((int)clienteDb[2]);
			cliente.setIdDipendente((int)clienteDb[3]);
			cliente.setData_prestito((String)clienteDb[4]);
			cliente.setData_scadenza((String)clienteDb[5]);
			cliente.setData_rientro((String)clienteDb[6]);
		}
		
		return cliente;
	}
	

	public List<Registro> findAll() {
		List<Registro> registri = new ArrayList<>();
		
		Object [] campiString = {1};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `id`,`idLibro`, `idCliente`,`idDipendente`,`data_prestito`,"+
				"`data_scadenza`,`data_rientro`"
				+ "FROM `registro` WHERE ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Registro cliente = new Registro();
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setId((int)clienteDb[0]);
			cliente.setIdLibro((int)clienteDb[1]);
			cliente.setIdCliente((int)clienteDb[2]);
			cliente.setIdDipendente((int)clienteDb[3]);
			cliente.setData_prestito((String)clienteDb[4]);
			cliente.setData_scadenza((String)clienteDb[5]);
			cliente.setData_rientro((String)clienteDb[6]);
			registri.add(cliente);
		}
		
		return registri;
	}
	
	
}
