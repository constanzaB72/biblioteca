package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import cl.inacap.bibliotecaApp.controller.TrabajadorController.ArrendarListener;
import cl.inacap.bibliotecaApp.frames.CompraFrame;
import cl.inacap.bibliotecaApp.frames.SelectLibrosJIFrame;
import cl.inacap.bibliotecaModel.dao.DistribuidorDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dto.*;

public class CompraController {
	private String rut;
	private String tipoUsuario;
	CompraFrame compraFrame;
	DistribuidorDAO distribuidorDAO= new DistribuidorDAO();
	LibrosDAO librosDAO = new LibrosDAO();
	
	
	public CompraController(String rut, String tipousuario) {
		this.rut=rut;
		this.tipoUsuario=tipousuario;
		compraFrame= new CompraFrame();
		List<Distribuidor> distribuidores =distribuidorDAO.getAll();
		List<Libro> libros = librosDAO.getAll();
		SelectLibrosJIFrame listalibros =new SelectLibrosJIFrame(libros);
		compraFrame.addMenuListener(new MenuListener());
		
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

}
