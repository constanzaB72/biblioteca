package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cl.inacap.bibliotecaApp.frames.CompraExitosa;
import cl.inacap.bibliotecaApp.frames.CompraFrame;
import cl.inacap.bibliotecaApp.frames.SelectLibrosJIFrame;
import cl.inacap.bibliotecaModel.dao.ComprasDAO;
import cl.inacap.bibliotecaModel.dao.DetallesComprasDAO;
import cl.inacap.bibliotecaModel.dao.DetallesFacturasDAO;
import cl.inacap.bibliotecaModel.dao.DistribuidorDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.FacturasDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dto.*;
import cl.inacap.bibliotecaModel.utils.Generador;

public class CompraController {
	private String rut;
	private String tipoUsuario;
	private CompraFrame compraFrame;
	private CompraExitosa compraExitosa; 
	private DistribuidorDAO distribuidorDAO= new DistribuidorDAO();
	private LibrosDAO librosDAO = new LibrosDAO();
	private FacturasDAO facturasDAO =new FacturasDAO();
	private ComprasDAO compraDAO = new ComprasDAO();
	private DetallesComprasDAO  detallesComprasDAO =new DetallesComprasDAO();
	private DetallesFacturasDAO detallesFacturasDAO = new DetallesFacturasDAO();
	private LibrosDAO libroDao=new LibrosDAO();
	private EjemplarDAO ejemplarDAO=new EjemplarDAO();
	private List<Libro> libros;
	private SelectLibrosJIFrame listalibros;
	private Generador generador =new Generador();
	
	
	public CompraController(String rut, String tipousuario) {
		this.rut=rut;
		this.tipoUsuario=tipousuario;
		compraFrame= new CompraFrame();
		List<Distribuidor> distribuidores =distribuidorDAO.getAll();
		libros = librosDAO.getAll();
		
		compraFrame.addMenuListener(new MenuListener());
		compraFrame.addSelectListener(new SelectListener());
		compraFrame.addCompraListener(new CompraListener());
		for(Distribuidor distribuidor:distribuidores) {
			compraFrame.getCbxDistribuidor().addItem(distribuidor.getIdDistribuidor()+"-"+distribuidor.getNombreEmpresa());
		}
		compraFrame.repaint();			
	}
	
	class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TrabajadorController trabajador = new TrabajadorController(rut);
			compraFrame.dispose();
		}
	}
	//Guardar Compra
	//TODO automatizar folio factura
	class CompraListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			
			Factura factura =new Factura();
			factura.setFolio(generador.generarFolioFactura());
			factura.setFechaCompra(String.valueOf(generador.generarFechaActual()));
			factura.setMetodoPago(String.valueOf(compraFrame.getCbxMetodoPago().getSelectedItem()));
			factura.setHoraCompra(String.valueOf(generador.generarHoraActual()));
			Distribuidor distribuidor = new Distribuidor();
			String[] dist = String.valueOf(compraFrame.getCbxDistribuidor().getSelectedItem()).split("-");
			distribuidor.setIdDistribuidor(Integer.parseInt(dist[0]));
			distribuidor.setNombreEmpresa(dist[1]);
			facturasDAO.insertFactura(factura);
			int idCompra = compraDAO.insertCompra(factura, distribuidor);
			Compra compra=new Compra();
			compra.setIdCompra(idCompra);
			
			int cantidadFilas= compraFrame.getTableLibros().getModel().getRowCount();
			System.out.println("cantidad de filas encontrado"+cantidadFilas);
			List<Ejemplar> ejemplares=new ArrayList<Ejemplar>();
			List<Libro> libros=new ArrayList<Libro>();
			for(int i=0;i<cantidadFilas;i++) {
				System.out.println("entra for " +i);
				Libro libro = new Libro();
				libro.setIsbn(String.valueOf(compraFrame.getTableLibros().getModel().getValueAt(i, 0)));
				libro.setPrecio((Integer)(compraFrame.getTableLibros().getModel().getValueAt(i, 2)));
				libro.setTitulo(String.valueOf(compraFrame.getTableLibros().getModel().getValueAt(i, 1)));
				int cont=0;
				do {
					System.out.println("entra DO "+cont);
					Ejemplar ejemplar =new Ejemplar();
					
					ejemplar.setNumSerie(ejemplarDAO.insertEjemplar(libro));
					System.out.println("numserie "+ejemplar.getNumSerie());
					ejemplar.setTitulo(String.valueOf(compraFrame.getTableLibros().getModel().getValueAt(i, 1)));
					ejemplar.setIsbn(libro.getIsbn());
					ejemplares.add(ejemplar);
					cont++;
				//TODO modificar cuando se capture cantidad de libros
				}while(cont<1);
				//}while(cont<(Integer)(compraFrame.getTableLibros().getModel().getValueAt(i, 3)));
				
			
				libros.add(libro);
			}
			detallesComprasDAO.insertDetalleCompra(ejemplares, factura, compra, distribuidor);
			detallesFacturasDAO.insertDetalleFactura(ejemplares, libros, factura, distribuidor);
			compraExitosa =new CompraExitosa();
			compraExitosa.setVisible(true);
			compraExitosa.addFinalizarListener(new FinalizarListener());
			
			
			
			
		}
	}
	
	class FinalizarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			compraFrame.dispose();
			compraExitosa.setVisible(false);
			TrabajadorController trabajador = new TrabajadorController(rut);
			compraExitosa.dispose();
		}
	}
	class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			listalibros =new SelectLibrosJIFrame(libros);
			listalibros.addConfirmarAgregar(new AgregarListener());
			listalibros.addCancelarAgregar(new CancelarAgregarListener());
		}
	}
	//TODO falta agrega la cantidad de libros
	class AgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel aux=(DefaultTableModel)listalibros.getTable2().getModel();
			compraFrame.getTableLibros().setModel(aux);
			compraFrame.getTableLibros().removeColumn(compraFrame.getTableLibros().getColumnModel().getColumn(4));
			Integer suma=0;
			for(int fila=0;fila<aux.getRowCount();fila++) {
				suma=suma+((Integer) aux.getValueAt(fila, 2)/* */);				
			}
			compraFrame.getTxtCosto().setText("$"+String.valueOf(suma));
			listalibros.dispose();
			
		}
	}
	class CancelarAgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			listalibros.dispose();
			
		}
	}
	
	

}
