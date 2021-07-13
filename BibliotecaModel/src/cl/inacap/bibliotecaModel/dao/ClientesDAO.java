package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.utils.DB;

public class ClientesDAO {
	
	
	private DB db = new DB();
	
	public static List<String> erroresClientesDAO = new ArrayList<String>();
	
	
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
		
			erroresClientesDAO.add("Se Produjo un error al consultar");
			return null;
		
		}finally {
			db.desconectar();
		}
	
	
	}
	
	
	public void insertCliente(Cliente cliente, List<String> telefonos, List<String> correos, List<String> direcciones) {
		try {
			db.conectar();
			
			String query = "INSERT INTO Clientes(Rut, Nombre, ApellidoMa, ApellidoPa, FechaNacimiento,Password) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setString(1, cliente.getRut());
			st.setString(2, cliente.getNombre());
			st.setString(3, cliente.getApellidoMa());
			st.setString(4, cliente.getApellidoPa());
			st.setString(5, cliente.getFechaNacimiento());
			st.setString(6, cliente.getPassword());
			
			st.executeUpdate();
			
			String queryIdCliente = "SELECT idCliente FROM BibliotecaV2.Clientes WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdCliente);
			o.setString(1, cliente.getRut());
			ResultSet rs = o.executeQuery();
			
			while(rs.next()) {
				String queryTel = "INSERT INTO TelefonosClientes(idCliente, Telefono) VALUES(?,?)";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				for(String telefono : telefonos) {
					s.setInt(1, rs.getInt(1));
					s.setString(2, telefono);
					s.executeUpdate();
				}
				
				String queryCorre = "INSERT INTO CorreosClientes(idCliente, Correo) VALUES(?,?)";
				PreparedStatement p = db.getCon().prepareStatement(queryCorre);
				for(String correo : correos) {
					p.setInt(1, rs.getInt(1));
					p.setString(2, correo);
					p.executeUpdate();
				}
				
				String queryDire = "INSERT INTO DireccionesClientes(idCliente, Direccion) VALUES(?,?)";
				PreparedStatement t = db.getCon().prepareStatement(queryDire);
				for(String direccion : direcciones) {
					t.setInt(1, rs.getInt(1));
					t.setString(2, direccion);
					t.executeUpdate();
				}
			}
			

			System.out.println("Cliente ingresado con exito!");
			
			
		}catch(Exception ex) {
			erroresClientesDAO.add("Se Produjo un Error al Insertar el Cliente");
		}finally {
			db.desconectar();
		}
	}
	
	public void updateTelefono(Cliente cliente, List<String> telefonos) {
		try {
			db.conectar();
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
	
	public void deleteCliente(Cliente cliente) {
		try {
			db.conectar();
			
			String queryIdCliente = "SELECT idCliente FROM BibliotecaV2.Clientes WHERE Rut =?";
			PreparedStatement o = db.getCon().prepareStatement(queryIdCliente);
			o.setString(1, cliente.getRut());
			ResultSet rs = o.executeQuery();
			
			while(rs.next()) {
				String queryTel = "DELETE FROM TelefonosClientes WHERE idCliente =?";
				PreparedStatement s = db.getCon().prepareStatement(queryTel);
				s.setInt(1, rs.getInt(1));
				s.executeUpdate();
				
				String queryCorre = "DELETE FROM CorreosClientes WHERE idCliente =?";
				PreparedStatement t = db.getCon().prepareStatement(queryCorre);
				t.setInt(1, rs.getInt(1));
				t.executeUpdate();
				
				String queryDirec = "DELETE FROM DireccionesClientes WHERE idCliente =?";
				PreparedStatement p = db.getCon().prepareStatement(queryDirec);
				p.setInt(1, rs.getInt(1));
				p.executeUpdate();
				
				
				String query = "DELETE FROM Clientes WHERE idCliente =?";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, rs.getInt(1));
				st.executeUpdate();
			}
			
			
			
			
			System.err.println("Cliente Eliminado con EXITO!");
			
		}catch(Exception ex) {
			erroresClientesDAO.add("Se Produjo un Error Al Eliminar al Cliente!");
		}finally {
			db.desconectar();
		}
	}
	
}
