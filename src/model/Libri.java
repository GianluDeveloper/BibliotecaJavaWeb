package model;

public class Libri {
	private int idLibro, numPagine, anno, posizione;
	private String titolo, genere, autore, isbn, casaEditrice;

	public Libri(int idLibro, int numPagine, int anno, int posizione, String titolo, String genere, String autore,
			String isbn, String casaEditrice) {
		this.idLibro = idLibro;
		this.numPagine = numPagine;
		this.anno = anno;
		this.posizione = posizione;
		this.titolo = titolo;
		this.genere = genere;
		this.autore = autore;
		this.isbn = isbn;
		this.casaEditrice = casaEditrice;
	}

	public Libri() {
		this.numPagine = 0;
		this.anno = 0;
		this.posizione = 0;
		this.titolo = "";
		this.genere = "";
		this.autore = "";
		this.isbn = "";
		this.casaEditrice = "";
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public int getNumPagine() {
		return numPagine;
	}

	public void setNumPagine(int numPagine) {
		this.numPagine = numPagine;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getPosizione() {
		return posizione;
	}

	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCasaEditrice() {
		return casaEditrice;
	}

	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

}
