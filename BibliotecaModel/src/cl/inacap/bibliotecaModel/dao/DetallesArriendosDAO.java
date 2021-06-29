package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.DetalleArriendo;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesArriendosDAO {
	
	private DB db = new DB();
	
	
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
			System.out.println("Se Produjo un error al Consultar");
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
				//
				d.setCostoLibro(rs.getInt(2));
				
				//GUARDAMOS EN LA LISTA
				detalles.add(d);
			}
			
			rs.close();
			return detalles;
		}catch(Exception ex) {
			System.out.println("Se produjo un error al Consultar!");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
}
