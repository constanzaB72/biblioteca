package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Autor;
import cl.inacap.bibliotecaModel.utils.DB;

public class AutorDAO {
	
	private DB db = new DB();
	
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
