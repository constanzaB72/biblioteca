package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.DetalleFactura;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesFacturasDAO {
	
private DB db = new DB();
	
	public List<DetalleFactura> getAll(){
		
		try {
			
			List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
			db.conectar();
			
			String query = "SELECT idDetalleFactura, Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros FROM BibliotecaV2.DetalleFacturas";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DetalleFactura d = new DetalleFactura();
				d.setIdDetalleFactura(rs.getInt(1));
				d.setFolio(rs.getInt(2));
				d.setNumSerie(rs.getInt(3));
				d.setIdDistribuidor(rs.getInt(4));
				d.setPrecioLibroNeto(rs.getInt(5));
				d.setPrecioLibroIva(rs.getInt(6));
				d.setIva(rs.getInt(7));
				d.setCantidadLibro(rs.getInt(8));

				
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
	
	
	public List<DetalleFactura> getDetalles(Factura factura){
		try {
			List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
			db.conectar();
			
			String query = "SELECT idDetalleFactura, Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros  FROM BibliotecaV2.DetalleFacturas WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DetalleFactura d = new DetalleFactura();
				d.setIdDetalleFactura(rs.getInt(1));
				d.setFolio(rs.getInt(2));
				d.setNumSerie(rs.getInt(3));
				d.setIdDistribuidor(rs.getInt(4));
				d.setPrecioLibroNeto(rs.getInt(5));
				d.setPrecioLibroIva(rs.getInt(6));
				d.setIva(rs.getInt(7));
				d.setCantidadLibro(rs.getInt(8));
				
				//GUARDAMOS EN LA LISTA
				
				detalles.add(d);
				
			}
			
			rs.close();
			return detalles;
		}catch(Exception ex) {
			System.out.println("Se produjo un error al Consultar!");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	
	
}
