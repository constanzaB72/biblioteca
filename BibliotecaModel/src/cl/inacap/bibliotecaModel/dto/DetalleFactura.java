package cl.inacap.bibliotecaModel.dto;

public class DetalleFactura {

	private int detalleFactura;
	private int precioLibroNeto;
	private int precioLibroIva;
	private int iva;
	private int cantidadLibro;
	private Factura factura;
	private Ejemplar ejemplar;
	private Distribuidor distribuidor;
	
	
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	public Distribuidor getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}
	public int getDetalleFactura() {
		return detalleFactura;
	}
	public void setDetalleFactura(int detalleFactura) {
		this.detalleFactura = detalleFactura;
	}
	public int getPrecioLibroNeto() {
		return precioLibroNeto;
	}
	public void setPrecioLibroNeto(int precioLibroNeto) {
		this.precioLibroNeto = precioLibroNeto;
	}
	public int getPrecioLibroIva() {
		return precioLibroIva;
	}
	public void setPrecioLibroIva(int precioLibroIva) {
		this.precioLibroIva = precioLibroIva;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public int getCantidadLibro() {
		return cantidadLibro;
	}
	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}
	
}
