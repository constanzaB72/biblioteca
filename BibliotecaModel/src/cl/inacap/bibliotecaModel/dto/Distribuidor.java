package cl.inacap.bibliotecaModel.dto;

/**
 * Clase encargada de manipular la entidad Distribuidor. Contiene 6 Atributos de
 * Clase, cada uno de estos coinciden con su entidad existente en la base de
 * datos, para que al momento de instanciar la clase cumpla con todos sus
 * atributos. Sus Atributos se entienden a simple vista por sus nombre sumamente
 * descriptivos. Cuenta con sus Getters and Setters para poder obtener e
 * instanciar sus Atributos. Ademas cuenta con un Metodo ToString que nos
 * devuelve sus Atributos instanciados.
 * 
 * CREADO EL DIA 25-06-2021
 * 
 * @author Constanza Benavides
 *
 */
public class Distribuidor {

	private int idDistribuidor;
	private String rut;
	private String nombreEmpresa;
	private int anioVinculo;
	private String direccion;
	private String telefono;

	public int getIdDistribuidor() {
		return idDistribuidor;
	}

	public void setIdDistribuidor(int idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public int getAnioVinculo() {
		return anioVinculo;
	}

	public void setAnioVinculo(int anioVinculo) {
		this.anioVinculo = anioVinculo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Distribuidor [idDistribuidor=" + idDistribuidor + ", rut=" + rut + ", nombreEmpresa=" + nombreEmpresa
				+ ", anioVinculo=" + anioVinculo + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

}
