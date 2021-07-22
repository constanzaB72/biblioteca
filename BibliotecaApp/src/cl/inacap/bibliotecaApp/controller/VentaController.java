package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cl.inacap.bibliotecaApp.controller.CompraController.AgregarListener;
import cl.inacap.bibliotecaApp.controller.CompraController.CancelarAgregarListener;
import cl.inacap.bibliotecaApp.controller.CompraController.CompraListener;
import cl.inacap.bibliotecaApp.controller.CompraController.SelectListener;
import cl.inacap.bibliotecaApp.frames.SelectLibrosJIFrame;
import cl.inacap.bibliotecaApp.frames.VentaExitosa;
import cl.inacap.bibliotecaApp.frames.VentaFrame;
import cl.inacap.bibliotecaModel.dao.DistribuidorDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dto.Distribuidor;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.utils.Generador;

public class VentaController {
	private VentaFrame ventaFrame;
	private String rut;
	private String tipoUsuario;
	private VentaExitosa ventaExitosa;
	private DistribuidorDAO distribuidorDAO= new DistribuidorDAO();
	private LibrosDAO librosDAO = new LibrosDAO();
	private List<Libro> libros;
	private SelectLibrosJIFrame listalibros;
	private LibrosDAO libroDao=new LibrosDAO();
	private EjemplarDAO ejemplarDAO=new EjemplarDAO();
	private Generador generador =new Generador();
	
	public VentaController(String rut, String tipoUsuario) {
		this.rut=rut;
		this.tipoUsuario=tipoUsuario;
		ventaFrame = new VentaFrame();
		List<Distribuidor> distribuidores = distribuidorDAO.getAll();
		libros = librosDAO.getAll();
		
		ventaFrame.addMenuListener(new MenuListener());
		ventaFrame.addSelectListener(new SelectListener());
		ventaFrame.repaint();
	}
	class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TrabajadorController trabajador = new TrabajadorController(rut);
			ventaFrame.dispose();
		}
	}
	//class ventaListener
	class FinalizarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ventaFrame.dispose();
			ventaExitosa.setVisible(false);
			ventaExitosa.dispose();
		}
	}
	class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			listalibros =new SelectLibrosJIFrame(libros);
			listalibros.addConfirmarAgregar(new AgregarListener());
			listalibros.addCancelarAgregar(new CancelarAgregarListener());
	}
	}
	class AgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel aux=(DefaultTableModel)listalibros.getTable2().getModel();
			ventaFrame.getTableLibros().setModel(aux);
			ventaFrame.getTableLibros().removeColumn(ventaFrame.getTableLibros().getColumnModel().getColumn(4));
			Integer suma=0;
			for(int fila=0;fila<aux.getRowCount();fila++) {
				suma=suma+((Integer) aux.getValueAt(fila, 2)/* */);				
			}
			ventaFrame.getTxtCosto().setText("$"+String.valueOf(suma));
			listalibros.dispose();
			
		}
	}
	class CancelarAgregarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			listalibros.dispose();
			
		}
	}
	
}