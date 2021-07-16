package cl.inacap.bibliotecaApp.controller;

import javax.swing.JLabel;

import cl.inacap.bibliotecaApp.frames.TrabajadorFrame;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;
import cl.inacap.bibliotecaModel.dto.Trabajador;

public class TrabajadorController {
	
	private Trabajador trabajador;
	TrabajadorFrame trabajadorFrame;
	
	TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();

	public TrabajadorController(String rut) {
		trabajador = trabajadorDAO.findByRut(rut);
		TrabajadorFrame trabajadorFrame= new TrabajadorFrame(trabajador); 
		trabajadorFrame.setVisible(true);
	}
	
	
}
