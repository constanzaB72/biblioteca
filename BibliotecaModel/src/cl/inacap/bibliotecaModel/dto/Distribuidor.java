package cl.inacap.bibliotecaModel.dto;

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
	
}
