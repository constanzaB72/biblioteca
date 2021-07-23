package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Boleta;

import cl.inacap.bibliotecaModel.dto.DetalleBoleta;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion y creacion de la clase y entidad
 * DetallesBoletas. Implementa la clase DB la cual permite la conexion directa
 * hacia la base de datos. Se relaciona con la Clase Boleta, Facturas .
 * 
 * CREADA EL DIA 1-07-2021
 * 
 * @author Camilo Moya
 * 
 */
public class DetallesBoletasDAO {
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
	public static List<String> erroresDetallesBoletaDAO = new ArrayList<String>();

	/**
	 * Metodo que se encarga de traer todos los detalles de boletas correspondientes
	 * a la tabla DetalleBoletas. El metodo realiza la consulta, con las tuplas
	 * resultantes las recorremos mediante un loop While, dentro del cual creamos
	 * una clase DetalleBoleta y le asignamos a sus atributos de clase los valores
	 * extraidos desde la query a la base de datos. Luego de asignar sus valores
	 * añadimos ese objeto DetalleBoleta a la lista de Tipo DetalleBoleta la cual
	 * será retornada al finalizar el Metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo de DatalleBoleta
	 * @exception Agrega el error a la lista erroresDetallesBoletasDAO
	 */
	public List<DetalleBoleta> getAll() {
		try {

			List<DetalleBoleta> detalles = new ArrayList<DetalleBoleta>();
			db.conectar();

			String query = "SELECT Folio,NumSerie,PrecioLibroNeto,CantidadLibros,PrecioLibroIVA,IVA FROM BibliotecaV2.DetalleBoletas";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleBoleta d = new DetalleBoleta();
				d.setFolio(rs.getInt(1));
				d.setNumSerie(rs.getInt(2));
				d.setPrecioLibroNeto(rs.getInt(3));
				d.setCantidadLibro(rs.getInt(4));
				d.setPrecioLibroIva(rs.getInt(5));
				d.setIva(rs.getInt(6));

				// Guardamos en la lista
				detalles.add(d);
			}

			rs.close();
			return detalles;

		} catch (Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que recibe 1 parametro, una Clase Boleta. El metodo es simple, busca
	 * todos los detalles que esten asociados a la Boleta recibida. Lo hace mediante
	 * un consulta SQL a la tabla DetalleBoletas con la sentencia WHERE Folio =
	 * boleta.getFolio(). Luego las tuplas resultantes se recorren con la ayuda de
	 * un loop While, en donde creamos una clase DetalleBoleta y le vamos asignando
	 * los valores de las tuplas a sus atributos de Clase. Para luego agregar ese
	 * DetalleBoleta a la Lista de tipo DetalleBoleta que será retornada al
	 * finalizar el metodo.
	 * 
	 * @author Camilo Moya
	 * @param boleta
	 * @return Lista de Tipo DetalleBoleta
	 * @exception Agrega el error a la lista erroresDetallesBoletasDAO
	 */
	public List<DetalleBoleta> getDetalles(Boleta boleta) {
		try {
			List<DetalleBoleta> detalles = new ArrayList<DetalleBoleta>();
			db.conectar();

			String query = "SELECT Folio,NumSerie,PrecioLibroNeto,CantidadLibros,PrecioLibroIVA,IVA FROM BibliotecaV2.DetalleBoletas WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, boleta.getFolio());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleBoleta d = new DetalleBoleta();
				d.setFolio(rs.getInt(1));
				d.setNumSerie(rs.getInt(2));
				d.setPrecioLibroNeto(rs.getInt(3));
				d.setCantidadLibro(rs.getInt(4));
				d.setPrecioLibroIva(rs.getInt(5));
				d.setIva(rs.getInt(6));

				// GUARDAMOS EN LA LISTA
				detalles.add(d);
			}

			rs.close();
			return detalles;
		} catch (Exception ex) {
			System.out.println("Se produjo un error al Consultar!");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * 
	 * Metodo que recibe 3 parametros, un Objeto Boleta y 2 listas, de Libros y
	 * Ejemplares. Primero realiza una consulta sobre el NumSerie de la tabla
	 * DetallesBoletas, ya que no se permite vender mas de 1 vez, 1 solo libro. Y
	 * luego se recorre ese resultado con un loop while, dentro de el se recorre
	 * primero la lista de Ejemplares, si se cumple que el NumSerie de ejemplar no
	 * está registrado en la tabla, se comienza a recorrer la lista de Libros, si
	 * sus ISBN coinciden , entonces , comenzará el calculo de IVA , para finalmente
	 * realizar la insercion de todos los datos extraidos en la tabla
	 * DetalleBoletas. Finalizando con un mensaje en la consola confirmando la
	 * insercion de cada detalle.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param ejemplares
	 * @param libros
	 * @param boleta
	 * @exception Agrega el error a la lista erroresDetallesBoletasDAO
	 */
	public void insertDetalles(List<Ejemplar> ejemplares, List<Libro> libros, Boleta boleta) {
		try {
			db.conectar();

//			String query1 = "SELECT NumSerie FROM BibliotecaV2.DetalleBoletas";
//			PreparedStatement s = db.getCon().prepareStatement(query1);
//
//			ResultSet rs = s.executeQuery();
//
//			while (rs.next()) {
				for (Ejemplar ejemplar : ejemplares) {
					//if (ejemplar.getNumSerie() != rs.getInt(1)) {
						for (Libro libro : libros) {
							if (ejemplar.getIsbn().equalsIgnoreCase(libro.getIsbn())) {
								int costoIva = (libro.getPrecio()) + (int) (libro.getPrecio() * 0.19);
								int iva = (int) (libro.getPrecio() * 0.19);

								String query = "INSERT INTO DetalleBoletas(Folio, NumSerie, PrecioLibroNeto, CantidadLibros, PrecioLibroIVA, IVA) VALUES(?,?,?,?,?,?)";
								PreparedStatement st = db.getCon().prepareStatement(query);
								st.setInt(1, boleta.getFolio());
								st.setInt(2, ejemplar.getNumSerie());
								st.setInt(3, libro.getPrecio());
								st.setInt(4, 1);
								st.setInt(5, costoIva);
								st.setInt(6, iva);

								st.executeUpdate();

								System.out.println("Detalle Ingresado con Exito!");
							}
						}
					//}
				}
			//}

		} catch (Exception ex) {
			erroresDetallesBoletaDAO.add("Se Produjo un Error al ingresar los detalles");
		} finally {
			db.desconectar();
		}
	}

}
