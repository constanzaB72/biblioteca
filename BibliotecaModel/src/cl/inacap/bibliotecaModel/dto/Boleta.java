package cl.inacap.bibliotecaModel.dto;

import java.util.Date;

public class Boleta {
 
	private int folio;
	private Date fechaVenta;
	private String horaVenta;
	private String metodoPago;
	private Cliente cliente;
	private Trabajador trabajador;
	
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
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getHoraVenta() {
		return horaVenta;
	}
	public void setHoraVenta(String horaVenta) {
		this.horaVenta = horaVenta;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	
}
