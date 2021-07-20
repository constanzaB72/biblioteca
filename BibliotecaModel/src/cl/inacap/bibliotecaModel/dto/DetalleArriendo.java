package cl.inacap.bibliotecaModel.dto;

/**
 * Clase encargada de manipular la entidad DetalleArriendo. Contiene 3 Atributos
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
