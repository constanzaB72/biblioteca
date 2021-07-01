package cl.inacap.bibliotecaModel.dto;

public class Autor {

	private int idAutor;
	private String nombre;
	private String apellidoPa;
	private String apellidoMa;
	
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPa() {
		return apellidoPa;
	}
	public void setApellidoPa(String apellidoPa) {
		this.apellidoPa = apellidoPa;
	}
	public String getApellidoMa() {
		return apellidoMa;
	}
	public void setApellidoMa(String apellidoMa) {
		this.apellidoMa = apellidoMa;
	}
	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", apellidoPa=" + apellidoPa + ", apellidoMa="
				+ apellidoMa + "]";
	}
	
}
