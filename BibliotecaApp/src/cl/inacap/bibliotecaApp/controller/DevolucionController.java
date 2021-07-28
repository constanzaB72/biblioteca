package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
	public ArriendosDAO arriendosDAO=new ArriendosDAO();
	public DetallesArriendosDAO detalleArriendoDAO = new DetallesArriendosDAO();
	private List<Arriendo> listaArriendos; 
	private String rut;

	public DevolucionController() {
		devolucion = new DevolucionFrame();
		devolucion.addAplicarMulta(new AplicarMultaListener());
		devolucion.addCancelarAgregar(new CancelarListener());
		devolucion.addBuscarRut(new BuscarRutListener());
		

	}

	// TODO Multa Listener BotonBuscar por el rut
	class BuscarRutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			rut=devolucion.getTxtClienteDevolucion().getText();
			System.out.println("buscar rut devo "+rut);
			if(!rut.isEmpty()) {
				ReloadJTable();
			}else {
				
				  JOptionPane.showMessageDialog(devolucion, "Deve ingresar rut cliente ", "ERROR",
				  JOptionPane.ERROR_MESSAGE);
				  System.out.println("error");
				 
			}

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
				int resp = JOptionPane.showConfirmDialog(devolucion, "¿Confirmar Aplicar multa?");
				if (JOptionPane.OK_OPTION == resp) {
					for (Arriendo arriendoMulta : listaArriendos) {
						arriendoDAO.agregarMulta(arriendoMulta, multa);
						arriendoDAO.agregarCostoTotal(detalleArriendoDAO, arriendoMulta, arriendoDAO);
					}
				}
				devolucion.getTxtMonto().setText("");
			}
			devolucion.getTxtMonto().setText("");	
			listaArriendos = arriendosDAO.getByRutCliente(rut);
			ReloadJTable();
			
			

		}
		
	}

	// TODO cerrar sin cambios
	class CancelarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			devolucion.dispose();
		}
	}
	private void ReloadJTable() {
		System.out.println("buscar rut devo  entra if"+rut);
		listaArriendos = arriendosDAO.getByRutCliente(rut);
		String[] columnNames = { "Id Arriendo", "Fecha de Arriendo", "Fecha de Entrega", "Dias de Retraso", "Multa",
		"Costo total" };
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		if (listaArriendos != null && !listaArriendos.isEmpty()) {
			for (int fila = 0; fila < listaArriendos.size(); fila++) {
				Object[] columna = new Object[] { listaArriendos.get(fila).getIdArriendo(),
						listaArriendos.get(fila).getFechaArriendo(), listaArriendos.get(fila).getFechaEntrega(),
						listaArriendos.get(fila).getDiasRetraso(), listaArriendos.get(fila).getMulta(),
						listaArriendos.get(fila).getCostoTotal() };
				model.addRow(columna);
				
			}
			devolucion.getTable().setModel(model);

		}
	}
}