package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cl.inacap.bibliotecaApp.frames.VentaFrame;

public class VentaController {
	VentaFrame ventaFrame;
	private String rut;
	private String tipoUsuario;
	
	public VentaController(String rut, String tipoUsuario) {
		this.rut=rut;
		this.tipoUsuario=tipoUsuario;
		ventaFrame = new VentaFrame();
		ventaFrame.addMenuListener(new MenuListener());
	}
	class MenuListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(tipoUsuario.equals("trabajador")) {
				TrabajadorController trabajador = new TrabajadorController(rut);
			}else {
				ClienteController cliente = new ClienteController(rut);
			}
			ventaFrame.dispose();
		}
	}
	
}