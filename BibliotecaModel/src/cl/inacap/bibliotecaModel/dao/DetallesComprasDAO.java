/**
 * 
 */
package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cl.inacap.bibliotecaModel.dto.DetalleCompra;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesComprasDAO {
	
	private DB db = new DB();
	
	public List<DetalleCompra> getAll(){
		try {
			
			List<DetalleCompra> detalles = new ArrayList<DetalleCompra>();
			db.conectar();
			
			String query = "SELECT Folio,NumSerie,idDistribuidor,LibroComprado,CantidadLibros FROM BibliotecaV2.DetalleCompras";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DetalleCompra d = new DetalleCompra();
				d.setLibroComprado(rs.getString(4));
				d.setCantidadLibro(rs.getInt(5));
				
				//Guardamos en la lista
				detalles.add(d);
			}
			
			rs.close();
			return detalles;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	
}
