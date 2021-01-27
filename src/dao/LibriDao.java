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
				"`genere`,`autore`,`isbn`,`casaEditrice` "
				+ " FROM `libri` WHERE `idLibro` = ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			int incr = 0;
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setIdLibro((int)clienteDb[incr++]);
			cliente.setNumPagine((int)clienteDb[incr++]);
			cliente.setAnno((int)clienteDb[incr++]);
			cliente.setPosizione((int)clienteDb[incr++]);
			cliente.setTitolo((String)clienteDb[incr++]);
			cliente.setGenere((String)clienteDb[incr++]);
			cliente.setAutore((String)clienteDb[incr++]);
			cliente.setIsbn((String)clienteDb[incr++]);
			cliente.setCasaEditrice((String)clienteDb[incr++]);
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
				+ " `genere`,`autore`,`isbn`,`casaEditrice` "
				+ " FROM `libri` WHERE `"+k+"`=?";
		
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			for(int i=0;i<rsp.size();i++) {
				Libri cliente = new Libri();
				int incr = 0;
				Object[] clienteDb = (Object[]) rsp.get(i);
				cliente.setIdLibro((int)clienteDb[incr++]);
				cliente.setNumPagine((int)clienteDb[incr++]);
				cliente.setAnno((int)clienteDb[incr++]);
				cliente.setPosizione((int)clienteDb[incr++]);
				cliente.setTitolo((String)clienteDb[incr++]);
				cliente.setGenere((String)clienteDb[incr++]);
				cliente.setAutore((String)clienteDb[incr++]);
				cliente.setIsbn((String)clienteDb[incr++]);
				cliente.setCasaEditrice((String)clienteDb[incr++]);
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
				"`genere`,`autore`,`isbn`,`casaEditrice` "
				+ " FROM `libri` WHERE ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			for(int i = 0;i<rsp.size();i++) {
				Libri cliente = new Libri();
				int incr = 0;
				Object[] clienteDb = (Object[]) rsp.get(i);
				cliente.setIdLibro((int)clienteDb[incr++]);
				cliente.setNumPagine((int)clienteDb[incr++]);
				cliente.setAnno((int)clienteDb[incr++]);
				cliente.setPosizione((int)clienteDb[incr++]);
				cliente.setTitolo((String)clienteDb[incr++]);
				cliente.setGenere((String)clienteDb[incr++]);
				cliente.setAutore((String)clienteDb[incr++]);
				cliente.setIsbn((String)clienteDb[incr++]);
				cliente.setCasaEditrice((String)clienteDb[incr++]);

				
				libri.add(cliente);
			}
		}
		
		return libri;
	}
	
}
