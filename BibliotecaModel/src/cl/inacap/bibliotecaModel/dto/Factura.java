package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

/**
 * Clase encargada de manipular la entidad Factura. Contiene 4 Atributos de
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
