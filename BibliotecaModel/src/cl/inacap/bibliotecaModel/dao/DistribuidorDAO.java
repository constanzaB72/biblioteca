package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.utils.DB;

public class DistribuidorDAO {
	
private DB db = new DB();

public static List<String> erroresDistribuidoresDAO = new ArrayList<String>();
	
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
			erroresDistribuidoresDAO.add("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	public void insertDistribuidor(Distribuidor distribuidor) {
		try {
			db.conectar();
			
			String query = "INSERT INTO Distribuidores(idDistribuidor, Rut, NombreEmpresa, AnioVinculo, Direccion, Telefono) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, distribuidor.getIdDistribuidor());
			st.setString(2, distribuidor.getRut());
			st.setString(3, distribuidor.getNombreEmpresa());
			st.setInt(4, distribuidor.getAnioVinculo());
			st.setString(5, distribuidor.getDireccion());
			st.setString(6, distribuidor.getTelefono());
			
			st.executeUpdate();
			
			System.out.println("Distribuidor Ingresado Con Exito!");
			
		}catch(Exception ex) {
			erroresDistribuidoresDAO.add("Se Produjo un error al ingresar el Distribuidor!");
		}finally {
			db.desconectar();
		}
	}
	
	public void updateDistribuidor(Distribuidor distribuidor, String telefono) {
		try {
			db.conectar();
			
			String query = "UPDATE BibliotecaV2.Distribuidores SET Telefono =? WHERE idDistribuidor =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, telefono);
			st.setInt(2, distribuidor.getIdDistribuidor());
			
			st.executeUpdate();
			
			System.out.println("Se Actualizó el Telefono con Exito!");
			
			
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
	
	public void deleteDistribuidor(Distribuidor distribuidor) {
		try {
			db.conectar();
			
			String query = "DELETE FROM Distribuidores WHERE idDistribuidor=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, distribuidor.getIdDistribuidor());
			st.executeUpdate();
			
			System.out.println("Distribuidor Eliminado con Exito!");
			
		}catch(Exception ex) {
			erroresDistribuidoresDAO.add("Se Produjo un error al Eliminar el Distribuidor!");
		}finally {
			db.desconectar();
		}
	}
	
}
