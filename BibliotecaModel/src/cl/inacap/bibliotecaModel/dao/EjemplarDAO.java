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

public class EjemplarDAO {
	
private DB db = new DB();
public static List<String> erroresEjemplaresDAO = new ArrayList<String>();
	
	public List<Ejemplar> getAll(){
		
		try {
			
			List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
			db.conectar();
			
			String query = "SELECT NumSerie, ISBN, Titulo FROM BibliotecaV2.Ejemplares";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Ejemplar e = new Ejemplar();
				e.setNumSerie(rs.getInt(1));
				e.setIsbn(rs.getString(2));
				e.setTitulo(rs.getString(3));

				
				//Guardamos en la lista
				
				ejemplares.add(e);
				
			}
			
			rs.close();
			return ejemplares;
			
		}catch(Exception ex) {
			erroresEjemplaresDAO.add("Se Produjo un error al Consultar los Ejemplares");
			
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	public void insertEjemplar(Libro libro) {
		
		try {
			List<Ejemplar> ejemplares = new EjemplarDAO().getAll();
			Generador gen = new Generador();
			int num = gen.generarNumSerie();
			int bandera = 0;

			// PREGUNTAMOS, ESTÁ EL NUMSERIE REGISTRADO? SI NO , LO INGRESA
			for(Ejemplar ejem : ejemplares) {
				if(ejem.getNumSerie() == num) {
					System.out.println("El Numero de Serie Ya está Registrado!");
					bandera++;
				}
			}
			if(bandera == 0) {
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
			}else {
				erroresEjemplaresDAO.add("El Ejemplar ya se encuentra REGISTRADO!");
	
			}
			
			}catch(Exception ex) {
				erroresEjemplaresDAO.add("Se Produjo un Error al ingresar el Ejemplar!");
			}finally {
				db.desconectar();
			}
		
	}
	
	public void updateEstado(Ejemplar ejemplar, String estado) {
		try {
			db.conectar();
			String query = "UPDATE BibliotecaV2.Estados SET Estado =? WHERE NumSerie =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, estado);
			st.setInt(2, ejemplar.getNumSerie());
			st.executeUpdate();
			System.out.println("Actualizado con exito!");
		}catch(Exception ex) {
			erroresEjemplaresDAO.add("Se Produjo un Error al Actualizar el Estado del Ejemplar!");
			System.out.println("Error!");
		}finally {
			db.desconectar();
		}
	}
	
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
		}catch(Exception ex){
			erroresEjemplaresDAO.add("Se Produjo un error al Eliminar el Ejemplar!");
		}finally {
			db.desconectar();
		}
	}
}
