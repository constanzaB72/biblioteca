package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Boleta;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.dto.Venta;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion,creacion,actualizacion y eliminacion
 * de la clase y entidad Venta. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase Boleta,
 * Cliente y Trabajador.
 * 
 * CREADA EL DIA 30-06-2021
 * 
 * 
 * @author Camilo Moya
 * 
 */
public class VentasDAO {
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
	public static List<String> erroresVentasDAO = new ArrayList<String>();

	/**
	 * Metodo encargado de consultar todos los valores de la tabla Ventas. Realiza
	 * una query consultando por los valores de la tabla Ventas, con las tuplas
	 * resultantes las recorremos con la ayuda de un loop While y creamos ademas una
	 * Clase Venta en donde asignaremos los valores de la tupla a los atributos de
	 * la clase Venta. Luego de eso la guadaremos en la Lista de tipo Venta que sera
	 * retornada al finalizar el metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo Venta
	 * @exception Agrega el error a la lista erroresVentasDAO
	 */
	public List<Venta> getAll() {

		try {

			List<Venta> ventas = new ArrayList<Venta>();
			db.conectar();

			String query = "SELECT idVenta,idTrabajador,idCliente,Folio FROM BibliotecaV2.Ventas";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Venta v = new Venta();
				v.setIdVenta(rs.getInt(1));
				v.setIdTrabajador(rs.getInt(2));
				v.setIdCliente(rs.getInt(3));
				v.setFolio(rs.getInt(4));

				// Guardamos en la lista
				ventas.add(v);
			}

			rs.close();
			return ventas;

		} catch (Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}

	}

	/**
	 * Metodo encargado de insertar una clase Venta a la tabla Ventas. Recibe 3
	 * parametros, un objeto Boleta, un Cliente y un Trabajador , a los cuales se le
	 * extraeran los datos de Folio, idcliente, idTrabajador correspondientemente.
	 * Luego se realiza la qury de insercion de los datos a la tabla Ventas. Si todo
	 * sale correctamente en la consola se mostrará un mensaje de confirmacion.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param boleta
	 * @param cliente
	 * @param trabajador
	 * @exception Agrega el error a la lista erroresVentasDAO
	 */
	public void insertVenta(Boleta boleta, Cliente cliente, Trabajador trabajador) {
		try {
			db.conectar();

			String query = "INSERT INTO Ventas(idTrabajador, idCliente, Folio) VALUES(?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, trabajador.getIdTrabajador());
			st.setInt(2, cliente.getIdCliente());
			st.setInt(3, boleta.getFolio());

			st.executeUpdate();
			System.out.println("Venta Ingresada con EXITO!");

		} catch (Exception ex) {
			erroresVentasDAO.add("Se Produjo un Error al Ingresar la Venta");
		} finally {

		}
	}

	/**
	 * Metodo encargado de Eliminar un Objeto Venta de la tabla Ventas. Recibe 1
	 * parametro , una Boleta, de la cual se extrae su folio, para ser utilizado en
	 * la query con una sentencia WHERE Folio = boleta.getFolio(). Una vez realizada
	 * la eliminacion , mediante la consola se mostrará un mensaje de confirmacion.
	 * 
	 * @author Camilo Moya
	 * @param boleta
	 * @exception Agrega el error a la lista erroresVentasDAO
	 */
	public void deleteVenta(Boleta boleta) {
		try {
			db.conectar();

			String query = "DELETE FROM Ventas WHERE Folio =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, boleta.getFolio());
			st.executeUpdate();

			System.out.println("Venta Eliminada con EXITO!");

		} catch (Exception ex) {
			erroresVentasDAO.add("Se Produjo un Error al Eliminar la VENTA!");
		} finally {
			db.desconectar();
		}
	}

}
