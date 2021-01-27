package dao;

import java.util.ArrayList;
import java.util.List;

import main.ObjSql;
import model.Dipendenti;

public class DipendentiDao {
	
	public DipendentiDao() {}
	
	
	public boolean insert(Dipendenti d)  {
		Object [] campiString = {d.getNome(),d.getCognome(),d.getTelefono(),d.isAdmin()};
		ObjSql connettore = new ObjSql();
		String sql = "INSERT INTO dipendente(nome, cognome,telefono,admin) VALUES(?,?,?,?)";
		System.out.println(d.isAdmin());
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean update(Dipendenti d) {
		Object [] campiString = {d.getNome(),d.getCognome(),d.getTelefono(),
				d.isAdmin(),d.getMatricola()};
		ObjSql connettore = new ObjSql();
		String sql = "UPDATE `dipendente` SET `nome`=?,`cognome`=?,`telefono`=?,`admin`=? WHERE id=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean remove(Dipendenti d) {
		Object [] campiString = {d.getMatricola()};
		ObjSql connettore = new ObjSql();
		String sql = "DELETE FROM `dipendente` WHERE id=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public Dipendenti findById(int id) {
		Dipendenti dipendente = new Dipendenti();
		Object [] campiString = {id};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `id`, `nome`, `cognome`, `telefono`,`admin` FROM `dipendente` "
				+ "WHERE `id`= ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Object[] dipendenteDb = (Object[]) rsp.get(0);
			dipendente.setMatricola((int)dipendenteDb[0]);
			dipendente.setNome((String)dipendenteDb[1]);
			dipendente.setCognome((String)dipendenteDb[2]);
			dipendente.setTelefono((String)dipendenteDb[3]);
			dipendente.setAdmin((boolean)dipendenteDb[4]);
		}
		
		return dipendente;
	}
	
	public List<Dipendenti> findAll() {
		List<Dipendenti> dipendenti = new ArrayList<>();
		Object [] campiString = {1};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `id`, `nome`, `cognome`, `telefono`,`admin` FROM `dipendente` "
				+ "WHERE ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			for(int i=0;i<rsp.size();i++) {
				Object[] dipendenteDb = (Object[]) rsp.get(i);
				Dipendenti dipendente = new Dipendenti();
				dipendente.setMatricola((int)dipendenteDb[0]);
				dipendente.setNome((String)dipendenteDb[1]);
				dipendente.setCognome((String)dipendenteDb[2]);
				dipendente.setTelefono((String)dipendenteDb[3]);
				dipendente.setAdmin((boolean)dipendenteDb[4]);

				dipendenti.add(dipendente);
			}
		}
		
		return dipendenti;
	}
	
}
