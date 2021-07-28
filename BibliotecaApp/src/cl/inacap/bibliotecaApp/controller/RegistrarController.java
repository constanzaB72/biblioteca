package cl.inacap.bibliotecaApp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import cl.inacap.bibliotecaApp.frames.RegistrarFrame;

public class RegistrarController {

	private RegistrarFrame registrarFrame;

	public RegistrarController() {
		registrarFrame = new RegistrarFrame(); 
		registrarFrame.addConfirmaRegistrar(new RegistrarListener());
		registrarFrame.addAgregarDireccion(new DireccionListener());
		registrarFrame.addAgregarCorreos(new CorreosListener());
		registrarFrame.addAgregarTelefonos(new TelefonosListener());
	}

	class RegistrarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			

		}

	}
	
	class DireccionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel<String> DireccionModel = (DefaultListModel<String>)registrarFrame.getListaDireccion().getModel();
			DireccionModel.addElement(registrarFrame.getTxtDireccionRegistrar().getText());
			registrarFrame.getListaDireccion().setModel(DireccionModel);

		}

	}
	
	class CorreosListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel<String> correoModel = (DefaultListModel<String>)registrarFrame.getListaCorreos().getModel();
			correoModel.addElement(registrarFrame.getTxtDireccionRegistrar().getText());
			registrarFrame.getListaDireccion().setModel(correoModel);

		}

	}
	
	class TelefonosListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			DefaultListModel<String> telefonoModel = (DefaultListModel<String>)registrarFrame.getListaTelefonos().getModel();
			telefonoModel.addElement(registrarFrame.getTxtDireccionRegistrar().getText());
			registrarFrame.getListaDireccion().setModel(telefonoModel);

		}

	}
}
