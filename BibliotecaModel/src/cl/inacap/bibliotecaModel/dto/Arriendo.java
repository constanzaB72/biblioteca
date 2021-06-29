package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;
import java.util.Date;

public class Arriendo {

	private int idArriendo;
	private String fechaArriendo;
	private String fechaDevolucion;
	private String fechaEntrega;
	private int diasRetraso;
	private int multa;
	private int costoTotal;
	private Cliente cliente;
	private Trabajador trabajador;
	
	private ArrayList<DetalleArriendo> detalleArriendos;
	public int getIdArriendo() {
		return idArriendo;
	}
	public void setIdArriendo(int idArriendo) {
		this.idArriendo = idArriendo;
	}
	
	public String getFechaArriendo() {
		return fechaArriendo;
	}
	public void setFechaArriendo(String fechaArriendo) {
		this.fechaArriendo = fechaArriendo;
	}
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getDiasRetraso() {
		return diasRetraso;
	}
	public void setDiasRetraso(int diasRetraso) {
		this.diasRetraso = diasRetraso;
	}
	public int getMulta() {
		return multa;
	}
	public void setMulta(int multa) {
		this.multa = multa;
	}
	public int getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Trabajador getTrabajador() {
		return trabajador;
	}
	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	public ArrayList<DetalleArriendo> getDetalleArriendos() {
		return detalleArriendos;
	}
	public void setDetalleArriendos(ArrayList<DetalleArriendo> detalleArriendos) {
		this.detalleArriendos = detalleArriendos;
	}
	
	
}
