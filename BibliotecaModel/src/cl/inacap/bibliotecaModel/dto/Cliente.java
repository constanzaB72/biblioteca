package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

/**
 * Clase encargada de manipular la entidad Cliente. Contiene 10 Atributos de
 * Clase, cada uno de estos coinciden con su entidad existente en la base de
 * datos, para que al momento de instanciar la clase cumpla con todos sus
 * atributos. Sus Atributos se entienden a simple vista por sus nombre sumamente
 * descriptivos. Cuenta con 3 Listas de Arreglos de tipo String, estas cumplen
 * la funcion de almacer los multiples telefonos,correos o direcciones con las
 * que cuente la clase. Ademas cuenta con sus Getters and Setters para poder
 * obtener e instanciar sus Atributos. Ademas cuenta con un Metodo ToString que
 * nos devuelve sus Atributos instanciados.
 * 
 * CREADO EL DIA 25-06-2021
 * 
 * @author Constanza Benavides
 *
 */
public class Cliente {

	private int idCliente;
	private String rut;
	private String nombre;
	private String apellidoPa;
	private String apellidoMa;
	private String fechaNacimiento;
	private ArrayList<String> telefonos;
	private ArrayList<String> direcciones;
	private ArrayList<String> correos;
	private String Password;

	public ArrayList<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<String> telefonos) {
		this.telefonos = telefonos;
	}

	public ArrayList<String> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(ArrayList<String> direcciones) {
		this.direcciones = direcciones;
	}

	public ArrayList<String> getCorreos() {
		return correos;
	}

	public void setCorreos(ArrayList<String> correos) {
		this.correos = correos;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", rut=" + rut + ", nombre=" + nombre + ", apellidoPa=" + apellidoPa
				+ ", apellidoMa=" + apellidoMa + ", fechaNacimiento=" + fechaNacimiento + ", telefonos=" + telefonos
				+ ", direcciones=" + direcciones + ", correos=" + correos + "]";
	}

}
