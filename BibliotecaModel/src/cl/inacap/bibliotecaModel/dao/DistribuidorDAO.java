package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion,creacion,actualizacion y eliminacion
 * de la clase y entidad Distribuidor. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase
 * Distribudor.
 * 
 * CREADA EL DIA 5-07-2021
 * 
 * @author Camilo Moya
 * 
 */
public class DistribuidorDAO {
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
	public static List<String> erroresDistribuidoresDAO = new ArrayList<String>();

	/**
	 * Metodo que se encarga de traer todos los Distribuidores correspondientes a la
	 * tabla Distribuidores de la base de datos. El metodo realiza la consulta, con
	 * las tuplas resultantes las recorremos mediante un loop While, dentro del cual
	 * creamos una clase Distribuidor y le asignamos a sus atributos de clase los
	 * valores extraidos desde la query a la base de datos. Luego de asignar sus
	 * valores añadimos ese objeto Distribuidor a la lista de Tipo Distribuidor la
	 * cual será retornada al finalizar el Metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo Distribuidor
	 * @exception Agrega el error a la lista erroresDistribuidoresDAO
	 */
	public List<Distribuidor> getAll() {

		try {

			List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
			db.conectar();

			String query = "SELECT idDistribuidor, Rut, NombreEmpresa, AnioVinculo, Direccion, Telefono FROM BibliotecaV2.Distribuidores";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Distribuidor d = new Distribuidor();
				d.setIdDistribuidor(rs.getInt(1));
				d.setRut(rs.getString(2));
				d.setNombreEmpresa(rs.getString(3));
				d.setAnioVinculo(rs.getInt(4));
				d.setDireccion(rs.getString(5));
				d.setTelefono(rs.getString(6));

				// Guardamos en la lista

				distribuidores.add(d);
			}

			rs.close();
			return distribuidores;

		} catch (Exception ex) {
			erroresDistribuidoresDAO.add("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que se encarga de insertar una Clase Distribuidor a la base de datos
	 * en la tabla Distribuidores. El metodo recibe 1 perametro, la Clase
	 * Distribuidor, de la cual extraeremos sus datos y los insertaremos con la
	 * ayuda de una Query SQL hacia la tabla Distribuidores. Finalmente en la
	 * consola se lanza un mensaje de confirmacion sobre la insercion del
	 * distribuidor a la tabla Distribuidores.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param distribuidor
	 * @exception Agrega el error a la lista erroresDistribuidoresDAO
	 */
	public void insertDistribuidor(Distribuidor distribuidor) {
		try {
			db.conectar();

			String query = "INSERT INTO Distribuidores(idDistribuidor, Rut, NombreEmpresa, AnioVinculo, Direccion, Telefono) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, distribuidor.getIdDistribuidor());
			st.setString(2, distribuidor.getRut());
			st.setString(3, distribuidor.getNombreEmpresa());
			st.setInt(4, distribuidor.getAnioVinculo());
			st.setString(5, distribuidor.getDireccion());
			st.setString(6, distribuidor.getTelefono());

			st.executeUpdate();

			System.out.println("Distribuidor Ingresado Con Exito!");

		} catch (Exception ex) {
			erroresDistribuidoresDAO.add("Se Produjo un error al ingresar el Distribuidor!");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de Actualizar el Numero de Telefono de un distribuidor en
	 * especifico. El metodo recibe 2 parametros, una clase Distribuidor y un String
	 * que corresponde al telefono nuevo. Se realiza una query directa de
	 * actualizacion hacia la base de datos actualizando el telefono cuando se
	 * cumpla la sentencia WHERE idDistribuidor = distribuidor.getIdDistribuidor().
	 * Finalmente lanza en la consola un mensaje de confirmacion sobre la
	 * actualizacion.
	 * 
	 * @author Camilo Moya
	 * @param distribuidor
	 * @param telefono
	 * @exception Agrega el error a la lista erroresDistribuidoresDAO
	 */
	public void updateDistribuidor(Distribuidor distribuidor, String telefono) {
		try {
			db.conectar();

			String query = "UPDATE BibliotecaV2.Distribuidores SET Telefono =? WHERE idDistribuidor =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, telefono);
			st.setInt(2, distribuidor.getIdDistribuidor());

			st.executeUpdate();

			System.out.println("Se Actualizó el Telefono con Exito!");

		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que se encarga de eliminar un Distribuidor de la tabla Distribuidores.
	 * El metodo recibe 1 parametro, una Clase Distribuidor de la cual se extrae su
	 * id para realizar una sentencia de eliminacion con ayuda de un WHERE. Si
	 * cumple la sentencia WHERE idDistribuidor = distribuidor.getIdDistribuidor(),
	 * entonces se producira la eliminacion en la tabla. Dando como resultado en la
	 * consola un mensaje de confirmacion.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param distribuidor
	 * @exception Agrega el error a la lista erroresDistribuidoresDAO
	 */
	public void deleteDistribuidor(Distribuidor distribuidor) {
		try {
			db.conectar();

			String query = "DELETE FROM Distribuidores WHERE idDistribuidor=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, distribuidor.getIdDistribuidor());
			st.executeUpdate();

			System.out.println("Distribuidor Eliminado con Exito!");

		} catch (Exception ex) {
			erroresDistribuidoresDAO.add("Se Produjo un error al Eliminar el Distribuidor!");
		} finally {
			db.desconectar();
		}
	}

}
