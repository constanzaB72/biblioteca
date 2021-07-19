package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

/**
 * Clase encargada de manipular la entidad Compra. Contiene 3 Atributos de
 * Clase, cada uno de estos coinciden con su entidad existente en la base de
 * datos, para que al momento de instanciar la clase cumpla con todos sus
 * atributos. Sus Atributos se entienden a simple vista por sus nombre sumamente
 * descriptivos. En cuanto a el idDistribuidor, es un parametro extraido desde
 * otra clase o metodo. Cuenta con sus Getters and Setters para poder obtener e
 * instanciar sus Atributos. Ademas cuenta con un Metodo ToString que nos
 * devuelve sus Atributos instanciados.
 * 
 * CREADO EL DIA 25-06-2021
 * 
 * @author Constanza Benavides
 *
 */
public class Compra {

	private int idCompra;
	private int idDistribuidor;
	private int folio;

	private ArrayList<DetalleCompra> detalleCompra;

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdDistribuidor() {
		return idDistribuidor;
	}

	public void setIdDistribuidor(int idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", idDistribuidor=" + idDistribuidor + ", folio=" + folio + "]";
	}

	public ArrayList<DetalleCompra> getDetalleCompra() {
		return detalleCompra;
	}

	public void setDetalleCompra(ArrayList<DetalleCompra> detalleCompra) {
		this.detalleCompra = detalleCompra;
	}

}
