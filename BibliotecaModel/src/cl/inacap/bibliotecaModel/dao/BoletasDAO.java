package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Boleta;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;

public class BoletasDAO {
	
	private DB db = new DB();
	
	public static List<String> erroresBoletasDAO = new ArrayList<String>();
	
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
				b.setIdCliente(rs.getInt(2));
				b.setIdTrabajador(rs.getInt(3));
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
	
	
	public void insertBoleta(Boleta boleta, Cliente cliente, Trabajador trabajador) {
		try {
			db.conectar();
			
			
			
			String query = "INSERT INTO Boletas(Folio, idCliente, idTrabajador, FechaVenta, HoraVenta, MetodoPago) VALUES(?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, boleta.getFolio());
			st.setInt(2, cliente.getIdCliente());
			st.setInt(3, trabajador.getIdTrabajador());
			st.setString(4, boleta.getFechaVenta());
			st.setString(5, boleta.getHoraVenta());
			st.setString(6, boleta.getMetodoPago());
			
			st.executeUpdate();
			
			System.out.println("Boleta Ingresada con EXITO!");
			
			
		}catch(Exception ex) {
			erroresBoletasDAO.add("Se Produjo un Error al ingresar la Boleta");
		}finally {
			db.desconectar();
		}
	}
	
	public void updateBoleta(Boleta boleta) {
		
	}
	
	public void deleteBoleta(Boleta boleta){
		try {
			db.conectar();
			
			String queryDeta = "DELETE FROM DetalleBoletas WHERE Folio =?";
			PreparedStatement s = db.getCon().prepareStatement(queryDeta);
			s.setInt(1, boleta.getFolio());
			s.executeUpdate();
			
			
			String query = "DELETE FROM Boletas WHERE Folio =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, boleta.getFolio());
			st.executeUpdate();
			
			System.out.println("Boleta Eliminada con EXITO!");
			
		}catch(Exception ex) {
			erroresBoletasDAO.add("Se Produjo un error al Eliminar la Boleta");
		}finally {
			db.desconectar();
		}
	}
	
	
	
}
