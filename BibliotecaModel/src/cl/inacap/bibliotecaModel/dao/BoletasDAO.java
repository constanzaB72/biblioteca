package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Boleta;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * Clase que se encargada de la Obtencion,Creacion,Actualizacion y Eliminacion
 * de elementos en la tabla Boletas de la Base de Datos. Contiene Metodos
 * especificos que ayudan a obtener, crear , actualizar o eliminar datos de la
 * tabla Boletas. Se relaciona con la clase Boleta , la Clase BoletasDAO y la
 * Clase DetallesBoletas.
 * 
 * CREADA EL DIA 1-07-2021
 * 
 * @author Camilo Moya
 * 
 *
 */
public class BoletasDAO {

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
	public static List<String> erroresBoletasDAO = new ArrayList<String>();

	/**
	 * 
	 * Metodo que realiza un consulta SQL a la base de datos, la cual nos trae los
	 * datos requeridos de la tabla Boletas. El metodo luego de realizar la
	 * consulta, trae las tuplas y recorre 1 por 1 con l ayuda de un loop While, en
	 * donde dentro de este, se crea un clase Boleta y se le asignan los datos
	 * extraidos desde la base de datos, para luego guadar esta clase Boleta en la
	 * lista de tipo Boleta. Para Finalmente ser retornada al finalizar el metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Boletas
	 * @exception Se Agrega la Exception a la lista de tipo String erroresBoletasDAO
	 */
	public List<Boleta> getAll() {

		try {

			List<Boleta> boletas = new ArrayList<Boleta>();
			db.conectar();

			String query = "SELECT Folio,idCliente,idTrabajador,FechaVenta,HoraVenta,MetodoPago FROM BibliotecaV2.Boletas";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Boleta b = new Boleta();
				b.setFolio(rs.getInt(1));
				b.setIdCliente(rs.getInt(2));
				b.setIdTrabajador(rs.getInt(3));
				b.setFechaVenta(rs.getString(4));
				b.setHoraVenta(rs.getString(5));
				b.setMetodoPago(rs.getString(6));

				// Guardamos en la lista
				boletas.add(b);
			}

			rs.close();
			return boletas;

		} catch (Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}

	}

	/**
	 * El Metodo Void recibe 3 parametros, una Boleta, un Cliente y un Trabajador de
	 * los cuales se extraen sus atributos para luego realizar una insercion en la
	 * tabla Boletas.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param boleta
	 * @param cliente
	 * @param trabajador
	 */
	public void insertBoleta(Boleta boleta, Cliente cliente, Trabajador trabajador) {
		try {
			db.conectar();

			String query = "INSERT INTO Boletas(Folio, idCliente, idTrabajador, FechaVenta, HoraVenta, MetodoPago) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, boleta.getFolio());
			st.setInt(2, cliente.getIdCliente());
			st.setInt(3, trabajador.getIdTrabajador());
			st.setString(4, boleta.getFechaVenta());
			st.setString(5, boleta.getHoraVenta());
			st.setString(6, boleta.getMetodoPago());

			st.executeUpdate();

			System.out.println("Boleta Ingresada con EXITO!");

		} catch (Exception ex) {
			erroresBoletasDAO.add("Se Produjo un Error al ingresar la Boleta");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * El Metodo Void recibe una boleta a la cual se le extraen sus atributos para
	 * luego modificarlos en la query hacia la base de datos.
	 * 
	 * @author Camilo Moya
	 * @param boleta
	 */
	public void updateBoleta(Boleta boleta) {

	}

	/**
	 * 
	 * El Metodo Void recibe un parametro, un objeto Boleta, al cual le extrae su
	 * Folio, para realizar una eliminacion en la tabla Boletas en donde se cumpla
	 * la sentencia WHERE Folio = boleta.getFolio(). Antes de realizar eso, se
	 * procede a eliminar cualquier detalle relacionado con el Folio de la Boleta
	 * recibida, con una sentencia de Eliminacion en la tabla DetallesBoletas. Para
	 * luego finalmente realizar la eliminacion de la Boleta en la tabla Boletas.
	 * 
	 * @author Camilo Moya
	 * @param boleta
	 */
	public void deleteBoleta(Boleta boleta) {
		try {
			db.conectar();

			String queryDeta = "DELETE FROM DetalleBoletas WHERE Folio =?";
			PreparedStatement s = db.getCon().prepareStatement(queryDeta);
			s.setInt(1, boleta.getFolio());
			s.executeUpdate();

			String query = "DELETE FROM Boletas WHERE Folio =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, boleta.getFolio());
			st.executeUpdate();

			System.out.println("Boleta Eliminada con EXITO!");

		} catch (Exception ex) {
			erroresBoletasDAO.add("Se Produjo un error al Eliminar la Boleta");
		} finally {
			db.desconectar();
		}
	}

}
