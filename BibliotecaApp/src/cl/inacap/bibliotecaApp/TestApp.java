package cl.inacap.bibliotecaApp;

import java.util.List;

import cl.inacap.bibliotecaModel.dao.DetallesArriendosDAO;
import cl.inacap.bibliotecaModel.dao.FacturasDAO;
import cl.inacap.bibliotecaModel.dto.DetalleArriendo;
import cl.inacap.bibliotecaModel.dto.Factura;






public class TestApp {

	public static void main(String[] args) {
		
		
		System.out.println("Hola Bienvenido a Nuestra Biblioteca!");
		List<Factura> facturas = new FacturasDAO().getAll();
		
		if(facturas.isEmpty()) {
			System.out.println("HEY! la Lista está VACIA!");
		}else {
			
			for(Factura factura : facturas) {
				System.out.println(factura);
			}
			
		}
		
		
		
		
		
	}

}
