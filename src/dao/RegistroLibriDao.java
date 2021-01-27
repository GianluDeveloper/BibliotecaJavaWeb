package dao;

import java.util.ArrayList;
import java.util.List;

import main.JavaDate;
import main.ObjSql;
import model.Cliente;
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
				d.getData_prestito().split("/"),
				d.getData_scadenza().split("/"),
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
			cliente.setData_prestito(new JavaDate().back((java.sql.Date)clienteDb[4]));
			cliente.setData_scadenza(new JavaDate().back((java.sql.Date)clienteDb[5]));
			cliente.setData_rientro(new JavaDate().back((java.sql.Date)clienteDb[6]));
		}
		
		return cliente;
	}
	
	public List<Registro> findBykv(String k , String v) {
		List<Registro> registri = new ArrayList<>();
		String[]allowed = {"id","idLibro", "idCliente","idDipendente","data_prestito",
				"data_scadenza","data_rientro"};

		boolean isAllowed=false;
		for(String check: allowed) {
			if(k.equals(check)) {
				isAllowed=true;
				break;
			}
		}
		
		if(!isAllowed) {
			return registri;
		}


		Object [] campiString = {v};
		
		
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `id`,`idLibro`, `idCliente`,`idDipendente`,`data_prestito`,"+
				"`data_scadenza`,`data_rientro` "
				+ "FROM `registro` WHERE `"+k+"`=?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			for(Object p:rsp) {
				Registro cliente = new Registro();
				Object[] clienteDb = (Object[]) p;
				cliente.setId((int)clienteDb[0]);
				cliente.setIdLibro((int)clienteDb[1]);
				cliente.setIdCliente((int)clienteDb[2]);
				cliente.setIdDipendente((int)clienteDb[3]);
				cliente.setData_prestito(new JavaDate().back((java.sql.Date)clienteDb[4]));
				cliente.setData_scadenza(new JavaDate().back((java.sql.Date)clienteDb[5]));
				cliente.setData_rientro(new JavaDate().back((java.sql.Date)clienteDb[6]));
				registri.add(cliente);
			}
			
		}
		
		return registri;
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
			for(Object p:rsp) {
				Registro cliente = new Registro();
				Object[] clienteDb = (Object[]) p;
				cliente.setId((int)clienteDb[0]);
				cliente.setIdLibro((int)clienteDb[1]);
				cliente.setIdCliente((int)clienteDb[2]);
				cliente.setIdDipendente((int)clienteDb[3]);
				cliente.setData_prestito(new JavaDate().back((java.sql.Date)clienteDb[4]));
				cliente.setData_scadenza(new JavaDate().back((java.sql.Date)clienteDb[5]));
				cliente.setData_rientro(new JavaDate().back((java.sql.Date)clienteDb[6]));
				registri.add(cliente);
			}
			
		}
		
		return registri;
	}
	
	
}
