package cl.inacap.bibliotecaModel.dto;

public class DetalleArriendo {

	private int idDetalleArriendo;
	private int costoLibro;
	private int NumSerie;
	
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
	
	public int getNumSerie() {
		return NumSerie;
	}
	public void setNumSerie(int numSerie) {
		NumSerie = numSerie;
	}
	@Override
	public String toString() {
		return "DetalleArriendo [idDetalleArriendo=" + idDetalleArriendo + ", costoLibro=" + costoLibro + ", NumSerie="
				+ NumSerie + "]";
	}
	
	
	
	
}
