package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * Clase que se encargada de la Obtencion,Creacion,Actualizacion y Eliminacion
 * de elementos en la tabla Boletas de la Base de Datos. Contiene Metodos
 * especificos que ayudan a obtener, crear , actualizar o eliminar datos de la
 * tabla Boletas. Se relaciona con la clase Cliente.
 * 
 * CREADA 1-07-2021
 * 
 * @author Camilo Moya
 * 
 *
 */
public class ClientesDAO {

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
	public static List<String> erroresClientesDAO = new ArrayList<String>();

	/**
	 * Metodo que se encarga de realizar una consulta a la base de datos, sobre
	 * todos los parametros de la tabla Clientes, al recibir las tuplas resultantes
	 * se recorren en un loop While, en donde se crea la clase Cliente a la cual se
	 * le asignan lo valores de la consulta a sus atributos de clase, para luego
	 * agregar ese Cliente a la lista de tipo Cliente que será retornada.
	 * 
	 * Ademas dentro del metodo, se realizan 3 subConsultas, las cuales consultan
	 * las tablas TelefonosClientes,CorreosClientes,DireccionesClientes , ya que un
	 * Cliente puede contar con 1 o mas telefonos,direcciones o correos. Dentro de
	 * estas subconsultas, se realiza una query hacia las tablas correspondientes,
	 * preguntando con la sentencia WHERE idCliente = Cliente.getIdCliente(). De
	 * esta forma cada SubConsulta traera los datos de cada cliente, para luego ser
	 * recorrida en un loop While y ser agregadas a las listas de tipo String que
	 * serán asignadas a la Clase Cliente.
	 * 
	 * Al finalizar todo el Proceso, se agregará el Cliente a la lista de Tipo
	 * Cliente y será retornada.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Clientes
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresClientesDAO
	 */
	public List<Cliente> getAll() {
		try {

			List<Cliente> clientes = new ArrayList<Cliente>();
			db.conectar();

			String query = "SELECT idCliente,Rut,Nombre,ApellidoMa,ApellidoPa,FechaNacimiento FROM BibliotecaV2.Clientes";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(Integer.parseInt(rs.getString(1)));
				c.setRut(rs.getString(2));
				c.setNombre(rs.getString(3));
				c.setApellidoMa(rs.getString(4));
				c.setApellidoPa(rs.getString(5));
				c.setFechaNacimiento(rs.getString(6));

				// ---- GUARDAMOS TELEFONOS ----
				if (c.getTelefonos() == null) {
					String queryLibro = "SELECT Telefono FROM BibliotecaV2.TelefonosClientes WHERE idCliente=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> telefonos = new ArrayList<String>();

					while (r.next()) {
						telefonos.add(r.getString(1));
					}
					c.setTelefonos((ArrayList<String>) telefonos);
				}
				// ---- GUARDAMOS CORREOS ----
				if (c.getCorreos() == null) {
					String queryLibro = "SELECT Correo FROM BibliotecaV2.CorreosClientes WHERE idCliente=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> correos = new ArrayList<String>();

					while (r.next()) {
						correos.add(r.getString(1));
					}

					c.setCorreos((ArrayList<String>) correos);
				}
				// ---- GUARDAMOS LAS DIRECCIONES ----
				if (c.getDirecciones() == null) {
					String queryLibro = "SELECT Direccion FROM BibliotecaV2.DireccionesClientes WHERE idCliente=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();

					List<String> direcciones = new ArrayList<String>();

					while (r.next()) {
						direcciones.add(r.getString(1));
					}

					c.setDirecciones((ArrayList<String>) direcciones);
				}

				// Guardamos en la lista
				clientes.add(c);
			}

			rs.close();
			return clientes;

		} catch (Exception ex) {

			erroresClientesDAO.add("Se Produjo un error al consultar");
			return null;

		} finally {
			db.desconectar();
		}

	}

	/**
	 * Este Metodo Void recibe 4 parametros, Cliente y 3 listas de tipo String. El
	 * metodo se encarga de realizar una insercion a la tabla Cliente en una Primera
	 * instancia. Los valores ingresados a la tabla , seran extraidos de los
	 * atributos de la clase Cliente. Ademas, cada lista de tipo String será de
	 * Telefonos,Correos y Direcciones correspondientemente, por lo cual ademas de
	 * la insercion principal, se realizan 3 loops de inserciones a la tabla
	 * correspondiente con la ayuda de un For que recorra cada lista recibida, la
	 * lista telefonos a la tabla TelefonosClientes, la lista correos a la tabla
	 * CorreosClientes y finalmente la lista direcciones a la tabla
	 * DireccionesClientes.
	 * 
	 * 
	 * 
	 * @author Camilo Moya
	 * @param cliente
	 * @param telefonos
	 * @param correos
	 * @param direcciones
	 * @return Mensaje de insercion Exitosa en la Consola
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresClientesDAO
	 */
	public void insertCliente(Cliente cliente, List<String> telefonos, List<String> correos, List<String> direcciones) {
		try {
			db.conectar();

			String query = "INSERT INTO Clientes(Rut, Nombre, ApellidoMa, ApellidoPa, FechaNacimiento,Password) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, cliente.getRut());
			st.setString(2, cliente.getNombre());
			st.setString(3, cliente.getApellidoMa());
			st.setString(4, cliente.getApellidoPa());
			st.setString(5, cliente.getFechaNacimiento());
			st.setString(6, cliente.getPassword());

			st.executeUpdate();

			String queryIdCliente = "SELECT idCliente FROM BibliotecaV2.Clientes WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdCliente);
			o.setString(1, cliente.getRut());
			ResultSet rs = o.executeQuery();

			while (rs.next()) {
				String queryTel = "INSERT INTO TelefonosClientes(idCliente, Telefono) VALUES(?,?)";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				for (String telefono : telefonos) {
					s.setInt(1, rs.getInt(1));
					s.setString(2, telefono);
					s.executeUpdate();
				}

				String queryCorre = "INSERT INTO CorreosClientes(idCliente, Correo) VALUES(?,?)";
				PreparedStatement p = db.getCon().prepareStatement(queryCorre);
				for (String correo : correos) {
					p.setInt(1, rs.getInt(1));
					p.setString(2, correo);
					p.executeUpdate();
				}

				String queryDire = "INSERT INTO DireccionesClientes(idCliente, Direccion) VALUES(?,?)";
				PreparedStatement t = db.getCon().prepareStatement(queryDire);
				for (String direccion : direcciones) {
					t.setInt(1, rs.getInt(1));
					t.setString(2, direccion);
					t.executeUpdate();
				}
			}

			System.out.println("Cliente ingresado con exito!");

		} catch (Exception ex) {
			erroresClientesDAO.add("Se Produjo un Error al Insertar el Cliente");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo Void que recibe 2 parametros , cliente y una lista de tipo String. El
	 * metodo se encarga de actualizar los telefonos hacia la tabla
	 * TelefonosClientes.
	 * 
	 * @author Camilo Moya
	 * @param cliente
	 * @param telefonos
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresClientesDAO
	 */
	public void updateTelefono(Cliente cliente, List<String> telefonos) {
		try {
			db.conectar();
		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de la Eliminacion de la Clase Cliente recibida en la tabla
	 * Clientes. Ademas antes de eliminar el Cliente en si, realiza 3 eliminaciones,
	 * en las 3 tablas asociadas a la Clase Cliente como lo son,
	 * TelefonosClientes,CorreosClientes,DireccionesClientes , todas estas
	 * eliminaciones son realizadas con la sentencia WHERE Rut = cliente.getRut().
	 * Una vez eliminados todos los datos en las tablas asociadas, se procede a la
	 * eliminacion de la entidad Cliente que corresponda con la sentencia WHERE =
	 * Rut = cliente.getRut().
	 * 
	 * 
	 * @author Camilo Moya
	 * @param cliente
	 * @exception Se Agrega el error a la lista de Tipo String llamada
	 *               erroresClientesDAO
	 */
	public void deleteCliente(Cliente cliente) {
		try {
			db.conectar();

			String queryIdCliente = "SELECT idCliente FROM BibliotecaV2.Clientes WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdCliente);
			o.setString(1, cliente.getRut());
			ResultSet rs = o.executeQuery();

			while (rs.next()) {
				String queryTel = "DELETE FROM TelefonosClientes WHERE idCliente =?";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				s.setInt(1, rs.getInt(1));
				s.executeUpdate();

				String queryCorre = "DELETE FROM CorreosClientes WHERE idCliente =?";
				PreparedStatement t = db.getCon().prepareStatement(queryCorre);
				t.setInt(1, rs.getInt(1));
				t.executeUpdate();

				String queryDirec = "DELETE FROM DireccionesClientes WHERE idCliente =?";
				PreparedStatement p = db.getCon().prepareStatement(queryDirec);
				p.setInt(1, rs.getInt(1));
				p.executeUpdate();

				String query = "DELETE FROM Clientes WHERE idCliente =?";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, rs.getInt(1));
				st.executeUpdate();
			}

			System.err.println("Cliente Eliminado con EXITO!");

		} catch (Exception ex) {
			erroresClientesDAO.add("Se Produjo un Error Al Eliminar al Cliente!");
		} finally {
			db.desconectar();
		}
	}

}
