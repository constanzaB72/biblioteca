package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.DetalleArriendo;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion, creacion y eliminacion de la clase y
 * entidad DetallesArriendo. Implementa la clase DB la cual permite la conexion
 * directa hacia la base de datos. Se relaciona con la Clase Arriendo, y la
 * Clase DAO DetallesArriendosDAO.
 * 
 * CREADA EL DIA 30-06-2021
 * 
 * @author Camilo Moya
 * 
 */
public class DetallesArriendosDAO {
	/**
	 * Clase que nos permite una conexion directa hacia la base de datos
	 */
	private DB db = new DB();
	/**
	 * Lista static de String o Cadena que nos permite guardar los errores que
	 * posiblemente se produzcan al ocurrir un fallo en cualquiera de los metodos.
	 * Esta lista sera propagada luego en el Main, para exponer los errores
	 * ocurridos en pantalla.
	 */
	public static List<String> erroresDetallesArriendo = new ArrayList<String>();

	/**
	 * Metodo que realiza una consulta directa a la base de datos a la tabla
	 * DetalleArriendo, la cual trae todas la tuplas resultantes, las cuales son
	 * recorridas con un loop While, generando la Clase DetalleArriendo y añadiendo
	 * sus atributos de clase con los datos resultantes de la consulta a la base de
	 * datos, luego de crear la Clase DetalleArriendo se procede a añadir la clase a
	 * la lista de Tipo DetalleArriendo para posteriormente ser retornada al
	 * finalizar el metodo.
	 * 
	 * @return Lista de Tipo DetalleArriendo
	 * @exception Agrega el error a la lista erroresDetallesArriendo
	 */
	public List<DetalleArriendo> getAll() {
		try {

			List<DetalleArriendo> detalles = new ArrayList<DetalleArriendo>();
			db.conectar();

			String query = "SELECT NumSerie,idArriendo,CostoLibro FROM BibliotecaV2.DetalleArriendos";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleArriendo d = new DetalleArriendo();
				d.setNumSerie(rs.getInt(1));
				d.setIdDetalleArriendo(rs.getInt(2));
				d.setCostoLibro(rs.getInt(3));

				// Guardamos en la lista
				detalles.add(d);
			}

			rs.close();
			return detalles;

		} catch (Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al Consultar los Detalles");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Se encarga de buscar todos los detalles de un Arriendo, a travez de su Id.
	 * 
	 * Metodo que recibe 1 parametro, una Clase Arriendo, está encargado de realizar
	 * una consulta especifica a la base de datos en la tabla DetalleArriendos, esta
	 * consulta debe cumplir con la sentencia WHERE id Arriendo =
	 * arriendo.getIdArriendo(). Luego se recorren las tuplas resultantes para ser
	 * añadidas a la clase DetalleArriendo y ademas a la Lista de tipo
	 * DetalleArriendo. Finalmente una vez terminado el loop, se retorna la lista de
	 * tipo DetalleArriendo.
	 * 
	 * @author Camilo Moya
	 * @param arriendo
	 * @return Lista de tipo DetalleArriendo
	 * @exception Agrega el error a la lista erroresDetallesArriendo
	 */
	public List<DetalleArriendo> getDetalles(Arriendo arriendo) {
		try {
			List<DetalleArriendo> detalles = new ArrayList<DetalleArriendo>();
			db.conectar();

			String query = "SELECT NumSerie,CostoLibro FROM BibliotecaV2.DetalleArriendos WHERE idArriendo=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleArriendo d = new DetalleArriendo();
				d.setNumSerie(rs.getInt(1));
				d.setCostoLibro(rs.getInt(2));

				// GUARDAMOS EN LA LISTA
				detalles.add(d);
			}

			rs.close();
			return detalles;
		} catch (Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al consultar por el detalle del arriendo!");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que recibe 2 parametros, un arriendo un arriendoDAO. Nos retorna un
	 * int correspondiendte a la variable CostoTotal. El metodo realiza una consulta
	 * sobre el CostoLibro de la tabla DetallesArriendo en donde se cumpla la
	 * sentencia WHERE idArriendo = arriendo.getIdArriendo() Al recibir las tuplas
	 * resultante se recorren en un loop while y se va guardando el monto en la
	 * variable costoTotal. Finalmente se retorna el costoTotal + la Multa Extraida
	 * del metodo de ArriendoDAO recibido.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param arriendo
	 * @param arriendoDAO
	 * @return costoTotal + Multa del metodo extraido de ArriendoDAO
	 * @exception Agrega el error a la lista erroresDetallesArriendo
	 */
	public int getCostoTotal(Arriendo arriendo, ArriendosDAO arriendoDAO) {
		try {

			db.conectar();

			int costoTotal = 0;

			String query = "SELECT CostoLibro FROM BibliotecaV2.DetalleArriendos WHERE idArriendo=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				costoTotal += rs.getInt(1);
			}

			rs.close();
			return costoTotal + arriendoDAO.getMulta(arriendo);
		} catch (Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al consultar por el detalle del arriendo!");
			return arriendo.getCostoTotal();
		} finally {
			db.desconectar();
		}
	}

	/**
	 * 
	 * Metodo void que recibe 3 parametros, una clase arriendo y 2 listas, de libros
	 * y ejemplares. El metodo es simple, se encarga de ingresar a la tabla
	 * DetallesArriendos todos los detalles correspondientes a 1 arriendo. Recorres
	 * las 2 listas primero la de ejemplares y luego la de libros con la ayuda de un
	 * Loop For, luego mediante una sentencia IF preguntamos si el ISBN de Ejemplar
	 * y Libro son iguales, se realiza la insercion a la base de datos del
	 * DetalleArriendo con los datos tanto de libros como de ejemplar y Arriendo.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param arriendo
	 * @param libros
	 * @param ejemplares
	 * @exception Agrega el error a la lista erroresDetallesArriendo
	 */
	public void insertDetalleArriendo(Arriendo arriendo, List<Libro> libros, List<Ejemplar> ejemplares) {
		try {
			db.conectar();
			for (Ejemplar ejemplar : ejemplares) {
				System.out.println(ejemplar);
				for (Libro libro1 : libros) {
					System.out.println(libro1);
					if (ejemplar.getIsbn().equals(libro1.getIsbn())) {
						String query = "INSERT INTO DetalleArriendos(NumSerie,idArriendo,CostoLibro) VALUES(?,?,?)";
						PreparedStatement st = db.getCon().prepareStatement(query);
						st.setInt(1, ejemplar.getNumSerie());
						st.setInt(2, arriendo.getIdArriendo());
						st.setInt(3, libro1.getPrecio());

						st.executeUpdate();

						System.out.println("Detalle ingresado con EXITO!!");
					}
				}
			}
			System.out.println("Finalizo!");

		} catch (Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al ingresar el detalle!");
			System.out.println(ex);
		} finally {
			db.desconectar();
		}
	}

}
