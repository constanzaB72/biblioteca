package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Venta;
import cl.inacap.bibliotecaModel.utils.DB;

public class VentasDAO {
	
	private DB db = new DB();
	
	
	public List<Venta> getAll(){
		
		
		try {
			
			List<Venta> ventas = new ArrayList<Venta>();
			db.conectar();
			
			String query = "SELECT idVenta,idTrabajador,idCliente,Folio FROM BibliotecaV2.Ventas";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Venta v = new Venta();
				v.setIdVenta(rs.getInt(1));
				v.setIdTrabajador(rs.getInt(2));
				v.setIdCliente(rs.getInt(3));
				v.setFolio(rs.getInt(4));
				
				//Guardamos en la lista
				ventas.add(v);
			}
			
			rs.close();
			return ventas;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
		

		
	}
}
