package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.utils.DB;

public class DistribuidorDAO {
	
private DB db = new DB();
	
	public List<Distribuidor> getAll(){
		
		try {
			
			List<Distribuidor> distribuidores = new ArrayList<Distribuidor>();
			db.conectar();
			
			String query = "SELECT idDistribuidor, Rut, NombreEmpresa, AnioVinculo, Direccion, Telefono FROM BibliotecaV2.Distribuidores";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Distribuidor d = new Distribuidor();
				d.setIdDistribuidor(rs.getInt(1));
				d.setRut(rs.getString(2));
				d.setNombreEmpresa(rs.getString(3));
				d.setAnioVinculo(rs.getInt(4));
				d.setDireccion(rs.getString(5));
				d.setTelefono(rs.getString(6));

				
				//Guardamos en la lista
				
				distribuidores.add(d);
			}
			
			rs.close();
			return distribuidores;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	
}
