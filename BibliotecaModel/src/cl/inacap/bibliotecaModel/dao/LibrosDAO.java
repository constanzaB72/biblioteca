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
			
			//                      ----- COMIENZAN CONSULTAS PARA LA CREACION DE LOS LIBROS ------
			while(rs.next()) { 
				Libro l = new Libro();
				l.setIsbn(rs.getString(1));
				l.setTitulo(rs.getString(2));
				l.setNumPagina(rs.getInt(3));
				l.setPrecio(rs.getInt(4));
				l.setAnioPublicacion(Integer.parseInt(rs.getString(5)));
				
				                                    // ---- CONSULTA IDIOMAS ----
				if(l.getIdiomas() == null) {
					String queryLibro = "SELECT ISBN,idIdioma FROM BibliotecaV2.Libro_Idioma WHERE ISBN=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					String isbn = "";
					int idIdioma = 0;
					
					List<String> idiomas = new ArrayList<String>();
					
					while(r.next()) {
						isbn = r.getString(1);
						idIdioma = r.getInt(2);
						
						String queryIdioma = "SELECT Idioma FROM BibliotecaV2.Idiomas WHERE idIdioma=?";
						PreparedStatement c = db.getCon().prepareStatement(queryIdioma);
						c.setInt(1, idIdioma);
						ResultSet re = c.executeQuery();
						
						for(int i=1; i < 5; ++i) {
							while(re.next()) {
								if(re.getString(i) == null) {
									System.out.println("No existen Idiomas!");
								}else {
									idiomas.add(re.getString(i));
								}
							}
						}
					}
					
				                             // ASIGNAMOS LOS VALORES AL ARRAYLIST DE IDIOMAS LIBRO	
				l.setIdiomas((ArrayList<String>) idiomas);		
				
				}
				
				                                 //   ------- CONSULTA DE AUTORES -------
				if(l.getAutores() == null) {
					String queryLibro = "SELECT ISBN,idAutor FROM BibliotecaV2.Libro_Autor WHERE ISBN=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					String isbn = "";
					int idAutor = 0;
					
					while(r.next()) {
						isbn = r.getString(1);
						idAutor = r.getInt(2);
					}
					
					String queryAutor = "SELECT Nombre,ApellidoPa FROM BibliotecaV2.Autores WHERE idAutor=?";
					PreparedStatement c = db.getCon().prepareStatement(queryAutor);
					c.setInt(1, idAutor);
					ResultSet re = c.executeQuery();
					
					List<String> autores = new ArrayList<String>();
					
					for(int i=1; i < 5; ++i) {
						while(re.next()) {
							if(re.getString(i) == null) {
								System.out.println("No existen Autores!");
							}else {
								autores.add(re.getString(i) + " " + re.getString(i+1));
							}
						}
					}
					
					        // ASIGNAMOS LOS VALORES AL ARRAY
					l.setAutores((ArrayList<String>) autores);
				}
				
				
				
				                              //   ------- CONSULTA DE CATEGORIAS -------
				if(l.getCategorias() == null) {
					String queryLibro = "SELECT ISBN,idCategoria FROM BibliotecaV2.Libro_Categoria WHERE ISBN=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					String isbn = "";
					int idCategoria = 0;
					
					List<String> categorias = new ArrayList<String>();
					
					while(r.next()) {
						isbn = r.getString(1);
						idCategoria = r.getInt(2);
						
						String queryCate = "SELECT Categoria FROM BibliotecaV2.Categorias WHERE idCategoria=?";
						PreparedStatement c = db.getCon().prepareStatement(queryCate);
						c.setInt(1, idCategoria);
						ResultSet re = c.executeQuery();
						
						for(int i=1; i < 5; ++i) {
							while(re.next()) {
								if(re.getString(i) == null) {
									System.out.println("No existen Autores!");
								}else {
									categorias.add(re.getString(i));
								}
							}
						}
					}
					                                      //ASIGNAMOS LOS VALORES AL ARRAY
					l.setCategorias((ArrayList<String>) categorias);
				}
				                               //   ------- CONSULTA DE EDITORIAL -------
				if(l.getEditorial() == null) {
					String queryLibro = "SELECT Editorial FROM BibliotecaV2.Editoriales WHERE ISBN=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					String editorial = "";
					
					while(r.next()) {
						editorial = r.getString(1);
					}
					
				l.setEditorial(editorial);	
					
				}

				
				//HAY QUE CAMBIARLO , EL ESTADO DEBE ESTAR EN EJEMPLAR NO EN LIBRO!!!
				l.setEstado("Disponible");
					
				
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
