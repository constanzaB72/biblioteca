package cl.inacap.bibliotecaModel.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * Clase encargada de propocionar metodos generadores automaticos para ser
 * utilizados dentro del funcionamiento de la aplicacion.
 * 
 * 
 * CREADA EL DIA 6-07-2021
 * 
 * @author Camilo Moya
 *
 */
public class Generador {

	DB db = new DB();

	/**
	 * 
	 * 
	 * Metodo de Tipo Int encargado de generar un Numero de Serie de 4 digitos de
	 * forma Aleatoria. Realiza un loop para ir generando un numero Random y
	 * guardarlo en una variable anteriormente inicializada. Finalmente esos
	 * resultados los parseamos a un String , los concatenamos y luego los volvemos
	 * a parsear pero ahora a un Integer, para finalmente retornar la variable
	 * result quu contiene el Resultado con el Numero de Serie Final.
	 * 
	 * @author Camilo Moya
	 * @return result
	 */
	public int generarNumSerie() {

		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;

		for (int i = 0; i < 4; i++) {

			if (n1 == 0) {
				n1 = (int) (Math.random() * 9 + 1);
			} else if (n2 == 0) {
				n2 = (int) (Math.random() * 9 + 1);
			} else if (n3 == 0) {
				n3 = (int) (Math.random() * 9 + 1);
			} else if (n4 == 0) {
				n4 = (int) (Math.random() * 9 + 1);
			}

		}

		int result = Integer.valueOf(String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4));

		return result;
	}

	/**
	 * Metodo de tipo String encargado de Obtener la fecha actual . El metodo consta
	 * de un Formatter, una fecha y una fechaActual. El formatter establece el
	 * formato que queremos, luego con la ayuda de la clase LocalDate extraemos la
	 * fecha del sistema , la formateamos con la ayuda del formatter , para
	 * finlamente guardarla en una variable que retornaremos .
	 * 
	 * 
	 * @author Camilo Moya
	 * @return fechaActual
	 */
	public String generarFechaActual() {
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fecha = LocalDate.now();
		String fechaActual = fecha.format(formatter2);

		return fechaActual;
	}

	/**
	 * Metodo de tipo String encargado de Obtener la hora actual . El metodo consta
	 * de un Formatter, una hora y una horaActual. El formatter establece el formato
	 * que queremos, luego con la ayuda de la clase LocalTime extraemos la hora del
	 * sistema , la formateamos con la ayuda del formatter , para finlamente
	 * guardarla en una variable que retornaremos .
	 * 
	 * 
	 * @author Camilo Moya
	 * @return horaActual
	 */
	public String generarHoraActual() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime hora = LocalTime.now();
		String horaActual = hora.format(formatter);

		return horaActual;
	}

	/**
	 * Metodo de Tipo Int que se encarga de generar un Folio para una Boleta de
	 * Forma Automatica. El metodo realiza una query a la base de datos ,
	 * consultando la tabla Boletas con el ultimo Folio Registrado. Al obtener el
	 * resultado, le suma 1 y asigna ese valor a una variable que finalmente se
	 * retornará. En caso de Fallo aparecerá una Alerta en la consola
	 * 
	 * 
	 * @author Camilo Moya
	 * @return folio
	 */
	public int generarFolioBoleta() {
		try {
			db.conectar();
			String query = "SELECT Folio FROM BibliotecaV2.Boletas WHERE Folio=(SELECT MAX(Folio) FROM BibliotecaV2.Boletas)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();

			int folio = 0;
			while (rs.next()) {
				folio = rs.getInt(1) + 1;
			}

			return folio;

		} catch (Exception ex) {
			System.out.println("Se Produjo un Error al Generar el FOLIO");
			return 0;
		} finally {
			db.desconectar();
		}
	}
	public int generarFolioFactura() {
		try {
			db.conectar();
			String query = "SELECT Folio FROM BibliotecaV2.Facturas WHERE Folio=(SELECT MAX(Folio) FROM BibliotecaV2.Facturas)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			
			int folio = 0;
			while(rs.next()) {
				folio = rs.getInt(1) + 1;
			}
			
			return folio;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un Error al Generar el FOLIO");
			return 0;
		}finally {
			db.desconectar();
		}
	}
}
