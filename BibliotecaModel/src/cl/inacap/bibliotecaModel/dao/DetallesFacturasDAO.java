package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.DetalleFactura;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;

public class DetallesFacturasDAO {

	private DB db = new DB();

	public static List<String> erroresDetallesFacturasDAO = new ArrayList<String>();

	public List<DetalleFactura> getAll() {

		try {

			List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
			db.conectar();

			String query = "SELECT idDetalleFactura, Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros FROM BibliotecaV2.DetalleFacturas";
			PreparedStatement st = db.getCon().prepareStatement(query);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleFactura d = new DetalleFactura();
				d.setIdDetalleFactura(rs.getInt(1));
				d.setFolio(rs.getInt(2));
				d.setNumSerie(rs.getInt(3));
				d.setIdDistribuidor(rs.getInt(4));
				d.setPrecioLibroNeto(rs.getInt(5));
				d.setPrecioLibroIva(rs.getInt(6));
				d.setIva(rs.getInt(7));
				d.setCantidadLibro(rs.getInt(8));

				// Guardamos en la lista

				detalles.add(d);

			}

			rs.close();
			return detalles;

		} catch (Exception ex) {
			System.out.println("Se Produjo un error al Consultar");
			return null;
		} finally {
			db.desconectar();
		}

	}

	public List<DetalleFactura> getDetalles(Factura factura) {
		try {
			List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
			db.conectar();

			String query = "SELECT idDetalleFactura, Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros  FROM BibliotecaV2.DetalleFacturas WHERE Folio=?";
			PreparedStatement st = db.getCon().prepareStatement(query);
			st.setInt(1, factura.getFolio());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				DetalleFactura d = new DetalleFactura();
				d.setIdDetalleFactura(rs.getInt(1));
				d.setFolio(rs.getInt(2));
				d.setNumSerie(rs.getInt(3));
				d.setIdDistribuidor(rs.getInt(4));
				d.setPrecioLibroNeto(rs.getInt(5));
				d.setPrecioLibroIva(rs.getInt(6));
				d.setIva(rs.getInt(7));
				d.setCantidadLibro(rs.getInt(8));

				// GUARDAMOS EN LA LISTA

				detalles.add(d);

			}

			rs.close();
			return detalles;
		} catch (Exception ex) {
			System.out.println("Se produjo un error al Consultar!");
			return null;
		} finally {
			db.desconectar();
		}
	}

	public void insertDetalleFactura(List<Ejemplar> ejemplares, List<Libro> libros, Factura factura,
			Distribuidor distribuidor) {
		try {
			db.conectar();

			String query1 = "SELECT NumSerie FROM BibliotecaV2.DetalleFacturas";
			PreparedStatement s = db.getCon().prepareStatement(query1);

			ResultSet rs = s.executeQuery();

			while (rs.next()) {
				for (Ejemplar ejemplar : ejemplares) {
					if (ejemplar.getNumSerie() != rs.getInt(1)) {
						for (Libro libro : libros) {
							if (ejemplar.getIsbn() == libro.getIsbn()) {
								int costoIva = (libro.getPrecio()) + (int) (libro.getPrecio() * 0.19);
								int iva = (int) (libro.getPrecio() * 0.19);

								String query = "INSERT INTO DetalleFacturas(Folio, NumSerie, idDistribuidor, PrecioLibroNeto, PrecioLibroIVA, IVA, CantidadLibros) VALUES(?,?,?,?,?,?,?)";
								PreparedStatement st = db.getCon().prepareStatement(query);
								st.setInt(1, factura.getFolio());
								st.setInt(2, ejemplar.getNumSerie());
								st.setInt(3, distribuidor.getIdDistribuidor());
								st.setInt(4, libro.getPrecio());
								st.setInt(5, costoIva);
								st.setInt(6, iva);
								st.setInt(7, 1);

								st.executeUpdate();

								System.out.println("Detalle Ingresado con Exito!");
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			erroresDetallesFacturasDAO.add("Error al Insertar los Detalles");
		} finally {
			db.desconectar();
		}
	}

	public void updateDetalleFactura(Factura factura) {
		try {
			db.conectar();
		} catch (Exception ex) {

		} finally {
			db.desconectar();
		}
	}

}
