package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.DetalleArriendo;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;

public class ArriendosDAO {
	
	private DB db = new DB();
	
	public static List<String> erroresArriendosDAO = new ArrayList<String>();
	
	public List<Arriendo> getAll(){
		
		try {
			List<Arriendo> arriendos = new ArrayList<Arriendo>();
			db.conectar();
			
			String query = "SELECT idArriendo,FechaArriendo,FechaDevolucion,FechaEntrega,DiasRetraso,Multa,CostoTotal FROM BibliotecaV2.Arriendos";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Arriendo a = new Arriendo();
				a.setIdArriendo(Integer.parseInt(rs.getString(1)));
				a.setFechaArriendo(rs.getString(2));
				a.setFechaDevolucion(rs.getString(3));
				a.setFechaEntrega(rs.getString(4));
				a.setDiasRetraso(Integer.parseInt(rs.getString(5)));
				a.setMulta(Integer.parseInt(rs.getString(6)));
				a.setCostoTotal(rs.getInt(7));

				
				//Guardamos en la lista
				arriendos.add(a);
			}
			
			rs.close();
			return arriendos;
			
		}catch(Exception ex) {
			erroresArriendosDAO.add("Se Produjo un Error al Consultar los Arriendos!");
			return null;
		
		}finally {
			db.desconectar();
		}
	}
	
	public void crearArriendo(Arriendo arriendo, int idCliente, int idTrabajador) {
		try {
			db.conectar();
			String query = "INSERT INTO Arriendos(idCliente, idTrabajador, FechaArriendo, FechaDevolucion, FechaEntrega, DiasRetraso, Multa, CostoTotal) VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, idCliente);
			st.setInt(2, idTrabajador);
			st.setString(3, arriendo.getFechaArriendo());
			st.setString(4, arriendo.getFechaDevolucion());
			st.setString(5, arriendo.getFechaEntrega());
			st.setInt(6, arriendo.getDiasRetraso());
			st.setInt(7, arriendo.getMulta());
			st.setInt(8, arriendo.getCostoTotal());
			
			st.executeUpdate();
			
		}catch(Exception ex) {
			erroresArriendosDAO.add("Se Produjo un Error al ingresar el Arriendo!");
		}finally {
			db.desconectar();
		}
	}
	
	public void agregarCostoTotal(DetallesArriendosDAO detalles, Arriendo arriendo, ArriendosDAO arriendoDAO) {
		try {
			db.conectar();
			String query = "UPDATE BibliotecaV2.Arriendos SET CostoTotal =? WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, detalles.getCostoTotal(arriendo, arriendoDAO));
			st.setInt(2, arriendo.getIdArriendo());
			
			st.executeUpdate();
			
			System.out.println("Se Agrego el costo!");
				
		}catch(Exception ex) {
			
		}finally {
			db.desconectar();
		}
	}
	
	public int getMulta(Arriendo arriendo) {
		try {
			db.conectar();
			int multa = 0;
			String query = "SELECT Multa FROM BibliotecaV2.Arriendos WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				multa+= rs.getInt(1);
			}
			
			rs.close();
			
			return multa ;
		}catch(Exception ex) {
			return arriendo.getMulta();
		}finally {
			db.desconectar();
		}
	}
	
	public void agregarMulta(Arriendo arriendo , int multa) {
		try {	
			db.conectar();
			String query = "UPDATE BibliotecaV2.Arriendos SET Multa =? WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, multa);
			st.setInt(2, arriendo.getIdArriendo());
			
			st.executeUpdate();
			
			System.out.println("Se Agrego la Multa!!");
			
			
		}catch(Exception ex) {
			erroresArriendosDAO.add("Se produjo un error al agregar la Multa!");
		}finally {
			db.desconectar();
		}
	}
	
	public void deleteArriendo(Arriendo arriendo) {
		try {
			db.conectar();
			
			String query = "DELETE FROM BibliotecaV2.DetalleArriendos WHERE idArriendo =?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, arriendo.getIdArriendo());
			
			st.executeUpdate();
			
			String query2 = "DELETE FROM BibliotecaV2.Arriendos WHERE idArriendo =?";
			PreparedStatement s = db.getCon().prepareStatement(query2);
			s.setInt(1, arriendo.getIdArriendo());
			
			s.executeUpdate();
			
			System.out.println("Arriendo Eliminado con Exito!");
			
			
		}catch(Exception ex) {
			erroresArriendosDAO.add("Se Produjo un error al Eliminar el Arriendo!");
		}finally {
			db.desconectar();
		}
	}
	
}
