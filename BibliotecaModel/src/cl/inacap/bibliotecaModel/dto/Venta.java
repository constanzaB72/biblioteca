package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

/**
 * Clase encargada de manipular la entidad Venta. Contiene 4 Atributos de Clase,
 * cada uno de estos coinciden con su entidad existente en la base de datos,
 * para que al momento de instanciar la clase cumpla con todos sus atributos.
 * Sus Atributos se entienden a simple vista por sus nombre sumamente
 * descriptivos. Cuenta con sus Getters and Setters para poder obtener e
 * instanciar sus Atributos. Ademas cuenta con un Metodo ToString que nos
 * devuelve sus Atributos instanciados.
 * 
 * CREADO EL DIA 25-06-2021
 * 
 * @author Constanza Benavides
 *
 */
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
