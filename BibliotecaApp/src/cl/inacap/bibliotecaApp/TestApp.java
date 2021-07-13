package cl.inacap.bibliotecaApp;


import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dao.ArriendosDAO;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.ComprasDAO;
import cl.inacap.bibliotecaModel.dao.DetallesArriendosDAO;
import cl.inacap.bibliotecaModel.dao.DetallesComprasDAO;
import cl.inacap.bibliotecaModel.dao.DetallesFacturasDAO;
import cl.inacap.bibliotecaModel.dao.DistribuidorDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.FacturasDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dto.Arriendo;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Compra;
import cl.inacap.bibliotecaModel.dto.DetalleArriendo;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.DB;
import cl.inacap.bibliotecaModel.utils.Generador;




public class TestApp {

	public static void main(String[] args) {
		
		System.out.println("Hola Bienvenido a Nuestra Biblioteca!");
		
		// ------  CARGA Y PROPAGACION DE ERRORES ENTRE CAPAS ------
		
		List<String> erroresLibros = new LibrosDAO().erroresLibrosDAO;
		List<String> erroresEjemplares = new EjemplarDAO().erroresEjemplaresDAO;
		
		
		
		List<Libro> libros = new LibrosDAO().getAll();
		
		 DB db = new DB();
		
		if(libros.isEmpty()) {
			System.out.println("HEY! está VACIO!");
		}else {
			
			for(Libro libro3 : libros) {
				System.out.println(libro3);
			}
			
		}
		
		if(erroresLibros.isEmpty()) {
			System.out.println("MMMM vacio prro");
		}else {
			for(String error : erroresLibros) {
				System.out.println(error);
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
		
		LibrosDAO libroDAO = new LibrosDAO();
		EjemplarDAO ejemplarDAO = new EjemplarDAO();
		
		Libro libro = new Libro();
		libro.setIsbn("9784166202134");
		libro.setTitulo("Paranoia2");
		libro.setNumPagina(621);
		libro.setPrecio(20100);
		libro.setAnioPublicacion(1998);
		
		//libroDAO.insertLibro(libro);
		//ejemplarDAO.insertEjemplar(libro);
		//libroDAO.updatePrecioLibro(libro);
		//libroDAO.deleteLibro(libro);
		
		
		System.out.println("Libro Guardado con Exito");
		
		
		
		
		
		
		System.out.println("-------------------------------------------------------------------------------------------------------------");
	
		
		FacturasDAO facturas = new FacturasDAO();
		DetallesFacturasDAO detalleFacturas = new DetallesFacturasDAO();
		ComprasDAO compras = new ComprasDAO();
		DetallesComprasDAO detallesCompras = new DetallesComprasDAO();
		Generador generar = new Generador();
		
		Distribuidor di =  new Distribuidor();
		di.setIdDistribuidor(1);
		
		List<Ejemplar> ejemplares2 = new ArrayList<Ejemplar>();
		List<Libro> libros2 = new ArrayList<Libro>();
		Ejemplar e = new Ejemplar();
		e.setIsbn("9780001849129");
		e.setTitulo("kaka");
		e.setNumSerie(1241);
		ejemplares2.add(e);
		
		Ejemplar ej = new Ejemplar();
		ej.setIsbn("9782266202886");
		ej.setNumSerie(5421);
		ej.setTitulo("LALA");
		ejemplares2.add(ej);
		
		Libro l = new Libro();
		l.setIsbn("9780001849129");
		l.setPrecio(17000);
		libros2.add(l);
		
		Libro li = new Libro();
		li.setIsbn("9782266202886");
		li.setPrecio(12000);
		libros2.add(li);
		
		Factura f = new Factura();
		f.setFolio(2);
		f.setHoraCompra(generar.generarHoraActual());
		f.setFechaCompra(generar.generarFechaActual());
		f.setMetodoPago("Efectivo");
	
		//Compra c = new Compra();
		//c.setIdCompra(1);
	
		//facturas.insertFactura(f);
		//detalleFacturas.insertDetalleFactura(ejemplares2, libros2, f, di);
		//compras.insertCompra(c, f, di);
		//detallesCompras.insertDetalleCompra(ejemplares2, f, c, di);
		//compras.deleteCompra(f);
		
		
		//facturas.deleteFactura(f);
		
		//DistribuidorDAO distribuidor = new DistribuidorDAO();
		
		//Distribuidor d = new Distribuidor();
		//d.setIdDistribuidor(4);
		//d.setRut("69.213.887-2");
		//d.setNombreEmpresa("AmalGaMMABook");
		//d.setAnioVinculo(2021);
		//d.setDireccion("Calle Verdadera #3124 , Viña del Mar");
		//d.setTelefono("+56ooooooee");
		
		//distribuidor.insertDistribuidor(d);
		//distribuidor.deleteDistribuidor(d);
		//distribuidor.updateDistribuidor(d, "+56ooooooee");
		
		
		
		
		
		
		
		
		
		
		/**
		 * List<Ejemplar> ejemplares2 = new EjemplarDAO().getAll();
	
		if(ejemplares2.isEmpty()) {
			System.out.println("HEY! esta vacio!");
		}else {
			
			for(Ejemplar ejemplar : ejemplares2) {
				if(ejemplar.getNumSerie() == 5892) {
					//ejemplarDAO.deleteEjemplar(ejemplar);
				}
			}
			
			
		}
		 */
		
		//ArriendosDAO arriendos = new ArriendosDAO();
		//DetallesArriendosDAO detalles = new DetallesArriendosDAO();
/*
 * 	List<Libro> libros2 = new ArrayList<Libro>();
		List<Ejemplar> ejemplares2 = new ArrayList<Ejemplar>();
		
		Libro l = new Libro();
		l.setIsbn("9780001849129");
		l.setPrecio(17000);
		libros2.add(l);
		Ejemplar e = new Ejemplar();
		e.setIsbn("9780001849129");
		e.setNumSerie(1241);
		ejemplares2.add(e);
		Libro li = new Libro();
		li.setIsbn("9782266202886");
		li.setPrecio(12000);
		libros2.add(li);
		Ejemplar ej = new Ejemplar();
		ej.setIsbn("9782266202886");
		ej.setNumSerie(5421);
		ejemplares2.add(ej);
		
		
		Arriendo arriendo = new Arriendo();
		arriendo.setIdArriendo(12);
		arriendo.setIdCliente(1);
		arriendo.setIdTrabajador(2);
		arriendo.setFechaArriendo("12-08-2019");
		arriendo.setFechaDevolucion("20-09-2019");
		arriendo.setFechaEntrega("-");
		arriendo.setDiasRetraso(0);
		arriendo.setMulta(0);
		arriendo.setCostoTotal(0);
		
		//arriendos.crearArriendo(arriendo, 1, 2);
		
		//detalles.insertDetalleArriendo(arriendo, libros2, ejemplares2, 0);
		
		//arriendos.agregarCostoTotal(detalles, arriendo, arriendos);
		
		//arriendos.deleteArriendo(arriendo);
		
		//arriendos.agregarMulta(arriendo, 12000);
 */
	
		
		
		
		
	}	
}


