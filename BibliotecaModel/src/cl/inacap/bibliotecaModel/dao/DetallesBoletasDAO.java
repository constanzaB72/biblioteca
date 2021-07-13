package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cl.inacap.bibliotecaModel.dto.Boleta;

import cl.inacap.bibliotecaModel.dto.DetalleBoleta;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesBoletasDAO {
	
	private DB db = new DB();
	
	public static List<String> erroresDetallesBoletaDAO = new ArrayList<String>();
	
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
		
		
		public void insertDetalles(List<Ejemplar> ejemplares, List<Libro> libros, Boleta boleta) {
			try {
				db.conectar();
				
				String query1 = "SELECT NumSerie FROM BibliotecaV2.DetalleBoletas";
				PreparedStatement s = db.getCon().prepareStatement(query1);

				ResultSet rs = s.executeQuery();

				while (rs.next()) {
					for (Ejemplar ejemplar : ejemplares) {
						if (ejemplar.getNumSerie() != rs.getInt(1)) {
							for (Libro libro : libros) {
								if (ejemplar.getIsbn() == libro.getIsbn()) {
									int costoIva = (libro.getPrecio()) + (int) (libro.getPrecio() * 0.19);
									int iva = (int) (libro.getPrecio() * 0.19);

									String query = "INSERT INTO DetalleBoletas(Folio, NumSerie, PrecioLibroNeto, CantidadLibros, PrecioLibroIVA, IVA) VALUES(?,?,?,?,?,?)";
									PreparedStatement st = db.getCon().prepareStatement(query);
									st.setInt(1, boleta.getFolio());
									st.setInt(2, ejemplar.getNumSerie());
									st.setInt(3, libro.getPrecio());
									st.setInt(4, 1);
									st.setInt(5, costoIva);
									st.setInt(6, iva);
								

									st.executeUpdate();

									System.out.println("Detalle Ingresado con Exito!");
								}
							}
						}
					}
				}
				
				
				
				
				
				
			}catch(Exception ex) {
				erroresDetallesBoletaDAO.add("Se Produjo un Error al ingresar los detalles");
			}finally {
				db.desconectar();
			}
		}
	
		
}
