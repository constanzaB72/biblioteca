package cl.inacap.bibliotecaModel.dto;

/**
 * Clase encargada de manipular la entidad Autor. Contiene 4 Atributos de Clase,
 * cada uno de estos coinciden con su entidad existente en la base de datos,
 * para que al momento de instanciar la clase cumpla con todos sus atributos.
 * Sus Atributos se entienden a simple vista por sus nombre sumamente
 * descriptivos. Cuenta con sus Getters and Setters para poder obtener e
 * instanciar sus Atributos. Ademas cuenta con un Metodo ToString que nos
 * devuelve sus Atributos instanciados.
 * 
 * CREADO EL DIA 25-06-2021
 * 
 * 
 * @author Constanza Benavides
 *
 */
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
