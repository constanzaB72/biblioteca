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
import cl.inacap.bibliotecaApp.frames.SelectLibrosJIFrame;
import cl.inacap.bibliotecaModel.dto.Libro;

public class ArriendoController {
	ArriendoFrame arriendoFrame;
	private ArriendoExitoso arriendoExitoso;
	private SelectLibrosJIFrame listalibros;
	private List<Libro> libros;
	
	public ArriendoController() {
		arriendoFrame = new ArriendoFrame();
	}
	class FinalizarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			arriendoFrame.dispose();
			arriendoExitoso.setVisible(false);
			arriendoExitoso.dispose();
		}
	}
	
	}
	

