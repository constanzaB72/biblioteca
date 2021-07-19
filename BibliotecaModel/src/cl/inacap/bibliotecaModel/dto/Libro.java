package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

/**
 * Clase encargada de manipular la entidad Libro. Contiene 9 Atributos de Clase,
 * cada uno de estos coinciden con su entidad existente en la base de datos,
 * para que al momento de instanciar la clase cumpla con todos sus atributos.
 * Sus Atributos se entienden a simple vista por sus nombre sumamente
 * descriptivos.Cuenta con 3 listas de Arreglos, para poder asignarle a las
 * clase variedad de autores, categorias o idiomas. Ademas cuenta con sus
 * Getters and Setters para poder obtener e instanciar sus Atributos. Ademas
 * cuenta con un Metodo ToString que nos devuelve sus Atributos instanciados.
 * 
 * CREADO EL DIA 25-06-2021
 * 
 * @author Constanza Benavides
 *
 */
public class Libro {

	private String isbn;
	private String titulo;
	private int numPagina;
	private int precio;
	private int anioPublicacion;
	private String editorial;
	private ArrayList<String> autores;
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

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
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
				+ ", anioPublicacion=" + anioPublicacion + ", editorial=" + editorial + ", autores=" + autores
				+ ", categorias=" + categorias + ", idiomas=" + idiomas + "]";
	}

}
