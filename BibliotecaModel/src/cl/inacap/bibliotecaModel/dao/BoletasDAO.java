package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Boleta;
import cl.inacap.bibliotecaModel.utils.DB;

public class BoletasDAO {
	
	private DB db = new DB();
	
	public List<Boleta> getAll(){
		
		try {
			
			List<Boleta> boletas = new ArrayList<Boleta>();
			db.conectar();
			
			String query = "SELECT Folio,idCliente,idTrabajador,FechaVenta,HoraVenta,MetodoPago FROM BibliotecaV2.Boletas";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Boleta b = new Boleta();
				b.setFolio(rs.getInt(1));
				//b.setCliente(rs.getString(2));
				//b.setTrabajador(rs.getString(3));
				b.setFechaVenta(rs.getString(4));
				b.setHoraVenta(rs.getString(5));
				b.setMetodoPago(rs.getString(6));

				
				//Guardamos en la lista
				boletas.add(b);
			}
			
			rs.close();
			return boletas;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	
	}
}
