package cl.inacap.bibliotecaModel.dto;

public class DetalleArriendo {

	private int idDetalleArriendo;
	private int costoLibro;
	private String isbn;
	
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
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "DetalleArriendo [idDetalleArriendo=" + idDetalleArriendo + ", costoLibro=" + costoLibro + ", isbn="
				+ isbn + "]";
	}
	
	
	
}
