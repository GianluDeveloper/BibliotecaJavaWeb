package model;

public class Dipendenti {
	
	private int matricola;
	private String nome;
	private String cognome;
	private String telefono;
	private boolean admin;
	
	
	
	public Dipendenti(int matricola, String nome, String cognome, String telefono, boolean admin){
		
		this.matricola = matricola;
		this.nome = nome;
		this.cognome=cognome;
		this.telefono=telefono;
		this.admin = admin;
		
	}

	public Dipendenti(){}
	
	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
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

	public boolean isAdmin() {
		return this.admin;
	}	
	
	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public void printToScreen() {
		System.out.println(this.matricola+" "+this.nome+
				" "+this.cognome+" "+this.telefono);
	}
}
