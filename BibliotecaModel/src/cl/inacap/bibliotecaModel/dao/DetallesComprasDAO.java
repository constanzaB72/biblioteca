/**
 * 
 */
package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Compra;
import cl.inacap.bibliotecaModel.dto.DetalleCompra;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion y creacion de la clase y entidad
 * DetallesCompras. Implementa la clase DB la cual permite la conexion directa
 * hacia la base de datos. Se relaciona con la Clase Compra, Distribudor.
 * 
 * CREADA EL DIA 3-07-2021
 * 
 * @author Camilo Moya
 * 
 */
public class DetallesComprasDAO {
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
	public static List<String> erroresDetallesCompras = new ArrayList<String>();

	/**
	 * Metodo que se encarga de traer todos los detalles de compra correspondientes
	 * a la tabla DetalleCompras. El metodo realiza la consulta, con las tuplas
	 * resultantes las recorremos mediante un loop While, dentro del cual creamos
	 * una clase DetalleCompra y le asignamos a sus atributos de clase los valores
	 * extraidos desde la query a la base de datos. Luego de asignar sus valores
	 * añadimos ese objeto DetalleCompra a la lista de Tipo DetalleCompra la cual
	 * será retornada al finalizar el Metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo DetalleCompra
	 * @exception Agrega el error a la lista erroresDetallesCompras
	 */
	public List<DetalleCompra> getAll() {
		try {

			List<DetalleCompra> detalles = new ArrayList<DetalleCompra>();
			db.conectar();

			String query = "SELECT Folio,NumSerie,idDistribuidor,LibroComprado,CantidadLibros FROM BibliotecaV2.DetalleCompras";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleCompra d = new DetalleCompra();
				d.setLibroComprado(rs.getString(4));
				d.setCantidadLibro(rs.getInt(5));

				// Guardamos en la lista
				detalles.add(d);
			}

			rs.close();
			return detalles;

		} catch (Exception ex) {
			erroresDetallesCompras.add("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que recibe 1 parametro, una Clase Compra. El metodo es simple, busca
	 * todos los detalles que esten asociados a la Compra recibida. Lo hace mediante
	 * un consulta SQL a la tabla DetalleCompras con la sentencia WHERE Folio =
	 * compra.getFolio(). Luego las tuplas resultantes se recorren con la ayuda de
	 * un loop While, en donde creamos una clase DetalleCompra y le vamos asignando
	 * los valores de las tuplas a sus atributos de Clase. Para luego agregar ese
	 * DetalleCompra a la Lista de tipo DetalleCompra que será retornada al
	 * finalizar el metodo.
	 * 
	 * @author Camilo Moya
	 * @param compra
	 * @return Lista de Tipo DetalleCompra
	 * @exception Agrega el error a la lista erroresDetallesCompras
	 */
	public List<DetalleCompra> getDetalles(Compra compra) {
		try {
			List<DetalleCompra> detalles = new ArrayList<DetalleCompra>();
			db.conectar();

			String query = "SELECT idDetalleCompra, idCompra, Folio, NumSerie, idDistribuidor, LibroComprado, CantidadLibros FROM BibliotecaV2.DetalleCompras  WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, compra.getFolio());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleCompra d = new DetalleCompra();
				d.setIdCompra(rs.getInt(1));
				d.setIdCompra(rs.getInt(2));
				d.setFolio(rs.getInt(3));
				d.setNumSerie(rs.getInt(4));
				d.setIdDistribuidor(rs.getInt(5));
				d.setLibroComprado(rs.getString(6));
				d.setCantidadLibro(rs.getInt(7));

				// GUARDAMOS EN LA LISTA

				detalles.add(d);

			}

			rs.close();
			return detalles;
		} catch (Exception ex) {
			erroresDetallesCompras.add("Se produjo un error al Consultar!");
			return null;
		} finally {
			db.desconectar();
		}

	}

	/**
	 * 
	 * Metodo que recibe 3 parametros, 1 lista de ejemplares, y 3 Clases ,
	 * Factura,COmpra,Distribuidor, de las cuales se le extraeran los datos para
	 * realizar la insercion a la tabla DetalleCompras. El metodo comienza
	 * recorriendo la lista de ejemplares, por cada ejemplar se realiza una
	 * insercion, a la tabla extrayendo el idCompra, el Folio, el numSerie, el
	 * idDistribuidor y el titulo del ejemplar. Finaliza cada insercion con un
	 * mensaje de confirmacion en consola.
	 * 
	 * @author Camilo Moya
	 * @param ejemplares
	 * @param factura
	 * @param compra
	 * @param distribuidor
	 * @exception Agrega el error a la lista erroresDetallesCompras
	 */
	public void insertDetalleCompra(List<Ejemplar> ejemplares, Factura factura, Compra compra,
			Distribuidor distribuidor) {
		try {
			db.conectar();

			for (Ejemplar ejemplar : ejemplares) {
				String query = "INSERT INTO DetalleCompras(idCompra, Folio, NumSerie, idDistribuidor, LibroComprado, CantidadLibros) VALUES(?,?,?,?,?,?)";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, compra.getIdCompra());
				st.setInt(2, factura.getFolio());
				st.setInt(3, ejemplar.getNumSerie());
				st.setInt(4, distribuidor.getIdDistribuidor());
				st.setString(5, ejemplar.getTitulo());
				st.setInt(6, 1);

				st.executeUpdate();

				System.out.println("Detalle Compra Ingresado con Exito!");
			}

		} catch (Exception ex) {
			erroresDetallesCompras.add("Se Produjo un error al ingresar el Detalle");
			System.out.println(ex);
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de la actulizacion de un detalle en especifico asociado a
	 * una Compra.
	 * 
	 * @author Camilo Moya
	 * @exception Agrega el error a la lista erroresDetallesCompras
	 */
	public void updateDetalleCompra() {
		try {
			db.conectar();
		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

}
