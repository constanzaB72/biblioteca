package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

public class Venta {

	private int idVenta;
	private int idCliente;
	private int idTrabajador;
	private int folio;
	
	private ArrayList<DetalleVenta> detalleVenta;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public ArrayList<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}

	public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idCliente=" + idCliente + ", idTrabajador=" + idTrabajador + ", folio="
				+ folio + ", detalleVenta=" + detalleVenta + "]";
	}
	
}
