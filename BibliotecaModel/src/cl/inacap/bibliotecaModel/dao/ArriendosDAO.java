
package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.DetalleArriendo;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion, creacion, actualizacion y eliminacion
 * de la clase y entidad Arriendo. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase Arriendo,
 * y la Clase DAO DetallesArriendosDAO.
 * 
 * CREADA EL DIA 30-06-2021
 * 
 * @author Camilo Moya
 * 
 */
public class ArriendosDAO {
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
	public static List<String> erroresArriendosDAO = new ArrayList<String>();

	/**
	 * Metodo encargado de consultar a la base de datos todos los campos de la tabla
	 * Arriendos. Al traerlos, se recorren los resultados en un loop While, en donde
	 * por cada tupla resultante, se crea un Objeto Arriendo al cual se le settean
	 * los datos, para finalmente agregarlos a la lista de clase arriendo, la cual
	 * será retornada al finalizar el metodo.
	 * 
	 * @author Camilo Moya
	 * @exception Añade el error de la Exception a una lista llamada
	 *                  erroresAriendosDAO
	 * @return Retorna una lista de Arriendos
	 * @exception Agrega el error a la lista erroresArriendosDAO
	 */
	public List<Arriendo> getAll() {

		try {
			List<Arriendo> arriendos = new ArrayList<Arriendo>();
			db.conectar();

			String query = "SELECT idArriendo,FechaArriendo,FechaDevolucion,FechaEntrega,DiasRetraso,Multa,CostoTotal FROM BibliotecaV2.Arriendos";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Arriendo a = new Arriendo();
				a.setIdArriendo(Integer.parseInt(rs.getString(1)));
				a.setFechaArriendo(rs.getString(2));
				a.setFechaDevolucion(rs.getString(3));
				a.setFechaEntrega(rs.getString(4));
				a.setDiasRetraso(Integer.parseInt(rs.getString(5)));
				a.setMulta(Integer.parseInt(rs.getString(6)));
				a.setCostoTotal(rs.getInt(7));

				// Guardamos en la lista
				arriendos.add(a);
			}

			rs.close();
			return arriendos;

		} catch (Exception ex) {
			erroresArriendosDAO.add("Se Produjo un Error al Consultar los Arriendos!");
			return null;

		} finally {
			db.desconectar();
		}
	}

	/**
	 * 
	 * Metodo Void que recibe 3 parametros, el primero es arriendo del cual se
	 * extraen la mayoria de los datos, luego está cliente y trabajador a los cuales
	 * unicamente se le extraen los id. El metodo, realiza una query de insercion
	 * hacia la base de datos, inyectando todos los datos extraidos de los
	 * parametros de entrada.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param arriendo
	 * @param cliente
	 * @param trabajador
	 * @exception Agrega el error a la lista erroresArriendosDAO
	 */

	public int crearArriendo(Arriendo arriendo, Cliente cliente, Trabajador trabajador) {
		int idArriendo=-1;
		try {
			db.conectar();
			String query = "INSERT INTO Arriendos(idCliente, idTrabajador, FechaArriendo, FechaDevolucion, FechaEntrega, DiasRetraso, Multa, CostoTotal) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, cliente.getIdCliente());
			st.setInt(2, trabajador.getIdTrabajador());
			st.setString(3, arriendo.getFechaArriendo());
			st.setString(4, arriendo.getFechaDevolucion());
			st.setString(5, arriendo.getFechaEntrega());
			st.setInt(6, arriendo.getDiasRetraso());
			st.setInt(7, arriendo.getMulta());
			st.setInt(8, arriendo.getCostoTotal());

			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
				idArriendo=rs.getInt(1);
			}
			return idArriendo;


		} catch (Exception ex) {
			erroresArriendosDAO.add("Se Produjo un Error al ingresar el Arriendo!");
			return idArriendo;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * 
	 * Metodo Void que recibe 3 parametros, detallesArriendosDAO, para acceder a su
	 * metodo getCostoTotal, recibe ademas un Arriendo y un ArriendosDAO. El metodo
	 * genera una actualizacion a la tabla arriendos en la columna CostoTotal, que
	 * cumpla con la sentencia WHERE del idArriendo, dando un mensaje en consola que
	 * indica que el costo fue agregado con Exito! .
	 * 
	 * @author Camilo Moya
	 * @param detalles
	 * @param arriendo
	 * @param arriendoDAO
	 * @exception Agrega el error a la lista erroresArriendosDAO
	 */

	public void agregarCostoTotal(DetallesArriendosDAO detalles, Arriendo arriendo, ArriendosDAO arriendoDAO) {
		try {
			db.conectar();
			String query = "UPDATE BibliotecaV2.Arriendos SET CostoTotal =? WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, detalles.getCostoTotal(arriendo, arriendoDAO));
			st.setInt(2, arriendo.getIdArriendo());

			st.executeUpdate();

			System.out.println("Se Agrego el costo!");

		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo int que recibe 1 parametro, un Arriendo del cual se extrae su id para
	 * poder realizar una consulta SQL con una sentencia WHERE. El metodo comienza
	 * inicializando una variable multa en 0, luego realiza la consulta SQL de Multa
	 * a la tabla Arriendos que cumpla con el WHERE idArriendo especificado, luego
	 * se recorre el resultado de la query en un loop while, guardando el resultado
	 * en la variable multa, para finalmente retornar Multa.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param arriendo
	 * @return multa
	 * @exception Agrega el error a la lista erroresArriendosDAO
	 */
	public int getMulta(Arriendo arriendo) {
		try {
			db.conectar();
			int multa = 0;
			String query = "SELECT Multa FROM BibliotecaV2.Arriendos WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				multa += rs.getInt(1);
			}

			rs.close();

			return multa;
		} catch (Exception ex) {
			return arriendo.getMulta();
		} finally {
			db.desconectar();
		}
	}

	/**
	 * 
	 * Metodo Void que recibe 1 arriendo y un int multa. El metodo realiza una
	 * actualizacion en la tabla arriendo realizando un set de la columna Multa con
	 * el valor recibido en el parametro multa.
	 * 
	 * @author Camilo Moya
	 * @param arriendo
	 * @param multa
	 * @exception Agrega el error a la lista erroresArriendosDAO
	 */
	public void agregarMulta(Arriendo arriendo, int multa) {
		try {
			db.conectar();
			String query = "UPDATE BibliotecaV2.Arriendos SET Multa =? WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, multa);
			st.setInt(2, arriendo.getIdArriendo());

			st.executeUpdate();

			System.out.println("Se Agrego la Multa!!");

		} catch (Exception ex) {
			erroresArriendosDAO.add("Se produjo un error al agregar la Multa!");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo Void que recibe el parametro Arriendo. Lo primero que realiza el
	 * metodo es realizar la eliminacion de cualquier Detalle al que se encuentra
	 * enlazado el Arriendo recibido , todo esto en la tabla DetallesArriendo. Luego
	 * el metodo realiza la eliminacion de la tabla arriendos en donde corresponda
	 * la sentencia WHERE idArriendo = al id extraido del parametro recibido
	 * arriendo.
	 * 
	 * De esta forma al eliminar 1 arriendo de la tabla Arriendos, se forma
	 * síncrona, realiza primero la eliminacion de los detalles enlazados a ese
	 * arriendo.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param arriendo
	 * @exception Agrega el error a la lista erroresArriendosDAO
	 */
	public void deleteArriendo(Arriendo arriendo) {
		try {
			db.conectar();

			String query = "DELETE FROM BibliotecaV2.DetalleArriendos WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());

			st.executeUpdate();

			String query2 = "DELETE FROM BibliotecaV2.Arriendos WHERE idArriendo =?";
			PreparedStatement s = db.getCon().prepareStatement(query2);
			s.setInt(1, arriendo.getIdArriendo());

			s.executeUpdate();

			System.out.println("Arriendo Eliminado con Exito!");

		} catch (Exception ex) {
			erroresArriendosDAO.add("Se Produjo un error al Eliminar el Arriendo!");
		} finally {
			db.desconectar();
		}
	}
	
	public List<Arriendo> getByRutCliente(String rutCliente) {

		try {
			List<Arriendo> arriendos = new ArrayList<Arriendo>();
			db.conectar();

			String query = "SELECT a.idArriendo,a.FechaArriendo,a.FechaDevolucion,a.FechaEntrega,a.DiasRetraso,a.Multa,a.CostoTotal FROM BibliotecaV2.Arriendos a"
					+ " LEFT join BibliotecaV2.Clientes c ON c.idCliente = a.idCliente"
					+ " where c.Rut=?";
			
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, rutCliente);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Arriendo a = new Arriendo();
				a.setIdArriendo(Integer.parseInt(rs.getString(1)));
				a.setFechaArriendo(rs.getString(2));
				a.setFechaDevolucion(rs.getString(3));
				a.setFechaEntrega(rs.getString(4));
				a.setDiasRetraso(Integer.parseInt(rs.getString(5)));
				a.setMulta(Integer.parseInt(rs.getString(6)));
				a.setCostoTotal(rs.getInt(7));

				// Guardamos en la lista
				arriendos.add(a);
			}

			rs.close();
			System.out.println("arriendos encontrados: "+arriendos.size());
			return arriendos;

		} catch (Exception ex) {
			System.out.println(ex);
			erroresArriendosDAO.add("Se Produjo un Error al Consultar los Arriendos!");
			return null;

		} finally {
			db.desconectar();
		}
	}

}
