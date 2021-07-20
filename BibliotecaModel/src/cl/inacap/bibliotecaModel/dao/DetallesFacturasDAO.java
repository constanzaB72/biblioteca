package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.DetalleFactura;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion y creacion de la clase y entidad
 * DetallesFacturas. Implementa la clase DB la cual permite la conexion directa
 * hacia la base de datos. Se relaciona con la Clase Factura, Distribudor.
 * 
 * CREADA EL DIA 4-07-2021
 * 
 * @author Camilo Moya
 * 
 */
public class DetallesFacturasDAO {
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
	public static List<String> erroresDetallesFacturasDAO = new ArrayList<String>();

	/**
	 * Metodo que se encarga de traer todos los detalles de compra correspondientes
	 * a la tabla DetalleFacturas. El metodo realiza la consulta, con las tuplas
	 * resultantes las recorremos mediante un loop While, dentro del cual creamos
	 * una clase DetalleFactura y le asignamos a sus atributos de clase los valores
	 * extraidos desde la query a la base de datos. Luego de asignar sus valores
	 * añadimos ese objeto DetalleFactura a la lista de Tipo DetalleFactura la cual
	 * será retornada al finalizar el Metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo DetalleFatura
	 * @exception Agrega el error a la lista erroresDetallesFacturasDAO
	 */
	public List<DetalleFactura> getAll() {

		try {

			List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
			db.conectar();

			String query = "SELECT idDetalleFactura, Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros FROM BibliotecaV2.DetalleFacturas";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleFactura d = new DetalleFactura();
				d.setIdDetalleFactura(rs.getInt(1));
				d.setFolio(rs.getInt(2));
				d.setNumSerie(rs.getInt(3));
				d.setIdDistribuidor(rs.getInt(4));
				d.setPrecioLibroNeto(rs.getInt(5));
				d.setPrecioLibroIva(rs.getInt(6));
				d.setIva(rs.getInt(7));
				d.setCantidadLibro(rs.getInt(8));

				// Guardamos en la lista

				detalles.add(d);

			}

			rs.close();
			return detalles;

		} catch (Exception ex) {
			erroresDetallesFacturasDAO.add("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}

	}

	/**
	 * Metodo que recibe 1 parametro, una Clase Factura. El metodo es simple, busca
	 * todos los detalles que esten asociados a la Factura recibida. Lo hace
	 * mediante un consulta SQL a la tabla DetalleFacturas con la sentencia WHERE
	 * Folio = factura.getFolio(). Luego las tuplas resultantes se recorren con la
	 * ayuda de un loop While, en donde creamos una clase DetalleFactura y le vamos
	 * asignando los valores de las tuplas a sus atributos de Clase. Para luego
	 * agregar ese DetalleFactura a la Lista de tipo DetalleFactura que será
	 * retornada al finalizar el metodo.
	 * 
	 * @author Camilo Moya
	 * @param factura
	 * @return Lista de Tipo DetalleFatura
	 * @exception Agrega el error a la lista erroresDetallesFacturasDAO
	 */
	public List<DetalleFactura> getDetalles(Factura factura) {
		try {
			List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
			db.conectar();

			String query = "SELECT idDetalleFactura, Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros  FROM BibliotecaV2.DetalleFacturas WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleFactura d = new DetalleFactura();
				d.setIdDetalleFactura(rs.getInt(1));
				d.setFolio(rs.getInt(2));
				d.setNumSerie(rs.getInt(3));
				d.setIdDistribuidor(rs.getInt(4));
				d.setPrecioLibroNeto(rs.getInt(5));
				d.setPrecioLibroIva(rs.getInt(6));
				d.setIva(rs.getInt(7));
				d.setCantidadLibro(rs.getInt(8));

				// GUARDAMOS EN LA LISTA

				detalles.add(d);

			}

			rs.close();
			return detalles;
		} catch (Exception ex) {
			erroresDetallesFacturasDAO.add("Se produjo un error al Consultar!");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que recibe 3 parametros, un Objeto Boleta y 2 listas, de Libros y
	 * Ejemplares. Primero realiza una consulta sobre el NumSerie de la tabla
	 * DetallesFacturas, ya que no se permite vender mas de 1 vez, 1 solo libro. Y
	 * luego se recorre ese resultado con un loop while, dentro de el se recorre
	 * primero la lista de Ejemplares, si se cumple que el NumSerie de ejemplar no
	 * está registrado en la tabla, se comienza a recorrer la lista de Libros, si
	 * sus ISBN coinciden , entonces , comenzará el calculo de IVA , para finalmente
	 * realizar la insercion de todos los datos extraidos en la tabla
	 * DetalleFacturas. Finalizando con un mensaje en la consola confirmando la
	 * insercion de cada detalle.
	 * 
	 * @author Camilo Moya
	 * @param ejemplares
	 * @param libros
	 * @param factura
	 * @param distribuidor
	 * @exception Agrega el error a la lista erroresDetallesFacturasDAO
	 * 
	 */
	public void insertDetalleFactura(List<Ejemplar> ejemplares, List<Libro> libros, Factura factura,
			Distribuidor distribuidor) {
		try {
			db.conectar();
			//TODO hay que buscar otra forma de validar el num  de serie ya que esta al estar la tabla vacia
			//no entra a ciclo del insert
			/*
			 * String query1 = "SELECT NumSerie FROM BibliotecaV2.DetalleFacturas";
			 * PreparedStatement s = db.getCon().prepareStatement(query1);
			 * 
			 * ResultSet rs = s.executeQuery();
			 */

			//while (rs.next()) {
				for (Ejemplar ejemplar : ejemplares) {
					//if (ejemplar.getNumSerie() != rs.getInt(1)) {
						for (Libro libro : libros) {
							if (ejemplar.getIsbn() == libro.getIsbn()) {
								int costoIva = (libro.getPrecio()) + (int) (libro.getPrecio() * 0.19);
								int iva = (int) (libro.getPrecio() * 0.19);

								String query = "INSERT INTO DetalleFacturas(Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros) VALUES(?,?,?,?,?,?,?)";
								PreparedStatement st = db.getCon().prepareStatement(query);
								st.setInt(1, factura.getFolio());
								st.setInt(2, ejemplar.getNumSerie());
								st.setInt(3, distribuidor.getIdDistribuidor());
								st.setInt(4, libro.getPrecio());
								st.setInt(5, costoIva);
								st.setInt(6, iva);
								st.setInt(7, 1);

								st.executeUpdate();

								System.out.println("Detalle Ingresado con Exito!");
							}
						}
					//}
				}
			//}
		} catch (Exception ex) {
			erroresDetallesFacturasDAO.add("Error al Insertar los Detalles");
			System.out.println(ex);
		} finally {
			db.desconectar();
		}
	}

	/**
	 * 
	 * El metodo recibe una Factura a la cual se le extraen sus datos para realizar
	 * una actualizacion en la base de datos.
	 * 
	 * @author Camilo Moya
	 * @param factura
	 * @exception Agrega el error a la lista erroresDetallesFacturasDAO
	 */
	public void updateDetalleFactura(Factura factura) {
		try {
			db.conectar();
		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

}
