package cl.inacap.bibliotecaApp;

import java.util.List;

import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Libro;



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
		
		List<Cliente> clientes = new ClientesDAO().getAll();
		
		if(clientes.isEmpty()) {
			System.out.println("La lista esta vacia!");
		}else {
			
			for(Cliente cliente : clientes) {
				System.out.println(cliente);
			}
			
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		
		List<Ejemplar> ejemplares = new EjemplarDAO().getAll();
		
		if(ejemplares.isEmpty()) {
			System.out.println("HEY! esta vacio!");
		}else {
			
			for(Ejemplar ejemplar : ejemplares) {
				System.out.println(ejemplar);
			}
			
			
		}
		
	}	
}


