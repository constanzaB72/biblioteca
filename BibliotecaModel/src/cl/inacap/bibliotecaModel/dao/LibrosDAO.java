package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Autor;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;
import cl.inacap.bibliotecaModel.utils.Generador;

public class LibrosDAO {


	private DB db = new DB();
	
	public static List<String> erroresLibrosDAO = new ArrayList<String>();
	
	
	public List<Libro> getAll(){
		try {
			
			List<Libro> libros = new ArrayList<Libro>();
			db.conectar();
			//CONSULTA DIRECTA A LA TABLA LIBROS
			String query = "SELECT ISBN,Titulo,NumPagina,Precio,AnioPublicacion FROM BibliotecaV2.Libros";
			PreparedStatement st = db.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			erroresLibrosDAO.add("ESTO ES una PRUEBA de ERROR!");
			
			//                      ----- COMIENZAN CONSULTAS PARA LA CREACION DE LOS LIBROS ------
			while(rs.next()) { 
				Libro l = new Libro();
				l.setIsbn(rs.getString(1));
				l.setTitulo(rs.getString(2));
				l.setNumPagina(rs.getInt(3));
				l.setPrecio(rs.getInt(4));
				l.setAnioPublicacion(Integer.parseInt(rs.getString(5)));
				
				                                    // ---- CONSULTA IDIOMAS ----
				try {
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
					
				}catch(Exception ex) {
					erroresLibrosDAO.add("Se Produjo un Error al Consultar el Idioma!");
				}
				
				                                 //   ------- CONSULTA DE AUTORES -------
				try {
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
				}catch(Exception ex) {
					erroresLibrosDAO.add("Se Produjo un Error al Consultar los Autores!");
				}
				
				
				                              //   ------- CONSULTA DE CATEGORIAS -------
				try {
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
				}catch(Exception ex) {
					erroresLibrosDAO.add("Se Produjo un error al consultar las Categorias!");
				}	
					
					//   ------- CONSULTA DE EDITORIAL -------
				try {
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
				}catch(Exception ex) {
					erroresLibrosDAO.add("Se produjo un error al Consultar la Editorial!");
				}
				
				//Guardamos en la lista
				libros.add(l);
			}
			
			rs.close();
			return libros;
			
		}catch(Exception ex) {
			erroresLibrosDAO.add("Se Produjo un Error al consultar los Libros!");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	public void insertLibro(Libro libro, List<String> idiomas, List<String> autores, List<String> categorias) {
		try {
			
			// GUARDAMOS LOS PRIMERO PARAMETROS DE LA TABLA LIBROS
			db.conectar();
			String sql = "INSERT INTO Libros(ISBN,Titulo,NumPagina,Precio,AnioPublicacion) VALUES(?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(sql);
			st.setString(1, libro.getIsbn());
			st.setString(2, libro.getTitulo());
			st.setInt(3, libro.getNumPagina());
			st.setInt(4, libro.getPrecio());
			st.setInt(5, libro.getAnioPublicacion());
			
			st.executeUpdate();
						
			
			//PREGUNTAR Y GUARDAMOS LOS PARAMETROS EN LA TABLA AUTOR
			for(String autor : autores) {
				String query = "SELECT idAutor, Nombre, ApellidoPa, ApellidoMa FROM Autores";
				PreparedStatement s = db.getCon().prepareStatement(query);
				ResultSet rs = s.executeQuery();
				
				while(rs.next()) {
					if(autor.equals(rs.getString(2))) {
						System.out.println("Autor Registrado");
					}else {
						String query2 = "INSERT INTO Autores(Nombre) VALUES(?)";
						PreparedStatement p = db.getCon().prepareStatement(query2);
						p.setString(1, autor);
						p.executeUpdate();
					}
				}
				//PREGUNTAR Y GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_AUTOR
				int idAutor = 0;
				String query1 = "SELECT idAutor, Nombre FROM Autores WHERE Nombre =?";
				PreparedStatement so = db.getCon().prepareStatement(query1);
				so.setString(1, autor);
				ResultSet r = so.executeQuery();
				while(r.next()) {
					idAutor = r.getInt(1);
				}
				
				String query3 = "INSERT INTO Libro_Autor(ISBN, idAutor) VALUES(?,?)";
				PreparedStatement t = db.getCon().prepareStatement(query3);
				t.setString(1, libro.getIsbn());
				t.setInt(2, idAutor);
				t.executeUpdate();
			}
			
			
			
			//GUARDAMOS LOS PARAMETROS EN LA TABLA IDIOMAS
			//GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_IDIOMA
			
			//GUARDAMOS LOS PARAMETROS EN LA TABLA CATEGORIAS
			//GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_CATEGORIAS
			
			//GUARDAMOS LOS PARAMETROS EN LA TABLA EDITORIAL
			
			System.out.println("Libro Ingresado Con EXITOP!!");
			
		}catch(Exception ex) {
			erroresLibrosDAO.add("Se Produjo un error al Insertar el Libro!");
		}finally {
			db.desconectar();
		}
	}
	
	public void updatePrecioLibro(Libro libro) {
		try {
			db.conectar();
			String query = "UPDATE BibliotecaV2.Libros SET Precio =? WHERE ISBN =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, libro.getPrecio());
			st.setString(2, libro.getIsbn());
			st.executeUpdate();
			System.out.println("Actualizado con exito!");
		}catch(Exception ex) {
			erroresLibrosDAO.add("Se Produjo un problema al Actualizar el Precio del Libro!");
		}finally {
			db.desconectar();
		}
	}
	
	
	public void deleteLibro(Libro libro) {
		try {
			db.conectar();
			String query = "DELETE FROM BibliotecaV2.Libros WHERE ISBN =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, libro.getIsbn());
			
			st.executeUpdate();
			
		}catch(Exception ex) {
			erroresLibrosDAO.add("Se Produjo un error al Eliminar el Libro!");
		}finally {
			db.desconectar();
		}
	}
}
