/**
 * 
 */
package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Compra;
import cl.inacap.bibliotecaModel.dto.DetalleCompra;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesComprasDAO {
	
	private DB db = new DB();
	
	public static List<String> erroresDetallesCompras = new ArrayList<String>();
	
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
	
	
	public List<DetalleCompra> getDetalles(Compra compra){
		try {
			List<DetalleCompra> detalles = new ArrayList<DetalleCompra>();
			db.conectar();
			
			String query = "SELECT idDetalleCompra, idCompra, Folio, NumSerie, idDistribuidor, LibroComprado, CantidadLibros FROM BibliotecaV2.DetalleCompras  WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, compra.getFolio());
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DetalleCompra d = new DetalleCompra();
				d.setIdCompra(rs.getInt(1));
				d.setIdCompra(rs.getInt(2));
				d.setFolio(rs.getInt(3));
				d.setNumSerie(rs.getInt(4));
				d.setIdDistribuidor(rs.getInt(5));
				d.setLibroComprado(rs.getString(6));
				d.setCantidadLibro(rs.getInt(7));
				
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
	
	public void insertDetalleCompra(List<Ejemplar> ejemplares,Factura factura, Compra compra, Distribuidor distribuidor) {
		try {
			db.conectar();
			
			for(Ejemplar ejemplar : ejemplares) {
				String query = "INSERT INTO DetalleCompras(idCompra, Folio, NumSerie, idDistribuidor, LibroComprado, CantidadLibros) VALUES(?,?,?,?,?,?)";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, compra.getIdCompra());
				st.setInt(2, factura.getFolio());
				st.setInt(3, ejemplar.getNumSerie());
				st.setInt(4, distribuidor.getIdDistribuidor());
				st.setString(5, ejemplar.getTitulo());
				st.setInt(6, 1);
				
				st.executeUpdate();
				
				System.out.println("Detalle Compra Ingresado con Exito!");
			}
			
		}catch(Exception ex) {
			erroresDetallesCompras.add("Se Produjo un error al ingresar el Detalle");
		}finally {
			db.desconectar();
		}
	}
	
	public void updateDetalleCompra() {
		try {
			db.conectar();
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
	
}
