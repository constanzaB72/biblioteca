package cl.inacap.bibliotecaModel.dto;

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

