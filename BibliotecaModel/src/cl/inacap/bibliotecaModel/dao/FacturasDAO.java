package cl.inacap.bibliotecaModel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.utils.DB;

public class FacturasDAO {
	
	
	private DB db = new DB();
	
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
			System.out.println("Se Produjo un error al Consultar");
			return null;
		}finally {
			db.desconectar();
		}
	}
	
	
	
}
