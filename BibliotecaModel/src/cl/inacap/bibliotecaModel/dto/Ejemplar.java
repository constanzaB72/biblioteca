package cl.inacap.bibliotecaModel.dto;

public class Ejemplar {

	private int numSerie;
	private Libro libro;
	
	public int getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
}
