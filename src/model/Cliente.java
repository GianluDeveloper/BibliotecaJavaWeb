package model;

public class Cliente {
	
	private int idCliente;
	private String nome,cognome,telefono;
	
	public Cliente(){
		
	}
	
	
	public Cliente(int idCliente, String nome, String cognome, String telefono) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}


//	public void printToScreen() {
//		System.out.println(this.idCliente+" "+this.nome+
//				" "+this.cognome+" "+this.telefono);
//	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
