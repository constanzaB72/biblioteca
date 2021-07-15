package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Compra;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion, creacion, actualizacion y eliminacion
 * de la clase y entidad Compras. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase Compra,
 * DetallesCompras y Factura.
 * 
 * CREADA EL DIA 3-07-2021
 * 
 * @author Camilo Moya
 * 
 */
public class ComprasDAO {
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
	public static List<String> erroresComprasDAO = new ArrayList<String>();

	/**
	 * Metodo que realiza una consulta a la base de datos sobre los elementos de la
	 * tabla Compras. Al recibir las tuplas resultantes, se recorren con la ayuda de
	 * un loop While, en donde se crea la Clase Compra a la cual se le asignan los
	 * valores resultantes de la consulta a sus atributos de clase. Para luego ser
	 * agregada a la lista de tipo Compra que será retornada al finalizar el metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo Compra
	 * @exception Agrega el error a la lista erroresComprasDAO
	 */
	public List<Compra> getAll() {

		try {

			List<Compra> compras = new ArrayList<Compra>();
			db.conectar();

			String query = "SELECT idCompra,idDistribuidor,Folio FROM BibliotecaV2.Compras";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Compra c = new Compra();
				c.setIdCompra(rs.getInt(1));
				c.setIdDistribuidor(rs.getInt(2));
				c.setFolio(rs.getInt(3));

				// Guardamos en la lista
				compras.add(c);
			}

			rs.close();
			return compras;

		} catch (Exception ex) {
			erroresComprasDAO.add("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}

	}

	/**
	 * El Metodo void recibe 3 parametros, las clases Compra, Factura y
	 * Distribuidor, de la cuales se les extraeran algunos atributos para ser
	 * ingresadas a los valores de la tabla Compras. Al momento de completarse la
	 * insercion a la tabla Compras, se mostrará en consula un mensaje de
	 * confirmacion sobre la insercion.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param compra
	 * @param factura
	 * @param distribuidor
	 */
	public void insertCompra(Compra compra, Factura factura, Distribuidor distribuidor) {
		try {
			db.conectar();

			String query = "INSERT INTO Compras(idCompra, idDistribuidor, Folio) VALUES(?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, compra.getIdCompra());
			st.setInt(2, distribuidor.getIdDistribuidor());
			st.setInt(3, factura.getFolio());

			st.executeUpdate();

			System.out.println("Compra ingresada con Exito!");

		} catch (Exception ex) {
			erroresComprasDAO.add("Error al Ingresar la Compra!");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo void que recibe 1 parametro, la Clase Factura a la cual se le extraen
	 * sus atributos para ser modificados en la tabla Compras.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param factura
	 * @exception Agrega el error a la lista erroresComprasDAO
	 */
	public void updateCompra(Factura factura) {
		try {
			db.conectar();
		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que recibe 1 parametro, una Clase Factura de la cual extraerá su
	 * nomero de Folio, para realizar una eliminacion con una sentencia WHERE Folio
	 * = factura.getFolio(). Pero antes de realizar la eliminacion directa, debe
	 * eliminar cualquier elemento relacionado con el Folio en tablas externas. Por
	 * lo tanto realiza la eliminacion de los Detalles de la compra en la tabla
	 * DetalleCompras son la misma sentencia WHERE Folio = factura.getFolio(). Una
	 * vez eliminados todos los detalles asociados, se realiza la eliminacion de la
	 * compra directament a la tabla Compras, mostrando un mensaje en consola
	 * confirmando la eliminacion de la Compra.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param factura
	 * @exception Agrega el error a la lista erroresComprasDAO
	 */
	public void deleteCompra(Factura factura) {
		try {
			db.conectar();

			String query = "DELETE FROM DetalleCompras WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());

			st.executeUpdate();

			String query2 = "DELETE FROM Compras WHERE Folio=?";
			PreparedStatement s = db.getCon().prepareStatement(query2);
			s.setInt(1, factura.getFolio());

			s.executeUpdate();

			System.out.println("Compra Eliminada con Exito!");

		} catch (Exception ex) {
			erroresComprasDAO.add("Se Produjo un Error al Eliminar la Compra");
		} finally {
			db.desconectar();
		}
	}

}
