package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion,creacion,actualizacion y eliminacion
 * de la clase y entidad Trabajador. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase
 * Trabajador.
 * 
 * CREADA EL DIA 29-06-2021
 * 
 * 
 * @author Camilo Moya
 * 
 */
public class TrabajadoresDAO {
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
	public static List<String> erroresTrabajadoresDAO = new ArrayList<String>();

	/**
	 * Metodo que se encarga de realizar una consulta a la base de datos, sobre
	 * todos los parametros de la tabla Trabajadores, al recibir las tuplas
	 * resultantes se recorren en un loop While, en donde se crea la clase
	 * Trabajador a la cual se le asignan lo valores de la consulta a sus atributos
	 * de clase, para luego agregar ese Trabajador a la lista de tipo Trabajador que
	 * será retornada.
	 * 
	 * Ademas dentro del metodo, se realizan 3 subConsultas, las cuales consultan
	 * las tablas TelefonosTrabajadores,CorreosTrabajadores,DireccionesTrabajadores,
	 * ya que un Trabajador puede contar con 1 o mas telefonos,direcciones o
	 * correos. Dentro de estas subconsultas, se realiza una query hacia las tablas
	 * correspondientes, preguntando con la sentencia WHERE idTrabajador =
	 * trabajador.getIdTrabajador(). De esta forma cada SubConsulta traera los datos
	 * de cada trabajador, para luego ser recorrida en un loop While y ser agregadas
	 * a las listas de tipo String que serán asignadas a la Clase Trabajador.
	 * 
	 * Al finalizar todo el Proceso, se agregará el Trabajador a la lista de Tipo
	 * Trabajador y será retornada.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo Trabajador
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresTrabajadoresDAO
	 */
	public List<Trabajador> getAll() {
		try {

			List<Trabajador> trabajadores = new ArrayList<Trabajador>();
			db.conectar();

			String query = "SELECT idTrabajador,Rut,Nombre,ApellidoMa,ApellidoPa,FechaContrato FROM BibliotecaV2.Trabajadores";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Trabajador t = new Trabajador();
				t.setIdTrabajador(Integer.parseInt(rs.getString(1)));
				;
				t.setRut(rs.getString(2));
				t.setNombre(rs.getString(3));
				t.setApellidoMa(rs.getString(4));
				t.setApellidoPa(rs.getString(5));
				t.setFechaContrato(rs.getString(6));

				if (t.getTelefonos() == null) {
					String queryLibro = "SELECT Telefono FROM BibliotecaV2.TelefonosTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> telefonos = new ArrayList<String>();

					while (r.next()) {
						telefonos.add(r.getString(1));
					}

					t.setTelefonos((ArrayList<String>) telefonos);
				}

				if (t.getDirecciones() == null) {
					String queryLibro = "SELECT Direccion FROM BibliotecaV2.DireccionesTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> direcciones = new ArrayList<String>();

					while (r.next()) {
						direcciones.add(r.getString(1));
					}

					t.setDirecciones((ArrayList<String>) direcciones);
				}

				if (t.getCorreos() == null) {
					String queryLibro = "SELECT Correo FROM BibliotecaV2.CorreosTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> correos = new ArrayList<String>();

					while (r.next()) {
						correos.add(r.getString(1));
					}

					t.setCorreos((ArrayList<String>) correos);

				}

				// Guardamos en la lista
				trabajadores.add(t);
			}

			rs.close();
			return trabajadores;

		} catch (Exception ex) {
			erroresTrabajadoresDAO.add("Se Produjo un error al consultar");
			return null;

		} finally {
			db.desconectar();
		}

	}

	/**
	 * Este Metodo Void recibe 4 parametros, Trabajador y 3 listas de tipo String.
	 * El metodo se encarga de realizar una insercion a la tabla Trabajadores en una
	 * Primera instancia. Los valores ingresados a la tabla , seran extraidos de los
	 * atributos de la clase Trabajador. Ademas, cada lista de tipo String será de
	 * Telefonos,Correos y Direcciones correspondientemente, por lo cual ademas de
	 * la insercion principal, se realizan 3 loops de inserciones a la tabla
	 * correspondiente con la ayuda de un For que recorra cada lista recibida, la
	 * lista telefonos a la tabla TelefonosTrabajadores, la lista correos a la tabla
	 * CorreosTrabajadores y finalmente la lista direcciones a la tabla
	 * DireccionesTrabajadores.
	 * 
	 * @author Camilo Moya
	 * @param trabajador
	 * @param telefonos
	 * @param correos
	 * @param direcciones
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresTrabajadoresDAO
	 */
	public void insertTrabajador(Trabajador trabajador, List<String> telefonos, List<String> correos,
			List<String> direcciones) {
		try {
			db.conectar();

			String query = "INSERT INTO Trabajadores(Rut, Nombre, ApellidoMa, ApellidoPa, FechaContrato, Password) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, trabajador.getRut());
			st.setString(2, trabajador.getNombre());
			st.setString(3, trabajador.getApellidoMa());
			st.setString(4, trabajador.getApellidoPa());
			st.setString(5, trabajador.getFechaContrato());
			st.setString(6, trabajador.getPassword());

			st.executeUpdate();

			String queryIdCliente = "SELECT idTrabajador FROM BibliotecaV2.Trabajadores WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdCliente);
			o.setString(1, trabajador.getRut());
			ResultSet rs = o.executeQuery();

			while (rs.next()) {
				String queryTel = "INSERT INTO TelefonosTrabajadores(idTrabajador, Telefono) VALUES(?,?)";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				for (String telefono : telefonos) {
					s.setInt(1, rs.getInt(1));
					s.setString(2, telefono);
					s.executeUpdate();
				}

				String queryCorre = "INSERT INTO CorreosTrabajadores(idTrabajador, Correo) VALUES(?,?)";
				PreparedStatement p = db.getCon().prepareStatement(queryCorre);
				for (String correo : correos) {
					p.setInt(1, rs.getInt(1));
					p.setString(2, correo);
					p.executeUpdate();
				}

				String queryDire = "INSERT INTO DireccionesTrabajadores(idTrabajador, Direccion) VALUES(?,?)";
				PreparedStatement t = db.getCon().prepareStatement(queryDire);
				for (String direccion : direcciones) {
					t.setInt(1, rs.getInt(1));
					t.setString(2, direccion);
					t.executeUpdate();
				}
				System.out.println("Trabajador Ingresado con EXITO!");
			}

		} catch (Exception ex) {
			erroresTrabajadoresDAO.add("Se Produjo un Error al Ingresar el trabajador");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo Void que recibe 1 parametro. El metodo se encarga de realizar la
	 * actualizacion de los datos del objeto obtenido.
	 * 
	 * @author Camilo Moya
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresTrabajadoresDAO
	 */

	public void updateTrabajador(Trabajador trabajador) {
		try {
			db.conectar();
		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de la Eliminacion de la Clase Trabajador recibida en la
	 * tabla Trabajadores. Ademas antes de eliminar el Trabajador en si, realiza 3
	 * eliminaciones, en las 3 tablas asociadas a la Clase Trabajador como lo son,
	 * TelefonosTrabajadores,CorreosTrabajadores,DireccionesTrabajadores, todas
	 * estas eliminaciones son realizadas con la sentencia WHERE Rut =
	 * trabajador.getRut(). Una vez eliminados todos los datos en las tablas
	 * asociadas, se procede a la eliminacion de la entidad Trabajador que
	 * corresponda con la sentencia WHERE = Rut = trabajador.getRut().
	 * 
	 * 
	 * @author Camilo Moya
	 * @param trabajador
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresTrabajadoresDAO
	 */
	public void deleteTrabajador(Trabajador trabajador) {
		try {
			db.conectar();

			String queryIdTrabajador = "SELECT idTrabajador FROM BibliotecaV2.Trabajadores WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdTrabajador);
			o.setString(1, trabajador.getRut());
			ResultSet rs = o.executeQuery();

			while (rs.next()) {
				String queryTel = "DELETE FROM TelefonosTrabajadores WHERE idTrabajador =?";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				s.setInt(1, rs.getInt(1));
				s.executeUpdate();

				String queryCorre = "DELETE FROM CorreosTrabajadores WHERE idTrabajador =?";
				PreparedStatement t = db.getCon().prepareStatement(queryCorre);
				t.setInt(1, rs.getInt(1));
				t.executeUpdate();

				String queryDirec = "DELETE FROM DireccionesTrabajadores WHERE idTrabajador =?";
				PreparedStatement p = db.getCon().prepareStatement(queryDirec);
				p.setInt(1, rs.getInt(1));
				p.executeUpdate();

				String query = "DELETE FROM Trabajadores WHERE idTrabajador =?";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, rs.getInt(1));
				st.executeUpdate();

				System.err.print("Trabajador Eliminado con EXITO!");
			}

		} catch (Exception ex) {
			erroresTrabajadoresDAO.add("Error al eliminar el Trabajador!");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de realizar la validacion de usuario en el loggin. Recibe 2
	 * parametros, 2 Strings , password y usuario. Luego realiza una consulta a la
	 * tabla Trabajadores. Si existe el Usuario y conicide su contraseña , retorna
	 * TRUE. Pero si no retorna FALSE.
	 * 
	 * 
	 * @author Constanza Benavides
	 * @param usuario
	 * @param password
	 * @return True si existe , False si no Existe
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresTrabajadoresDAO
	 */
	public boolean usuarioValido(String usuario, String password) {
		try {
			db.conectar();
			String query = "SELECT Rut,Password FROM BibliotecaV2.Trabajadores where Rut = ? and Password = ?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, usuario);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				rs.close();
				return true;
			}
			return false;
		} catch (Exception e) {
			erroresTrabajadoresDAO.add("Se Produjo un Error al Consultar los DATOS");
			return false;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de buscar a un Trabajador en la base de datos basados en un
	 * parametro entregado llamado Rut El metodo recibe 1 parametro, una cadena de
	 * texto llamada rut. El metodo consta de una consulta SQL hacia la base de
	 * datos con una sentencia WHERE que busca la coincidencia entre el String rut
	 * con la columna Rut de la base de datos si la encuentra, comienza a rellanar
	 * sus atributos de clase y por ende comienza a realizar consultas a las tablas
	 * enlazadas como telefonosTrabajadores, correosTrabajadores,
	 * direccionesTrabajadores, para luego ser asignadas a una clase trabajador
	 * creada al comienzo. Finalmente el Metodo nos retornará el trabajador de la
	 * Clase Trabajador.
	 * 
	 * @author Lorena Perez
	 * @param rut
	 * @return trabajador
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresTrabajadoresDAO
	 */
	public Trabajador findByRut(String rut) {
		try {
			Trabajador trabajador = new Trabajador();
			db.conectar();

			String query = "SELECT idTrabajador,Rut,Nombre,ApellidoMa,ApellidoPa,FechaContrato FROM BibliotecaV2.Trabajadores where Rut=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, rut);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {

				trabajador.setIdTrabajador(Integer.parseInt(rs.getString(1)));
				;
				trabajador.setRut(rs.getString(2));
				trabajador.setNombre(rs.getString(3));
				trabajador.setApellidoMa(rs.getString(4));
				trabajador.setApellidoPa(rs.getString(5));
				trabajador.setFechaContrato(rs.getString(6));

				if (trabajador.getTelefonos() == null) {
					String queryLibro = "SELECT Telefono FROM BibliotecaV2.TelefonosTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> telefonos = new ArrayList<String>();

					while (r.next()) {
						telefonos.add(r.getString(1));
					}

					trabajador.setTelefonos((ArrayList<String>) telefonos);
				}

				if (trabajador.getDirecciones() == null) {
					String queryLibro = "SELECT Direccion FROM BibliotecaV2.DireccionesTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> direcciones = new ArrayList<String>();

					while (r.next()) {
						direcciones.add(r.getString(1));
					}

					trabajador.setDirecciones((ArrayList<String>) direcciones);
				}

				if (trabajador.getCorreos() == null) {
					String queryLibro = "SELECT Correo FROM BibliotecaV2.CorreosTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> correos = new ArrayList<String>();

					while (r.next()) {
						correos.add(r.getString(1));
					}

					trabajador.setCorreos((ArrayList<String>) correos);

				}

				return trabajador;
			}

			rs.close();
			return trabajador;

		} catch (Exception ex) {
			erroresTrabajadoresDAO.add("Se produjo un error al consultar");
			return null;

		} finally {
			db.desconectar();
		}

	}
}
