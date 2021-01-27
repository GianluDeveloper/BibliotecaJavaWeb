package dao;


import java.util.ArrayList;
import java.util.List;

import main.ObjSql;
import model.Dipendenti;
import model.Libri;

public class LibriDao {

	public LibriDao() {}

	public boolean insert(Libri d)  {
		Object [] campiString = {d.getNumPagine(),d.getAnno(),d.getPosizione(),d.getTitolo(),
				d.getGenere(),d.getAutore(),d.getIsbn(),d.getCasaEditrice()};
		ObjSql connettore = new ObjSql();
		String sql = "INSERT INTO `libri`(`numPagine`, `anno`, `posizione`,"
				+ " `titolo`, `genere`, `autore`, `isbn`, `casaEditrice`) VALUES "
				+ "(?,?,?,?,?,?,?,?);";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean update(Libri d) {
		Object [] campiString = {d.getNumPagine(),d.getAnno(),d.getPosizione(),d.getTitolo(),
				d.getGenere(),d.getAutore(),d.getIsbn(),d.getCasaEditrice(),d.getIdLibro()};
		ObjSql connettore = new ObjSql();
		String sql = "UPDATE `libri` SET `numPagine`=?,`anno`=?,`posizione`=?,`titolo`=?,"
				+ "`genere`=?,`autore`=?,`isbn`=?,`casaEditrice`=? WHERE `idLibro` = ?;";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public boolean remove(Libri d) {
		Object [] campiString = {d.getIdLibro()};
		ObjSql connettore = new ObjSql();
		String sql = "DELETE FROM `libri` WHERE idLibro=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public Libri findById(int id) {
		Libri cliente = new Libri();
		Object [] campiString = {id};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idLibro`, `numPagine`,`anno`,`posizione`,`titolo`,"+
				"`genere`,`autore`,`isbn`,`casaEditrice`,`autore` "
				+ "FROM `libri` WHERE `idLibro` = ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setIdLibro((int)clienteDb[0]);
			cliente.setNumPagine((int)clienteDb[1]);
			cliente.setAnno((int)clienteDb[2]);
			cliente.setPosizione((int)clienteDb[3]);
			cliente.setTitolo((String)clienteDb[4]);
			cliente.setGenere((String)clienteDb[5]);
			cliente.setIsbn((String)clienteDb[6]);
			cliente.setCasaEditrice((String)clienteDb[7]);
			cliente.setAutore((String)clienteDb[8]);
		}
		
		return cliente;
	}
	
	public List<Libri> findBykv(String k,String v) {
		String[]allowed = {"idLibro","numPagine", "anno", "posizione", "titolo",
				"genere","autore","isbn","casaEditrice"};
		List<Libri> libri = new ArrayList<>();

		boolean isAllowed=false;
		for(String check: allowed) {
			if(k.equals(check)) {
				isAllowed=true;
				break;
			}
		}
		
		if(!isAllowed) {
			return libri;
		}


		Object [] campiString = {v};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idLibro`, `numPagine`,`anno`,`posizione`,`titolo`,"
				+ " `genere`,`autore`,`isbn`,`casaEditrice`,`autore` "
				+ " FROM `libri` WHERE `"+k+"`=?";
		
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			for(int i=0;i<rsp.size();i++) {
				Libri cliente = new Libri();

				Object[] clienteDb = (Object[]) rsp.get(i);
				cliente.setIdLibro((int)clienteDb[0]);
				cliente.setNumPagine((int)clienteDb[1]);
				cliente.setAnno((int)clienteDb[2]);
				cliente.setPosizione((int)clienteDb[3]);
				cliente.setTitolo((String)clienteDb[4]);
				cliente.setGenere((String)clienteDb[5]);
				cliente.setIsbn((String)clienteDb[6]);
				cliente.setCasaEditrice((String)clienteDb[7]);
				cliente.setAutore((String)clienteDb[8]);
				libri.add(cliente);
			}
		}
		
		return libri;
	}
	
	public List<Libri> findAll() {
		List<Libri> libri = new ArrayList<>();
		
		Object [] campiString = {1};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idLibro`, `numPagine`,`anno`,`posizione`,`titolo`,"+
				"`genere`,`autore`,`isbn`,`casaEditrice`,`autore` "
				+ "FROM `libri` WHERE ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			for(int i = 0;i<rsp.size();i++) {
				Libri cliente = new Libri();

				Object[] clienteDb = (Object[]) rsp.get(i);
				cliente.setIdLibro((int)clienteDb[0]);
				cliente.setNumPagine((int)clienteDb[1]);
				cliente.setAnno((int)clienteDb[2]);
				cliente.setPosizione((int)clienteDb[3]);
				cliente.setTitolo((String)clienteDb[4]);
				cliente.setGenere((String)clienteDb[5]);
				cliente.setIsbn((String)clienteDb[6]);
				cliente.setCasaEditrice((String)clienteDb[7]);
				cliente.setAutore((String)clienteDb[8]);
				libri.add(cliente);
			}
		}
		
		return libri;
	}
	
}
