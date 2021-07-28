package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import cl.inacap.bibliotecaApp.frames.DevolucionFrame;
import cl.inacap.bibliotecaModel.dao.ArriendosDAO;
import cl.inacap.bibliotecaModel.dao.DetallesArriendosDAO;
import cl.inacap.bibliotecaModel.dto.Arriendo;

/**
 * Clase encargada de trabajara como un controlador del frameDevolucion. La
 * clase se encarga de recibir cualquier evento que ocurra al momento de generar
 * el frame, al recibir esos eventos entran en acciona todas la funciones
 * asociadas a cada evento a ocurrir.
 * 
 * CREADO EL DIA 26-07-2021
 * 
 * 
 * 
 * @author Lorena Perez , Camilo Moya
 *
 */
public class DevolucionController {
	DevolucionFrame devolucion;
	public ArriendosDAO arriendoDAO = new ArriendosDAO();
	public Arriendo arriendoMulta = new Arriendo();
	public DetallesArriendosDAO detalleArriendoDAO = new DetallesArriendosDAO();

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
			

			int multa = 0;
			int pass = 0;

			try {
				multa = Integer.parseInt(devolucion.getTxtMonto().getText());
				pass++;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Ingresa un Monto Valido! SOLO NUMEROS!");
			}

			if (pass >= 1) {
				arriendoDAO.agregarMulta(arriendoMulta, multa);
				arriendoDAO.agregarCostoTotal(detalleArriendoDAO, arriendoMulta, arriendoDAO);
			}

		}
	}

	// TODO cerrar sin cambios
	class CancelarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			devolucion.dispose();
		}
	}
}