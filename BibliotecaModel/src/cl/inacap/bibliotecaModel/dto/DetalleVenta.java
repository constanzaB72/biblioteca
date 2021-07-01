package cl.inacap.bibliotecaModel.dto;

public class DetalleVenta {

	private int idDetalleVenta;
	private String isbn;
	private int idVenta;
	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}
	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	@Override
	public String toString() {
		return "DetalleVenta [idDetalleVenta=" + idDetalleVenta + ", isbn=" + isbn + ", idVenta=" + idVenta + "]";
	}
	
	
	
}
