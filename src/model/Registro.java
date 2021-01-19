package model;

public class Registro {
	private int id,idLibro,idCliente,idDipendente;
	private String data_prestito,data_scadenza,data_rientro;
	
	public Registro(int id, int idLibro, int idCliente, int idDipendente, String data_prestito, String data_scadenza,
			String data_rientro) {
		this.id = id;
		this.idLibro = idLibro;
		this.idCliente = idCliente;
		this.idDipendente = idDipendente;
		this.data_prestito = data_prestito;
		this.data_scadenza = data_scadenza;
		this.data_rientro = data_rientro;
	}
	
	public Registro() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdDipendente() {
		return idDipendente;
	}
	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}
	public String getData_prestito() {
		return data_prestito;
	}
	public void setData_prestito(String data_prestito) {
		this.data_prestito = data_prestito;
	}
	public String getData_scadenza() {
		return data_scadenza;
	}
	public void setData_scadenza(String data_scadenza) {
		this.data_scadenza = data_scadenza;
	}
	public String getData_rientro() {
		return data_rientro;
	}
	public void setData_rientro(String data_rientro) {
		this.data_rientro = data_rientro;
	}
	
}
