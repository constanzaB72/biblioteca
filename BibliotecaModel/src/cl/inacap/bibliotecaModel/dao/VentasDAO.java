package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Boleta;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.dto.Venta;
import cl.inacap.bibliotecaModel.utils.DB;

public class VentasDAO {
	
	private DB db = new DB();
	
	public static List<String> erroresVentasDAO = new ArrayList<String>();
	
	
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
	
	
	public void insertVenta(Boleta boleta, Cliente cliente, Trabajador trabajador) {
		try {
			db.conectar();
			
			String query = "INSERT INTO Ventas(idTrabajador, idCliente, Folio) VALUES(?,?,?)";
			PreparedStatement st= db.getCon().prepareStatement(query);
			st.setInt(1, trabajador.getIdTrabajador());
			st.setInt(2, cliente.getIdCliente());
			st.setInt(3, boleta.getFolio());
			
			st.executeUpdate();
			System.out.println("Venta Ingresada con EXITO!");
			
		}catch(Exception ex) {
			erroresVentasDAO.add("Se Produjo un Error al Ingresar la Venta");
		}finally {
			
		}
	}
	
	public void deleteVenta(Boleta boleta) {
		try {
			db.conectar();
			
			String query = "DELETE FROM Ventas WHERE Folio =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, boleta.getFolio());
			st.executeUpdate();
			
			System.out.println("Venta Eliminada con EXITO!");
			
		}catch(Exception ex) {
			erroresVentasDAO.add("Se Produjo un Error al Eliminar la VENTA!");
		}finally {
			db.desconectar();
		}
	}
	
	
}
