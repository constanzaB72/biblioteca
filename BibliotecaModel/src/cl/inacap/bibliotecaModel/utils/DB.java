package cl.inacap.bibliotecaModel.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase encargada de proporcionar una conexion directa con una base de datos.
 * Contiene metodos que nos permiten realizar cierto tipo de acciones y
 * consultas.
 * 
 * 
 * CREADO EL DIA 22-06-2021
 * 
 * @author Camilo Moya
 *
 */
public class DB {

	private Connection con;

	/**
	 * Metodo directo de la libreria Java.sql.Connection Nos permite establecer
	 * conexion con la base de datos.
	 * 
	 * @return con
	 */
	public Connection getCon() {
		return con;
	}

	/**
	 * Metodo encargado de proporcionar la conexion con datos concretos con la base
	 * de datos seleccionada para trabajar. Dentro del metodo se especifican
	 * parametros para poder establecer una conexion segura y directa.
	 * 
	 * @author Camilo Moya
	 * @return True si establece conexion, False por Defecto.
	 */
	public boolean conectar() {
		try {

			// DECIRLE A JAVA QUE MOTOR DE DB ESTOY USANDO

			Class.forName("com.mysql.cj.jdbc.Driver");

			// CONECCION POR EL DRIVER
			// this.con =
			// DriverManager.getConnection("jdbc:mysql://localhost:33060/BibliotecaV2?serverTimeZone=UTC",
			// "root", "secret");

			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BibliotecaV2?serverTimeZone=UTC",
					"root", "");

			return true;

		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * Metodo desacoplador de la conexion, no permite cerrar la conexion
	 * anteriormente activa.
	 * 
	 * @author Camilo Moya
	 */
	public void desconectar() {
		try {
			con.close();

		} catch (Exception ex) {
			System.out.println("Se Produjo un error al cerrar la conexion");
		}
	}

}
