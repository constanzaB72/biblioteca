package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;
import cl.inacap.bibliotecaModel.utils.Generador;

/**
 * 
 * Esta Clase es creada para la obtencion,creacion,actualizacion y eliminacion
 * de la clase y entidad Ejemplar. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase Libro y
 * Ejemplar.
 * 
 * CREADA EL DIA 5-07-2021
 * 
 * @author Camilo Moya
 * 
 */
public class EjemplarDAO {
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
	public static List<String> erroresEjemplaresDAO = new ArrayList<String>();

	/**
	 * Metodo que se encarga de traer todos los Ejemplares correspondientes a la
	 * tabla Ejemplares de la base de datos. El metodo realiza la consulta, con las
	 * tuplas resultantes las recorremos mediante un loop While, dentro del cual
	 * creamos una clase Ejemplar y le asignamos a sus atributos de clase los
	 * valores extraidos desde la query a la base de datos. Luego de asignar sus
	 * valores añadimos ese objeto Ejemplar a la lista de Tipo Ejemplar la cual será
	 * retornada al finalizar el Metodo.
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo Ejemplar
	 * @exception Agrega el error a la lista erroresEjemplaresDAO
	 */
	public List<Ejemplar> getAll() {

		try {

			List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
			db.conectar();

			String query = "SELECT NumSerie, ISBN, Titulo FROM BibliotecaV2.Ejemplares";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Ejemplar e = new Ejemplar();
				e.setNumSerie(rs.getInt(1));
				e.setIsbn(rs.getString(2));
				e.setTitulo(rs.getString(3));

				// Guardamos en la lista

				ejemplares.add(e);

			}

			rs.close();
			return ejemplares;

		} catch (Exception ex) {
			erroresEjemplaresDAO.add("Se Produjo un error al Consultar los Ejemplares");

			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de insertar 1 o mas ejemplares hacia la tabla Ejemplares ,
	 * basandose en un Libro. El Metodo recibe 1 parametro, un objeto Libro, del
	 * cual se extraeran el isbn y su Titulo. Primero, se carga una lista de
	 * ejemplares y con la ayuda del generador, se genera 1 numero se serie de 4
	 * digitos Aleatorio. Se recorre la lista de ejemplares y pregunta si existe ese
	 * numSerie dentro de la lista, si no existe, se procede a insertar el ejemplar
	 * en la tabla Ejemplares. Agregado a eso, una vez insertado el ejemplar, se
	 * procede a enlazar un estado a ese ejemplar, insertado en la tabla Estados. Si
	 * todo sale correctamente se agrega el Ejemplar exitosamente.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param libro
	 * @exception Agrega el error a la lista erroresEjemplaresDAO
	 */
	public int insertEjemplar(Libro libro) {

		try {
			List<Ejemplar> ejemplares = new EjemplarDAO().getAll();
			Generador gen = new Generador();
			int num = gen.generarNumSerie();
			int bandera = 0;

			// PREGUNTAMOS, ESTÁ EL NUMSERIE REGISTRADO? SI NO , LO INGRESA
			for (Ejemplar ejem : ejemplares) {
				if (ejem.getNumSerie() == num) {
					System.out.println("El Numero de Serie Ya está Registrado!");
					bandera++;
				}
			}
			if (bandera == 0) {
				db.conectar();
				String query = "INSERT INTO Ejemplares(NumSerie,ISBN,Titulo) VALUES(?,?,?)";
				PreparedStatement s = db.getCon().prepareStatement(query);

				s.setInt(1, num);
				s.setString(2, libro.getIsbn());
				s.setString(3, libro.getTitulo());

				s.executeUpdate();

				String query2 = "INSERT INTO Estados(NumSerie,Estado) VALUES(?,?)";
				PreparedStatement st = db.getCon().prepareStatement(query2);
				st.setInt(1, num);
				st.setString(2, "Disponible");

				st.executeUpdate();
				
			} else {
				erroresEjemplaresDAO.add("El Ejemplar ya se encuentra REGISTRADO!");

			}
			return num;
		} catch (Exception ex) {
			erroresEjemplaresDAO.add("Se Produjo un Error al ingresar el Ejemplar!");
			System.out.println(ex);
			return -1;
		} finally {
			db.desconectar();
		}

	}

	/**
	 * 
	 * Metodo encargado de actualizar el estado de cada ejemplar. El metodo recibe 2
	 * parametros, un objeto Ejemplar y un String que corresponde al estado que se
	 * va a sustituir. Luego se realiza una query directa para actualizar el
	 * parametro Estado en la tabla Estados cuando la sentencia WHERE NumSerie =
	 * ejemplar.getNumSerie(). Finalmente nos mostrará en consola un mensaje de
	 * confirmacion.
	 *
	 * @author Camilo Moya
	 * @param ejemplar
	 * @param estado
	 * @exception Agrega el error a la lista erroresEjemplaresDAO
	 */
	public void updateEstado(Ejemplar ejemplar, String estado) {
		try {
			db.conectar();
			String query = "UPDATE BibliotecaV2.Estados SET Estado =? WHERE NumSerie =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, estado);
			st.setInt(2, ejemplar.getNumSerie());
			st.executeUpdate();
			System.out.println("Actualizado con exito!");
		} catch (Exception ex) {
			erroresEjemplaresDAO.add("Se Produjo un Error al Actualizar el Estado del Ejemplar!");
			System.out.println("Error!");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de eliminar un ejemplar en especifico, junto a su estado. El
	 * metodo recibe 1 parametro, un objeto Ejemplar, del cual se extrae su NumSerie
	 * para realizar las querys de eliminacion. La primera query realiza la
	 * eliminacion del ejemplar en la tabla Estados con la ayuda de la sentencia
	 * WHERE NumSerie = ejemplar.getNumSerie(). Luego de eso, se procede a realizar
	 * la eliminacion de la tabla ejemplares cuando cumpla con la misma sentencia
	 * WHERE anterior. Una vez eliminado, en consola se mostrará un mensaje de
	 * confirmaicon.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param ejemplar
	 * @exception Agrega el error a la lista erroresEjemplaresDAO
	 */
	public void deleteEjemplar(Ejemplar ejemplar) {
		try {

			db.conectar();
			String query2 = "DELETE FROM BibliotecaV2.Estados WHERE NumSerie =?";
			PreparedStatement s = db.getCon().prepareStatement(query2);
			s.setInt(1, ejemplar.getNumSerie());

			s.executeUpdate();

			String query = "DELETE FROM BibliotecaV2.Ejemplares WHERE NumSerie =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, ejemplar.getNumSerie());

			st.executeUpdate();

			System.out.println("Eliminado con Exito!");
		} catch (Exception ex) {
			erroresEjemplaresDAO.add("Se Produjo un error al Eliminar el Ejemplar!");
		} finally {
			db.desconectar();
		}
	}
}
