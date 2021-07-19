package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

/**
 * Clase encargada de manipular la entidad Trabajador. Contiene 10 Atributos de
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
public class Trabajador {

	private int idTrabajador;
	private String rut;
	private String nombre;
	private String apellidoPa;
	private String apellidoMa;
	private String fechaContrato;
	private ArrayList<String> telefonos;
	private ArrayList<String> direcciones;
	private ArrayList<String> correos;
	private String Password;

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

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

	public String getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	@Override
	public String toString() {
		return "Trabajador [idTrabajador=" + idTrabajador + ", rut=" + rut + ", nombre=" + nombre + ", apellidoPa="
				+ apellidoPa + ", apellidoMa=" + apellidoMa + ", fechaContrato=" + fechaContrato + ", telefonos="
				+ telefonos + ", direcciones=" + direcciones + ", correos=" + correos + ", Password=" + Password + "]";
	}

}
