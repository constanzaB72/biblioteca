package cl.inacap.bibliotecaModel.dto;

/**
 * Clase encargada de manipular la entidad DetalleFactura. Contiene 8 Atributos
 * de Clase, cada uno de estos coinciden con su entidad existente en la base de
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
public class DetalleFactura {

	private int idDetalleFactura;
	private int precioLibroNeto;
	private int precioLibroIva;
	private int numSerie;
	private int iva;
	private int cantidadLibro;
	private int folio;
	private int idDistribuidor;

	public int getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(int idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
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

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public int getCantidadLibro() {
		return cantidadLibro;
	}

	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public int getIdDistribuidor() {
		return idDistribuidor;
	}

	public void setIdDistribuidor(int idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	@Override
	public String toString() {
		return "DetalleFactura [idDetalleFactura=" + idDetalleFactura + ", precioLibroNeto=" + precioLibroNeto
				+ ", precioLibroIva=" + precioLibroIva + ", iva=" + iva + ", cantidadLibro=" + cantidadLibro
				+ ", folio=" + folio + ", idDistribuidor=" + idDistribuidor + "]";
	}

}
