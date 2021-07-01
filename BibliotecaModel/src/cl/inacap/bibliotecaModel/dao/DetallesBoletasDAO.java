package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cl.inacap.bibliotecaModel.dto.Boleta;

import cl.inacap.bibliotecaModel.dto.DetalleBoleta;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesBoletasDAO {
	
	private DB db = new DB();
	
	public List<DetalleBoleta> getAll(){
		try {
			
			List<DetalleBoleta> detalles = new ArrayList<DetalleBoleta>();
			db.conectar();
			
			String query = "SELECT Folio,NumSerie,PrecioLibroNeto,CantidadLibros,PrecioLibroIVA,IVA FROM BibliotecaV2.DetalleBoletas";
			PreparedStatement st = db.getCon().prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				DetalleBoleta d = new DetalleBoleta();
				d.setFolio(rs.getInt(1));
				d.setNumSerie(rs.getInt(2));
				d.setPrecioLibroNeto(rs.getInt(3));
				d.setCantidadLibro(rs.getInt(4));
				d.setPrecioLibroIva(rs.getInt(5));
				d.setIva(rs.getInt(6));

				
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
	
		public List<DetalleBoleta> getDetalles(Boleta boleta){
			try {
				List<DetalleBoleta> detalles = new ArrayList<DetalleBoleta>();
				db.conectar();
				
				String query = "SELECT Folio,NumSerie,PrecioLibroNeto,CantidadLibros,PrecioLibroIVA,IVA FROM BibliotecaV2.DetalleBoletas WHERE Folio=?";
				PreparedStatement st = db.getCon().prepareStatement(query);
				st.setInt(1, boleta.getFolio());
				
				ResultSet rs = st.executeQuery();
				while(rs.next()) {
					DetalleBoleta d = new DetalleBoleta();
					d.setFolio(rs.getInt(1));
					d.setNumSerie(rs.getInt(2));
					d.setPrecioLibroNeto(rs.getInt(3));
					d.setCantidadLibro(rs.getInt(4));
					d.setPrecioLibroIva(rs.getInt(5));
					d.setIva(rs.getInt(6));
					
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
