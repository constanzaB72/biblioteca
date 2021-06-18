package cl.inacap.bibliotecaModel.dto;

public class DetalleArriendo {

	private int idDetalleArriendo;
	private int costoLibro;
	private Ejemplar ejemplar;
	
	public int getIdDetalleArriendo() {
		return idDetalleArriendo;
	}
	public void setIdDetalleArriendo(int idDetalleArriendo) {
		this.idDetalleArriendo = idDetalleArriendo;
	}
	public int getCostoLibro() {
		return costoLibro;
	}
	public void setCostoLibro(int costoLibro) {
		this.costoLibro = costoLibro;
	}
	public Ejemplar getEjemplar() {
		return ejemplar;
	}
	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}
	
}
