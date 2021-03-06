package cl.inacap.bibliotecaModel.dto;

/**
 * Clase encargada de manipular la entidad DetalleCompra. Contiene 7 Atributos
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
public class DetalleCompra {

	private int idDetalleCompra;
	private String libroComprado;
	private int cantidadLibro;
	private int idCompra;
	private int idDistribuidor;
	private int numSerie;
	private int folio;

	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
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

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	@Override
	public String toString() {
		return "DetalleCompra [idDetalleCompra=" + idDetalleCompra + ", libroComprado=" + libroComprado
				+ ", cantidadLibro=" + cantidadLibro + ", idCompra=" + idCompra + ", idDistribuidor=" + idDistribuidor
				+ ", NumSerie=" + numSerie + ", Folio " + folio + "]";
	}

}
