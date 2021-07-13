package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Compra;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

public class ComprasDAO {
	
	private DB db = new DB();
	
	public static List<String> erroresComprasDAO = new ArrayList<String>();
	
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
					c.setIdDistribuidor(rs.getInt(2));
					c.setFolio(rs.getInt(3));

					
					//Guardamos en la lista
					compras.add(c);
				}
				
				rs.close();
				return compras ;
				
			}catch(Exception ex) {
				erroresComprasDAO.add("Se Produjo un error al Consultar");
				return null;
			}finally {
				db.desconectar();
			}
			
	}
		
	public void insertCompra(Compra compra, Factura factura, Distribuidor distribuidor) {
		try {
			db.conectar();
			
			String query= "INSERT INTO Compras(idCompra, idDistribuidor, Folio) VALUES(?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, compra.getIdCompra());
			st.setInt(2, distribuidor.getIdDistribuidor());
			st.setInt(3, factura.getFolio());
			
			st.executeUpdate();
			
			System.out.println("Compra ingresada con Exito!");
					
			
		}catch(Exception ex) {
			erroresComprasDAO.add("Error al Ingresar la Compra!");
		}finally {
			db.desconectar();
		}
	}
		
		
	public void updateCompra() {
		try {
			db.conectar();
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
		
		
	public void deleteCompra(Factura factura) {
		try {
			db.conectar();
			
			String query = "DELETE FROM DetalleCompras WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());
			
			st.executeUpdate();
			
			String query2 = "DELETE FROM Compras WHERE Folio=?";
			PreparedStatement s = db.getCon().prepareStatement(query2);
			s.setInt(1, factura.getFolio());
			
			s.executeUpdate();
			
			System.out.println("Compra Eliminada con Exito!");
			
			
		}catch(Exception ex) {
			erroresComprasDAO.add("Se Produjo un Error al Eliminar la Compra");
		}finally {
			db.desconectar();
		}
	}
	
	
	
}
