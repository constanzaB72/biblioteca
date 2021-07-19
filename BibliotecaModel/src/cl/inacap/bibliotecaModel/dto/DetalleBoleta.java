package cl.inacap.bibliotecaModel.dto;

/**
 * Clase encargada de manipular la entidad DetalleBoleta. Contiene 7 Atributos
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
public class DetalleBoleta {

	private int idDetalleBoleta;
	private int folio;
	private int numSerie;
	private int precioLibroNeto;
	private int cantidadLibro;
	private int precioLibroIva;
	private int iva;

	public int getIdDetalleBoleta() {
		return idDetalleBoleta;
	}

	public void setIdDetalleBoleta(int idDetalleBoleta) {
		this.idDetalleBoleta = idDetalleBoleta;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public int getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}

	public int getPrecioLibroNeto() {
		return precioLibroNeto;
	}

	public void setPrecioLibroNeto(int precioLibroNeto) {
		this.precioLibroNeto = precioLibroNeto;
	}

	public int getCantidadLibro() {
		return cantidadLibro;
	}

	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
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

	@Override
	public String toString() {
		return "DetalleBoleta [idDetalleBoleta=" + idDetalleBoleta + ", folio=" + folio + ", numSerie=" + numSerie
				+ ", precioLibroNeto=" + precioLibroNeto + ", cantidadLibro=" + cantidadLibro + ", precioLibroIva="
				+ precioLibroIva + ", iva=" + iva + "]";
	}

}
