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

/**
 * 
 * Esta Clase es creada para la obtencion,creacion,actualizacion y eliminacion
 * de la clase y entidad Libro. Implementa la clase DB la cual permite la
 * conexion directa hacia la base de datos. Se relaciona con la Clase Libro.
 * 
 * CREADA EL DIA 28-06-2021
 * 
 * 
 * @author Camilo Moya
 * 
 */
public class LibrosDAO {
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
	public static List<String> erroresLibrosDAO = new ArrayList<String>();

	/**
	 * Metodo encargado de Consultar a la base de datos todos las tablas y atributos
	 * relacionados con la Tabla Libro. Estas consultas se realizan a las tablas
	 * Libro, Autor, Libro_Autor, Idioma, Libro_Idioma, Categoria , Libro_Categoria
	 * , Editorial. Al comienzo realiza una consulta a la tabla Libros, trayendo la
	 * mayoria de los datos de la clase Libro. Mediante un Loop While , recorremos
	 * los datos de la consulta a la tabla libros, pero ademas dentro del mismo loop
	 * realizamos consultas hacia la tabla Libro_Idioma en donde corresponda el ISBN
	 * del libro, dando como resultado un IdIdioma, luego de eso consultamos a que
	 * idioma corresponde ese id, mediante la consulta a la tabla Idioma. Luego
	 * recorremos ese reultado y los guardamos en uns lista de Tipo String, que
	 * luego será agregada a la clase Libro. Este principio se cumple en todas las
	 * demas subconsultas, tanto para Categorias y para Autores . En editoriales es
	 * una consulta simple, solo consulta y devuelve 1 resultado que debe ser
	 * asignado a la clase Libro. Cada vez que se crea una nueva clase libro se
	 * agrega a la lista de Tipo Libro que será retornada al finalizar el metodo.
	 * 
	 * 
	 * @author Camilo Moya
	 * @return Lista de Tipo Libro
	 * @exception Agrega el error a la lista erroresLibrosDAO
	 */
	public List<Libro> getAll() {
		try {

			List<Libro> libros = new ArrayList<Libro>();
			db.conectar();
			// CONSULTA DIRECTA A LA TABLA LIBROS
			String query = "SELECT ISBN,Titulo,NumPagina,Precio,AnioPublicacion FROM BibliotecaV2.Libros";
			PreparedStatement st = db.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			erroresLibrosDAO.add("ESTO ES una PRUEBA de ERROR!");

			// ----- COMIENZAN CONSULTAS PARA LA CREACION DE LOS LIBROS ------
			while (rs.next()) {
				Libro l = new Libro();
				l.setIsbn(rs.getString(1));
				l.setTitulo(rs.getString(2));
				l.setNumPagina(rs.getInt(3));
				l.setPrecio(rs.getInt(4));
				l.setAnioPublicacion(Integer.parseInt(rs.getString(5)));

				// ---- CONSULTA IDIOMAS ----
				try {
					if (l.getIdiomas() == null) {
						String queryLibro = "SELECT ISBN,idIdioma FROM BibliotecaV2.Libro_Idioma WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String isbn = "";
						int idIdioma = 0;

						List<String> idiomas = new ArrayList<String>();

						while (r.next()) {
							isbn = r.getString(1);
							idIdioma = r.getInt(2);

							String queryIdioma = "SELECT Idioma FROM BibliotecaV2.Idiomas WHERE idIdioma=?";
							PreparedStatement c = db.getCon().prepareStatement(queryIdioma);
							c.setInt(1, idIdioma);
							ResultSet re = c.executeQuery();

							for (int i = 1; i < 5; ++i) {
								while (re.next()) {
									if (re.getString(i) == null) {
										System.out.println("No existen Idiomas!");
									} else {
										idiomas.add(re.getString(i));
									}
								}
							}
						}

						// ASIGNAMOS LOS VALORES AL ARRAYLIST DE IDIOMAS LIBRO
						l.setIdiomas((ArrayList<String>) idiomas);

					}

				} catch (Exception ex) {
					erroresLibrosDAO.add("Se Produjo un Error al Consultar el Idioma!");
				}

				// ------- CONSULTA DE AUTORES -------
				try {
					if (l.getAutores() == null) {
						String queryLibro = "SELECT ISBN,idAutor FROM BibliotecaV2.Libro_Autor WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String isbn = "";
						int idAutor = 0;

						List<String> autores = new ArrayList<String>();

						while (r.next()) {
							isbn = r.getString(1);
							idAutor = r.getInt(2);

							String queryAutor = "SELECT Nombre FROM BibliotecaV2.Autores WHERE idAutor=?";
							PreparedStatement c = db.getCon().prepareStatement(queryAutor);
							c.setInt(1, idAutor);
							ResultSet re = c.executeQuery();

							for (int i = 1; i < 5; ++i) {
								while (re.next()) {
									if (re.getString(i) == null) {
										System.out.println("No existen Autores!");
									} else {
										autores.add(re.getString(i));
									}
								}
							}
						}
						// ASIGNAMOS LOS VALORES AL ARRAY
						l.setAutores((ArrayList<String>) autores);
					}
				} catch (Exception ex) {
					erroresLibrosDAO.add("Se Produjo un Error al Consultar los Autores!");
				}

				// ------- CONSULTA DE CATEGORIAS -------
				try {
					if (l.getCategorias() == null) {
						String queryLibro = "SELECT ISBN,idCategoria FROM BibliotecaV2.Libro_Categoria WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String isbn = "";
						int idCategoria = 0;

						List<String> categorias = new ArrayList<String>();

						while (r.next()) {
							isbn = r.getString(1);
							idCategoria = r.getInt(2);

							String queryCate = "SELECT Categoria FROM BibliotecaV2.Categorias WHERE idCategoria=?";
							PreparedStatement c = db.getCon().prepareStatement(queryCate);
							c.setInt(1, idCategoria);
							ResultSet re = c.executeQuery();

							for (int i = 1; i < 5; ++i) {
								while (re.next()) {
									if (re.getString(i) == null) {
										System.out.println("No existen Autores!");
									} else {
										categorias.add(re.getString(i));
									}
								}
							}
						}
						// ASIGNAMOS LOS VALORES AL ARRAY
						l.setCategorias((ArrayList<String>) categorias);
					}
				} catch (Exception ex) {
					erroresLibrosDAO.add("Se Produjo un error al consultar las Categorias!");
				}

				// ------- CONSULTA DE EDITORIAL -------
				try {
					if (l.getEditorial() == null) {
						String queryLibro = "SELECT Editorial FROM BibliotecaV2.Editoriales WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String editorial = "";

						while (r.next()) {
							editorial = r.getString(1);
						}

						l.setEditorial(editorial);

					}
				} catch (Exception ex) {
					erroresLibrosDAO.add("Se produjo un error al Consultar la Editorial!");
				}

				// Guardamos en la lista
				libros.add(l);
			}

			rs.close();
			return libros;

		} catch (Exception ex) {
			erroresLibrosDAO.add("Se Produjo un Error al consultar los Libros!");
			return null;
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo que se encarga de Insertar un libro hacia la tabla Libros. El Metodo
	 * recibe 4 parametros, un objeto libro y 3 listas de tipo String. Como primer
	 * paso realiza la insercion del libro en la tabla libros, luego recorre las
	 * listas tanto de idiomas, autores, categorias para luego consultar si en sus
	 * respectivas tablas existen, si existen se agrega el ISBN del libro
	 * directamente al la tabla Libro_Autor o idioma o caegoria. Si no existe, se
	 * inserta un nuevo autor, idioma o categoria y se le agrega el ISBN a su tabla
	 * Libro_idioma o autor o categoria. Y asi susecivamente. Finalmente al
	 * terminar, se muestra en la consola un mensaje de confirmacion.
	 * 
	 * 
	 * @author Camilo Moya
	 * @param libro
	 * @param idiomas
	 * @param autores
	 * @param categorias
	 * @exception Agrega el error a la lista erroresLibrosDAO
	 */
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

			// PREGUNTAR Y GUARDAMOS LOS PARAMETROS EN LA TABLA AUTOR
			try {
				db.conectar();
				for (String autor : autores) {
					String query = "SELECT idAutor, Nombre, ApellidoPa, ApellidoMa FROM BibliotecaV2.Autores";
					PreparedStatement s = db.getCon().prepareStatement(query);
					ResultSet rs = s.executeQuery();

					int exist = 0;
					while (rs.next()) {
						if (autor.equalsIgnoreCase(rs.getString(2).trim())) {
							System.out.println("Autor Registrado");

							String query3 = "INSERT INTO Libro_Autor(ISBN, idAutor) VALUES(?,?)";
							PreparedStatement t = db.getCon().prepareStatement(query3);
							t.setString(1, libro.getIsbn());
							t.setInt(2, rs.getInt(1));
							t.executeUpdate();

							exist++;
						}

					}

					if (exist == 0) {
						String query2 = "INSERT INTO Autores(Nombre) VALUES(?)";
						PreparedStatement p = db.getCon().prepareStatement(query2);
						p.setString(1, autor);
						p.executeUpdate();

						// PREGUNTAR Y GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_AUTOR
						int idAutor = 0;
						String query1 = "SELECT idAutor, Nombre FROM Autores WHERE Nombre =?";
						PreparedStatement so = db.getCon().prepareStatement(query1);
						so.setString(1, autor);
						ResultSet r = so.executeQuery();
						while (r.next()) {
							idAutor = r.getInt(1);
						}

						String query3 = "INSERT INTO Libro_Autor(ISBN, idAutor) VALUES(?,?)";
						PreparedStatement t = db.getCon().prepareStatement(query3);
						t.setString(1, libro.getIsbn());
						t.setInt(2, idAutor);
						t.executeUpdate();
					}

				}

			} catch (Exception ex) {
				erroresLibrosDAO.add("Se Produjo un Error al ingresar los Autores!");
			} finally {
				db.desconectar();
			}

			// PREGUNTAMOS Y GUARDAMOS LOS PARAMETROS EN LA TABLA IDIOMAS
			try {
				db.conectar();
				for (String idioma : idiomas) {
					String query = "SELECT idIdioma, Idioma FROM BibliotecaV2.Idiomas";
					PreparedStatement s = db.getCon().prepareStatement(query);
					ResultSet rs = s.executeQuery();

					int exist = 0;
					while (rs.next()) {
						if (idioma.equalsIgnoreCase(rs.getString(2).trim())) {
							System.out.println("Idioma Registrado");

							String query3 = "INSERT INTO Libro_Idioma(ISBN, idIdioma) VALUES(?,?)";
							PreparedStatement t = db.getCon().prepareStatement(query3);
							t.setString(1, libro.getIsbn());
							t.setInt(2, rs.getInt(1));
							t.executeUpdate();
							exist++;
						}

					}
					// GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_IDIOMA
					if (exist == 0) {
						String query2 = "INSERT INTO Idiomas(Idioma) VALUES(?)";
						PreparedStatement p = db.getCon().prepareStatement(query2);
						p.setString(1, idioma);
						p.executeUpdate();

						// PREGUNTAR Y GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_AUTOR
						int idIdioma = 0;
						String query1 = "SELECT idIdioma, Idioma FROM Idiomas WHERE Idioma =?";
						PreparedStatement so = db.getCon().prepareStatement(query1);
						so.setString(1, idioma);
						ResultSet r = so.executeQuery();
						while (r.next()) {
							idIdioma = r.getInt(1);
						}

						String query3 = "INSERT INTO Libro_Idioma(ISBN, idIdioma) VALUES(?,?)";
						PreparedStatement t = db.getCon().prepareStatement(query3);
						t.setString(1, libro.getIsbn());
						t.setInt(2, idIdioma);
						t.executeUpdate();
					}

				}

				System.out.println("Idioma Ingresado con EXITO!");

			} catch (Exception ex) {
				erroresLibrosDAO.add("Se Produjo un Error al ingresar el Idioma!");
			} finally {
				db.desconectar();
			}

			// GUARDAMOS LOS PARAMETROS EN LA TABLA CATEGORIAS
			try {
				db.conectar();
				for (String categoria : categorias) {
					String query = "SELECT idCategoria, Categoria FROM BibliotecaV2.Categorias";
					PreparedStatement s = db.getCon().prepareStatement(query);
					ResultSet rs = s.executeQuery();

					int exist = 0;
					while (rs.next()) {
						if (categoria.equalsIgnoreCase(rs.getString(2).trim())) {
							System.out.println("Categoria Registrada");

							String query3 = "INSERT INTO Libro_Categoria(ISBN, idCategoria) VALUES(?,?)";
							PreparedStatement t = db.getCon().prepareStatement(query3);
							t.setString(1, libro.getIsbn());
							t.setInt(2, rs.getInt(1));
							t.executeUpdate();

							exist++;
						}

					}
					// GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_CATEGORIAS
					if (exist == 0) {
						String query2 = "INSERT INTO Categorias(Categoria) VALUES(?)";
						PreparedStatement p = db.getCon().prepareStatement(query2);
						p.setString(1, categoria);
						p.executeUpdate();

						// PREGUNTAR Y GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_AUTOR
						int idCategoria = 0;
						String query1 = "SELECT idCategoria, Categoria FROM Categorias WHERE Categoria =?";
						PreparedStatement so = db.getCon().prepareStatement(query1);
						so.setString(1, categoria);
						ResultSet r = so.executeQuery();
						while (r.next()) {
							idCategoria = r.getInt(1);
						}

						String query3 = "INSERT INTO Libro_Categoria(ISBN, idCategoria) VALUES(?,?)";
						PreparedStatement t = db.getCon().prepareStatement(query3);
						t.setString(1, libro.getIsbn());
						t.setInt(2, idCategoria);
						t.executeUpdate();
					}

				}

				System.out.println("Categoria Ingresada con EXITO!");

			} catch (Exception ex) {
				erroresLibrosDAO.add("Se Produjo un Error al ingresar la Categoria!");
			} finally {
				db.desconectar();
			}

			// INSERTAR LA EDITORIAL
			try {
				db.conectar();

				String query = "INSERT INTO Editoriales(ISBN, Editorial) VALUES(?,?)";
				PreparedStatement sta = db.getCon().prepareStatement(query);
				sta.setString(1, libro.getIsbn());
				sta.setString(2, libro.getEditorial());
				sta.executeUpdate();

				System.out.println("Se registro le Editorial con EXITO!");
			} catch (Exception ex) {
				erroresLibrosDAO.add("Se Produjo un Error al ingresar la Editorial!");
			} finally {
				db.desconectar();
			}

			System.out.println("Libro Ingresado Con EXITO!!");

		} catch (Exception ex) {
			erroresLibrosDAO.add("Se Produjo un error al Insertar el Libro!");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de Actualizar el Precio del Libro. Recibe 1 parametro, un
	 * objeto libro del cual se extraen los datos para realizar la consulta de
	 * Update. Si todo sale bien , finalmente se muestra un mensaje de confirmacion
	 * en la consola.
	 * 
	 * @author Camilo Moya
	 * @param libro
	 * @exception Agrega el error a la lista erroresLibrosDAO
	 */
	public void updatePrecioLibro(Libro libro) {
		try {
			db.conectar();
			String query = "UPDATE BibliotecaV2.Libros SET Precio =? WHERE ISBN =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, libro.getPrecio());
			st.setString(2, libro.getIsbn());
			st.executeUpdate();
			System.out.println("Actualizado con exito!");
		} catch (Exception ex) {
			erroresLibrosDAO.add("Se Produjo un problema al Actualizar el Precio del Libro!");
		} finally {
			db.desconectar();
		}
	}

	/**
	 * Metodo encargado de Eliminar un Libro. Recibe 1 parametro, un objeto Libro,
	 * del cual se extrae su ISBN unico para realizar una qeury con sentencia WHERE
	 * ISBN = libro.getIsbn(). Una vez realizada la eliminacion se muestra en
	 * consola un mensaje de Confirmacion.
	 * 
	 * @author Camilo Moya
	 * @param libro
	 * @exception Agrega el error a la lista erroresLibrosDAO
	 */
	public void deleteLibro(Libro libro) {
		try {
			db.conectar();
			String query = "DELETE FROM BibliotecaV2.Libros WHERE ISBN =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, libro.getIsbn());

			st.executeUpdate();

			System.out.println("Libro Eliminado con EXITO!");

		} catch (Exception ex) {
			erroresLibrosDAO.add("Se Produjo un error al Eliminar el Libro!");
		} finally {
			db.desconectar();
		}
	}
	
	public Libro findByISBN(String ISBN) {
		try {
			
			db.conectar();
			// CONSULTA DIRECTA A LA TABLA LIBROS
			String query = "SELECT ISBN,Titulo,NumPagina,Precio,AnioPublicacion FROM BibliotecaV2.Libros where ISBN=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, ISBN);
			ResultSet rs = st.executeQuery();
			erroresLibrosDAO.add("ESTO ES una PRUEBA de ERROR!");

			// ----- COMIENZAN CONSULTAS PARA LA CREACION DE LOS LIBROS ------
			Libro libro = new Libro();
			while (rs.next()) {
				
				libro.setIsbn(rs.getString(1));
				libro.setTitulo(rs.getString(2));
				libro.setNumPagina(rs.getInt(3));
				libro.setPrecio(rs.getInt(4));
				libro.setAnioPublicacion(Integer.parseInt(rs.getString(5)));

				// ---- CONSULTA IDIOMAS ----
				try {
					if (libro.getIdiomas() == null) {
						String queryLibro = "SELECT ISBN,idIdioma FROM BibliotecaV2.Libro_Idioma WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String isbn = "";
						int idIdioma = 0;

						List<String> idiomas = new ArrayList<String>();

						while (r.next()) {
							isbn = r.getString(1);
							idIdioma = r.getInt(2);

							String queryIdioma = "SELECT Idioma FROM BibliotecaV2.Idiomas WHERE idIdioma=?";
							PreparedStatement c = db.getCon().prepareStatement(queryIdioma);
							c.setInt(1, idIdioma);
							ResultSet re = c.executeQuery();

							for (int i = 1; i < 5; ++i) {
								while (re.next()) {
									if (re.getString(i) == null) {
										System.out.println("No existen Idiomas!");
									} else {
										idiomas.add(re.getString(i));
									}
								}
							}
						}

						// ASIGNAMOS LOS VALORES AL ARRAYLIST DE IDIOMAS LIBRO
						libro.setIdiomas((ArrayList<String>) idiomas);

					}

				} catch (Exception ex) {
					erroresLibrosDAO.add("Se Produjo un Error al Consultar el Idioma!");
				}

				// ------- CONSULTA DE AUTORES -------
				try {
					if (libro.getAutores() == null) {
						String queryLibro = "SELECT ISBN,idAutor FROM BibliotecaV2.Libro_Autor WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String isbn = "";
						int idAutor = 0;

						List<String> autores = new ArrayList<String>();

						while (r.next()) {
							isbn = r.getString(1);
							idAutor = r.getInt(2);

							String queryAutor = "SELECT Nombre FROM BibliotecaV2.Autores WHERE idAutor=?";
							PreparedStatement c = db.getCon().prepareStatement(queryAutor);
							c.setInt(1, idAutor);
							ResultSet re = c.executeQuery();

							for (int i = 1; i < 5; ++i) {
								while (re.next()) {
									if (re.getString(i) == null) {
										System.out.println("No existen Autores!");
									} else {
										autores.add(re.getString(i));
									}
								}
							}
						}
						// ASIGNAMOS LOS VALORES AL ARRAY
						libro.setAutores((ArrayList<String>) autores);
					}
				} catch (Exception ex) {
					erroresLibrosDAO.add("Se Produjo un Error al Consultar los Autores!");
				}

				// ------- CONSULTA DE CATEGORIAS -------
				try {
					if (libro.getCategorias() == null) {
						String queryLibro = "SELECT ISBN,idCategoria FROM BibliotecaV2.Libro_Categoria WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String isbn = "";
						int idCategoria = 0;

						List<String> categorias = new ArrayList<String>();

						while (r.next()) {
							isbn = r.getString(1);
							idCategoria = r.getInt(2);

							String queryCate = "SELECT Categoria FROM BibliotecaV2.Categorias WHERE idCategoria=?";
							PreparedStatement c = db.getCon().prepareStatement(queryCate);
							c.setInt(1, idCategoria);
							ResultSet re = c.executeQuery();

							for (int i = 1; i < 5; ++i) {
								while (re.next()) {
									if (re.getString(i) == null) {
										System.out.println("No existen Autores!");
									} else {
										categorias.add(re.getString(i));
									}
								}
							}
						}
						// ASIGNAMOS LOS VALORES AL ARRAY
						libro.setCategorias((ArrayList<String>) categorias);
					}
				} catch (Exception ex) {
					erroresLibrosDAO.add("Se Produjo un error al consultar las Categorias!");
				}

				// ------- CONSULTA DE EDITORIAL -------
				try {
					if (libro.getEditorial() == null) {
						String queryLibro = "SELECT Editorial FROM BibliotecaV2.Editoriales WHERE ISBN=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();

						String editorial = "";

						while (r.next()) {
							editorial = r.getString(1);
						}

						libro.setEditorial(editorial);

					}
				} catch (Exception ex) {
					erroresLibrosDAO.add("Se produjo un error al Consultar la Editorial!");
				}

				// Guardamos en la lista
				//libros.add(l);
			}

			rs.close();
			return libro;

		} catch (Exception ex) {
			erroresLibrosDAO.add("Se Produjo un Error al consultar los Libros!");
			return null;
		} finally {
			db.desconectar();
		}
	}
	
}
