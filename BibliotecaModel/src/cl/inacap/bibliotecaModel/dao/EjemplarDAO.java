package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.utils.DB;

public class EjemplarDAO {
	
private DB db = new DB();
	
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
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	}
}
