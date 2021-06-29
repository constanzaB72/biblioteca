package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.utils.DB;

public class ArriendosDAO {
	
	private DB db = new DB();
	
	public List<Arriendo> getAll(){
		
		try {
			List<Arriendo> arriendos = new ArrayList<Arriendo>();
			db.conectar();
			
			String query = "SELECT idArriendo,FechaArriendo,FechaDevolucion,FechaEntrega,DiasRetraso,Multa,CostoTotal FROM BibliotecaV2.Arriendos";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Arriendo a = new Arriendo();
				a.setIdArriendo(Integer.parseInt(rs.getString(1)));
				a.setFechaArriendo(rs.getString(2));
				a.setFechaDevolucion(rs.getString(3));
				a.setFechaEntrega(rs.getString(4));
				a.setDiasRetraso(Integer.parseInt(rs.getString(5)));
				a.setMulta(Integer.parseInt(rs.getString(6)));
				a.setCostoTotal(rs.getInt(7));

				
				//Guardamos en la lista
				arriendos.add(a);
			}
			
			rs.close();
			return arriendos;
			
		}catch(Exception ex) {
		
			System.out.println("Se Produjo un error al consultar");
			return null;
		
		}finally {
			db.desconectar();
		}
	}
	
	
	
	
}
