package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;

public class TrabajadoresDAO {

private DB db = new DB();
	
	
	public List<Trabajador> getAll() {
		try {
			
			List<Trabajador> trabajadores = new ArrayList<Trabajador>();
			db.conectar();
			
			String query = "SELECT idTrabajador,Rut,Nombre,ApellidoMa,ApellidoPa,FechaContrato FROM BibliotecaV2.Trabajadores";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Trabajador t = new Trabajador();
				t.setIdTrabajador(Integer.parseInt(rs.getString(1)));;
				t.setRut(rs.getString(2));
				t.setNombre(rs.getString(3));
				t.setApellidoMa(rs.getString(4));
				t.setApellidoPa(rs.getString(5));
				t.setFechaContrato(rs.getString(6));
				
				
				//Guardamos en la lista
				trabajadores.add(t);
			}
			
			rs.close();
			return trabajadores;
			
		}catch(Exception ex) {
		
			System.out.println("Se Produjo un error al consultar");
			return null;
		
		}finally {
			db.desconectar();
		}
	
	
	
	}	
	
}
