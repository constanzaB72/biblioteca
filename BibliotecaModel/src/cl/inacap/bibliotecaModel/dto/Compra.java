package cl.inacap.bibliotecaModel.dto;

import java.util.ArrayList;

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
	
	
}
