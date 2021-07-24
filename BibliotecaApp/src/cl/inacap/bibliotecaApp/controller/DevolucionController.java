package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cl.inacap.bibliotecaApp.frames.DevolucionFrame;


public class DevolucionController {
	private DevolucionFrame devolucion;
	
	
	
	
	public DevolucionController() {
		devolucion=new DevolucionFrame();
		devolucion.addAgregarMulta(new MultaListener());
		
	}




	class MultaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	
		}
}
}