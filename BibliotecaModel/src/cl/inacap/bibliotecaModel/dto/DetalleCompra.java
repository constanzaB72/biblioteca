package cl.inacap.bibliotecaModel.dto;

public class DetalleCompra {

	private int detalleCompra;
	private String libroComprado;
	private int cantidadLibro;
	private Compra compra;
	private Distribuidor distribuidor;
	private Ejemplar ejemplar;
	private Boleta boleta;
	
	public int getDetalleCompra() {
		return detalleCompra;
	}
	public void setDetalleCompra(int detalleCompra) {
		this.detalleCompra = detalleCompra;
	}
	public String getLibroComprado() {
		return libroComprado;
	}
	public void setLibroComprado(String libroComprado) {
		this.libroComprado = libroComprado;
	}
	public int getCantidadLibro() {
		return cantidadLibro;
	}
	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	public Boleta getBoleta() {
		return boleta;
	}
	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	
}
