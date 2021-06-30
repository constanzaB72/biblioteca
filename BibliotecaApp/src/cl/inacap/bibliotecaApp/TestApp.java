package cl.inacap.bibliotecaApp;

import java.util.List;

import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dao.VentasDAO;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.dto.Venta;

public class TestApp {

	public static void main(String[] args) {
		
		System.out.println("Hola Bienvenido a Nuestra Biblioteca!");
		
		List<Libro> libros = new LibrosDAO().getAll();
		
		if(libros.isEmpty()) {
			System.out.println("HEY! está VACIO!");
		}else {
			
			for(Libro libro : libros) {
				System.out.println(libro);
			}
			
		}
		
		List<Venta> ventas = new VentasDAO().getAll();
		
		if(ventas.isEmpty()) {
			System.out.println("La lista esta vacia!");
		}else {
			
			for(Venta venta : ventas) {
				System.out.println(venta);
			}
			
		}
		
		
		
	}	
}


