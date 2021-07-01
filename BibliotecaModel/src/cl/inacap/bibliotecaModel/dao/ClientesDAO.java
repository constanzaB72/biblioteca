package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.utils.DB;

public class ClientesDAO {
	
	
	private DB db = new DB();
	
	
	public List<Cliente> getAll() {
		try {
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			db.conectar();
			
			String query = "SELECT idCliente,Rut,Nombre,ApellidoMa,ApellidoPa,FechaNacimiento FROM BibliotecaV2.Clientes";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(Integer.parseInt(rs.getString(1)));
				c.setRut(rs.getString(2));
				c.setNombre(rs.getString(3));
				c.setApellidoMa(rs.getString(4));
				c.setApellidoPa(rs.getString(5));
				c.setFechaNacimiento(rs.getString(6));
				
				 // ---- GUARDAMOS TELEFONOS ----
				if(c.getTelefonos() == null) {
						String queryLibro = "SELECT Telefono FROM BibliotecaV2.TelefonosClientes WHERE idCliente=?";
						PreparedStatement con = db.getCon().prepareStatement(queryLibro);
						con.setString(1, rs.getString(1));
						ResultSet r = con.executeQuery();
						
					List<String> telefonos = new ArrayList<String>();
						
						while(r.next()) {
							telefonos.add(r.getString(1));
						}
					c.setTelefonos((ArrayList<String>) telefonos);
				}
				 // ---- GUARDAMOS CORREOS ----
				if(c.getCorreos() == null) {
					String queryLibro = "SELECT Correo FROM BibliotecaV2.CorreosClientes WHERE idCliente=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
				List<String> correos = new ArrayList<String>();
					
					while(r.next()) {
						correos.add(r.getString(1));
					}
					
					c.setCorreos((ArrayList<String>) correos);
				}
					// ---- GUARDAMOS LAS DIRECCIONES ----
				if(c.getDirecciones() == null) {
					String queryLibro = "SELECT Direccion FROM BibliotecaV2.DireccionesClientes WHERE idCliente=?";
					PreparedStatement con = db.getCon().prepareStatement(queryLibro);
					con.setString(1, rs.getString(1));
					ResultSet r = con.executeQuery();
					
				List<String> direcciones = new ArrayList<String>();
					
					while(r.next()) {
						direcciones.add(r.getString(1));
					}
					
					c.setDirecciones((ArrayList<String>) direcciones);
				}
				
				//Guardamos en la lista
				clientes.add(c);
			}
			
			rs.close();
			return clientes;
			
		}catch(Exception ex) {
		
			System.out.println("Se Produjo un error al consultar");
			return null;
		
		}finally {
			db.desconectar();
		}
	
	
}}
