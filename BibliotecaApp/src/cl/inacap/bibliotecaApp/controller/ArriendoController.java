package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import cl.inacap.bibliotecaApp.controller.CompraController.AgregarListener;
import cl.inacap.bibliotecaApp.controller.CompraController.CancelarAgregarListener;
import cl.inacap.bibliotecaApp.frames.ArriendoExitoso;
import cl.inacap.bibliotecaApp.frames.ArriendoFrame;
import cl.inacap.bibliotecaApp.frames.CompraExitosa;
import cl.inacap.bibliotecaApp.frames.SelectEjemplarFrame;
import cl.inacap.bibliotecaApp.frames.SelectLibrosJIFrame;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;
import cl.inacap.bibliotecaModel.dto.Libro;
import cl.inacap.bibliotecaModel.dto.Trabajador;

public class ArriendoController {
	ArriendoFrame arriendoFrame;
	private ArriendoExitoso arriendoExitoso;
	private SelectLibrosJIFrame listalibros;
	private Trabajador trabajador;
	// DAO
	private LibrosDAO librosDAO = new LibrosDAO();
	private LibrosDAO libroDao = new LibrosDAO();
	private EjemplarDAO ejemplarDAO = new EjemplarDAO();
	private ClientesDAO clienteDao = new ClientesDAO();
	private TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();

	private List<Libro> libros;
	
	public ArriendoController(String rut, String tipoUsuario) {
		arriendoFrame = new ArriendoFrame();
		if(tipoUsuario.equals("cliente")) {
			arriendoFrame.getTxtClienteArriendo().setText(rut);
			arriendoFrame.getTxtClienteArriendo().setEditable(false);
			trabajador = trabajadorDAO.findByRut("20.127.772-9");
		}else {
			trabajador =trabajadorDAO.findByRut(rut);
		}
	}
	class FinalizarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			arriendoFrame.dispose();
			arriendoExitoso.setVisible(false);
			arriendoExitoso.dispose();
		}
	}
	class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		}
	}
//	class MenuListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			if(tipoUsuario.equals("cliente")) {
//				ClienteController cliente = new ClienteController(rut);
//			}else {
//				TrabajadorController trabajador = new TrabajadorController(rut);
//			}
//			ventaFrame.dispose();
//		}
//	}
//	class FinalizarListener implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			arriendoFrame.dispose();
//			arriendoExitoso.setVisible(false);
//			arriendoExitoso.dispose();
//		}
//	}
//	
}

