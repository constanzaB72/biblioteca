package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;

public class TrabajadoresDAO {

private DB db = new DB();
public static List<String> erroresTrabajadoresDAO = new ArrayList<String>();
	
	
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
				
				if(t.getTelefonos() == null) {
					String queryLibro = "SELECT Telefono FROM BibliotecaV2.TelefonosTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					List<String> telefonos = new ArrayList<String>();
					
					while(r.next()) {
						telefonos.add(r.getString(1));
					}
					
					t.setTelefonos((ArrayList<String>) telefonos);
				}
				
				if(t.getDirecciones() == null) {
					String queryLibro = "SELECT Direccion FROM BibliotecaV2.DireccionesTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					List<String> direcciones = new ArrayList<String>();
					
					while(r.next()) {
						direcciones.add(r.getString(1));
					}
					
					t.setDirecciones((ArrayList<String>) direcciones);
				}
				
				if(t.getCorreos() == null ) {
					String queryLibro = "SELECT Correo FROM BibliotecaV2.CorreosTrabajadores WHERE idTrabajador=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
					List<String> correos = new ArrayList<String>();
					
					while(r.next()) {
						correos.add(r.getString(1));
					}
					
					t.setCorreos((ArrayList<String>) correos);
					
				}
				
				//Guardamos en la lista
				trabajadores.add(t);
			}
			
			rs.close();
			return trabajadores;
			
		}catch(Exception ex) {
			erroresTrabajadoresDAO.add("Se Produjo un error al consultar");
			return null;
		
		}finally {
			db.desconectar();
		}
	
	
	
	}	
	
	public void insertTrabajador(Trabajador trabajador, List<String> telefonos, List<String> correos, List<String> direcciones) {
		try {
			db.conectar();
			
			String query = "INSERT INTO Trabajadores(Rut, Nombre, ApellidoMa, ApellidoPa, FechaContrato, Password) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, trabajador.getRut());
			st.setString(2, trabajador.getNombre());
			st.setString(3, trabajador.getApellidoMa());
			st.setString(4, trabajador.getApellidoPa());
			st.setString(5, trabajador.getFechaContrato());
			st.setString(6, trabajador.getPassword());
			
			st.executeUpdate();
			
			String queryIdCliente = "SELECT idTrabajador FROM BibliotecaV2.Trabajadores WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdCliente);
			o.setString(1, trabajador.getRut());
			ResultSet rs = o.executeQuery();
			
			while(rs.next()) {
				String queryTel = "INSERT INTO TelefonosTrabajadores(idTrabajador, Telefono) VALUES(?,?)";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				for(String telefono : telefonos) {
					s.setInt(1, rs.getInt(1));
					s.setString(2, telefono);
					s.executeUpdate();
				}
				
				String queryCorre = "INSERT INTO CorreosTrabajadores(idTrabajador, Correo) VALUES(?,?)";
				PreparedStatement p = db.getCon().prepareStatement(queryCorre);
				for(String correo : correos) {
					p.setInt(1, rs.getInt(1));
					p.setString(2, correo);
					p.executeUpdate();
				}
				
				String queryDire = "INSERT INTO DireccionesTrabajadores(idTrabajador, Direccion) VALUES(?,?)";
				PreparedStatement t = db.getCon().prepareStatement(queryDire);
				for(String direccion : direcciones) {
					t.setInt(1, rs.getInt(1));
					t.setString(2, direccion);
					t.executeUpdate();
				}
				System.out.println("Trabajador Ingresado con EXITO!");
			}
			
			
		}catch(Exception ex) {
			erroresTrabajadoresDAO.add("Se Produjo un Error al Ingresar el trabajador");
		}finally {
			db.desconectar();
		}
	}
	
	
	public void updateTrabajador() {
		try {
			db.conectar();
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
	
	public void deleteTrabajador(Trabajador trabajador) {
		try {
			db.conectar();
			
			String queryIdTrabajador = "SELECT idTrabajador FROM BibliotecaV2.Trabajadores WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdTrabajador);
			o.setString(1, trabajador.getRut());
			ResultSet rs = o.executeQuery();
			
			while(rs.next()) {
				String queryTel = "DELETE FROM TelefonosTrabajadores WHERE idTrabajador =?";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				s.setInt(1, rs.getInt(1));
				s.executeUpdate();
				
				String queryCorre = "DELETE FROM CorreosTrabajadores WHERE idTrabajador =?";
				PreparedStatement t = db.getCon().prepareStatement(queryCorre);
				t.setInt(1, rs.getInt(1));
				t.executeUpdate();
				
				String queryDirec = "DELETE FROM DireccionesTrabajadores WHERE idTrabajador =?";
				PreparedStatement p = db.getCon().prepareStatement(queryDirec);
				p.setInt(1, rs.getInt(1));
				p.executeUpdate();
				
				
				String query = "DELETE FROM Trabajadores WHERE idTrabajador =?";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, rs.getInt(1));
				st.executeUpdate();
				
				System.err.print("Trabajador Eliminado con EXITO!");
			}
			
			
			
		}catch(Exception ex) {
			erroresTrabajadoresDAO.add("Error al eliminar el Trabajador!");
		}finally {
			db.desconectar();
		}
	}
	
	
//Login
	public boolean usuarioValido(String usuario, String password) {		
		try {
			db.conectar();
			String query = "SELECT Rut,Password FROM BibliotecaV2.Trabajadores where Rut = ? and Password = ?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, usuario);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				rs.close();
				return true;			
			}
			return  false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}finally {
			db.desconectar();
		}
	}
	
}
