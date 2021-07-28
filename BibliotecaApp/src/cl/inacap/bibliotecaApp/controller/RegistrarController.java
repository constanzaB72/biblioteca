package cl.inacap.bibliotecaApp.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

import cl.inacap.bibliotecaApp.frames.RegistrarFrame;
import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;
import cl.inacap.bibliotecaModel.dto.Cliente;
import cl.inacap.bibliotecaModel.dto.Trabajador;
import cl.inacap.bibliotecaModel.utils.Generador;

public class RegistrarController {

	private RegistrarFrame registrarFrame;
	private Generador generador =new Generador();
	private TrabajadoresDAO trabajadoresDAO=new TrabajadoresDAO();
	private ClientesDAO clientesDAO = new ClientesDAO();
	public RegistrarController() {
		registrarFrame = new RegistrarFrame(); 
		registrarFrame.setVisible(true);
		registrarFrame.addConfirmaRegistrar(new RegistrarListener());
		registrarFrame.addAgregarDireccion(new DireccionListener());
		registrarFrame.addAgregarCorreos(new CorreosListener());
		registrarFrame.addAgregarTelefonos(new TelefonosListener());
	}

	class RegistrarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nombre = registrarFrame.getTxtNombreIngresar().getText();
			String apellidoP = registrarFrame.getTxtApellidoPaRegistrar().getText();
			String apellidoM =registrarFrame.getTxtApellidoMaRegistrar().getText();
			String rut =registrarFrame.getTxtRutRegistrar().getText();
			String fechaNac = registrarFrame.getTxtNacimientoRegistrar().getText();
			String password="123";
			List<String> correos = traerLista((DefaultListModel<String>) registrarFrame.getListaCorreos().getModel());
			List<String> telefonos = traerLista((DefaultListModel<String>) registrarFrame.getListaTelefonos().getModel());
			List<String> Direcciones = traerLista((DefaultListModel<String>) registrarFrame.getListaDireccion().getModel());
			List<String> errores=new ArrayList<String>();
			if(nombre.isEmpty()) {
				errores.add("Debe ingresar nombre");
			}if(apellidoP.isEmpty()) {
				errores.add("Debe ingresar apellido paterno");
			}
			/*
			 * private RutUtils rutUtils=new RutUtils();
			 * 
			 * String valido =
			 * rutUtils.validarRut(registrarFrame.getTxtRutRegistrar().getText()); if
			 * (valido.equals("Valido")) {
			 * 
			 * 
			 * }
			 */
			
			if(registrarFrame.getRdbtnTrabajador().isSelected()) {
				System.out.println("entraif registrar");
				Trabajador trabajador=new Trabajador();
				trabajador.setNombre(nombre);
				trabajador.setApellidoPa(apellidoP);
				trabajador.setApellidoMa(apellidoM);
				trabajador.setRut(rut);
				trabajador.setFechaContrato(generador.generarFechaActual());
				trabajador.setPassword(password);
				trabajadoresDAO.insertTrabajador(trabajador, telefonos, correos, Direcciones);				
			}else {
				System.out.println("entra else registrar");
				Cliente cliente = new Cliente();
				cliente.setRut(rut);
				cliente.setNombre(nombre);
				cliente.setApellidoPa(apellidoP);
				cliente.setApellidoMa(apellidoM);
				cliente.setFechaNacimiento(fechaNac);
				cliente.setPassword(password);
				clientesDAO.insertCliente(cliente, telefonos, correos, Direcciones);
				
				
			}
			

		}

	}
	
	class DireccionListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			DefaultListModel<String> DireccionModel = (DefaultListModel<String>)registrarFrame.getListaDireccion().getModel();
			DireccionModel.addElement(registrarFrame.getTxtDireccionRegistrar().getText());
			registrarFrame.getListaDireccion().setModel(DireccionModel);
			registrarFrame.getTxtDireccionRegistrar().setText("");
			registrarFrame.getListaDireccion().repaint();

		}

	}
	
	class CorreosListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("entra correo");
			DefaultListModel<String> correoModel = (DefaultListModel<String>)registrarFrame.getListaCorreos().getModel();
			correoModel.addElement(registrarFrame.getTxtCorreoRegistrar().getText());
			registrarFrame.getListaCorreos().setModel(correoModel);
			registrarFrame.getTxtCorreoRegistrar().setText("");
			System.out.println("entra correo fin");

		}

	}
	
	class TelefonosListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel<String> telefonoModel = (DefaultListModel<String>)registrarFrame.getListaTelefonos().getModel();
			telefonoModel.addElement(registrarFrame.getTxtTelefonoRegistrar().getText());
			registrarFrame.getListaTelefonos().setModel(telefonoModel);
			registrarFrame.getTxtTelefonoRegistrar().setText("");

		}

	}
	
	private List<String> traerLista(DefaultListModel<String> lista){
		List<String> listaString = new ArrayList<String>();
		for(int i = 0; i< lista.getSize();i++){
			listaString.add(lista.getElementAt(i));
        }		
		return listaString;
	}
}
