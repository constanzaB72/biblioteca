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
