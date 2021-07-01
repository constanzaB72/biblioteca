package cl.inacap.bibliotecaModel.dto;

public class Ejemplar {

	private int numSerie;
	private String isbn;
	private String titulo;
	
	
	public int getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "Ejemplar [numSerie=" + numSerie + ", isbn=" + isbn + " Titulo = " + titulo +  "]";
	}
	
	
}
