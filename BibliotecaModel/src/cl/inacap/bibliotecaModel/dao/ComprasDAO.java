package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Compra;
import cl.inacap.bibliotecaModel.utils.DB;

public class ComprasDAO {
	
	private DB db = new DB();
	
	public List<Compra> getAll(){
			
			try {
				
				List<Compra> compras = new ArrayList<Compra>();
				db.conectar();
				
				String query = "SELECT idCompra,idDistribuidor,Folio FROM BibliotecaV2.Compras";
				PreparedStatement st = db.getCon().prepareStatement(query);
				
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					Compra c = new Compra();
					c.setIdCompra(rs.getInt(1));
					//c.setDistribuidor(rs.getInt(2));
					//c.setBoleta(rs.getInt(3));

					
					//Guardamos en la lista
					compras.add(c);
				}
				
				rs.close();
				return compras ;
				
			}catch(Exception ex) {
				System.out.println("Se Produjo un error al Consultar");
				return null;
			}finally {
				db.desconectar();
			}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
