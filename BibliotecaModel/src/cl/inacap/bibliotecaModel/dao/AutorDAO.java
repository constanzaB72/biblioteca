package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Autor;
import cl.inacap.bibliotecaModel.utils.DB;

/**
 * 
 * Esta Clase es creada para la obtencion completa de la clase y entidad Autor extraida desde la Tabla Autores.
 * Implementa la clase DB la cual permite la conexion directa hacia la base de datos.
 * Se relaciona con la Clase Autor.
 * 
 * CREADA EL DIA 1-07-2021
 * 
 * @author Camilo Moya
 * 
 */
public class AutorDAO {
	/**
	 * Clase que nos permite una conexion directa hacia la base de datos
	 */
	private DB db = new DB();
	
	/**
	 * Metodo que realiza una consulta a la base de datos trayendo todos los datos pertenecientes a la tabla Autores.
	 * Luego de recorrer el resultado en un loop While , crea una clase autor y la guarda en una lista de clase Autor, guardando todos los autores traidos desde
	 * la base de datos.
	 * 
	 * @author Camilo Moya
	 * @return
	 */
	public List<Autor> getAll(){
		
		try {
			
			List<Autor> autores = new ArrayList<Autor>();
			db.conectar();
			
			String query = "SELECT Nombre,ApellidoPa FROM BibliotecaV2.Autores";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Autor a = new Autor();
				a.setNombre(rs.getString(1));
				a.setApellidoPa(rs.getString(2));

				//Guardamos en la lista
				autores.add(a);
			}
			
			rs.close();
			return autores ;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
		
	}
	
	
	
	
}
