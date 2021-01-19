package dao;

import java.util.ArrayList;
import java.util.List;

import main.ObjSql;
import model.Turni;

public class TurniDao {

	public TurniDao() {}
	
	public boolean insert(Turni d)  {
		Object [] campiString = {d.getIdDipendente(),d.getData_inizio().split("/"),
				d.getData_fine().split("/")};
		ObjSql connettore = new ObjSql();
		String sql = "INSERT INTO turni(`idDipendente`, `data_inizio`, `data_fine`) VALUES(?,?,?);";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean update(Turni d) {
		Object [] campiString = {d.getIdDipendente(),d.getData_inizio().split("/"),
				d.getData_fine().split("/"), d.getIdTurni()};
		ObjSql connettore = new ObjSql();
		String sql = "UPDATE `turni` SET `idDipendente`=?,`data_inizio`=?,`data_fine`=? WHERE `idTurni`=?;";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean remove(Turni d) {
		Object [] campiString = {d.getIdTurni()};
		ObjSql connettore = new ObjSql();
		String sql = "DELETE FROM `turni` WHERE idTurni=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public Turni findById(int id) {
		Turni cliente = new Turni();
		Object [] campiString = {id};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idTurni`, `idDipendente`, `data_inizio`, `data_fine` FROM `turni` "
				+ "WHERE `idTurni`= ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setIdTurni((int)clienteDb[0]);
			cliente.setIdDipendente((int)clienteDb[1]);
			cliente.setData_inizio((String)clienteDb[2]);
			cliente.setData_fine((String)clienteDb[3]);
		}
		
		return cliente;
	}
	
	public List<Turni> findAll() {
		List<Turni> turni = new ArrayList<>();
		Object [] campiString = {1};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idTurni`, `idDipendente`, `data_inizio`, `data_fine` FROM `turni` "
				+ "WHERE ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Turni cliente = new Turni();
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setIdTurni((int)clienteDb[0]);
			cliente.setIdDipendente((int)clienteDb[1]);
			cliente.setData_inizio((String)clienteDb[2]);
			cliente.setData_fine((String)clienteDb[3]);
			turni.add(cliente);
		}
		
		return turni;
	}
	
	
}
