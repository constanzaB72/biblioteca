package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

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
