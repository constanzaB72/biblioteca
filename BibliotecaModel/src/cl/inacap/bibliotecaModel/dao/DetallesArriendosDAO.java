package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.DetalleArriendo;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesArriendosDAO {
	
	private DB db = new DB();
	
	public static List<String> erroresDetallesArriendo = new ArrayList<String>();
	
	public List<DetalleArriendo> getAll(){
		try {
			
			List<DetalleArriendo> detalles = new ArrayList<DetalleArriendo>();
			db.conectar();
			
			String query = "SELECT NumSerie,idArriendo,CostoLibro FROM BibliotecaV2.DetalleArriendos";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DetalleArriendo d = new DetalleArriendo();
				d.setIdDetalleArriendo(rs.getInt(2));
				d.setCostoLibro(rs.getInt(3));
				
				//Guardamos en la lista
				detalles.add(d);
			}
			
			rs.close();
			return detalles;
			
		}catch(Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al Consultar los Detalles");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	
	public List<DetalleArriendo> getDetalles(Arriendo arriendo){
		try {
			List<DetalleArriendo> detalles = new ArrayList<DetalleArriendo>();
			db.conectar();
			
			
			String query = "SELECT NumSerie,CostoLibro FROM BibliotecaV2.DetalleArriendos WHERE idArriendo=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DetalleArriendo d = new DetalleArriendo();
				d.setNumSerie(rs.getInt(1));
				d.setCostoLibro(rs.getInt(2));
				
				
				//GUARDAMOS EN LA LISTA
				detalles.add(d);
			}
			
			rs.close();
			return detalles;
		}catch(Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al consultar por el detalle del arriendo!");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	public int getCostoTotal(Arriendo arriendo, ArriendosDAO arriendoDAO) {
		try {
			List<DetalleArriendo> detalles = new ArrayList<DetalleArriendo>();
			db.conectar();
			
			int costoTotal = 0;
			
			String query = "SELECT CostoLibro FROM BibliotecaV2.DetalleArriendos WHERE idArriendo=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				costoTotal+= rs.getInt(1);
			}
			
			rs.close();
			return costoTotal+arriendoDAO.getMulta(arriendo);
		}catch(Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al consultar por el detalle del arriendo!");
			return arriendo.getCostoTotal();
		}finally {
			db.desconectar();
		}
	}
	
	public void insertDetalleArriendo(Arriendo arriendo,List<Libro> libros,List<Ejemplar> ejemplares) {
		try {
			db.conectar();
				for(Ejemplar ejemplar : ejemplares) {
					System.out.println(ejemplar);
					for(Libro libro1 : libros) {
						System.out.println(libro1);
						if(ejemplar.getIsbn() == libro1.getIsbn()) {
							String query = "INSERT INTO DetalleArriendos(NumSerie,idArriendo,CostoLibro) VALUES(?,?,?)";
							PreparedStatement st = db.getCon().prepareStatement(query);
							st.setInt(1, ejemplar.getNumSerie());
							st.setInt(2, arriendo.getIdArriendo());
							st.setInt(3, libro1.getPrecio());
							
							st.executeUpdate();
							
							System.out.println("Detalle ingresado con EXITO!!");
						}
					}
				}
				System.out.println("Finalizo!");
						
			
		}catch(Exception ex) {
			erroresDetallesArriendo.add("Se produjo un error al ingresar el detalle!");
		}finally {
			db.desconectar();
		}
	}
	
}
