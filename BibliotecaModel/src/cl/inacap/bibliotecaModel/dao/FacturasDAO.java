package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion,creacion,actualizacion y eliminacion
 * de la clase y entidad Factura. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase Factura.
 * 
 * CREADA EL DIA 4-07-2021
 * 
 * 
 * @author Camilo Moya
 * 
 */
public class FacturasDAO {
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
	public static List<String> erroresFacturasDAO = new ArrayList<String>();

	/**
	 * Metodo que se encarga de traer todos las Facturas correspondientes a la tabla
	 * Facturas de la base de datos. El metodo realiza la consulta, con las tuplas
	 * resultantes las recorremos mediante un loop While, dentro del cual creamos
	 * una clase Factura y le asignamos a sus atributos de clase los valores
	 * extraidos desde la query a la base de datos. Luego de asignar sus valores
	 * añadimos ese objeto Factura a la lista de Tipo Factura la cual será retornada
	 * al finalizar el Metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo Factura
	 * @exception Agrega el error a la lista erroresFacturasDAO
	 */
	public List<Factura> getAll() {
		try {

			List<Factura> facturas = new ArrayList<Factura>();
			db.conectar();

			String query = "SELECT Folio,FechaCompra,HoraCompra,MetodoPago FROM BibliotecaV2.Facturas";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Factura f = new Factura();
				f.setFolio(rs.getInt(1));
				f.setFechaCompra(rs.getString(2));
				f.setHoraCompra(rs.getString(3));
				f.setMetodoPago(rs.getString(4));

				// Guardamos en la lista
				facturas.add(f);
			}

			rs.close();
			return facturas;

		} catch (Exception ex) {
			erroresFacturasDAO.add("Se Produjo un error al Consultar las Facturas");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de insertar una Factura a la tabla Facturas. El metodo
	 * recibe 1 Parametro, un objeto factura, del cual se extraen sus datos y se
	 * insertan mediante una query a la tabla Facturas en la base de datos.
	 * Mostrando al finalizar un mensaje en consola confirmando la accion.
	 * 
	 * @author Camilo Moya
	 * @param factura
	 * @exception Agrega el error a la lista erroresFacturasDAO
	 */
	public void insertFactura(Factura factura) {
		try {
			db.conectar();

			String query = "INSERT INTO Facturas(Folio,FechaCompra,HoraCompra,MetodoPago) VALUES(?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());
			st.setString(2, factura.getFechaCompra());
			st.setString(3, factura.getHoraCompra());
			st.setString(4, factura.getMetodoPago());

			st.executeUpdate();

			System.out.println("Factura Ingresada con Exito!");

		} catch (Exception ex) {
			erroresFacturasDAO.add("Se Produjo un error al ingresar la Factura");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de actualizar la Factura. El metodo recibe 1 parametro del
	 * que se extraen los datos para actualizarlos en la tabla Facturas.
	 * 
	 * @author Camilo Moya
	 * @param factura
	 * @exception Agrega el error a la lista erroresFacturasDAO
	 */
	public void updateFactura(Factura factura) {
		try {
			db.conectar();
		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

	/**
	 * 
	 * Metodo encargado de Eliminar la Factura y sus Detalles asociados de las
	 * tablas Facturas y DetallesFacturas. El metodo recibe 1 parametro, un objeto
	 * factura. La primera query de eliminacion se realiza en la tabla
	 * DetallesFacturas , con la ayuda de la sentencia WHERE Folio =
	 * factura.getFolio(). dentro de la query. Una vez eliminados todos los detalles
	 * enlazados, procedemos a eliminar la factura , realizando la query en base a
	 * su Folio. Una vez realizada la eliminacion, en consola aparecera un mensaje
	 * de confirmacion.
	 * 
	 * @param factura
	 */
	public void deleteFactura(Factura factura) {
		try {
			db.conectar();

			String query = "DELETE FROM DetalleFacturas WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());

			st.executeUpdate();

			String query2 = "DELETE FROM Facturas WHERE Folio=?";
			PreparedStatement s = db.getCon().prepareStatement(query2);
			s.setInt(1, factura.getFolio());

			s.executeUpdate();

			System.out.println("Factura Eliminada con Exito!");

		} catch (Exception ex) {
			erroresFacturasDAO.add("Se Produjo un error al Eliminar la Factura!");
		} finally {
			db.desconectar();
		}
	}

}
