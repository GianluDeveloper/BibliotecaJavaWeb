package dao;


import java.util.ArrayList;
import java.util.List;

import main.ObjSql;
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
		String sql = "DELETE FROM `libri` WHERE id=?";
		boolean resp = connettore.sql(sql, campiString);
		return resp;
	}
	
	public Libri findById(int id) {
		Libri cliente = new Libri();
		Object [] campiString = {id};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idLibro`, `numPagine`,`anno`,`posizione`,`titolo`,"+
				"`genere`,`autore`,`isbn`,`casaEditrice` "
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
		}
		
		return cliente;
	}
	
	public List<Libri> findAll() {
		List<Libri> libri = new ArrayList<>();
		
		Object [] campiString = {1};
		ObjSql connettore = new ObjSql();
		String sql = "SELECT `idLibro`, `numPagine`,`anno`,`posizione`,`titolo`,"+
				"`genere`,`autore`,`isbn`,`casaEditrice` "
				+ "FROM `libri` WHERE ?";
		boolean resp = connettore.sql(sql, campiString);
		
		List<Object> rsp = connettore.getResponse();
		if(resp && rsp.size()>0) {
			Libri cliente = new Libri();
			Object[] clienteDb = (Object[]) rsp.get(0);
			cliente.setIdLibro((int)clienteDb[0]);
			cliente.setNumPagine((int)clienteDb[1]);
			cliente.setAnno((int)clienteDb[2]);
			cliente.setPosizione((int)clienteDb[3]);
			cliente.setTitolo((String)clienteDb[4]);
			cliente.setGenere((String)clienteDb[5]);
			cliente.setIsbn((String)clienteDb[6]);
			cliente.setCasaEditrice((String)clienteDb[7]);
			libri.add(cliente);
		}
		
		return libri;
	}
	
}
