package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

public class Libro {

	private String isbn;
	private String titulo;
	private int numPagina;
	private int precio;
	private int anioPublicacion;
	private String estado;
	private String editorial;
	private ArrayList<Autor> autores;
	private ArrayList<String> categorias;
	private ArrayList<String> idiomas;
	
	
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
	public int getNumPagina() {
		return numPagina;
	}
	public void setNumPagina(int numPagina) {
		this.numPagina = numPagina;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	public ArrayList<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<String> categorias) {
		this.categorias = categorias;
	}
	public ArrayList<String> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(ArrayList<String> idiomas) {
		this.idiomas = idiomas;
	}
	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", numPagina=" + numPagina + ", precio=" + precio
				+ ", anioPublicacion=" + anioPublicacion + ", estado=" + estado + ", idiomas=" + idiomas + "]";
	}
	
}
