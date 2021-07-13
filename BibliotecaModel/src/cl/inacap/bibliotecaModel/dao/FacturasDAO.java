package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

public class FacturasDAO {
	
	
	private DB db = new DB();
	
	public static List<String> erroresFacturasDAO = new ArrayList<String>();
	
	public List<Factura> getAll(){
		try {
			
			List<Factura> facturas = new ArrayList<Factura>();
			db.conectar();
			
			String query = "SELECT Folio,FechaCompra,HoraCompra,MetodoPago FROM BibliotecaV2.Facturas";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Factura f = new Factura();
				f.setFolio(rs.getInt(1));
				f.setFechaCompra(rs.getString(2));
				f.setHoraCompra(rs.getString(3));
				f.setMetodoPago(rs.getString(4));

				//Guardamos en la lista
				facturas.add(f);
			}
			
			rs.close();
			return facturas;
			
		}catch(Exception ex) {
			erroresFacturasDAO.add("Se Produjo un error al Consultar las Facturas");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	public void insertFactura(Factura factura) {
		try {
			db.conectar();
			
			String query = "INSERT INTO Facturas(Folio,FechaCompra,HoraCompra,MetodoPago) VALUES(?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());
			st.setString(2, factura.getFechaCompra());
			st.setString(3, factura.getHoraCompra());
			st.setString(4, factura.getMetodoPago());
			
			st.executeUpdate();
			
			System.out.println("Factura Ingresada con Exito!");
			
		}catch(Exception ex) {
			erroresFacturasDAO.add("Se Produjo un error al ingresar la Factura");
		}finally {
			db.desconectar();
		}
	}
	
	public void updateFactura(Factura factura) {
		try {
			db.conectar();
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
	
	 public void deleteFactura(Factura factura) {
		 try {
				db.conectar();
				
				String query = "DELETE FROM DetalleFacturas WHERE Folio=?";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, factura.getFolio());
				
				st.executeUpdate();
				
				String query2 = "DELETE FROM Facturas WHERE Folio=?";
				PreparedStatement s = db.getCon().prepareStatement(query2);
				s.setInt(1, factura.getFolio());
				
				s.executeUpdate();
				
				System.out.println("Factura Eliminada con Exito!");
				
				
			}catch(Exception ex) {
				erroresFacturasDAO.add("Se Produjo un error al Eliminar la Factura!");
			}finally {
				db.desconectar();
			}
	 }
	
}
