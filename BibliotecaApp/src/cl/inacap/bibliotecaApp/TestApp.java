package cl.inacap.bibliotecaApp;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dao.BoletasDAO;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.ComprasDAO;
import cl.inacap.bibliotecaModel.dao.DetallesBoletasDAO;
import cl.inacap.bibliotecaModel.dao.DetallesComprasDAO;
import cl.inacap.bibliotecaModel.dao.DetallesFacturasDAO;

import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.FacturasDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dao.VentasDAO;
import cl.inacap.bibliotecaModel.dto.Boleta;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.DetalleBoleta;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Ejemplar;
import cl.inacap.bibliotecaModel.dto.Factura;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.DB;
import cl.inacap.bibliotecaModel.utils.Generador;




public class TestApp {

	public static void main(String[] args) {
		
		System.out.println("Hola Bienvenido a Nuestra Biblioteca!");
		
		// ------  CARGA Y PROPAGACION DE ERRORES ENTRE CAPAS ------
		
		List<String> erroresLibros = new LibrosDAO().erroresLibrosDAO;
		
		
		
		
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
		
		List<String> telefonos = new ArrayList<String>();
		List<String> correos = new ArrayList<String>();
		List<String> direcciones = new ArrayList<String>();
		
		List<String> autores = new ArrayList<String>();
		List<String> idiomas = new ArrayList<String>();
		List<String> categorias = new ArrayList<String>();
		
		telefonos.add("+56923876188");
		telefonos.add("+56922897631");
		correos.add("Pupu@Gmail.com");
		correos.add("Gustavito@Hotmail.com");
		correos.add("PerezGustavo@Outloock.com");
		direcciones.add("Calle SemiFalsa #123,  Villa Alemana");
		
		autores.add("Pedro Pascal");
		autores.add("Ruben Brito");
		
		//ClientesDAO clientes = new ClientesDAO();
		Cliente c = new Cliente();
		c.setIdCliente(2);
		c.setRut("19.872.716-9");
		c.setNombre("Gustavo");
		c.setApellidoMa("Rutia");
		c.setApellidoPa("Perez");
		c.setFechaNacimiento("28-03-1999");
		c.setPassword("1234567");
		
		//clientes.insertCliente(c, telefonos, correos, direcciones);
		//clientes.deleteCliente(c);
		
		
		//TrabajadoresDAO trabajadores = new TrabajadoresDAO();
		//Trabajador t = new Trabajador();
		//t.setIdTrabajador(3);
		//t.setRut("19.872.716-9");
		//t.setNombre("Gustavo");
		//t.setApellidoMa("Rutia");
		//t.setApellidoPa("Perez");
		//t.setFechaContrato("28-03-1999");
		//t.setPassword("1234567");
		
		//trabajadores.insertTrabajador(t, telefonos, correos, direcciones);
		//trabajadores.deleteTrabajador(t);
		
		
		List<Cliente> clientes2 = new ClientesDAO().getAll();
		
		if(clientes2.isEmpty()) {
			System.out.println("La lista esta vacia!");
		}else {
			
			for(Cliente cliente : clientes2) {
				System.out.println(cliente);
			}
			
		}
		
		LibrosDAO libroDAO = new LibrosDAO();
		EjemplarDAO ejemplarDAO = new EjemplarDAO();
		
		Libro libro = new Libro();
		libro.setIsbn("9784166202199");
		libro.setTitulo("Paranoia1");
		libro.setNumPagina(621);
		libro.setPrecio(20100);
		libro.setAnioPublicacion(1998);
		
		//libroDAO.insertLibro(libro, idiomas, autores, categorias);
		//ejemplarDAO.insertEjemplar(libro);
		//libroDAO.updatePrecioLibro(libro);
		//libroDAO.deleteLibro(libro);
		
	//REVISAR ERROR SE DUPLICA CUANDO ESTOY EN EL LOOP 
		
	/**
	 * try {
		db.conectar();
		for(String autor : autores) {
			String query = "SELECT idAutor, Nombre, ApellidoPa, ApellidoMa FROM BibliotecaV2.Autores";
			PreparedStatement s = db.getCon().prepareStatement(query);
			ResultSet rs = s.executeQuery();
			
			int exist = 0;
			while(rs.next()) {
				if(autor == rs.getString(2)) {
					System.out.println("Autor Registrado");
					exist++;
				}
				
			}
			
			if(exist == 0) {
				String query2 = "INSERT INTO Autores(Nombre) VALUES(?)";
				PreparedStatement p = db.getCon().prepareStatement(query2);
				p.setString(1, autor);
				p.executeUpdate();
				
				
				//PREGUNTAR Y GUARDAMOS LOS PARAMETROS EN LA TABLA LIBRO_AUTOR
				int idAutor = 0;
				String query1 = "SELECT idAutor, Nombre FROM Autores WHERE Nombre =?";
				PreparedStatement so = db.getCon().prepareStatement(query1);
				so.setString(1, autor);
				ResultSet r = so.executeQuery();
				while(r.next()) {
					idAutor = r.getInt(1);
				}
				
				String query3 = "INSERT INTO Libro_Autor(ISBN, idAutor) VALUES(?,?)";
				PreparedStatement t = db.getCon().prepareStatement(query3);
				t.setString(1, libro.getIsbn());
				t.setInt(2, idAutor);
				t.executeUpdate();
			}
			
			
		}
		
	 * 
	 * 
	 * 	
	 */

		

		System.out.println("-------------------------------------------------------------------------------------------------------------");
	
		
		//FacturasDAO facturas = new FacturasDAO();
		//DetallesFacturasDAO detalleFacturas = new DetallesFacturasDAO();
		//ComprasDAO compras = new ComprasDAO();
		//DetallesComprasDAO detallesCompras = new DetallesComprasDAO();
		//DetallesBoletasDAO detallesBoleta = new DetallesBoletasDAO();
		//BoletasDAO boleta = new BoletasDAO();
		//VentasDAO venta = new VentasDAO();
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
		
		//Boleta b = new Boleta();
		//b.setFolio(generar.generarFolioBoleta());
		//b.setFechaVenta(generar.generarFechaActual());
		//b.setHoraVenta(generar.generarHoraActual());
		//b.setIdCliente(c.getIdCliente());
		//b.setIdTrabajador(t.getIdTrabajador());
		//b.setMetodoPago("Tarjeta");
		
		//venta.deleteVenta(b);
		//boleta.insertBoleta(b, c, t);
		//boleta.deleteBoleta(b);
		//detallesBoleta.insertDetalles(ejemplares2, libros2, b);
		//venta.insertVenta(b, c, t);
		
		//
		
		
		
		
		
		//Factura f = new Factura();
		//f.setFolio(2);
		//f.setHoraCompra(generar.generarHoraActual());
		//f.setFechaCompra(generar.generarFechaActual());
		//f.setMetodoPago("Efectivo");
	
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


