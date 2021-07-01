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
		
			System.out.println("Se Produjo un error al consultar");
			return null;
		
		}finally {
			db.desconectar();
		}
	
	
	
	}	
	
}
