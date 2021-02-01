package model;

public class Turni {
	private int idTurni, idDipendente;
	private String data_inizio, data_fine;

	public Turni() {

	}

	public Turni(int idTurni, int idDipendente, String data_inizio, String data_fine) {
		this.idTurni = idTurni;
		this.idDipendente = idDipendente;
		this.setData_inizio(data_inizio);
		;
		this.setData_fine(data_fine);
	}

	public int getIdTurni() {
		return idTurni;
	}

	public void setIdTurni(int idTurni) {
		this.idTurni = idTurni;
	}

	public int getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
		this.idDipendente = idDipendente;
	}

	public String getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(String data_inizio) {
		if (data_inizio.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$"))
			this.data_inizio = data_inizio;
		else
			System.err.println("ATTENZIONE: Data non nel formato corretto");
	}

	public String getData_fine() {
		return data_fine;
	}

	public void setData_fine(String data_fine) {
		if (data_fine.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$"))
			this.data_fine = data_fine;
		else
			System.err.println("ATTENZIONE: Data non nel formato corretto");
	}
}
