package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;

public class LibrosDAO {

	private DB db = new DB();
	
	
	public List<Libro> getAll(){
		try {
			
			List<Libro> libros = new ArrayList<Libro>();
			db.conectar();
			//CONSULTA DIRECTA A LA TABLA LIBROS
			String query = "SELECT ISBN,Titulo,NumPagina,Precio,AnioPublicacion FROM BibliotecaV2.Libros";
			PreparedStatement st = db.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			//CONSULTA PARA SABER IDIOMAS POR ISBN
			
			//CONSULTA PARA SABER CATEGORIAS POR ISBN
			
			//CONSULTA PARA SABER AUTORES POR ISBN 
			
			
			while(rs.next()) { 
				Libro l = new Libro();
				l.setIsbn(0);

				
				//Guardamos en la lista
				
			}
			
			rs.close();
			return libros ;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	
	
	
	
}
