package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;
import java.util.Date;

public class Arriendo {

	private int idArriendo;
	private Date fechaArriendo;
	private Date fechaDevolucion;
	private Date fechaEntrega;
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
	public Date getFechaArriendo() {
		return fechaArriendo;
	}
	public void setFechaArriendo(Date fechaArriendo) {
		this.fechaArriendo = fechaArriendo;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
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
