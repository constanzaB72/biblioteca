package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

public class Factura {

	private int folio;
	private String fechaCompra;
	private String horaCompra;
	private String metodoPago;
	
	private ArrayList<DetalleFactura> detalleFactura;
	
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public String getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(String horaCompra) {
		this.horaCompra = horaCompra;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	public ArrayList<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}
	public void setDetalleFactura(ArrayList<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}
	@Override
	public String toString() {
		return "Factura [folio=" + folio + ", fechaCompra=" + fechaCompra + ", horaCompra=" + horaCompra
				+ ", metodoPago=" + metodoPago + "]";
	}
	
}
