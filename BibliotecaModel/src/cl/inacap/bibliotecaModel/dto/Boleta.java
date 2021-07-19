package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

/**
 * Clase encargada de manipular la entidad Boleta. Contiene 6 Atributos de
 * Clase, cada uno de estos coinciden con su entidad existente en la base de
 * datos, para que al momento de instanciar la clase cumpla con todos sus
 * atributos. Sus Atributos se entienden a simple vista por sus nombre sumamente
 * descriptivos. En cuanto a el idCliente y idTrabajador , son parametros
 * extraidos desde otra clase o metodo. Cuenta con sus Getters and Setters para
 * poder obtener e instanciar sus Atributos. Ademas cuenta con un Metodo
 * ToString que nos devuelve sus Atributos instanciados.
 * 
 * CREADO EL DIA 25-06-2021
 * 
 * @author Constanza Benavides
 *
 */
public class Boleta {

	private int folio;
	private String fechaVenta;
	private String horaVenta;
	private String metodoPago;
	private int idCliente;
	private int idTrabajador;

	private ArrayList<DetalleBoleta> detalleBoletas;

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
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

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
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

	public ArrayList<DetalleBoleta> getDetalleBoletas() {
		return detalleBoletas;
	}

	public void setDetalleBoletas(ArrayList<DetalleBoleta> detalleBoletas) {
		this.detalleBoletas = detalleBoletas;
	}

	@Override
	public String toString() {
		return "Boleta [folio=" + folio + ", fechaVenta=" + fechaVenta + ", horaVenta=" + horaVenta + ", metodoPago="
				+ metodoPago + ", idCliente=" + idCliente + ", idTrabajador=" + idTrabajador + "]";
	}

}
