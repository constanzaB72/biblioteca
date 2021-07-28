package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import cl.inacap.bibliotecaApp.frames.DevolucionFrame;

public class DevolucionController {
	private DevolucionFrame devolucion;

	public DevolucionController() {
		devolucion = new DevolucionFrame();
		devolucion.addAplicarMulta(new AplicarMultaListener());
		devolucion.addConfirmarAgregar(new ConfirmarListener());
		devolucion.addCancelarAgregar(new CancelarListener());
		devolucion.addBuscarRut(new BuscarRutListener());

	}

	// TODO Multa Listener BotonBuscar por el rut
	class BuscarRutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	// TODO Multa Listener boton aceptar para guardar cambios
	class ConfirmarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}
	}

	// TODO Multa Listener se aplica multa
	class AplicarMultaListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			

		}
	}
	// TODO cerrar sin cambios
		class CancelarListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				devolucion.dispose();
			}
		}
}