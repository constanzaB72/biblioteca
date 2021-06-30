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
				l.setIsbn(rs.getString(1));
				l.setTitulo(rs.getString(2));
				l.setNumPagina(rs.getInt(3));
				l.setPrecio(rs.getInt(4));
				l.setAnioPublicacion(Integer.parseInt(rs.getString(5)));
				
				if(l.getIdiomas() == null) {
					String queryLibro = "SELECT ISBN,idIdioma FROM BibliotecaV2.Libro_Idioma WHERE ISBN=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					String isbn = "";
					int idIdioma = 0;
					
					while(r.next()) {
						isbn = r.getString(1);
						idIdioma = r.getInt(2);
					}
					
					String queryIdioma = "SELECT Idioma FROM BibliotecaV2.Idiomas WHERE idIdioma=?";
					PreparedStatement c = db.getCon().prepareStatement(queryIdioma);
					c.setInt(1, idIdioma);
					ResultSet re = c.executeQuery();
					
					List<String> idiomas = new ArrayList<String>();
					
					for(int i=1; i < 5; ++i) {
						while(re.next()) {
							if(re.getString(i) == null) {
								System.out.println("No existen Idiomas!");
							}else {
								idiomas.add(re.getString(i));
							}
							
						}
					}
					
				l.setIdiomas((ArrayList<String>) idiomas);		
				
				}
				
				
				l.setAutores(null);
				l.setCategorias(null);
				l.setEditorial("kaka");
				l.setEstado("kiki");
				
				
				
				//Guardamos en la lista
				libros.add(l);
			}
			
			rs.close();
			return libros;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
}
